package com.indra.iopen.service.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.indra.iopen.exception.DataIntegrityException;
import com.indra.iopen.form.ReceivedInspectionResult;
import com.indra.iopen.model.Actividade;
import com.indra.iopen.model.ActividadePK;
import com.indra.iopen.model.CosteExp;
import com.indra.iopen.model.Expediente;
import com.indra.iopen.model.IopenApplication;
import com.indra.iopen.model.Ordene;
import com.indra.iopen.model.Personal;
import com.indra.iopen.model.PresupuestosExped;
import com.indra.iopen.model.PresupuestosExpedPK;
import com.indra.iopen.model.Tipo;
import com.indra.iopen.model.TrabpendAf;
import com.indra.iopen.model.Unicom;
import com.indra.iopen.model.Visita;
import com.indra.iopen.model.VisitaPK;
import com.indra.iopen.pojo.GISInspectionResult;
import com.indra.iopen.repositories.model.ActividadeRepository;
import com.indra.iopen.repositories.model.CosteExpRepository;
import com.indra.iopen.repositories.model.ExpedienteRepository;
import com.indra.iopen.repositories.model.GisIopenMappingRepository;
import com.indra.iopen.repositories.model.IopenApplicationRepository;
import com.indra.iopen.repositories.model.OrdeneRepository;
import com.indra.iopen.repositories.model.PersonalRepository;
import com.indra.iopen.repositories.model.PresupuestosExpedRepository;
import com.indra.iopen.repositories.model.TrabpendAfRepository;
import com.indra.iopen.repositories.model.UnicomRepository;
import com.indra.iopen.repositories.model.VisitaRepository;
import com.indra.iopen.service.ApplicationService;
import com.indra.iopen.service.CommonService;
import com.indra.iopen.service.InspectionResultsService;
import com.indra.iopen.service.QuotationService;
import com.indra.iopen.util.ApplicationAdvanceType;
import com.indra.iopen.util.ApplicationDefault;

@Service
// @Transactional(rollbackFor = { Exception.class })
@PropertySource("classpath:application.properties")
public class InspectionResultsServiceImpl implements InspectionResultsService {

	@Autowired
	private OrdeneRepository ordeneRepository;
	@Autowired
	TrabpendAfRepository trabpendAfRepository;
	@Autowired
	VisitaRepository visitaRepository;
	@Autowired
	ActividadeRepository actividadeRepository;
	@Autowired
	PresupuestosExpedRepository presupuestosExpedRepository;
	@Autowired
	CosteExpRepository costeExpRepository;
	@Autowired
	ExpedienteRepository expedienteRepository;
	@Autowired
	PersonalRepository personalRepository;
	@Autowired
	IopenApplicationRepository iopenApplicationRepository;
	@Autowired
	private Environment env;

	@Autowired
	private CommonService commonService;
	// SMA 20160317
	@Autowired
	private UnicomRepository unicomRepository;

	@Autowired
	private ApplicationService applicationService;
	@Autowired
	private QuotationService quotationService;

	// SMA/UMESCI-713 start
	@Value("${iopen.connection.type.domestic}")
	private String domesricConnectionType;
	@Value("${iopen.connection.type.commercial}")
	private String commercialConnectionType;
	@Value("${application.inspection.fee.tip_mov.value}")
	private String tipMovValue;
	@Value("${iopen.bill.status.billed}")
	private String billStatusBilled;
	@Autowired
	private GisIopenMappingRepository gisIopenMappingRepository;

