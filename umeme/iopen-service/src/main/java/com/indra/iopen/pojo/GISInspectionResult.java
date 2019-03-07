package com.indra.iopen.pojo;

import java.io.Serializable;

/**
 * UMESCI-713 This class is going to be used
 *
 * @author smaina
 *
 */
public class GISInspectionResult implements Serializable {
	private static final long serialVersionUID = 8976786216722311122L;
	private String inspectionStatus;
	private long inspectionDate;
	private long employeeCode;
	private String observation;
	private String connectionType;
	private String workRequestType;
	private String workRequestNumber;
	private GPS gps;

	public GISInspectionResult() {

	}

	public String getInspectionStatus() {
		return inspectionStatus;
	}

	public void setInspectionStatus(String inspectionStatus) {
		this.inspectionStatus = inspectionStatus;
	}

	public long getInspectionDate() {
		return inspectionDate;
	}

	public void setInspectionDate(long inspectionDate) {
		this.inspectionDate = inspectionDate;
	}

	public long getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(long employeeCode) {
		this.employeeCode = employeeCode;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public String getConnectionType() {
		return connectionType;
	}

	public void setConnectionType(String connectionType) {
		this.connectionType = connectionType;
	}

	public String getWorkRequestType() {
		return workRequestType;
	}

	public void setWorkRequestType(String workRequestType) {
		this.workRequestType = workRequestType;
	}

	public String getWorkRequestNumber() {
		return workRequestNumber;
	}

	public void setWorkRequestNumber(String workRequestNumber) {
		this.workRequestNumber = workRequestNumber;
	}

	public GPS getGps() {
		return gps;
	}

	public void setGps(GPS gps) {
		this.gps = gps;
	}

}
