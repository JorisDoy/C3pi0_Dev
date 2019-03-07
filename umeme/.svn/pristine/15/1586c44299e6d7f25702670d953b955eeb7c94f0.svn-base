package com.indra.iopen.web;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.indra.iopen.form.BillDispatchForm;
import com.indra.iopen.form.ContractNumberYearFilter;
import com.indra.iopen.form.ims.ComplaintsForm;
import com.indra.iopen.model.Callejero;
import com.indra.iopen.model.Localidade;
import com.indra.iopen.model.ims.GiTTipAviso;
import com.indra.iopen.model.ims.SgdInstalacion;
import com.indra.iopen.model.security.users.ClientUser;
import com.indra.iopen.service.BillDispatchService;
import com.indra.iopen.service.BillListingService;
import com.indra.iopen.service.CommonService;
import com.indra.iopen.service.ims.ComplaintsService;
import com.indra.iopen.service.model.CallejeroService;
import com.indra.iopen.service.model.LocalidadeService;
import com.indra.iopen.service.model.SgdInstalacionService;
import com.indra.iopen.util.ErrorInfo;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/rest")
public class RestController {
	@Autowired
	private Environment env;
	@Autowired
	private LocalidadeService localidadeService;

	@Autowired
	private CallejeroService callejeroService;

	@Autowired
	private SgdInstalacionService sgdInstalacionService;
	@Autowired
	private ComplaintsService complaintsService;
	@Autowired
	private BillListingService billListingService;
	@Autowired
	private CommonService commonService;
	@Autowired
	private BillDispatchService billDispatchService;

	@RequestMapping(value = "/client/application/villages", method = RequestMethod.GET)
	public @ResponseBody List<Localidade> findVillageByDistrict(
			@RequestParam(value = "codMunic", required = true) BigDecimal district) {
		return localidadeService.findVillageByDistrictCode(district);
	}

	@RequestMapping(value = "/client/application/localities", method = RequestMethod.GET)
	public @ResponseBody List<Localidade> findLocalityByVillage(
			@RequestParam(value = "codLocal", required = true) BigDecimal village) {
		return localidadeService.findLocalityByVillageCode(village);

	}

	@RequestMapping(value = "/client/application/streets", method = RequestMethod.GET)
	public @ResponseBody List<Callejero> findStreetByLocality(
			@RequestParam(value = "codLocal", required = true) BigDecimal locality) {
		return callejeroService.findStreetByLocalityCode(locality);
	}

	/* Select the network */
	@RequestMapping(value = "/connection/result/feeders", method = RequestMethod.GET)
	public @ResponseBody List<SgdInstalacion> findFeeders(
			@RequestParam(value = "subStationCode", required = true) BigDecimal subStationCode) {

		return sgdInstalacionService.findFeeder(subStationCode);

	}

	@RequestMapping(value = "/connection/result/transformers", method = RequestMethod.GET)
	public @ResponseBody List<SgdInstalacion> findTransformers(
			@RequestParam(value = "feederCode", required = true) BigDecimal feederCode) {

		return sgdInstalacionService.findTransformer(feederCode);

	}

	@RequestMapping(value = "/connection/result/circuits", method = RequestMethod.GET)
	public @ResponseBody List<SgdInstalacion> findCircuits(
			@RequestParam(value = "transformerCode", required = true) BigDecimal transformerCode) {

		return sgdInstalacionService.findCircuit(transformerCode);

	}

