package com.indra.iopen.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.indra.iopen.model.security.users.ClientUser;
import com.indra.iopen.service.InspectionSchedulingService;

@Controller
@RequestMapping("/client")
public class InspectionScheduleClientController {
	@Autowired
	private InspectionSchedulingService inspectionSchedulingService;

	@RequestMapping(value = "/applications/schedule", method = RequestMethod.GET)
	public String showApplicationsScheduler(Model model, @RequestParam("schedule") Boolean schedule) throws Exception {
		ClientUser clientUser = (ClientUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("scheduledApplications", inspectionSchedulingService
				.findScheduledApplicationsForClient(clientUser.getClienteProfile().getUsername(), schedule));

		return "application_scheduled";
	}
}
