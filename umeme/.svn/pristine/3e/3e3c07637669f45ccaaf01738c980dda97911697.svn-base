package com.indra.iopen.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;import java.util.Objects;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.env.Environment;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.indra.iopen.exception.DataIntegrityException;
import com.indra.iopen.form.InspectionScheduledApplication;
import com.indra.iopen.model.Callejero;
import com.indra.iopen.model.Expediente;
import com.indra.iopen.model.IopenApplication;
import com.indra.iopen.model.IopenUnicomContact;
import com.indra.iopen.model.Ordene;
import com.indra.iopen.model.security.users.EmployeeUser;
import com.indra.iopen.pojo.MailApplication;
import com.indra.iopen.pojo.MailApplicationCancelOrReject;
import com.indra.iopen.repositories.model.CallejeroRepository;
import com.indra.iopen.repositories.model.CodigoRepository;
import com.indra.iopen.repositories.model.ExpedienteRepository;
import com.indra.iopen.repositories.model.IopenApplicationRepository;
import com.indra.iopen.repositories.model.IopenUnicomContactRepository;
import com.indra.iopen.repositories.model.MunicipioRepository;
import com.indra.iopen.repositories.model.OrdeneRepository;
import com.indra.iopen.service.CommonService;
import com.indra.iopen.service.InspectionSchedulingService;
import com.indra.iopen.service.MailService;
import com.indra.iopen.service.phone.PhoneService;
import com.indra.iopen.util.ApplicationAdvanceType;
import com.indra.iopen.util.ApplicationDefault;
import com.indra.iopen.util.MailApplicationType;

@Service
public class InspectionSchedulingServiceImpl implements InspectionSchedulingService {
	@Autowired
	IopenApplicationRepository iopenApplicationRepository;
	@Autowired
	private CommonService commonService;
	@Autowired
	private MunicipioRepository municipioRepository;

	@Autowired

	@Lazy
	private MailService mailService;

	@Autowired
	private Environment env;
	@Autowired
	private PhoneService phoneService;
	@Autowired
	private CodigoRepository codigoRepository;
	@Autowired
	private IopenUnicomContactRepository iopenUnicomContactRepository;
	@Autowired
	private CallejeroRepository callejeroRepository;

	@Autowired
	private ExpedienteRepository expedienteRepository;
	@Autowired
	private OrdeneRepository ordeneRepository;

	private IopenApplication iopenApplication = null;

	@Override
	public List<InspectionScheduledApplication> findScheduledApplications(Boolean scheduled) {
		final List<InspectionScheduledApplication> inspectionScheduledApplications = iopenApplicationRepository
				.findScheduledIopenApplicationsWhichPaymentHaveBeenRecieved(
						env.getProperty("application.stage.reinspection.paid.value"),
						env.getProperty("application.stage.inspection.paid.value"),
						env.getProperty("application.stage.inspection.paid.value"), scheduled, null, Boolean.FALSE);
		return inspectionScheduledApplications;
	}

	@Override
	public List<InspectionScheduledApplication> findScheduledApplicationsForClient(String clientUserName,
			Boolean scheduled) {
		final List<InspectionScheduledApplication> inspectionScheduledApplications = iopenApplicationRepository
				.findScheduledIopenApplicationsWhichPaymentHaveBeenRecieved(
						env.getProperty("application.stage.reinspection.paid.value"),
						env.getProperty("application.stage.inspection.paid.value"),
						env.getProperty("application.stage.inspection.paid.value"), scheduled, clientUserName,
						Boolean.FALSE);
		return inspectionScheduledApplications;
	}

