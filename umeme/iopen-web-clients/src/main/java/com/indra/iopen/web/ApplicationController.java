package com.indra.iopen.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.indra.iopen.exception.DataIntegrityException;
import com.indra.iopen.form.Application;
import com.indra.iopen.model.IopenApplication;
import com.indra.iopen.service.ApplicationService;
import com.indra.iopen.service.model.MunicipioService;
import com.indra.iopen.util.ErrorInfo;

@Controller
@RequestMapping("/application")
public class ApplicationController {

	private static final Logger logger = LoggerFactory.getLogger(ApplicationController.class);

	@Autowired
	private ApplicationService applicationService;

	@Autowired
	MunicipioService municipioService;

	@Autowired
	private Validator validator;

	@Value("${file.application.input.max.files}")
	private String maxNumberFiles;

	@Value("${file.application.input.min.files}")
	private String minNumberFiles;

	@Value("${file.application.input.max.file.size}")
	private String maxFileSize;

	@Value("${file.application.allowed.file.extensions}")
	private List<String> allowedFileTypes;

	@Autowired
	private Environment env;

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String showNewApplicationForm(final Model model) {
		model.addAttribute(new Application());
		model.addAttribute("districts", municipioService.findAllMunicipiosByDepto());
		model.addAttribute("defaultValues", applicationService.retrieveDefaultValues());
		return "new_application";

	}

	private void validateAttachedFiles(final List<MultipartFile> files, final Errors errors) {
		final Integer maxFiles = Integer.getInteger(maxNumberFiles);
		final Integer minFiles = Integer.getInteger(minNumberFiles);
		final Long maxSize = Long.getLong(maxFileSize);

		if (files.size() > maxFiles) {

			errors.rejectValue("files", "application.error.max.files", new Object[] { maxFiles }, null);
		}

		if (files.size() < minFiles) {
			errors.rejectValue("files", "application.error.min.files", new Object[] { minFiles }, null);
		}

		for (final MultipartFile multipartFile : files) {
			if (multipartFile.getSize() > maxSize) {
				errors.rejectValue("files", "application.error.max.filesize",
						new Object[] { multipartFile.getOriginalFilename(), maxSize }, null);
				if (!allowedFileTypes.contains(multipartFile.getOriginalFilename())) {
					errors.rejectValue("files", "application.error.valid.type",
							new Object[] { multipartFile.getOriginalFilename(),
									env.getProperty("file.application.allowed.file.extensions") },
							null);
				}
			}
		}

	}

	@ExceptionHandler(MultipartException.class)
	public String manageMultipartException(final MultipartHttpServletRequest request, final Application application,
			final Model model, final Errors errors) {
		return "new_application";
	}

	@ExceptionHandler(MaxUploadSizeExceededException.class)
	public String manageMaxUploadSizeExceededException(final MultipartHttpServletRequest request,
			final Application application, final Model model, final Errors errors) {
		return "new_application";
	}

	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public String proccessApplicationForm(final MultipartHttpServletRequest request, final Application application,
			final Model model, final Errors errors) throws MultipartException, MaxUploadSizeExceededException {
		try {
			// if (!application.getAgreeTermsConditions().matches("Y")) {
			// throw new DataIntegrityException(
			// "You cannot register if you have not agreed to the terms and
			// conditions.");
			// }
			// validate the form, not the files uploaded
			validator.validate(application, errors);

			// Getting uploaded files from the request object
			final Map<String, MultipartFile> fileMap = request.getFileMap();
			application.setFiles(new ArrayList<MultipartFile>());
			for (final Map.Entry<String, MultipartFile> entry : fileMap.entrySet()) {
				final MultipartFile file = entry.getValue();
				application.getFiles().add(file);
			}

			// validate the files
			validateAttachedFiles(application.getFiles(), errors);

			if (errors.hasErrors()) {
				model.addAttribute("districts", municipioService.findAllMunicipiosByDepto());
				model.addAttribute("defaultValues", applicationService.retrieveDefaultValues());
				model.addAttribute("application", application);
				model.addAttribute(errors);
				return "new_application";
			}

			final IopenApplication iopenApplication = applicationService.saveUnregisteredApplication(application);
			model.addAttribute("iopenApplication", iopenApplication);
			return "application_successful";

		} catch (final DataIntegrityException e) {
			e.printStackTrace();
			System.out.println("ERROR: DATAINTEGRITY EXCEPTION");
			final ErrorInfo errorInfo = new ErrorInfo(e.getMessage(), HttpStatus.CONFLICT);
			model.addAttribute("errorInfo", errorInfo);
			model.addAttribute("districts", municipioService.findAllMunicipiosByDepto());
			model.addAttribute("defaultValues", applicationService.retrieveDefaultValues());
			return "new_application";
		} catch (final Exception e) {
			e.printStackTrace();
			final ErrorInfo errorInfo = new ErrorInfo("Oops it seems something went wrong, please try again later:\n "
					+ "IF symptoms persist seek the Administrator's advice ", HttpStatus.INTERNAL_SERVER_ERROR);
			model.addAttribute("errorInfo", errorInfo);
			model.addAttribute("districts", municipioService.findAllMunicipiosByDepto());
			model.addAttribute("defaultValues", applicationService.retrieveDefaultValues());
			return "new_application";
		}

	}

	/**
	 *
	 * @param model
	 * @return view name
	 */
	@RequestMapping(value = "/status")
	public final String applicationsStatus(final Model model) {
		// retrieve Application list from database
		return "application_list";
	}

	/**
	 *
	 * @param model
	 * @return view name
	 */
	@RequestMapping(value = "/status/{id}", method = RequestMethod.GET)
	public final String applicationsStatusDetail(final Model model) {
		// retrieve Application from database
		return "application_detail";
	}

}
