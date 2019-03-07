package com.indra.iopen.repositories.model.impl;

import java.util.List;

import com.indra.iopen.model.PresupuestosExped;

public interface PresupuestosExpedRepositoryCustom {
	public List<PresupuestosExped> findPresupuestosExpedByIdNumExp(String numExp);

	public String findPresupuestosExpedInvoiceType(String tipMov);

	long getMaxPresupuestosSecByNumExp(String numExp);

	List<PresupuestosExped> findPresupuestosExpedByIdNumExpAndEstado(String numExp, String estado);

}
