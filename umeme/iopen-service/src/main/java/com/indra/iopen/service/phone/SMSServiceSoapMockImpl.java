package com.indra.iopen.service.phone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import umemesmsservice.SMSServiceSoap;

/**
 * Mock Implementation of SMS sending service.
 * It only logs the given parameters to the current appender.
 * @author mbaez
 *
 */
public class SMSServiceSoapMockImpl implements SMSServiceSoap {

    private static final Logger LOGGER = LoggerFactory.getLogger(SMSServiceSoapMockImpl.class);

    @Override
    public final String sendSMS(final String phone, final String message, final String username,
            final String password) {
        LOGGER.debug("BEGIN - sendSMS()");
        LOGGER.debug("Message: " + message);
        LOGGER.debug("Phone number: " + phone);
        LOGGER.debug("Username: " + username);
        LOGGER.debug("Password: " + password);
        LOGGER.debug("END - sendSMS()");
        return "OK";
    }

}
