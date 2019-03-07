package com.indra.iopen.repositories.model;

import org.springframework.data.repository.CrudRepository;

import com.indra.iopen.model.ExpedComm;
import com.indra.iopen.model.ExpedCommPK;

public interface ExpedCommRepository extends CrudRepository<ExpedComm, ExpedCommPK> {

	ExpedComm findExpedCommByIdNumExpAndIdNumApaAndIdCoMarcaAndCgvSum(String numExp, String numApa, String coMarca,
			String cgvSum);
}
