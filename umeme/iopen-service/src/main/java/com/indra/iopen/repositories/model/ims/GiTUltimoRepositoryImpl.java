package com.indra.iopen.repositories.model.ims;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.indra.iopen.model.ims.GiTUltimo;

public class GiTUltimoRepositoryImpl implements GiTUltimoRepositoryCustom {
	@PersistenceContext
	private EntityManager entityManager;
	@Override
	public GiTUltimo getGiTUltimoRepositoryByTableName(String tableName) {
		GiTUltimo giTUltimo=(GiTUltimo) entityManager.createQuery("Select gi From GiTUltimo gi Where gi.id.tabla = :tabla").setParameter("tabla", tableName).getResultList().get(0);
		return giTUltimo;
	}

}
