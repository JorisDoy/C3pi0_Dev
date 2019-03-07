package com.indra.iopen.pojo;

public class MailApplicationCancelOrReject extends MailApplication {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private String reason;
	private String comment;

	private String districtPhoneNumber;

	private String callCentreNumber;

	private String districtEmailAddress;
	private String applicationNumber;

	public MailApplicationCancelOrReject(MailApplication mailApplication) {

		super(mailApplication.getCustomerName(), mailApplication.getConnectionType(),
				mailApplication.getTrackingNumber(), mailApplication.getDistrict());
	}

	public MailApplicationCancelOrReject() {

		super();
	}

	public String getReasons() {
		return reason;
	}

	public void setReasons(String reasons) {
		reason = reasons;
	}

	public String getDistrictPhoneNumber() {
		return districtPhoneNumber;
	}

	public void setDistrictPhoneNumber(String districtPhoneNumber) {
		this.districtPhoneNumber = districtPhoneNumber;
	}

	public String getCallCentreNumber() {
		return callCentreNumber;
	}

	public void setCallCentreNumber(String callCentreNumber) {
		this.callCentreNumber = callCentreNumber;
	}

	public String getDistrictEmailAddress() {
		return districtEmailAddress;
	}

	public void setDistrictEmailAddress(String districtEmailAddress) {
		this.districtEmailAddress = districtEmailAddress;
	}

	public String getApplicationNumber() {
		return applicationNumber;
	}

	public void setApplicationNumber(String applicationNumber) {
		this.applicationNumber = applicationNumber;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
