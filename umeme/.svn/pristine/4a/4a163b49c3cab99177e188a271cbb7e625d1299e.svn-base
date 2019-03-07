package com.indra.iopen.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;import java.util.Objects;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.env.Environment;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.indra.iopen.exception.DataIntegrityException;
import com.indra.iopen.form.Signup;
import com.indra.iopen.model.ClienteProfile;
import com.indra.iopen.model.Sumcon;
import com.indra.iopen.model.security.users.ClientUser;
import com.indra.iopen.model.security.util.SecurityUtil;
import com.indra.iopen.repositories.model.ClienteIdentificadorRepository;
import com.indra.iopen.repositories.model.ClienteProfileRepository;
import com.indra.iopen.repositories.model.EmployeeProfileRepository;
import com.indra.iopen.repositories.model.SumconRepository;
import com.indra.iopen.repositories.model.UsuarioPerfilRepository;
import com.indra.iopen.repositories.model.UsuarioRepository;
import com.indra.iopen.service.MailService;
import com.indra.iopen.service.UserService;
import com.indra.iopen.service.phone.PhoneService;
import com.indra.iopen.util.ApplicationDefault;
import com.indra.iopen.util.IOpenValidators;

@Service
public class UserServiceImpl implements UserService {

	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	private static String LIST_EMPLOYEE_ALLOWED_ROLES = "employee.allowed.roles";

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private EmployeeProfileRepository employeeProfileRepository;

	@Autowired
	private ClienteProfileRepository clienteProfileRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private UsuarioPerfilRepository usuarioPerfilRepository;

	@Autowired
	private Environment env;

	@Autowired

	@Lazy private MailService mailService;

	@Autowired
	private PhoneService phoneService;

	@Autowired
	private ClienteIdentificadorRepository clienteIdentificadorRepository;

	@Autowired
	private SumconRepository sumconRepository;

	@Override
	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
		UserDetails userDetails = null;
		final List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

		userDetails = loadClient(username, authorities);
		if (userDetails != null) {
			authorities.add(new SimpleGrantedAuthority(SecurityUtil.ROLE_CLIENT));
		} else {
			throw new UsernameNotFoundException("User " + username + " not found");
		}

		return userDetails;
	}

	/**
	 * Loads a client from the database
	 *
	 * @param username
	 * @param authorities
	 * @return
	 */
	private UserDetails loadClient(final String username, final List<GrantedAuthority> authorities) {
		ClientUser details = null;

		if (IOpenValidators.isValidEmail(username)) {
			final ClienteProfile clienteProfile = clienteProfileRepository.findClienteProfileByUsername(username);

			if (clienteProfile != null) {
				authorities.add(new SimpleGrantedAuthority("ROLE_CLIENT"));
				// details = new ClientUser(clienteProfile,
				// clienteProfile.getId().getUsername(),
				// clienteProfile.getUserPass(), authorities);
				details = new ClientUser(clienteProfile, clienteProfile.getUsername(), clienteProfile.getUserPass(),
						clienteProfile.getActive(), true, true, true, authorities);
			}
		}

		return details;
	}

	/**
	 * Activates a client from the database.
	 */
	@Override
	public final void activateClient(final String activationToken) {
		final ClienteProfile clienteProfile = clienteProfileRepository
				.findClienteProfileByActivationToken(activationToken);
		if ((clienteProfile != null) && !clienteProfile.getActive()) {
			clienteProfile.setActive(Boolean.TRUE);
			clienteProfileRepository.save(clienteProfile);
		}
	}

	/**
	 * Changes the password of an user.
	 */
	@Override
	public final Boolean changePassword(final String oldPassword, final String newPassword) {
		Boolean result = Boolean.FALSE;

		if (SecurityUtil.isClient()) {
			final ClientUser clientUser = SecurityUtil.getLoggedClientProfile();
			if (passwordEncoder.matches(oldPassword, clientUser.getClienteProfile().getUserPass())) {
				clientUser.getClienteProfile().setUserPass(passwordEncoder.encode(newPassword));
				clienteProfileRepository.save(clientUser.getClienteProfile());
				result = Boolean.TRUE;
			}
		}

		return result;
	}

	@Transactional(rollbackFor = { Exception.class })
	@Override
	public final void sigup(final Signup signup) throws Exception {

		if (!signup.getPassword().equals(signup.getConfirmPassword())) {
			throw new DataIntegrityException("passwords do not match");
		}
		if (clienteProfileRepository.findClienteProfileByUsername(signup.getEmail()) != null) {
			throw new DataIntegrityException("You already exist in the system. You should not register again, "
					+ "please log in and then create a new application. ");
		}

		Long codCli = 0L;

		if (signup.getExistingCustomer().equalsIgnoreCase("Y")) {
			// Get cod_cli using the id
			codCli = clienteIdentificadorRepository.findCodCliByTipDocDocId(signup.getIdType(), signup.getIdNumber());

			if (codCli == null) {
				throw new DataIntegrityException("The ID specified does not exist in the system.");
			}

			// Get the service specified
			Sumcon sumcon = sumconRepository.findOne(Long.valueOf(signup.getContractNumber()));

			if (sumcon != null && codCli != sumcon.getCodCli().longValue()) {
				throw new DataIntegrityException("Contract holder is different from the ID holder");
			}

		}

		final ClienteProfile clienteProfile = new ClienteProfile();
		clienteProfile.setUsername(signup.getEmail());
		clienteProfile.setCodCli(codCli);
		clienteProfile.setUserPass(passwordEncoder.encode(signup.getPassword()));
		clienteProfile.setFullName(signup.getFullName());
		clienteProfile.setPhoneNumber(signup.getPhoneNumber());
		clienteProfile.setActive(false);
		clienteProfile.setActivationToken(passwordEncoder.encode(signup.getEmail()));

		clienteProfile.setFActual(new Date());
		clienteProfile.setPrograma(ApplicationDefault.getProgram());
		clienteProfile.setUsuario(ApplicationDefault.getDatabaseUser());

		// save to database
		clienteProfileRepository.save(clienteProfile);

		// send Activation email
		final long threadId = Thread.currentThread().getId();
		logger.debug("Thread # " + threadId + " is doing sendMail()");
		mailService.sendUserActivation(clienteProfile, env.getProperty("umeme.district.phone"),
				env.getProperty("umeme.callcenter"), env.getProperty("umeme.district.email"),
				clienteProfile.getUsername(), clienteProfile.getFullName(), signup.getPassword());
		logger.debug("Thread # " + threadId + " is doing sendSMS()");
		phoneService.sendMessage(env.getProperty("application.sms.signup"), clienteProfile.getPhoneNumber());
		//SMA 20160301
		if(Boolean.valueOf(env.getProperty("laxcon.test"))){
			mailService.sendLaxxconSMStestMessage(env.getProperty("application.sms.signup"), clienteProfile.getUsername());
		}

	}

}
