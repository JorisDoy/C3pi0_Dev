package com.indra.iopen.service.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.indra.iopen.exception.DataIntegrityException;
import com.indra.iopen.form.ConnectionResult;
import com.indra.iopen.model.Actividade;
import com.indra.iopen.model.ActividadePK;
import com.indra.iopen.model.ApaTipCarac;
import com.indra.iopen.model.Aparato;
import com.indra.iopen.model.ApmedidaAp;
import com.indra.iopen.model.ApmedidaCo;
import com.indra.iopen.model.BillDispatch;
import com.indra.iopen.model.BillDispatchPK;
import com.indra.iopen.model.Cliente;
import com.indra.iopen.model.ConsumoContratado;
import com.indra.iopen.model.ConsumoContratadoPK;
import com.indra.iopen.model.CuentasCu;
import com.indra.iopen.model.ExpedComm;
import com.indra.iopen.model.ExpedCommPK;
import com.indra.iopen.model.Expediente;
import com.indra.iopen.model.Fincas;
import com.indra.iopen.model.FincasExp;
import com.indra.iopen.model.GrConsumoContratado;
import com.indra.iopen.model.Haparato;
import com.indra.iopen.model.HaparatoPK;
import com.indra.iopen.model.InvGroup;
import com.indra.iopen.model.IopenApplication;
import com.indra.iopen.model.Ordene;
import com.indra.iopen.model.PayingAccount;
import com.indra.iopen.model.Puntomed;
import com.indra.iopen.model.SumExp;
import com.indra.iopen.model.Sumcon;
import com.indra.iopen.model.SumconRetailAccess;
import com.indra.iopen.model.Suministro;
import com.indra.iopen.model.SuministroTipCsmo;
import com.indra.iopen.model.SuministroTipCsmoPK;
import com.indra.iopen.model.TrabpendAf;
import com.indra.iopen.model.Visita;
import com.indra.iopen.model.VisitaPK;
import com.indra.iopen.repositories.model.ActividadeRepository;
import com.indra.iopen.repositories.model.ApaTipCaracRepository;
import com.indra.iopen.repositories.model.AparatoRepository;
import com.indra.iopen.repositories.model.ApmedidaApRepository;
import com.indra.iopen.repositories.model.ApmedidaCoRepository;
import com.indra.iopen.repositories.model.BillDispatchRepository;
import com.indra.iopen.repositories.model.ClienteRepository;
import com.indra.iopen.repositories.model.ConsumoContratadoRepository;
import com.indra.iopen.repositories.model.CosteExpRepository;
import com.indra.iopen.repositories.model.CuentasCuRepository;
import com.indra.iopen.repositories.model.ExpedCommRepository;
import com.indra.iopen.repositories.model.ExpedienteRepository;
import com.indra.iopen.repositories.model.FincasExpRepository;
import com.indra.iopen.repositories.model.FincasRepository;
import com.indra.iopen.repositories.model.GrConsumoContratadoRepository;
import com.indra.iopen.repositories.model.HaparatoRepository;
import com.indra.iopen.repositories.model.InvGroupRepository;
import com.indra.iopen.repositories.model.IopenApplicationRepository;
import com.indra.iopen.repositories.model.OrdeneRepository;
import com.indra.iopen.repositories.model.PayingAccountRepository;
import com.indra.iopen.repositories.model.PresupuestosExpedRepository;
import com.indra.iopen.repositories.model.PuntomedRepository;
import com.indra.iopen.repositories.model.SumExpRepository;
import com.indra.iopen.repositories.model.SumconRepository;
import com.indra.iopen.repositories.model.SumconRetailAccessRepository;
import com.indra.iopen.repositories.model.SuministroRepository;
import com.indra.iopen.repositories.model.SuministroTipCsmoRepository;
import com.indra.iopen.repositories.model.TrabpendAfRepository;
import com.indra.iopen.repositories.model.VisitaRepository;
import com.indra.iopen.service.CommonService;
import com.indra.iopen.service.ConnectionResultService;
import com.indra.iopen.util.ApplicationAdvanceType;
import com.indra.iopen.util.ApplicationDefault;

@Service
@Transactional(rollbackFor = { Exception.class })
@PropertySource("classpath:application.properties")
public class ConnectionResultServiceImpl implements ConnectionResultService {

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
	SumExpRepository sumExpRepository;
	@Autowired
	ExpedCommRepository expedCommRepository;
	@Autowired
	FincasExpRepository fincasExpRepository;
	@Autowired
	SuministroRepository suministroRepository;
	@Autowired
	AparatoRepository aparatoRepository;
	@Autowired
	HaparatoRepository haparatoRepository;
	@Autowired
	SuministroTipCsmoRepository suministroTipCsmoRepository;
	@Autowired
	ApmedidaApRepository apmedidaApRepository;
	@Autowired
	ApmedidaCoRepository apmedidaCoRepository;
	@Autowired
	ApaTipCaracRepository apaTipCaracRepository;
	@Autowired
	FincasRepository fincasRepository;
	@Autowired
	PuntomedRepository puntomedRepository;
	@Autowired
	ClienteRepository clienteRepository;
	@Autowired
	CuentasCuRepository cuentasCuRepository;
	@Autowired
	SumconRepository sumconRepository;
	@Autowired
	GrConsumoContratadoRepository grConsumoContratadoRepository;
	@Autowired
	ConsumoContratadoRepository consumoContratadoRepository;
	@Autowired
	SumconRetailAccessRepository sumconRetailAccessRepository;
	@Autowired
	PayingAccountRepository payingAccountRepository;
	@Autowired
	BillDispatchRepository billDispatchRepository;
	@Autowired
	InvGroupRepository invGroupRepository;
	@Autowired
	IopenApplicationRepository iopenApplicationRepository;
	@Autowired
	private Environment env;

