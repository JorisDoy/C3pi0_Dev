package com.indra.iopen.model.security.exception;

import org.springframework.security.core.AuthenticationException;

public class IOpenAuthenticationException extends AuthenticationException {

	public IOpenAuthenticationException(String msg) {
		super(msg);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 2825289208786421280L;

}
