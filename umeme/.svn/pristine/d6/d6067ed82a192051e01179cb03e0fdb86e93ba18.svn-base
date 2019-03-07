package com.indra.iopen.repositories.model.ims;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.indra.iopen.model.ims.SgdAcometida;
import com.indra.iopen.model.ims.SgdAcometidaPK;

public interface SgdAcometidaRepository extends CrudRepository<SgdAcometida, SgdAcometidaPK> {

	SgdAcometida findSgdAcometidaByNroAcoSum(BigDecimal nroAcometida); 

	SgdAcometida findSgdAcometidaByInstalacionOrigen(BigDecimal nroInstalacion);
	
	@Query("Select sgd from SgdAcometida sgd Where sgd.instalacionOrigen = ?1")
	List<SgdAcometida> findSgdAcometidaByInstalacionOrigens(BigDecimal nroInstalacion);

}
