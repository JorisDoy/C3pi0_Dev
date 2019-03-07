package com.indra.iopen.web;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.indra.iopen.exception.ObjectNotFound;
import com.indra.iopen.form.Contract;
import com.indra.iopen.form.ContractNumberYearFilter;
import com.indra.iopen.form.CustomerProfile;
import com.indra.iopen.form.ims.ComplaintsForm;
import com.indra.iopen.model.security.users.ClientUser;
import com.indra.iopen.model.security.users.GenericUser;
import com.indra.iopen.pojo.ComplaintDetail;
import com.indra.iopen.pojo.ComplaintFilter;
import com.indra.iopen.service.BillListingService;
import com.indra.iopen.service.CommonService;
import com.indra.iopen.service.ContractService;
import com.indra.iopen.service.CustomerProfileService;
import com.indra.iopen.service.ims.ComplaintsService;
import com.indra.iopen.service.ims.GiAvisoImpl;
import com.indra.iopen.service.model.CallejeroService;
import com.indra.iopen.service.model.LocalidadeService;
import com.indra.iopen.service.model.MunicipioService;
import com.indra.iopen.util.ErrorInfo;

@Controller
@RequestMapping("/client/complaint")
public class ComplaintsController {
	@Autowired
	private Environment env;
	@Autowired
	private ComplaintsService complaintsService;
	@Autowired
	private LocalidadeService localidadeService;
	@Autowired
	private MunicipioService municipioService;
	@Autowired
	private CustomerProfileService customerProfileService;
	@Autowired
	private CommonService commonService;
	@Autowired
	private BillListingService billListingService;
	@Autowired
	private CallejeroService callejeroService;
	@Autowired
	private ContractService contractService;
	@Autowired
	private GiAvisoImpl giAvisoImpl;

