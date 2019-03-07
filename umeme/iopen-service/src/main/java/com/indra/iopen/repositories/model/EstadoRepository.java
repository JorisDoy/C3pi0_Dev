package com.indra.iopen.repositories.model;

import java.util.List;

import com.indra.iopen.model.Estado;
import com.indra.iopen.repositories.MasterDataRepository;

public interface EstadoRepository extends MasterDataRepository<Estado> {
	public Estado findEstadoByDesc(String statusDescFilter);

	public List<Estado> findEstadoLike(String filter);
}