	@Autowired
	private CommonService commonService;

	@Override
	public void processConnectionResult(ConnectionResult connectionResult) throws Exception {

		// validate connection results
		validateConnectionResults(connectionResult);

		// resolve service order
		resolveSiteInspectionServiceOrder(connectionResult);

		// process to connection in progress (17019)
		processToConnectionInProgress(connectionResult);

		// create service point
		final Suministro suministro = createServicePoint(connectionResult);

		// install meter
		installMeter(connectionResult, suministro);

		// enroll client (create service)
		createService(connectionResult, suministro);

		// send messages
		final List<IopenApplication> iopenApplications = new ArrayList<>();

		final IopenApplication iopenApplication = iopenApplicationRepository
				.findOne(connectionResult.getIopenApplication().getCodApplication());

		iopenApplications.add(iopenApplication);
		commonService.sendMessagesClientsToInformOfAdvanceInApplicationStatus(iopenApplications,
				ApplicationAdvanceType.SERVICE_POINT_CREATED);
	}

	private void validateConnectionResults(ConnectionResult connectionResult) throws Exception {

		// validate meter
		final Aparato aparato = aparatoRepository.findAparatoByIdNumApaAndIdCoMarca(connectionResult.getMeterNumber(),
				connectionResult.getMeterMake());
		if (aparato == null) {
			throw new DataIntegrityException("Meter does not exist");
		}

		if (!aparato.getEstApa()
				.equalsIgnoreCase(env.getProperty("application.aparato.est.apa.issue.for.installation.value"))) {
			throw new DataIntegrityException("Meter not issued for installation");
		}

		// validate ims installation number
		// Long imsInstallation = nativeQueriesRepository
		// .findNroInstalacionFromSgdInstalacion(connectionResult.getImsInstallationCode());
		//
		// if (imsInstallation == null) {
		// throw new DataIntegrityException("Incorrect installation code.");
		// }

	}

	@Transactional(rollbackFor = { Exception.class })
	private Expediente processToConnectionInProgress(ConnectionResult connectionResult) {
		final Expediente expediente = prepareExpediente(connectionResult);

		// update expedientes
		expediente.setEstado(env.getProperty("application.stage.connection.in.progress.value"));
		expedienteRepository.save(expediente);

		// insert into exped_comm
		final ExpedComm expedComm = prepareExpedComm(connectionResult);
		expedCommRepository.save(expedComm);

		// insert into actividades
		final Actividade actividade = prepareActividades(expediente,
				env.getProperty("application.stage.connection.in.progress.value"));
		actividade.setComentAct(connectionResult.getConnectionComment());
		actividadeRepository.save(actividade);

		// update sum_exp
		final SumExp sumExp = prepareSumExp(expediente);
		sumExpRepository.save(sumExp);

		return expediente;
	}

	@Transactional(rollbackFor = { Exception.class })
	private void resolveSiteInspectionServiceOrder(final ConnectionResult connectionResult) {
		// issue service order & update to resolved
		// update trapendAf
		final TrabpendAf trabpendAf = prepareTrapendAf(connectionResult.getIopenApplication().getExpediente());
		if (trabpendAf != null) {
			trabpendAfRepository.save(trabpendAf);
		}

		// insert into visita
		final Visita visita = prepareVisita(connectionResult);
		visitaRepository.save(visita);

		// update Orderne
		final Ordene ordene = prepareOrdenes(connectionResult.getIopenApplication().getExpediente());
		ordeneRepository.save(ordene);

	}

	@Transactional(rollbackFor = { Exception.class })
	private Suministro createServicePoint(ConnectionResult connectionResult) {
		final Expediente expediente = prepareExpediente(connectionResult);

		// insert into suministros
		final Suministro suministro = prepareSuministro(connectionResult);
		suministroRepository.save(suministro);

		// update exped_comm
		final ExpedComm expedComm = expedCommRepository.findExpedCommByIdNumExpAndIdNumApaAndIdCoMarcaAndCgvSum(
				expediente.getNumExp(), connectionResult.getMeterNumber(), connectionResult.getMeterMake(),
				connectionResult.getFloorNumber());

		expedComm.setNumSum(BigDecimal.valueOf(suministro.getNumSum()));
		expedComm.setFActual(new Date());
		expedComm.setUsuario(ApplicationDefault.getDatabaseUser());
		expedComm.setPrograma(ApplicationDefault.getProgram());

		expedCommRepository.save(expedComm);

		// update expedientes 17015
		expediente.setEstado(env.getProperty("application.stage.service.point.created.value"));
		expedienteRepository.save(expediente);

		// insert into actividades 17007
		final Actividade commissionedActividade = prepareActividades(expediente,
				env.getProperty("application.stage.commisioned.value"));
		actividadeRepository.save(commissionedActividade);

		// insert into actividades 17015
		final Actividade servicePointCreatedActividade = prepareActividades(expediente,
				env.getProperty("application.stage.service.point.created.value"));
		actividadeRepository.save(servicePointCreatedActividade);

		return suministro;
	}

