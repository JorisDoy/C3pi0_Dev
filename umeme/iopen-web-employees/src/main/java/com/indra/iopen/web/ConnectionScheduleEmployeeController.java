package com.indra.iopen.web;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.indra.iopen.exception.DataIntegrityException;
import com.indra.iopen.form.ApplicationListFilter;
import com.indra.iopen.form.ConnectionResult;
import com.indra.iopen.form.ConnectionScheduledApplication;
import com.indra.iopen.model.IopenApplication;
import com.indra.iopen.model.Municipio;
import com.indra.iopen.model.Unicom;
import com.indra.iopen.model.ims.SgdInstalacion;
import com.indra.iopen.model.security.users.EmployeeUser;
import com.indra.iopen.repositories.model.IopenApplicationRepository;
import com.indra.iopen.service.ApplicationListService;
import com.indra.iopen.service.ApplicationService;
import com.indra.iopen.service.CommonService;
import com.indra.iopen.service.ConnectionResultService;
import com.indra.iopen.service.ConnectionSchedulingService;
import com.indra.iopen.service.InspectionResultsService;
import com.indra.iopen.service.UnicomService;
import com.indra.iopen.service.model.CallejeroService;
import com.indra.iopen.service.model.LocalidadeService;
import com.indra.iopen.service.model.MunicipioService;
import com.indra.iopen.service.model.SgdInstalacionService;
import com.indra.iopen.util.ErrorInfo;

@Controller
@RequestMapping("/employee/connection")
public class ConnectionScheduleEmployeeController {
	@Autowired
	private ConnectionSchedulingService connectionSchedulingService;
	@Autowired
	private ApplicationListService applicationListService;
	@Autowired
	private ApplicationService applicationService;
	@Autowired
	private CommonService commonService;

	@Autowired
	private SgdInstalacionService sgdInstalacionService;

	@Autowired
	private InspectionResultsService inspectionResultsService;

	@Autowired
	private ConnectionResultService connectionResultService;
	// SMA 20160425 start ensure that premise details show names instead of the
	// codes
	@Autowired
	private MunicipioService municipioService;
	@Autowired
	private LocalidadeService localidadeService;
	@Autowired
	private CallejeroService callejeroService;

	@Autowired
	UnicomService unicomService;
	@Autowired
	private IopenApplicationRepository iopenApplicationRepository;

	@Autowired
	Environment env;

	// SMA 20160425 end

	@RequestMapping(value = "/pendingscheduling", method = RequestMethod.GET)
	public String showUnscheduledConnections(Model model, @RequestParam("schedule") Boolean schedule) throws Exception {

		/* Start Filters */
		model.addAttribute("applicationListFilter", new ApplicationListFilter());
		List<Municipio> municipio = new ArrayList<Municipio>();
		List<Unicom> unicoms = new ArrayList<Unicom>();

		if (env.getProperty("application.restrict.employee.application.by.unicom").equals("true")) {
			final EmployeeUser employeeUser = (EmployeeUser) SecurityContextHolder.getContext().getAuthentication()
					.getPrincipal();
			municipio = municipioService
					.findAllMunicipiosByDeptoAndUnicom(employeeUser.getEmployeeProfile().getCodUnicom());

			/* Company districts */
			unicoms = unicomService.getEmployeeCompanyDistrict(employeeUser.getEmployeeProfile().getCodUnicom());
		} else {
			municipio = municipioService.findAllMunicipiosByDepto();

			/* Company districts */
			unicoms = unicomService.getAllCompanyDistricts();
		}

		model.addAttribute("districts", municipio);
		model.addAttribute("companyDistricts", unicoms);
		model.addAttribute("workTypes", commonService.getTipos("012"));

		/* End Filters */

		model.addAttribute("scheduledApplications",
				connectionSchedulingService.findScheduledConnectionApplications(schedule));
		return "connection_schedule_list";
	}

