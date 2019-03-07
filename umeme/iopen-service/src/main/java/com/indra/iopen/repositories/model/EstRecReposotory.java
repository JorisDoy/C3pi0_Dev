package com.indra.iopen.repositories.model;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.indra.iopen.model.EstRec;
import com.indra.iopen.model.EstRecPK;

public interface EstRecReposotory extends CrudRepository<EstRec, EstRecPK> {
@Query("select MAX(est.id.secEstRec) FROM EstRec est WHERE est.id.numRec = ?1 ")
	Long findMaxSecEstRec(Long numRec);
	
}