	@Transactional(rollbackFor = { Exception.class })
	private void installMeter(ConnectionResult connectionResult, Suministro suministro) throws Exception {

		// update APARATOS
		final Aparato aparato = prepareAparatos(connectionResult);
		aparato.setNumSum(BigDecimal.valueOf(suministro.getNumSum()));
		aparato.setNifApa(suministro.getNif());
		aparatoRepository.save(aparato);

		// TODO insert into APMEDIDA_AP update APMEDIDA_AP
		final ApmedidaAp apmedidaAp = prepareApmedidaAp(suministro, aparato);
		final Long idApa = apmedidaApRepository.getNextIdApa();
		apmedidaAp.setIdApa(idApa);
		apmedidaAp.setNumMrsp(BigDecimal.valueOf(connectionResult.getMrDiv()));
		// SMA/UMESCI-732 -20170506
		apmedidaAp.setAolApa(new BigDecimal(env.getProperty("suminstro.rso.default.value")));
		apmedidaAp.setTipNatur(connectionResult.getReadingNature());
		apmedidaApRepository.save(apmedidaAp);

		// TODO insert into APMEDIDA_CO
		final ApmedidaCo apmedidaCo = prepareApmedidaCo(apmedidaAp);

		final long csmo = connectionResult.getMeterInitialReading() * connectionResult.getLossCoefficient();

		final Long idReg = apmedidaCoRepository.getNextIdApaCo();
		apmedidaCo.setIdReg(idReg);
		apmedidaCo.setCsmo(BigDecimal.valueOf(csmo));
		apmedidaCo.setCteCsmo(BigDecimal.valueOf(connectionResult.getMeterConstant()));
		apmedidaCo.setCoefPer(BigDecimal.valueOf(connectionResult.getLossCoefficient()));
		apmedidaCo.setLect(BigDecimal.valueOf(connectionResult.getMeterInitialReading()));
		apmedidaCo.setNumRue(BigDecimal.valueOf(connectionResult.getNoOfDials()));
		apmedidaCoRepository.save(apmedidaCo);

		// update SUMINISTRO_TIP_CSMO to cancel previous ones
		suministroTipCsmoRepository.save(prepareSuministrosTipCsmoToCancel(suministro.getNumSum()));

		// insert into SUMINISTRO_TIP_CSMO a new one
		final SuministroTipCsmo suministroTipCsmo = prepareSuministrosTipCsmoToInsert(suministro.getNumSum(),
				apmedidaAp.getIdApa());
		suministroTipCsmoRepository.save(suministroTipCsmo);

		// TODO insert into HAPARATOS
		final Haparato haparato = prepareHaparato(aparato);
		haparatoRepository.save(haparato);

	}

	@Transactional(rollbackFor = { Exception.class })
	private void createService(ConnectionResult connectionResult, Suministro suministro) throws Exception {

		// insert into sumcon
		final Sumcon sumcon = prepareSumcon(connectionResult, suministro);
		sumconRepository.save(sumcon);
		// insert into GR_CONSUMO_CONTRATADO
		final GrConsumoContratado grConsumoContratado = prepareGrConsumoContratado(sumcon);
		grConsumoContratadoRepository.save(grConsumoContratado);
		// insert into CONSUMO_CONTRATADO
		final ConsumoContratado consumoContratado = prepareConsumoContratado(grConsumoContratado);
		consumoContratadoRepository.save(consumoContratado);
		// insert into sumcon_retail_access
		final SumconRetailAccess sumconRetailAccess = prepareSumconRetailAccess(sumcon);
		sumconRetailAccessRepository.save(sumconRetailAccess);
		// insert into PAYING_ACCOUNT
		final PayingAccount payingAccount = preparePayingAccount(sumcon);
		payingAccountRepository.save(payingAccount);
		// INSERT INTO BILL_DISPATCH
		final BillDispatch billDispatch = prepareBillDispatch(sumcon);
		billDispatchRepository.save(billDispatch);
	}

	private SumconRetailAccess prepareSumconRetailAccess(Sumcon sumcon) {
		final Date now = new Date();
		final SumconRetailAccess sumconRetailAccess = new SumconRetailAccess();
		sumconRetailAccess.setUsuario(ApplicationDefault.getDatabaseUser());
		sumconRetailAccess.setPrograma(ApplicationDefault.getProgram());
		sumconRetailAccess.setFActual(now);
		sumconRetailAccess.setCodEmpresaEsp(
				new BigDecimal(env.getProperty("application.sumconretailaccess.cod_empresa_esp.default.value")));
		sumconRetailAccess.setCodEmpresaMdma(
				new BigDecimal(env.getProperty("application.sumconretailaccess.cod_empresa_mdma.default.value")));
		sumconRetailAccess.setCodEmpresaMsp(
				new BigDecimal(env.getProperty("application.sumconretailaccess.cod_empresa_msp.default.value")));
		sumconRetailAccess.setCodEmpresaUdc(
				new BigDecimal(env.getProperty("application.sumconretailaccess.cod_empresa_udc.default.value")));
		sumconRetailAccess.setFechaMod(now);
		sumconRetailAccess.setNisRad(new BigDecimal(sumcon.getNisRad()));
		sumconRetailAccess.setNisRadConsol(new BigDecimal(0));
		sumconRetailAccess.setNumSum(sumcon.getNumSum());
		sumconRetailAccess
		.setSecNis(new BigDecimal(env.getProperty("application.sumconretailaccess.sec_nis.default.value")));

		sumconRetailAccess.setTipConsolid(env.getProperty("application.sumconretailaccess.tip_consolid.default.value"));
		sumconRetailAccess.setTipRequest(env.getProperty("application.sumconretailaccess.tip_request.default.value"));

		return sumconRetailAccess;
	}

