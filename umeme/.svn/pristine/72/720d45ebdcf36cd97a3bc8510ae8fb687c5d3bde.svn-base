package com.indra.iopen.web;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.indra.iopen.exception.DataIntegrityException;
import com.indra.iopen.form.Application;
import com.indra.iopen.form.ApplicationList;
import com.indra.iopen.form.ApplicationListFilter;
import com.indra.iopen.form.ApplicationPendingInvoiceInformation;
import com.indra.iopen.form.ApplicationStatusInformation;
import com.indra.iopen.form.ChangePassword;
import com.indra.iopen.form.IOpenFile;
import com.indra.iopen.form.SearchApplication;
import com.indra.iopen.model.IopenApplication;
import com.indra.iopen.model.IopenApplicationDoc;
import com.indra.iopen.model.security.users.ClientUser;
import com.indra.iopen.repositories.model.IopenApplicationRepository;
import com.indra.iopen.service.ApplicationListService;
import com.indra.iopen.service.ApplicationService;
import com.indra.iopen.service.CommonService;
import com.indra.iopen.service.ContractService;
import com.indra.iopen.service.PDFService;
import com.indra.iopen.service.UserService;
import com.indra.iopen.service.model.CallejeroService;
import com.indra.iopen.service.model.LocalidadeService;
import com.indra.iopen.service.model.MunicipioService;
import com.indra.iopen.util.ErrorInfo;
import com.indra.iopen.util.FileValidator;

@Controller
public class ClientController {

	private static final Logger logger = LoggerFactory.getLogger(ClientController.class);

	@Autowired
	private ApplicationListService applicationListService;

	@Autowired
	private ApplicationService applicationService;

	@Autowired
	private UserService userService;
	@Autowired
	private FileValidator fileValidator;

	@Autowired
	private MunicipioService municipioService;

	@Autowired
	private LocalidadeService localidadeService;

	@Autowired
	private IopenApplicationRepository iopenApplicationRepository;

	@Autowired
	private CallejeroService callejeroService;

	@Autowired
	private Validator validator;

	@Autowired
	private Environment env;
	@Autowired
	private ContractService contractService;
	@Autowired
	private CommonService commonService;

	@Autowired
	private MessageSource messageSource;

	private final String genericErrorMsg = "application.error.generic";

	@Autowired
	private PDFService pdfService;

	@RequestMapping(value = "/client/application/steps", method = RequestMethod.GET)
	public String applicationSteps(final Model model) {
		return "application_steps";
	}

	@RequestMapping(value = "/client/application/instructions", method = RequestMethod.GET)
	public String applicationInstructions(final Model model) {
		return "application_instructions";
	}

	@RequestMapping(value = "/client/application/cancel/{id}")
	public String changeApplicationStatus(final Model model, @PathVariable(value = "id") final Long id)
			throws Exception {

		applicationListService.cancelApplication(id);
		return "cancel_application";
	}

	@RequestMapping(value = "/client/password/change", method = RequestMethod.POST)
	public String changePassword(final ChangePassword changePassword, final Model model, final Errors errors)
			throws Exception {
		validator.validate(changePassword, errors);
		if (!StringUtils.equals(changePassword.getNewPassword(), changePassword.getRepeatNewPassword())) {
			errors.rejectValue("repeatNewPassword", "passwords.not.match");
		}
		if (StringUtils.equals(changePassword.getOldPassword(), changePassword.getNewPassword())) {
			errors.rejectValue("newPassword", "new.passwords.mustbedifferent");
		}
		if (!errors.hasErrors()) {
			if (!userService.changePassword(changePassword.getOldPassword(), changePassword.getNewPassword())) {
				errors.rejectValue("oldPassword", "wrong.password");
			}
		}

		if (errors.hasErrors()) {
			return "change_password";
		}

		return "redirect:/logout";
	}

	// TODO find way of making the request method beDELETE
	@RequestMapping(value = "/client/application/doc", method = RequestMethod.GET)
	public String deleteDoc(final Model model, @RequestParam("codApplication") final String appId,
			@RequestParam(value = "complete", defaultValue = "true") final boolean complete,
			@RequestParam("tipDoc") final String docId) throws Exception {

		applicationListService.deleteDoc(appId, docId);
		return "redirect:/client/application/" + appId + "?complete=" + complete + "&edit=" + true;
	}

	@RequestMapping(value = "/client/application/new/doc", method = RequestMethod.GET)
	public String deleteDocSavedApplication(final Model model, @RequestParam("codApplication") final String appId,
			@RequestParam(value = "complete", defaultValue = "false") final boolean complete,
			@RequestParam("tipDoc") final String docId) throws Exception {

		applicationListService.deleteDoc(appId, docId);

		return "redirect:/client/application/new?codApplication=" + appId + "&complete=" + complete;
	}

