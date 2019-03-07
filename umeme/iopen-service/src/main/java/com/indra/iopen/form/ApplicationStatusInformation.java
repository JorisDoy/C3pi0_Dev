package com.indra.iopen.form;

public class ApplicationStatusInformation {

	private long codApplication;
	private String applicationNumber;
	private String applicationStage;
	private String applicationDescription;

	public ApplicationStatusInformation() {

	}

	public String getApplicationNumber() {
		return applicationNumber;
	}

	public void setApplicationNumber(String applicationNumber) {
		this.applicationNumber = applicationNumber;
	}

	public long getCodApplication() {
		return codApplication;
	}

	public void setCodApplication(long codApplication) {
		this.codApplication = codApplication;
	}

	public String getApplicationStage() {
		return applicationStage;
	}

	public void setApplicationStage(String applicationStage) {
		this.applicationStage = applicationStage;
	}

	public String getApplicationDescription() {
		return applicationDescription;
	}

	public void setApplicationDescription(String applicationDescription) {
		this.applicationDescription = applicationDescription;
	}

}
