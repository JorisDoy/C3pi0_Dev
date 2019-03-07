package com.indra.iopen.facade.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import com.indra.iopen.exception.DataIntegrityException;
import com.indra.iopen.facade.UtilityFacade;
import com.indra.iopen.util.annotation.Facade;
@Facade
public class UtilityFacadeImpl implements UtilityFacade {
	private static final Logger logger = LoggerFactory.getLogger(UtilityFacadeImpl.class);

	@Override
	public void validateRequest(BindingResult bindingResult) throws Exception {
		if (bindingResult.hasErrors()) {
			logger.error("POJO has errors");
			String errorMessage = "";
			for (final FieldError fieldError : bindingResult.getFieldErrors()) {
				errorMessage += fieldError.getDefaultMessage() + "\n";
			}
			logger.error(errorMessage);
			throw new DataIntegrityException(errorMessage);
		}
	}

}