	@RequestMapping(value = "/client/application/print", method = RequestMethod.GET)
	public String downloadApplicationPDF(final HttpServletResponse response) {

		File doc = null;
		try {
			doc = pdfService.createTAC();
		} catch (final Exception e1) {
			e1.printStackTrace();
		}

		try (OutputStream out = response.getOutputStream();) {
			response.setHeader("Content-Disposition", "inline;filename=\"" + doc.getName() + "\"");

			response.setContentType("application/pdf");
			IOUtils.copy(new ByteArrayInputStream(Files.readAllBytes(doc.toPath())), out);
			response.flushBuffer();

		} catch (final Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@RequestMapping("/client/download")
	public String download(@RequestParam("codApplication") final long codApplication,
			@RequestParam("tipDoc") final String tipDoc, final HttpServletResponse response) {

		IOpenFile doc = null;
		try {
			doc = applicationListService.findIopenApplicationDocById(codApplication, tipDoc);
		} catch (final FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try (OutputStream out = response.getOutputStream();) {
			response.setHeader("Content-Disposition", "inline;filename=\"" + doc.getOriginalFilename() + "\"");

			response.setContentType(doc.getContentType());
			IOUtils.copy(new ByteArrayInputStream(doc.getFile()), out);
			response.flushBuffer();

		} catch (final Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@RequestMapping(value = "/client/application/{id}", method = RequestMethod.POST)
	public String editApplication(final MultipartHttpServletRequest request, Model model,
			/* @RequestBody */ ApplicationList applicationList, @PathVariable(value = "id") final String id,
			final Errors errors) {
		// model.addAttribute("application", );

		validator.validate(applicationList, errors);

		if (errors.hasErrors()) {
			// model.addAttribute("application",
			// applicationListService.clientApplicationDetail(Long.valueOf(id)));
			model.addAttribute("application", applicationList);
			model.addAttribute("defaultValues", applicationService.retrieveDefaultValues());
			model.addAttribute("districts", municipioService.findAllMunicipiosByDepto());
			// SMA 20160219 UMESC-444 start
			// model =
			// getLocationModelData(applicationList.getIopenApplication(),
			// model);
			// SMA 20160219 UMESC-444 end
			return "client_view_application";
		}

		try {
			// Getting uploaded files from the request object
			final Map<String, MultipartFile> fileMap = request.getFileMap();
			applicationList.setFiles(new ArrayList<MultipartFile>());
			for (final String key : fileMap.keySet()) {
				final MultipartFile file = fileMap.get(key);
				applicationList.getFiles().add(file);
			}

			applicationList = applicationListService.edit(applicationList);
			// SMA 20160407
			boolean intermediateSubmit = true;
			for (final IopenApplicationDoc doc : applicationList.getIopenApplication().getIopenApplicationDocs()) {
				if (doc.getTac().equalsIgnoreCase("1")) {
					intermediateSubmit = false;
				}
			}
			if (applicationList.getIopenApplication().getIopenApplicationDocs().size() < 4) {
				return "redirect:/client/application/" + applicationList.getIopenApplication().getCodApplication()
						+ "edit=" + true;
			}

			if (intermediateSubmit) {
				return "redirect:/client/application/new/tac?codApplication="
						+ applicationList.getIopenApplication().getCodApplication();
			} else {
				return "redirect:/client/applications";
			}

		} catch (final DataIntegrityException e) {

			// model.addAttribute("edit", edit);

			System.out.println("ERROR: DATAINTEGRITY EXCEPTION");
			final ErrorInfo errorInfo = new ErrorInfo(e.getMessage(), HttpStatus.CONFLICT);
			final ApplicationList applicationList2 = applicationListService.clientApplicationDetail(Long.valueOf(id),
					true);
			model.addAttribute("errorInfo", errorInfo);
			model.addAttribute("districts", municipioService.findAllMunicipiosByDepto());
			model.addAttribute("application", applicationList2);
			model.addAttribute("defaultValues", applicationService.retrieveDefaultValues());
			model = getLocationModelData(applicationList2.getIopenApplication(), model);

			return "client_view_application";
		} catch (final Exception e) {
			e.printStackTrace();
			final ErrorInfo errorInfo = new ErrorInfo(env.getProperty("application.exception.message"),
					HttpStatus.INTERNAL_SERVER_ERROR);
			final ApplicationList applicationList2 = applicationListService.clientApplicationDetail(Long.valueOf(id),
					true);
			model.addAttribute("errorInfo", errorInfo);
			model.addAttribute("districts", municipioService.findAllMunicipiosByDepto());
			model.addAttribute("application", applicationList2);
			model.addAttribute("defaultValues", applicationService.retrieveDefaultValues());
			model = getLocationModelData(applicationList2.getIopenApplication(), model);
			return "client_view_application";
		}

	}

	@RequestMapping(value = "/client/application/new", method = RequestMethod.POST)
	public String processApplicationForm(final MultipartHttpServletRequest request, final Application application,
			final Model model, final Errors errors) throws Exception {
		String page = null;
		// SMA 20160314
		if (application.getDocumentType() != null && !application.getDocumentType().isEmpty()
				&& application.getDocumentType().contains(",")) {
			application.setDocumentType(application.getDocumentType().split(",")[0]);
		}
		if (application.getActionMethod().equalsIgnoreCase("save")) {
			application.setValidateFile(false);
			page = proccessApplicationFormSave(request, application, model, errors);
		} else if (application.getActionMethod().equalsIgnoreCase("submit")) {
			page = proccessApplicationFormSubmit(request, application, model, errors);
		} else if (application.getActionMethod().equalsIgnoreCase("cancel")) {
			application.setValidateFile(false);
			page = processApplicationFormCancel(request, application, model, errors);
		}

		return page;

	}

	@RequestMapping(value = "/client/application/new/tac", method = RequestMethod.POST)
	public String processApplicationFormTac(@RequestParam(required = false) final Long codApplication,
			final MultipartHttpServletRequest request, final Application application, final Model model,
			final Errors errors) throws Exception {
		String page = null;
		// SMA 20160407
		if (application.getDocumentType() != null && !application.getDocumentType().isEmpty()
				&& application.getDocumentType().contains(",")) {
			application.setDocumentType(application.getDocumentType().split(",")[0]);
		}
		application.setValidateFile(false);
		page = proccessApplicationFormSubmitTac(request, application, model, errors);

		return page;

	}

	@RequestMapping(value = "/client/application/new/tac", method = RequestMethod.GET)
	public String showNewApplicationFormTac(final Model model,
			@RequestParam(required = false) final Long codApplication) {
		String returnPage = null;
		Boolean newCustomer = false;

		try {
			final ClientUser clientUser = (ClientUser) SecurityContextHolder.getContext().getAuthentication()
					.getPrincipal();

			Application application = new Application();

			application = new Application();/*
			 * applicationService.
			 * getIncompleteApplication(
			 * codApplication);
			 */
			application.setValidateFile(false);
			application.setCodApplication(codApplication);

			// check if new user
			if (application.getCodCli() == null || application.getCodCli() == 0L) {
				newCustomer = true;
			}

			application.setEmailAddress(clientUser.getUsername());
			// SMA 20160314
			application.setMobileNumber(clientUser.getClienteProfile().getPhoneNumber());

			returnPage = "upload_tac";

			application.setPage(returnPage);
			model.addAttribute("application", application);
			model.addAttribute("defaultValues", applicationService.retrieveDefaultValues());
			model.addAttribute("newCustomer", newCustomer);
		} catch (final Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return returnPage;
	}

	// @RequestMapping(value = "/application/new", method = RequestMethod.POST,
	// params = {"submit","!save"})
	public String proccessApplicationFormSubmit(final MultipartHttpServletRequest request,
			final Application application, Model model, final Errors errors) {

		String onErrorPage = null;
		final String onSuccessPage = "application_successful";
		// SMA 20160407
		final String uploadTacPage = "redirect:/client/application/new/tac?";
		IopenApplication iopenApplication = new IopenApplication();
		try {

			if (application.getPage().equalsIgnoreCase("existing_client_new_application")) {
				onErrorPage = "existing_client_new_application";
			} else if (application.getPage().equalsIgnoreCase("new_application")) {
				onErrorPage = "new_application";

				validator.validate(application, errors);
			}

			final ClientUser clientUser = (ClientUser) SecurityContextHolder.getContext().getAuthentication()
					.getPrincipal();
			// SMA 20160412 check plot number
			if (!application.getHousePlot().matches("\\d+")) {
				throw new DataIntegrityException("House plot number should be a numerical value");
			}
			// Getting uploaded files from the request object
			final Map<String, MultipartFile> fileMap = request.getFileMap();
			application.setFiles(new ArrayList<MultipartFile>());
			for (final String key : fileMap.keySet()) {
				final MultipartFile file = fileMap.get(key);
				application.getFiles().add(file);

			}
			// SMA 20160406 start to validate document numbers
			int docNumber = application.getFiles().size();
			if (application.getCodApplication() != null && application.getCodApplication() != 0) {
				docNumber += iopenApplicationRepository.findOne(application.getCodApplication())
						.getIopenApplicationDocs().size();
			}
			if (docNumber > 5) {
				throw new DataIntegrityException("you cannot upload more than 5 documents please remove some");
			} else if (docNumber < 3) {
				throw new DataIntegrityException(
						"Please ensure that you have uploaded all the documents in the checklist");
			}
			// SMA 20160406 end
			if (errors.hasErrors()) {
				System.out.println("APPLICATION WITH ERROR");
				model.addAttribute("application", applicationService.getApplicationForLoggedInUser(clientUser));
				// model.addAttribute("districts",
				// municipioService.findAllMunicipiosByDepto());
				// model = getLocationModelData(application, model);
				model.addAttribute("defaultValues", applicationService.retrieveDefaultValues());
				model.addAttribute(errors);

				return onErrorPage;
			}

			if (application.getCustomerContactPerson().equalsIgnoreCase("self")) {
				application.setContactName(application.getFirstName() + " " + application.getMiddleName() + " "
						+ application.getSurname());
				application.setContactNumber(application.getMobileNumber());
			}

			fileValidator.validate(application, errors);
			// SMA 20160704
			iopenApplication = applicationService.submitApplication(application, true);
			// if
			// (application.getPage().equalsIgnoreCase("existing_client_new_application"))
			// {
			// iopenApplication =
			// applicationService.submitApplcationWhenLoggedIn(application,
			// clientUser);
			// } else if
			// (application.getPage().equalsIgnoreCase("new_application")) {
			// iopenApplication =
			// applicationService.submitUnregisteredApplication(application);
			// }

			model.addAttribute("iopenApplication", iopenApplication);
			// SMA 20160407
			boolean intermediateSubmit = true;
			for (final IopenApplicationDoc doc : iopenApplication.getIopenApplicationDocs()) {
				if (doc.getTac().equalsIgnoreCase("1")) {
					intermediateSubmit = false;
				}
			}
			if (intermediateSubmit) {
				return uploadTacPage + "codApplication=" + iopenApplication.getCodApplication();
			} else {
				return onSuccessPage;
			}

		} catch (final DataIntegrityException e) {
			System.out.println("ERROR: DATAINTEGRITY EXCEPTION");
			final ErrorInfo errorInfo = new ErrorInfo(e.getMessage(), HttpStatus.CONFLICT);
			model.addAttribute("errorInfo", errorInfo);
			try {
				model.addAttribute("application",
						applicationService.getIncompleteApplication(application.getCodApplication()));
			} catch (final Exception ex) {
				e.printStackTrace();
			}
			// model.addAttribute("districts",
			// municipioService.findAllMunicipiosByDepto());
			// model = getLocationModelData(application, model);
			model.addAttribute("defaultValues", applicationService.retrieveDefaultValues());
			return onErrorPage;
		} catch (final Exception e) {
			e.printStackTrace();
			final ErrorInfo errorInfo = new ErrorInfo(env.getProperty("application.exception.message"),
					HttpStatus.INTERNAL_SERVER_ERROR);
			model.addAttribute("errorInfo", errorInfo);
			try {
				model.addAttribute("application",
						applicationService.getIncompleteApplication(application.getCodApplication()));
			} catch (final Exception ex) {
				e.printStackTrace();
			}
			// model.addAttribute("districts",
			// municipioService.findAllMunicipiosByDepto());
			// model = getLocationModelData(application, model);
			model.addAttribute("defaultValues", applicationService.retrieveDefaultValues());

			return onErrorPage;
		}

	}

	@RequestMapping(value = "/client/application/{id}", method = RequestMethod.GET)
	public String showApplication(Model model, @PathVariable(value = "id") final String id,
			@RequestParam(value = "complete", defaultValue = "true") final boolean complete,
			@RequestParam(value = "edit", defaultValue = "false") final boolean edit) throws Exception {
		final ClientUser clientUser = (ClientUser) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();

		Boolean newCustomer = false;
		if (clientUser.getClienteProfile() == null || clientUser.getClienteProfile().getCodCli() == 0L) {
			newCustomer = true;
		}
		final ApplicationList applicationList = applicationListService.clientApplicationDetail(Long.valueOf(id),
				complete);
		model.addAttribute("application", applicationList);

		model.addAttribute("defaultValues", applicationService.retrieveDefaultValues());
		model = getLocationModelData(applicationList.getIopenApplication(), model);
		model.addAttribute("edit", edit);
		model.addAttribute("newCustomer", newCustomer);

		return "client_view_application";

	}

	@RequestMapping(value = "/client/home", method = RequestMethod.GET)
	public String showHome(Model model) throws Exception {

		final ClientUser clientUser = (ClientUser) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();

		final Long noOfServices = contractService
				.getNumberOfClientContracts(clientUser.getClienteProfile().getCodCli());

		if (noOfServices == null || noOfServices == 0) {
			final List<ApplicationList> applicationLists = applicationListService
					.clientApplicationList(clientUser.getClienteProfile(), true);
			if (applicationLists == null || applicationLists.isEmpty()) {
				final List<ApplicationList> applicationListsIncomplete = applicationListService
						.clientIncompleteApplicationList(clientUser.getClienteProfile());
				if (applicationListsIncomplete == null || applicationListsIncomplete.isEmpty()) {
					return "redirect:/client/application/instructions";
				} else {
					return "redirect:/client/applications/incomplete";
				}
			} else {
				return "redirect:/client/applications";
			}
		} else if (noOfServices == 1) {
			// Calendar calendar = Calendar.getInstance();
			// List<Contract> contracts =
			// contractService.getClientContracts(clientUser.getClienteProfile().getCodCli());
			return "redirect:/client/contract/bills";
		} else if (noOfServices > 1) {
			return "redirect:/client/contract/list";
		} else {
			return "redirect:/client/application/instructions";
		}

	}

	@RequestMapping(value = "/client/applications", method = RequestMethod.GET)
	public String showApplications(final Model model,
			@RequestParam(value = "complete", defaultValue = "true") final boolean complete) throws Exception {

		final ClientUser clientUser = (ClientUser) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		model.addAttribute("applicationListFilter", new ApplicationListFilter());

		model.addAttribute("statuses", applicationListService.findApplicationStatuses());

		model.addAttribute("stages", commonService.getEstados("17"));

		model.addAttribute("applications",
				applicationListService.clientApplicationList(clientUser.getClienteProfile(), complete));

		return "my_applications";
	}

	@RequestMapping(value = "/client/applications", method = RequestMethod.POST)
	public String showApplicationsByStatus(final Model model, final ApplicationListFilter applicationListFilter,
			@RequestParam(value = "complete", defaultValue = "true") final boolean complete) throws Exception {

		applicationListFilter.setComplete(complete);
		model.addAttribute("applications", applicationListService.clientFilteredApplicationList(applicationListFilter));

		model.addAttribute("applicationListFilter", applicationListFilter);

		model.addAttribute("statuses", applicationListService.findApplicationStatuses());

		model.addAttribute("stages", commonService.getEstados("17"));

		return "my_applications";

		// if (applicationListFilter.getApplicationStatus() != null
		// && !applicationListFilter.getApplicationStatus().isEmpty()) {
		// model.addAttribute("applications",
		// applicationListService.clientApplicationListByStatus(
		// clientUser.getClienteProfile(),
		// applicationListFilter.getApplicationStatus(), complete));
		// model.addAttribute("applicationListFilter", applicationListFilter);
		//
		// model.addAttribute("statuses",
		// applicationListService.findApplicationStatuses());
		// return "my_applications";
		// } else {
		// model.addAttribute("applicationListFilter", new
		// ApplicationListFilter());
		//
		// model.addAttribute("statuses",
		// applicationListService.findApplicationStatuses());
		//
		// model.addAttribute("applications",
		// applicationListService.clientApplicationList(clientUser.getClienteProfile(),
		// complete));
		//
		// return "my_applications";
		// }
	}

	@RequestMapping(value = "/client/password/change", method = RequestMethod.GET)
	public String showChangePasswordForm(final Model model) {
		model.addAttribute("changePassword", new ChangePassword());

		return "change_password";
	}

	@RequestMapping(value = "/client/applications/incomplete", method = RequestMethod.GET)
	public String showIncompleteApplications(final Model model) throws Exception {

		final ClientUser clientUser = (ClientUser) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();

		model.addAttribute("applicationListFilter", new ApplicationListFilter());
		model.addAttribute("applications",
				applicationListService.clientIncompleteApplicationList(clientUser.getClienteProfile()));
		model.addAttribute("defaultValues", applicationService.retrieveDefaultKeys());
		model.addAttribute("statuses", applicationListService.findApplicationStatuses());
		return "my_incomplete_applications";
	}

	@RequestMapping(value = "/client/applications/incomplete", method = RequestMethod.POST)
	public String filterIncompleteApplications(final Model model, final ApplicationListFilter applicationListFilter,
			@RequestParam(value = "complete", defaultValue = "false") final boolean complete) throws Exception {

		applicationListFilter.setComplete(complete);
		model.addAttribute("applications", applicationListService.clientFilteredApplicationList(applicationListFilter));

		model.addAttribute("applicationListFilter", applicationListFilter);

		model.addAttribute("statuses", applicationListService.findApplicationStatuses());

		return "my_incomplete_applications";
	}

	@RequestMapping(value = "/client/application/new", method = RequestMethod.GET)
	public String showNewApplicationForm(final Model model, @RequestParam(required = false) final Long codApplication,
			@RequestParam(required = false) final Boolean complete) {
		String returnPage = null;
		Boolean newCustomer = false;

		try {
			final ClientUser clientUser = (ClientUser) SecurityContextHolder.getContext().getAuthentication()
					.getPrincipal();

			Application application = new Application();

			model.addAttribute("districts", municipioService.findAllMunicipiosByDepto());
			if (complete != null && !complete) {
				application = applicationService.getIncompleteApplication(codApplication);
				final BigDecimal district = new BigDecimal(application.getDistrict());
				if (application.getDistrict() > 0) {
					model.addAttribute("villages", localidadeService.findVillageByDistrictCode(district));
				}
				final BigDecimal village = new BigDecimal(application.getVillage());
				if (application.getVillage() > 0) {
					model.addAttribute("localities", localidadeService.findLocalityByVillageCode(village));
				}
				final BigDecimal street = new BigDecimal(application.getLocality());
				if (application.getLocality() > 0) {
					model.addAttribute("streets", callejeroService.findStreetByLocalityCode(street));
				}
				application.setValidateFile(false);
			} else {
				application = applicationService.getApplicationForLoggedInUser(clientUser);
			}

			// check if new user
			if (application.getCodCli() == null || application.getCodCli() == 0L) {
				newCustomer = true;
			}

			application.setEmailAddress(clientUser.getUsername());
			// SMA 20160314
			application.setMobileNumber(clientUser.getClienteProfile().getPhoneNumber());

			// if (application.getSurname() == null) {
			// if (clientUser.getClienteProfile().getCodCli() == 0) {
			// returnPage = "new_application";
			// } else {
			// returnPage = "existing_client_new_application";
			// }

			returnPage = "existing_client_new_application";

			application.setPage(returnPage);
			model.addAttribute("application", application);
			model.addAttribute("defaultValues", applicationService.retrieveDefaultValues());
			model.addAttribute("newCustomer", newCustomer);
		} catch (final Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return returnPage;
	}

	@RequestMapping(value = "/client/application/searchAny", method = RequestMethod.GET)
	public String showSearchApplication(final Model model) throws Exception {

		model.addAttribute("application", new SearchApplication());
		model.addAttribute("applicationList", new ArrayList<ApplicationList>());

		return "client_search_application";
	}

	@RequestMapping(value = "/client/application/searchAny", method = RequestMethod.POST)
	public String submitSearchApplication(final Model model, @Valid final SearchApplication application)
			throws Exception {
		List<ApplicationList> applicationList = null;
		try {
			if (application.getApplicationNumber() != null && !application.getApplicationNumber().isEmpty()
					&& application.getTrackingNumber() != null && !application.getTrackingNumber().isEmpty()) {
				applicationList = applicationListService.searchApplicationByTrackingNumberOrApplicationNumber(
						application.getTrackingNumber(), application.getApplicationNumber());
			} else if (application.getApplicationNumber() != null && !application.getApplicationNumber().isEmpty()
					&& (application.getTrackingNumber() == null || application.getTrackingNumber().isEmpty())) {
				applicationList = applicationListService.searchApplicationByNumExp(application.getApplicationNumber());
			} else {
				applicationList = applicationListService
						.searchApplicationByTrackingNumber(application.getApplicationNumber());
			}
			model.addAttribute("applicationList", applicationList);
			model.addAttribute("application", new SearchApplication());

			return "client_search_application";

		} catch (final DataIntegrityException e) {
			System.out.println("ERROR: DATAINTEGRITY EXCEPTION");
			final ErrorInfo errorInfo = new ErrorInfo(e.getMessage(), HttpStatus.CONFLICT);
			model.addAttribute("errorInfo", errorInfo);
			model.addAttribute("applicationList", new ArrayList<ApplicationList>());
			model.addAttribute("application", new SearchApplication());
			return "client_search_application";

		} catch (final Exception e) {
			e.printStackTrace();
			final ErrorInfo errorInfo = new ErrorInfo(env.getProperty("application.exception.message"),
					HttpStatus.INTERNAL_SERVER_ERROR);
			model.addAttribute("errorInfo", errorInfo);
			model.addAttribute("applicationList", new ArrayList<ApplicationList>());
			model.addAttribute("application", new SearchApplication());

			return "client_search_application";
		}
	}

	// @RequestMapping(value = "/application/new", method = RequestMethod.POST,
	// params = {"save", "!submit"})
	public String proccessApplicationFormSave(final MultipartHttpServletRequest request, final Application application,
			Model model, final Errors errors) throws Exception {

		String onErrorPage = null;
		onErrorPage = "existing_client_new_application";

		// if
		// (application.getPage().equalsIgnoreCase("existing_client_new_application"))
		// {
		// onErrorPage = "existing_client_new_application";
		// } else if (application.getPage().equalsIgnoreCase("new_application"))
		// {
		// onErrorPage = "new_application";
		// }

		// final ClientUser clientUser = (ClientUser)
		// SecurityContextHolder.getContext().getAuthentication()
		// .getPrincipal();

		IopenApplication iopenApplication = new IopenApplication();

		try {
			// Getting uploaded files from the request object
			final Map<String, MultipartFile> fileMap = request.getFileMap();
			application.setFiles(new ArrayList<MultipartFile>());
			for (final String key : fileMap.keySet()) {
				final MultipartFile file = fileMap.get(key);
				application.getFiles().add(file);
			}

			if (application.isValidateFile()) {
				fileValidator.validate(application, errors);
			}

			// if
			// (application.getPage().equalsIgnoreCase("existing_client_new_application"))
			// {
			// iopenApplication =
			// applicationService.saveApplcationWhenLoggedIn(application,
			// clientUser);
			// } else if
			// (application.getPage().equalsIgnoreCase("new_application")) {
			// iopenApplication =
			// applicationService.saveUnregisteredApplication(application);
			// }

			iopenApplication = applicationService.submitApplication(application, false);

			model.addAttribute("iopenApplication", iopenApplication);
			return "redirect:/client/applications/incomplete";

		} catch (final DataIntegrityException e) {
			System.out.println("ERROR: DATAINTEGRITY EXCEPTION");
			final ErrorInfo errorInfo = new ErrorInfo(e.getMessage(), HttpStatus.CONFLICT);

			if (application.getCodApplication() != null && application.getCodApplication() > 0) {
				model.addAttribute("application",
						applicationService.getIncompleteApplication(application.getCodApplication()));
			}
			model.addAttribute("errorInfo", errorInfo);
			// model.addAttribute("districts",
			// municipioService.findAllMunicipiosByDepto());
			// model = getLocationModelData(application, model);
			model.addAttribute("defaultValues", applicationService.retrieveDefaultValues());
			return onErrorPage;
		} catch (final Exception e) {
			e.printStackTrace();
			final ErrorInfo errorInfo = new ErrorInfo(env.getProperty("application.exception.message"),
					HttpStatus.INTERNAL_SERVER_ERROR);
			model.addAttribute("application", application);
			model.addAttribute("errorInfo", errorInfo);
			// model.addAttribute("districts",
			// municipioService.findAllMunicipiosByDepto());
			// model = getLocationModelData(application, model);
			model.addAttribute("defaultValues", applicationService.retrieveDefaultValues());

			return onErrorPage;
		}

	}

	public String proccessApplicationFormSubmitTac(final MultipartHttpServletRequest request,
			final Application application, Model model, final Errors errors) throws Exception {

		String onErrorPage = null;
		onErrorPage = "redirect:/client/application/new/tac?codApplication=" + application.getCodApplication();

		// if
		// (application.getPage().equalsIgnoreCase("existing_client_new_application"))
		// {
		// onErrorPage = "existing_client_new_application";
		// } else if (application.getPage().equalsIgnoreCase("new_application"))
		// {
		// onErrorPage = "new_application";
		// }

		// final ClientUser clientUser = (ClientUser)
		// SecurityContextHolder.getContext().getAuthentication()
		// .getPrincipal();

		IopenApplication iopenApplication = new IopenApplication();

		try {
			// Getting uploaded files from the request object
			final Map<String, MultipartFile> fileMap = request.getFileMap();
			// SMA 20160407
			if (fileMap == null || fileMap.isEmpty()) {
				throw new DataIntegrityException("you must upload the terms and conditions document");
			}
			application.setFiles(new ArrayList<MultipartFile>());
			for (final String key : fileMap.keySet()) {
				final MultipartFile file = fileMap.get(key);
				application.getFiles().add(file);
			}

			if (application.isValidateFile()) {
				fileValidator.validate(application, errors);
			}

			// if
			// (application.getPage().equalsIgnoreCase("existing_client_new_application"))
			// {
			// iopenApplication =
			// applicationService.saveApplcationWhenLoggedIn(application,
			// clientUser);
			// } else if
			// (application.getPage().equalsIgnoreCase("new_application")) {
			// iopenApplication =
			// applicationService.saveUnregisteredApplication(application);
			// }

			iopenApplication = applicationService.submitApplicationTaC(application, true);

			model.addAttribute("iopenApplication", iopenApplication);
			return "application_successful";

		} catch (final DataIntegrityException e) {
			System.out.println("ERROR: DATAINTEGRITY EXCEPTION");
			final ErrorInfo errorInfo = new ErrorInfo(e.getMessage(), HttpStatus.CONFLICT);

			model.addAttribute("errorInfo", errorInfo);
			// model.addAttribute("districts",
			// municipioService.findAllMunicipiosByDepto());
			// model = getLocationModelData(application, model);
			model.addAttribute("defaultValues", applicationService.retrieveDefaultValues());
			return onErrorPage;
		} catch (final Exception e) {
			e.printStackTrace();
			final ErrorInfo errorInfo = new ErrorInfo(env.getProperty("application.exception.message"),
					HttpStatus.INTERNAL_SERVER_ERROR);
			model.addAttribute("application", application);
			model.addAttribute("errorInfo", errorInfo);
			// model.addAttribute("districts",
			// municipioService.findAllMunicipiosByDepto());
			// model = getLocationModelData(application, model);
			model.addAttribute("defaultValues", applicationService.retrieveDefaultValues());

			return onErrorPage;
		}

	}

	public Environment getEnv() {
		return env;
	}

	public void setEnv(final Environment env) {
		this.env = env;
	}

	@RequestMapping(value = "/client/application/statusinformation/{codApplication}", method = RequestMethod.GET)
	public String showApplicationStatusInformation(final Model model,
			@RequestParam(value = "complete", defaultValue = "true") final boolean complete,
			@PathVariable(value = "codApplication") final long codApplication,
			@RequestParam(value = "edit", defaultValue = "false") final boolean edit) throws Exception {
		// SMA 20160219 UMESC-444 start
		final ApplicationStatusInformation applicationStatusInformation = applicationListService
				.clientApplicationStatusInformation(Long.valueOf(codApplication), complete);
		applicationStatusInformation.setCodApplication(codApplication);
		model.addAttribute("applicationstatus", applicationStatusInformation);
		// SMA 20160219 UMESC-444 end
		model.addAttribute("codApplication", codApplication);
		model.addAttribute("edit", edit);
		return "application_status_information";
	}

	@RequestMapping(value = "/client/application/pendinginvoice/{codApplication}", method = RequestMethod.GET)
	public String showApplicationPendingInvoices(final Model model,
			@RequestParam(value = "complete", defaultValue = "true") final boolean complete,
			@PathVariable(value = "codApplication") final long codApplication,
			@RequestParam(value = "edit", defaultValue = "false") final boolean edit) throws Exception {
		// SMA 20160219 UMESC-444 start
		final ApplicationPendingInvoiceInformation applicationPendingInvoiceInformation = applicationListService
				.clientApplicationPendingInvoiceInformation(Long.valueOf(codApplication), complete);
		applicationPendingInvoiceInformation.setCodApplication(codApplication);
		model.addAttribute("pendingInvoiceList", applicationPendingInvoiceInformation);
		// SMA 20160219 UMESC-444 end
		model.addAttribute("codApplication", codApplication);
		model.addAttribute("edit", edit);
		return "application_pending_invoices";
	}

	private Model getLocationModelData(final IopenApplication iopenApplication, final Model model) {
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
		return model;
	}

	private Model getLocationModelData(final Application application, final Model model) {
		model.addAttribute("districts", municipioService.findAllMunicipiosByDepto());
		final BigDecimal district = new BigDecimal(application.getDistrict());
		if (application.getDistrict() > 0) {
			model.addAttribute("villages", localidadeService.findVillageByDistrictCode(district));
		}
		final BigDecimal village = new BigDecimal(application.getVillage());
		if (application.getVillage() > 0) {
			model.addAttribute("localities", localidadeService.findLocalityByVillageCode(village));
		}
		final BigDecimal street = new BigDecimal(application.getLocality());
		if (application.getLocality() > 0) {
			model.addAttribute("streets", callejeroService.findStreetByLocalityCode(street));
		}
		return model;
	}

	public String processApplicationFormCancel(final MultipartHttpServletRequest request, final Application application,
			Model model, final Errors errors) throws Exception {

		String onErrorPage = null;

		if (application.getPage().equalsIgnoreCase("existing_client_new_application")) {
			onErrorPage = "existing_client_new_application";
		} else if (application.getPage().equalsIgnoreCase("new_application")) {
			onErrorPage = "new_application";
		}

		try {

			if (application.getCodApplication() != null) {
				applicationService.discardIncompleteApplication(application);
			}

			return "redirect:/client/application/steps";

		} catch (final DataIntegrityException e) {
			System.out.println("ERROR: DATAINTEGRITY EXCEPTION");
			final ErrorInfo errorInfo = new ErrorInfo(e.getMessage(), HttpStatus.CONFLICT);

			if (application.getCodApplication() != null && application.getCodApplication() > 0) {
				model.addAttribute("application",
						applicationService.getIncompleteApplication(application.getCodApplication()));
			}
			model.addAttribute("errorInfo", errorInfo);
			// model.addAttribute("districts",
			// municipioService.findAllMunicipiosByDepto());
			// model = getLocationModelData(application, model);
			model.addAttribute("defaultValues", applicationService.retrieveDefaultValues());
			return onErrorPage;
		} catch (final Exception e) {
			e.printStackTrace();
			final ErrorInfo errorInfo = new ErrorInfo(env.getProperty("application.exception.message"),
					HttpStatus.INTERNAL_SERVER_ERROR);
			model.addAttribute("application", application);
			model.addAttribute("errorInfo", errorInfo);
			// model.addAttribute("districts",
			// municipioService.findAllMunicipiosByDepto());
			// model = getLocationModelData(application, model);
			model.addAttribute("defaultValues", applicationService.retrieveDefaultValues());

			return onErrorPage;
		}

	}

}
