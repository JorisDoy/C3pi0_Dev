package com.indra.iopen.service.impl;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.velocity.app.VelocityEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.ui.velocity.VelocityEngineUtils;

import com.indra.iopen.model.Callejero;
import com.indra.iopen.model.ClienteProfile;
import com.indra.iopen.model.IopenApplication;
import com.indra.iopen.model.IopenUnicomContact;
import com.indra.iopen.model.PasswordResetToken;
import com.indra.iopen.pojo.MailApplication;
import com.indra.iopen.pojo.MailApplicationAdvanceStatus;
import com.indra.iopen.pojo.MailApplicationApproval;
import com.indra.iopen.pojo.MailApplicationCancelOrReject;
import com.indra.iopen.repositories.model.CallejeroRepository;
import com.indra.iopen.repositories.model.IopenUnicomContactRepository;
import com.indra.iopen.repositories.model.MunicipioRepository;
import com.indra.iopen.service.CommonService;
import com.indra.iopen.service.MailService;
import com.indra.iopen.service.phone.PhoneService;
import com.indra.iopen.util.MailApplicationType;

@Service
public class MailServiceImpl implements MailService {

	private static final Logger logger = LoggerFactory.getLogger(MailServiceImpl.class);

	private static String FROM_MAIL = "mail.from";

	private final String basePath = "/META-INF/templates/email/";

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private Environment env;

	@Autowired
	private VelocityEngine velocityEngine;
	// SMA 20160229 start
	@Autowired
	private MunicipioRepository municipioRepository;
	@Autowired
	private PhoneService phoneService;
	@Autowired
	private CommonService commonService;
	// SMA 20160229 end
	// SMA 20160303
	@Autowired
	private CallejeroRepository callejeroRepository;
	@Autowired
	private IopenUnicomContactRepository iopenUnicomContactRepository;

	// SMA 20160303 end
	private void sendMail(String emailBody, String subject, String... emailAddress) throws MessagingException {
		final long threadId = Thread.currentThread().getId();
		logger.debug("Thread # " + threadId + " is doing sendMail()");
		final MimeMessage message = mailSender.createMimeMessage();
		final MimeMessageHelper helper = new MimeMessageHelper(message, false);
		helper.setFrom(env.getProperty(FROM_MAIL));
		helper.setTo(emailAddress);
		helper.setSubject(subject);
		helper.setSentDate(new Date());
		helper.setText(emailBody, true);

		// call to mail sender
		mailSender.send(message);
	}

	private String generateActivationMailBody(Map<String, Object> model, String template) {

		final String emailText = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, basePath + template,
				"UTF-8", model);

