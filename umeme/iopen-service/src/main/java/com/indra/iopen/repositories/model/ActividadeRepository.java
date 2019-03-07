package com.indra.iopen.repositories.model;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.indra.iopen.model.Actividade;
import com.indra.iopen.model.ActividadePK;

/**
 * The persistent interface for the ACTIVIDADES database table.
 *
 */

public interface ActividadeRepository extends CrudRepository<Actividade, ActividadePK> {

	@Query("select max(a.id.numAct) from Actividade a where a.id.numExp = ?1")
	Long findMaxNumActByIdNumExp(String numExp);

	// SMA/UMESCI-732 20170606
	@Query("select count(*) from Actividade a where a.estAct=:status and a.id.numExp =:applicationNUmber")
	Long findCountByStatusAndApplicationNumber(@Param("status") String status,
			@Param("applicationNUmber") String applicationNUmber);

}