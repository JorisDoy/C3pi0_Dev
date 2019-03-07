package com.indra.iopen.web;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.indra.iopen.exception.DataIntegrityException;
import com.indra.iopen.form.ApplicationList;
import com.indra.iopen.form.ApplicationListFilter;
import com.indra.iopen.form.IOpenFile;
import com.indra.iopen.form.export.ApplicationListExport;
import com.indra.iopen.model.Municipio;
import com.indra.iopen.model.Unicom;
import com.indra.iopen.model.security.users.EmployeeUser;
import com.indra.iopen.service.ApplicationListService;
import com.indra.iopen.service.ApplicationService;
import com.indra.iopen.service.CommonService;
import com.indra.iopen.service.QuotationService;
import com.indra.iopen.service.UnicomService;
import com.indra.iopen.service.model.CallejeroService;
import com.indra.iopen.service.model.LocalidadeService;
import com.indra.iopen.service.model.MunicipioService;
import com.indra.iopen.util.ErrorInfo;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private ApplicationListService applicationListService;
	@Autowired
	private ApplicationService applicationService;

	@Autowired
	MunicipioService municipioService;

	@Autowired
	LocalidadeService localidadeService;

	@Autowired
	CallejeroService callejeroService;

	@Autowired
	CommonService commonService;

	@Autowired
	QuotationService quotationService;

	@Autowired
	UnicomService unicomService;

	@Autowired
	Environment env;

	@RequestMapping("/download")
	public String download(@RequestParam("codApplication") long codApplication, @RequestParam("tipDoc") String tipDoc,
			HttpServletResponse response) {

		IOpenFile doc = null;
		try {
			doc = applicationListService.findIopenApplicationDocById(codApplication, tipDoc);
		} catch (final FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		if (doc != null) {
			try {
				response.setHeader("Content-Disposition", "inline;filename=\"" + doc.getOriginalFilename() + "\"");
				final OutputStream out = response.getOutputStream();
				response.setContentType(doc.getContentType());
				IOUtils.copy(new ByteArrayInputStream(doc.getFile()), out);
				out.flush();
				out.close();

			} catch (final Exception e) {
				throw new RuntimeException(e);
			}

		} else {
			logger.error("ERROR: DOCUMENT IS NULL");
		}
		return null;
	}

	@RequestMapping(value = "/application/{id}", method = RequestMethod.POST)
	public String editApplication(Model model, @NotNull /* @RequestBody */ ApplicationList applicationList,
			@PathVariable(value = "id") String id, BindingResult result, RedirectAttributes attributes) {

		try {
			System.out.println("list: " + applicationList);
			if (applicationList.getApplicationStatus() == env.getProperty("application.iopenstatus.approved")
					&& applicationList.getIopenApplication().getDistrict() == null
					|| applicationList.getIopenApplication().getDistrict() == 0) {

				final ErrorInfo errorInfo = new ErrorInfo("Edit the locations", HttpStatus.CONFLICT);
				model.addAttribute("errorInfo", errorInfo);
				return "redirect:/employee/application/" + id + "?complete=true&errorInfo=" + errorInfo.getMessage();
			}
			applicationListService.editStatus(applicationList);
			// model.addAttribute("application",
			// applicationListService.editStatus(applicationList));
			// model.addAttribute("statuses",
			// applicationListService.findApplicationStatuses());
			// model.addAttribute("districts",
			// applicationService.findAllDistricts());

			return "redirect:/employee/applications";
		} catch (final DataIntegrityException e) {
			System.out.println("ERROR: DATAINTEGRITY EXCEPTION");
			final ErrorInfo errorInfo = new ErrorInfo(e.getMessage(), HttpStatus.CONFLICT);
			model.addAttribute("errorInfo", errorInfo);
			return "redirect:/employee/application/" + id + "?complete=true&errorInfo=" + errorInfo.getMessage();
		} catch (final Exception e) {
			e.printStackTrace();
			final ErrorInfo errorInfo = new ErrorInfo(env.getProperty("application.exception.message"),
					HttpStatus.INTERNAL_SERVER_ERROR);
			model.addAttribute("errorInfo", errorInfo);
			return "redirect:/employee/application/" + id + "?complete=true&errorInfo=" + errorInfo.getMessage();
		}

	}

	@RequestMapping(value = "/application/view/{id}", method = RequestMethod.GET)
	public String showApplicationView(Model model, @PathVariable(value = "id") long id,
			@RequestParam(value = "complete", required = true) boolean complete,
			@RequestParam(value = "errorInfo", required = false) String errorInfo) throws Exception {

		final EmployeeUser employeeUser = (EmployeeUser) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();

		final ApplicationList applicationList = applicationListService.clientApplicationDetail(Long.valueOf(id),
				complete);
		model.addAttribute("application", applicationList);
		model.addAttribute("defaultValues", applicationService.retrieveDefaultValues());
		model.addAttribute("districts", municipioService.findAllMunicipiosByDepto());

		final BigDecimal district = new BigDecimal(applicationList.getIopenApplication().getDistrict());
		if (applicationList.getIopenApplication().getDistrict() > 0) {
			model.addAttribute("villages", localidadeService.findVillageByDistrictCode(district));
		}
		final BigDecimal village = new BigDecimal(applicationList.getIopenApplication().getVillage());
		if (applicationList.getIopenApplication().getVillage() > 0) {
			model.addAttribute("localities", localidadeService.findLocalityByVillageCode(village));
		}
		final BigDecimal street = new BigDecimal(applicationList.getIopenApplication().getLocality());
		if (applicationList.getIopenApplication().getLocality() > 0) {
			model.addAttribute("streets", callejeroService.findStreetByLocalityCode(street));
		}

		model.addAttribute("employeeUnicom", employeeUser.getEmployeeProfile().getCodUnicom());
		model.addAttribute("statuses", applicationListService.findApplicationStatuses());
		model.addAttribute("rejectReasons", commonService.getCodigos("IR"));

		model.addAttribute("errorInfo", errorInfo);

		return "employee_viewonly_application";
	}

	@RequestMapping(value = "/application/{id}", method = RequestMethod.GET)
	public String showApplication(Model model, @PathVariable(value = "id") long id,
			@RequestParam(value = "complete", required = true) boolean complete,
			@RequestParam(value = "errorInfo", required = false) String errorInfo) throws Exception {

		final EmployeeUser employeeUser = (EmployeeUser) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();

		final ApplicationList applicationList = applicationListService.clientApplicationDetail(Long.valueOf(id),
				complete);
		model.addAttribute("application", applicationList);
		model.addAttribute("defaultValues", applicationService.retrieveDefaultValues());
		model.addAttribute("districts", municipioService.findAllMunicipiosByDepto());

		final BigDecimal district = new BigDecimal(applicationList.getIopenApplication().getDistrict());
		if (applicationList.getIopenApplication().getDistrict() > 0) {
			model.addAttribute("villages", localidadeService.findVillageByDistrictCode(district));
		}
		final BigDecimal village = new BigDecimal(applicationList.getIopenApplication().getVillage());
		if (applicationList.getIopenApplication().getVillage() > 0) {
			model.addAttribute("localities", localidadeService.findLocalityByVillageCode(village));
		}
		final BigDecimal street = new BigDecimal(applicationList.getIopenApplication().getLocality());
		if (applicationList.getIopenApplication().getLocality() > 0) {
			model.addAttribute("streets", callejeroService.findStreetByLocalityCode(street));
		}

		model.addAttribute("employeeUnicom", employeeUser.getEmployeeProfile().getCodUnicom());
		model.addAttribute("statuses", applicationListService.findApplicationStatuses());
		model.addAttribute("rejectReasons", commonService.getCodigos("IR"));

		model.addAttribute("errorInfo", errorInfo);

		return "employee_view_application";
	}

	@RequestMapping(value = "/applications", method = RequestMethod.GET)
	public String showPendingApplications(Model model) throws Exception {
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

		model.addAttribute("statuses", applicationListService.findApplicationStatuses());
		model.addAttribute("defaultValues", applicationService.retrieveDefaultValues());

		// model.addAttribute("applications",
		// applicationListService.filteredApplicationList("ALL", "IA001", "",
		// ""));

		return "client_applications";
	}

	// THIS METHOD WAS DEPRECATED BY THIS ISSUE UMESCI-
	// @RequestMapping(value = "/application/quotation", method =
	// RequestMethod.GET)
	// public String testQuotationModule(Model model) throws Exception {
	//
	// quotationService.processAllToGenerateQuotation();
	//
	// return "redirect:/employee/applications";
	// }

	@RequestMapping(value = "/applications/currentStageApplicationNumberFilters", method = RequestMethod.GET)
	public String showCurrentStageApplicationNumberFilters(Model model) throws Exception {
		model.addAttribute("applicationListFilter", new ApplicationListFilter());
		model.addAttribute("currentStage", commonService.getEstados("17"));
		model.addAttribute("defaultValues", applicationService.retrieveDefaultValues());

		return "search_application_stage";
	}

	@RequestMapping(value = "/applications/currentStageApplicationNumberFilters", method = RequestMethod.POST, params = "method=export")
	public String filterByCurrentStageApplicationNumberFilters(ApplicationListFilter applicationFilter,
			HttpServletResponse response) throws Exception {

		final List<ApplicationList> applicationList = applicationListService
				.filterByCurrentStageApplicationNumberFilters(applicationFilter.getCurrentStage(),
						applicationFilter.getApplicationNumber());
		if (applicationList.isEmpty()) {
			throw new DataIntegrityException("the filter returned no data");
		} else {
			// new ModelAndView("ApplicationListExcelBuilder",
			// "applicationList", applicationList);
			new ApplicationListExport(applicationList).export(response);
		}

		return null;
	}

	@RequestMapping(value = "/applications/currentStageApplicationNumberFilters", method = RequestMethod.POST, params = "method=filter")
	public String showFilteredApplicationsByCurrentStageApplicationNumberFilters(
			ApplicationListFilter applicationFilter, Model model,
			@RequestParam(value = "batch", defaultValue = "25") int batch) throws Exception {

		model.addAttribute("applicationListFilter", applicationFilter);
		model.addAttribute("currentStage", commonService.getEstados("17"));
		model.addAttribute("applications", applicationListService.filterByCurrentStageApplicationNumberFilters(
				applicationFilter.getCurrentStage(), applicationFilter.getApplicationNumber()));

		return "search_application_stage";
	}

	@RequestMapping(value = "/applications", method = RequestMethod.POST, params = "method=export")
	public String exportApplicationFilterAsExcel(ApplicationListFilter applicationFilter, HttpServletResponse response)
			throws Exception {

		if (env.getProperty("application.restrict.employee.application.by.unicom").equals("true")) {
			applicationFilter.setDistrict(0L);
		}

		final List<ApplicationList> applicationList = applicationListService.filteredApplicationList(applicationFilter);
		if (applicationList.isEmpty()) {
			throw new DataIntegrityException("the filter returned no data");
		} else {
			new ApplicationListExport(applicationList).export(response);
		}

		return null;
	}

	@RequestMapping(value = "/applications", method = RequestMethod.POST, params = "method=filter")
	public String showFilteredApplications(ApplicationListFilter applicationFilter, Model model) throws Exception {
		// model.addAttribute("applicationListFilter", new
		// ApplicationListFilter());

		List<Municipio> municipio = new ArrayList<Municipio>();
		List<Unicom> unicoms = new ArrayList<Unicom>();

		if (env.getProperty("application.restrict.employee.application.by.unicom").equals("true")) {
			final EmployeeUser employeeUser = (EmployeeUser) SecurityContextHolder.getContext().getAuthentication()
					.getPrincipal();
			municipio = municipioService
					.findAllMunicipiosByDeptoAndUnicom(employeeUser.getEmployeeProfile().getCodUnicom());

			/* Company districts */
			unicoms = unicomService.getEmployeeCompanyDistrict(employeeUser.getEmployeeProfile().getCodUnicom());

			// applicationFilter.setDistrict(0L);
		} else {
			municipio = municipioService.findAllMunicipiosByDepto();

			/* Company districts */
			unicoms = unicomService.getAllCompanyDistricts();

		}

		model.addAttribute("districts", municipio);
		model.addAttribute("companyDistricts", unicoms);

		// model.addAttribute("districts",
		// municipioService.findAllMunicipiosByDepto());
		model.addAttribute("statuses", applicationListService.findApplicationStatuses());
		model.addAttribute("defaultValues", applicationService.retrieveDefaultValues());
		final List<ApplicationList> list = applicationListService.filteredApplicationList(applicationFilter);

		model.addAttribute("applications", list);
		applicationFilter.setNoOfPages(applicationListService.countFilteredApplicationList(applicationFilter).intValue());
		model.addAttribute("applicationListFilter", applicationFilter);
		return "client_applications";
	}

}
