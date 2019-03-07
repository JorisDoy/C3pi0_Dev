package com.indra.iopen.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.indra.iopen.model.Actividade;
import com.indra.iopen.model.ActividadePK;
import com.indra.iopen.model.CosteExp;
import com.indra.iopen.model.Expediente;
import com.indra.iopen.model.IopenApplication;
import com.indra.iopen.model.PresupuestosExped;
import com.indra.iopen.model.PresupuestosExpedPK;
import com.indra.iopen.pojo.QuotationAmount;
import com.indra.iopen.repositories.model.ActividadeRepository;
import com.indra.iopen.repositories.model.CosteExpRepository;
import com.indra.iopen.repositories.model.ExpedienteRepository;
import com.indra.iopen.repositories.model.IopenApplicationRepository;
import com.indra.iopen.repositories.model.PresupuestosExpedRepository;
import com.indra.iopen.repositories.model.ReciboRepository;
import com.indra.iopen.service.CommonService;
import com.indra.iopen.service.QuotationService;
import com.indra.iopen.util.ApplicationAdvanceType;
import com.indra.iopen.util.ApplicationDefault;

@Service
@Transactional(rollbackFor = { Exception.class })
@PropertySource("classpath:application.properties")
public class QuotationServiceImpl implements QuotationService {

	@Autowired
	private Environment env;

	@Autowired
	private CommonService commonService;

	@Autowired
	private CosteExpRepository costeExpRepository;
	@Autowired
	private ReciboRepository reciboRepository;
	@Autowired
	private PresupuestosExpedRepository presupuestosExpedRepository;
	@Autowired
	private ActividadeRepository actividadeRepository;
	@Autowired
	private ExpedienteRepository expedienteRepository;
	@Autowired
	private IopenApplicationRepository IopenApplicationRepository;

	private QuotationAmount quotationAmount;

	@Override
	public void processAllToGenerateQuotation() throws Exception {
		final List<IopenApplication> iopenApplications = IopenApplicationRepository
				.findByExpedienteEstado(env.getProperty("application.stage.inspection.passed.value"));

		for (final IopenApplication iopenApplication : iopenApplications) {
			processFromInspectionPassed(iopenApplication,null);
			System.out.println("Application No: " + iopenApplication.getExpediente().getNumExp());
		}
		// SMA 20160323 Also send quotation for applications in quotation
		// prepared state
		// SMA/UMESCI-732 -20170506
		processToQuotationSentFromQuotationPrepared();

	}

	// SMA/UMESCI-732 -20170506 start
	@Override
	public void processToQuotationSentFromQuotationPrepared() throws Exception {
		final List<IopenApplication> iopenApplications = IopenApplicationRepository
				.findByExpedienteEstado(env.getProperty("application.stage.quotation.prepared.value"));
		iopenApplications.parallelStream().filter(Objects::nonNull).forEach(iopenApplication -> {
			try {
				sendQuotation(iopenApplication);
			} catch (final Exception e) {
				e.printStackTrace();
			}

		});

	}

	@Override
	public void sendQuotation(IopenApplication iopenApplication) throws Exception {
		// send message
		final List<IopenApplication> iopenApplicationsMessage = new ArrayList<>();
		iopenApplicationsMessage.add(iopenApplication);

		quotationAmount = new QuotationAmount();
		double secDeposit = 0;
		final PresupuestosExped securityDeposit = getPresupuestosExpedSecurityDeposit(iopenApplication.getExpediente());
		if (securityDeposit != null) {
			secDeposit = securityDeposit.getCoste().doubleValue();
		}
		quotationAmount.setSecurityDeposit(secDeposit);

		double capContribution = 0;
		final PresupuestosExped capitalContribution = getPresupuestosExpedCapitalContribution(
				iopenApplication.getExpediente());
		if (capitalContribution != null) {
			capContribution = capitalContribution.getCoste().doubleValue();
		}
		double inspectionBalance = 0;
		final PresupuestosExped inspectionBalanceExped = getPresupuestosExpedBalance(iopenApplication.getExpediente());
		if (inspectionBalanceExped != null) {
			inspectionBalance = inspectionBalanceExped.getCoste().doubleValue();
		}
		quotationAmount.setCapitalContribution(capContribution);
		quotationAmount.setAlreadyPaidAmount(getAlreadyPaidAmount(iopenApplication.getExpediente().getNumExp()));
		// SMA/UMESCI-732 20170606 start
		quotationAmount.setTotalAmountPayable(inspectionBalance + capContribution + secDeposit);
		quotationAmount.setInspectionBalance(inspectionBalance);
		// SMA/UMESCI-732 20170606 end
		processToQuotationSent(iopenApplication.getExpediente());
		commonService.sendMessagesClientsToInformOfAdvanceInApplicationStatus(iopenApplicationsMessage,
				ApplicationAdvanceType.QUOTATION_SENT, quotationAmount);

	}

