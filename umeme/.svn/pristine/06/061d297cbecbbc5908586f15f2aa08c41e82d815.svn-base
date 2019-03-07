package com.indra.iopen.form;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.springframework.stereotype.Component;

@Component
public class PasswordResetRequest implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1454769079749996726L;

	@NotNull
	@Email(message ="{email.valid}")
	private String email;
	
	@NotNull
	@Email(message ="{email.valid}")
	private String repeatEmail;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRepeatEmail() {
		return repeatEmail;
	}

	public void setRepeatEmail(String repeatEmail) {
		this.repeatEmail = repeatEmail;
	}
	
}
