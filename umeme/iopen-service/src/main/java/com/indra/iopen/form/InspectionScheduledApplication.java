package com.indra.iopen.form;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InspectionScheduledApplication {
	private String applicationNumber = null;
	private String applicationType = null;
	private String district = null;
	private String village = null;
	private String street = null;
	private String housePlot = null;
	private String phoneNumber = null;
	private Long codApplication = null;
	private String duration = null;
	private String inspectionScheduledBy = null;
	private Date inspectionScheduledDate = null;
	private Boolean inspectionScheduled = Boolean.FALSE;
	private String rejectionCode = null;
	private String rejectionComments = null;

	/* Service order details jagira 20170605 - Assign SO to employee */
	private String serviceOrderUnicom = null;
	private String serviceOrderNumber = null;
	/* Employee jagira 20170605 - Assign SO to employee */
	private BigDecimal assignedEmployeeCode = null;

	public InspectionScheduledApplication() {

	}

	public InspectionScheduledApplication(String applicationNumber, String applicationType, String district,
			String village, String street, String housePlot, String phoneNumber, Long codApplication, Date paidDate,
			String inspectionScheduledBy, Date inspectionScheduledDate, Boolean inspectionScheduled,
			String rejectionCode, String rejectionComments) {
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
		this.inspectionScheduledBy = inspectionScheduledBy;
		this.inspectionScheduledDate = inspectionScheduledDate;
		this.inspectionScheduled = inspectionScheduled;
		this.rejectionCode = rejectionCode;
		this.rejectionComments = rejectionComments;
	}

	public BigDecimal getAssignedEmployeeCode() {
		return assignedEmployeeCode;
	}

	public void setAssignedEmployeeCode(BigDecimal assignedEmployeeCode) {
		this.assignedEmployeeCode = assignedEmployeeCode;
	}

	public String getServiceOrderUnicom() {
		return serviceOrderUnicom;
	}

	public void setServiceOrderUnicom(String serviceOrderUnicom) {
		this.serviceOrderUnicom = serviceOrderUnicom;
	}

	public String getServiceOrderNumber() {
		return serviceOrderNumber;
	}

	public void setServiceOrderNumber(String serviceOrderNumber) {
		this.serviceOrderNumber = serviceOrderNumber;
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

	public Boolean getInspectionScheduled() {
		return inspectionScheduled;
	}

	public void setInspectionScheduled(Boolean inspectionScheduled) {
		this.inspectionScheduled = inspectionScheduled;
	}

	public String getInspectionScheduledBy() {
		return inspectionScheduledBy;
	}

	public void setInspectionScheduledBy(String inspectionScheduledBy) {
		this.inspectionScheduledBy = inspectionScheduledBy;
	}

	public String getInspectionScheduledDate() {

		if (inspectionScheduledDate != null) {
			final SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			return formatter.format(inspectionScheduledDate);
		} else {
			return "";
		}
	}

	public void setInspectionScheduledDate(String inspectionScheduledDateStr) {
		final SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date inspectionScheduledDate = null;

		try {

			inspectionScheduledDate = formatter.parse(inspectionScheduledDateStr);
			System.out.println(inspectionScheduledDate);
			System.out.println(formatter.format(inspectionScheduledDate));

		} catch (final Exception e) {
			e.printStackTrace();
		}
		this.inspectionScheduledDate = inspectionScheduledDate;
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
