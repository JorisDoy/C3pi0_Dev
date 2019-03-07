package com.indra.iopen.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

import com.indra.iopen.exception.DataIntegrityException;
import com.indra.iopen.form.Login;
import com.indra.iopen.form.Signup;
import com.indra.iopen.model.security.util.SecurityUtil;
import com.indra.iopen.service.UserService;
import com.indra.iopen.util.ErrorInfo;

@Controller
@RequestMapping("/user")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@Autowired
	private Validator validator;
	@Autowired
	Environment env;

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String applicationSignupForm(final Model model) {

		model.addAttribute(new Signup());
		return "signup";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String submitSignupForm(final Signup signup, final Model model, final Errors errors) {

		validator.validate(signup, errors);

		if (errors.hasErrors()) {
			model.addAttribute(signup);
			return "signup";
		}

		// save to db
		try {
			userService.sigup(signup);
		} catch (final DataIntegrityException e) {
			e.printStackTrace();
			System.out.println("ERROR: DATAINTEGRITY EXCEPTION");
			final ErrorInfo errorInfo = new ErrorInfo(e.getMessage(), HttpStatus.CONFLICT);
			model.addAttribute("errorInfo", errorInfo);
			return "signup";
		} catch (final Exception e) {
			e.printStackTrace();
			final ErrorInfo errorInfo = new ErrorInfo(env.getProperty("application.exception.message"),
					HttpStatus.INTERNAL_SERVER_ERROR);
			model.addAttribute("errorInfo", errorInfo);
			return "signup";
		}

		return "signup_success";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String applicationLoginForm(final WebRequest webRequest, @ModelAttribute("login") final Login login,
			final Errors errors) {

		final Object lastException = webRequest.getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION,
				WebRequest.SCOPE_SESSION);
		if (lastException != null) {
			if (lastException instanceof BadCredentialsException) {
				errors.rejectValue("lastError", "error.badCredentials");
			}
			if (lastException instanceof LockedException) {
				errors.rejectValue("lastError", "error.lockedaccount");
			}
			if (lastException instanceof DisabledException) {
				errors.rejectValue("lastError", "error.disabledaccount");
			}
		}
		return "login";
	}

	@RequestMapping(value = "/loggedin", method = RequestMethod.GET)
	public String successfullLoggedUser() {

		if (SecurityUtil.isEmployee()) {
			return "redirect:/employee/applications";
		} else {
			return "login";
		}
	}

	@RequestMapping(value = "/activation/{activationToken}", method = RequestMethod.GET)
	public String activeClientAccount(@PathVariable final String activationToken, final Model model) {

		userService.activateClient(activationToken);
		model.addAttribute(new Login());
		return "redirect:/user/login";
	}
}
