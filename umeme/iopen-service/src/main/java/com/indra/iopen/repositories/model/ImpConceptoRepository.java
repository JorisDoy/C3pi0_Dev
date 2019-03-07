package com.indra.iopen.repositories.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.indra.iopen.model.ImpConcepto;
import com.indra.iopen.model.ImpConceptoPK;

public interface ImpConceptoRepository extends CrudRepository<ImpConcepto, ImpConceptoPK> {

	/* Get consumptions of a particular service (nis_rad) */
	@Query("Select i From ImpConcepto i, Recibo r, GrupoEst g " + "Where i.id.numRec = r.numRec "
			+ "And i.coConcepto = g.id.estRec And r.nisRad = ?1 And g.id.coGrupo = ?2 Order By r.fFact Desc")
	List<ImpConcepto> findConsumptionListByNisRad(BigDecimal nisRad, String energyConceptsGroup, Pageable pageable);

	@Query("Select i From ImpConcepto i, Recibo r, GrupoEst g " + "Where i.id.numRec = r.numRec "
			+ "And i.coConcepto = g.id.estRec And r.nisRad = ?1 And g.id.coGrupo = ?2 "
			+ "And r.fFact Between ?3 And ?4 Order By r.fFact Desc")
	List<ImpConcepto> findConsumptionListByNisRadAndFFactBetween(BigDecimal nisRad, String energyConceptsGroup,
			Date startDate, Date endDate, Pageable pageable);

	@Query("Select count(i) From ImpConcepto i, Recibo r, GrupoEst g " + "Where i.id.numRec = r.numRec "
			+ "And i.coConcepto = g.id.estRec And r.nisRad = ?1 And g.id.coGrupo = ?2")
	Long getConsumptionCountByNisRad(BigDecimal nisRad, String energyConceptsGroup);

	@Query("Select count(i) From ImpConcepto i, Recibo r, GrupoEst g " + "Where i.id.numRec = r.numRec "
			+ "And i.coConcepto = g.id.estRec And r.nisRad = ?1 And g.id.coGrupo = ?2 And r.fFact Between ?3 And ?4")
	Long getConsumptionCountByNisRadAndFFactBetween(BigDecimal nisRad, String energyConceptsGroup, Date startDate,
			Date endDate);

	/* Get bill items by bill number (num_rec) */
	ImpConcepto findImpConceptoByIdNumRec(BigDecimal numRec);
}
