package com.indra.iopen.pojo;

public class ServicePoint {

	private String status;
	private String connectionType;
	private String phaseType;
	private String voltageType;
	private String readingFrequency;

	public ServicePoint() {

	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getConnectionType() {
		return connectionType;
	}

	public void setConnectionType(String connectionType) {
		this.connectionType = connectionType;
	}

	public String getPhaseType() {
		return phaseType;
	}

	public void setPhaseType(String phaseType) {
		this.phaseType = phaseType;
	}

	public String getVoltageType() {
		return voltageType;
	}

	public void setVoltageType(String voltageType) {
		this.voltageType = voltageType;
	}

	public String getReadingFrequency() {
		return readingFrequency;
	}

	public void setReadingFrequency(String readingFrequency) {
		this.readingFrequency = readingFrequency;
	}

}
