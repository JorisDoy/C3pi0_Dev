package com.indra.iopen.repositories.model;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.indra.iopen.model.FincasExp;
import com.indra.iopen.model.FincasExpPK;
import com.indra.iopen.repositories.model.impl.FincasExpRepositoryCustom;

/**
 * The persistent interface for the FINCAS_EXP database table.
 *
 */
public interface FincasExpRepository extends CrudRepository<FincasExp, FincasExpPK>, FincasExpRepositoryCustom {
	@Query("select fep from FincasExp fep where fep.id.numExp = ?1 and fep.id.secFinca =  (select max(fe.id.secFinca) from FincasExp fe where fe.id.numExp = ?1 )")
	FincasExp findMaxSecIdByNumExp(String numExp);

}