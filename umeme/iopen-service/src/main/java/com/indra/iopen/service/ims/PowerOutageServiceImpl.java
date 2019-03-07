package com.indra.iopen.service.ims;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;import java.util.Objects;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.indra.iopen.form.PowerOutageFilter;
import com.indra.iopen.form.ims.PowerOutage;
import com.indra.iopen.model.ims.GiFeeder;
import com.indra.iopen.model.ims.SgdCentro;
import com.indra.iopen.model.ims.SgdIncidencia;
import com.indra.iopen.model.ims.SgdInstalacion;
import com.indra.iopen.model.ims.SgdValor;
import com.indra.iopen.pojo.IncidentLocation;
import com.indra.iopen.pojo.PowerOutageIncidentInfo;
import com.indra.iopen.pojo.PowerOutageInstallationInfo;
import com.indra.iopen.repositories.model.MunicipioRepository;
import com.indra.iopen.repositories.model.SgdInstalacionRepository;
import com.indra.iopen.repositories.model.ims.GiFeederRepository;
import com.indra.iopen.repositories.model.ims.SgdAcometidaRepository;
import com.indra.iopen.repositories.model.ims.SgdCentroRepository;
import com.indra.iopen.repositories.model.ims.SgdIncidenciaRepository;
import com.indra.iopen.repositories.model.ims.SgdValorRepository;
import com.indra.iopen.service.CommonService;

@Service
public class PowerOutageServiceImpl implements PowerOutageService {
	@Autowired
	private SgdIncidenciaRepository sgdIncidenciaRepository;
	@Autowired
	private SgdInstalacionRepository sgdInstalacionRepository;
	@Autowired
	private SgdCentroRepository sgdCentroRepository;
	@Autowired
	private SgdValorRepository sgdValorRepository;
	@Autowired
	private CommonService commonService;
	@Autowired
	private SgdAcometidaRepository sgdAcometidaRepository;
	@Autowired
	private MunicipioRepository municipioRepository;
	@Autowired
	private GiFeederRepository giFeederRepository;
	@Autowired
	private Environment env;
	private PowerOutageFilter powerOutageFilter = null;

	@Override
	public PowerOutageFilter getPowerOutageFilter() {
		return powerOutageFilter;
	}

