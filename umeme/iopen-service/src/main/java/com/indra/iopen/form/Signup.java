package com.indra.iopen.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.indra.iopen.util.annotation.Phone;

public class Signup {

	@NotNull
	private String email;
	@NotNull
	@Size(min = 2, max = 50, message = "{fullName.size}")
	private String fullName;

	@NotNull
	@Size(min = 10, max = 14, message = "{phoneNumber.size}")
	@Phone
	private String phoneNumber;

	@NotNull
	@Size(min = 8, max = 30, message = "{password.size}")
	private String password;

	@NotNull
	@Size(min = 8, max = 30, message = "{password.size}")
	private String confirmPassword;

	// For existing clients
	private String existingCustomer;
	private String contractNumber;
	private String idType;
	private String idNumber;

	public Signup(String email, String fullName, String phoneNumber, String password, String confirmPassword) {
		super();
		this.email = email;
		this.fullName = fullName;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.confirmPassword = confirmPassword;
	}

	public Signup() {
		super();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	/* Already existing customers */

	public String getExistingCustomer() {
		return existingCustomer;
	}

	public void setExistingCustomer(String existingCustomer) {
		this.existingCustomer = existingCustomer;
	}

	public String getContractNumber() {
		return contractNumber;
	}

	public void setContractNumber(String contractNumber) {
		this.contractNumber = contractNumber;
	}

	public String getIdType() {
		return idType;
	}

	public void setIdType(String idType) {
		this.idType = idType;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

}
