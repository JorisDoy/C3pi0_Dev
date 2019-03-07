package com.indra.iopen.form;

import java.util.List;

public class ApplicationPendingInvoiceInformation {

	private long codApplication;
	private List<ApplicationInvoice> invoices;

	public ApplicationPendingInvoiceInformation() {

	}

	public long getCodApplication() {
		return codApplication;
	}

	public void setCodApplication(long codApplication) {
		this.codApplication = codApplication;
	}

	public List<ApplicationInvoice> getInvoices() {
		return invoices;
	}

	public void setInvoices(List<ApplicationInvoice> invoices) {
		this.invoices = invoices;
	}

}