	private PayingAccount preparePayingAccount(Sumcon sumcon) throws Exception {
		final Date now = new Date();
		final PayingAccount payingAccount = new PayingAccount();
		final InvGroup invgroup = invGroupRepository.findByCodCta(sumcon.getCodCta());
		payingAccount.setIgId(new BigDecimal(invgroup.getIgId()));
		payingAccount.setFActual(now);
		payingAccount.setUsuario(ApplicationDefault.getDatabaseUser());
		payingAccount.setPrograma(ApplicationDefault.getProgram());
		payingAccount.setNisRad(new BigDecimal(sumcon.getNisRad()));
		payingAccount.setCodCta(sumcon.getCodCta());
		payingAccount.setFPayingDesde(now);
		payingAccount.setFPayingHasta(new SimpleDateFormat("yyyyMMdd").parse("29991231"));
		payingAccount
		.setIndExempt(new BigDecimal(env.getProperty("application.payingaccount.ind_exempt.default.value")));
		payingAccount.setIndPrinc(new BigDecimal(env.getProperty("application.payingaccount.ind_princ.default.value")));
		payingAccount.setShLimit(new BigDecimal(env.getProperty("application.payingaccount.sh_limit.default.value")));
		payingAccount.setShPerc(new BigDecimal(env.getProperty("application.payingaccount.sh_perc.default.value")));

		return payingAccount;
	}

	private BillDispatch prepareBillDispatch(Sumcon sumcon) {
		final BillDispatch billDispatch = new BillDispatch();
		final BillDispatchPK billDispatchPK = new BillDispatchPK();
		billDispatchPK.setNisRad(sumcon.getNisRad());
		billDispatchPK.setTipDispatch(env.getProperty("application.billdispatch.tip_dispatch.default.value"));
		billDispatch.setId(billDispatchPK);
		billDispatch.setFActual(new Date());
		billDispatch.setPrograma(ApplicationDefault.getProgram());
		billDispatch.setUsuario(ApplicationDefault.getDatabaseUser());
		billDispatch.setBdStatus(" ");
		return billDispatch;
	}

	private ConsumoContratado prepareConsumoContratado(GrConsumoContratado grConsumoContratado) {
		final ConsumoContratado consumoContratado = new ConsumoContratado();
		final ConsumoContratadoPK consumoContratadoPK = new ConsumoContratadoPK();
		consumoContratadoPK.setTipCsmoBloque(env.getProperty("application.consumocontratado.tip_csmo_bloque"));
		consumoContratadoPK.setNumBloque(Long.valueOf(0));
		consumoContratadoPK.setIdGrConsumoContratado(grConsumoContratado.getIdGrConsumoContratado());
		consumoContratado.setId(consumoContratadoPK);
		consumoContratado.setUsuario(ApplicationDefault.getDatabaseUser());
		consumoContratado.setPrograma(ApplicationDefault.getProgram());
		consumoContratado.setTipCsmo(env.getProperty("application.consumocontratado.tip_csmo"));
		consumoContratado.setFActual(new Date());

		return consumoContratado;
	}

	private GrConsumoContratado prepareGrConsumoContratado(Sumcon sumcon) throws Exception {
		final GrConsumoContratado grConsumoContratado = new GrConsumoContratado();
		final Date now = new Date();
		grConsumoContratado.setUsuario(ApplicationDefault.getDatabaseUser());
		grConsumoContratado.setPrograma(ApplicationDefault.getProgram());
		grConsumoContratado.setFActual(now);
		// grConsumoContratado.setIdGrConsumoContratado(idGrConsumoContratado);
		grConsumoContratado.setNisRad(new BigDecimal(sumcon.getNisRad()));
		grConsumoContratado.setNumSum(sumcon.getNumSum());
		grConsumoContratado.setFAltaReal(sumcon.getFAlta());
		grConsumoContratado.setFAlta(sumcon.getFAlta());
		grConsumoContratado.setFBaja(new SimpleDateFormat("yyyyMMdd").parse("29991231"));
		grConsumoContratado.setFBajaReal(new SimpleDateFormat("yyyyMMdd").parse("29991231"));
		grConsumoContratado.setIdEstacionalidad(new BigDecimal(1));
		grConsumoContratado.setIdLoadshape(sumcon.getLoadshapeId());
		return grConsumoContratado;
	}

