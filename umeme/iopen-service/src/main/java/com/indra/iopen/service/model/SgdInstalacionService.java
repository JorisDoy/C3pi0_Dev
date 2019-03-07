package com.indra.iopen.service.model;

import java.math.BigDecimal;
import java.util.List;

import com.indra.iopen.model.ims.SgdInstalacion;

public interface SgdInstalacionService {

	List<SgdInstalacion> findSubStations();

	List<SgdInstalacion> findCircuit(BigDecimal nroInstPadre);

	List<SgdInstalacion> findTransformer(BigDecimal nroInstPadre);

	List<SgdInstalacion> findFeeder(BigDecimal nroInstPadre);

}
