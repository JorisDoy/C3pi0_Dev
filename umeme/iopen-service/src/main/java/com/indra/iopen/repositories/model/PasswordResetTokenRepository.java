package com.indra.iopen.repositories.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.indra.iopen.model.PasswordResetToken;

public interface PasswordResetTokenRepository extends CrudRepository<PasswordResetToken, Long> {
	
	List<PasswordResetToken> findPasswordResetTokensByUsername(String username);
	PasswordResetToken findPasswordResetTokenByToken(String token);
	PasswordResetToken findPasswordResetTokenByTokenAndUsername(String token, String username);

}
