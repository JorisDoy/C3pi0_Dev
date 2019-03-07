package com.indra.iopen.service.model;

import java.math.BigDecimal;
import java.util.List;
import com.indra.iopen.model.Localidade;

public interface LocalidadeService {
	public List<Localidade> findVillageByDistrictCode(BigDecimal district);
	public List<Localidade> findLocalityByVillageCode(BigDecimal village);

}
