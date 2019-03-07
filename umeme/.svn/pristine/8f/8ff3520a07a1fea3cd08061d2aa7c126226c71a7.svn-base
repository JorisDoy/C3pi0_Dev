package com.indra.iopen.service.impl;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.commons.lang.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.indra.iopen.model.Callejero;
import com.indra.iopen.model.ClienteProfile;
import com.indra.iopen.model.IopenApplication;
import com.indra.iopen.model.IopenUnicomContact;
import com.indra.iopen.model.Municipio;
import com.indra.iopen.pojo.MailApplication;
import com.indra.iopen.pojo.MailApplicationCancelOrReject;
import com.indra.iopen.repositories.model.CallejeroRepository;
import com.indra.iopen.repositories.model.ClienteProfileRepository;
import com.indra.iopen.repositories.model.IopenApplicationRepository;
import com.indra.iopen.repositories.model.IopenUnicomContactRepository;
import com.indra.iopen.repositories.model.MunicipioRepository;
import com.indra.iopen.service.ApplicationBatchService;
import com.indra.iopen.service.CommonService;
import com.indra.iopen.service.MailService;
import com.indra.iopen.service.QuotationService;
import com.indra.iopen.service.phone.PhoneService;
import com.indra.iopen.util.ApplicationAdvanceType;
import com.indra.iopen.util.MailApplicationType;

@Service
@Transactional(rollbackFor = { Exception.class })
public class ApplicationBatchServiceImpl implements ApplicationBatchService {

	private static final Logger logger = LoggerFactory.getLogger(ApplicationBatchServiceImpl.class);
	@Autowired
	private PhoneService phoneService;
	@Autowired
	private ClienteProfileRepository clienteProfileRepository;
	@Autowired
	private CallejeroRepository callejeroRepository;
	@Autowired
	private IopenUnicomContactRepository iopenUnicomContactRepository;
	@Autowired
	private Environment env;
	@Autowired
	private IopenApplicationRepository iopenApplicationRepository;
	@Autowired
	private CommonService commonService;
	@Autowired
	private MunicipioRepository municipioRepository;
	@Autowired
	private QuotationService quotationService;

	@Autowired

	@Lazy
	private MailService mailService;

	@Value("${application.iopenstatus.cancel}")
	private String statusCanceled;

	@Value("${application.default.status}")
	private String statusActive;

	@Value("${application.stage.inspection.paid.value}")
	private String inspectionPaidEstado;

	@Value("${application.stage.reinspection.paid.value}")
	private String reInspectionestado;

	@Value("${application.stage.connection.in.progress.value}")
	private String connectionPendingEstado;

	@Value("${application.stage.quotation.paid.value}")
	private String quotationPaidEstado;

	/**
	 *
	 */
	@Override
	public void remindImcompleteApplicationToClients(Integer maxDays) {
		logger.info("BEGIN - remindImcompleteApplicationToClients");
		// Get the client list to notify
		// SMA 20160229
		final Map<ClienteProfile, IopenApplication> clients = getClientsWithIncompleteApplications(maxDays);

		// Send mail to the clients included in the list
		sendMailClientsToEnforceFinishPendingApplications(clients);

		logger.info("END - remindImcompleteApplicationToClients");

	}

	@Override
	public void sendMessageWhenPaymentIsRecievedJob() {
		logger.info("BEGIN - sendMessageWhenPaymentIsRecievedJob");
		// List<IopenApplication> iopenApplications = new
		// ArrayList<IopenApplication>();

		final List<IopenApplication> inspectionPaidIopenApplications = iopenApplicationRepository
				.findIopenApplicationsWhereMessageIsNotYetSent(inspectionPaidEstado);

		final List<IopenApplication> reInspectedIopenApplications = iopenApplicationRepository
				.findIopenApplicationsWhereMessageIsNotYetSent(reInspectionestado);
		if (reInspectedIopenApplications != null && !reInspectedIopenApplications.isEmpty()) {
			// SMA 20160316
			commonService.sendMessagesClientsToInformOfAdvanceInApplicationStatus(reInspectedIopenApplications,
					ApplicationAdvanceType.REINSPECTION_PAID);
			// SMA 20160412 to remove rejection fields from inspection paid
			// applications
			reInspectedIopenApplications.parallelStream().filter(Objects::nonNull)
			.forEach(reInspectedIopenApplication -> {
				reInspectedIopenApplication.setInspectionRejectCode(null);
				reInspectedIopenApplication.setInspectionRejectBy(null);
				reInspectedIopenApplication.setInspectionRejectComment(null);
				reInspectedIopenApplication.setInspectionRejectDate(null);
				reInspectedIopenApplication.setInspectionRejected(Boolean.FALSE);
				reInspectedIopenApplication.setCoRejectReason(null);
				iopenApplicationRepository.save(reInspectedIopenApplication);

			});
		}

		if (inspectionPaidIopenApplications != null && !inspectionPaidIopenApplications.isEmpty()) {
			// SMA 20160316
			commonService.sendMessagesClientsToInformOfAdvanceInApplicationStatus(inspectionPaidIopenApplications,
					ApplicationAdvanceType.INSPECTION_PAID);
		}

		logger.info("END - sendMessageWhenPaymentIsRecievedJob");

	}

