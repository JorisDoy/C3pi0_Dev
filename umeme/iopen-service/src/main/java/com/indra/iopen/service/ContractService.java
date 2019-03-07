package com.indra.iopen.service;

import java.util.List;

import com.indra.iopen.form.Contract;

public interface ContractService {

	List<Contract> getClientContracts(Long codCli);

	Contract getContractByContractNumber(Long contractNumber);

	Long getNumberOfClientContracts(Long codCli);

}