	private Sumcon prepareSumcon(ConnectionResult connectionResult, Suministro suministro) throws Exception {
		final Sumcon sumcon = new Sumcon();
		final Date now = new Date();
		final Cliente cliente = clienteRepository
				.findById(connectionResult.getIopenApplication().getExpediente().getCodCliS().longValue());

		final CuentasCu cuentasCu = cuentasCuRepository.findCuentasCuByCodCli(BigDecimal.valueOf(cliente.getCodCli()));

		final FincasExp fincasExp = fincasExpRepository
				.findMaxSecIdByNumExp(connectionResult.getIopenApplication().getExpediente().getNumExp());

		sumcon.setUsuario(ApplicationDefault.getDatabaseUser());
		sumcon.setFActual(now);
		sumcon.setPrograma(ApplicationDefault.getProgram());
		final long nisRad = sumconRepository.getNextNisRadValue();
		sumcon.setNisRad(nisRad);
		sumcon.setSecNis(new BigDecimal(0));

		sumcon.setTipServ(env.getProperty("application.sumcon.tip.serv.default.value"));
		sumcon.setEstServ(env.getProperty("application.sumcon.est.serv.active.pending.billing.value"));
		sumcon.setCoMotivo(" ");
		sumcon.setNumSum(BigDecimal.valueOf(suministro.getNumSum()));
		sumcon.setNic(new BigDecimal(0));
		sumcon.setCodCnae(cliente.getCodCnae());

		sumcon.setCodEmpresaOperativa(
				new BigDecimal(env.getProperty("application.sumcon.cod.empresa.operativa.default.value")));
		sumcon.setCodEmpresaProveedora(
				new BigDecimal(env.getProperty("application.sumcon.cod.empresa.proveedora.default.value")));
		sumcon.setCodCli(BigDecimal.valueOf(cliente.getCodCli()));
		sumcon.setTipUso("UT" + connectionResult.getRecommendedTariff().toString());
		sumcon.setCodCta(BigDecimal.valueOf(cuentasCu.getCodCta()));

		sumcon.setCodCliAccHold(BigDecimal.valueOf(cliente.getCodCli()));
		sumcon.setNif(BigDecimal.valueOf(fincasExp.getId().getNif()));
		sumcon.setCgvServ(suministro.getCgvSum());

		sumcon.setNisSolidario(new BigDecimal(0));
		sumcon.setSecNisSolidario(new BigDecimal(0));
		sumcon.setCodCliSolidario(new BigDecimal(0));
		sumcon.setFAltaCont(now);
		sumcon.setCoFacturacion(env.getProperty("application.sumcon.co_facturacion.default.value"));
		sumcon.setTipPerFact(env.getProperty("application.sumcon.tip_per_fact.default.value"));
		sumcon.setTipConexionCd(env.getProperty("application.sumcon.tip_conexion_cd.default.value"));
		//
		sumcon.setTipContr(env.getProperty("application.sumcon.tip_contr.default.value"));
		sumcon.setIndConvertRa(new BigDecimal(2));
		sumcon.setIndEventual(new BigDecimal(2));
		sumcon.setCodUnicom(suministro.getCodUnicom());
		sumcon.setCoAnVip(env.getProperty("application.sumcon.co_an_vip.default.value"));
		sumcon.setImpDerechosConex(new BigDecimal(0));
		sumcon.setImpDerechosConexPagado(new BigDecimal(0));
		sumcon.setCantFijaCobro(new BigDecimal(0));
		sumcon.setTipMulta(env.getProperty("application.sumcon.tip.multa.default.value"));
		sumcon.setTasaMulta(new BigDecimal(env.getProperty("application.sumcon.tasa_multa.default.value")));
		sumcon.setTipRecargo(env.getProperty("application.sumcon.tip.recargo.default.value"));
		sumcon.setTasaRecargo(new BigDecimal(env.getProperty("application.sumcon.tasa_recargo.default.value")));
		sumcon.setCodTar(connectionResult.getRecommendedTariff());
		sumcon.setGrConcepto(connectionResult.getTariffItemGroup());
		sumcon.setCodTarAdicional(" ");
		//
		sumcon.setGrConceptoAdicional(new BigDecimal(0));
		sumcon.setFAlta(now);
		sumcon.setFModServ(now);
		sumcon.setFCorrServ(now);
		sumcon.setFBajaServ(cliente.getFBaja());
		sumcon.setFCorteServ(new SimpleDateFormat("yyyyMMdd").parse("29991231"));
		sumcon.setFResCont(now);
		sumcon.setFPosibleRevision(new SimpleDateFormat("yyyyMMdd").parse("29991231"));
		sumcon.setFReenganche(new SimpleDateFormat("yyyyMMdd").parse("29991231"));
		sumcon.setPot(" ");
		sumcon.setPotPenal(new BigDecimal(0));
		sumcon.setCsmoFijo(new BigDecimal(0));
		sumcon.setHoraUtil(new BigDecimal(0));
		sumcon.setCoAsignacion(env.getProperty("application.sumcon.co_asignacion.default.value"));
		sumcon.setCoCondFiscal(env.getProperty("application.sumcon.co_cond_fiscal.default.value"));
		sumcon.setCoEstm(env.getProperty("application.sumcon.co_estm.default.value"));
		sumcon.setEstmAnual(new BigDecimal(0));
		sumcon.setEstmCons(new BigDecimal(0));
		//
		sumcon.setContTransPot(new BigDecimal(0));
		sumcon.setFTransPot(new SimpleDateFormat("yyyyMMdd").parse("29991231"));
		sumcon.setIndAnNodet(new BigDecimal(1));
		sumcon.setIndBonif(new BigDecimal(2));
		sumcon.setGrupoFamil(new BigDecimal(0));
		sumcon.setIndEstacion(new BigDecimal(2));
		sumcon.setBocasContraincendio(new BigDecimal(0));
		sumcon.setImpPrecDefecto(new BigDecimal(0));
		sumcon.setNumCort(new BigDecimal(0));
		sumcon.setIndCortable(new BigDecimal(1));
		sumcon.setCoMotnocort(env.getProperty("application.sumcon.co_mot_no_cot.default.value"));
		sumcon.setRespNoCort(" ");
		sumcon.setCoModoPago(" ");
		sumcon.setCantSumSer(new BigDecimal(0));
		sumcon.setFechaProximaFac(new SimpleDateFormat("yyyyMMdd").parse("29991231"));
		sumcon.setTipCalendario(env.getProperty("application.sumcon.tip.calendrio.default.value"));
		//
		sumcon.setIndGastosAdicionales(new BigDecimal(2));
		sumcon.setCoPerfilUtilizacion(" ");
		sumcon.setNisRadPte(new BigDecimal(0));
		sumcon.setFAlta(now);
		sumcon.setLoadshapeId(new BigDecimal(0));
		sumcon.setUsrNumber1(new BigDecimal(1));
		sumcon.setUsrNumber2(new BigDecimal(0));
		sumcon.setUsrNumber3(new BigDecimal(9999));
		sumcon.setUsrNumber4(new BigDecimal(0));
		sumcon.setUsrNumber5(new BigDecimal(0));
		sumcon.setUsrVarchar1(" ");
		sumcon.setUsrVarchar2(" ");
		sumcon.setUsrVarchar3("0");
		sumcon.setUsrDatetime1(now);
		sumcon.setUsrDatetime2(new SimpleDateFormat("yyyyMMdd").parse("29991231"));
		return sumcon;
	}

