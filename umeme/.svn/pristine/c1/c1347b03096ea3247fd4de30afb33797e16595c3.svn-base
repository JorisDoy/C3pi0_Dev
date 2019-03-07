package com.indra.iopen.web;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.indra.iopen.form.InspectionScheduledApplication;
import com.indra.iopen.form.ReceivedInspectionResult;
import com.indra.iopen.model.IopenApplication;
import com.indra.iopen.service.ApplicationListService;
import com.indra.iopen.service.ApplicationService;
import com.indra.iopen.service.CommonService;
import com.indra.iopen.service.InspectionResultsService;
import com.indra.iopen.service.InspectionSchedulingService;
import com.indra.iopen.service.PersonalService;
import com.indra.iopen.service.model.CallejeroService;
import com.indra.iopen.service.model.LocalidadeService;
import com.indra.iopen.service.model.MunicipioService;
import com.indra.iopen.util.ErrorInfo;

@Controller
@RequestMapping("/employee/inspection/")
public class InspectionScheduleEmployeeController {

	@Autowired
	private InspectionSchedulingService inspectionSchedulingService;
	@Autowired
	private InspectionResultsService inspectionResultsService;

	@Autowired
	private ApplicationListService applicationListService;
	@Autowired
	private ApplicationService applicationService;

	@Autowired
	private CommonService commonService;
	// SMA 20160425 start ensure that premise details show names instead of the
	// codes
	@Autowired
	private MunicipioService municipioService;
	@Autowired
	private LocalidadeService localidadeService;
	@Autowired
	private CallejeroService callejeroService;
	@Autowired
	PersonalService personalService;

	// SMA 20160425 end
	@RequestMapping(value = "/pendingscheduling", method = RequestMethod.GET)
	public String showApplicationsScheduler(Model model, @RequestParam("schedule") Boolean schedule) throws Exception {

		model.addAttribute("scheduledApplications", inspectionSchedulingService.findScheduledApplications(schedule));
		return "inspection_schedule_list";
	}

	@RequestMapping(value = "/pendingscheduling/{codApplication}", method = RequestMethod.GET)
	public String showApplicationsScheduler(Model model, @PathVariable("codApplication") Long codApplication)
			throws Exception {
		final InspectionScheduledApplication inspectionScheduledApplication = inspectionSchedulingService
				.getScheduledApplication(codApplication);
		model.addAttribute("scheduledApplication", inspectionScheduledApplication);
		model.addAttribute("application", applicationListService.clientApplicationDetail(codApplication, true));
		model.addAttribute("defaultValues", applicationService.retrieveDefaultValues());
		model.addAttribute("rejectReasons", commonService.getCodigos("IR"));

		/* Employee & District list */
		model.addAttribute("employeesToSchedule", personalService
				.getPersonalByUnicom(new BigDecimal(inspectionScheduledApplication.getServiceOrderUnicom())));
		return "schedule_application_inspection";
	}

	@RequestMapping(value = "/pendingscheduling/{codApplication}", method = RequestMethod.POST)
	public String scheduleApplications(Model model, InspectionScheduledApplication inspectionScheduledApplication,
			@PathVariable("codApplication") Long codApplication) throws Exception {

		inspectionSchedulingService.addInspectionScheduleToApplication(inspectionScheduledApplication);
		return "redirect:/employee/inspection/pendingscheduling?schedule=false";
	}

	@RequestMapping(value = "/pendinginspection", method = RequestMethod.GET)
	public String showScheduledApplications(Model model, @RequestParam("schedule") Boolean schedule) throws Exception {

		model.addAttribute("scheduledApplications", inspectionSchedulingService.findScheduledApplications(schedule));
		return "scheduled_for_inspection";
	}

	@RequestMapping(value = "/pendinginspection/{codApplication}", method = RequestMethod.GET)
	public String showScheduledApplications(Model model, @PathVariable("codApplication") Long codApplication)
			throws Exception {
		model.addAttribute("scheduledApplication", inspectionSchedulingService.getScheduledApplication(codApplication));
		model.addAttribute("application", applicationListService.clientApplicationDetail(codApplication, true));
		model.addAttribute("defaultValues", applicationService.retrieveDefaultValues());
		model.addAttribute("rejectReasons", commonService.getCodigos("IR"));
		return "view_scheduledfor_inspection";
	}

