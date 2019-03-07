package com.indra.iopen.repositories.model;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.indra.iopen.model.InspectionResultTipObra;

public interface InspectionResultTipObraRepository extends CrudRepository<InspectionResultTipObra, String> {

	@Query("select i.tipObra from InspectionResultTipObra i " + "where ?1 between i.minNoOfPoles and i.maxNoOfPoles "
			+ "and ?2 between i.minNoOfMeters and i.maxNoOfMeters " + "and phasesRequested  = ?3")
	String findTipObraByTipObraByNoOfPoleAndNoOfMeterAndPhase(Long noOfPoles, Long noOfMeters, String phase);
}
