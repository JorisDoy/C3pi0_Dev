package com.indra.iopen.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;import java.util.Objects;
import org.springframework.stereotype.Service;

import com.indra.iopen.form.Contract;
import com.indra.iopen.model.ClienteProfile;
import com.indra.iopen.model.security.util.SecurityUtil;
import com.indra.iopen.pojo.ContractBillingData;
import com.indra.iopen.pojo.MonthBillingData;
import com.indra.iopen.pojo.YearBillingData;
import com.indra.iopen.repositories.model.ReciboRepository;
import com.indra.iopen.repositories.model.SumconRepository;
import com.indra.iopen.service.BillingInformationService;
import com.indra.iopen.service.ContractService;

@Service
public class BillingInformationServiceImpl implements BillingInformationService {

	@Autowired
	private ReciboRepository reciboRepository;

	@Autowired
	private SumconRepository sumconRepository;

	@Autowired
	private ContractService contractService;

	@Override
	public List<ContractBillingData> loadUserBillingdata() {
		final List<ContractBillingData> contractsBillingData = new ArrayList<ContractBillingData>();

		// load username
		final ClienteProfile profile = SecurityUtil.getLoggedClientProfile().getClienteProfile();

		// load user available contracts
		// final List<BigDecimal> contracts =
		// loadAvailableContractsPerUser(profile.getUsuario());
		// final List<Long> contracts =
		// loadAvailableContractsPerUser(BigDecimal.valueOf(profile.getCodCli()));

		final List<Contract> contracts = contractService.getClientContracts(profile.getCodCli());

		for (final Contract contract : contracts) {
			final ContractBillingData billingData = new ContractBillingData(contract);
			contractsBillingData.add(billingData);

			final List<Integer> years = loadAvialableBillingYearsPerContract(
					new BigDecimal(contract.getContractNumber()));

			for (final Integer year : years) {
				final YearBillingData yearlyBilling = new YearBillingData(year);
				billingData.addYearBilling(yearlyBilling);

				final List<MonthBillingData> monthBills = loadMonthlyBilling(
						new BigDecimal(contract.getContractNumber()), year);
				yearlyBilling.getMonthBills().addAll(monthBills);
			}

		}

		return contractsBillingData;
	}

	// private List<BigDecimal> loadAvailableContractsPerUser(final String
	// username) {
	// final List<BigDecimal> contracts =
	// reciboRepository.getContractsByUsuario(username);
	// return contracts;
	// }

	private List<Long> loadAvailableContractsPerUser(final BigDecimal codCli) {
		final List<Long> contracts = sumconRepository.findNisRadByCodCliOrderByNisRadAsc(codCli);
		return contracts;
	}

	private List<Integer> loadAvialableBillingYearsPerContract(final BigDecimal contract) {
		final List<Integer> years = reciboRepository.getBillingAvailableYearsByContract(contract);
		return years;
	}

	private List<MonthBillingData> loadMonthlyBilling(final BigDecimal contract, final Integer year) {
		return reciboRepository.getMonthlyBillingDataByContractAndYear(contract, year);
	}

	// @Override
	// public List<ContractBillingData> loadUserConsumptiondata() {
	// final List<ContractBillingData> contractsBillingData = new
	// ArrayList<ContractBillingData>();
	//
	// // load username
	// final ClienteProfile profile =
	// SecurityUtil.getLoggedClientProfile().getClienteProfile();
	//
	// // load user available contracts
	// // final List<BigDecimal> contracts =
	// // loadAvailableContractsPerUser(profile.getUsuario());
	// final List<Long> contracts =
	// loadAvailableContractsPerUser(BigDecimal.valueOf(profile.getCodCli()));
	//
	// for (final Long contract : contracts) {
	// final ContractBillingData billingData = new
	// ContractBillingData(Integer.toString(contract.intValue()));
	// contractsBillingData.add(billingData);
	//
	// final List<Integer> years =
	// loadAvialableBillingYearsPerContract(BigDecimal.valueOf(contract));
	//
	// for (final Integer year : years) {
	// final YearBillingData yearlyBilling = new YearBillingData(year);
	// billingData.addYearBilling(yearlyBilling);
	//
	// final List<MonthBillingData> monthBills =
	// loadMonthlyConsumption(BigDecimal.valueOf(contract), year);
	// yearlyBilling.getMonthBills().addAll(monthBills);
	// }
	//
	// }
	//
	// return contractsBillingData;
	// }

	private List<MonthBillingData> loadMonthlyConsumption(final BigDecimal contract, final Integer year) {
		return reciboRepository.getMonthlyConsumptionDataByContractAndYear(contract, year);
	}

}
