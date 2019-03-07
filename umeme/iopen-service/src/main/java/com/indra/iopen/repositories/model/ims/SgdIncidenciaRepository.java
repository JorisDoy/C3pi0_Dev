package com.indra.iopen.repositories.model.ims;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.indra.iopen.model.ims.SgdIncidencia;
import com.indra.iopen.pojo.IncidentLocation;

public interface SgdIncidenciaRepository extends CrudRepository<SgdIncidencia, Long> {

	List<SgdIncidencia> findSgdIncidenciaByTipIncidencia(BigDecimal tipIncidencia);

	@Query("SELECT new com.indra.iopen.pojo.IncidentLocation(sgd,feeder) FROM SgdInstalacion feeder, SgdIncidencia sgd WHERE sgd.nroInstAfectada = feeder.id.nroInstalacion "
			+ "  AND sgd.tipIncidencia IN ( ?1 ) AND sgd.estActual IN ( ?2 )AND (sgd.nroCentro IN ( ?3 ) OR sgd.nroMesa IN ( ?3 )) AND sgd.fDeteccion BETWEEN ?4 AND ?5 "
			+ "ORDER BY sgd.fDeteccion DESC")
	List<IncidentLocation> findFeederIncidences(List<BigDecimal> tipIncidencia, List<BigDecimal> inEstActual,
			List<BigDecimal> district, Date start, Date end, Pageable pageable);
	@Query("SELECT count(feeder) FROM SgdInstalacion feeder, SgdIncidencia sgd WHERE sgd.nroInstAfectada = feeder.id.nroInstalacion "
			+ "  AND sgd.tipIncidencia IN ( ?1 ) AND sgd.estActual IN ( ?2 )AND (sgd.nroCentro IN ( ?3 ) OR sgd.nroMesa IN ( ?3 )) AND sgd.fDeteccion BETWEEN ?4 AND ?5 "
			+ "ORDER BY sgd.fDeteccion DESC")
	Long findCountFeederIncidences(List<BigDecimal> tipIncidencia, List<BigDecimal> inEstActual,
			List<BigDecimal> district, Date start, Date end);

}
