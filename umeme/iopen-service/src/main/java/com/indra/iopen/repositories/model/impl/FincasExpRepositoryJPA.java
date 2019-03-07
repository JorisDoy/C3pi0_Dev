package com.indra.iopen.repositories.model.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

/**
 * The persistent class for the FINCAS_EXP database table.
 *
 */
@Repository
public class FincasExpRepositoryJPA implements FincasExpRepositoryCustom {
	@PersistenceContext
	private EntityManager entityManager;

}