	@Override
	public ReceivedInspectionResult prepareReceivedInspectionResultsFromGISInspectionResults(
			final GISInspectionResult gISInspectionResult) throws Exception {
		final ReceivedInspectionResult inspectionResult = new ReceivedInspectionResult();
		final Date date = new Date(gISInspectionResult.getInspectionDate());
		final SimpleDateFormat formatTime = new SimpleDateFormat("HH.mm");
		inspectionResult.setInspectionDate(date);
		inspectionResult.setInspectionStatus(Long.valueOf(gisIopenMappingRepository
				.findGisIopenMappingByDescription(gISInspectionResult.getInspectionStatus()).getCode()));
		inspectionResult.setInspectionTime(formatTime.format(date));
		inspectionResult.setGps(gISInspectionResult.getGps());
		// get IOPENApplication
		IopenApplication iopenApplication = iopenApplicationRepository
				.findIopenApplicationByExpedienteNumExp(gISInspectionResult.getWorkRequestNumber());
		if (iopenApplication != null) {
			inspectionResult.setIopenApplication(iopenApplication);
		} else {
			iopenApplication = applicationService.prepareIopenApplication(gISInspectionResult.getWorkRequestNumber());
			inspectionResult.setIopenApplication(iopenApplication);
		}
		inspectionResult.setInspectionByEmployeeCode(gISInspectionResult.getEmployeeCode());
		inspectionResult.setInspectionComment(gISInspectionResult.getObservation());
		inspectionResult.setTipSolic(String.valueOf(gisIopenMappingRepository
				.findGisIopenMappingByDescription(gISInspectionResult.getConnectionType()).getCode()));
		inspectionResult.setTipObra(String.valueOf(gisIopenMappingRepository
				.findGisIopenMappingByDescription(gISInspectionResult.getWorkRequestType()).getCode()));
		// inspectionResult.setTipConexion(gISInspectionResult.getWorkRequestType());

		return inspectionResult;
	}

	// SMA/UMESCI-713 stop
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void processInspectionResults(final ReceivedInspectionResult inspectionResult) throws Exception {
		IopenApplication iopenApplication = null;
		// Resolve Service order
		resolveSiteInspectionServiceOrder(inspectionResult);
		if (inspectionResult.getIopenApplication() != null) {
			iopenApplication = inspectionResult.getIopenApplication();
		}else{
			throw new Exception();
		}
		/* Update inspection results */
		if (inspectionResult.getInspectionPassed().equals(Boolean.TRUE)) {
			// SMA/UMESCI-713 START
			final Expediente expediente = inspectionResult.getIopenApplication().getExpediente();
			if (!expediente.getTipSolic().equalsIgnoreCase(inspectionResult.getTipSolic())) {
				// check if change is from domestic to commercial (This is the
				// requiremsnts for UMESCI-713)
				double balance;
				if (inspectionResult.getTipSolic().equalsIgnoreCase(commercialConnectionType)
						&& expediente.getTipSolic().equalsIgnoreCase(domesricConnectionType)) {
					double commercialCost = 0;
					final CosteExp costeExp = costeExpRepository.findCosteExpByTipMovAndTipTarrif(tipMovValue,
							inspectionResult.getTipSolic());
					if (costeExp != null) {
						commercialCost = costeExp.getCoste().doubleValue();
					}
					PresupuestosExped presupuestosExped = presupuestosExpedRepository
							.findPresupuestosExpedByIdNumExpAndTipMovAndEstado(expediente.getNumExp(), tipMovValue,
									billStatusBilled);
					balance = commercialCost
							- (presupuestosExped != null ? presupuestosExped.getCoste().longValue() : 0);
					presupuestosExped = preparePresupuestosExped(expediente, tipMovValue, balance);
					expediente.setTipSolic(inspectionResult.getTipSolic());
					expedienteRepository.edit(expediente);

					presupuestosExpedRepository.save(presupuestosExped);

					processToInspectionPassed(inspectionResult);

					// update iopenApplication for purpose of mail sending
					iopenApplication = iopenApplicationRepository.findOne(iopenApplication.getCodApplication());

					// SMA/UMESCI-732 -20170606
					quotationService.processFromInspectionPassed(iopenApplication,presupuestosExped);

				} else {
					// fail
					// fail inspection
					processToInspectionFailed(inspectionResult);

					final List<IopenApplication> iopenApplications = new ArrayList<>();
					iopenApplication = iopenApplicationRepository
							.findOne(inspectionResult.getIopenApplication().getCodApplication());
					iopenApplications.add(iopenApplication);
					commonService.sendMessagesClientsToInformOfAdvanceInApplicationStatus(iopenApplications,
							ApplicationAdvanceType.INSPECTION_FAILED, inspectionResult);

				}
			} else {
				processToInspectionPassed(inspectionResult);

				// update iopenApplication for purpose of mail sending
				iopenApplication = iopenApplicationRepository
						.findOne(inspectionResult.getIopenApplication().getCodApplication());
				// SMA/UMESCI-732 -20170606
				quotationService.processFromInspectionPassed(iopenApplication,null);

			} // SMA/UMESCI-713 STOP
		} else if (inspectionResult.getInspectionPassed().equals( Boolean.FALSE) ){

			processToInspectionFailed(inspectionResult);
			final List<IopenApplication> iopenApplications = new ArrayList<>();
			iopenApplication = iopenApplicationRepository
					.findOne(inspectionResult.getIopenApplication().getCodApplication());
			iopenApplications.add(iopenApplication);
			commonService.sendMessagesClientsToInformOfAdvanceInApplicationStatus(iopenApplications,
					ApplicationAdvanceType.INSPECTION_FAILED, inspectionResult);

		}
	}

