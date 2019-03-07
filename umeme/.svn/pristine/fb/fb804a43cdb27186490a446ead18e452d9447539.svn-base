package com.indra.iopen.repositories.model.impl;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class TrabpendReRepositoryImpl implements TrabpendReRepositoryCustom {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Long getNextIdNumRe() {
		long numRe = ((BigDecimal) entityManager.createNativeQuery("SELECT NUM_RECLAM.NEXTVAL FROM DUAL")
				.getSingleResult()).longValue();
		return numRe;
	}
}
