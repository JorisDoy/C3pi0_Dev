package com.indra.iopen.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IOpenValidators {

	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	private static final String NUMBER_PATTERN = "[+]?\\d{9,12}";

	public static boolean isValidEmail(final String input) {
		final Pattern pattern = Pattern.compile(EMAIL_PATTERN);
		Matcher matcher;
		matcher = pattern.matcher(input);
		return matcher.matches();
	}

}
