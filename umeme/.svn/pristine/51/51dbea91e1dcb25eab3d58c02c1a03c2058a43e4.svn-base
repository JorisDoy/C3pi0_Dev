package com.indra.iopen.repositories.model.ims;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.indra.iopen.model.ims.GiOt;

public interface GiOtRepository extends CrudRepository<GiOt, Long> {

	@Query("Select MIN(gi.nroIncidencia) FROM GiOt gi WHERE (gi.estOt<?1) AND (gi.nroIncidencia = ?2) AND (gi.nroInstalacion = ?3) ")
	Long findMinGiOtByEstOtAndNroIncidenciaAndNroInstalacion(BigDecimal estOt,BigDecimal nroIncidencia,BigDecimal nroInstalacion);
}
