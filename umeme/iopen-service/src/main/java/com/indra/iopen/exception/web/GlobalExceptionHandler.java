package com.indra.iopen.exception.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;import java.util.Objects;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.indra.iopen.exception.DataIntegrityException;
import com.indra.iopen.exception.ObjectNotFound;

@ControllerAdvice
public class GlobalExceptionHandler {
	public static final String DEFAULT_ERROR_VIEW = "error";

	@Autowired
	Environment env;

	@ResponseStatus(value = HttpStatus.CONFLICT)
	@ExceptionHandler(value = DataIntegrityException.class)
	public ModelAndView dataIntegrityErrorHandler(final HttpServletRequest req, final DataIntegrityException e)
			throws Exception {
		e.printStackTrace();
		final ModelAndView mav = new ModelAndView();
		mav.addObject("errorMessage", e.getMessage());
		mav.addObject("url", req.getRequestURL());
		mav.setViewName(DEFAULT_ERROR_VIEW);
		return mav;
	}

	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public ModelAndView requestHandlingNoHandlerFound(final HttpServletRequest req, final NoHandlerFoundException ex) {

		ex.printStackTrace();
		final ModelAndView mav = new ModelAndView();
		mav.addObject("errorMessage", "That path does not exist");
		mav.addObject("url", req.getRequestURL());
		mav.setViewName(DEFAULT_ERROR_VIEW);
		return mav;
	}

	@ExceptionHandler(UsernameNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public ModelAndView userNameNotFoundFound(final HttpServletRequest req, final UsernameNotFoundException ex) {
		ex.printStackTrace();

		final ModelAndView mav = new ModelAndView();
		mav.addObject("errorMessage", ex.getMessage());
		mav.addObject("url", req.getRequestURL());
		mav.setViewName(DEFAULT_ERROR_VIEW);
		return mav;
	}

	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ExceptionHandler(value = ObjectNotFound.class)
	public ModelAndView objectNotFoundErrorHandler(final HttpServletRequest req, final ObjectNotFound e)
			throws Exception {
		e.printStackTrace();

		final ModelAndView mav = new ModelAndView();
		mav.addObject("errorMessage", e.getMessage());
		mav.addObject("url", req.getRequestURL());
		mav.setViewName(DEFAULT_ERROR_VIEW);
		return mav;
	}

	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Oops it seems something went wrong, please try again later:\n IF symptoms persist seek the Administrator's advice")
	@ExceptionHandler(value = Exception.class)
	public ModelAndView defaultErrorHandler(final HttpServletRequest req, final Exception e) throws Exception {
		e.printStackTrace();
		// If the exception is annotated with @ResponseStatus rethrow it and let
		// the framework handle it
		if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null) {
			throw e;
		}

		// Otherwise setup and send the user to a default error-view.
		final ModelAndView mav = new ModelAndView();
		mav.addObject("errorMessage", env.getProperty("application.exception.message"));
		mav.addObject("url", req.getRequestURL());
		mav.setViewName(DEFAULT_ERROR_VIEW);
		return mav;
	}
}
