package com.indra.iopen.form;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.indra.iopen.model.IopenApplication;
import com.indra.iopen.pojo.GPS;

public class ReceivedInspectionResult {

	// private Expediente expediente;
	private IopenApplication iopenApplication;

	private Boolean inspectionPassed;private long inspectionStatus;
	private String tipSolic;
	private String tipObra;
	private String tipConexion;

	private String inspectionComment;

	private Date inspectionDate;
	private String inspectionDateString;
	private double inspectionTime;
	private long inspectionByEmployeeCode;
	// SMA/UMESCI-713
	private GPS gps;

	// private IopenApplication iopenApplication = null;
	// private String noofpoles = null;
	// private String solidallength = null;
	// private String phasesrequested = null;

	public ReceivedInspectionResult() {
		super();
	}

	public ReceivedInspectionResult(IopenApplication iopenApplication) {
		super();
		this.iopenApplication = iopenApplication;
	}

	public IopenApplication getIopenApplication() {
		return iopenApplication;
	}

	public void setIopenApplication(IopenApplication iopenApplication) {
		this.iopenApplication = iopenApplication;
	}

	public Boolean getInspectionPassed() {
		return inspectionPassed;
	}

	public void setInspectionPassed(Boolean inspectionPassed) {
		this.inspectionPassed = inspectionPassed;
	}

	public String getTipSolic() {
		return tipSolic;
	}

	public void setTipSolic(String tipSolic) {
		this.tipSolic = tipSolic;
	}

	public String getTipObra() {
		return tipObra;
	}

	public void setTipObra(String tipObra) {
		this.tipObra = tipObra;
	}

	public String getTipConexion() {
		return tipConexion;
	}

	public void setTipConexion(String tipConexion) {
		this.tipConexion = tipConexion;
	}

	public String getInspectionComment() {
		return inspectionComment;
	}

	public void setInspectionComment(String inspectionComment) {

		if (inspectionComment == null) {
			inspectionComment = " ";
		}
		this.inspectionComment = inspectionComment;
	}

	public Date getInspectionDate() {
		return inspectionDate;
	}

	public void setInspectionDate(Date inspectionDate) {
		this.inspectionDate = inspectionDate;
	}

	public String getInspectionTime() {
		return String.valueOf(inspectionTime);
	}

	public void setInspectionTime(String inspectionTime) {
		if (inspectionTime != null && !inspectionTime.isEmpty()) {
			this.inspectionTime = Double.parseDouble(inspectionTime);
		} else {
			this.inspectionTime = 0.0;
		}
	}

	public long getInspectionByEmployeeCode() {
		return inspectionByEmployeeCode;
	}

	public void setInspectionByEmployeeCode(long inspectionByEmployeeCode) {
		this.inspectionByEmployeeCode = inspectionByEmployeeCode;
	}

	public String getInspectionDateString() {

		if (inspectionDate != null) {
			final SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			inspectionDateString = formatter.format(inspectionDate);
		}

		return inspectionDateString;
	}

	public void setInspectionDateString(String inspectionDateString) {
		this.inspectionDateString = inspectionDateString;

		final SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		try {
			inspectionDate = formatter.parse(this.inspectionDateString);

		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	// SMA/UMESCI-713 start
	public GPS getGps() {
		return gps;
	}

	public void setGps(GPS gps) {
		this.gps = gps;
	}

	public long getInspectionStatus() {
		return inspectionStatus;
	}

	public void setInspectionStatus(long inspectionStatus) {
		this.inspectionStatus = inspectionStatus;
	}

	// SMA/UMESCI-713 stop

}
