package com.indra.iopen.repositories.model.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.indra.iopen.form.BillDispatchForm;

public class BillDispatchRepositoryImpl implements BillDispatchRepositoryCustom {
	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<BillDispatchForm> getBillDispatchMethodsOfASpecificContract(Long contractNumber) {
		List<BillDispatchForm> billDispatchs = entityManager
				.createQuery(
						"select new com.indra.iopen.form.BillDispatchForm(bill.id.nisRad,bill.id.tipDispatch,bill.fActual) FROM BillDispatch bill WHERE bill.id.nisRad= :nisRad")
				.setParameter("nisRad", contractNumber).getResultList();
		return billDispatchs;
	}

	/*
	 * @SuppressWarnings("unchecked")
	 *
	 * @Override public List<BillDispatchForm> getBillDispatchMethods() {
	 * List<BillDispatchForm> billDispatchs = entityManager .createQuery(
	 * "select new com.indra.iopen.form.BillDispatchForm(bill.id.nisRad,bill.id.tipDispatch,bill.fActual,0) "
	 * + " FROM BillDispatch bill") .getResultList();
	 *
	 * return billDispatchs; }
	 */

}
