package com.indra.iopen.web;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.indra.iopen.form.CustomerProfile;
import com.indra.iopen.form.PowerOutageFilter;
import com.indra.iopen.form.ims.PowerOutage;
import com.indra.iopen.model.security.users.ClientUser;
import com.indra.iopen.repositories.model.ims.SgdCentroRepository;
import com.indra.iopen.service.CustomerProfileService;
import com.indra.iopen.service.ims.PowerOutageService;
import com.indra.iopen.service.model.MunicipioService;

@Controller
@RequestMapping("/client/outages")
public class PowerOutageController {

	@Autowired
	private MunicipioService municipioService;
	@Autowired
	private SgdCentroRepository sgdCentroRepository;
	@Autowired
	private PowerOutageService powerOutageService;
	@Autowired
	private CustomerProfileService customerProfileService;
	@Autowired
	private Environment env;

	@RequestMapping(value = "/all", method = RequestMethod.POST)
	public String filterUnPlannedPowerOutages(final Model model, PowerOutageFilter powerOutageFilter) {
		try {
			powerOutageFilter.setBatch(20);

			model.addAttribute("districts", sgdCentroRepository.findSgdCentroByIdTipCentro(
					Long.valueOf(env.getProperty("application.sgdcentro.tipcentro.district.value"))));
			model.addAttribute("powerOutageStatuses", powerOutageService.getPowerOutageStatuses());
			model.addAttribute("powerOutageFilter", powerOutageFilter);
			model.addAttribute("outages", powerOutageService.getPowerOutages(powerOutageFilter));

			model.addAttribute("page", powerOutageFilter.getPage());
			model.addAttribute("noOfPages", powerOutageService.getPowerOutageFilter().getNoOfPages());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "power_outages";
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public String getAllPowerOutages(final Model model) {
		try {
			final ClientUser clientUser = (ClientUser) SecurityContextHolder.getContext().getAuthentication()
					.getPrincipal();
			CustomerProfile customerProfile = customerProfileService.getCustomerProfile(clientUser);
			PowerOutageFilter powerOutageFilter = new PowerOutageFilter();
			// TODO fill in the filter with district and dates then send a list
			// of one month's worth of power outages.
			if (customerProfile != null && customerProfile.getFirstName() != null) {
				powerOutageFilter.setDistrict(new BigDecimal(customerProfile.getPremiseInformation().getDistrict()));
			}
			Calendar calendar = Calendar.getInstance();
			calendar.add(Calendar.MONTH, 1);
			powerOutageFilter.setEndDateString(new SimpleDateFormat("dd/MM/yyyy").format(calendar.getTime()));
			powerOutageFilter.setStartDateString(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
			// model.addAttribute("outages",
			// powerOutageService.getPlannedPowerOutages(powerOutageFilter,
			// page, recordsPerPage);
			List<PowerOutage> powerOutages = new ArrayList<>();
			model.addAttribute("outages", powerOutages);
			model.addAttribute("powerOutageStatuses", powerOutageService.getPowerOutageStatuses());
			model.addAttribute("districts", sgdCentroRepository.findSgdCentroByIdTipCentro(
					Long.valueOf(env.getProperty("application.sgdcentro.tipcentro.district.value"))));
			model.addAttribute("powerOutageFilter", powerOutageFilter);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "power_outages";
	}

	@RequestMapping(value = "/{id}")
	public String viewPowerOutage(Model model, @PathVariable(value = "id") final Long incidentId) {
		try {
			PowerOutage powerOutage = powerOutageService.getPowerOutage(incidentId);

			model.addAttribute("powerOutage", powerOutage);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "power_outage_view";
	}
}
