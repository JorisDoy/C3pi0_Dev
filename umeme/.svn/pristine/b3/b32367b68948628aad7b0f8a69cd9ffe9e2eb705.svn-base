package com.indra.iopen.model.security.util;

import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@Primary
public class IOpenPasswordEnconder implements PasswordEncoder {

//	private PasswordEncoder passwordEncoder = new StandardPasswordEncoder("SALT");

	 private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	@Override
	public String encode(CharSequence arg0) {
		return passwordEncoder.encode(arg0);
	}

	@Override
	public boolean matches(CharSequence arg0, String arg1) {
		if (arg1.isEmpty()) {
			return false;
		}
		return passwordEncoder.matches(arg0, arg1);
	}

}
