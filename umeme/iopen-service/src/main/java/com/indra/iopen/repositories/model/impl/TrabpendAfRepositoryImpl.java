package com.indra.iopen.repositories.model.impl;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.indra.iopen.model.TrabpendAf;

@Repository
public class TrabpendAfRepositoryImpl implements TrabpendAfRepositoryCustom {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public final TrabpendAf findTrabpendAfToBeUpdatedWhenCommitingInspectionResults(final Long numOs,
			final String estAf, final String estOs) {
		TrabpendAf trabpendAf = null;
		try {
			final Query query = entityManager.createQuery(" SELECT tr FROM TrabpendAf tr WHERE tr.numAf IN "
					+ " (SELECT d.numAf FROM TrabpendAf d,AnTrabpendAf f "
					+ " WHERE ((f.numOs = :numOs and d.estAf like :estAf ) and d.numAf=f.id.numAf ) and d.numAf "
					+ " not in (SELECT a.id.numAf FROM AnTrabpendAf a, Ordene b, TrabpendAf c "
					+ " WHERE ((((a.numOs=b.numOs and a.numOs = :numOs ) and c.estAf LIKE :estAf ) "
					+ " and c.numAf=a.id.numAf) and b.estOs = :estOs )))");

			query.setParameter("numOs", numOs);
			query.setParameter("estAf", estAf);
			query.setParameter("estOs", estOs);
			trabpendAf = (TrabpendAf) query.getSingleResult();

			if (trabpendAf == null) {
				return null;
			} else {
				return trabpendAf;
			}
		} catch (NoResultException e) {
			// e.printStackTrace();
			return null;
		}
	}

}
