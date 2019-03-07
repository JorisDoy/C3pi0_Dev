package com.indra.iopen.web;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.indra.iopen.form.Contract;
import com.indra.iopen.form.ContractConsumption;
import com.indra.iopen.form.ContractNumberYearFilter;
import com.indra.iopen.model.security.users.ClientUser;
import com.indra.iopen.service.BillListingService;
import com.indra.iopen.service.ConsumptionListService;
import com.indra.iopen.service.ContractService;

@Controller
@RequestMapping("/client/contract")
public class ConsumptionListController {

	@Autowired
	private ConsumptionListService consumptionListService;
	@Autowired
	private ContractService contractService;
	@Autowired
	private BillListingService billListingService;

	private ContractNumberYearFilter globalContractNumberYearFilter;

	@RequestMapping(value = "/consumption")
	public String showCustomerConsumptions(Model model) throws Exception {

		ContractNumberYearFilter contractNumberYearFilter = globalContractNumberYearFilter;
		globalContractNumberYearFilter = null;

		if (contractNumberYearFilter == null) {
			final ClientUser clientUser = (ClientUser) SecurityContextHolder.getContext().getAuthentication()
					.getPrincipal();
			// Contract contracts =
			// contractService.getClientContracts(clientUser.getClienteProfile().getCodCli()).get(0);

			List<Contract> contractsList = contractService
					.getClientContracts(clientUser.getClienteProfile().getCodCli());

			Contract contracts = new Contract();

			if (contractsList.size() > 0 && contractsList != null) {
				contracts = contractsList.get(0);

				Integer year = billListingService.getMaxBillYear(new BigDecimal(contracts.getContractNumber()));

				Calendar cal = Calendar.getInstance();

				String currentYear = String.valueOf(cal.get(Calendar.YEAR));
				if (year != null) {
					currentYear = String.valueOf(year);
				}
				// String currentYear =
				// consumptionListService.getMaxConsumptionYear(Long.valueOf(contracts.getContractNumber()))
				// .toString();
				int page = 1;

				contractNumberYearFilter = new ContractNumberYearFilter(Long.valueOf(contracts.getContractNumber()),
						currentYear, page, 20);
			} else {
				contractNumberYearFilter = new ContractNumberYearFilter(null, null, 1, 20);
			}
		}

		model = processConsumptionList(model, contractNumberYearFilter);
		return "contract_consumption_list";
	}

	@RequestMapping(value = "/consumption", method = RequestMethod.POST)
	public String filterConsumptions(@Valid ContractNumberYearFilter contractNumberYearFilter, Model model,
			final Errors errors) throws Exception {

		model = processConsumptionList(model, contractNumberYearFilter);
		return "contract_consumption_list";

		// return "redirect:/client/contract/consumption?contractNumber="
		// + contractNumberYearFilter.getBillContractNumber() + "&year=" +
		// contractNumberYearFilter.getBillYear()
		// + "&page=1";
	}

	@RequestMapping(value = "/specific/consumption")
	public String showCustomerUsageWithContractSelected(Model model,
			@RequestParam(value = "contractNumber", required = true) String contractNumber,
			@RequestParam(value = "year", required = false) String year) throws Exception {

		if (year == null) {
			Integer yearInt = billListingService.getMaxBillYear(new BigDecimal(contractNumber));

			Calendar cal = Calendar.getInstance();

			year = String.valueOf(cal.get(Calendar.YEAR));
			if (yearInt != null) {
				year = String.valueOf(yearInt);
			}
		}

		int page = 1;
		Long contractLong = null;
		if (!contractNumber.isEmpty() && contractNumber != null && !contractNumber.equalsIgnoreCase("null")) {
			contractLong = Long.valueOf(contractNumber);
		}
		globalContractNumberYearFilter = new ContractNumberYearFilter(contractLong, year, page, 20);

		return "redirect:/client/contract/consumption";
	}

	private Model processConsumptionList(Model model, ContractNumberYearFilter contractNumberYearFilter)
			throws Exception {
		final ClientUser clientUser = (ClientUser) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();

		Long id = contractNumberYearFilter.getBillContractNumber();
		String year = contractNumberYearFilter.getBillYear();
		int page = contractNumberYearFilter.getPage();

		List<ContractConsumption> consumptions = new ArrayList<ContractConsumption>();
		int numberOfPages = 0;
		List<Integer> filterYears = new ArrayList<Integer>();
		List<Contract> contracts = new ArrayList<Contract>();

		if (id != null) {
			consumptions = consumptionListService.getConsumptionsByNisRad(id, year, page, 20);
			numberOfPages = consumptionListService.getNumberOfPages(id, year, 20);

			filterYears = consumptionListService.getConsumptionYears(id);
			contracts = contractService.getClientContracts(clientUser.getClienteProfile().getCodCli());
		}
		// else {
		// filterYears = billListingService.getBillYearList();
		// }

		model.addAttribute("contractNumberYearFilter", new ContractNumberYearFilter(id, year, page, 20));
		model.addAttribute("contracts", contracts);
		model.addAttribute("yearsLength", filterYears.size());
		model.addAttribute("years", filterYears);
		model.addAttribute("consumptions", consumptions);
		model.addAttribute("noOfPages", numberOfPages);
		model.addAttribute("contractNumber", id);
		model.addAttribute("page", page);

		return model;
	}

	@RequestMapping(value = "/consumption/years", method = RequestMethod.GET)
	public @ResponseBody List<Integer> findContractConsumptionYears(
			@RequestParam(value = "contractNumber", required = true) Long contractNumber) {
		return consumptionListService.getConsumptionYears(contractNumber);
	}
}
