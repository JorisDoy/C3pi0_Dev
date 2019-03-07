package com.indra.iopen.service;

import java.math.BigDecimal;
import java.util.List;

import com.indra.iopen.form.ContractBill;

public interface BillListingService {

	int getNumberOfPages(Long contractNumber, String year, int recordsPerPage) throws Exception;

	List<Integer> getBillYearList() throws Exception;

	List<ContractBill> getContractBills(Long contractNumber, String year, int page, int recordsPerPage) throws Exception;

	List<ContractBill> getBillCodesForComplaints(Long contractNumber) throws Exception;

	List<Integer> getContractBillYears(BigDecimal contractNumber);
	
	Integer getMaxBillYear(BigDecimal contractNumber);

}
