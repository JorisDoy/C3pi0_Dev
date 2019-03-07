package com.indra.iopen.repositories.model.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.indra.iopen.pojo.MonthBillingData;

@Repository
public class ApmedidaCoRepositoryImpl implements ApmedidaCoRepositoryCustom {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Long getNextIdApaCo() {
		long idApaCo = ((BigDecimal) entityManager.createNativeQuery("SELECT ICSPROD.ID_AP_CO.NEXTVAL FROM DUAL")
				.getSingleResult()).longValue();
		return idApaCo;
	}

	@Override
	public List<MonthBillingData> getMonthlyConsumptionDataByContractAndYear(final BigDecimal contract,
			final BigDecimal idApa, List<String> validUsageTypes, List<String> validUsageStatuses, Integer year) {

		final List<MonthBillingData> monthlyBillings = new ArrayList<>();
		final Query query = entityManager.createQuery("select month(co.fLect), SUM(co.csmo)" + " from ApmedidaCo co "
				+ " where co.idApa = :idApa  and co.tipLect in :tipLect and co.estCsmo in :estCsmo AND YEAR(co.fLect)=:year "
				+ " group by month(co.fLect) order by month(co.fLect)");

		query.setParameter("idApa", idApa);
		query.setParameter("tipLect", validUsageTypes);
		query.setParameter("estCsmo", validUsageStatuses);
		query.setParameter("year", year);

		final List<Object[]> resultList = query.getResultList();
		for (final Object[] objects : resultList) {
			monthlyBillings.add(new MonthBillingData(Integer.toString(contract.intValue()), year, (Integer) objects[0],
					0L, ((BigDecimal) objects[1]).longValue()));
		}

		return monthlyBillings;
	}
}