	// @Transactional(rollbackFor = { Exception.class })
	@Override
	public void resolveSiteInspectionServiceOrder(final ReceivedInspectionResult inspectionResult) throws Exception {
		// issue service order & update to resolved
		// update trapendAf
		final TrabpendAf trabpendAf = prepareTrapendAf(inspectionResult.getIopenApplication().getExpediente());
		if (trabpendAf != null) {
			trabpendAfRepository.save(trabpendAf);
		}

		// insert into visita
		final Visita visita = prepareVisita(inspectionResult);
		visitaRepository.save(visita);

		// update Orderne
		final Ordene ordene = prepareOrdenes(inspectionResult.getIopenApplication().getExpediente());
		// SMA/UMESCI-732 -20170506
		ordene.setCodEmpAsig(BigDecimal.valueOf(inspectionResult.getInspectionByEmployeeCode()));
		ordeneRepository.save(ordene);

		// SMA/UMESCI-713 start
		// save GPS coordinates
		final IopenApplication iopenApplication = inspectionResult.getIopenApplication();
		if (inspectionResult.getGps() != null) {
			iopenApplication
			.setGps(inspectionResult.getGps().getX() + "@" + inspectionResult.getGps().getY() + "@" + "0");
		}
		iopenApplicationRepository.save(iopenApplication);
		// SMA/UMESCI-713 end

	}

	// @Transactional(rollbackFor = { Exception.class })
	@Override
	public void processToInspectionPassed(final ReceivedInspectionResult inspectionResult) {
		// update expediente
		final Expediente expediente = prepareExpediente(inspectionResult);
		expediente.setEstado(env.getProperty("application.stage.inspection.passed.value"));
		expedienteRepository.save(expediente);

		// insert into actividades
		final Actividade actividade = prepareActividades(expediente,
				env.getProperty("application.stage.inspection.passed.value"));
		actividade.setComentAct(inspectionResult.getInspectionComment());
		actividadeRepository.save(actividade);
	}

