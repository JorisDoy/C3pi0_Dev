package com.indra.iopen.repositories.model;

import org.springframework.data.repository.CrudRepository;

import com.indra.iopen.model.EmployeeProfile;

/**
 * The persistent interface for the EMPLOYEE_PROFILE database table.
 * 
 */
public interface EmployeeProfileRepository extends CrudRepository<EmployeeProfile, String>  {

	EmployeeProfile findEmployeeByUsername(String username);
	
}