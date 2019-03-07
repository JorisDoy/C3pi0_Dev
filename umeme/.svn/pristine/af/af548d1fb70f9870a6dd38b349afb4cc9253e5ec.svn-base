package com.indra.iopen.form;

import java.util.List;

import com.indra.iopen.pojo.ContractFinancialSummary;
import com.indra.iopen.pojo.MeterData;
import com.indra.iopen.pojo.PremiseInformation;
import com.indra.iopen.pojo.ServicePoint;

public class Contract {

	private String contractNumber;
	private String tariff;
	private String status;
	private String enrollmentDate;
	private String billingPeriod;

	private List<BillDispatchForm> billDispatchForms;
	private PremiseInformation premiseInformation;
	private ServicePoint servicePoint;
	private MeterData meterData;
	private ContractFinancialSummary contractFinancialSummary;

	public Contract() {
		super();
	}

	public Contract(String contractNumber, String tariff, String status, ServicePoint servicePoint, MeterData meterData,
			ContractFinancialSummary contractFinancialSummary) {
		super();
		this.contractNumber = contractNumber;
		this.tariff = tariff;
		this.status = status;
		this.servicePoint = servicePoint;
		this.meterData = meterData;
		this.contractFinancialSummary = contractFinancialSummary;
	}

	public String getContractNumber() {
		return contractNumber;
	}

	public void setContractNumber(String contractNumber) {
		this.contractNumber = contractNumber;
	}

	public String getTariff() {
		return tariff;
	}

	public void setTariff(String tariff) {
		this.tariff = tariff;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ServicePoint getServicePoint() {
		return servicePoint;
	}

	public void setServicePoint(ServicePoint servicePoint) {
		this.servicePoint = servicePoint;
	}

	public MeterData getMeterData() {
		return meterData;
	}

	public void setMeterData(MeterData meterData) {
		this.meterData = meterData;
	}

	public ContractFinancialSummary getContractFinancialSummary() {
		return contractFinancialSummary;
	}

	public void setContractFinancialSummary(ContractFinancialSummary contractFinancialSummary) {
		this.contractFinancialSummary = contractFinancialSummary;
	}

	public String getEnrollmentDate() {
		return enrollmentDate;
	}

	public void setEnrollmentDate(String enrollmentDate) {
		this.enrollmentDate = enrollmentDate;
	}

	public String getBillingPeriod() {
		return billingPeriod;
	}

	public void setBillingPeriod(String billingPeriod) {
		this.billingPeriod = billingPeriod;
	}

	public List<BillDispatchForm> getBillDispatchForms() {
		return billDispatchForms;
	}

	public void setBillDispatchForms(List<BillDispatchForm> billDispatchForms) {
		this.billDispatchForms = billDispatchForms;
	}

	public PremiseInformation getPremiseInformation() {
		return premiseInformation;
	}

	public void setPremiseInformation(PremiseInformation premiseInformation) {
		this.premiseInformation = premiseInformation;
	}

	public String getContractNumberWithDescription() {
		return contractNumber + " (" + status + ") - " + premiseInformation.getStreetName() + " "
				+ premiseInformation.getHousePlotNumber();
	}

}
