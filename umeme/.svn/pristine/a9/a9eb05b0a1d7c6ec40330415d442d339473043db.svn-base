package com.indra.iopen.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;import java.util.Objects;
import org.springframework.core.env.Environment;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.indra.iopen.model.Usuario;
import com.indra.iopen.model.UsuarioPerfilPK;
import com.indra.iopen.model.security.users.EmployeeUser;
import com.indra.iopen.model.security.util.SecurityUtil;
import com.indra.iopen.repositories.model.UsuarioPerfilRepository;
import com.indra.iopen.repositories.model.UsuarioRepository;
import com.indra.iopen.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private Environment env;

	private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	private static String LIST_EMPLOYEE_ALLOWED_ROLES = "employee.allowed.roles";

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private UsuarioPerfilRepository usuarioPerfilRepository;

	@Override
	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
		UserDetails userDetails = null;
		final List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

		userDetails = loadEmployee(username, authorities);
		if (userDetails != null) {
			authorities.add(new SimpleGrantedAuthority(SecurityUtil.ROLE_EMPLOYEE));
		} else {
			logger.debug("User not found");
			throw new UsernameNotFoundException("User " + username + " not found");
		}

		return userDetails;
	}

	/**
	 * Loads an employee from the database
	 *
	 * @param username
	 * @param authorities
	 * @return
	 */
	private UserDetails loadEmployee(final String username, final List<GrantedAuthority> authorities) {

		EmployeeUser details = null;

		final Usuario usuario = usuarioRepository.findOne(username);
		final String roles = env.getProperty(LIST_EMPLOYEE_ALLOWED_ROLES);
		Boolean hasRole = Boolean.FALSE;
		if (usuario != null && StringUtils.isNotEmpty(roles)) {
			final String[] employeeRoles = roles.split(",");

			for (final String role : employeeRoles) {
				if (usuarioPerfilRepository.exists(new UsuarioPerfilPK(username, role.trim()))) {
					hasRole = Boolean.TRUE;
					break;
				}
			}

			if (usuario != null && hasRole) {
				authorities.add(new SimpleGrantedAuthority("ROLE_EMPLOYEE"));
				details = new EmployeeUser(usuario, usuario.getNomUsr(), "", authorities);
			}
		}

		return details;
	}

	@Override
	public Boolean checkValidEmployee(final String username, final String password) throws Exception {

		final String driver = env.getProperty("db.driver");
		final String url = env.getProperty("db.url");

		Class.forName(driver);
		final Connection conn = DriverManager.getConnection(url, username, password);
		return conn.isValid(10);
	}

}
