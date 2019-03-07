package com.indra.iopen.form;

public class ApplicationListFilter {
	// no need for validation as not all f these fields must be available
	private Long district;
	private String applicationStatus;
	private String documentType;
	private String idNumber;
	private String applicationNumber;
	private String trackingNumber;
	private String currentStage;
	private boolean complete;
	//	SMA/UMESCI-732
	private String estado;
	private String estAct;
	private Integer batch = 25;
	private Integer page=1;
	private int noOfPages;

	/* Filter by tipObra jagira 20170607 */
	private String workType;

	public int getNoOfPages() {
		return noOfPages;
	}

	public void setNoOfPages(int noOfPages) {
		this.noOfPages = noOfPages;
	}

	public String getWorkType() {
		return workType;
	}

	public void setWorkType(String workType) {
		this.workType = workType;
	}

	public boolean isComplete() {
		return complete;
	}

	public void setComplete(boolean complete) {
		this.complete = complete;
	}

	public Long getDistrict() {
		return district;
	}

	public void setDistrict(final Long district) {
		this.district = district;
	}

	public String getApplicationStatus() {
		return applicationStatus;
	}

	public void setApplicationStatus(final String applicationStatus) {
		this.applicationStatus = applicationStatus;
	}

	public String getDocumentType() {
		return documentType;
	}

	public void setDocumentType(final String documentType) {
		this.documentType = documentType;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(final String idNumber) {
		this.idNumber = idNumber;
	}

	public String getCurrentStage() {
		return currentStage;
	}

	public void setCurrentStage(String currentStage) {
		this.currentStage = currentStage;
	}

	public String getApplicationNumber() {
		return applicationNumber;
	}

	public void setApplicationNumber(String applicationNumber) {
		this.applicationNumber = applicationNumber;
	}

	public String getTrackingNumber() {
		return trackingNumber;
	}

	public void setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
	}
	//SMA/umesci-732 start
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getEstAct() {
		return estAct;
	}

	public void setEstAct(String estAct) {
		this.estAct = estAct;
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

	//SMA/umesci-732 end
}
