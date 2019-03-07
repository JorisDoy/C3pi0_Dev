package com.indra.iopen.pojo;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class MailApplication implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 3720228994414576970L;

	private String customerName;

	private String connectionType;

	private String trackingNumber;

	private String district;

	public MailApplication() {
	}

	public MailApplication(String customerName, String connectionType, String trackingNumber, String district) {

		this.customerName = customerName;
		this.connectionType = connectionType;
		this.trackingNumber = trackingNumber;
		this.district = district;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getConnectionType() {
		return connectionType;
	}

	public void setConnectionType(String connectionType) {
		this.connectionType = connectionType;
	}

	public String getTrackingNumber() {
		return trackingNumber;
	}

	public void setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}
}
