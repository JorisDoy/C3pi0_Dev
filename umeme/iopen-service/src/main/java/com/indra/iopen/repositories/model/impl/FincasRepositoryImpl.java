package com.indra.iopen.repositories.model.impl;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class FincasRepositoryImpl implements FincasRepositoryCustom {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public long getNifNextVal() {
		long nif = ((BigDecimal) this.entityManager.createNativeQuery("SELECT ICSPROD.NIF.NEXTVAL FROM DUAL")
				.getSingleResult()).longValue();
		return nif;
	}
}
