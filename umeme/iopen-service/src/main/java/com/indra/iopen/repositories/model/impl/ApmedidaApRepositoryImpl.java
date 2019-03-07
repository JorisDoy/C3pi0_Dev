package com.indra.iopen.repositories.model.impl;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class ApmedidaApRepositoryImpl implements ApmedidaApRepositoryCustom {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Long getNextIdApa() {
		long idApa = ((BigDecimal) entityManager.createNativeQuery("SELECT ICSPROD.ID_APA.NEXTVAL FROM DUAL")
				.getSingleResult()).longValue();
		return idApa;
	}

}