	private Ordene prepareOrdenes(final Expediente expediente) {
		final Ordene ordene = ordeneRepository.findOne(expediente.getNumOs().longValue());
		final Date now = new Date();
		ordene.setFUce(now);
		ordene.setFActual(now);
		ordene.setUsuario(ApplicationDefault.getDatabaseUser());
		ordene.setPrograma(ApplicationDefault.getProgram());
		ordene.setEstOs(env.getProperty("application.default.issue.service.order.status"));

		return ordene;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void addInspectionScheduleToApplication(InspectionScheduledApplication inspectionScheduledApplication)
			throws Exception {
		iopenApplication = iopenApplicationRepository.findOne(inspectionScheduledApplication.getCodApplication());
		if (iopenApplication == null) {
			throw new DataIntegrityException("the application does not exist");
		}
		final MailApplication mailApplication = new MailApplication();
		mailApplication.setConnectionType(commonService.getApplicationTypesName(iopenApplication.getApplicationType()));
		mailApplication.setCustomerName(iopenApplication.getContactName());
		mailApplication.setDistrict(municipioRepository.findOne(iopenApplication.getDistrict()).getNomMunic());
		mailApplication.setTrackingNumber(String.valueOf(iopenApplication.getCodApplication()));

		if (inspectionScheduledApplication.getRejectionCode() == null
				|| inspectionScheduledApplication.getRejectionCode().isEmpty()) {
			iopenApplication.setInspectionScheduled(Boolean.TRUE);
			final SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			iopenApplication.setInspectionScheduledDate(
					formatter.parse(inspectionScheduledApplication.getInspectionScheduledDate()));
			iopenApplication.setInspectionScheduledBy(
					((EmployeeUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal())
					.getEmployeeProfile().getNomUsr());
			// SMA/UMESCI-732 -20170506 start
			final Ordene ordene = prepareOrdenes(iopenApplication.getExpediente());
			ordene.setCodEmpAsig(inspectionScheduledApplication.getAssignedEmployeeCode());
			ordeneRepository.save(ordene);
			// SMA/UMESCI-732 -20170506 end
			// send message
			final List<IopenApplication> iopenApplications = new ArrayList<>();
			iopenApplications.add(iopenApplication);
			commonService.sendMessagesClientsToInformOfAdvanceInApplicationStatus(iopenApplications,
					ApplicationAdvanceType.INSPECTION_SCHEDULED);
		} else {
			iopenApplication.setInspectionScheduled(Boolean.FALSE);
			iopenApplication.setCoRejectReason(inspectionScheduledApplication.getRejectionCode());
			iopenApplication.setComments(inspectionScheduledApplication.getRejectionComments());

			iopenApplication.setEstStatus(env.getProperty("application.iopenstatus.reject"));
			iopenApplication.setInspectionRejected(Boolean.TRUE);
			iopenApplication.setInspectionRejectCode(inspectionScheduledApplication.getRejectionCode());
			iopenApplication.setInspectionRejectComment(inspectionScheduledApplication.getRejectionComments());
			iopenApplication.setInspectionRejectDate(new Date());
			iopenApplication.setInspectionRejectBy(
					((EmployeeUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal())
					.getEmployeeProfile().getNomUsr());

			// send email
			// Municipio municipio =
			// municipioRepository.findOne(iopenApplication.getDistrict());
			final Callejero callejero = callejeroRepository.findOne(iopenApplication.getStreet());
			final IopenUnicomContact iopenUnicomContact = iopenUnicomContactRepository
					.findOne(String.valueOf(callejero.getCodUnicom()));

			final MailApplicationCancelOrReject mailApplicationCancelOrReject = new MailApplicationCancelOrReject(
					mailApplication);

			mailApplicationCancelOrReject.setCallCentreNumber(env.getProperty("umeme.callcenter"));
			mailApplicationCancelOrReject.setDistrictEmailAddress(iopenUnicomContact.getEmail());
			mailApplicationCancelOrReject.setDistrictPhoneNumber(iopenUnicomContact.getPhoneContact());
			mailApplicationCancelOrReject.setComment(inspectionScheduledApplication.getRejectionComments());
			mailApplicationCancelOrReject.setReasons(
					codigoRepository.findById(inspectionScheduledApplication.getRejectionCode()).getDescCod() + " : "
							+ inspectionScheduledApplication.getRejectionComments());
			// SMA 20160219 UMESC-444 start
			if (iopenApplication.getExpediente() != null) {
				mailApplicationCancelOrReject.setApplicationNumber(iopenApplication.getExpediente().getNumExp());
				// SMA 20160219 UMESC-444 end
			}
			mailService.sendApplicationStatus(mailApplicationCancelOrReject, MailApplicationType.REJECTION,
					iopenApplication.getEmailAddress());

			// SEND SMS
			// SMA 20160229
			phoneService.sendMessage(env.getProperty("application.sms.inspection.failed"),
					iopenApplication.getContactNumber());
			// SMA 20160301
			if (Boolean.valueOf(env.getProperty("laxcon.test"))) {
				mailService.sendLaxxconSMStestMessage(env.getProperty("application.sms.inspection.failed"),
						iopenApplication.getEmailAddress());
			}
		}

		iopenApplicationRepository.save(iopenApplication);
	}

	@Override
	public InspectionScheduledApplication getScheduledApplication(Long codApplication) {

		final InspectionScheduledApplication inspectionScheduledApplication = iopenApplicationRepository
				.findScheduledApplicationForClient(env.getProperty("application.stage.reinspection.paid.value"),
						env.getProperty("application.stage.inspection.paid.value"), codApplication);

		return updateServiceOrderDetails(inspectionScheduledApplication);
	}

	@Override
	public List<InspectionScheduledApplication> findRejectedApplications() {

		return iopenApplicationRepository.findRejectedOnInspectionScheduleIopenApplication(
				env.getProperty("application.stage.reinspection.paid.value"),
				env.getProperty("application.stage.inspection.paid.value"));
	}

	public InspectionScheduledApplication updateServiceOrderDetails(
			InspectionScheduledApplication inspectionScheduledApplication) {

		final Expediente exp = expedienteRepository.findById(inspectionScheduledApplication.getApplicationNumber());
		final Ordene ord = ordeneRepository.findOne(exp.getNumOs().longValue());

		inspectionScheduledApplication.setServiceOrderNumber(String.valueOf(ord.getNumOs()));
		inspectionScheduledApplication.setServiceOrderUnicom(String.valueOf(ord.getCodUnicom()));

		return inspectionScheduledApplication;

	}

}