	// @Transactional(rollbackFor = { Exception.class })
	@Override
	public void processToInspectionFailed(final ReceivedInspectionResult inspectionResult) {
		// update expediente
		final Expediente expediente = prepareExpediente(inspectionResult);
		expediente.setEstado(env.getProperty("application.stage.inspection.failed.value"));
		expedienteRepository.save(expediente);

		// insert into actividades
		final Actividade actividade = prepareActividades(expediente,
				env.getProperty("application.stage.inspection.failed.value"));
		actividade.setComentAct(inspectionResult.getInspectionComment());
		actividadeRepository.save(actividade);

		// insert into presupuestos_exped (re-inspection fee)
		final PresupuestosExped presupuestosExped = preparePresupuestosExped(expediente,
				env.getProperty("application.inspection.fee.tip_mov.value"),
				getInspectionFee(expediente.getTipSolic()));
		presupuestosExpedRepository.save(presupuestosExped);

		// update iopen application remove inspection schedule data
		final IopenApplication iopenApplication = iopenApplicationRepository
				.findOne(inspectionResult.getIopenApplication().getCodApplication());
		iopenApplication.setInspectionScheduled(Boolean.FALSE);
		iopenApplication.setInspectionScheduledDate(null);
		iopenApplicationRepository.save(iopenApplication);

	}

	private Expediente prepareExpediente(final ReceivedInspectionResult inspectionResult) {
		final Expediente expediente = expedienteRepository
				.findById(inspectionResult.getIopenApplication().getExpediente().getNumExp());

		expediente.setTipSolic(inspectionResult.getTipSolic());
		if (inspectionResult.getTipConexion() != null && !inspectionResult.getTipConexion().isEmpty())
			expediente.setTipConexion(inspectionResult.getTipConexion());
		expediente.setTipObra(inspectionResult.getTipObra());

		expediente.setFUce(new Date());
		expediente.setFActual(new Date());
		expediente.setUsuario(ApplicationDefault.getDatabaseUser());
		expediente.setPrograma(ApplicationDefault.getProgram());

		return expediente;
	}

	private TrabpendAf prepareTrapendAf(final Expediente expediente) {
		final TrabpendAf trabpendAf = trabpendAfRepository.findTrabpendAfToBeUpdatedWhenCommitingInspectionResults(
				expediente.getNumOs().longValue(), "%1", env.getProperty("application.service.order.status.generated"));

		if (trabpendAf != null) {
			trabpendAf.setEstAf(trabpendAf.getEstAf().substring(1, 4).concat("2"));
			trabpendAf.setUsuario(ApplicationDefault.getDatabaseUser());
			trabpendAf.setFActual(new Date());
			trabpendAf.setPrograma(ApplicationDefault.getProgram());
		}

		return trabpendAf;
	}

	private Ordene prepareOrdenes(final Expediente expediente) {
		final Ordene ordene = ordeneRepository.findOne(expediente.getNumOs().longValue());
		final Date now = new Date();
		ordene.setFUce(now);
		ordene.setFActual(now);
		ordene.setUsuario(ApplicationDefault.getDatabaseUser());
		ordene.setPrograma(ApplicationDefault.getProgram());
		ordene.setEstOs(env.getProperty("application.default.resolve.service.order.status"));

		return ordene;
	}

	private Visita prepareVisita(final ReceivedInspectionResult inspectionResult) throws Exception {
		if (inspectionResult.getInspectionComment() == null) {
			throw new DataIntegrityException("You must provide a comment");
		}
		final Visita visita = new Visita();

		final VisitaPK visitaPK = new VisitaPK();

		visitaPK.setCoAcceje(env.getProperty("application.visita.site.inspection.value"));
		visitaPK.setFVis(inspectionResult.getInspectionDate());
		visitaPK.setNumOs(inspectionResult.getIopenApplication().getExpediente().getNumOs().longValue());
		visita.setId(visitaPK);

		visita.setUsuario(ApplicationDefault.getDatabaseUser());
		visita.setFActual(new Date());
		visita.setPrograma(ApplicationDefault.getProgram());

		visita.setCodEmp(BigDecimal.valueOf(inspectionResult.getInspectionByEmployeeCode()));
		visita.setHoraVisFin(BigDecimal.valueOf(Double.parseDouble(inspectionResult.getInspectionTime())));
		visita.setHoraVisIni(BigDecimal.valueOf(Double.parseDouble(inspectionResult.getInspectionTime())));
		visita.setObservaciones(inspectionResult.getInspectionComment());
		return visita;
	}

