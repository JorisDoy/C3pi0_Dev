package com.indra.iopen.service;

import java.util.List;

import com.indra.iopen.form.BillDispatchForm;

public interface BillDispatchService {
	void addBillDispatchMethod(BillDispatchForm billDispatchForm) throws Exception;

	void removeBillDispatchMethod(BillDispatchForm billDispatchForm) throws Exception;

	List<BillDispatchForm> getBillDispatchMethodsOfASpecificContract(Long contractNumber) throws Exception;

	void addBillDispatchMethods(BillDispatchForm billDispatchForm, long codCli) throws Exception;

	// List<BillDispatchForm> getBillDispatchMethods() throws Exception;
}
