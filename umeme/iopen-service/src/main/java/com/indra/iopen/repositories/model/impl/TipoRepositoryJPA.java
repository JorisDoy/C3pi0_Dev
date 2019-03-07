package com.indra.iopen.repositories.model.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.indra.iopen.model.Tipo;
import com.indra.iopen.repositories.BaseRepository;
import com.indra.iopen.repositories.model.TipoRepository;

@Repository
public class TipoRepositoryJPA extends BaseRepository<Tipo>implements TipoRepository {

	public TipoRepositoryJPA() {
		entityClass = Tipo.class;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Tipo> findTipoLike(String filter) {

		return entityManager.createQuery("select t from Tipo t where t.tipo like :tipo and indInUse = :indInUse")
				.setParameter("tipo", filter + "%").setParameter("indInUse", new BigDecimal(1)).getResultList();
	}

	// @Override
	// public Tipo findTipo(String tipo){
	// return (Tipo) this.entityManager
	// .createQuery("select t from Tipo t where t.tipo = :tipo")
	// .setParameter("tipo", tipo)
	// .getSingleResult();
	// }

}
