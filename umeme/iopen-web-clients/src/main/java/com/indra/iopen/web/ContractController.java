package com.indra.iopen.web;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.indra.iopen.form.Contract;
import com.indra.iopen.model.security.users.ClientUser;
import com.indra.iopen.service.CommonService;
import com.indra.iopen.service.ContractService;
import com.indra.iopen.service.model.CallejeroService;
import com.indra.iopen.service.model.LocalidadeService;
import com.indra.iopen.service.model.MunicipioService;

@Controller
@RequestMapping("/client")
public class ContractController {

	@Autowired
	private ContractService contractService;
	@Autowired
	private CommonService commonService;
	@Autowired
	private MunicipioService municipioService;

	@Autowired
	private LocalidadeService localidadeService;

	@Autowired
	private CallejeroService callejeroService;

	@RequestMapping(value = "/contract/list", method = RequestMethod.GET)
	public String clientContracts(final Model model) {

		final ClientUser clientUser = (ClientUser) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();

		// client contracts
		List<Contract> contracts = contractService.getClientContracts(clientUser.getClienteProfile().getCodCli());

		model.addAttribute("contracts", contracts);

		return "client_contract_list";
	}

	@RequestMapping(value = "/contract/{id}", method = RequestMethod.GET)
	public String contractDetail(Model model, @PathVariable(value = "id") final String contractNumber)
			throws Exception {

		Contract contract = contractService.getContractByContractNumber(Long.valueOf(contractNumber));

		model.addAttribute("contract", contract);

		model = getAllContractModels(model);

		model = getLocationDataModel(model, contract);

		return "client_contract";

	}

	@RequestMapping(value = "/my_contracts", method = RequestMethod.GET)
	public String redirectClientContracts(final Model model) {
		String page = "redirect:/client/contract/list";

		final ClientUser clientUser = (ClientUser) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();

		Long noOfServices = contractService.getNumberOfClientContracts(clientUser.getClienteProfile().getCodCli());

		if (noOfServices == 1) {
			List<Contract> contracts = contractService.getClientContracts(clientUser.getClienteProfile().getCodCli());

			page = "redirect:/client/contract/" + contracts.get(0).getContractNumber();
		}

		return page;
	}

	private Model getAllContractModels(Model model) {

		// tariffs
		model.addAttribute("tariffs", commonService.getAllMtarifas());

		// contract statuses
		model.addAttribute("contractStatuses", commonService.getEstados("EC"));

		// Billing periods
		model.addAttribute("billingPeriods", commonService.getTipos("PF"));

		// service point status;
		model.addAttribute("servicePointStatuses", commonService.getEstados("SS"));

		// connection types
		model.addAttribute("connectionTypes", commonService.getTipos("CX"));

		// phase types
		model.addAttribute("phaseTypes", commonService.getTipos("FA"));

		// voltage types
		model.addAttribute("voltageTypes", commonService.getTipos("TT"));

		// reading frequency
		model.addAttribute("readingPeriods", commonService.getTipos("RU"));

		// meter dropdowns
		model.addAttribute("manufacturers", commonService.getCodigos("MC"));
		model.addAttribute("meterModels", commonService.getCodigos("MO"));

		model.addAttribute("meterStatuses", commonService.getEstados("AP"));

		model.addAttribute("meterNatures", commonService.getTipos("RF"));
		model.addAttribute("meterVoltages", commonService.getTipos("TT"));
		model.addAttribute("meterMaterialTypes", commonService.getTipos("MA"));

		return model;
	}

	private Model getLocationDataModel(Model model, Contract contract) {

		model.addAttribute("districts", municipioService.findAllMunicipiosByDepto());

		Long district = contract.getPremiseInformation().getDistrict();
		Long locality = contract.getPremiseInformation().getLocality();

		if (district > 0) {

			model.addAttribute("villages", localidadeService.findVillageByDistrictCode(BigDecimal.valueOf(district)));

			model.addAttribute("streets", callejeroService.findStreetByLocalityCode(BigDecimal.valueOf(locality)));

		}

		return model;
	}

}
