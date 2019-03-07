package com.indra.iopen.service;

import java.util.List;

import com.indra.iopen.form.ApplicationListFilter;
import com.indra.iopen.form.ConnectionScheduledApplication;

public interface ConnectionSchedulingService {

	List<ConnectionScheduledApplication> findScheduledConnectionApplications(Boolean scheduled);

	List<ConnectionScheduledApplication> findScheduledConnectionApplicationsForClient(String clientUserName,
			Boolean scheduled);

	ConnectionScheduledApplication getScheduledConnectionApplication(Long codApplication);

	void addConnectionScheduleToApplication(ConnectionScheduledApplication connectionScheduledApplication)
			throws Exception;

	/**
	 * SMA/UMESCI-732 gets count of schedled/unscheduled applications
	 *
	 * @param scheduled
	 * @param applicationFilter
	 * @return
	 */
	Long countScheduledConnectionApplications(Boolean scheduled, ApplicationListFilter applicationFilter);

	/**
	 * find scheduled/unscheduled application
	 *
	 * @param scheduled
	 * @param applicationFilter
	 * @return
	 */
	List<ConnectionScheduledApplication> findScheduledConnectionApplications(Boolean scheduled,
			ApplicationListFilter applicationFilter);

	List<ConnectionScheduledApplication> findUnScheduledConnectionApplications(ApplicationListFilter applicationFilter);

}
