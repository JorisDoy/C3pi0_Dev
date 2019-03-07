package com.indra.iopen.repositories.model.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.indra.iopen.model.BdgActOfiAux;

public class BdgActOfiAuxRepositoryImpl implements BdgActOfiAuxRepositoryCustom {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertIntoBdgActOfiAux(BdgActOfiAux bdgActOfiAux) {
		String query = "Insert into ICSPROD.BDG_ACT_OFI_AUX (USUARIO, F_ACTUAL, PROGRAMA, FECHA, COD_UNICOM, TIP_ACT_OF) "
				+ "Values (:usuario, :fActual, :programa, :fecha, :codUnicom, :tipActOf)";

		entityManager.createNativeQuery(query)
				.setParameter("usuario", bdgActOfiAux.getUsuario()).setParameter("fActual", bdgActOfiAux.getFActual())
				.setParameter("programa", bdgActOfiAux.getPrograma()).setParameter("fecha", bdgActOfiAux.getFecha())
				.setParameter("codUnicom", bdgActOfiAux.getCodUnicom()).setParameter("tipActOf", bdgActOfiAux.getTipActOf()).executeUpdate();
	}
}