	// SMA/UMESCI-732 -20170506 end
	@Override
	public void processFromInspectionPassed(IopenApplication iopenApplication, PresupuestosExped inspectionBalanceEx)
			throws Exception {

		final String tipObras = env.getProperty("application.eligible.tip.obra.for.quotation.prepared");
		final List<String> predeterminedTipObras = new ArrayList<>(Arrays.asList(tipObras.split(",")));
		// final List<String> predeterminedTipObras =
		// predeterminedTipObras2.stream().filter(Objects::nonNull)
		// .map(map ->
		// String.valueOf(Integer.valueOf(map))).collect(Collectors.toList());
		Expediente expediente = iopenApplication.getExpediente();
		/*
		 * Process to quotation prepared if quotation can be generated and to
		 * quotation pending if quotation cannot be generated
		 */

		final List<IopenApplication> iopenApplications = new ArrayList<>();
		iopenApplications.add(iopenApplication);
		if (predeterminedTipObras.contains(expediente.getTipObra())) {
			expediente = processToQuotationPrepared(iopenApplication,inspectionBalanceEx);
			processToQuotationSent(expediente);
			// send message
			commonService.sendMessagesClientsToInformOfAdvanceInApplicationStatus(iopenApplications,
					ApplicationAdvanceType.QUOTATION_SENT, quotationAmount);

		} else {
			processToQuotationPending(expediente);
			// send message
			commonService.sendMessagesClientsToInformOfAdvanceInApplicationStatus(iopenApplications,
					ApplicationAdvanceType.QUOTATION_PENDING);
		}

	}

	@Transactional(rollbackFor = { Exception.class })
	private Expediente processToQuotationPrepared(IopenApplication iopenApplication, PresupuestosExped inspectionBalanceEx){
		// insert into presupuestosExpend
		// Security Deposit
		final Expediente expediente = iopenApplication.getExpediente();
		final PresupuestosExped securityDeposit = preparePresupuestosExped(expediente,
				env.getProperty("application.security.deposit.tip_mov.value"),
				getSecurityDeposit(expediente.getTipSolic()));

		presupuestosExpedRepository.save(securityDeposit);
		quotationAmount = new QuotationAmount();
		quotationAmount.setSecurityDeposit(securityDeposit.getCoste().doubleValue());
		// Capital Contribution
		final PresupuestosExped capitalContribution = preparePresupuestosExped(expediente,
				env.getProperty("application.capital.contribution.tip_mov.value"),
				getCapitalContribution(expediente.getTipObra()));

		presupuestosExpedRepository.save(capitalContribution);
		quotationAmount.setCapitalContribution(capitalContribution.getCoste().doubleValue());
		// SMA/UMESCI-732 20170606 start
		double inspectionBalance = 0;
		if(inspectionBalanceEx==null){
			final PresupuestosExped inspectionBalanceExped = getPresupuestosExpedBalance(iopenApplication.getExpediente());
			if (inspectionBalanceExped != null) {
				inspectionBalance = inspectionBalanceExped.getCoste().doubleValue();
			}}else{
				inspectionBalance=inspectionBalanceEx.getCoste().doubleValue();
			}
		quotationAmount.setInspectionBalance(inspectionBalance);
		quotationAmount.setTotalAmountPayable(inspectionBalance + capitalContribution.getCoste().doubleValue()
				+ securityDeposit.getCoste().doubleValue());
		// SMA/UMESCI-732 20170606 end

		// insert into actividade (17003)
		final Actividade actividade = prepareActividades(expediente,
				env.getProperty("application.stage.quotation.prepared.value"));

		actividadeRepository.save(actividade);

		// update expediente
		expediente.setUsuario(ApplicationDefault.getDatabaseUser());
		expediente.setPrograma(ApplicationDefault.getProgram());
		expediente.setFActual(new Date());
		expediente.setEstado(env.getProperty("application.stage.quotation.prepared.value"));
		expediente.setFUce(new Date());
		expedienteRepository.save(expediente);

		quotationAmount.setAlreadyPaidAmount(getAlreadyPaidAmount(iopenApplication.getExpediente().getNumExp()));

		return iopenApplication.getExpediente();
	}

