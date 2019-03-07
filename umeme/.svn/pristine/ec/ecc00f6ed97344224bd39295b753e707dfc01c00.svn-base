package com.indra.iopen.pojo;

import java.util.ArrayList;
import java.util.List;

import com.indra.iopen.form.Contract;

public class ContractBillingData {
	private Contract contractNumber;

	private List<YearBillingData> yearlyBilling;

	public ContractBillingData() {
		super();
		this.yearlyBilling = new ArrayList<YearBillingData>();
	}

	public ContractBillingData(final Contract contractNumber) {
		super();
		this.contractNumber = contractNumber;
		this.yearlyBilling = new ArrayList<YearBillingData>();
	}

	public Contract getContractNumber() {
		return contractNumber;
	}

	public void setContractNumber(final Contract contractNumber) {
		this.contractNumber = contractNumber;
	}

	public List<YearBillingData> getYearlyBilling() {
		if (yearlyBilling == null) {
			this.yearlyBilling = new ArrayList<YearBillingData>();
		}
		return yearlyBilling;
	}

	public void setYearlyBilling(final List<YearBillingData> yearlyBilling) {
		this.yearlyBilling = yearlyBilling;
	}

	public void addYearBilling(final YearBillingData billingData) {
		this.yearlyBilling.add(billingData);
	}
}
