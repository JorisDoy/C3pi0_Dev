package com.indra.iopen.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.indra.iopen.form.Signup;

public interface UserService extends UserDetailsService {

	UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
	
	void activateClient(String activationToken);
	
	Boolean changePassword(String oldPassword, String newPassword);

	public void sigup(Signup signup) throws Exception;

	
}
