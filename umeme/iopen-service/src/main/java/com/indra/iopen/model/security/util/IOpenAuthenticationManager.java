package com.indra.iopen.model.security.util;

import org.springframework.beans.factory.annotation.Autowired;import java.util.Objects;
import org.springframework.dao.DataAccessException;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.authentication.dao.SaltSource;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.indra.iopen.model.security.users.EmployeeUser;
import com.indra.iopen.service.EmployeeService;

@Component
public class IOpenAuthenticationManager extends AbstractUserDetailsAuthenticationProvider {

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	private SaltSource saltSource;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private EmployeeService employeeService;
	
	private boolean includeDetailsObject = true;
	
	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails,
            UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
        if (authentication.getCredentials() == null) {
            throw new BadCredentialsException("Bad credentials");
        }
        
        if (!(userDetails instanceof EmployeeUser)) {
        	 String presentedPassword = authentication.getCredentials().toString();
             if (!passwordEncoder.matches(presentedPassword, userDetails.getPassword())) {
             	throw new BadCredentialsException("Bad credentials");
             }
        }
       
    }

	@Override
	protected final UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication)
            throws AuthenticationException {
        UserDetails loadedUser;

        try {
            loadedUser = this.getUserDetailsService().loadUserByUsername(username);
            if (loadedUser!=null) {
            	 if ((loadedUser instanceof EmployeeUser)) {
	            	String presentedPassword = authentication.getCredentials().toString();
	            	if (!employeeService.checkValidEmployee(username, presentedPassword)) {
	            		throw new BadCredentialsException("Bad credentials");
	            	}
            	 }
            }
        } catch (DataAccessException repositoryProblem) {
            throw new AuthenticationServiceException(repositoryProblem.getMessage(), repositoryProblem);
        } catch (Exception ex) {
        	throw new AuthenticationServiceException(ex.getMessage());
        }

        if (loadedUser == null) {
            throw new AuthenticationServiceException(
                    "UserDetailsService returned null, which is an interface contract violation");
        }
        return loadedUser;
    }

	public PasswordEncoder getPasswordEncoder() {
		return passwordEncoder;
	}

	public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

	public SaltSource getSaltSource() {
		return saltSource;
	}

	public void setSaltSource(SaltSource saltSource) {
		this.saltSource = saltSource;
	}

	public UserDetailsService getUserDetailsService() {
		return userDetailsService;
	}

	public void setUserDetailsService(UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}

	public boolean isIncludeDetailsObject() {
		return includeDetailsObject;
	}

	public void setIncludeDetailsObject(boolean includeDetailsObject) {
		this.includeDetailsObject = includeDetailsObject;
	}
	
	protected void doAfterPropertiesSet() throws Exception {
		Assert.notNull(this.userDetailsService, "A UserDetailsService must be set");
	}
}
