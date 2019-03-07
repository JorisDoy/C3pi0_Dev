package com.indra.iopen.model.security.util;

import org.springframework.beans.factory.annotation.Autowired;
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
    private EmployeeService employeeService;

    private boolean includeDetailsObject = true;

    @Override
    protected void additionalAuthenticationChecks(final UserDetails userDetails,
            final UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
        if (authentication.getCredentials() == null) {
            throw new BadCredentialsException("Bad credentials");
        }

        if (!(userDetails instanceof EmployeeUser)) {
            final String presentedPassword = authentication.getCredentials().toString();
            if (!passwordEncoder.matches(presentedPassword, userDetails.getPassword())) {
                throw new BadCredentialsException("Bad credentials");
            }
        }

    }

    @Override
    protected final UserDetails retrieveUser(final String username,
            final UsernamePasswordAuthenticationToken authentication)
                    throws AuthenticationException {
        UserDetails loadedUser;

        try {
            loadedUser = this.getUserDetailsService().loadUserByUsername(username);
            if (loadedUser != null) {
                if ((loadedUser instanceof EmployeeUser)) {
                    final String presentedPassword = authentication.getCredentials().toString();
                    if (!employeeService.checkValidEmployee(username, presentedPassword)) {
                        throw new BadCredentialsException("Bad credentials");
                    }
                }
            }
        } catch (final DataAccessException repositoryProblem) {
            throw new AuthenticationServiceException(repositoryProblem.getMessage(), repositoryProblem);
        } catch (final Exception ex) {
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

    public void setPasswordEncoder(final PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public SaltSource getSaltSource() {
        return saltSource;
    }

    public void setSaltSource(final SaltSource saltSource) {
        this.saltSource = saltSource;
    }

    public UserDetailsService getUserDetailsService() {
        return employeeService;
    }

    public void setUserDetailsService(final UserDetailsService userDetailsService) {
        this.employeeService = (EmployeeService) userDetailsService;
    }

    public boolean isIncludeDetailsObject() {
        return includeDetailsObject;
    }

    public void setIncludeDetailsObject(final boolean includeDetailsObject) {
        this.includeDetailsObject = includeDetailsObject;
    }

    @Override
    protected void doAfterPropertiesSet() throws Exception {
        Assert.notNull(this.employeeService, "A UserDetailsService must be set");
    }
}
