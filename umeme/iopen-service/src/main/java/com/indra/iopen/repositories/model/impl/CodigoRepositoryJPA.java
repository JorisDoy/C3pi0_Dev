package com.indra.iopen.repositories.model.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.indra.iopen.model.Codigo;
import com.indra.iopen.repositories.BaseRepository;
import com.indra.iopen.repositories.model.CodigoRepository;

@Repository
public class CodigoRepositoryJPA extends BaseRepository<Codigo>implements CodigoRepository {

	public CodigoRepositoryJPA() {
		entityClass = Codigo.class;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Codigo> findCodigoLike(String filter) {
		return entityManager.createQuery("select c from Codigo c where c.cod like :cod")
				.setParameter("cod", filter + "%").getResultList();
	}

}
