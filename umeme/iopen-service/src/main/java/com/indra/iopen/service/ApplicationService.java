package com.indra.iopen.service;

import java.util.HashMap;
import java.util.List;

import com.indra.iopen.form.Application;
import com.indra.iopen.model.DistrictDepto;
import com.indra.iopen.model.IopenApplication;
import com.indra.iopen.model.security.users.ClientUser;

public interface ApplicationService {

	public List<DistrictDepto> findAllDistricts();

	public Application getApplicationForLoggedInUser(ClientUser clientUser) throws Exception;

	public HashMap<?, ?> retrieveDefaultValues();

	public IopenApplication saveApplcationWhenLoggedIn(Application application, ClientUser clientUser) throws Exception;

	public IopenApplication saveUnregisteredApplication(Application application) throws Exception;

	// public IopenApplication submitUnregisteredApplication(Application
	// application) throws Exception;

	public Application getIncompleteApplication(Long codApplication) throws Exception;

	public IopenApplication findIopenApplicationByCodApplication(Long codApplication);

	public HashMap<String, String> retrieveDefaultKeys();

	void discardIncompleteApplication(Application application) throws Exception;

	IopenApplication employeeApproveApplication(Application application, IopenApplication iopenApplication)
			throws Exception;

	Application mapIopenapplicationToApplication(IopenApplication iopenApplication);

	IopenApplication submitApplication(Application application, Boolean complete) throws Exception;

	// SMA 20160407
	IopenApplication submitApplicationTaC(Application application, Boolean complete) throws Exception;

	// SMA/UMESCI-713
	/**
	 * This method is used to prepare an IopenApplication for an already
	 * existing connection
	 *
	 * @param numExp
	 * @return
	 * @throws Exception
	 */
	IopenApplication prepareIopenApplication(String numExp) throws Exception;

}
