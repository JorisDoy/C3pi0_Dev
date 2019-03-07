package com.indra.iopen.pojo;

import java.io.Serializable;

public class QuotationAmount implements Serializable {
	private static final long serialVersionUID = -460416501154291446L;

	private Double securityDeposit;
	private Double capitalContribution;
	private Double alreadyPaidAmount;
	private Double totalAmountPayable;
	// SMA/UMESCI-732 -20170506
	private Double inspectionBalance;

	public QuotationAmount() {

	}

	public Double getSecurityDeposit() {
		return securityDeposit;
	}

	public void setSecurityDeposit(Double securityDeposit) {
		this.securityDeposit = securityDeposit;
	}

	public Double getCapitalContribution() {
		return capitalContribution;
	}

	public void setCapitalContribution(Double capitalContribution) {
		this.capitalContribution = capitalContribution;
	}

	public Double getAlreadyPaidAmount() {
		return alreadyPaidAmount;
	}

	public void setAlreadyPaidAmount(Double alreadyPaidAmount) {
		this.alreadyPaidAmount = alreadyPaidAmount;
	}

	public Double getTotalAmountPayable() {
		return capitalContribution + securityDeposit - alreadyPaidAmount;
	}

	public void setTotalAmountPayable(Double totalAmountPayable) {
		this.totalAmountPayable = totalAmountPayable;
	}

	// SMA/UMESCI-732 -20170506 start
	public Double getInspectionBalance() {
		return inspectionBalance;
	}

	public void setInspectionBalance(Double inspectionBalance) {
		this.inspectionBalance = inspectionBalance;
	}

	@Override
	public String toString() {
		return "QuotationAmount [securityDeposit=" + securityDeposit + ", capitalContribution=" + capitalContribution
				+ ", alreadyPaidAmount=" + alreadyPaidAmount + ", totalAmountPayable=" + totalAmountPayable
				+ ", inspectionBalance=" + inspectionBalance + "]";
	}

	// SMA/UMESCI-732 -20170506 end

}
