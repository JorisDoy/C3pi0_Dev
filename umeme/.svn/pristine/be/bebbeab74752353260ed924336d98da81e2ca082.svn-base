package com.indra.iopen.service;

import java.io.FileNotFoundException;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.indra.iopen.form.ApplicationList;
import com.indra.iopen.form.ApplicationListFilter;
import com.indra.iopen.form.ApplicationPendingInvoiceInformation;
import com.indra.iopen.form.ApplicationStatusInformation;
import com.indra.iopen.form.IOpenFile;
import com.indra.iopen.form.Status;
import com.indra.iopen.model.ClienteProfile;
import com.indra.iopen.model.Codigo;
import com.indra.iopen.model.IopenApplication;

public interface ApplicationListService {

	// public List<ApplicationList> testApplicationList() throws Exception;

	public List<ApplicationList> allApplicationList(boolean complete) throws Exception;

	public void cancelApplication(Long id) throws Exception;

	public ApplicationList clientApplicationDetail(long codApplication, boolean complete);

	public List<ApplicationList> clientApplicationList(@NotNull ClienteProfile clienteProfile, boolean complete)
			throws Exception;

	public List<ApplicationList> clientApplicationListByStatus(@NotNull ClienteProfile clienteProfile,
			@NotNull String status, boolean complete);

	public List<ApplicationList> clientApplicationListUsername(String username, boolean complete) throws Exception;

	public List<ApplicationList> clientIncompleteApplicationList(ClienteProfile clienteProfile);

	public void deleteDoc(String appId, String docId) throws Exception;

	public ApplicationList edit(@NotNull ApplicationList applicationList) throws Exception;

	public ApplicationList editStatus(@NotNull ApplicationList applicationList) throws Exception;

	public List<ApplicationList> filterApplicationListByDistrict(@NotNull List<ApplicationList> applicationList,
			@NotNull Long district) throws Exception;

	public List<ApplicationList> filterApplicationListById(@NotNull List<ApplicationList> applicationList,
			@NotNull String idType, String idNumber) throws Exception;

	public List<ApplicationList> filterApplicationListByStatus(@NotNull List<ApplicationList> applicationList,
			@NotNull String status) throws Exception;

	public List<ApplicationList> filteredApplicationList(ApplicationListFilter applicationListFilter) throws Exception;

	public List<Status> findApplicationStatuses() throws Exception;

	public IOpenFile findIopenApplicationDocById(long codApplication, String tipDoc) throws FileNotFoundException;

	public ApplicationList prepareApplicationDetail(IopenApplication iopenApplication, boolean complete);

	public List<ApplicationList> prepareApplicationList(@NotNull List<IopenApplication> iopenApplications,
			boolean complete) throws Exception;

	public List<ApplicationList> searchApplicationByNumExp(String numExp) throws Exception;

	public List<Codigo> findRejectionMessages();

	public ApplicationStatusInformation prepareApplicationStatusInformation(IopenApplication iopenApplication,
			boolean complete);

	public ApplicationStatusInformation clientApplicationStatusInformation(long codApplication, boolean complete);

	public ApplicationPendingInvoiceInformation clientApplicationPendingInvoiceInformation(long codApplication,
			boolean complete);

	public ApplicationPendingInvoiceInformation prepareApplicationPendingInvoiceInformation(
			IopenApplication iopenApplication, boolean complete);

	List<ApplicationList> filterByCurrentStageApplicationNumberFilters(String currentStage, String applicationNumber);

	List<ApplicationList> searchApplicationByTrackingNumber(String trackingNumber) throws Exception;

	List<ApplicationList> searchApplicationByTrackingNumberOrApplicationNumber(String trackingNumber,
			String applicationNumber) throws Exception;

	List<ApplicationList> clientFilteredApplicationList(ApplicationListFilter S);

	/**
	 * SMA/UMESCI-732 returns the number of pages
	 *
	 * @param applicationListFilter
	 * @return
	 */
	Long countFilteredApplicationList(ApplicationListFilter applicationListFilter);

}
