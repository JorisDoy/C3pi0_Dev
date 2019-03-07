package com.indra.iopen.form;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

/**
 * Form used to change user password
 * 
 * @author mbaez
 *
 */
@Component
public class ChangePassword implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7896075300248214446L;

	@NotNull
	private String oldPassword;

	@NotNull
	@Size(min = 6, message = "{password.size}")
	private String newPassword;

	@Size(min = 6, message = "{password.size}")
	private String repeatNewPassword;

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(final String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(final String newPassword) {
		this.newPassword = newPassword;
	}

	public String getRepeatNewPassword() {
		return repeatNewPassword;
	}

	public void setRepeatNewPassword(final String repeatNewPassword) {
		this.repeatNewPassword = repeatNewPassword;
	}

}
