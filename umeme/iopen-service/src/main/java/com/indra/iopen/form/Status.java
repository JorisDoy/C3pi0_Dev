package com.indra.iopen.form;

public class Status {
	private String statusCode;
	private String statusDescription;
	
	public Status(){
		
	}
	
	public Status(String statusCode, String statusDescription) {
		super();
		this.statusCode = statusCode;
		this.statusDescription = statusDescription;
	}
	
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getStatusDescription() {
		return statusDescription;
	}
	public void setStatusDescription(String statusDescription) {
		this.statusDescription = statusDescription;
	}
	
}
