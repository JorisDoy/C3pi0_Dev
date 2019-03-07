package com.indra.iopen.repositories.model;

import org.springframework.data.repository.CrudRepository;

import com.indra.iopen.model.ClienteProfile;
import com.indra.iopen.model.ClienteProfilePK;

/**
 * The persistent interface for the CLIENTE_PROFILE database table.
 * 
 */
public interface ClienteProfileRepository extends CrudRepository<ClienteProfile, String> {

//	public ClienteProfile findClienteProfileById(ClienteProfilePK clienteProfilePK);
	
	public ClienteProfile findClienteProfileByUsername(String username);
	
//	public ClienteProfile findClienteProfileByIdUsername(String username);
	
	public ClienteProfile findClienteProfileByActivationToken(String activationToken);
}