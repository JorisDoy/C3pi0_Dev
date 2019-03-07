package com.indra.iopen.service.phone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import umemesmsservice.SMSServiceSoap;

/**
 * Implmentation of the Phone Service.
 *
 * @author mbaez
 *
 */
@Service
public class PhoneServiceImpl implements PhoneService {

	private static final Logger LOGGER = LoggerFactory.getLogger(PhoneServiceImpl.class);

	@Autowired
	private SMSServiceSoap smsService;

	@Value("${sms.service.user}")
	private String smsUserName;

	@Value("${sms.service.pass}")
	private String smsPassword;

	@Override
	@Async
	public final void sendMessage(final String message, final String phoneNumber) {
		try {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("sending SMS message: '" + message + "' to " + phoneNumber);
			}
			smsService.sendSMS(phoneNumber, message, smsUserName, smsPassword);
		} catch (final Exception e) {
			e.printStackTrace();
			LOGGER.error("error sending message '" + message + "' to " + phoneNumber);
		}
	}
}
