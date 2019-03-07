package com.indra.iopen.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.indra.iopen.form.BillDispatchForm;
import com.indra.iopen.form.Contract;
import com.indra.iopen.model.security.users.ClientUser;
import com.indra.iopen.service.BillDispatchService;
import com.indra.iopen.service.CommonService;
import com.indra.iopen.service.ContractService;
import com.indra.iopen.util.ErrorInfo;

@Controller
@RequestMapping("/client/bill-dispatch")
public class BillDispatchController {
	@Autowired
	private BillDispatchService billDispatchService;
	@Autowired
	private CommonService commonService;
	@Autowired
	private Environment env;
	@Autowired
	private ContractService contractService;

	@RequestMapping(value = "{contractNumber}", method = RequestMethod.GET)
	public String getBillDispatchForms(final Model model, @PathVariable(value = "contractNumber") Long contractNumber) {
		/*
		 * try { model.addAttribute("billDispatchList",
		 * billDispatchService.getBillDispatchMethodsOfASpecificContract(
		 * contractNumber));
		 *
		 * } catch (Exception e) { e.printStackTrace(); } return
		 * "bill_dispatch_list";
		 */
		try {
			// client contracts
			final ClientUser clientUser = (ClientUser) SecurityContextHolder.getContext().getAuthentication()
					.getPrincipal();
			List<Contract> contracts = contractService.getClientContracts(clientUser.getClienteProfile().getCodCli());

			if (!contracts.isEmpty()) {
				model.addAttribute("billDispatchList",
						billDispatchService.getBillDispatchMethodsOfASpecificContract(contractNumber));
			} else {
				model.addAttribute("billDispatchList", new ArrayList<BillDispatchForm>());

			}
			model.addAttribute("selectedContractNumber", contractNumber);
			model.addAttribute("billDispatchForm", new BillDispatchForm());
			model.addAttribute("contracts", contracts);
			model.addAttribute("dispatchMethods", commonService.getTipos("BD"));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "bill_dispatch_list";
	}

	@RequestMapping(method = RequestMethod.GET)
	public String getBillDispatchForm(final Model model) {
		try {
			// client contracts
			final ClientUser clientUser = (ClientUser) SecurityContextHolder.getContext().getAuthentication()
					.getPrincipal();
			List<Contract> contracts = contractService.getClientContracts(clientUser.getClienteProfile().getCodCli());

			if (!contracts.isEmpty()) {
				model.addAttribute("billDispatchList", billDispatchService
						.getBillDispatchMethodsOfASpecificContract(Long.valueOf(contracts.get(0).getContractNumber())));
			} else {
				model.addAttribute("billDispatchList", new ArrayList<BillDispatchForm>());

			}

			model.addAttribute("billDispatchForm", new BillDispatchForm());
			model.addAttribute("contracts", contracts);
			model.addAttribute("dispatchMethods", commonService.getTipos("BD"));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "bill_dispatch_list";

	}

	@RequestMapping(value = "{contractNumber}", method = RequestMethod.POST)
	public String addBillDispatchForm(final BillDispatchForm billDispatchForm, final Model model,
			@PathVariable(value = "contractNumber") Long contractNumber) {
		try {
			billDispatchForm.setContractNumber(String.valueOf(contractNumber));
			billDispatchService.addBillDispatchMethod(billDispatchForm);

			return "redirect:/client/bill/" + contractNumber;
		} catch (Exception e) {
			e.printStackTrace();
			final ErrorInfo errorInfo = new ErrorInfo(env.getProperty("application.exception.message"),
					HttpStatus.INTERNAL_SERVER_ERROR);
			model.addAttribute("errorInfo", errorInfo);
			return "bill_dispatch";
		}
	}

	@RequestMapping(value = "/contract/list", method = RequestMethod.GET)
	public @ResponseBody List<BillDispatchForm> getContractBillDispatch(
			@RequestParam(value = "contractNumber", required = true) Long contractNumber) {

		List<BillDispatchForm> billDispatchForms = new ArrayList<BillDispatchForm>();
		try {
			billDispatchForms = billDispatchService.getBillDispatchMethodsOfASpecificContract(contractNumber);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return billDispatchForms;

	}

	@RequestMapping(value = "/contract/update", method = RequestMethod.GET)
	public @ResponseBody List<BillDispatchForm> UpdateContractBillDispatch(
			@RequestParam(value = "billDispatchString", required = true) String billDispatchString,
			@RequestParam(value = "contractNumber", required = true) Long contractNumber) {

		List<BillDispatchForm> billDispatchForms = new ArrayList<BillDispatchForm>();
		ObjectMapper mapper = new ObjectMapper();
		try {
			billDispatchForms = mapper.readValue(billDispatchString,
					TypeFactory.defaultInstance().constructCollectionType(List.class, BillDispatchForm.class));
		} catch (JsonParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (JsonMappingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			for (BillDispatchForm billDispatchForm : billDispatchForms) {
				billDispatchForm.setContractNumber(String.valueOf(contractNumber));
				billDispatchService.addBillDispatchMethod(billDispatchForm);

			}
			billDispatchForms = billDispatchService.getBillDispatchMethodsOfASpecificContract(contractNumber);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return billDispatchForms;

	}

}
