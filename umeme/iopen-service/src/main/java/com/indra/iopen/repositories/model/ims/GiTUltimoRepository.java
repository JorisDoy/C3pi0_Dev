package com.indra.iopen.repositories.model.ims;

import org.springframework.data.repository.CrudRepository;

import com.indra.iopen.model.ims.GiTUltimo;
import com.indra.iopen.model.ims.GiTUltimoPK;

public interface GiTUltimoRepository extends CrudRepository<GiTUltimo, GiTUltimoPK>,GiTUltimoRepositoryCustom {

}
