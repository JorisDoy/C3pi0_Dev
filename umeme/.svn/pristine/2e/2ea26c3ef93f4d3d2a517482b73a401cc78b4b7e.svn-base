package com.indra.iopen.form;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

import com.indra.iopen.model.IopenApplication;

public class ApplicationList {

	@NotNull
	private String applicationDate;
	@NotNull
	private String applicationNumber;
	@NotNull
	private String applicationType;
	@NotNull
	private String applicationStatus;
	@NotNull
	private String applicationComment;
	@NotNull
	private String applicationCurrentStage;
	
	
	private String applicationNextStage;

	private List<MultipartFile> files;

	private IopenApplication iopenApplication;
	private List<ApplicationInvoice> invoices;

	public String getApplicationComment() {
		return applicationComment;
	}

	public String getApplicationCurrentStage() {
		return applicationCurrentStage;
	}

	public String getApplicationDate() {
		return applicationDate;
	}

	public String getApplicationNextStage() {
		return applicationNextStage;
	}

	public String getApplicationNumber() {
		return applicationNumber;
	}

	public String getApplicationStatus() {
		return applicationStatus;
	}

	public String getApplicationType() {
		return applicationType;
	}

	public List<MultipartFile> getFiles() {
		return files;
	}

	public List<ApplicationInvoice> getInvoices() {
		return invoices;
	}

	public IopenApplication getIopenApplication() {
		return iopenApplication;
	}

	public void setApplicationComment(String applicationComment) {
		this.applicationComment = applicationComment;
	}

	public void setApplicationCurrentStage(String applicationCurrentStage) {
		this.applicationCurrentStage = applicationCurrentStage;
	}

	public void setApplicationDate(String applicationDate) {
		this.applicationDate = applicationDate;
	}

	public void setApplicationNextStage(String applicationNextStage) {
		this.applicationNextStage = applicationNextStage;
	}

	public void setApplicationNumber(String applicationNumber) {
		this.applicationNumber = applicationNumber;
	}

	public void setApplicationStatus(String applicationStatus) {
		this.applicationStatus = applicationStatus;
	}

	public void setApplicationType(String applicationType) {
		this.applicationType = applicationType;
	}

	public void setFiles(List<MultipartFile> files) {
		this.files = files;
	}

	public void setInvoices(List<ApplicationInvoice> invoices) {
		this.invoices = invoices;
	}

	public void setIopenApplication(IopenApplication iopenApplication) {
		this.iopenApplication = iopenApplication;
	}

	@Override
	public String toString() {
		return "ApplicationList [applicationDate=" + applicationDate + ", applicationNumber=" + applicationNumber
				+ ", applicationType=" + applicationType + ", applicationStatus=" + applicationStatus
				+ ", applicationComment=" + applicationComment + ", applicationCurrentStage=" + applicationCurrentStage
				+ ", applicationNextStage=" + applicationNextStage + ", iopenApplication=" + iopenApplication
				+ ", invoices=" + invoices + "]";
	}

}
