package com.indra.iopen.repositories.model;

import java.math.BigDecimal;
import java.util.List;

import com.indra.iopen.model.Personal;
import com.indra.iopen.repositories.MasterDataRepository;

public interface PersonalRepository extends MasterDataRepository<Personal> {

	public List<Personal> findPersonalWithServiceOrderNo(Long numOs);

	public List<Personal> findPersonalByCodUnicom(BigDecimal codUnicom);

}
