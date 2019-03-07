package com.indra.iopen.web;

import java.io.File;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.indra.iopen.form.GraphicalRepresentation;
import com.indra.iopen.service.BillingInformationService;
import com.indra.iopen.service.ContractService;

@Controller
public class BillingInformationController {

	private static final Logger logger = LoggerFactory.getLogger(BillingInformationController.class);

	@Autowired
	private ObjectMapper jsonMapper;

	@Autowired
	private BillingInformationService informationService;

	@Autowired
	private ContractService contractService;

	private String selectedContractNumber = null;
	private String selectedContractYear = null;

	@RequestMapping(value = "/client/billinginfo/graphical", method = RequestMethod.GET)
	public String getBillingGraphicalInfo(final Model model) {
		final GraphicalRepresentation graphicalRepresentation = new GraphicalRepresentation();
		// lodUserBillingdata(graphicalRepresentation);

		if (selectedContractNumber != null && !selectedContractNumber.isEmpty()
				&& !selectedContractNumber.equalsIgnoreCase("null")) {
			graphicalRepresentation
					.setContractNumber(contractService.getContractByContractNumber(Long.valueOf(selectedContractNumber))
							.getContractNumberWithDescription());
			selectedContractNumber = null;
		}

		if (selectedContractYear != null) {
			graphicalRepresentation.setYear(selectedContractYear);
			selectedContractYear = null;
		}
		graphicalRepresentation.setContractBillingList(informationService.loadUserBillingdata());
		model.addAttribute("graphicalRepresentation", graphicalRepresentation);
		try {
			// Object to JSON in file
			model.addAttribute("jsonGraphicalRepresentation", jsonMapper.writeValueAsString(graphicalRepresentation));
			jsonMapper.writeValue(new File("c:\\user.json"), graphicalRepresentation);
		} catch (final JsonGenerationException e) {
			logger.error(e.getMessage());
		} catch (final JsonMappingException e) {
			logger.error(e.getMessage());
		} catch (final IOException e) {
			logger.error(e.getMessage());
		}
		return "billing_graphical";
	}

	@RequestMapping(value = "/client/specific/billinginfo/graphical", method = RequestMethod.GET)
	public String getBillingGraphicalInfoSpecificContractAndYear(final Model model,
			@RequestParam(value = "contractNumber", required = true) String contractNumber,
			@RequestParam(value = "year", required = false) String year) {

		selectedContractNumber = contractNumber;

		if (year != null) {
			selectedContractYear = year;
		}

		return "redirect:/client/billinginfo/graphical";
	}
}
