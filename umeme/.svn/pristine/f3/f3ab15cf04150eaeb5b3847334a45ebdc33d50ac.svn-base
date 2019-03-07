package com.indra.iopen.repositories.model.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.indra.iopen.model.PresupuestosExped;

/**
 * The persistent class for the PRESUPUESTOS_EXPED database table.
 *
 */
@Repository
@SuppressWarnings("unchecked")
public class PresupuestosExpedRepositoryImpl implements PresupuestosExpedRepositoryCustom {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<PresupuestosExped> findPresupuestosExpedByIdNumExp(String numExp) {

		final List<PresupuestosExped> presupuestosExpeds = entityManager
				.createQuery("select p from PresupuestosExped p where p.id.numExp= :numExp ")
				.setParameter("numExp", numExp).getResultList();

		return presupuestosExpeds;
	}

	@Override
	public List<PresupuestosExped> findPresupuestosExpedByIdNumExpAndEstado(String numExp, String estado) {

		final List<PresupuestosExped> presupuestosExpeds = entityManager
				.createQuery("select p from PresupuestosExped p where p.id.numExp= :numExp and p.estado = :estado ")
				.setParameter("numExp", numExp).setParameter("estado", estado).getResultList();

		return presupuestosExpeds;
	}

	@Override
	public String findPresupuestosExpedInvoiceType(String tipMov) {
		final String invoiceType = (String) entityManager
				.createNativeQuery("SELECT DESC_CONN_FEE_ITEMS FROM CONN_FEE_ITEMS WHERE TIP_MOV = :tipMov")
				.setParameter("tipMov", tipMov).getSingleResult();

		return invoiceType;
	}

	@Override
	public long getMaxPresupuestosSecByNumExp(String numExp) {

		return (Long) entityManager
				.createQuery("select max(p.id.presupuestosSec) from PresupuestosExped p where p.id.numExp = :numExp")
				.setParameter("numExp", numExp).getSingleResult();
	}
}