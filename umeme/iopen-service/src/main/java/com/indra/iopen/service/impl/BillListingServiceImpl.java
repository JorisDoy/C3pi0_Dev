package com.indra.iopen.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;import java.util.Objects;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.indra.iopen.form.ContractBill;
import com.indra.iopen.model.Recibo;
import com.indra.iopen.repositories.model.EstadoRepository;
import com.indra.iopen.repositories.model.ReciboRepository;
import com.indra.iopen.repositories.model.TipoRepository;
import com.indra.iopen.service.BillListingService;

@Service
@PropertySource("classpath:application.properties")
public class BillListingServiceImpl implements BillListingService {

	@Autowired
	private ReciboRepository reciboRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private TipoRepository tipoRepository;

	@Autowired
	private Environment env;

	@Override
	public List<ContractBill> getContractBills(Long contractNumber, String year, int page, int recordsPerPage) {
		final List<ContractBill> contractBills = new ArrayList<ContractBill>();

		// String[] tipRecs = {
		// env.getProperty("bill.recibo.tip_rec.installment_agreement_quota.value"),
		// env.getProperty("bill.recibo.tip_rec.closed_installment_agreement.value")
		// };

		// recibos.addAll(reciboRepository.findReciboByWithBalanceAndCodCtaPagoOfNisRadAndTipRec(
		// BigDecimal.valueOf(contractNumber), Arrays.asList(tipRecs), new
		// Date()));

		// List<Recibo> recibos =
		// reciboRepository.findReciboByWithBalanceAndCodCtaPagoOfNisRadAndTipRec(
		// BigDecimal.valueOf(contractNumber), Arrays.asList(tipRecs), new
		// Date(),
		// new PageRequest(page - 1, recordsPerPage, Direction.ASC, "numRec"));

		if (contractNumber != null && contractNumber != 0) {
			List<Recibo> recibos = new ArrayList<Recibo>();
			final String billListCoGrupo = env.getProperty("bill.recibo.grupo_est.co_grupo.value");

			if (year.equalsIgnoreCase("ALL")) {
				// recibos =
				// reciboRepository.findReciboByNisRad(BigDecimal.valueOf(contractNumber),
				// new PageRequest(page - 1, recordsPerPage, Direction.DESC,
				// "fFact"));

				recibos = reciboRepository.findReciboByNisRadAndCoGrupo(BigDecimal.valueOf(contractNumber),
						billListCoGrupo, new PageRequest(page - 1, recordsPerPage, Direction.DESC, "fFact"));

			} else {

				final Calendar calendarStart = Calendar.getInstance();
				calendarStart.set(Calendar.YEAR, Integer.valueOf(year));
				calendarStart.set(Calendar.MONTH, 0);
				calendarStart.set(Calendar.DAY_OF_MONTH, 1);
				// returning the first date
				final Date startDate = calendarStart.getTime();

				final Calendar calendarEnd = Calendar.getInstance();
				calendarEnd.set(Calendar.YEAR, Integer.valueOf(year));
				calendarEnd.set(Calendar.MONTH, 11);
				calendarEnd.set(Calendar.DAY_OF_MONTH, 31);

				// returning the last date
				final Date endDate = calendarEnd.getTime();

				// recibos =
				// reciboRepository.findReciboByNisRadAndFFactBetween(BigDecimal.valueOf(contractNumber),
				// startDate,
				// endDate, new PageRequest(page - 1, recordsPerPage,
				// Direction.DESC, "fFact"));
				recibos = reciboRepository.findReciboByNisRadAndFFactBetweenAndCoGrupo(
						BigDecimal.valueOf(contractNumber), startDate, endDate, billListCoGrupo,
						new PageRequest(page - 1, recordsPerPage));

			}

			recibos.parallelStream().filter(Objects::nonNull).forEach((recibo) -> {
				final ContractBill contractBill = new ContractBill();

				contractBill.setBillingDate(recibo.getFFact());
				contractBill.setBillNumber(recibo.getNumRec());
				contractBill.setBillStatementId(recibo.getIdStatement().longValue());

				contractBill.setBillStatus(estadoRepository.findById(recibo.getEstAct()).getDescEst());
				contractBill.setTypeOfBill(tipoRepository.findById(recibo.getTipRec()).getDescTipo());

				contractBill.setBillAmount(recibo.getImpTotRec().doubleValue());
				contractBill.setPaidAmount(recibo.getImpCta().doubleValue());
				contractBill.setOutstandingAmount(contractBill.getBillAmount() - contractBill.getPaidAmount());

				contractBills.add(contractBill);
			});

		}
		return contractBills;
	}