	@RequestMapping(method = RequestMethod.GET)
	public String getComplaintsForm(final Model model) {
		try {
			final ClientUser clientUser = (ClientUser) SecurityContextHolder.getContext().getAuthentication()
					.getPrincipal();
			final CustomerProfile customerProfile = customerProfileService.getCustomerProfile(clientUser);
			final ComplaintsForm complaintsForm = new ComplaintsForm();
			complaintsForm.setCustomerProfile(customerProfile);
			// complaintsForm.getCustomerProfile().setPremiseInformation(customerProfile.getPremiseInformation());
			// List<String> contracts = complaintsService.getContracts();
			final List<Contract> contracts = contractService.getClientContracts(clientUser.getClienteProfile().getCodCli());
			// if (contracts != null && !contracts.isEmpty() && contracts.size()
			// == 1) {
			// model.addAttribute("contractBills", billListingService
			// .getBillCodesForComplaints(Long.valueOf(contracts.get(0).getContractNumber())));
			// }
			model.addAttribute("contracts", contracts);
			model.addAttribute("billSources", commonService.getCodigos("ZP"));
			model.addAttribute("billComplaintTypes", commonService.getTipos("ZO"));
			model.addAttribute("complaintNatures", commonService.getComplaintNatures());
			model.addAttribute("scopes", commonService.getScopes());
			model.addAttribute("complaintTypes",
					commonService.getComplaintTypes().parallelStream()
					.filter(filter -> filter != null && !filter.getCodigo()
					.equals(new BigDecimal(env
							.getProperty("application.sgdvalor.codif.complainttype.assistive.value"))))
					.collect(Collectors.toList()));
			model.addAttribute("complaintForm", complaintsForm);
			model.addAttribute("idTypes", commonService.getTipos("TD"));
			model.addAttribute("districts", municipioService.findAllMunicipiosByDepto());
			if (customerProfile.getPremiseInformation().getDistrict() > 0) {

				model.addAttribute("villages", localidadeService.findVillageByDistrictCode(
						new BigDecimal(customerProfile.getPremiseInformation().getDistrict())));
				model.addAttribute("streets", callejeroService.findStreetByLocalityCode(
						new BigDecimal(customerProfile.getPremiseInformation().getLocality())));

			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
		return "complaint_form";
	}

	// @RequestMapping(value = "/bill", method = RequestMethod.GET)
	// public String getBillComplaintsForm(final Model model) {
	// try {
	// final ClientUser clientUser = (ClientUser)
	// SecurityContextHolder.getContext().getAuthentication()
	// .getPrincipal();
	// CustomerProfile customerProfile =
	// customerProfileService.getCustomerProfile(clientUser);
	// ComplaintsForm complaintsForm = new ComplaintsForm();
	// complaintsForm.setCustomerProfile(customerProfile);
	// //
	// complaintsForm.getCustomerProfile().setPremiseInformation(customerProfile.getPremiseInformation());
	// List<String> contracts = complaintsService.getContracts();
	// if (contracts != null && !contracts.isEmpty() && contracts.size() == 1) {
	// model.addAttribute("contractBills",
	// billListingService.getBillCodesForComplaints(Long.valueOf(contracts.get(0))));
	// }
	// model.addAttribute("contracts", contracts);
	// model.addAttribute("sources", commonService.getCodigos("ZP"));
	// model.addAttribute("billComplaintTypes", commonService.getTipos("ZO"));
	// model.addAttribute("complaintForm", complaintsForm);
	// model.addAttribute("districts",
	// municipioService.findAllMunicipiosByDepto());
	// if (customerProfile.getPremiseInformation().getDistrict() > 0) {
	//
	// model.addAttribute("villages",
	// localidadeService.findVillageByDistrictCode(
	// new BigDecimal(customerProfile.getPremiseInformation().getDistrict())));
	// model.addAttribute("streets",
	// localidadeService.findLocalityByVillageCode(
	// new BigDecimal(customerProfile.getPremiseInformation().getVillage())));
	//
	// }
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// return "bill_complaint_form";
	// }
	//
	// @RequestMapping(value = "/bill", method = RequestMethod.POST)
	// public String addBillComplaintsForm(final Model model, final
	// ComplaintsForm complaintsForm) throws Exception {
	// try {
	// complaintsService.registerBillComplaint(complaintsForm);
	// return "/client/complaint/all/bill/" +
	// complaintsForm.getComplaintDetail().getContractNumber();
	//
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// return "emergency_complaint";
	// }

	// @RequestMapping(value = "/all/bill/{contractNumber}", method =
	// RequestMethod.GET)
	// public String getBillComplaintsForms(final Model model,
	// @PathVariable(value = "id") final BigDecimal contractNumber) {
	// try {
	// model.addAttribute("complaintList",
	// complaintsService.getBillComplaints(contractNumber));
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// return "complaint_list";
	// }

	@RequestMapping(value = "/hazard", method = RequestMethod.GET)
	public String getHazardComplaintsForm(final Model model) {
		try {
			model.addAttribute(getHazardModel(model));

		} catch (final Exception e) {
			e.printStackTrace();
		}
		return "emergency_complaint";
	}

	@RequestMapping(value = "/anonymous/hazard", method = RequestMethod.GET)
	public String getAnonymousHazardComplaintsForm(final Model model) {
		try {
			model.addAttribute(getHazardModel(model));

		} catch (final Exception e) {
			e.printStackTrace();
		}
		return "anonymous_emergency_complaint";
	}

	private Model getHazardModel(Model model) throws Exception {
		ClientUser clientUser = null;
		final Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof GenericUser) {
			clientUser = (ClientUser) principal;
		}

		final ComplaintsForm complaintsForm = new ComplaintsForm();
		complaintsForm.setCustomerProfile(new CustomerProfile());
		complaintsForm.setComplaintDetail(new ComplaintDetail());
		model.addAttribute("districts", municipioService.findAllMunicipiosByDepto());
		if (clientUser != null) {
			final CustomerProfile customerProfile = customerProfileService.getCustomerProfile(clientUser);
			if (customerProfile != null && customerProfile.getFirstName() != null) {
				complaintsForm.setCustomerProfile(customerProfile);
				if (customerProfile.getPremiseInformation().getDistrict() > 0) {

					model.addAttribute("villages", localidadeService.findVillageByDistrictCode(
							new BigDecimal(customerProfile.getPremiseInformation().getDistrict())));
					if (customerProfile.getPremiseInformation().getVillage() > 0) {
						model.addAttribute("localities", localidadeService.findLocalityByVillageCode(
								new BigDecimal(customerProfile.getPremiseInformation().getVillage())));
					}
					if (customerProfile.getPremiseInformation().getLocality() > 0) {
						model.addAttribute("streets", callejeroService.findStreetByLocalityCode(
								new BigDecimal(customerProfile.getPremiseInformation().getLocality())));
					}
				}
			} else {
				complaintsForm.setCustomerProfile(new CustomerProfile());
			}
		}

		model.addAttribute("complaintForm", complaintsForm);
		model.addAttribute("scopes", commonService.getScopes());
		model.addAttribute("complaintTypes",
				commonService.getComplaintTypes().parallelStream()
				.filter(filter -> filter != null && filter.getCodigo()
				.equals(new BigDecimal(
						env.getProperty("application.sgdvalor.codif.complainttype.assistive.value"))))
				.collect(Collectors.toList()));

		model.addAttribute("idTypes", commonService.getTipos("TD"));
		return model;
	}

	@RequestMapping(value = "/hazard", method = RequestMethod.POST)
	public String addHazardComplaintsForm(final Model model, final ComplaintsForm complaintsForm) throws Exception {
		try {
			final long nroAviso = giAvisoImpl.getGiAvisoId("AVISOS");
			complaintsService.registerComplaint(complaintsForm, nroAviso);
			model.addAttribute(getHazardModel(model));

		} catch (final Exception e) {
			e.printStackTrace();
		}
		return "emergency_complaint";
	}

	@RequestMapping(value = "/anonymous/hazard", method = RequestMethod.POST)
	public String addAnonymousHazardComplaintsForm(final Model model, final ComplaintsForm complaintsForm)
			throws Exception {
		try {
			final long nroAviso = giAvisoImpl.getGiAvisoId("AVISOS");
			complaintsService.registerComplaint(complaintsForm, nroAviso);
			model.addAttribute(getHazardModel(model));

		} catch (final Exception e) {
			e.printStackTrace();
		}
		return "redirect:/client/complaint/anonymous/hazard";
	}

	@RequestMapping(value = "/all", method = RequestMethod.POST)
	public String getComplaintsForms(final Model model, final ComplaintFilter complaintFilter) {
		try {
			final ClientUser clientUser = (ClientUser) SecurityContextHolder.getContext().getAuthentication()
					.getPrincipal();

			// complaintFilter.setBatch(3);// test pagination

			model.addAttribute("complaintFilter", complaintFilter);
			if (complaintFilter.getComplaintSource() == Integer
					.valueOf(env.getProperty("application.complaint.source.bill.value"))) {
				model.addAttribute("complaintList", complaintsService.getBillComplaints(complaintFilter));
			} else {
				model.addAttribute("complaintList", complaintsService.getComplaints(complaintFilter, clientUser));
			}

			model.addAttribute("noOfPages", complaintsService.getComplaintFilter().getNumberOfPages());
			model.addAttribute("page", complaintsService.getComplaintFilter().getPage());
		} catch (final Exception e) {
			e.printStackTrace();
		}
		return "complaint_list";
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public String getComplaintsForms(final Model model) {
		try {
			model.addAttribute("complaintFilter", new ComplaintFilter());
			model.addAttribute("contractNumberYearFilter", new ContractNumberYearFilter());
		} catch (final Exception e) {
			e.printStackTrace();
		}
		return "complaint_list";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String addComplaintForm(final ComplaintsForm complaintsForm, final Model model) {
		try {
			if (complaintsForm.getComplaintDetail().getBillNumber() != null
					&& complaintsForm.getComplaintDetail().getBillNumber() > 0) {
				complaintsService.registerBillComplaint(complaintsForm);
			} else {
				final long nroAviso = giAvisoImpl.getGiAvisoId("AVISOS");
				complaintsService.registerComplaint(complaintsForm, nroAviso);
			}
			return "redirect:/client/complaint/all";
		} catch (final ObjectNotFound e) {
			e.printStackTrace();
			final ErrorInfo errorInfo = new ErrorInfo(e.getMessage(), HttpStatus.NOT_FOUND);
			model.addAttribute("errorInfo", errorInfo);
			return "redirect:/client/complaint";
		} catch (final Exception e) {
			e.printStackTrace();
			final ErrorInfo errorInfo = new ErrorInfo(env.getProperty("application.exception.message"),
					HttpStatus.INTERNAL_SERVER_ERROR);
			model.addAttribute("errorInfo", errorInfo);
			return "redirect:/client/complaint";
		}
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public String viewComplaintsForm(final Model model, @PathVariable(value = "id") final Long id) {
		try {
			final ClientUser clientUser = (ClientUser) SecurityContextHolder.getContext().getAuthentication()
					.getPrincipal();
			final ComplaintsForm complaintsForm = complaintsService.getComplaint(id, clientUser);
			model.addAttribute("complaintTypes",
					commonService.getComplaintTypes().parallelStream()
					.filter(filter -> filter != null && !filter.getCodigo()
					.equals(new BigDecimal(env
							.getProperty("application.sgdvalor.codif.complainttype.assistive.value"))))
					.collect(Collectors.toList()));
			// complaintsForm.getCustomerProfile().setPremiseInformation(customerProfile.getPremiseInformation());
			model.addAttribute(getComplaintsFormModel(model, complaintsForm));

		} catch (final Exception e) {
			e.printStackTrace();
		}
		return "complaint_form_view";
	}

	private Object getComplaintsFormModel(Model model, ComplaintsForm complaintsForm) throws Exception {
		model.addAttribute("contracts", complaintsService.getContracts());
		model.addAttribute("complaintNatures", commonService.getComplaintNatures());
		model.addAttribute("scopes", commonService.getScopes());
		model.addAttribute("complaintTypes", commonService.getComplaintTypes());
		model.addAttribute("complaintForm", complaintsForm);
		model.addAttribute("docTypes", commonService.getTipos("TD"));
		model.addAttribute("districts", municipioService.findAllMunicipiosByDepto());
		return model;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/bill/{id}")
	public String viewBillComplaintsForm(final Model model, @PathVariable(value = "id") final Long id) {
		try {
			final ClientUser clientUser = (ClientUser) SecurityContextHolder.getContext().getAuthentication()
					.getPrincipal();
			final ComplaintsForm complaintsForm = complaintsService.getBillComplaint(id, clientUser);
			// complaintsForm.getCustomerProfile().setPremiseInformation(customerProfile.getPremiseInformation());
			model.addAttribute("billComplaintTypes", commonService.getTipos("ZO"));
			model.addAttribute(getComplaintsFormModel(model, complaintsForm));

		} catch (final Exception e) {
			e.printStackTrace();
		}

		return "bill_complaint_view";
	}

}
