package com.indra.iopen.form;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ConnectionScheduledApplication {
	private String applicationNumber = null;
	private String applicationType = null;
	private String district = null;
	private String village = null;
	private String street = null;
	private String housePlot = null;
	private String phoneNumber = null;
	private Long codApplication = null;
	private String duration = null;
	private String connectionScheduledBy = null;
	private Date connectionScheduledDate = null;
	private Boolean connectionScheduled = Boolean.FALSE;
	private String rejectionCode = null;
	private String rejectionComments = null;
	private String workTypeDesc = null;

	public ConnectionScheduledApplication() {

	}

	public ConnectionScheduledApplication(String applicationNumber, String applicationType, String district,
			String village, String street, String housePlot, String phoneNumber, Long codApplication, Date paidDate,
			String connectionScheduledBy, Date connectionScheduledDate, Boolean connectionScheduled,
			String rejectionCode, String rejectionComments,String workTypeDesc) {
		super();
		this.applicationNumber = applicationNumber;
		this.applicationType = applicationType;
		this.district = district;
		this.village = village;
		this.street = street;
		this.housePlot = housePlot;
		this.phoneNumber = phoneNumber;
		this.codApplication = codApplication;
		duration = String.valueOf((new Date().getTime() - paidDate.getTime()) / (24 * 60 * 60 * 1000));
		this.connectionScheduledBy = connectionScheduledBy;
		this.connectionScheduledDate = connectionScheduledDate;
		this.connectionScheduled = connectionScheduled;
		this.rejectionCode = rejectionCode;
		this.rejectionComments = rejectionComments;
		this.workTypeDesc=workTypeDesc;
	}

	public String getWorkTypeDesc() {
		return workTypeDesc;
	}

	public void setWorkTypeDesc(String workTypeDesc) {
		this.workTypeDesc = workTypeDesc;
	}

	public String getApplicationNumber() {
		return applicationNumber;
	}

	public void setApplicationNumber(String applicationNumber) {
		this.applicationNumber = applicationNumber;
	}

	public String getApplicationType() {
		return applicationType;
	}

	public void setApplicationType(String applicationType) {
		this.applicationType = applicationType;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getVillage() {
		return village;
	}

	public void setVillage(String village) {
		this.village = village;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getHousePlot() {
		return housePlot;
	}

	public void setHousePlot(String housePlot) {
		this.housePlot = housePlot;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Long getCodApplication() {
		return codApplication;
	}

	public void setCodApplication(Long codApplication) {
		this.codApplication = codApplication;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public Boolean getconnectionScheduled() {
		return connectionScheduled;
	}

	public void setconnectionScheduled(Boolean connectionScheduled) {
		this.connectionScheduled = connectionScheduled;
	}

	public String getconnectionScheduledBy() {
		return connectionScheduledBy;
	}

	public void setconnectionScheduledBy(String connectionScheduledBy) {
		this.connectionScheduledBy = connectionScheduledBy;
	}

	public String getconnectionScheduledDate() {
		if (connectionScheduledDate != null) {
			final SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			return formatter.format(connectionScheduledDate);
		} else {
			return "";
		}
	}

	public void setconnectionScheduledDate(String connectionScheduledDateString) {
		final SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date connectionScheduledDate = null;
		try {

			connectionScheduledDate = formatter.parse(connectionScheduledDateString);

		} catch (final Exception e) {
			e.printStackTrace();
		}
		this.connectionScheduledDate = connectionScheduledDate;

	}

	public String getRejectionCode() {
		return rejectionCode;
	}

	public void setRejectionCode(String rejectionCode) {
		this.rejectionCode = rejectionCode;
	}

	public String getRejectionComments() {
		return rejectionComments;
	}

	public void setRejectionComments(String rejectionComments) {
		this.rejectionComments = rejectionComments;
	}

}
