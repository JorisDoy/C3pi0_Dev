package com.indra.iopen.repositories.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.indra.iopen.pojo.MonthBillingData;

@Repository
public class ReciboRepositoryImpl implements ReciboRepositoryCustom {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<MonthBillingData> getMonthlyBillingDataByContractAndYear(final BigDecimal contract,
			final Integer year) {
		final List<MonthBillingData> monthlyBillings = new ArrayList<>();
		final Query query = manager.createQuery("select month(r.fFact), SUM(r.impTotRec)" + " from Recibo r "
				+ " where r.nisRad=:contract " + " AND r.tipRec in ('TR010') " + " AND YEAR(r.fFact)=:year "
				+ " group by month(r.fFact) " + " order by month(r.fFact)");
		query.setParameter("contract", contract);
		query.setParameter("year", year);

		final List<Object[]> resultList = query.getResultList();
		for (final Object[] objects : resultList) {
			monthlyBillings.add(new MonthBillingData(Integer.toString(contract.intValue()), year, (Integer) objects[0],
					((BigDecimal) objects[1]).longValue()));
		}

		return monthlyBillings;
	}

	@Override
	public List<MonthBillingData> getMonthlyConsumptionDataByContractAndYear(final BigDecimal contract,
			final Integer year) {
		final List<MonthBillingData> monthlyBillings = new ArrayList<>();
		final Query query = manager.createQuery("select month(r.fFact) , sum(i.impConcepto) , sum(i.csmoFact)  "
				+ "from ImpConcepto i, Recibo r " + "where i.id.numRec = r.numRec " + "and r.nisRad = :contract "
				+ "and year(r.fFact) = :year " + "group by month(r.fFact) " + "order by month(r.fFact)");
		query.setParameter("contract", contract);
		query.setParameter("year", year);

		final List<Object[]> resultList = query.getResultList();
		for (final Object[] objects : resultList) {
			monthlyBillings.add(new MonthBillingData(Integer.toString(contract.intValue()), year, (Integer) objects[0],
					((BigDecimal) objects[1]).longValue(), ((BigDecimal) objects[2]).longValue()));
		}

		return monthlyBillings;
	}

}
