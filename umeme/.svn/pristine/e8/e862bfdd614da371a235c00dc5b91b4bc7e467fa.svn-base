package com.indra.iopen.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface EmployeeService extends UserDetailsService {
    Boolean checkValidEmployee(String username, String password) throws Exception;

    @Override
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
