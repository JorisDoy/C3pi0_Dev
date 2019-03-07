package com.indra.iopen.repositories.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.indra.iopen.model.Recibo;

public interface ReciboRepository extends CrudRepository<Recibo, Long>, ReciboRepositoryCustom {

	@Query("select sum (r.impCta) from Recibo r "
			+ "where ( (r.codUnicom = (select e.codUnicomCompet  from Expediente e where e.numExp = ?1) and r.numFact = ?1) "
			+ "and ( (r.estAct in (select g.id.estRec from GrupoEst g where g.id.coGrupo = 'GE100') or r.estAct = 'ER310') or r.estAct = 'ER500')) "
			+ "group by r.tipRec")
	BigDecimal findApplicationAlreadyPaidAmount(String numExp);

	// Bill listing queries
	List<Recibo> findReciboByNisRad(BigDecimal nisRad, Pageable pageable);

	// Bill listing queries
	@Query("Select r From Recibo r, GrupoEst g Where  r.estAct = g.id.estRec And r.nisRad = ?1 And g.id.coGrupo = ?2 ")
	List<Recibo> findReciboByNisRadAndCoGrupo(BigDecimal nisRad, String coGrupo, Pageable pageable);

	// Bill listing queries between date
	List<Recibo> findReciboByNisRadAndFFactBetween(BigDecimal nisRad, Date startDate, Date endDate, Pageable pageable);

	// Bill listing queries between date
	@Query("Select r From Recibo r, GrupoEst g Where r.estAct = g.id.estRec And r.nisRad = ?1 "
			+ "And r.fFact Between ?2 And ?3 And g.id.coGrupo = ?4")
	List<Recibo> findReciboByNisRadAndFFactBetweenAndCoGrupo(BigDecimal nisRad, Date startDate, Date endDate,
			String coGrupo, Pageable pageable);

	@Query("Select count(r) From Recibo r Where r.nisRad = ?1")
	Long findReciboCountByNisRad(BigDecimal nisRad);

	@Query("Select count(r) From Recibo r Where r.nisRad = ?1 And r.fFact Between ?2 And ?3")
	Long findReciboCountByNisRadAndFFactBetween(BigDecimal nisRad, Date startDate, Date endDate);

	@Query("Select r From Recibo r " + "Where "
			+ "( r.impTotRec-r.impCta > 0 And r.codCtaPago IN (Select p.codCta From PayingAccount p Where p.nisRad = ?1 And p.indPrinc=1 ) "
			+ "And r.tipRec IN ?2 And r.fVctoFac <= ?3) OR  r.nisRad=?1 ")
	List<Recibo> findReciboByWithBalanceAndCodCtaPagoOfNisRadAndTipRec(BigDecimal nisRad, List<String> tipRecs,
			Date today, Pageable pageable);

	@Query("Select count(r) From Recibo r " + "Where ((r.impTotRec-r.impCta) > 0 "
			+ "And r.codCtaPago IN (Select p.codCta From PayingAccount p Where p.nisRad = ?1 And p.indPrinc = 1) "
			+ "And r.tipRec IN ?2 " + "And r.fVctoFac <= ?3 ) OR r.nisRad = ?1")
	Long findReciboCountByNisRad(BigDecimal nisRad, List<String> tipRecs, Date today);

	@Query("select distinct(r.nisRad) from Recibo r where r.usuario = :usuario and r.tipRec IN ('TR060', 'TR063') order by r.nisRad")
	List<BigDecimal> getContractsByUsuario(@Param("usuario") String usuario);

	// @Query("select distinct(year(r.fFact)) from Recibo r where r.nisRad =
	// :nisRad and r.tipRec IN ('TR060', 'TR063') order by year(r.fFact)")
	// List<Integer> getBillingAvailableYearsByContract(@Param("nisRad")
	// BigDecimal contrato);
	//
	@Query("select distinct(year(r.fFact)) from Recibo r where r.nisRad = :nisRad order by year(r.fFact) desc")
	List<Integer> getBillingAvailableYearsByContract(@Param("nisRad") BigDecimal contrato);

	@Query("select max(year(r.fFact)) from Recibo r where r.nisRad = :nisRad order by year(r.fFact) desc")
	Integer getBillingMaxYearsByContract(@Param("nisRad") BigDecimal contrato);

	@Query("Select sum(r.impTotRec - r.impCta) From Recibo r Where r.nisRad = ?1")
	BigDecimal getNisRadBillOutstandingAmount(BigDecimal nisRad);

}