	@Override
	public void generateQuotationJob() {
		logger.info("BEGIN - generateQuotationJob");
		try {
			quotationService.processAllToGenerateQuotation();
		} catch (final Exception e) {
			e.printStackTrace();
		}
		logger.info("END - generateQuotationJob");

	}

	@Override
	public void sendMessageWhenStatusIsConnectionPendingJob() {
		logger.info("BEGIN - sendMessageWhenStatusIsConnectionPendingJob");
		// List<IopenApplication> iopenApplications = iopenApplicationRepository
		// .findIopenApplicationsWhereMessageIsNotYetSent(inspectionPaidEstado);

		final List<IopenApplication> iopenApplications = iopenApplicationRepository
				.findIopenApplicationsWhereMessageIsNotYetSent(quotationPaidEstado);

		commonService.sendMessagesClientsToInformOfAdvanceInApplicationStatus(iopenApplications,
				ApplicationAdvanceType.PAID);

		logger.info("END - sendMessageWhenStatusIsConnectionPendingJob");

	}

	/**
	 * Returns a list with the clients with pendind applications
	 *
	 * @return
	 */
	// SMA 20160229 start
	private Map<ClienteProfile, IopenApplication> getClientsWithIncompleteApplications(Integer maxDays) {
		logger.info("BEGIN - getClientsWithIncompleteApplications");
		// SMA 20160315
		final Calendar calendar = Calendar.getInstance();
		// calendar.setTime(new Date());
		Date limitDate = null;
		Date twoDaysBefore = null;
		final Map<ClienteProfile, IopenApplication> clientMap = new HashMap<>();
		ClienteProfile clienteProfile = null;
		final List<IopenApplication> applications = iopenApplicationRepository
				.findByCompleteAndEstStatus(new BigDecimal(0), statusActive);

		logger.debug("Retrieved " + applications.size() + " pending applications");

		for (final IopenApplication iopenApplication : applications) {
			// SMA 20160315
			if (iopenApplication.getFActual() != null) {
				calendar.setTime(new Date());
				limitDate = DateUtils.addDays(iopenApplication.getFActual(), maxDays);
				twoDaysBefore = DateUtils.addDays(limitDate, -2);
				// check if it's 2 days before the application is canceled
				if (DateUtils.isSameDay(twoDaysBefore, calendar.getTime())) {
					clienteProfile = clienteProfileRepository
							.findClienteProfileByUsername(iopenApplication.getClientUsername());
					if (clienteProfile != null && clienteProfile.getActive()) {
						clientMap.put(clienteProfile, iopenApplication);
						logger.debug("Adding " + clienteProfile.getCodCli() + " for notifing him.");
					} else {
						logger.warn("Client " + iopenApplication.getClientUsername() + " its not valid.");
					}
				}
			}
		}
		logger.info("END - getClientsWithIncompleteApplications");
		return clientMap;
	}

