package com.indra.iopen.repositories.model;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.indra.iopen.model.InspectionResult;

public interface InspectionResultRepository extends CrudRepository<InspectionResult, String> {


	@Query("SELECT new com.indra.iopen.pojo.InspectionResult(ir.proceedwithserviceconnection,ir.noofpoles,ir.solidallength,ir.solidallength,null,null) "
			+ " FROM InspectionResult ir WHERE ir.workrequestid = ?1")
	InspectionResult findInspectionResultbyWorkRequestId(String workRequestId);

}