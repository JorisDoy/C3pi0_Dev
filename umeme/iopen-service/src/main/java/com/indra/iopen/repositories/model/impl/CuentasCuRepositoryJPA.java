package com.indra.iopen.repositories.model.impl;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.indra.iopen.model.CuentasCu;
import com.indra.iopen.repositories.BaseRepository;
import com.indra.iopen.repositories.model.CuentasCuRepository;

/**
 * The persistent class for the CUENTAS_CU database table.
 *
 */
@Repository
public class CuentasCuRepositoryJPA extends BaseRepository<CuentasCu>implements CuentasCuRepository, Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public CuentasCuRepositoryJPA() {
		this.entityClass = CuentasCu.class;
	}

	@Override
	public CuentasCu findCuentasCuByCodCli(BigDecimal codCli) {
		List<CuentasCu> cuentasCus = this.entityManager
				.createQuery("select c from CuentasCu c where c.codCli = :codCli").setParameter("codCli", codCli)
				.getResultList();

		if (cuentasCus.isEmpty()) {
			return null;
		} else {
			return cuentasCus.get(0);
		}
	}

}