	@RequestMapping(value = "/inspectionresults/{codApplication}", method = RequestMethod.GET)
	public String captureInspectionResults(Model model, @PathVariable("codApplication") Long codApplication)
			throws Exception {

		final IopenApplication iopenApplication = applicationService
				.findIopenApplicationByCodApplication(codApplication);

		model.addAttribute("receivedInspectionResult", new ReceivedInspectionResult(iopenApplication));

		// use tipo for return value and descTipo for display
		model.addAttribute("projectTypes", inspectionResultsService.getValidProjectTypes());
		model.addAttribute("connectionTypes", commonService.getTipos("31"));
		model.addAttribute("workRequestTypes", commonService.getTipos("32"));

		// use empCode for return value and ape1Emp+" "+ape2Emp+" "+nomEmp for
		// display
		model.addAttribute("inspectionEmployees", inspectionResultsService
				.findPersonalToWorkOnServiceOrder(iopenApplication.getExpediente().getNumOs().longValue()));
		model.addAttribute("defaultValues", applicationService.retrieveDefaultKeys());

		// SMA 20160425 start ensure that premise details show names instead of
		// the codes
		model.addAttribute("districts", municipioService.findAllMunicipiosByDepto());
		final BigDecimal district = new BigDecimal(iopenApplication.getDistrict());
		if (iopenApplication.getDistrict() > 0) {
			model.addAttribute("villages", localidadeService.findVillageByDistrictCode(district));
		}
		final BigDecimal village = new BigDecimal(iopenApplication.getVillage());
		if (iopenApplication.getVillage() > 0) {
			model.addAttribute("localities", localidadeService.findLocalityByVillageCode(village));
		}
		final BigDecimal street = new BigDecimal(iopenApplication.getLocality());
		if (iopenApplication.getLocality() > 0) {
			model.addAttribute("streets", callejeroService.findStreetByLocalityCode(street));
		}
		// SMA 20160425 end

		return "inspection_results";
	}

	@RequestMapping(value = "/inspectionresults/{codApplication}", method = RequestMethod.POST)
	public String submitInspectionResults(Model model, ReceivedInspectionResult inspectionResult,
			@PathVariable("codApplication") Long codApplication) throws Exception {
		IopenApplication iopenApplication = null;
		try {
			iopenApplication = applicationService.findIopenApplicationByCodApplication(codApplication);
			inspectionResult.setIopenApplication(iopenApplication);
			inspectionResultsService.processInspectionResults(inspectionResult);
		} catch (final Exception e) {
			e.printStackTrace();
			final ErrorInfo errorInfo = new ErrorInfo("something went wrong please try again",
					HttpStatus.INTERNAL_SERVER_ERROR);
			model.addAttribute("errorInfo", errorInfo);
			model.addAttribute("receivedInspectionResult", new ReceivedInspectionResult(iopenApplication));

			// use tipo for return value and descTipo for display
			model.addAttribute("projectTypes", inspectionResultsService.getValidProjectTypes());
			model.addAttribute("connectionTypes", commonService.getTipos("31"));
			model.addAttribute("workRequestTypes", commonService.getTipos("32"));

			// use empCode for return value and ape1Emp+" "+ape2Emp+" "+nomEmp
			// for
			// display
			model.addAttribute("inspectionEmployees", inspectionResultsService
					.findPersonalToWorkOnServiceOrder(iopenApplication.getExpediente().getNumOs().longValue()));
			model.addAttribute("defaultValues", applicationService.retrieveDefaultKeys());

			// SMA 20160425 start ensure that premise details show names instead
			// of
			// the codes
			model.addAttribute("districts", municipioService.findAllMunicipiosByDepto());
			final BigDecimal district = new BigDecimal(iopenApplication.getDistrict());
			if (iopenApplication.getDistrict() > 0) {
				model.addAttribute("villages", localidadeService.findVillageByDistrictCode(district));
			}
			final BigDecimal village = new BigDecimal(iopenApplication.getVillage());
			if (iopenApplication.getVillage() > 0) {
				model.addAttribute("localities", localidadeService.findLocalityByVillageCode(village));
			}
			final BigDecimal street = new BigDecimal(iopenApplication.getLocality());
			if (iopenApplication.getLocality() > 0) {
				model.addAttribute("streets", callejeroService.findStreetByLocalityCode(street));
			}
			// SMA 20160425 end

			return "inspection_results";
		}
		return "redirect:/employee/inspection/pendinginspection?schedule=true";

		// return
		// "redirect:/employee/inspection/pendingconnection?schedule=true";
	}

	@RequestMapping(value = "/rejectedinspections", method = RequestMethod.GET)
	public String showRejectedApplications(Model model) throws Exception {

		model.addAttribute("scheduledApplications", inspectionSchedulingService.findRejectedApplications());
		return "rejected_inspections";
	}

}
