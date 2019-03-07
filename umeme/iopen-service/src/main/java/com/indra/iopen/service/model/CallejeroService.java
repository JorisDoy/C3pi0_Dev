package com.indra.iopen.service.model;

import java.math.BigDecimal;
import java.util.List;

import com.indra.iopen.model.Callejero;

public interface CallejeroService {
	public List<Callejero> findStreetByLocalityCode(BigDecimal locality);

}