	@RequestMapping(value = "/complaints/bill", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> ContractBills(final String contractNumberYearFilterString,
			@RequestParam(value = "contractNumber", required = true) Long contractNumber,
			@RequestParam(value = "year", required = false, defaultValue = "ALL") String year,
			@RequestParam(value = "batch", required = false, defaultValue = "20") int batch,
			@RequestParam(value = "page", required = false, defaultValue = "1") int page) {
		Map<String, Object> response = new HashMap<String, Object>();
		if (contractNumberYearFilterString != null && !contractNumberYearFilterString.isEmpty()) {
			ObjectMapper mapper = new ObjectMapper();
			ContractNumberYearFilter contractNumberYearFilter = new ContractNumberYearFilter();
			try {
				contractNumberYearFilter = mapper.readValue(contractNumberYearFilterString,
						ContractNumberYearFilter.class);
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
				response.put("bills",
						billListingService.getContractBills(contractNumberYearFilter.getBillContractNumber(),
								contractNumberYearFilter.getBillYear(), contractNumberYearFilter.getPage(),
								contractNumberYearFilter.getBatch()));
				response.put("noOfPages",
						billListingService.getNumberOfPages(contractNumberYearFilter.getBillContractNumber(),
								contractNumberYearFilter.getBillYear(), contractNumberYearFilter.getBatch()));
				return response;
			} catch (Exception e) {
				e.printStackTrace();

			}
		} else {
			try {
				ContractNumberYearFilter contractNumberYearFilter = new ContractNumberYearFilter(contractNumber, year,
						page, batch);
				response.put("bills",
						billListingService.getContractBills(contractNumberYearFilter.getBillContractNumber(),
								contractNumberYearFilter.getBillYear(), contractNumberYearFilter.getPage(),
								contractNumberYearFilter.getBatch()));
				response.put("totalPages",
						billListingService.getNumberOfPages(contractNumberYearFilter.getBillContractNumber(),
								contractNumberYearFilter.getBillYear(), contractNumberYearFilter.getBatch()));
				return response;
			} catch (Exception e) {
				e.printStackTrace();

			}
		}
		return response;

	}

	@RequestMapping(value = "/complaints/complaintTypes", method = RequestMethod.GET)
	public @ResponseBody Object billComplaintType(@RequestParam(value = "source", required = true) int source) {

		try {
			if (source == Integer.valueOf(env.getProperty("application.complaint.source.bill.value"))) {
				return commonService.getTipos("ZO");
			} else if (source == Integer.valueOf(env.getProperty("application.complaint.source.poweroutage.value"))) {
				return commonService.getComplaintTypes();
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<>();
		}

	}

	@RequestMapping(value = "/complaints", method = RequestMethod.GET)
	public @ResponseBody List<ComplaintsForm> ContractComplaintsForm(
			@RequestParam(value = "contractNumber", required = true) Long contractNumber) {
		final ClientUser clientUser = (ClientUser) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		List<ComplaintsForm> complaintsForms = null;
		try {
			complaintsForms = complaintsService.getComplaintByContractNumber(contractNumber, clientUser);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return complaintsForms;
	}

	@RequestMapping(value = "/complaints/complaintNature", method = RequestMethod.GET)
	public @ResponseBody List<GiTTipAviso> findcomplaintNature(
			@RequestParam(value = "complaintType", required = true) BigDecimal complaintType) {
		List<GiTTipAviso> giTTipAvisos = new ArrayList<GiTTipAviso>();

		try {
			if (complaintType.equals(new BigDecimal(env.getProperty("application.gittipaviso.normal.value")))) {
				giTTipAvisos = complaintsService.getGiTTipAvisoByIndNormal();
			} else if (complaintType.equals(new BigDecimal(env.getProperty("application.gittipaviso.quality.value")))) {
				giTTipAvisos = complaintsService.getGiTTipAvisoByIndQuality();
			} else
				if (complaintType.equals(new BigDecimal(env.getProperty("application.gittipaviso.assistance.value")))) {
				giTTipAvisos = complaintsService.getGiTTipAvisoByIndAssistance();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return giTTipAvisos;

	}

	@RequestMapping(value = "/client/bill-dispatch", method = RequestMethod.POST)
	public boolean addBillDispatchForm(final BillDispatchForm billDispatchForm, final Model model) {
		try {
			billDispatchService.addBillDispatchMethod(billDispatchForm);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			final ErrorInfo errorInfo = new ErrorInfo(env.getProperty("application.exception.message"),
					HttpStatus.INTERNAL_SERVER_ERROR);
			model.addAttribute("errorInfo", errorInfo);
		}
		return false;
	}

	@RequestMapping(value = "/client/bill-dispatch/delete", method = RequestMethod.DELETE)
	public boolean removeBillDispatchForms(final BillDispatchForm billDispatchForm, final Model model) {
		try {
			billDispatchService.removeBillDispatchMethod(billDispatchForm);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			final ErrorInfo errorInfo = new ErrorInfo(env.getProperty("application.exception.message"),
					HttpStatus.INTERNAL_SERVER_ERROR);
			model.addAttribute("errorInfo", errorInfo);
		}
		return false;

	}

}
