package com.indra.iopen.service;

import java.util.List;

import com.indra.iopen.form.InspectionScheduledApplication;

public interface InspectionSchedulingService {

	void addInspectionScheduleToApplication(InspectionScheduledApplication inspectionScheduledApplication)
			throws Exception;

	List<InspectionScheduledApplication> findScheduledApplications(Boolean scheduled);

	List<InspectionScheduledApplication> findScheduledApplicationsForClient(String clientUserName, Boolean scheduled);

	InspectionScheduledApplication getScheduledApplication(Long codApplication);

	List<InspectionScheduledApplication> findRejectedApplications();
}
