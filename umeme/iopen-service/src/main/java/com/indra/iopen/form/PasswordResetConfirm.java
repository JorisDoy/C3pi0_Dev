package com.indra.iopen.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Component
public class PasswordResetConfirm {
	
	@NotNull
	private String token;
	
	@NotNull
	private String username;
	
	@NotNull
	@Size(
			min = 6,
			message = "{numbermin.size}")
	private String password;
	
	@NotNull
	@Size(
			min = 6,
			message = "{numbermin.size}")
	private String repeatPassword;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
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

	public String getRepeatPassword() {
		return repeatPassword;
	}

	public void setRepeatPassword(String repeatPassword) {
		this.repeatPassword = repeatPassword;
	}
}
