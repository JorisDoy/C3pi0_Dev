package com.indra.iopen.service;

import java.util.List;

import com.indra.iopen.pojo.ContractBillingData;

public interface BillingInformationService {
	List<ContractBillingData> loadUserBillingdata();

	// List<ContractBillingData> loadUserConsumptiondata();
}
