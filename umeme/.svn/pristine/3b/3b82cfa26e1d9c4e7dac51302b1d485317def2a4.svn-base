package com.indra.iopen.repositories.model.ims;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.indra.iopen.model.ims.GiAvisosLlamada;

public class GiAvisosLlamadaRepositoryImpl implements GiAvisosLlamadaRepositoryCustom {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertIntoGiAvisosLlamada(GiAvisosLlamada giAvisosLlamada) {
		String query = "Insert into IMSPROD.GI_AVISOS_LLAMADAS@IMS " + " (NRO_AVISO, F_LLAMADA, NOM_OPERADOR) "
				+ "  Values " + "    (:nroAviso, :fLlamada, :nomOperador)";

		entityManager.createNativeQuery(query).setParameter("nroAviso", giAvisosLlamada.getNroAviso())
				.setParameter("fLlamada", giAvisosLlamada.getFLlamada())
				.setParameter("nomOperador", giAvisosLlamada.getNomOperador()).executeUpdate();
	}
}