	private SuministroTipCsmo prepareSuministrosTipCsmoToInsert(long numSum, long idApa) throws Exception {
		final SuministroTipCsmo suministroTipCsmo = new SuministroTipCsmo();
		final SuministroTipCsmoPK suministroTipCsmoPK = new SuministroTipCsmoPK();

		suministroTipCsmoPK.setIdApa(idApa);
		suministroTipCsmoPK.setNumSum(numSum);
		suministroTipCsmoPK.setTipCsmo(env.getProperty("application.suministro.tip.csmo.tip.csmo.energy.value"));
		suministroTipCsmo.setId(suministroTipCsmoPK);
		suministroTipCsmo.setFAlta(new Date());
		suministroTipCsmo.setFBaja(new SimpleDateFormat("yyyyMMdd").parse("29991231"));

		suministroTipCsmo.setUsuario(ApplicationDefault.getDatabaseUser());
		suministroTipCsmo.setFActual(new Date());
		suministroTipCsmo.setPrograma(ApplicationDefault.getProgram());

		return suministroTipCsmo;
	}

	private List<SuministroTipCsmo> prepareSuministrosTipCsmoToCancel(long numSum) {
		final List<SuministroTipCsmo> suministroTipCsmos = suministroTipCsmoRepository
				.findSuministroTipCsmoByIdNumSumAndIdTipCsmoAndFBajaGreaterThan(numSum,
						env.getProperty("application.suministro.tip.csmo.tip.csmo.energy.value"), new Date());

		for (int i = 0; i < suministroTipCsmos.size(); i++) {
			suministroTipCsmos.get(i).setFBaja(new Date());
			suministroTipCsmos.get(i).setUsuario(ApplicationDefault.getDatabaseUser());
			suministroTipCsmos.get(i).setFActual(new Date());
			suministroTipCsmos.get(i).setPrograma(ApplicationDefault.getProgram());
		}

		return suministroTipCsmos;

	}

	private Aparato prepareAparatos(ConnectionResult connectionResult) throws Exception {
		final Aparato aparato = aparatoRepository.findAparatoByIdNumApaAndIdCoMarca(connectionResult.getMeterNumber(),
				connectionResult.getMeterMake());
		if (aparato == null) {
			throw new DataIntegrityException("invalid meter number or make");
		}
		aparato.setEstApa(env.getProperty("application.aparato.est.apa.installed.value"));
		aparato.setUsuario(ApplicationDefault.getDatabaseUser());
		aparato.setPrograma(ApplicationDefault.getProgram());
		aparato.setFActual(new Date());

		return aparato;
	}

	private Haparato prepareHaparato(Aparato aparato) {
		final Haparato haparato = new Haparato();

		final HaparatoPK haparatoPK = new HaparatoPK();
		haparatoPK.setNumApa(aparato.getId().getNumApa());
		haparatoPK.setCoMarca(aparato.getId().getCoMarca());
		haparatoPK.setFCambio(new Date());

		haparato.setId(haparatoPK);

		haparato.setUsuario(ApplicationDefault.getDatabaseUser());
		haparato.setFActual(new Date());
		haparato.setPrograma(ApplicationDefault.getProgram());
		haparato.setEstApa(aparato.getEstApa());
		haparato.setCodAlmacen(aparato.getCodAlmacen());
		haparato.setNumLote(aparato.getNumLote());
		haparato.setNumSum(aparato.getNumSum());
		haparato.setNifApa(aparato.getNifApa());
		haparato.setSecPm(aparato.getSecPm());
		haparato.setNumPrecin(aparato.getNumPrecin());

		return haparato;
	}

	private ApmedidaCo prepareApmedidaCo(ApmedidaAp apmedidaAp) throws Exception {
		final ApmedidaCo apmedidaCo = new ApmedidaCo();

		// PROGRAMA,ID_REG,ID_APA,TIP_CSMO,F_LECT,F_MOD_LECT,EST_CSMO,IND_LECT,CTE_APA,
		// TIP_LECT,LECT,DIF_LECT,CSMO,CTE_CSMO,NUM_RUE,COEF_PER,NUM_SUM,F_CSMO_DESDE,GRUP_PER
		apmedidaCo.setPrograma(ApplicationDefault.getProgram());
		apmedidaCo.setUsuario(ApplicationDefault.getDatabaseUser());
		apmedidaCo.setFActual(new Date());

		// apmedidaCo.setIdReg(idReg);

		apmedidaCo.setIdApa(BigDecimal.valueOf(apmedidaAp.getIdApa()));

		apmedidaCo.setTipCsmo(env.getProperty("application.suministro.tip.csmo.tip.csmo.energy.value"));
		apmedidaCo.setFLect(new Date());
		apmedidaCo.setFModLect(new SimpleDateFormat("yyyyMMdd").parse("29991231"));

		apmedidaCo.setNumSum(apmedidaAp.getNumSum());
		apmedidaCo.setCteApa(apmedidaAp.getCteApa());

		apmedidaCo.setEstCsmo(env.getProperty("application.apmedida.co.est.csmo.valid.usage.value"));
		apmedidaCo.setIndLect(new BigDecimal(env.getProperty("application.apmedida.co.ind.lect.default.value")));

		apmedidaCo.setTipLect(env.getProperty("application.apmedida.co.tip.lect.meter.installation.value"));

		apmedidaCo.setFCsmoDesde(new SimpleDateFormat("yyyyMMdd").parse("29991231"));
		apmedidaCo.setGrupPer(new BigDecimal(0));
		apmedidaCo.setDifLect(new BigDecimal(0));

		return apmedidaCo;

	}