	@RequestMapping(value = "/pendingscheduling/{codApplication}", method = RequestMethod.GET)
	public String showUnscheduledConnection(Model model, @PathVariable("codApplication") Long codApplication)
			throws Exception {
		model.addAttribute("scheduledApplication",
				connectionSchedulingService.getScheduledConnectionApplication(codApplication));
		model.addAttribute("application", applicationListService.clientApplicationDetail(codApplication, true));
		model.addAttribute("defaultValues", applicationService.retrieveDefaultValues());
		return "schedule_connection";
	}

	@RequestMapping(value = "/pendingscheduling/{codApplication}", method = RequestMethod.POST)
	public String scheduleConnection(Model model, ConnectionScheduledApplication connectionScheduledApplication,
			@PathVariable("codApplication") Long codApplication) throws Exception {

		connectionSchedulingService.addConnectionScheduleToApplication(connectionScheduledApplication);
		return "redirect:/employee/connection/pendingscheduling?schedule=false";
	}

	@RequestMapping(value = "/pendingconnection", method = RequestMethod.GET)
	public String showScheduledConnections(Model model, @RequestParam("schedule") Boolean schedule) throws Exception {

		model.addAttribute("scheduledApplications",
				connectionSchedulingService.findScheduledConnectionApplications(schedule));
		return "scheduled_for_connection";

	}

	@RequestMapping(value = "/connectionresults/{codApplication}", method = RequestMethod.GET)
	public String captureconnectionResults(Model model, @PathVariable("codApplication") Long codApplication)
			throws Exception {

		final IopenApplication iopenApplication = applicationService
				.findIopenApplicationByCodApplication(codApplication);

		model = getConnectionResultModels(iopenApplication, model);
		// model.addAttribute("connectionTypes", commonService.getTipos("31"));
		model.addAttribute("connectionResult", new ConnectionResult(iopenApplication));
		// model.addAttribute("connectionByEmployees", inspectionResultsService
		// .findPersonalToWorkOnServiceOrder(iopenApplication.getExpediente().getNumOs().longValue()));
		model.addAttribute("meterReadingDivisions", inspectionResultsService.findMeterReadingDivision(codApplication));

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
		return "connection_results";
	}

	@RequestMapping(value = "/connectionresults/{codApplication}", method = RequestMethod.POST)
	public String submitConnectionResults(Model model, ConnectionResult connectionResult,
			@PathVariable("codApplication") Long codApplication, Errors errors) throws Exception {

		if (errors.hasErrors()) {
			final IopenApplication iopenApplication = applicationService
					.findIopenApplicationByCodApplication(codApplication);

			model = getConnectionResultModels(iopenApplication, model);
			model.addAttribute("connectionResult", connectionResult);
			model.addAttribute("meterReadingDivisions",
					inspectionResultsService.findMeterReadingDivision(codApplication));
			model.addAttribute("feeders",
					sgdInstalacionService.findFeeder(new BigDecimal(connectionResult.getSubStation())));
			model.addAttribute("transfomers",
					sgdInstalacionService.findTransformer(new BigDecimal(connectionResult.getFeeder())));
			model.addAttribute("circuits",
					sgdInstalacionService.findCircuit(new BigDecimal(connectionResult.getTransformer())));
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
			return "connection_results";
		}

		IopenApplication iopenApplication = null;
		try {
			iopenApplication = applicationService.findIopenApplicationByCodApplication(codApplication);
			connectionResult.setIopenApplication(iopenApplication);
			connectionResultService.processConnectionResult(connectionResult);
		} catch (final DataIntegrityException e) {
			System.out.println("ERROR: DATAINTEGRITY EXCEPTION");
			final ErrorInfo errorInfo = new ErrorInfo(e.getMessage(), HttpStatus.CONFLICT);

			model = getConnectionResultModels(iopenApplication, model);
			model.addAttribute("errorInfo", errorInfo);
			model.addAttribute("connectionResult", connectionResult);
			model.addAttribute("meterReadingDivisions",
					inspectionResultsService.findMeterReadingDivision(codApplication));

			model.addAttribute("feeders",
					sgdInstalacionService.findFeeder(new BigDecimal(connectionResult.getSubStation())));
			model.addAttribute("transfomers",
					sgdInstalacionService.findTransformer(new BigDecimal(connectionResult.getFeeder())));
			model.addAttribute("circuits",
					sgdInstalacionService.findCircuit(new BigDecimal(connectionResult.getTransformer())));

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
			return "connection_results";

		}
		return "redirect:/employee/connection/pendingconnection?schedule=true";
	}

