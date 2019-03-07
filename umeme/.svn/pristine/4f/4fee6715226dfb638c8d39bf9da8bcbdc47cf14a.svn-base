package com.indra.iopen.repositories.model.ims;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.indra.iopen.model.ims.GiAviso;

public interface GiAvisoRepository extends CrudRepository<GiAviso, Long>, GiAvisoRepositoryCustom {

	GiAviso findGiAvisoByNisRad(BigDecimal bigDecimal);

	List<GiAviso> findGiAvisoByNisRadInAndEstAvisoNot(List<BigDecimal> bigDecimal, BigDecimal bigDecimal2,
			Pageable pageable);

	List<GiAviso> findGiAvisoByIndCalidadAndNisRadInAndEstAvisoNot(BigDecimal complaintType,
			List<BigDecimal> bigDecimal, BigDecimal bigDecimal2, Pageable pageable);

	// Collection<? extends GiAviso>
	// findGiAvisoByIndCalidadAndNisRadInAndEstAvisoNot(BigDecimal bigDecimal,
	// List<BigDecimal> nisRads, BigDecimal bigDecimal2);

	// Collection<? extends GiAviso>
	// findGiAvisoByNisRadInAndEstAvisoNot(List<BigDecimal> nisRads, BigDecimal
	// bigDecimal, Pageable pageable);

	List<GiAviso> findGiAvisoByNisRadAndEstAvisoNot(BigDecimal bigDecimal, BigDecimal bigDecimal2, Pageable pageable);

	List<GiAviso> findGiAvisoByNisRadAndEstAvisoNot(BigDecimal bigDecimal, BigDecimal bigDecimal2);

	@Query("SELECT count(*) FROM GiAviso gi WHERE gi.nisRad IN (?1) AND gi.estAviso NOT IN (?2) ")
	Long findCountGiAvisoByNisRadInAndEstAvisoNot(List<BigDecimal> nisRads, BigDecimal bigDecimal);

	@Query("SELECT count(*) FROM GiAviso gi WHERE gi.indCalidad = ?1 AND gi.nisRad IN (?2) AND gi.estAviso NOT IN (?3) ")
	Long findCountGiAvisoByIndCalidadAndNisRadInAndEstAvisoNot(BigDecimal bigDecimal, List<BigDecimal> nisRads,
			BigDecimal bigDecimal2);

	@Query("SELECT count(*) FROM GiAviso gi WHERE gi.indCalidad = ?1 AND gi.nisRad IN (?2) AND gi.estAviso NOT IN (?3) ")
	Long findCountGiAvisoByIndCalidadAndNisRadAndEstAvisoNot(BigDecimal bigDecimal, List<BigDecimal> bigDecimal2,
			BigDecimal bigDecimal3);

}
