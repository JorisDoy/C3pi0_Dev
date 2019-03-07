package com.indra.iopen.service.ims;

import java.util.List;

import org.springframework.stereotype.Service;

import com.indra.iopen.form.ims.ComplaintsForm;
import com.indra.iopen.model.ims.GiTTipAviso;
import com.indra.iopen.model.security.users.ClientUser;
import com.indra.iopen.pojo.ComplaintFilter;

@Service
public interface ComplaintsService {

	void registerComplaint(ComplaintsForm complaintsForm, long id) throws Exception;

	List<ComplaintsForm> getComplaints(ComplaintFilter complaintFilter, ClientUser clientUser) throws Exception;

	ComplaintsForm getComplaint(Long nroAviso, ClientUser clientUser) throws Exception;

	List<String> getContracts() throws Exception;

	List<ComplaintsForm> getComplaintByContractNumber(Long contractNumber, ClientUser clientUser) throws Exception;

	List<GiTTipAviso> getGiTTipAvisoByIndNormal() throws Exception;

	List<GiTTipAviso> getGiTTipAvisoByIndQuality() throws Exception;

	List<GiTTipAviso> getGiTTipAvisoByIndAssistance() throws Exception;

	void registerBillComplaint(ComplaintsForm complaintsForm);

	List<ComplaintsForm> getBillComplaints(ComplaintFilter complaintFilter);

	ComplaintsForm getBillComplaint(Long numRe, ClientUser clientUser) throws Exception;

	ComplaintFilter getComplaintFilter();
}
