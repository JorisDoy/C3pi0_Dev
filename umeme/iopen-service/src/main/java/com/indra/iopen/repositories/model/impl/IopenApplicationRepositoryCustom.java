package com.indra.iopen.repositories.model.impl;

import java.math.BigDecimal;
import java.util.List;

import com.indra.iopen.form.ApplicationListFilter;
import com.indra.iopen.form.ConnectionScheduledApplication;
import com.indra.iopen.form.InspectionScheduledApplication;
import com.indra.iopen.model.IopenApplication;

public interface IopenApplicationRepositoryCustom {
	List<IopenApplication> findAllIopenApplications();

	List<IopenApplication> findByDistrictStatusFilters(Long district, String status, int batch, int page);

	List<IopenApplication> findByDistrictStatusFilters(Long district, String status, boolean complete, int batch,
			int page);

	List<IopenApplication> findByIdNumber(String idType, String idNumber);

	// SMA 20160219 UMESCI-446 start
	List<IopenApplication> findByStatus(String estStatus, String clientUsername, BigDecimal complete);
	// SMA 20160219 UMESCI-446 end

	List<IopenApplication> findClientIopenApplications(String clientUsername, boolean complete);

	List<IopenApplication> findIncompleteClientIopenApplications(String clientUsername);

	List<IopenApplication> findIopenApplicationsWhereMessageIsNotYetSent(String estado);

	/**
	 * SMA/UMESCI-732 used to filter unscheduled connection applications
	 *
	 * @param currentStage
	 * @param codCli
	 * @return
	 */
	List<ConnectionScheduledApplication> findConnectionScheduleIopenApplication(Boolean scheduled,
			ApplicationListFilter applicationListFilter);

	// List<InspectionScheduledApplication>
	// findScheduledIopenApplicationsWhichPaymentHaveBeenRecieved(
	// String reInspectionEstado, String estado, String estAct, Boolean
	// scheduled, String clientUserName);

	InspectionScheduledApplication findScheduledApplicationForClient(String reINspectionestAct, String estAct,
			Long codApplication);

	/**
	 * to be used for 'pagination'
	 *
	 * @param reInspectionEstAct
	 * @param estado
	 * @param estAct
	 * @return number of scheduled applications
	 */
	int countOnlyScheduledApplications(String reInspectionEstAct, String estado, String estAct);

	List<ConnectionScheduledApplication> findConnectionIopenApplicationsWhichPaymentHaveBeenRecieved(String estado,
			String estAct, Boolean scheduled, String clientUserName);

	ConnectionScheduledApplication findScheduledConectionApplicationForClient(String estAct, Long codApplication);

	List<IopenApplication> findByCurrentStageApplicationNumberFilters(String currentStage, String applicationNumber);

	List<IopenApplication> findByDistrictStatusUnicomFilters(Long district, String status, boolean complete,
			BigDecimal codUnicom, int batch, int page);

	List<IopenApplication> findIopenApplicationsWhereFeePaidButStatusNotChanged(String tipRec, String paidEstado,
			String applicationStage);

	List<InspectionScheduledApplication> findRejectedOnInspectionScheduleIopenApplication(String reInspectionEstAct,
			String estAct);

	List<InspectionScheduledApplication> findScheduledIopenApplicationsWhichPaymentHaveBeenRecieved(
			String reInspectionEstAct, String estado, String estAct, Boolean scheduled, String clientUserName,
			Boolean rejected);

	List<IopenApplication> clientFindByCurrentStageApplicationNumberFilters(String currentStage, BigDecimal codCli);

	/**
	 * SMA/UMESCI-732 used to count unscheduled connection applications
	 *
	 * @param applicationListFilter
	 * @param scheduled
	 * @return
	 */
	Long getCountOfUnscheduledConnection(Boolean scheduled, ApplicationListFilter applicationListFilter);

	/**
	 * SMA/UMESCI-732 get total number of pages
	 *
	 * @param district
	 * @param status
	 * @param complete
	 * @param codUnicom
	 * @return
	 */
	Long countDistrictStatusUnicomFilters(Long district, String status, boolean complete, BigDecimal codUnicom);

	/**
	 * SMA/UMESCI-732 get total number of pages
	 *
	 * @param district
	 * @param status
	 * @return
	 */
	Long countDistrictStatusFilters(Long district, String status);

	/**
	 * SMA/UMESCI-732 get total number of pages
	 *
	 * @param district
	 * @param status
	 * @param complete
	 * @return
	 */
	Long countDistrictStatusFilters(Long district, String status, boolean complete);

}