	private ApmedidaAp prepareApmedidaAp(Suministro suministro, Aparato aparato) throws Exception {
		final ApmedidaAp apmedidaAp = new ApmedidaAp();

		final ApaTipCarac apaTipCarac = apaTipCaracRepository.findApaTipCaracByIdTipApaAndIdCoMarcaAndIdCoModelo(
				aparato.getTipApa(), aparato.getId().getCoMarca(), aparato.getCoModelo());

		// find fincas
		final Fincas finca = fincasRepository.findOne(suministro.getNif().longValue());
		// find puntomed
		final Puntomed puntomed = puntomedRepository.findPuntomedByIdNifAndMaxIdSecPm(suministro.getNif().longValue());

		apmedidaAp.setUsuario(ApplicationDefault.getDatabaseUser());
		apmedidaAp.setFActual(new Date());
		apmedidaAp.setPrograma(ApplicationDefault.getProgram());

		/* TODO Empty to be investigated further */
		apmedidaAp.setEstado(" ");
		apmedidaAp.setCiudad(" ");
		apmedidaAp.setDireccion(" ");
		apmedidaAp.setCodPostal(" ");
		apmedidaAp.setCodPostalExt(" ");
		apmedidaAp.setRefDir(" ");
		apmedidaAp.setAccFinca(" ");
		apmedidaAp.setNumApaOld(" ");
		apmedidaAp.setTfno(" ");
		apmedidaAp.setNumItin(new BigDecimal(0));
		apmedidaAp.setAolFinca(new BigDecimal(0));
		apmedidaAp.setAccPm(" ");
		/* End */

		apmedidaAp.setDuplicador(finca.getDuplicador());
		apmedidaAp.setCgvPm(puntomed.getCgvPm());
		apmedidaAp.setAolPm(puntomed.getAolPm());
		apmedidaAp.setSecPm(BigDecimal.valueOf(puntomed.getId().getSecPm()));
		apmedidaAp.setNumPuerta(finca.getNumPuerta());

		apmedidaAp.setNumApa(aparato.getId().getNumApa());
		apmedidaAp.setCoMarca(aparato.getId().getCoMarca());
		apmedidaAp.setCoModelo(aparato.getCoModelo());

		apmedidaAp.setTipProducto(env.getProperty("application.suministro.tip.producto.electricity.value"));
		apmedidaAp.setEstApa(env.getProperty("application.apmedida.ap.est.apa.normal.value"));
		apmedidaAp.setNumSum(aparato.getNumSum());
		apmedidaAp.setNifApa(aparato.getNifApa());
		apmedidaAp.setNumPrecin(aparato.getNumPrecin());
		apmedidaAp.setTipApa(aparato.getTipApa());
		apmedidaAp.setCoPropApa(aparato.getCoPropApa());
		apmedidaAp.setFProxCalibracion(aparato.getFProxCalibracion());
		apmedidaAp.setFProxVerificacion(aparato.getFProxVerificacion());
		apmedidaAp.setTipPerLect(suministro.getTipPerLect());
		apmedidaAp.setTipTension(suministro.getTipTension());
		apmedidaAp.setTipFase(suministro.getTipFase());
		apmedidaAp.setIndPrecin(new BigDecimal(env.getProperty("application.apmedida.ap.ind.precin.default.value")));
		apmedidaAp.setFPrecin(new SimpleDateFormat("yyyyMMdd").parse("29991231"));
		apmedidaAp.setTipIntensidad(apaTipCarac.getTipIntensidad());
		apmedidaAp.setTipMaterial(apaTipCarac.getTipMaterial());
		apmedidaAp.setRegulador(apaTipCarac.getRegulador());
		apmedidaAp.setIdEmpProp(new BigDecimal(env.getProperty("application.apmedida.ap.id.emp.prop.default.value")));
		apmedidaAp.setCteApa(apaTipCarac.getCteApa());
		apmedidaAp.setDimenConex(apaTipCarac.getDimenConex());
		apmedidaAp.setDiametro(apaTipCarac.getDiametro());
		apmedidaAp.setFFabric(aparato.getFFabric());
		apmedidaAp.setFInst(new Date());
		apmedidaAp.setFUrevis(new Date());

		return apmedidaAp;
	}