	private Model getConnectionResultModels(IopenApplication iopenApplication, Model model) {
		// populate the substations
		model.addAttribute("subStations", sgdInstalacionService.findSubStations());
		model.addAttribute("feeders", new ArrayList<SgdInstalacion>());
		model.addAttribute("transfomers", new ArrayList<SgdInstalacion>());
		model.addAttribute("circuits", new ArrayList<SgdInstalacion>());

		model.addAttribute("connectionTypes", commonService.getTipos("CX"));
		model.addAttribute("voltageTypes", commonService.getTipos("TT"));
		model.addAttribute("associationTypes", commonService.getTipos("IA"));
		model.addAttribute("phaseTypes", commonService.getTipos("FA"));
		model.addAttribute("readingPeriods", commonService.getTipos("RU"));

		model.addAttribute("connectionTypes", commonService.getTipos("CX"));
		model.addAttribute("voltageTypes", commonService.getTipos("TT"));
		model.addAttribute("associationTypes", commonService.getTipos("IA"));
		model.addAttribute("phaseTypes", commonService.getTipos("FA"));
		model.addAttribute("readingPeriods", commonService.getTipos("RU"));
		model.addAttribute("servicePointTypes", commonService.getTipos("SU"));
		model.addAttribute("readingNatures", commonService.getTipos("RF"));

		model.addAttribute("estimationMethods", commonService.getCodigos("ME"));
		model.addAttribute("meterMakes", commonService.getCodigos("MC"));

		model.addAttribute("servicePointStatuses", commonService.getEstados("SS"));

		model.addAttribute("connectionByEmployees", inspectionResultsService
				.findPersonalToWorkOnServiceOrder(iopenApplication.getExpediente().getNumOs().longValue()));

		model.addAttribute("recommendedTariffs", commonService.getAllMtarifas());

		return model;
	}

	@RequestMapping(value = "/pendingscheduling", method = RequestMethod.POST, params = "method=filter")
	public String showFilteredApplications(ApplicationListFilter applicationFilter, Model model,
			@RequestParam(value = "batch", defaultValue = "25") int batch) throws Exception {

		/* Start Filters */
		model.addAttribute("applicationListFilter", new ApplicationListFilter());
		List<Municipio> municipio = new ArrayList<>();
		List<Unicom> unicoms = new ArrayList<>();

		if (env.getProperty("application.restrict.employee.application.by.unicom").equals("true")) {
			final EmployeeUser employeeUser = (EmployeeUser) SecurityContextHolder.getContext().getAuthentication()
					.getPrincipal();
			municipio = municipioService
					.findAllMunicipiosByDeptoAndUnicom(employeeUser.getEmployeeProfile().getCodUnicom());

			/* Company districts */
			unicoms = unicomService.getEmployeeCompanyDistrict(employeeUser.getEmployeeProfile().getCodUnicom());
		} else {
			municipio = municipioService.findAllMunicipiosByDepto();

			/* Company districts */
			unicoms = unicomService.getAllCompanyDistricts();
		}

		model.addAttribute("districts", municipio);
		model.addAttribute("companyDistricts", unicoms);
		model.addAttribute("workTypes", commonService.getTipos("012"));

		/* End Filters */

		/*
		 * Method to filter called here and attribute added
		 */
		model.addAttribute("scheduledApplications",
				connectionSchedulingService.findUnScheduledConnectionApplications(applicationFilter));
		model.addAttribute("applicationListFilter", applicationFilter);

		return "connection_schedule_list";
	}

}