	@Override
	public List<ContractBill> getBillCodesForComplaints(Long contractNumber) {
		final List<ContractBill> contractBills = new ArrayList<ContractBill>();
		final String billListCoGrupo = env.getProperty("bill.recibo.grupo_est.co_grupo.forcomplaints.value");
		final List<Recibo> recibos = reciboRepository.findReciboByNisRadAndCoGrupo(BigDecimal.valueOf(contractNumber),
				billListCoGrupo, null);

		recibos.parallelStream().forEach((recibo) -> {
			final ContractBill contractBill = new ContractBill();

			contractBill.setBillingDate(recibo.getFFact());
			contractBill.setBillNumber(recibo.getNumRec());
			contractBill.setBillStatementId(recibo.getIdStatement().longValue());

			contractBill.setBillStatus(estadoRepository.findById(recibo.getEstAct()).getDescEst());
			contractBill.setTypeOfBill(tipoRepository.findById(recibo.getTipRec()).getDescTipo());

			contractBill.setBillAmount(recibo.getImpTotRec().doubleValue());
			contractBill.setPaidAmount(recibo.getImpCta().doubleValue());
			contractBill.setOutstandingAmount(contractBill.getBillAmount() - contractBill.getPaidAmount());

			contractBills.add(contractBill);
		});
		return contractBills;
	}

	@Override
	public int getNumberOfPages(Long contractNumber, String year, int recordsPerPage) {

		// String[] tipRecs = {
		// env.getProperty("bill.recibo.tip_rec.installment_agreement_quota.value"),
		// env.getProperty("bill.recibo.tip_rec.closed_installment_agreement.value")
		// };
		//
		// Long records =
		// reciboRepository.findReciboCountByNisRad(BigDecimal.valueOf(contractNumber),
		// Arrays.asList(tipRecs), new Date());
		Long records = 0L;
		//SMA 20160318
		if(contractNumber!=null){
			if (year.equalsIgnoreCase("ALL")) {
				records = reciboRepository.findReciboCountByNisRad(BigDecimal.valueOf(contractNumber));
			} else {

				final Calendar calendarStart = Calendar.getInstance();
				calendarStart.set(Calendar.YEAR, Integer.valueOf(year));
				calendarStart.set(Calendar.MONTH, 0);
				calendarStart.set(Calendar.DAY_OF_MONTH, 1);
				// returning the first date
				final Date startDate = calendarStart.getTime();

				final Calendar calendarEnd = Calendar.getInstance();
				calendarEnd.set(Calendar.YEAR, Integer.valueOf(year));
				calendarEnd.set(Calendar.MONTH, 11);
				calendarEnd.set(Calendar.DAY_OF_MONTH, 31);

				// returning the last date
				final Date endDate = calendarEnd.getTime();

				records = reciboRepository.findReciboCountByNisRadAndFFactBetween(BigDecimal.valueOf(contractNumber),
						startDate, endDate);
			}
		}
		// SMA 20160318
		if (records == null) {
			records = 0l;
		}

		final Double dPages = Math.ceil(records.doubleValue() / recordsPerPage);

		final int pages = dPages.intValue();

		return pages;
	}

	@Override
	public List<Integer> getBillYearList() {

		final List<Integer> years = new ArrayList<Integer>();
		final String period = env.getProperty("bill.year_list_start_year.value");
		final int startYear = new Integer(period);

		final Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		final int endYear = cal.get(Calendar.YEAR);

		for (int i = startYear; i <= endYear; i++) {
			years.add(i);
		}

		return years;
	}

	@Override
	public List<Integer> getContractBillYears(BigDecimal contractNumber) {
		return reciboRepository.getBillingAvailableYearsByContract(contractNumber);
	}

	@Override
	public Integer getMaxBillYear(BigDecimal contractNumber) {
		return reciboRepository.getBillingMaxYearsByContract(contractNumber);
	}

}
