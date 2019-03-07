package com.indra.iopen.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

public class ComplaintFilter implements Serializable {

	private static final long serialVersionUID = -4508399476869628575L;

	private String complaintType = null;
	private int complaintSource;
	private Long contractNumber = null;
	private int batch;
	private int page;
	private int numberOfPages;

	public ComplaintFilter() {

	}

	public String getComplaintType() {
		return complaintType;
	}

	public void setComplaintType(String complaintType) {
		this.complaintType = complaintType;
	}

	public int getComplaintSource() {
		return complaintSource;
	}

	public void setComplaintSource(int complaintSource) {
		this.complaintSource = complaintSource;
	}

	public Long getContractNumber() {
		return contractNumber;
	}

	public void setContractNumber(Long contractNumber) {
		this.contractNumber = contractNumber;
	}

	public int getBatch() {
		return batch;
	}

	public void setBatch(int batch) {
		this.batch = batch;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getNumberOfPages() {
		return numberOfPages;
	}

	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}

}
