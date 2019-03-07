package com.indra.iopen.repositories.model.ims;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import com.indra.iopen.model.ims.SgdValor;
import com.indra.iopen.model.ims.SgdValorPK;

public interface SgdValorRepository extends CrudRepository<SgdValor, SgdValorPK> {
	List<SgdValor> findSgdValorByIdCodif(String codif,Sort sort);

	List<SgdValor> findSgdValorByIdCodifAndIdValor(String codif, String valor);
}
