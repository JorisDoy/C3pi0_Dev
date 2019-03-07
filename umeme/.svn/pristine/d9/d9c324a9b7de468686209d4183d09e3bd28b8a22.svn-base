package com.indra.iopen.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.constraints.NotNull;

public class ComplaintDetail implements Serializable {
	private static final long serialVersionUID = -8342121738311756958L;
	private String contractNumber;
	private String meterNumber;
	private String complaintType;
	private String complaintTypeDescription = null;
	private Long complaintNumber;
	private Date detectionDate = null;
	private String scope = null;
	@NotNull
	private String comments = null;
	private String status;
	private Long billNumber = null;
	private Long complaintNature = null;
	private int complaintSource;

	public int getComplaintSource() {
		return complaintSource;
	}

	public void setComplaintSource(int complaintSource) {
		this.complaintSource = complaintSource;
	}

	public Long getBillNumber() {
		return billNumber;
	}

	public void setBillNumber(Long billNumber) {
		this.billNumber = billNumber;
	}

	private BigDecimal previousCalls = null;
	private BigDecimal powerOutage = null;

	public ComplaintDetail() {

	}

	public String getContractNumber() {
		return contractNumber;
	}

	public void setContractNumber(String contractNumber) {
		this.contractNumber = contractNumber;
	}

	public String getMeterNumber() {
		return meterNumber;
	}

	public void setMeterNumber(String meterNumber) {
		this.meterNumber = meterNumber;
	}

	public String getComplaintType() {
		return complaintType;
	}

	public void setComplaintType(String l) {
		complaintType = l;
	}

	public Long getComplaintNumber() {
		return complaintNumber;
	}

	public void setComplaintNumber(Long complaintNumber) {
		this.complaintNumber = complaintNumber;
	}

	public String getDetectionDate() {
		String detectionDateString = null;
		if (detectionDate != null) {
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			detectionDateString = formatter.format(detectionDate);
		}

		return detectionDateString;
	}

	public void setDetectionDate(String detectionDateStr) {

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		try {
			if (detectionDateStr != null && !detectionDateStr.isEmpty() && !detectionDateStr.equalsIgnoreCase(" ")) {
				detectionDate = formatter.parse(detectionDateStr);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getComplaintNature() {
		return complaintNature;
	}

	public void setComplaintNature(Long complaintNature) {
		this.complaintNature = complaintNature;
	}

	public BigDecimal getPreviousCalls() {
		return previousCalls;
	}

	public void setPreviousCalls(BigDecimal previousCalls) {
		this.previousCalls = previousCalls;
	}

	public BigDecimal getPowerOutage() {
		return powerOutage;
	}

	public void setPowerOutage(BigDecimal powerOutage) {
		this.powerOutage = powerOutage;
	}

	public String getComplaintTypeDescription() {
		return complaintTypeDescription;
	}

	public void setComplaintTypeDescription(String complaintTypeDescription) {
		this.complaintTypeDescription = complaintTypeDescription;
	}

}
