package com.indra.iopen.repositories.model;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.indra.iopen.model.TrabpendRe;
import com.indra.iopen.repositories.model.impl.TrabpendReRepositoryCustom;

public interface TrabpendReRepository extends CrudRepository<TrabpendRe, Long>, TrabpendReRepositoryCustom {
	List<TrabpendRe> findTrabpendReByNisRadInAndCodCli(List<BigDecimal> contractNumber, BigDecimal codCli, Pageable pageable);

	List<TrabpendRe> findTrabpendReByNisRadInAndCodCliAndTipRcm(List<BigDecimal> bigDecimal, BigDecimal codCli,
			String complaintType, Pageable pageable);

	@Query("SELECT count(*) FROM TrabpendRe tr WHERE tr.nisRad IN ( ?1 ) AND tr.codCli = ?2 AND tr.tipRcm = ?3 ")
	Long findCountTrabpendReByNisRadInAndCodCliAndTipRcm(List<BigDecimal> bigDecimal, BigDecimal bigDecimal2,
			String complaintType);

	@Query("SELECT count(*) FROM TrabpendRe tr WHERE tr.nisRad IN ( ?1 ) AND tr.codCli = ?2 ")
	Long findCountTrabpendReByNisRadInAndCodCli(List<BigDecimal> bigDecimal, BigDecimal bigDecimal2);

}