	// SMA 20160229 end
	/**
	 * Sends a reminder email to all the clients with pending applications
	 *
	 * @param clients
	 */
	// SMA 20160229 start
	private void sendMailClientsToEnforceFinishPendingApplications(Map<ClienteProfile, IopenApplication> clients) {
		logger.info("BEGIN - sendMailClientsToEnforceFinishPendingApplications");
		clients.entrySet().stream().filter(Objects::nonNull).forEach((client) -> {
			try {
				final ClienteProfile clienteProfile = client.getKey();
				final IopenApplication iopenApplication = client.getValue();
				mailService.sendIncompleteAppReminder(clienteProfile, iopenApplication);
			} catch (final Exception e) {
				logger.error("Send remainder email failed for client " + client.getKey().getUsername(), e);
			}
		});
		logger.info("END - sendMailClientsToEnforceFinishPendingApplications");
	}
	// SMA 20160229 end

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public void autoCancelOldPendingApplications(Integer days) {
		final Calendar calendar = Calendar.getInstance();
		// calendar.setTime(new Date());
		Date limitDate = null;
		Date now = null;

		logger.info("BEGIN - autoCancelOldPendingApplications");
		// SMA 20160314
		final List<IopenApplication> applications = iopenApplicationRepository
				.findByCompleteAndEstStatus(new BigDecimal(0), statusActive);

		for (final IopenApplication iopenApplication : applications) {
			try {
				if (iopenApplication.getFActual() != null) {
					now = new Date();
					calendar.setTime(new Date());
					limitDate = DateUtils.addDays(iopenApplication.getFActual(), days);

					if (DateUtils.isSameDay(limitDate, now)) {
						logger.debug(
								"Marking iopenApplication " + iopenApplication.getCodApplication() + " as cancelled.");
						iopenApplication.setEstStatus(statusCanceled);
						iopenApplicationRepository.save(iopenApplication);
						// SMA 20162403 start
						final Municipio municipio = municipioRepository.findOne(iopenApplication.getDistrict());
						Callejero callejero = null;
						if (iopenApplication.getExpediente() != null) {
							callejero = callejeroRepository.findOne(iopenApplication.getStreet());
						}
						IopenUnicomContact iopenUnicomContact = null;
						if (callejero != null) {
							iopenUnicomContact = iopenUnicomContactRepository
									.findOne(String.valueOf(callejero.getCodUnicom()));
						}
						final MailApplication mailApplication = new MailApplication();
						mailApplication.setTrackingNumber(String.valueOf(iopenApplication.getCodApplication()));
						mailApplication.setCustomerName(iopenApplication.getFirstName() + " "
								+ iopenApplication.getMiddleName() + " " + iopenApplication.getSurname());
						if (iopenApplication.getDistrict() != null && iopenApplication.getDistrict() != 0) {
							mailApplication.setDistrict(municipio.getNomMunic());
						} else {
							if (iopenApplication.getDistrictDesc() != null
									&& !iopenApplication.getDistrictDesc().trim().isEmpty()) {
								mailApplication.setDistrict(iopenApplication.getDistrictDesc());
							}
						}
						mailApplication.setConnectionType(
								commonService.getApplicationTypesName(iopenApplication.getApplicationType()));
						final MailApplicationCancelOrReject mailApplicationCancelOrReject = new MailApplicationCancelOrReject(
								mailApplication);
						mailApplicationCancelOrReject.setCallCentreNumber(env.getProperty("umeme.callcenter"));
						// SMA 20160303 start
						if (iopenUnicomContact != null) {
							mailApplicationCancelOrReject.setDistrictEmailAddress(iopenUnicomContact.getEmail());
							mailApplicationCancelOrReject.setDistrictPhoneNumber(iopenUnicomContact.getPhoneContact());
						} else {
							mailApplicationCancelOrReject.setDistrictEmailAddress("");
							mailApplicationCancelOrReject.setDistrictPhoneNumber("");
						}
						// SMA 20160303 end
						mailApplicationCancelOrReject.setReasons(iopenApplication.getComments());

						mailService.sendApplicationStatus(mailApplicationCancelOrReject,
								MailApplicationType.CANCELATION, iopenApplication.getEmailAddress());
						String smsMessage = env.getProperty("application.sms.cancellation");
						smsMessage = smsMessage.replace("#customerName",
								mailApplicationCancelOrReject.getCustomerName());
						smsMessage = smsMessage.replace("#trackingNumber",
								mailApplicationCancelOrReject.getTrackingNumber());
						smsMessage = smsMessage.replace("#connectionType",
								mailApplicationCancelOrReject.getConnectionType());

						// SMA 20160303 added the check for getDistrict();
						if (iopenApplication.getDistrict() != null && iopenApplication.getDistrict() != 0) {
							smsMessage = smsMessage.replace("#district",
									env.getProperty("application.message.district.text") + " "
											+ municipio.getNomMunic());
						} else {
							if (iopenApplication.getDistrictDesc() != null

									&& !iopenApplication.getDistrictDesc().trim().isEmpty()) {
								smsMessage = smsMessage.replace("#district",
										env.getProperty("application.message.district.text") + " "
												+ mailApplicationCancelOrReject.getDistrict());
							} else {
								smsMessage = smsMessage.replace("#district", "");
							}
						}
						phoneService.sendMessage(smsMessage, iopenApplication.getMobileNumber());
						// SMA 20162403 end
					}
				}
			} catch (final Exception e) {
				e.printStackTrace();
			}
		}

		logger.info("END - autoCancelOldPendingApplications");
	}

}
