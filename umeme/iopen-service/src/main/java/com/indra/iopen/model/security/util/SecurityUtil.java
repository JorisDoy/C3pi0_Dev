package com.indra.iopen.model.security.util;

import java.util.Collection;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import com.indra.iopen.model.security.users.ClientUser;
import com.indra.iopen.model.security.users.EmployeeUser;
import com.indra.iopen.model.security.users.GenericUser;

public class SecurityUtil {
	
	public static String ROLE_CLIENT = "ROLE_CLIENT";
	public static String ROLE_EMPLOYEE = "ROLE_EMPLOYEE";

	public static boolean isAnonimous() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
		       return false;
		}
		return true;
	}
	
	public static boolean isClient() {
		if (!SecurityUtil.isAnonimous()) {
			return hasAuthority(ROLE_CLIENT);
		}
		return false;
	}

	private static boolean hasAuthority(String authority) {
		Collection<? extends GrantedAuthority> authorities = 
				SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		return authorities.contains(new SimpleGrantedAuthority(authority));
	}
	
	public static boolean isEmployee() {
		if (!SecurityUtil.isAnonimous()) {
			return hasAuthority(ROLE_EMPLOYEE);
		}
		return false;
	}
	
	private static GenericUser getLoggedUserDetails() {
		GenericUser user = null;
		
		if (!isAnonimous()) {
			user = (GenericUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		}	
				 
		return user;
	}
	
	public static EmployeeUser getLoggedEmployeeProfile() {
		EmployeeUser employee = null;
		
		if (isEmployee()) {
			employee = (EmployeeUser) getLoggedUserDetails();
		}
		
		return employee;
	}
	
	public static ClientUser getLoggedClientProfile() {
		ClientUser client = null;
		
		if (isClient()) {
			client = (ClientUser) getLoggedUserDetails();
		}
		
		return client;
	}

}
