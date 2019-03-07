package com.indra.iopen.repositories.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.indra.iopen.model.ApmedidaCo;
import com.indra.iopen.repositories.model.impl.ApmedidaCoRepositoryCustom;

public interface ApmedidaCoRepository extends CrudRepository<ApmedidaCo, Long>, ApmedidaCoRepositoryCustom {

	@Query("Select co From ApmedidaCo co Where co.idApa = ?1 and co.tipLect in ?2 and co.estCsmo in ?3 ")
	List<ApmedidaCo> findByIdApa(BigDecimal idApa, List<String> validUsageTypes, List<String> validUsageStatuses,
			Pageable pageable);

	@Query("Select co From ApmedidaCo co Where co.idApa = ?1 and co.tipLect in ?2 and co.estCsmo in ?3 "
			+ "and co.fLect between ?4 and ?5 ")
	List<ApmedidaCo> findByIdApaAndFLectBetween(BigDecimal idApa, List<String> validUsageTypes,
			List<String> validUsageStatuses, Date startDate, Date endDate, Pageable pageable);

	@Query("Select count(co) From ApmedidaCo co Where co.idApa = ?1 and co.tipLect in ?2 and co.estCsmo in ?3 ")
	Long findCountByIdApa(BigDecimal idApa, List<String> validUsageTypes, List<String> validUsageStatuses);

	@Query("Select count(co) From ApmedidaCo co Where co.idApa = ?1 and co.tipLect in ?2 and co.estCsmo in ?3 "
			+ "and co.fLect between ?4 and ?5 ")
	Long findCountByIdApaAndFLectBetween(BigDecimal idApa, List<String> validUsageTypes,
			List<String> validUsageStatuses, Date startDate, Date endDate);

	@Query("Select distinct(year(co.fLect)) From ApmedidaCo co Where co.idApa = ?1 and co.tipLect in ?2 and co.estCsmo in ?3 "
			+ "order by year(co.fLect) desc")
	List<Integer> findDistinctConsumptionYears(BigDecimal idApa, List<String> validUsageTypes,
			List<String> validUsageStatuses);

	@Query("Select max(year(co.fLect)) From ApmedidaCo co Where co.idApa = ?1 and co.tipLect in ?2 and co.estCsmo in ?3 ")
	Integer findMaxConsumptionYears(BigDecimal idApa, List<String> validUsageTypes, List<String> validUsageStatuses);
}