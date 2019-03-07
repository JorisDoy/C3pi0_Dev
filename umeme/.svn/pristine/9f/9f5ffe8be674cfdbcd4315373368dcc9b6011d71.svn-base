package com.indra.iopen.repositories.model;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.indra.iopen.model.Fincas;
import com.indra.iopen.repositories.model.impl.FincasRepositoryCustom;

/**
 * The persistent interface for the FINCAS database table.
 *
 */
public interface FincasRepository extends CrudRepository<Fincas, Long>, FincasRepositoryCustom {
	@Query("SELECT COUNT ( fin ) FROM Fincas fin WHERE codCalle =?1 AND numPuerta =?2 ")
	Long findCountFincasByCodCalleAndNumPuerta(BigDecimal street, BigDecimal bigDecimal);

}