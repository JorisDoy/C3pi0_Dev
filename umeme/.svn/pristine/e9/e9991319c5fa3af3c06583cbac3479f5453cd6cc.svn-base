package com.indra.iopen.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;import java.util.Objects;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.indra.iopen.model.ClienteProfile;
import com.indra.iopen.model.PasswordResetToken;
import com.indra.iopen.repositories.model.ClienteProfileRepository;
import com.indra.iopen.repositories.model.PasswordResetTokenRepository;
import com.indra.iopen.service.MailService;
import com.indra.iopen.service.PasswordService;

/**
 * The Password Service Implementation class.
 * 
 * @author mbaez
 *
 */
@Service
@Transactional(rollbackFor = { Exception.class })
@PropertySource({ "classpath:application.properties" })
public class PasswordServiceImpl implements PasswordService {

	private static final Integer MILISECONDS_PER_SECOND = 1000;

	private static final Integer SECONDS_PER_MINUTE = 60;

	@Autowired

	@Lazy private MailService mailService;

	@Autowired
	private ClienteProfileRepository clienteProfileRepository;

	@Autowired
	private PasswordResetTokenRepository tokenRepository;

	@Autowired
	private PasswordEncoder encoder;

	@Autowired
	private Environment env;

	private static final Logger LOGGER = LoggerFactory.getLogger(PasswordServiceImpl.class);

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public final Boolean generateNewRequest(final String userEmail) {
		Boolean result = Boolean.FALSE;

		// retrieve user
		final ClienteProfile clienteProfile = retrieveUserByEmail(userEmail);

		// generate new token
		final PasswordResetToken token = generateToken(clienteProfile);

		// send email
		if (token != null) {
			try {
				mailService.sendPasswordReset(clienteProfile, token, userEmail);
				result = Boolean.TRUE;
			} catch (final Exception e) {
				e.printStackTrace();
				LOGGER.error(e.getMessage());
				result = Boolean.FALSE;
			}
		}

		return result;
	}

	private PasswordResetToken generateToken(final ClienteProfile clienteProfile) {
		// CREATE NEW TOKEN FOR THE USER
		if (clienteProfile != null) {
			final Long expireTimeInMinutes = new Long(env.getProperty("token.expire.time.minutes"));
			deleteExistingUsernameTokens(clienteProfile);
			final PasswordResetToken token = new PasswordResetToken();
			token.setToken(encoder.encode(clienteProfile.getUserPass()));
			token.setExpireDate(new Date());
			token.getExpireDate().setTime(token.getExpireDate().getTime()
					+ (expireTimeInMinutes * SECONDS_PER_MINUTE * MILISECONDS_PER_SECOND));
			token.setUsername(clienteProfile.getUsername());
			tokenRepository.save(token);
			return token;
		}
		return null;
	}

	private void deleteExistingUsernameTokens(final ClienteProfile clienteProfile) {
		// DELETE PREVIOUS EXISTING TOKENS FOR THE USER
		final List<PasswordResetToken> tokens = tokenRepository
				.findPasswordResetTokensByUsername(clienteProfile.getUsername());
		if ((tokens != null) && (tokens.size() > 0)) {
			tokenRepository.delete(tokens);
		}
	}

	private ClienteProfile retrieveUserByEmail(final String username) {
		ClienteProfile clienteProfile = clienteProfileRepository.findClienteProfileByUsername(username);
		if ((clienteProfile != null) && !clienteProfile.getActive()) {
			clienteProfile = null;
		}
		return clienteProfile;
	}

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public final Boolean changePassword(final String userEmail, final String token, final String newPassword) {

		final ClienteProfile clienteProfile = clienteProfileRepository.findClienteProfileByUsername(userEmail);

		if ((clienteProfile == null) || !clienteProfile.getActive()) {
			return false;
		}

		final PasswordResetToken resetToken = tokenRepository.findPasswordResetTokenByTokenAndUsername(token,
				userEmail);

		if (resetToken == null) {
			return false;
		}

		// check token date
		final Date currentDate = new Date();
		if (currentDate.getTime() > resetToken.getExpireDate().getTime()) {
			return false;
		}

		// delete the token
		tokenRepository.delete(resetToken);

		// update the password at the clienteProfile
		clienteProfile.setUserPass(encoder.encode(newPassword));
		clienteProfileRepository.save(clienteProfile);

		return true;
	}

}
