package com.indra.iopen.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;import java.util.Objects;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.indra.iopen.form.Contract;
import com.indra.iopen.model.ApmedidaAp;
import com.indra.iopen.model.ClienteProfile;
import com.indra.iopen.model.security.util.SecurityUtil;
import com.indra.iopen.pojo.ContractBillingData;
import com.indra.iopen.pojo.MonthBillingData;
import com.indra.iopen.pojo.YearBillingData;
import com.indra.iopen.repositories.model.ApmedidaApRepository;
import com.indra.iopen.repositories.model.ApmedidaCoRepository;
import com.indra.iopen.repositories.model.GrupoEstRepository;
import com.indra.iopen.repositories.model.SumconRepository;
import com.indra.iopen.service.ConsumptionInformationService;
import com.indra.iopen.service.ContractService;

@Service
public class ConsumptionInformationServiceImpl implements ConsumptionInformationService {

	@Autowired
	private GrupoEstRepository grupoEstRepository;

	@Autowired
	private SumconRepository sumconRepository;

	@Autowired
	private ApmedidaApRepository apmedidaApRepository;

	@Autowired
	private ApmedidaCoRepository apmedidaCoRepository;

	@Autowired
	private ContractService contractService;

	@Autowired
	private Environment env;

	@Override
	public List<ContractBillingData> loadUserConsumptiondata() {
		final List<ContractBillingData> contractsBillingData = new ArrayList<ContractBillingData>();

		// load username
		final ClienteProfile profile = SecurityUtil.getLoggedClientProfile().getClienteProfile();

		// final List<Contract> contracts =
		// loadAvailableContractsPerUser(BigDecimal.valueOf(profile.getCodCli()));
		final List<Contract> contracts = contractService.getClientContracts(profile.getCodCli());

		for (final Contract contract : contracts) {
			final ContractBillingData billingData = new ContractBillingData(contract);
			contractsBillingData.add(billingData);
			// Find valid usage types and usage statuses to display online
			final String validUsageStatusesCode = env.getProperty("consumption.grupoEst.co_grupo.est_csmo_group.value");
			final String validUsageTypesCode = env.getProperty("consumption.grupoEst.co_grupo.tip_csmo_group.value");
			final List<String> validUsageStatuses = grupoEstRepository.findEstRecByidCoGrupo(validUsageStatusesCode);
			final List<String> validUsageTypes = grupoEstRepository.findEstRecByidCoGrupo(validUsageTypesCode);

			// Find the idApa used to search for usages
			final BigDecimal numSum = sumconRepository.findOne(Long.valueOf(contract.getContractNumber())).getNumSum();
			final ApmedidaAp apmedidaAp = apmedidaApRepository.findApmedidaApByNumSum(numSum);

			final List<Integer> years = loadAvialableConsumptionYearsPerContract(
					Long.valueOf(contract.getContractNumber()));

			for (final Integer year : years) {
				final YearBillingData yearlyBilling = new YearBillingData(year);
				billingData.addYearBilling(yearlyBilling);

				final List<MonthBillingData> monthBills = loadMonthlyConsumption(
						new BigDecimal(contract.getContractNumber()), BigDecimal.valueOf(apmedidaAp.getIdApa()),
						validUsageTypes, validUsageStatuses, year);

				yearlyBilling.getMonthBills().addAll(monthBills);
			}
		}

		return contractsBillingData;
	}

	private List<Long> loadAvailableContractsPerUser(final BigDecimal codCli) {
		final List<Long> contracts = sumconRepository.findNisRadByCodCliOrderByNisRadAsc(codCli);
		return contracts;
	}

	private List<Integer> loadAvialableConsumptionYearsPerContract(final Long contract) {
		// Find valid usage types and usage statuses to display online
		final String validUsageStatusesCode = env.getProperty("consumption.grupoEst.co_grupo.est_csmo_group.value");
		final String validUsageTypesCode = env.getProperty("consumption.grupoEst.co_grupo.tip_csmo_group.value");
		final List<String> validUsageStatuses = grupoEstRepository.findEstRecByidCoGrupo(validUsageStatusesCode);
		final List<String> validUsageTypes = grupoEstRepository.findEstRecByidCoGrupo(validUsageTypesCode);

		// Find the idApa used to search for usages
		final BigDecimal numSum = sumconRepository.findOne(contract).getNumSum();
		final ApmedidaAp apmedidaAp = apmedidaApRepository.findApmedidaApByNumSum(numSum);
		List<Integer> years = null;
		if (apmedidaAp != null) {
			years = apmedidaCoRepository.findDistinctConsumptionYears(BigDecimal.valueOf(apmedidaAp.getIdApa()),
					validUsageTypes, validUsageStatuses);
		} else {
			years = new ArrayList<>();
		}

		return years;
	}

	private List<MonthBillingData> loadMonthlyConsumption(final BigDecimal contract, final BigDecimal idApa,
			List<String> validUsageTypes, List<String> validUsageStatuses, final Integer year) {
		return apmedidaCoRepository.getMonthlyConsumptionDataByContractAndYear(contract, idApa, validUsageTypes,
				validUsageStatuses, year);
	}
}
