package com.indra.iopen.service.model;

import java.math.BigDecimal;
import java.util.List;

import com.indra.iopen.model.Municipio;

public interface MunicipioService {
	public List<Municipio> findAllMunicipios();

	public List<Municipio> findAllMunicipiosByDepto();

	List<Municipio> findAllMunicipiosByDeptoAndUnicom(BigDecimal codUnicom);

}
