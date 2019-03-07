package com.indra.iopen.service;

import com.indra.iopen.model.ClienteProfile;
import com.indra.iopen.model.IopenApplication;
import com.indra.iopen.model.PasswordResetToken;
import com.indra.iopen.pojo.MailApplication;
import com.indra.iopen.util.MailApplicationType;

public interface MailService {

	void sendPasswordReset(ClienteProfile profile, PasswordResetToken token, String email) throws Exception;

	void sendApplicationStatus(MailApplication mailApplication, MailApplicationType applicationType, String... emails)
			throws Exception;

	void sendRegistrationSuccess(String customerName, String connectionType, String district, String trackingNumber,
			String... emails) throws Exception;

	void sendIncompleteAppFirstSave(String customerName, String connectionType, String district, String trackingNumber,
			String districtPhoneNumber, String callCentreNumber, String districtEmailAddress, String... emails)
					throws Exception;
	//SMA 20162403
	void sendIncompleteAppReminder(ClienteProfile clienteProfile, IopenApplication iopenApplication)
			throws Exception;

	void sendDistrictNotifyUpdatedApps(String districtName, String trackingNumber, String... emails) throws Exception;

	// SMA 20160229 start
	void sendPendindApplicationReminder(ClienteProfile profile, IopenApplication iopenApplication) throws Exception;

	void sendUserActivation(ClienteProfile profile, String districtPhoneNumber, String callCentreNumber,
			String districtEmailAddress, String email, String fullname, String password) throws Exception;

	// SMA 20160229 end
	// SMA 20160301
	void sendLaxxconSMStestMessage(String message, String email) throws Exception;

}