		return emailText;
	}

	@Override
	@Async
	// SMA 20160229
	public void sendUserActivation(ClienteProfile profile, String districtPhoneNumber, String callCentreNumber,
			String districtEmailAddress, String email, String fullname, String password) throws Exception {

		final long threadId = Thread.currentThread().getId();
		logger.debug("Thread # " + threadId + " is doing sendUserActivation()");
		final String template = env.getProperty("mail.template.activation.account");
		final Map<String, Object> model = new HashMap<String, Object>();
		String activationUrl = env.getProperty("mail.activation.url");
		// SMA20160314
		activationUrl = activationUrl.replace("#TOKEN#", profile.getActivationToken());

		model.put("customer_name", fullname);
		model.put("username", profile.getUsername());
		// SMA20160314
		model.put("district_phone_number",
				districtPhoneNumber != null && !districtPhoneNumber.trim().isEmpty() ? districtPhoneNumber + "," : "");
		model.put("call_centre_number",
				callCentreNumber != null && !callCentreNumber.trim().isEmpty() ? callCentreNumber : "");
		model.put("district_email_address", districtEmailAddress != null && !districtEmailAddress.trim().isEmpty()
				? " or email " + districtEmailAddress : "");
		// SMA 20160229
		model.put("password", password);
		model.put("activation_url", activationUrl);

		final String emailText = generateActivationMailBody(model, template);
		final String subject = env.getProperty("mail.subject.activation.account");

		sendMail(emailText, subject, email);
	}

	@Override
	@Async
	public void sendPasswordReset(ClienteProfile profile, PasswordResetToken token, String email) throws Exception {

		String resetUrl = env.getProperty("mail.reset.password.url");
		resetUrl = resetUrl.replace("#USERNAME#", token.getUsername());
		resetUrl = resetUrl.replace("#TOKEN#", token.getToken());
		final Map<String, Object> model = new HashMap<String, Object>();
		model.put("profile", profile);
		model.put("resetUrl", resetUrl);

		final String emailBody = generateActivationMailBody(model, "reset_password.vm");

		sendMail(emailBody, env.getProperty("mail.subject.reset.password"), email);
	}

	@Override
	@Async
	// SMA 20160301
	public void sendLaxxconSMStestMessage(String message, String email) throws Exception {
		final Map<String, Object> model = new HashMap<String, Object>();
		model.put("message", message);

		final String emailBody = generateActivationMailBody(model, "laxcon_sms_test.vm");

		sendMail(emailBody, env.getProperty("mail.subject.laxcon.sms.test"), email);
	}

	@Override
	@Async
	// SMA 20160229 UMESCI-444 start
	public void sendPendindApplicationReminder(ClienteProfile clienteProfile, IopenApplication iopenApplication)
			throws Exception {

		final Map<String, Object> model = new HashMap<String, Object>();
		String applicationsUrl = env.getProperty("mail.client.pending.application.url");
		applicationsUrl = applicationsUrl.replace("#cod#", String.valueOf(iopenApplication.getCodApplication()));
		final String template = env.getProperty("mail.template.pending.applications.reminder");
		final String subject = env.getProperty("mail.subject.pending.applications.reminder");
		// SMA 20160302 start
		String userName = null;
		String phoneNumber = null;
		String fullName = null;
		if (clienteProfile != null) {
			userName = clienteProfile.getUsername();
			phoneNumber = clienteProfile.getPhoneNumber();
			// SMA 20160316 start
			fullName = iopenApplication.getFirstName() + " " + iopenApplication.getMiddleName() + " "
					+ iopenApplication.getSurname();
			if (fullName == null || fullName.trim().isEmpty()) {
				fullName = clienteProfile.getFullName();
			}
			// SMA 20160316 end
		} else {
			userName = iopenApplication.getEmailAddress();
			phoneNumber = iopenApplication.getMobileNumber();
			fullName = iopenApplication.getFirstName() + " " + iopenApplication.getMiddleName() + " "
					+ iopenApplication.getSurname();
		}
		// SMA 20160302 end
		// SMA 20160303 start
		// Municipio municipio =
		// municipioRepository.findOne(iopenApplication.getDistrict());
		final Callejero callejero = callejeroRepository.findOne(iopenApplication.getStreet());
		IopenUnicomContact iopenUnicomContact = null;
		if (callejero != null) {
			iopenUnicomContact = iopenUnicomContactRepository.findOne(String.valueOf(callejero.getCodUnicom()));
			model.put("district_email_address", " or email " + iopenUnicomContact.getEmail());
			model.put("call_centre_number", env.getProperty("umeme.callcenter"));
			model.put("district_phone_number", iopenUnicomContact.getPhoneContact() + ",");
			model.put("district", env.getProperty("application.message2.district.text") + " "
					+ municipioRepository.findOne(iopenApplication.getDistrict()).getNomMunic());
			// SMA 20160303 end
		} else {

			model.put("district_email_address", "");
			model.put("call_centre_number", "");
			model.put("district_phone_number", "");
			if (iopenApplication.getDistrictDesc() != null && !iopenApplication.getDistrictDesc().trim().isEmpty()) {
				model.put("district", env.getProperty("application.message2.district.text") + " "
						+ iopenApplication.getDistrictDesc());
			} else {
				model.put("district", "");
			}

		}
		// SMA 20160302
		model.put("fullName", fullName);
		model.put("tracking_number", String.valueOf(iopenApplication.getCodApplication()));
		model.put("connection_type", commonService.getApplicationTypesName(iopenApplication.getApplicationType()));
		model.put("applicationsUrl", applicationsUrl);

		final String emailBody = generateActivationMailBody(model, template);

		// SMA 20160302
		sendMail(emailBody, subject, userName);
		System.out.println("MAIL SENT");
		String smsMessage = env.getProperty("application.sms.reminder");
		// SMA 20160302
		smsMessage = smsMessage.replace("#customerName", fullName);
		smsMessage = smsMessage.replace("#trackingNumber", String.valueOf(iopenApplication.getCodApplication()));
		// if (iopenApplication.getDistrict() != null) {
		// smsMessage = smsMessage.replace("district",
		// env.getProperty("application.message.district.text") + " "
		// +
		// municipioRepository.findOne(iopenApplication.getDistrict()).getNomMunic());
		// } else {
		// if (iopenApplication.getDistrictDesc() != null &&
		// !iopenApplication.getDistrictDesc().trim().isEmpty()) {
		// smsMessage = smsMessage.replace("district",
		// env.getProperty("application.message.district.text") + " "
		// + iopenApplication.getDistrictDesc());
		// }else{
		// smsMessage = smsMessage.replace("district", "");
		// }
		// }
		// SMA 20160302
		phoneService.sendMessage(smsMessage, phoneNumber);
		// SMA 20160301
		if (Boolean.valueOf(env.getProperty("laxcon.test"))) {
			// SMA 20160302
			sendLaxxconSMStestMessage(smsMessage, userName);
		}
	}
	// SMA 20160229 UMESCI-444 end

	@Override
	@Async
	public void sendApplicationStatus(MailApplication mailApplication, MailApplicationType applicationType,
			String... emails) throws Exception {
		final Map<String, Object> model = new HashMap<String, Object>();
		String template = "";
		String subject = "";
		final String currency = env.getProperty("application.default.currency.value");
		final DecimalFormat currencyFormat = new DecimalFormat(currency + "###,###.00" + "/=");

		model.put("customer_name", mailApplication.getCustomerName());
		model.put("connection_type", mailApplication.getConnectionType());
		model.put("tracking_number", mailApplication.getTrackingNumber());
		// SMA 20160229
		if (mailApplication.getDistrict() != null && !mailApplication.getDistrict().isEmpty()) {
			model.put("district",
					env.getProperty("application.message.district.text") + " " + mailApplication.getDistrict());
		} else {
			model.put("district", "");
		}
		switch (applicationType) {
		case APPROVAL:
			if (mailApplication instanceof MailApplicationApproval) {

				template = env.getProperty("mail.template.application.approval");
				subject = env.getProperty("mail.subject.application.approval");
				model.put("application_number", ((MailApplicationApproval) mailApplication).getApplicationNumber());
				model.put("inspection_fee", ((MailApplicationApproval) mailApplication).getInspectionFee());
				model.put("url_to_payment_outlets", env.getProperty("mail.url.payment.outlets"));
				model.put("url_to_connection_process", env.getProperty("mail.url.connection.proccess"));
			}
			break;

		case ADVANCE:
			if (mailApplication instanceof MailApplicationAdvanceStatus) {
				template = env.getProperty("mail.template.advance.applications.message");
				subject = env.getProperty("mail.subject.advance.applications.message");
				model.put("application_number",
						((MailApplicationAdvanceStatus) mailApplication).getApplicationNumber());
				model.put("specific_message", ((MailApplicationAdvanceStatus) mailApplication).getSpecificMessage());
				model.put("fullName", mailApplication.getCustomerName());// SMA20160314
				model.put("district_phone_number", ((MailApplicationAdvanceStatus) mailApplication)
						.getDistrictPhoneNumber() != null
						&& !((MailApplicationAdvanceStatus) mailApplication).getDistrictPhoneNumber().trim().isEmpty()
						? ((MailApplicationAdvanceStatus) mailApplication).getDistrictPhoneNumber() + "," : "");
				model.put("call_centre_number",
						((MailApplicationAdvanceStatus) mailApplication).getCallCentreNumber() != null
						&& !((MailApplicationAdvanceStatus) mailApplication).getCallCentreNumber().trim()
						.isEmpty()
						? ((MailApplicationAdvanceStatus) mailApplication).getCallCentreNumber()
								: "");
				model.put("district_email_address", ((MailApplicationAdvanceStatus) mailApplication)
						.getDistrictEmailAddress() != null
						&& !((MailApplicationAdvanceStatus) mailApplication).getDistrictEmailAddress().trim().isEmpty()
						? " or email "
						+ ((MailApplicationAdvanceStatus) mailApplication).getDistrictEmailAddress()
						: "");
				model.put("application_stage", ((MailApplicationAdvanceStatus) mailApplication).getCurrentStage());
				if (((MailApplicationAdvanceStatus) mailApplication).getQuotationAmount() != null) {
					template = env.getProperty("mail.template.advance.applications.quotation.message");
					subject = env.getProperty("mail.subject.advance.applications.quotation.message");
					// SMA/UMESCI-732 20170606
					model.put("connection_fee", currencyFormat.format(((MailApplicationAdvanceStatus) mailApplication)
							.getQuotationAmount().getTotalAmountPayable()));
					model.put("payment_url",env.getProperty("mail.payment.url") );




				}

				if (((MailApplicationAdvanceStatus) mailApplication).getConnectionScheduledDate() != null) {

					template = env.getProperty("mail.template.advance.applications.connection.schedule.message");
					subject = env.getProperty("mail.subject.advance.applications.connection.schedule.message");
					model.put("connection_schedule", new SimpleDateFormat("dd/MM/yyyy")
							.format(((MailApplicationAdvanceStatus) mailApplication).getConnectionScheduledDate()));
				}

				if (((MailApplicationAdvanceStatus) mailApplication).getInspectionScheduledDate() != null) {

					template = env.getProperty("mail.template.advance.applications.inspection.schedule.message");
					subject = env.getProperty("mail.subject.advance.applications.inspection.schedule.message");
					final SimpleDateFormat	df=new SimpleDateFormat("dd/MM/yyyy");
					model.put("inspection_date", df
							.format(((MailApplicationAdvanceStatus) mailApplication).getInspectionScheduledDate()));

				}

			}

			break;
		case CANCELATION:
			if (mailApplication instanceof MailApplicationCancelOrReject) {

				template = env.getProperty("mail.template.application.cancelation");
				subject = env.getProperty("mail.subject.application.cancelation");
				model.put("reasons", ((MailApplicationCancelOrReject) mailApplication).getReasons());

				// SMA20160314
				model.put("district_phone_number", ((MailApplicationCancelOrReject) mailApplication)
						.getDistrictPhoneNumber() != null
						&& !((MailApplicationCancelOrReject) mailApplication).getDistrictPhoneNumber().trim().isEmpty()
						? ((MailApplicationCancelOrReject) mailApplication).getDistrictPhoneNumber() + ","
								: "");
				model.put("call_centre_number", ((MailApplicationCancelOrReject) mailApplication)
						.getCallCentreNumber() != null
						&& !((MailApplicationCancelOrReject) mailApplication).getCallCentreNumber().trim().isEmpty()
						? ((MailApplicationCancelOrReject) mailApplication).getCallCentreNumber() : "");
				model.put("district_email_address", ((MailApplicationCancelOrReject) mailApplication)
						.getDistrictEmailAddress() != null
						&& !((MailApplicationCancelOrReject) mailApplication).getDistrictEmailAddress().trim().isEmpty()
						? " or email "
						+ ((MailApplicationCancelOrReject) mailApplication).getDistrictEmailAddress()
						: "");
				model.put("url_iopen_landing_page", env.getProperty("mail.url.iopen.landing.page"));
			}
			break;
		case REJECTION:
			if (mailApplication instanceof MailApplicationCancelOrReject) {

				template = env.getProperty("mail.template.application.rejection");
				subject = env.getProperty("mail.subject.application.rejection");
				model.put("reasons", ((MailApplicationCancelOrReject) mailApplication).getReasons());
				// SMA20160314
				model.put("district_phone_number", ((MailApplicationCancelOrReject) mailApplication)
						.getDistrictPhoneNumber() != null
						&& !((MailApplicationCancelOrReject) mailApplication).getDistrictPhoneNumber().trim().isEmpty()
						? ((MailApplicationCancelOrReject) mailApplication).getDistrictPhoneNumber() + ","
								: "");
				model.put("call_centre_number", ((MailApplicationCancelOrReject) mailApplication)
						.getCallCentreNumber() != null
						&& !((MailApplicationCancelOrReject) mailApplication).getCallCentreNumber().trim().isEmpty()
						? ((MailApplicationCancelOrReject) mailApplication).getCallCentreNumber() : "");
				model.put("district_email_address", ((MailApplicationCancelOrReject) mailApplication)
						.getDistrictEmailAddress() != null
						&& !((MailApplicationCancelOrReject) mailApplication).getDistrictEmailAddress().trim().isEmpty()
						? ((MailApplicationCancelOrReject) mailApplication).getDistrictEmailAddress() : "");

				model.put("url_my_applications", env.getProperty("mail.url.iopen.client.applications"));
			}
			break;

		}

		final String emailBody = generateActivationMailBody(model, template);
		sendMail(emailBody, subject, emails);
	}

	@Override
	@Async
	public void sendRegistrationSuccess(String customerName, String connectionType, String district,
			String trackingNumber, String... emails) throws Exception {

		final String template = env.getProperty("mail.template.registration.successfull");

		final Map<String, Object> model = new HashMap<String, Object>();
		model.put("customer_name", customerName);
		model.put("connection_type", connectionType);
		// SMA 20160229
		if (district != null && !district.trim().isEmpty()) {
			model.put("district", env.getProperty("application.message.district.text") + " " + district);
		} else {
			model.put("district", "");
		}
		model.put("tracking_number", trackingNumber);
		model.put("url_my_applications", env.getProperty("mail.url.iopen.client.applications"));

		final String emailBody = generateActivationMailBody(model, template);
		final String subject = env.getProperty("mail.subject.registration.successfull");

		sendMail(emailBody, subject, emails);
	}

	@Override
	@Async
	public void sendIncompleteAppFirstSave(String customerName, String connectionType, String district,
			String trackingNumber, String districtPhoneNumber, String callCentreNumber, String districtEmailAddress,
			String... emails) throws Exception {

		final String template = env.getProperty("mail.template.incomplete.application.first");
		final String subject = env.getProperty("mail.subject.incomplete.application.first");

		final Map<String, Object> model = new HashMap<String, Object>();
		model.put("customer_name", customerName);
		model.put("connection_type", connectionType);
		// SMA 20160229
		if (district != null && !district.trim().isEmpty()) {
			model.put("district", env.getProperty("application.message2.district.text") + " " + district);
		} else {
			model.put("district", "");
		}
		model.put("tracking_number", trackingNumber);
		// SMA20160314
		model.put("district_phone_number",
				districtPhoneNumber != null && !districtPhoneNumber.trim().isEmpty() ? districtPhoneNumber + "," : "");
		model.put("call_centre_number",
				callCentreNumber != null && !callCentreNumber.trim().isEmpty() ? callCentreNumber : "");
		model.put("district_email_address", districtEmailAddress != null && !districtEmailAddress.trim().isEmpty()
				? " or email " + districtEmailAddress : "");

		final String emailBody = generateActivationMailBody(model, template);

		sendMail(emailBody, subject, emails);
	}

	@Override
	@Async
	public void sendIncompleteAppReminder(ClienteProfile clienteProfile, IopenApplication iopenApplication)
			throws Exception {
		// SMA 20160302 start
		String userName = null;
		String phoneNumber = null;
		String fullName = null;
		if (clienteProfile != null) {
			userName = clienteProfile.getUsername();
			phoneNumber = clienteProfile.getPhoneNumber();
			// SMA 20160316 start
			fullName = iopenApplication.getFirstName() + " " + iopenApplication.getMiddleName() + " "
					+ iopenApplication.getSurname();
			if (fullName == null || fullName.trim().isEmpty()) {
				fullName = clienteProfile.getFullName();
			}
			// SMA 20160316 end
		} else {
			userName = iopenApplication.getEmailAddress();
			phoneNumber = iopenApplication.getMobileNumber();
			fullName = iopenApplication.getFirstName() + " " + iopenApplication.getMiddleName() + " "
					+ iopenApplication.getSurname();
		}
		// SMA 20160302 end
		final String template = env.getProperty("mail.template.incomplete.application.reminder");
		final String subjects = env.getProperty("mail.subject.incomplete.application.reminder");

		final Map<String, Object> model = new HashMap<String, Object>();
		model.put("customer_name", fullName);
		model.put("connection_type", commonService.getApplicationTypesName(iopenApplication.getApplicationType()));
		// SMA 20160303 start
		// Municipio municipio =
		// municipioRepository.findOne(iopenApplication.getDistrict());
		final Callejero callejero = callejeroRepository.findOne(iopenApplication.getStreet());
		IopenUnicomContact iopenUnicomContact = null;
		if (callejero != null) {
			iopenUnicomContact = iopenUnicomContactRepository.findOne(String.valueOf(callejero.getCodUnicom()));
			model.put("district_email_address", " or email " + iopenUnicomContact.getEmail());
			model.put("call_centre_number", env.getProperty("umeme.callcenter"));
			model.put("district_phone_number", iopenUnicomContact.getPhoneContact() + ",");
			model.put("district", env.getProperty("application.message2.district.text") + " "
					+ municipioRepository.findOne(iopenApplication.getDistrict()).getNomMunic());
			// SMA 20160303 end
		} else {

			model.put("district_email_address", "");
			model.put("call_centre_number", "");
			model.put("district_phone_number", "");
			if (iopenApplication.getDistrictDesc() != null && !iopenApplication.getDistrictDesc().trim().isEmpty()) {
				model.put("district", env.getProperty("application.message2.district.text") + " "
						+ iopenApplication.getDistrictDesc());
			} else {
				model.put("district", "");
			}

		}
		model.put("tracking_number", iopenApplication.getExpediente() != null
				? String.valueOf(iopenApplication.getExpediente().getNumExp()) : "");
		model.put("url_to_complete_application", env.getProperty("mail.url.iopen.complete.application"));

		final String emailBody = generateActivationMailBody(model, template);

		sendMail(emailBody, subjects, userName);
	}

	@Override
	@Async
	public void sendDistrictNotifyUpdatedApps(String districtName, String trackingNumber, String... emails)
			throws Exception {
		final String template = env.getProperty("mail.template.district.notify");
		final String subject = env.getProperty("mail.subject.district.notify");

		final Map<String, Object> model = new HashMap<String, Object>();
		model.put("district_name", districtName);
		model.put("tracking_number", trackingNumber);
		model.put("url_staff_page", env.getProperty("mail.url.iopen.employee.applications"));

		final String emailBody = generateActivationMailBody(model, template);
		System.out.println("NOTIFY DISTRICT UPDATED STATUS");
		sendMail(emailBody, subject, emails);
	}

}
