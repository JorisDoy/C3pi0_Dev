package com.indra.iopen.web;

import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.indra.iopen.form.PasswordResetConfirm;
import com.indra.iopen.form.PasswordResetRequest;
import com.indra.iopen.service.PasswordService;

@Controller
@RequestMapping(value="/password")
public class PasswordController {

	private static final Logger logger = LoggerFactory.getLogger(PasswordController.class);
	
	@Autowired
	private PasswordService passwordService;
	
	@RequestMapping(value = "/reset/request", method = RequestMethod.GET)
	public String showPasswordResetRequestForm(Model model) {
		model.addAttribute(new PasswordResetRequest());
		return "password_reset_request";
	}
	
	@RequestMapping(value = "/reset/request", method = RequestMethod.POST)
	public String proccessPasswordResetRequestForm(@Valid PasswordResetRequest resetRequest, Model model, Errors errors) {
		
		if (!StringUtils.equals(resetRequest.getEmail(), resetRequest.getRepeatEmail())) {
			errors.rejectValue("repeatEmail", "email.not.match");
		} else if (!passwordService.generateNewRequest(resetRequest.getEmail())) {
			errors.rejectValue("email", "email.invalid");
		}
		if (errors.hasErrors()) {
			return "password_reset_request";
		}		

		return "password_reset_request_confirmation";
	}
	
	
	@RequestMapping(value = "/reset/change", method = RequestMethod.GET)
	public String showPasswordResetChangeForm(
			@RequestParam(name="user") String user,
			@RequestParam(name="tokenvalue") String token,
			Model model) {
		PasswordResetConfirm passwordResetConfirm = new PasswordResetConfirm();
		passwordResetConfirm.setUsername(user);
		passwordResetConfirm.setToken(token);
		model.addAttribute(passwordResetConfirm);

		return "password_reset_change_request";
	}
	
	@RequestMapping(value = "/reset/change", method = RequestMethod.POST)
	public String proccessPasswordResetChangeForm(@Valid PasswordResetConfirm resetConfirm, Model model, Errors errors) {
		
		if (!StringUtils.equals(resetConfirm.getPassword(), resetConfirm.getRepeatPassword())) {
			errors.rejectValue("repeatPassword", "password.not.match");
		} else if (!passwordService.changePassword(
				resetConfirm.getUsername(), 
				resetConfirm.getToken(), 
				resetConfirm.getPassword())) {
			errors.rejectValue("username", "change.password.global.error");
		}
		
		if (errors.hasErrors()) {
			return "password_reset_change_request";
		}

		return "password_reset_change_request_confirmation";
	}
}