	private Suministro prepareSuministro(ConnectionResult connectionResult) {
		final Suministro suministro = new Suministro();

		// suministro.setNumSum(numSum);
		suministro.setNumExp(connectionResult.getIopenApplication().getExpediente().getNumExp());
		suministro.setTipSuministro(connectionResult.getServicePointType());
		suministro.setTipPerLect(connectionResult.getReadingPeriod());
		suministro.setTipConexion(connectionResult.getConnectionType());
		suministro.setTipTension(connectionResult.getVoltageType());
		suministro.setTipFase(connectionResult.getPhaseType());
		suministro.setTipAsoc(connectionResult.getAssociationType());
		suministro.setCgvSum(connectionResult.getFloorNumber());
		suministro.setPotMaxAdmis(BigDecimal.valueOf(connectionResult.getContPower()));
		suministro.setCodTafRec(connectionResult.getRecommendedTariff());
		suministro.setNumAcometida(BigDecimal.valueOf(connectionResult.getImsInstallationCode()));
		// SMA/UMESCI-732 -20170506
		suministro.setCoEstm(env.getProperty("suministro.estimation.method.default.value"));
		suministro.setCodUnicom(connectionResult.getIopenApplication().getExpediente().getCodUnicomCompet());
		suministro.setUsrNumber3(new BigDecimal(env.getProperty("suministro.fuse.default.value")));
		suministro.setUsrNumber1(BigDecimal.valueOf(connectionResult.getDepositPaid()));
		final Calendar calendar = Calendar.getInstance();
		calendar.set(2999, 11, 31);
		suministro.setUsrDatetime1(calendar.getTime());
		suministro.setUsrDatetime2(calendar.getTime());
		suministro.setUsrDatetime3(calendar.getTime());
		suministro.setUsrNumber2(new BigDecimal(0));
		suministro.setUsrVarchar1(" ");
		suministro.setUsrVarchar3(" ");
		suministro.setUsrVarchar2(connectionResult.getIopenApplication().getGps());
		suministro.setNif(BigDecimal.valueOf(fincasExpRepository
				.findMaxSecIdByNumExp(connectionResult.getIopenApplication().getExpediente().getNumExp()).getId()
				.getNif()));

		suministro.setUsuario(ApplicationDefault.getDatabaseUser());
		suministro.setFActual(new Date());
		suministro.setPrograma(ApplicationDefault.getProgram());
		suministro.setEstSum(env.getProperty("application.suministro.est.sum.connected.value"));
		suministro.setNumSumUdc(" ");
		suministro.setTipProducto(env.getProperty("application.suministro.tip.producto.electricity.value"));

		suministro.setEmpresaProd(
				BigDecimal.valueOf(Long.valueOf(env.getProperty("application.suministro.empresa.prod.default.value"))));
		suministro.setDiametroConex(BigDecimal
				.valueOf(Long.valueOf(env.getProperty("application.suministro.diametro.conex.default.value"))));
		suministro.setNumPuntoClimatico(BigDecimal
				.valueOf(Long.valueOf(env.getProperty("application.suministro.num.punto.climatico.default.value"))));
		suministro.setIndModifLect(BigDecimal
				.valueOf(Long.valueOf(env.getProperty("application.suministro.ind.modif.lect.default.value"))));
		suministro.setNumLectNecesarias(BigDecimal
				.valueOf(Long.valueOf(env.getProperty("application.suministro.num.lect.necesarias.default.value"))));
		suministro.setContLectDif(BigDecimal
				.valueOf(Long.valueOf(env.getProperty("application.suministro.cont.lect.dif.default.value"))));
		suministro.setContLectRep(BigDecimal
				.valueOf(Long.valueOf(env.getProperty("application.suministro.cont.lect.rep.default.value"))));
		suministro.setIndLvto(
				BigDecimal.valueOf(Long.valueOf(env.getProperty("application.suministro.ind.lvto.default.value"))));
		suministro.setAusCons(
				BigDecimal.valueOf(Long.valueOf(env.getProperty("application.suministro.aus.cons.default.value"))));
		suministro.setIndAnNodet(
				BigDecimal.valueOf(Long.valueOf(env.getProperty("application.suministro.ind.an.nodet.default.value"))));
		suministro.setIndCsmoAdicional(BigDecimal
				.valueOf(Long.valueOf(env.getProperty("application.suministro.ind.csmo.adicional.default.value"))));
		suministro.setIndLectPropia(BigDecimal
				.valueOf(Long.valueOf(env.getProperty("application.suministro.ind.lect.propia.default.value"))));

		return suministro;
	}

	private Expediente prepareExpediente(ConnectionResult connectionResult) {
		final Expediente expediente = expedienteRepository
				.findById(connectionResult.getIopenApplication().getExpediente().getNumExp());

		expediente.setFUce(new Date());
		expediente.setFActual(new Date());
		expediente.setUsuario(ApplicationDefault.getDatabaseUser());
		expediente.setPrograma(ApplicationDefault.getProgram());

		return expediente;
	}

	private SumExp prepareSumExp(Expediente expediente) {
		final SumExp sumExp = sumExpRepository.findSumExpByIdNumExp(expediente.getNumExp());

		sumExp.setCantSum(new BigDecimal(1));
		sumExp.setFActual(new Date());
		sumExp.setUsuario(ApplicationDefault.getDatabaseUser());
		sumExp.setPrograma(ApplicationDefault.getProgram());

		return sumExp;
	}

	private ExpedComm prepareExpedComm(ConnectionResult connectionResult) {
		final ExpedComm expedComm = new ExpedComm();

		final ExpedCommPK expedCommPK = new ExpedCommPK();
		expedCommPK.setNumExp(connectionResult.getIopenApplication().getExpediente().getNumExp());
		expedCommPK.setNumApa(connectionResult.getMeterNumber());
		expedCommPK.setCoMarca(connectionResult.getMeterMake());
		expedComm.setId(expedCommPK);

		expedComm.setCgvSum(connectionResult.getFloorNumber());
		expedComm.setNumRue(BigDecimal.valueOf(connectionResult.getNoOfDials()));
		expedComm.setNroAco(BigDecimal.valueOf(connectionResult.getImsInstallationCode()));
		expedComm.setLectIni(BigDecimal.valueOf(connectionResult.getMeterInitialReading()));
		expedComm.setNumSum(new BigDecimal(0));

		expedComm.setFActual(new Date());
		expedComm.setUsuario(ApplicationDefault.getDatabaseUser());
		expedComm.setPrograma(ApplicationDefault.getProgram());

		return expedComm;
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

	private Visita prepareVisita(final ConnectionResult connectionResult) {
		final Visita visita = new Visita();

		final VisitaPK visitaPK = new VisitaPK();
		visitaPK.setCoAcceje(env.getProperty("application.visita.connection.value"));
		visitaPK.setFVis(connectionResult.getConnectionDate());
		visitaPK.setNumOs(connectionResult.getIopenApplication().getExpediente().getNumOs().longValue());
		visita.setId(visitaPK);

		visita.setUsuario(ApplicationDefault.getDatabaseUser());
		visita.setFActual(new Date());
		visita.setPrograma(ApplicationDefault.getProgram());

		visita.setCodEmp(BigDecimal.valueOf(connectionResult.getConnectionByEmployeeCode()));
		visita.setHoraVisFin(BigDecimal.valueOf(connectionResult.getConnectionTime()));
		visita.setHoraVisIni(BigDecimal.valueOf(connectionResult.getConnectionTime()));
		visita.setObservaciones(connectionResult.getConnectionComment());
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
		actividade.setEstAct(ApplicationDefault.getActividadesestAct());

		return actividade;

	}
}
