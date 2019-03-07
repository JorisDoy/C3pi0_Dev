package com.indra.iopen.repositories.model;

import org.springframework.data.repository.CrudRepository;

import com.indra.iopen.model.PresupuestosExped;
import com.indra.iopen.model.PresupuestosExpedPK;
import com.indra.iopen.repositories.model.impl.PresupuestosExpedRepositoryCustom;

/**
 * The persistent interface for the PRESUPUESTOS_EXPED database table.
 *
 */
public interface PresupuestosExpedRepository
extends CrudRepository<PresupuestosExped, PresupuestosExpedPK>, PresupuestosExpedRepositoryCustom {
	/**
	 * UMESCI-713 Find PresupuestosExped by the parameters
	 *
	 * @param numExp
	 * @param tipMovValue
	 * @param billStatusActive
	 * @return
	 */
	PresupuestosExped findPresupuestosExpedByIdNumExpAndTipMovAndEstado(String numExp, String tipMovValue,
			String billStatusActive);


}