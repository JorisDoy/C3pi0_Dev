package com.indra.iopen.repositories.model.impl;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

/**
 * The persistent class for the SUMCON database table.
 *
 */
@Repository
public class SumconRepositoryImpl implements SumconRepositoryCustom {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Long getNextNisRadValue() {
		final Long nisRad = ((BigDecimal) entityManager.createNativeQuery("SELECT ICSPROD.SUMCON_NIS_RAD.NEXTVAL FROM DUAL")
				.getSingleResult()).longValue();
		return nisRad;
	}
}