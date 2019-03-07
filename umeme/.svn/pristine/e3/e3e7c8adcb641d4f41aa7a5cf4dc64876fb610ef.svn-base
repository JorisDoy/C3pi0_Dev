package com.indra.iopen.repositories.model;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.indra.iopen.model.Sumcon;
import com.indra.iopen.repositories.model.impl.SumconRepositoryCustom;

/**
 * The persistent interface for the SUMCON database table.
 *
 */
public interface SumconRepository extends CrudRepository<Sumcon, Long>, SumconRepositoryCustom {

	Sumcon findSumconByNumSum(long longValue);

	List<Sumcon> findSumconByCodCliOrderByNisRadAsc(BigDecimal codCli);

	@Query("Select s.nisRad From Sumcon s Where s.codCli = ?1 Order by s.nisRad asc")
	List<Long> findNisRadByCodCliOrderByNisRadAsc(BigDecimal codCli);

	@Query("Select Count(s.nisRad) From Sumcon s Where s.codCli = ?1")
	Long getCountByCodCli(BigDecimal codCli);

}