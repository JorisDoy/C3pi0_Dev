package com.indra.iopen.web;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.indra.iopen.form.Contract;
import com.indra.iopen.form.ContractBill;
import com.indra.iopen.form.ContractNumberYearFilter;
import com.indra.iopen.model.security.users.ClientUser;
import com.indra.iopen.service.BillListingService;
import com.indra.iopen.service.ContractService;
import com.indra.iopen.util.ErrorInfo;

@Controller
@RequestMapping("/client/contract")
public class BillListingController {

	@Autowired
	private BillListingService billListingService;
	@Autowired
	private ContractService contractService;

	ContractNumberYearFilter globalContractNumberYearFilter = null;

	// @RequestMapping(value = "/bills")
	// public String showCustomerBills(final Model model, @RequestParam(name =
	// "contractNumber", required = false) Long id,
	// @RequestParam(name = "year", required = true, defaultValue = "ALL")
	// String year,
	// @RequestParam(name = "page", required = true, defaultValue = "1") int
	// page) throws Exception {
	//
	// final ClientUser clientUser = (ClientUser)
	// SecurityContextHolder.getContext().getAuthentication()
	// .getPrincipal();
	//
	// List<ContractBill> contractBills = new ArrayList<ContractBill>();
	// int numberOfPages = 0;
	//
	// if (id != null) {
	// contractBills = billListingService.getContractBills(id, year, page, 20);
	// numberOfPages = billListingService.getNumberOfPages(id, year, 20);
	// }
	//
	// model.addAttribute("contractNumberYearFilter", new
	// ContractNumberYearFilter(id, year, page));
	// model.addAttribute("contracts",
	// contractService.getClientContracts(clientUser.getClienteProfile().getCodCli()));
	// model.addAttribute("years", billListingService.getBillYearList());
	// model.addAttribute("contractBills", contractBills);
	// model.addAttribute("noOfPages", numberOfPages);
	// model.addAttribute("contractNumber", id);
	// model.addAttribute("page", page);
	//
	// return "contract_bill_list";
	// }

	@RequestMapping(value = "/bills")
	public String showCustomerBills(Model model, @RequestParam(value = "errorInfo", required = false) String errorInfo1)
			throws Exception {

		ErrorInfo errorInfo = null; // TODO

		if (errorInfo1 != null && !errorInfo1.isEmpty()) {
			errorInfo = new ErrorInfo(errorInfo1, HttpStatus.CONFLICT);
		}

		ContractNumberYearFilter contractNumberYearFilter = globalContractNumberYearFilter;
		globalContractNumberYearFilter = null;

		if (contractNumberYearFilter == null) {
			final ClientUser clientUser = (ClientUser) SecurityContextHolder.getContext().getAuthentication()
					.getPrincipal();

			final List<Contract> contractsList = contractService
					.getClientContracts(clientUser.getClienteProfile().getCodCli());

			Contract contracts = new Contract();

			if (contractsList.size() > 0 && contractsList != null) {
				contracts = contractsList.get(0);

				final Integer year = billListingService.getMaxBillYear(new BigDecimal(contracts.getContractNumber()));

				final Calendar cal = Calendar.getInstance();

				String currentYear = String.valueOf(cal.get(Calendar.YEAR));
				if (year != null) {
					currentYear = String.valueOf(year);
				}
				final int page = 1;

				contractNumberYearFilter = new ContractNumberYearFilter(Long.valueOf(contracts.getContractNumber()),
						currentYear, page, 20);
			} else {
				contractNumberYearFilter = new ContractNumberYearFilter(null, null, 1, 20);
			}
		}

		model = processBillListing(contractNumberYearFilter, model);

		model.addAttribute("errorInfo", errorInfo);
		return "contract_bill_list";
	}

	@RequestMapping(value = "/bills", method = RequestMethod.POST)
	public String filterBills(@Valid ContractNumberYearFilter contractNumberYearFilter, Model model,
			final Errors errors) throws Exception {

		model = processBillListing(contractNumberYearFilter, model);
		return "contract_bill_list";

		// return "redirect:/client/contract/bills?contractNumber=" +
		// contractNumberYearFilter.getBillContractNumber()
		// + "&year=" + contractNumberYearFilter.getBillYear() + "&page=1";
	}

	@RequestMapping(value = "/specific/bills")
	public String showCustomerBillsWithContractSelected(Model model,
			@RequestParam(value = "contractNumber", required = true) String contractNumber,
			@RequestParam(value = "year", required = false) String year) throws Exception {

		if (year == null) {
			final Integer yearInt = billListingService.getMaxBillYear(new BigDecimal(contractNumber));

			final Calendar cal = Calendar.getInstance();

			year = String.valueOf(cal.get(Calendar.YEAR));
			if (yearInt != null) {
				year = String.valueOf(yearInt);
			}
		}

		final int page = 1;
		Long contractLong = null;
		if (!contractNumber.isEmpty() && contractNumber != null && !contractNumber.equalsIgnoreCase("null")) {
			contractLong = Long.valueOf(contractNumber);
		}
		globalContractNumberYearFilter = new ContractNumberYearFilter(contractLong, year, page, 20);

		return "redirect:/client/contract/bills";
	}

	private Model processBillListing(ContractNumberYearFilter contractNumberYearFilter, Model model) throws Exception {
		final ClientUser clientUser = (ClientUser) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();

		final Long id = contractNumberYearFilter.getBillContractNumber();
		final String year = contractNumberYearFilter.getBillYear();
		final int page = contractNumberYearFilter.getPage();

		List<ContractBill> contractBills = new ArrayList<ContractBill>();
		List<Integer> years = new ArrayList<Integer>();
		List<Contract> contracts = new ArrayList<Contract>();

		int numberOfPages = 0;

		if (id != null) {
			contractBills = billListingService.getContractBills(id, year, page, 20);
			numberOfPages = billListingService.getNumberOfPages(id, year, 20);

			years = billListingService
					.getContractBillYears(BigDecimal.valueOf(contractNumberYearFilter.getBillContractNumber()));
			contracts = contractService.getClientContracts(clientUser.getClienteProfile().getCodCli());
		}

		model.addAttribute("contractNumberYearFilter", new ContractNumberYearFilter(id, year, page, 20));

		model.addAttribute("contracts", contracts);
		model.addAttribute("yearsLength", years.size());
		model.addAttribute("years", years);
		model.addAttribute("contractBills", contractBills);
		model.addAttribute("noOfPages", numberOfPages);
		model.addAttribute("contractNumber", id);
		model.addAttribute("page", page);

		return model;
	}

	@RequestMapping(value = "/billyears", method = RequestMethod.GET)
	public @ResponseBody List<Integer> findContractBillYears(
			@RequestParam(value = "contractNumber", required = true) Long contractNumber) {
		return billListingService.getContractBillYears(BigDecimal.valueOf(contractNumber));
	}

}