	@Override
	public List<PowerOutage> getPowerOutages(PowerOutageFilter powerOutageFilter) throws Exception {
		int page = powerOutageFilter.getPage();
		if (page > 0) {
			page = powerOutageFilter.getPage() - 1;
		}
		int recordsPerPage = powerOutageFilter.getBatch();
		List<PowerOutage> powerOutages = new ArrayList<>();
		List<IncidentLocation> incidentLocations = null;
		List<BigDecimal> powerOutageTypes = new ArrayList<>();
		if (powerOutageFilter.getOutageType() == Integer
				.valueOf(env.getProperty("application.poweroutage.planned.value"))) {
			powerOutageTypes.add(
					new BigDecimal(env.getProperty("application.sgdIncidencia.tipincidencia.planned.outage.value")));
		} else if (powerOutageFilter.getOutageType() == Integer
				.valueOf(env.getProperty("application.poweroutage.unplanned.value"))) {
			powerOutageTypes.add(
					new BigDecimal(env.getProperty("application.sgdIncidencia.tipincidencia.unplanned.outage.value")));
		} else if (powerOutageFilter.getOutageType() == Integer
				.valueOf(env.getProperty("application.poweroutage.all.value"))) {
			powerOutageTypes.add(
					new BigDecimal(env.getProperty("application.sgdIncidencia.tipincidencia.planned.outage.value")));
			powerOutageTypes.add(
					new BigDecimal(env.getProperty("application.sgdIncidencia.tipincidencia.unplanned.outage.value")));

		} else {
			// does not exist for now
		}
		List<SgdValor> statuses = getPowerOutageStatuses();
		Map<BigDecimal, String> statusMap = statuses.parallelStream().filter(Objects::nonNull)
				.collect(Collectors.toMap(SgdValor::getCodigo, SgdValor::getDescripcion));
		List<BigDecimal> statusList = new ArrayList<>();
		BigDecimal allCode = new BigDecimal(env.getProperty("application.poweroutage.status.all.value"));
		if (powerOutageFilter.getStatus() != null && powerOutageFilter.getStatus().equals(allCode)) {
			statusList
					.addAll(statuses
							.parallelStream().filter(
									filter -> filter != null
											&& !filter.getCodigo()
													.equals(new BigDecimal(env.getProperty(
															"application.sgdIncidencia.closed.estactual.value")))
							&& !filter.getCodigo()
									.equals(new BigDecimal(
											env.getProperty("application.poweroutage.status.all.value"))))
					.map(map -> map.getCodigo()).collect(Collectors.toList()));
		} else {
			statusList.add(powerOutageFilter.getStatus());
		}
		List<BigDecimal> districtList = new ArrayList<>();
		if (powerOutageFilter.getDistrict() != null && powerOutageFilter.getDistrict()
				.equals(new BigDecimal(env.getProperty("application.poweroutage.district.all.value")))) {
			districtList.addAll(sgdCentroRepository
					.findSgdCentroByIdTipCentro(
							Long.valueOf(env.getProperty("application.sgdcentro.tipcentro.district.value")))
					.parallelStream().map(map -> new BigDecimal(map.getId().getNroCentro()))
					.collect(Collectors.toList()));
		} else {
			districtList.add(powerOutageFilter.getDistrict());
		}

		incidentLocations = sgdIncidenciaRepository.findFeederIncidences(powerOutageTypes, statusList, districtList,
				new SimpleDateFormat("dd/MM/yyyy").parse(powerOutageFilter.getStartDateString()),
				new SimpleDateFormat("dd/MM/yyyy").parse(powerOutageFilter.getEndDateString()),
				new PageRequest(page, recordsPerPage));
		long totalPages = sgdIncidenciaRepository.findCountFeederIncidences(powerOutageTypes, statusList, districtList,
				new SimpleDateFormat("dd/MM/yyyy").parse(powerOutageFilter.getStartDateString()),
				new SimpleDateFormat("dd/MM/yyyy").parse(powerOutageFilter.getEndDateString()));
		if (powerOutageFilter.getNoOfPages() == 0) {
			powerOutageFilter.setNoOfPages((int) Math.ceil((double) (int) totalPages / recordsPerPage));
		}
		// map sub stations and Feeder
		List<GiFeeder> sgdInstalacionsSubStationsFeeders = (List<GiFeeder>) giFeederRepository.findAll();
		// feeder
		Map<Long, String> feederMap = sgdInstalacionsSubStationsFeeders.parallelStream()
				.filter(Objects::nonNull).collect(Collectors.toMap(GiFeeder::getCodigo, GiFeeder::getFeeder));
		// substation
		Map<Long, String> substationMap = sgdInstalacionsSubStationsFeeders.parallelStream()
				.filter(Objects::nonNull)
				.collect(Collectors.toMap(GiFeeder::getCodigo, GiFeeder::getSubstation));

		// map districts
		List<SgdCentro> districts = sgdCentroRepository.findSgdCentroByIdTipCentro(
				Long.valueOf(env.getProperty("application.sgdcentro.tipcentro.district.value")));
		Map<Long, String> districtMap = new HashMap<>();
		districts.parallelStream().filter(Objects::nonNull).forEach((district) -> {
			districtMap.put(district.getId().getNroCentro(), district.getNomCentro());
		});

		// map regions
		List<SgdCentro> regions = sgdCentroRepository.findSgdCentroByIdTipCentro(
				Long.valueOf(env.getProperty("application.sgdcentro.tipcentro.region.value")));
		Map<Long, String> regionMap = new HashMap<>();
		regions.parallelStream().filter(Objects::nonNull).forEach((region) -> {
			regionMap.put(region.getId().getNroCentro(), region.getNomCentro());
		});

		// map scope
		List<SgdValor> sgdValors = commonService.getScopes();
		Map<BigDecimal, String> scopes = sgdValors.parallelStream().filter(Objects::nonNull)
				.collect(Collectors.toMap(SgdValor::getCodigo, SgdValor::getDescripcion));
		this.powerOutageFilter = powerOutageFilter;
		incidentLocations.parallelStream().filter(Objects::nonNull).forEach((incidentLocation) -> {

			PowerOutage powerOutage = new PowerOutage();
			PowerOutageIncidentInfo powerOutageIncidentInfo = new PowerOutageIncidentInfo();
			PowerOutageInstallationInfo powerOutageInstallationInfo = new PowerOutageInstallationInfo();
			powerOutageIncidentInfo.setStatus(statusMap.get(incidentLocation.getSgdIncidencia().getEstActual()));
			powerOutageIncidentInfo.setComment(incidentLocation.getSgdIncidencia().getDescIncidencia());
			powerOutageIncidentInfo.setPlannedDate(
					new SimpleDateFormat("yyyy/MM/dd").format(incidentLocation.getSgdIncidencia().getFDeteccion()));

			powerOutageIncidentInfo.setPlannedDay(
					new SimpleDateFormat("EE").format(incidentLocation.getSgdIncidencia().getFDeteccion()));
			// TODO wait for Brian to give more info
			powerOutage.setRegion(regionMap.get(incidentLocation.getSgdIncidencia().getNroCentro().longValue()));
			powerOutage.setScope(scopes.get(incidentLocation.getSgdIncidencia().getAlcance()));
			powerOutage.setVoltage(String.valueOf(incidentLocation.getSgdInstalacion().getTension()));
			powerOutage.setIncidentId(incidentLocation.getSgdIncidencia().getNroIncidencia());
			powerOutageInstallationInfo
					.setDistrict(districtMap.get(incidentLocation.getSgdIncidencia().getNroMesa().longValue()));
			if (incidentLocation.getSgdIncidencia().getFeeder() != null) {
				powerOutageInstallationInfo
						.setFeeder(feederMap.get(incidentLocation.getSgdIncidencia().getFeeder().longValue()));
				powerOutageInstallationInfo
						.setSubstation(substationMap.get(incidentLocation.getSgdIncidencia().getFeeder().longValue()));
			}
			powerOutage.setPowerOutageIncidentInfo(powerOutageIncidentInfo);
			powerOutage.setPowerOutageInstallationInfo(powerOutageInstallationInfo);
			powerOutage.setOutageType(incidentLocation.getSgdIncidencia().getTipIncidencia().intValue());
			powerOutages.add(powerOutage);
		});
		return powerOutages;
	}

