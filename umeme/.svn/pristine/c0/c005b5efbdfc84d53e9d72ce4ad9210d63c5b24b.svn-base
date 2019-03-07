package com.indra.iopen.form;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BillDispatchForm implements Serializable {
	private static final long serialVersionUID = 8020172188630050166L;
	private Date updatedDate = null;
	private String dispatchMethod = null;
	private String dispatchName = null;
	private String contractNumber = null;
	private String contact = null;
	private boolean selected = false;

	public BillDispatchForm() {

	}

	public BillDispatchForm(Long contractNumber, String dispatchMethod, Date updatedDate, boolean selected) {
		this.contractNumber = String.valueOf(contractNumber);
		this.dispatchMethod = dispatchMethod;
		this.updatedDate = updatedDate;
		this.selected = selected;
	}

	public BillDispatchForm(Long contractNumber, String dispatchMethod, Date updatedDate) {
		this.contractNumber = String.valueOf(contractNumber);
		this.dispatchMethod = dispatchMethod;
		this.updatedDate = updatedDate;
		// selected = true;
	}

	public String getUpdatedDate() {
		if (updatedDate != null) {
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			return formatter.format(updatedDate);
		} else {
			return "";
		}
	}

	public void setUpdatedDate(String updatedDateStr) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date updatedDate = null;

		try {

			updatedDate = formatter.parse(updatedDateStr);

		} catch (Exception e) {
			e.printStackTrace();
		}
		this.updatedDate = updatedDate;
	}

	public String getDispatchMethod() {
		return dispatchMethod;
	}

	public void setDispatchMethod(String dispatchMethod) {
		this.dispatchMethod = dispatchMethod;
	}

	public String getContractNumber() {
		return contractNumber;
	}

	public void setContractNumber(String contractNumber) {
		this.contractNumber = contractNumber;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public String getDispatchName() {
		return dispatchName;
	}

	public void setDispatchName(String dispatchName) {
		this.dispatchName = dispatchName;
	}

	@Override
	public String toString() {
		return "BillDispatch [updatedDate=" + updatedDate + ", dispatchMethod=" + dispatchMethod + ", contractNumber="
				+ contractNumber + "]";
	}

}
