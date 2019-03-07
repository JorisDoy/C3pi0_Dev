package com.indra.iopen.repositories.model;

import org.springframework.data.repository.CrudRepository;

import com.indra.iopen.model.BdgActOfiAux;
import com.indra.iopen.repositories.model.impl.BdgActOfiAuxRepositoryCustom;

public interface BdgActOfiAuxRepository extends CrudRepository<BdgActOfiAux, BdgActOfiAux>,BdgActOfiAuxRepositoryCustom {

}
