package com.indra.iopen.pojo;

import java.util.Date;

public class MailApplicationAdvanceStatus extends MailApplication {

	private static final long serialVersionUID = 6152572340483462323L;
	private String applicationNumber = null;
	private String specificMessage = null;
	private String districtPhoneNumber = null;
	private String districtEmailAddress = null;
	private String callCentreNumber = null;
	private String currentStage = null;
	private Date inspectionScheduledDate = null;
	private Date connectionScheduledDate = null;
	private QuotationAmount quotationAmount = null;


	public Date getInspectionScheduledDate() {
		return inspectionScheduledDate;
	}

	public void setInspectionScheduledDate(Date inspectionScheduledDate) {
		this.inspectionScheduledDate = inspectionScheduledDate;
	}

	public Date getConnectionScheduledDate() {
		return connectionScheduledDate;
	}

	public void setConnectionScheduledDate(Date connectionScheduledDate) {
		this.connectionScheduledDate = connectionScheduledDate;
	}

	public MailApplicationAdvanceStatus() {

	}

	public MailApplicationAdvanceStatus(MailApplication mailApplication) {
		super(mailApplication.getCustomerName(), mailApplication.getConnectionType(),
				mailApplication.getTrackingNumber(), mailApplication.getDistrict());
	}

	public String getApplicationNumber() {
		return applicationNumber;
	}

	public void setApplicationNumber(String applicationNumber) {
		this.applicationNumber = applicationNumber;
	}

	public String getSpecificMessage() {
		return specificMessage;
	}

	public void setSpecificMessage(String specificMessage) {
		this.specificMessage = specificMessage;
	}

	public String getDistrictPhoneNumber() {
		return districtPhoneNumber;
	}

	public void setDistrictPhoneNumber(String districtPhoneNumber) {
		this.districtPhoneNumber = districtPhoneNumber;
	}

	public String getDistrictEmailAddress() {
		return districtEmailAddress;
	}

	public void setDistrictEmailAddress(String districtEmailAddress) {
		this.districtEmailAddress = districtEmailAddress;
	}

	public String getCallCentreNumber() {
		return callCentreNumber;
	}

	public void setCallCentreNumber(String callCentreNumber) {
		this.callCentreNumber = callCentreNumber;
	}

	public String getCurrentStage() {
		return currentStage;
	}

	public void setCurrentStage(String currentStage) {
		this.currentStage = currentStage;
	}

	public QuotationAmount getQuotationAmount() {
		return quotationAmount;
	}

	public void setQuotationAmount(QuotationAmount quotationAmount) {
		this.quotationAmount = quotationAmount;
	}

	@Override
	public String toString() {
		return "MailApplicationAdvanceStatus [applicationNumber=" + applicationNumber + ", specificMessage="
				+ specificMessage + ", districtPhoneNumber=" + districtPhoneNumber + ", districtEmailAddress="
				+ districtEmailAddress + ", callCentreNumber=" + callCentreNumber + ", currentStage=" + currentStage
				+ ", inspectionScheduledDate=" + inspectionScheduledDate + ", connectionScheduledDate="
				+ connectionScheduledDate + ", quotationAmount=" + quotationAmount + "]";
	}

}