	@Override
	public PowerOutage getPowerOutage(long nroIncidencia) {

		List<SgdValor> statuses = getPowerOutageStatuses();
		Map<BigDecimal, String> statusMap = statuses.parallelStream().filter(Objects::nonNull)
				.collect(Collectors.toMap(SgdValor::getCodigo, SgdValor::getDescripcion));

		// map sub stations and Feeder
		List<GiFeeder> sgdInstalacionsSubStationsFeeders = (List<GiFeeder>) giFeederRepository.findAll();
		// feeder
		Map<Long, String> feederMap = sgdInstalacionsSubStationsFeeders.parallelStream()
				.filter(Objects::nonNull).collect(Collectors.toMap(GiFeeder::getCodigo, GiFeeder::getFeeder));
		// substation
		Map<Long, String> substationMap = sgdInstalacionsSubStationsFeeders.parallelStream()
				.filter(Objects::nonNull)
				.collect(Collectors.toMap(GiFeeder::getCodigo, GiFeeder::getSubstation));

		// map districts
		List<SgdCentro> districts = sgdCentroRepository.findSgdCentroByIdTipCentro(
				Long.valueOf(env.getProperty("application.sgdcentro.tipcentro.district.value")));
		Map<Long, String> districtMap = new HashMap<>();
		districts.parallelStream().filter(Objects::nonNull).forEach((district) -> {
			districtMap.put(district.getId().getNroCentro(), district.getNomCentro());
		});
		// map scope
		List<SgdValor> sgdValors = commonService.getScopes();
		Map<BigDecimal, String> scopes = sgdValors.parallelStream().filter(Objects::nonNull)
				.collect(Collectors.toMap(SgdValor::getCodigo, SgdValor::getDescripcion));

		// map regions
		List<SgdCentro> regions = sgdCentroRepository.findSgdCentroByIdTipCentro(
				Long.valueOf(env.getProperty("application.sgdcentro.tipcentro.region.value")));
		Map<Long, String> regionMap = new HashMap<>();
		regions.parallelStream().filter(Objects::nonNull).forEach((region) -> {
			regionMap.put(region.getId().getNroCentro(), region.getNomCentro());
		});

		SgdIncidencia sgdIncidencia = sgdIncidenciaRepository.findOne(nroIncidencia);
		SgdInstalacion sgdInstalacion = sgdInstalacionRepository
				.findSgdInstalacionByIdNroInstalacion(sgdIncidencia.getNroInstAfectada());

		PowerOutage powerOutage = new PowerOutage();
		PowerOutageIncidentInfo powerOutageIncidentInfo = new PowerOutageIncidentInfo();
		PowerOutageInstallationInfo powerOutageInstallationInfo = new PowerOutageInstallationInfo();

		powerOutage.setVoltage(String.valueOf(sgdInstalacion.getTension()));
		powerOutageIncidentInfo.setComment(sgdIncidencia.getDescIncidencia());
		powerOutageIncidentInfo
				.setPlannedDate(new SimpleDateFormat("yyyy/mm/dd").format(sgdIncidencia.getFDeteccion()));
		powerOutageIncidentInfo.setStatus(statusMap.get(sgdIncidencia.getEstActual()));
		powerOutageIncidentInfo.setPlannedDay(new SimpleDateFormat("EE").format(sgdIncidencia.getFDeteccion()));
		// TODO wait for Brian to give more info
		powerOutage.setRegion(regionMap.get(sgdIncidencia.getNroCentro().longValue()));
		powerOutage.setScope(scopes.get(sgdIncidencia.getAlcance()));
		powerOutageInstallationInfo.setDistrict(districtMap.get(sgdIncidencia.getNroMesa().longValue()));
		if (sgdIncidencia.getFeeder() != null) {
			powerOutageInstallationInfo.setFeeder(feederMap.get(sgdIncidencia.getFeeder().longValue()));
			powerOutageInstallationInfo.setSubstation(substationMap.get(sgdIncidencia.getFeeder().longValue()));
		}
		powerOutage.setPowerOutageIncidentInfo(powerOutageIncidentInfo);
		powerOutage.setPowerOutageInstallationInfo(powerOutageInstallationInfo);
		powerOutage.setOutageType(sgdIncidencia.getTipIncidencia().intValue());

		return powerOutage;
	}

	@Override
	public List<SgdValor> getPowerOutageStatuses() {
		List<SgdValor> sgdValors = sgdValorRepository.findSgdValorByIdCodif(
				env.getProperty("application.sgdvalor.codif.poweroutage.status.value"),
				new Sort(Sort.Direction.ASC, "codigo"));
		return sgdValors.parallelStream().filter((filter) -> filter.getCodigo().intValue() <= 5)
				.collect(Collectors.toList());
	}
}
