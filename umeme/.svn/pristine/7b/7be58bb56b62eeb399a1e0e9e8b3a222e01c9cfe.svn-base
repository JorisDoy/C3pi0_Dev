package com.indra.iopen.repositories.model.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.indra.iopen.model.Estado;
import com.indra.iopen.repositories.BaseRepository;
import com.indra.iopen.repositories.model.EstadoRepository;

@Repository
public class EstadoRepositoryJPA extends BaseRepository<Estado>implements EstadoRepository {

	public EstadoRepositoryJPA() {
		entityClass = Estado.class;
	}

	@Override
	public Estado findEstadoByDesc(String statusDescFilter) {

		return (Estado) entityManager.createQuery("select e from Estado e where e.descEst like :descEst")
				.setParameter("descEst", statusDescFilter + "%").getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Estado> findEstadoLike(String filter) {

		return entityManager
				.createQuery("select e from Estado e where e.estado like :estado and e.indInUse = 1 order by e.estado")
				.setParameter("estado", filter + "%").getResultList();
	}

	// @Override
	// public Estado findEstado(String estado) {
	// return (Estado) this.entityManager
	// .createQuery("select e from Estado e where e.estado = :estado")
	// .setParameter("estado", estado)
	// .getSingleResult();
	// }

}
