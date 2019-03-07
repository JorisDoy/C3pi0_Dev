package com.indra.iopen.repositories.model;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.indra.iopen.model.ims.SgdInstalacion;
import com.indra.iopen.model.ims.SgdInstalacionPK;

public interface SgdInstalacionRepository extends CrudRepository<SgdInstalacion, SgdInstalacionPK> {

	// find sub-stations
	List<SgdInstalacion> findSgdInstalacionByTipoInstalacionAndEstadoAndIdBdiJobOrderByNomInstalacionAsc(
			BigDecimal tipoInstalacion, BigDecimal Estado, Long bdiJob);

	// find feeder, transformer and circuit NRO_INST_PADRE
	List<SgdInstalacion> findSgdInstalacionByTipoInstalacionAndNroInstPadreAndEstadoAndIdBdiJobOrderByNomInstalacionAsc(
			BigDecimal tipoInstalacion, BigDecimal nroInstPadre, BigDecimal Estado, Long bdiJob);

	List<SgdInstalacion> findSgdInstalacionByTipoInstalacion(BigDecimal tipoInstalacion);

	@Query("SELECT feeder FROM SgdInstalacion feeder, SgdIncidencia sgd WHERE sgd.nroInstAfectada = feeder.id.nroInstalacion ")
	List<SgdInstalacion> findInstallationIncidences();

	@Query("SELECT feeder FROM SgdInstalacion feeder, SgdIncidencia sgd,SgdAcometida aco WHERE "
			+ " sgd.nroInstAfectada = feeder.id.nroInstalacion AND aco.instalacionOrigen = feeder.id.nroInstalacion AND aco.codMunic = ?1  ")
	List<SgdInstalacion> findInstallationsIncidencesByDistrict(BigDecimal district);

	SgdInstalacion findSgdInstalacionByIdNroInstalacion(Long nroInstAfectada);

}