package com.indra.iopen.service;

public interface PasswordService {

		Boolean generateNewRequest(String userEmail);
		
		Boolean changePassword(String userEmail, String token, String newPassword);
}
