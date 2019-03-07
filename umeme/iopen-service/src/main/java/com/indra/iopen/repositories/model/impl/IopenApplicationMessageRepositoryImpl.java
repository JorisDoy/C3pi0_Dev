package com.indra.iopen.repositories.model.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

//SMA 20160314
@Repository
public class IopenApplicationMessageRepositoryImpl implements IopenApplicationMessageCustom {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Long findMaxIdSecIdByIdCodApplication(Long codApplication) {

		return (Long) entityManager
				.createQuery(
						"select max(mes.id.secId) from IopenApplicationMessage mes where mes.id.codApplication = :codApplication")
				.setParameter("codApplication", codApplication).getSingleResult();

	}
}
