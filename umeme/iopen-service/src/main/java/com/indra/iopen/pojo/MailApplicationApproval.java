package com.indra.iopen.pojo;

public class MailApplicationApproval extends MailApplication {

	/**
	 *
	 */
	private static final long serialVersionUID = -511408590559016506L;

	private String applicationNumber;

	private String inspectionFee;
	private String districtPhoneNumber = null;
	private String districtEmailAddress = null;
	private String callCentreNumber = null;

	public MailApplicationApproval() {
	}

	public MailApplicationApproval(MailApplication mailApplication) {
		super(mailApplication.getCustomerName(), mailApplication.getConnectionType(),
				mailApplication.getTrackingNumber(), mailApplication.getDistrict());
	}

	public String getApplicationNumber() {
		return applicationNumber;
	}

	public void setApplicationNumber(String applicationNumber) {
		this.applicationNumber = applicationNumber;
	}

	public String getInspectionFee() {
		return inspectionFee;
	}

	public void setInspectionFee(String inspectionFee) {
		this.inspectionFee = inspectionFee;
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

}
