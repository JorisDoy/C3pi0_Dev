package com.indra.iopen.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.springframework.stereotype.Component;

@Component
public class Login {
	
	@NotNull
	@Email(message ="{email.valid}")
	private String username;
	
	@NotNull
	@Size(
			min = 7,
			max = 30,
			message = "{password.size}")
	private String password;

	private String lastError;
	 
    public String getLastError() {
        return lastError;
    }
 
    public void setLastError(String lastError) {
        this.lastError = lastError;
    }

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
