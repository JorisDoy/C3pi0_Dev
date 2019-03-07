package com.indra.iopen.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;import java.util.Objects;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.indra.iopen.form.ContractConsumption;
import com.indra.iopen.model.ApmedidaAp;
import com.indra.iopen.model.ApmedidaCo;
import com.indra.iopen.repositories.model.ApmedidaApRepository;
import com.indra.iopen.repositories.model.ApmedidaCoRepository;
import com.indra.iopen.repositories.model.CodigoRepository;
import com.indra.iopen.repositories.model.EstadoRepository;
import com.indra.iopen.repositories.model.GrupoEstRepository;
import com.indra.iopen.repositories.model.ImpConceptoRepository;
import com.indra.iopen.repositories.model.ReciboRepository;
import com.indra.iopen.repositories.model.SumconRepository;
import com.indra.iopen.repositories.model.TipoRepository;
import com.indra.iopen.service.ConsumptionListService;

@Service
@PropertySource("classpath:application.properties")
public class ConsumptionListServiceImpl implements ConsumptionListService {

	@Autowired
	private ImpConceptoRepository impConceptoRepository;
	@Autowired
	private ReciboRepository reciboRepository;
	@Autowired
	private CodigoRepository codigoRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private TipoRepository tipoRepository;
	@Autowired
	private GrupoEstRepository grupoEstRepository;
	@Autowired
	private SumconRepository sumconRepository;
	@Autowired
	private ApmedidaApRepository apmedidaApRepository;
	@Autowired
	private ApmedidaCoRepository apmedidaCoRepository;

	@Autowired
	private Environment env;

	@Override
	public List<ContractConsumption> getConsumptionsByNisRad(Long contractNumber, String year, int page,
			int recordsPerPage) {

		List<ContractConsumption> consumptions = new ArrayList<>();

		// Find valid usage types and usage statuses to display online
		String validUsageStatusesCode = env.getProperty("consumption.grupoEst.co_grupo.est_csmo_group.value");
		String validUsageTypesCode = env.getProperty("consumption.grupoEst.co_grupo.tip_csmo_group.value");
		List<String> validUsageStatuses = grupoEstRepository.findEstRecByidCoGrupo(validUsageStatusesCode);
		List<String> validUsageTypes = grupoEstRepository.findEstRecByidCoGrupo(validUsageTypesCode);

		// Find the idApa used to search for usages
		BigDecimal numSum = sumconRepository.findOne(contractNumber).getNumSum();
		ApmedidaAp apmedidaAp = apmedidaApRepository.findApmedidaApByNumSum(numSum);

		List<ApmedidaCo> apmedidaCos = new ArrayList<ApmedidaCo>();

		// List<ImpConcepto> impConceptos = new ArrayList<ImpConcepto>();

		if (year.equalsIgnoreCase("ALL") || year.isEmpty()) {
			// impConceptos =
			// impConceptoRepository.findConsumptionListByNisRad(BigDecimal.valueOf(contractNumber),
			// energyConceptsGroup, new PageRequest(page - 1, recordsPerPage));

			apmedidaCos = apmedidaCoRepository.findByIdApa(BigDecimal.valueOf(apmedidaAp.getIdApa()), validUsageTypes,
					validUsageStatuses, new PageRequest(page - 1, recordsPerPage, Direction.DESC, "fLect"));

		} else {

			Calendar calendarStart = Calendar.getInstance();
			calendarStart.set(Calendar.YEAR, Integer.valueOf(year));
			calendarStart.set(Calendar.MONTH, 0);
			calendarStart.set(Calendar.DAY_OF_MONTH, 1);
			// returning the first date
			Date startDate = calendarStart.getTime();

			Calendar calendarEnd = Calendar.getInstance();
			calendarEnd.set(Calendar.YEAR, Integer.valueOf(year));
			calendarEnd.set(Calendar.MONTH, 11);
			calendarEnd.set(Calendar.DAY_OF_MONTH, 31);

			// returning the last date
			Date endDate = calendarEnd.getTime();

			// impConceptos =
			// impConceptoRepository.findConsumptionListByNisRadAndFFactBetween(
			// BigDecimal.valueOf(contractNumber), energyConceptsGroup,
			// startDate, endDate,
			// new PageRequest(page - 1, recordsPerPage));

			apmedidaCos = apmedidaCoRepository.findByIdApaAndFLectBetween(BigDecimal.valueOf(apmedidaAp.getIdApa()),
					validUsageTypes, validUsageStatuses, startDate, endDate,
					new PageRequest(page - 1, recordsPerPage, Direction.DESC, "fLect"));
		}

		ContractConsumption contractConsumption = null;
		// Recibo recibo = null;
		// for (ImpConcepto impConcepto : impConceptos) {
		// contractConsumption = new ContractConsumption();
		// recibo = reciboRepository.findOne(impConcepto.getId().getNumRec());
		//
		// contractConsumption.setBillingDate(recibo.getFFact());
		// contractConsumption.setBillStatus(estadoRepository.findById(recibo.getEstAct()).getDescEst());
		// contractConsumption.setBillNumber(impConcepto.getId().getNumRec());
		// contractConsumption.setConsumptionType(codigoRepository.findById(impConcepto.getCoConcepto()).getDescCod());
		// contractConsumption.setUnitsConsumed(impConcepto.getCsmoFact().longValue());
		//
		// consumptions.add(contractConsumption);
		// }

		for (ApmedidaCo apmedidaCo : apmedidaCos) {
			contractConsumption = new ContractConsumption();

			contractConsumption.setConsumptionType(tipoRepository.findById(apmedidaCo.getTipCsmo()).getDescTipo());
			contractConsumption.setCurrentReading(apmedidaCo.getLect().doubleValue());
			contractConsumption.setMeterConstant(apmedidaCo.getCteApa().doubleValue());
			contractConsumption.setMeterMake(codigoRepository.findById(apmedidaAp.getCoMarca()).getDescCod());
			contractConsumption.setMeterNumber(apmedidaAp.getNumApa());
			contractConsumption.setReadingDate(apmedidaCo.getFLect());
			contractConsumption.setReadingType(tipoRepository.findById(apmedidaCo.getTipLect()).getDescTipo());
			contractConsumption.setUsage(apmedidaCo.getCsmo().doubleValue());

			consumptions.add(contractConsumption);
		}

		return consumptions;
	}

