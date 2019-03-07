package com.indra.iopen.repositories.model;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.indra.iopen.model.Localidade;

public interface LocalidadeRepository extends CrudRepository<Localidade, Long> {
	
	List<Localidade> findLocalidadeByCodMunicAndUsrNumber1OrderByNomLocalAsc(BigDecimal codMunic, BigDecimal usrNumber1);

	List<Localidade> findLocalidadeByUsrNumber1OrderByNomLocalAsc(BigDecimal codMunic);
}
