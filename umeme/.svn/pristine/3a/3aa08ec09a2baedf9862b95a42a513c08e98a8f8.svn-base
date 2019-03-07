package com.indra.iopen.repositories.model.ims;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.indra.iopen.model.ims.SgdCentro;
import com.indra.iopen.model.ims.SgdCentroPK;

public interface SgdCentroRepository extends CrudRepository<SgdCentro, SgdCentroPK> {

	@Query("SELECT DISTINCT sgd FROM SgdCentro sgd,SgdRelacionCentro rel "
			+ " WHERE  rel.id.centroDepen=sgd.id.nroCentro"
			+ " AND (rel.id.centroResp IN (98,0)) AND (rel.id.tipCentro IN (1,0)) AND (sgd.id.tipCentro=1) "
			+ " AND (sgd.id.nroCentro NOT IN (98,99,0)) ")
	List<SgdCentro> findRegions();

	List<SgdCentro> findSgdCentroByIdTipCentro(Long valueOf);
}
