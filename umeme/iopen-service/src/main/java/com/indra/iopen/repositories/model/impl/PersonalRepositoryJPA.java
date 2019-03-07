package com.indra.iopen.repositories.model.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.indra.iopen.model.Personal;
import com.indra.iopen.repositories.BaseRepository;
import com.indra.iopen.repositories.model.PersonalRepository;

@Repository
public class PersonalRepositoryJPA extends BaseRepository<Personal>implements PersonalRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Personal> findPersonalWithServiceOrderNo(Long numOs) {

		return entityManager
				.createQuery("select p from Personal p, Ordene o "
						+ "where p.codUnicom = o.codUnicom and p.tipEmp like :tipEmpLike " + "and p.estEmp = :estEmp "
						+ "and o.numOs = :numOs")
				.setParameter("tipEmpLike", "PN1%").setParameter("estEmp", "EE001").setParameter("numOs", numOs)
				.getResultList();
	}

	@Override
	public List<Personal> findPersonalByCodUnicom(BigDecimal codUnicom) {

		return entityManager.createNamedQuery("Personal.findCodUnicom").setParameter("codUnicom", codUnicom)
				.getResultList();
	}
}