	@Override
	public int getNumberOfPages(Long contractNumber, String year, int recordsPerPage) {

		// String energyConceptsGroup =
		// env.getProperty("consumption.grupoEst.co_grupo.energy_concepts_group.value");
		Long records;

		// Find valid usage types and usage statuses to display online
		String validUsageStatusesCode = env.getProperty("consumption.grupoEst.co_grupo.est_csmo_group.value");
		String validUsageTypesCode = env.getProperty("consumption.grupoEst.co_grupo.tip_csmo_group.value");
		List<String> validUsageStatuses = grupoEstRepository.findEstRecByidCoGrupo(validUsageStatusesCode);
		List<String> validUsageTypes = grupoEstRepository.findEstRecByidCoGrupo(validUsageTypesCode);

		// Find the idApa used to search for usages
		BigDecimal numSum = sumconRepository.findOne(contractNumber).getNumSum();
		ApmedidaAp apmedidaAp = apmedidaApRepository.findApmedidaApByNumSum(numSum);

		if (year.equalsIgnoreCase("ALL") || year.isEmpty()) {
			records = apmedidaCoRepository.findCountByIdApa(BigDecimal.valueOf(apmedidaAp.getIdApa()), validUsageTypes,
					validUsageStatuses);

			// records =
			// impConceptoRepository.getConsumptionCountByNisRad(BigDecimal.valueOf(contractNumber),
			// energyConceptsGroup);

		} else {

			Calendar calendarStart = Calendar.getInstance();
			calendarStart.set(Calendar.YEAR, Integer.valueOf(year));
			calendarStart.set(Calendar.MONTH, 0);
			calendarStart.set(Calendar.DAY_OF_MONTH, 1);
			// returning the first date
			Date startDate = calendarStart.getTime();

			Calendar calendarEnd = Calendar.getInstance();
			calendarEnd.set(Calendar.YEAR, Integer.valueOf(year));
			calendarEnd.set(Calendar.MONTH, 11);
			calendarEnd.set(Calendar.DAY_OF_MONTH, 31);

			// returning the last date
			Date endDate = calendarEnd.getTime();

			// records =
			// impConceptoRepository.getConsumptionCountByNisRadAndFFactBetween(
			// BigDecimal.valueOf(contractNumber), energyConceptsGroup,
			// startDate, endDate);
			records = apmedidaCoRepository.findCountByIdApaAndFLectBetween(BigDecimal.valueOf(apmedidaAp.getIdApa()),
					validUsageTypes, validUsageStatuses, startDate, endDate);
		}

		Double dPages = Math.ceil(records.doubleValue() / recordsPerPage);

		int pages = dPages.intValue();

		return pages;
	}

	@Override
	public List<Integer> getConsumptionYears(Long contractNumber) {
		// Find valid usage types and usage statuses to display online
		String validUsageStatusesCode = env.getProperty("consumption.grupoEst.co_grupo.est_csmo_group.value");
		String validUsageTypesCode = env.getProperty("consumption.grupoEst.co_grupo.tip_csmo_group.value");
		List<String> validUsageStatuses = grupoEstRepository.findEstRecByidCoGrupo(validUsageStatusesCode);
		List<String> validUsageTypes = grupoEstRepository.findEstRecByidCoGrupo(validUsageTypesCode);

		// Find the idApa used to search for usages
		BigDecimal numSum = sumconRepository.findOne(contractNumber).getNumSum();
		ApmedidaAp apmedidaAp = apmedidaApRepository.findApmedidaApByNumSum(numSum);

		return apmedidaCoRepository.findDistinctConsumptionYears(BigDecimal.valueOf(apmedidaAp.getIdApa()),
				validUsageTypes, validUsageStatuses);
	}

	@Override
	public Integer getMaxConsumptionYear(Long contractNumber) {
		// Find valid usage types and usage statuses to display online
		String validUsageStatusesCode = env.getProperty("consumption.grupoEst.co_grupo.est_csmo_group.value");
		String validUsageTypesCode = env.getProperty("consumption.grupoEst.co_grupo.tip_csmo_group.value");
		List<String> validUsageStatuses = grupoEstRepository.findEstRecByidCoGrupo(validUsageStatusesCode);
		List<String> validUsageTypes = grupoEstRepository.findEstRecByidCoGrupo(validUsageTypesCode);

		// Find the idApa used to search for usages
		BigDecimal numSum = sumconRepository.findOne(contractNumber).getNumSum();
		ApmedidaAp apmedidaAp = apmedidaApRepository.findApmedidaApByNumSum(numSum);

		return apmedidaCoRepository.findMaxConsumptionYears(BigDecimal.valueOf(apmedidaAp.getIdApa()), validUsageTypes,
				validUsageStatuses);
	}
}
