package com.indra.iopen.util;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.indra.iopen.util.annotation.Phone;

public class PhoneConstraintValidator implements ConstraintValidator<Phone, String> {

	@Override
	public void initialize(Phone phone) {
	}

	@Override
	public boolean isValid(String phoneField, ConstraintValidatorContext cxt) {
		if (phoneField == null) {
			return false;
		}
		return phoneField.matches("[+]?\\d{9,12}");
	}

}
