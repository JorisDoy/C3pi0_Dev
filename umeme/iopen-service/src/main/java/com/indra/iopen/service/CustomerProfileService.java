package com.indra.iopen.service;

import com.indra.iopen.form.CustomerProfile;
import com.indra.iopen.model.security.users.ClientUser;

public interface CustomerProfileService {

	CustomerProfile getCustomerProfile(ClientUser clientUser) throws Exception;

	void editCustomerProfile(ClientUser clientUser,CustomerProfile customerProfile) throws Exception;
}