	@Transactional(rollbackFor = { Exception.class })
	private void processToQuotationPending(Expediente expediente) {

		// insert into actividade (17003)
		final Actividade actividade = prepareActividades(expediente,
				env.getProperty("application.stage.quotation.pending.value"));

		actividadeRepository.save(actividade);

		// update expediente
		expediente.setUsuario(ApplicationDefault.getDatabaseUser());
		expediente.setPrograma(ApplicationDefault.getProgram());
		expediente.setFActual(new Date());
		expediente.setEstado(env.getProperty("application.stage.quotation.pending.value"));
		expediente.setFUce(new Date());
		expedienteRepository.save(expediente);

	}

	@Transactional(rollbackFor = { Exception.class })
	private void processToQuotationSent(Expediente expediente) {

		// insert into actividade (17004)
		final Actividade actividade = prepareActividades(expediente,
				env.getProperty("application.stage.quotation.sent.value"));

		actividadeRepository.save(actividade);

		// update expediente
		expediente.setUsuario(ApplicationDefault.getDatabaseUser());
		expediente.setPrograma(ApplicationDefault.getProgram());
		expediente.setFActual(new Date());
		expediente.setEstado(env.getProperty("application.stage.quotation.sent.value"));
		expediente.setFUce(new Date());
		expedienteRepository.save(expediente);
	}

	// SMA/UMESCI-732 20170606 start
	// SMA 20160323 start
	private PresupuestosExped getPresupuestosExpedSecurityDeposit(Expediente expediente) {
		return presupuestosExpedRepository.findPresupuestosExpedByIdNumExpAndTipMovAndEstado(expediente.getNumExp(),
				env.getProperty("application.security.deposit.tip_mov.value"),
				env.getProperty("application.default.presupestos_exped.estado.value"));
	}

	private PresupuestosExped getPresupuestosExpedCapitalContribution(Expediente expediente) {
		return presupuestosExpedRepository.findPresupuestosExpedByIdNumExpAndTipMovAndEstado(expediente.getNumExp(),
				env.getProperty("application.capital.contribution.tip_mov.value"),
				env.getProperty("application.default.presupestos_exped.estado.value"));
	}

	private PresupuestosExped getPresupuestosExpedBalance(Expediente expediente) {
		return presupuestosExpedRepository.findPresupuestosExpedByIdNumExpAndTipMovAndEstado(expediente.getNumExp(),
				env.getProperty("application.inspection.fee.tip_mov.value"),
				env.getProperty("application.default.presupestos_exped.estado.value"));
	}

	// SMA 20160323 end
	// SMA/UMESCI-732 20170606 end
	private PresupuestosExped preparePresupuestosExped(Expediente expediente, String tipMov, double amount) {

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

	private Actividade prepareActividades(Expediente expediente, String status) {
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

	private double getSecurityDeposit(String tariff) {
		double cost = 0;

		final CosteExp costeExp = costeExpRepository.findCoste(tariff,
				env.getProperty("application.security.deposit.tip_mov.value"));

		if (costeExp != null) {
			cost = costeExp.getCoste().doubleValue();
		}

		return cost;
	}

	private double getCapitalContribution(String projectType) {
		double cost = 0;

		final CosteExp costeExp = costeExpRepository.findCosteByTipObra(projectType,
				env.getProperty("application.capital.contribution.tip_mov.value"));

		if (costeExp != null) {
			cost = costeExp.getCoste().doubleValue();
		}

		return cost;
	}

	private double getAlreadyPaidAmount(String numExp) {
		final BigDecimal amount = reciboRepository.findApplicationAlreadyPaidAmount(numExp);
		if (amount == null) {
			return 0;
		} else {
			return amount.doubleValue();
		}
	}
}
