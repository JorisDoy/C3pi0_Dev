package com.indra.iopen.service;

import java.util.List;

import com.indra.iopen.form.ContractConsumption;

public interface ConsumptionListService {

	List<ContractConsumption> getConsumptionsByNisRad(Long contractNumber, String year, int page, int recordsPerPage);

	int getNumberOfPages(Long contractNumber, String year, int recordsPerPage);

	List<Integer> getConsumptionYears(Long contractNumber);

	Integer getMaxConsumptionYear(Long contractNumber);

}
