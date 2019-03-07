package com.indra.iopen.repositories.model.impl;

import java.util.List;

import com.indra.iopen.form.BillDispatchForm;

public interface BillDispatchRepositoryCustom {
	List<BillDispatchForm> getBillDispatchMethodsOfASpecificContract(Long contractNumber);

	// List<BillDispatchForm> getBillDispatchMethods();
}
