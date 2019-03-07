package com.indra.iopen.web;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.indra.iopen.form.CustomerProfile;
import com.indra.iopen.model.security.users.ClientUser;
import com.indra.iopen.service.ApplicationService;
import com.indra.iopen.service.CommonService;
import com.indra.iopen.service.CustomerProfileService;
import com.indra.iopen.service.model.CallejeroService;
import com.indra.iopen.service.model.LocalidadeService;
import com.indra.iopen.service.model.MunicipioService;
import com.indra.iopen.util.ErrorInfo;

@Controller
@RequestMapping("/client")
public class ClientProfileController {

	@Autowired
	private Environment env;
	@Autowired
	private CustomerProfileService customerProfileService;
	@Autowired
	private ApplicationService applicationService;
	@Autowired
	private CommonService commonService;
	@Autowired
	private LocalidadeService localidadeService;
	@Autowired
	private MunicipioService municipioService;
	@Autowired
	private CallejeroService callejeroService;

	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String userProfile(Model model) {
		final ClientUser clientUser = (ClientUser) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		try {
			boolean customerExist = true;

			CustomerProfile customerProfile = customerProfileService.getCustomerProfile(clientUser);
			if (customerProfile == null || customerProfile.getFirstName() == null) {
				customerProfile = new CustomerProfile();
				customerExist = false;
			}
			model.addAttribute("profile", customerProfile);
			model.addAttribute("districts", municipioService.findAllMunicipiosByDepto());
			if (customerProfile.getPremiseInformation() != null
					&& customerProfile.getPremiseInformation().getDistrict() > 0) {
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
			model.addAttribute("defaultValues", applicationService.retrieveDefaultValues());
			model.addAttribute("idTypes", commonService.getTipos("TD"));
			model.addAttribute("customerExist", customerExist);
		} catch (Exception e) {
			final ErrorInfo errorInfo = new ErrorInfo(env.getProperty("application.exception.message"),
					HttpStatus.INTERNAL_SERVER_ERROR);
			model.addAttribute("errorInfo", errorInfo);
			e.printStackTrace();
		}
		return "customer_profile";
	}

	@RequestMapping(value = "/profile/edit", method = RequestMethod.GET)
	public String editUserProfile(Model model) {
		final ClientUser clientUser = (ClientUser) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		try {
			CustomerProfile customerProfile = customerProfileService.getCustomerProfile(clientUser);
			model.addAttribute("profile", customerProfile);
			model.addAttribute("districts", municipioService.findAllMunicipiosByDepto());
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
			model.addAttribute("defaultValues", applicationService.retrieveDefaultValues());
			model.addAttribute("idTypes", commonService.getTipos("TD"));
		} catch (Exception e) {
			final ErrorInfo errorInfo = new ErrorInfo(env.getProperty("application.exception.message"),
					HttpStatus.INTERNAL_SERVER_ERROR);
			model.addAttribute("errorInfo", errorInfo);
			e.printStackTrace();
		}
		return "customer_profile_edit";
	}

	@RequestMapping(value = "/profile", method = RequestMethod.POST)
	public String userProfile(Model model, final CustomerProfile customerProfile) {
		final ClientUser clientUser = (ClientUser) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		try {
			customerProfileService.editCustomerProfile(clientUser, customerProfile);
		} catch (Exception e) {
			final ErrorInfo errorInfo = new ErrorInfo(env.getProperty("application.exception.message"),
					HttpStatus.INTERNAL_SERVER_ERROR);
			model.addAttribute("errorInfo", errorInfo);
			e.printStackTrace();
		}
		// return "customer_profile";
		return "redirect:/client/profile";
	}

}
