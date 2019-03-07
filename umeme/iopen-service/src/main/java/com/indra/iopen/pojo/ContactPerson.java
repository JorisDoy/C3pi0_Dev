package com.indra.iopen.pojo;

import java.io.Serializable;

public class ContactPerson implements Serializable {
	private static final long serialVersionUID = -6475360006833091904L;
	private String name=null;
	private String phoneNumber=null;
	
	public ContactPerson(){
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "ContactPerson [name=" + name + ", phoneNumber=" + phoneNumber + "]";
	}
	

}
