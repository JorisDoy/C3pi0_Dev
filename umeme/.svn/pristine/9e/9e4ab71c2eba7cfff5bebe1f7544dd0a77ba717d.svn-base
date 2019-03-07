package com.indra.iopen.form;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PowerOutageFilter {
	private Date startDate = null;
	private BigDecimal status = null;
	private String startDateString = null;
	private Date endDate = null;
	private String endDateString = null;
	private BigDecimal district = null;
	private int outageType;
	private int page = 1;
	private int batch;
	private int noOfPages;

	public PowerOutageFilter() {

	}

	public String getStartDate() {
		if (startDate != null) {
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			return formatter.format(startDate);
		} else {
			return "";
		}
	}

	public void setStartDate(String startDateStr) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date startDate = null;

		try {

			startDate = formatter.parse(startDateStr);

		} catch (Exception e) {
			e.printStackTrace();
		}
		this.startDate = startDate;
	}

	public String getEndDate() {
		if (endDate != null) {
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			return formatter.format(endDate);
		} else {
			return "";
		}
	}

	public void setEndDate(String endDateStr) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date endDate = null;

		try {

			endDate = formatter.parse(endDateStr);

		} catch (Exception e) {
			e.printStackTrace();
		}
		this.endDate = endDate;
	}

	public BigDecimal getDistrict() {
		return district;
	}

	public void setDistrict(BigDecimal district) {
		this.district = district;
	}

	public String getStartDateString() {
		return startDateString;
	}

	public void setStartDateString(String startDateString) {
		this.startDateString = startDateString;
	}

	public String getEndDateString() {
		return endDateString;
	}

	public void setEndDateString(String endDateString) {
		this.endDateString = endDateString;
	}

	public BigDecimal getStatus() {
		return status;
	}

	public void setStatus(BigDecimal status) {
		this.status = status;
	}

	public int getOutageType() {
		return outageType;
	}

	public void setOutageType(int outageType) {
		this.outageType = outageType;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getBatch() {
		return batch;
	}

	public void setBatch(int batch) {
		this.batch = batch;
	}

	public int getNoOfPages() {
		return noOfPages;
	}

	public void setNoOfPages(int noOfPages) {
		this.noOfPages = noOfPages;
	}

}
