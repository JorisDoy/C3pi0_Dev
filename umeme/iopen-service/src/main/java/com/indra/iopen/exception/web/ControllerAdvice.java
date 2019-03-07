package com.indra.iopen.exception.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.hateoas.VndErrors;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.indra.iopen.exception.DataIntegrityException;
import com.indra.iopen.exception.ExpectationFailedException;
import com.indra.iopen.exception.ObjectNotFound;
import com.indra.iopen.exception.PreconditionFailedException;

@RestControllerAdvice
public class ControllerAdvice {
	@Value("${application.exception.message}")
	private String genericErrorMessage;

	@ResponseBody
	@ExceptionHandler(DataIntegrityException.class)
	@ResponseStatus(HttpStatus.CONFLICT)
	VndErrors exceptionHandler(DataIntegrityException ex) {
		return new VndErrors("error", ex.getMessage());
	}

	@ResponseBody
	@ExceptionHandler(ObjectNotFound.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	VndErrors objectNotFoundExceptionHandler(ObjectNotFound ex) {
		return new VndErrors("error", ex.getMessage());
	}

	@ResponseBody
	@ExceptionHandler(UsernameNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	VndErrors exceptionHandler(UsernameNotFoundException ex) {
		return new VndErrors("error", ex.getMessage());
	}

	@ResponseBody
	@ExceptionHandler(PreconditionFailedException.class)
	@ResponseStatus(HttpStatus.PRECONDITION_FAILED)
	VndErrors exceptionHandler(PreconditionFailedException ex) {
		// for debugging purposes
		ex.printStackTrace();
		return new VndErrors("error",
				ex.getMessage() == null || ex.getMessage().isEmpty() ? genericErrorMessage : ex.getMessage());
	}

	@ResponseBody
	@ExceptionHandler(ExpectationFailedException.class)
	@ResponseStatus(HttpStatus.EXPECTATION_FAILED)
	VndErrors exceptionHandler(ExpectationFailedException ex) {
		// for debugging purposes
		ex.printStackTrace();
		return new VndErrors("error",
				ex.getMessage() == null || ex.getMessage().isEmpty() ? genericErrorMessage : ex.getMessage());
	}

	@ResponseBody
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	VndErrors exceptionHandler(Exception ex) {
		// for debugging purposes
		ex.printStackTrace();
		return new VndErrors("error", genericErrorMessage);
	}
}