	private Actividade prepareActividades(final Expediente expediente, final String status) {
		final Actividade actividade = new Actividade();
		final ActividadePK actividadePK = new ActividadePK();

		actividadePK.setNumExp(expediente.getNumExp());

		final long maxNumAct = actividadeRepository.findMaxNumActByIdNumExp(expediente.getNumExp());
		actividadePK.setNumAct(maxNumAct + 1);
		actividade.setId(actividadePK);

		actividade.setPrograma(ApplicationDefault.getProgram());
		actividade.setUsuario(ApplicationDefault.getDatabaseUser());
		actividade.setEstAct(status);

		return actividade;

	}

	@Override
	public PresupuestosExped preparePresupuestosExped(final Expediente expediente, final String tipMov,
			final double amount) {

		final PresupuestosExped presupuestosExped = new PresupuestosExped();
		final PresupuestosExpedPK presupuestosExpedPK = new PresupuestosExpedPK();

		presupuestosExpedPK.setNumExp(expediente.getNumExp());
		presupuestosExpedPK.setPresupuestosSec(
				presupuestosExpedRepository.getMaxPresupuestosSecByNumExp(expediente.getNumExp()) + 1);

		presupuestosExpedPK.setCodPresupuesto(Long.valueOf(ApplicationDefault.getPresupestosExpedcodPresupuesto()));
		presupuestosExped.setId(presupuestosExpedPK);

		presupuestosExped.setCoste(BigDecimal.valueOf(amount));
		presupuestosExped.setTipMov(tipMov);

		presupuestosExped.setPrograma(ApplicationDefault.getProgram());
		presupuestosExped.setUsuario(ApplicationDefault.getDatabaseUser());
		presupuestosExped.setFechaEnvio(new Date());
		presupuestosExped.setDescCategoria(ApplicationDefault.getPresupestosExpeddescCategoria());
		presupuestosExped.setDescConceptoPres(ApplicationDefault.getPresupestosExpeddescCncepto_pres());
		presupuestosExped.setCantidad(new BigDecimal(ApplicationDefault.getPresupestosExpedcantidad()));
		presupuestosExped.setIndBg(new BigDecimal(ApplicationDefault.getPresupestosExpedindBg()));
		presupuestosExped.setEstado(ApplicationDefault.getPresupestosExpedestado());

		return presupuestosExped;
	}

	@Override
	public double getInspectionFee(final String tariff) {
		double cost = 0;

		final CosteExp costeExp = costeExpRepository.findCoste(tariff,
				env.getProperty("application.inspection.fee.tip_mov.value"));

		if (costeExp != null) {
			cost = costeExp.getCoste().doubleValue();
		}

		return cost;
	}

	@Override
	public List<Personal> findPersonalToWorkOnServiceOrder(long numOs) {
		return personalRepository.findPersonalWithServiceOrderNo(numOs);
	}

	// SMA 20160317
	@Override
	public Map<Long, String> findMeterReadingDivision(Long codApplicaion) {
		List<Unicom> unicomList = null;
		Map<Long, String> mrDiv = new HashMap<>();
		unicomList = unicomRepository.findUnicomMrDivByCodApplication(codApplicaion);
		if (unicomList != null && !unicomList.isEmpty()) {
			mrDiv = unicomList.stream().filter(Objects::nonNull)
					.collect(Collectors.toMap(Unicom::getCodUnicom, Unicom::getNomUnicom));
		}
		return mrDiv;
	}

	@Override
	public List<Tipo> getValidProjectTypes() {
		final List<Tipo> projectTypes = commonService.getTipos("01");
		// final String tipObras =
		// env.getProperty("application.invalid.project.type");
		// final ArrayList<String> invalidTipObras = new
		// ArrayList<String>(Arrays.asList(tipObras.split(",")));
		// projectTypes=projectTypes.stream().filter(filter->filter!=null&&!invalidTipObras.contains(filter.getTipo())).collect(Collectors.toList());
		return projectTypes;
	}
}
