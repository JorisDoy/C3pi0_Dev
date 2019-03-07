package com.indra.iopen.repositories.model;

import org.springframework.data.repository.CrudRepository;

import com.indra.iopen.model.ApaTipCarac;
import com.indra.iopen.model.ApaTipCaracPK;

public interface ApaTipCaracRepository extends CrudRepository<ApaTipCarac, ApaTipCaracPK> {

	ApaTipCarac findApaTipCaracByIdTipApaAndIdCoMarcaAndIdCoModelo(String tipApa, String coMarca, String coModelo);
}
