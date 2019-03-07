package com.indra.iopen.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.indra.iopen.exception.DataIntegrityException;
import com.indra.iopen.form.ApplicationListFilter;
import com.indra.iopen.form.ConnectionScheduledApplication;
import com.indra.iopen.model.IopenApplication;
import com.indra.iopen.model.security.users.EmployeeUser;
import com.indra.iopen.repositories.model.IopenApplicationRepository;
import com.indra.iopen.service.CommonService;
import com.indra.iopen.service.ConnectionSchedulingService;
import com.indra.iopen.util.ApplicationAdvanceType;

@Service
public class ConnectionSchedulingServiceImpl implements ConnectionSchedulingService {
	@Autowired
	IopenApplicationRepository iopenApplicationRepository;
	@Autowired
	private CommonService commonService;

	@Autowired
	private Environment env;

	private IopenApplication iopenApplication = null;

	@Override
	public List<ConnectionScheduledApplication> findScheduledConnectionApplications(Boolean scheduled) {
		final List<ConnectionScheduledApplication> inspectionScheduledApplications = iopenApplicationRepository
				.findConnectionIopenApplicationsWhichPaymentHaveBeenRecieved(
						env.getProperty("application.stage.quotation.paid.value"),
						env.getProperty("application.stage.quotation.paid.value"), scheduled, null);
		return inspectionScheduledApplications;
	}

	@Override
	public List<ConnectionScheduledApplication> findScheduledConnectionApplicationsForClient(String clientUserName,
			Boolean scheduled) {
		final List<ConnectionScheduledApplication> inspectionScheduledApplications = iopenApplicationRepository
				.findConnectionIopenApplicationsWhichPaymentHaveBeenRecieved(
						env.getProperty("application.stage.quotation.paid.value"),
						env.getProperty("application.stage.quotation.paid.value"), scheduled, clientUserName);
		return inspectionScheduledApplications;
	}

	@Override
	public ConnectionScheduledApplication getScheduledConnectionApplication(Long codApplication) {
		return iopenApplicationRepository.findScheduledConectionApplicationForClient(
				env.getProperty("application.stage.quotation.paid.value"), codApplication);
	}

	@Override
	public void addConnectionScheduleToApplication(ConnectionScheduledApplication connectionScheduledApplication)
			throws Exception {
		iopenApplication = iopenApplicationRepository.findOne(connectionScheduledApplication.getCodApplication());
		if (iopenApplication == null) {
			throw new DataIntegrityException("the application does not exist");
		}
		iopenApplication.setConnectionScheduled(Boolean.TRUE);
		final SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		iopenApplication.setConnectionScheduledDate(
				formatter.parse(connectionScheduledApplication.getconnectionScheduledDate()));
		iopenApplication.setConnectionScheduledBy(
				((EmployeeUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal())
				.getEmployeeProfile().getNomUsr());
		// send message
		final List<IopenApplication> iopenApplications = new ArrayList<>();
		iopenApplications.add(iopenApplication);
		commonService.sendMessagesClientsToInformOfAdvanceInApplicationStatus(iopenApplications,
				ApplicationAdvanceType.CONNECTION_SCHEDULED);

		iopenApplicationRepository.save(iopenApplication);
	}

	@Override
	public List<ConnectionScheduledApplication> findUnScheduledConnectionApplications(
			ApplicationListFilter applicationFilter) {
		List<ConnectionScheduledApplication> connectionScheduledApplications = new ArrayList<>();
		if (applicationFilter.getApplicationNumber() != null && !applicationFilter.getApplicationNumber().isEmpty()) {
			return iopenApplicationRepository.findConnectionScheduleIopenApplicationByApplicationNumber(
					env.getProperty("application.stage.quotation.paid.value"),
					env.getProperty("application.stage.quotation.paid.value"), false,
					applicationFilter.getApplicationNumber());
		}
		if (applicationFilter.getTrackingNumber() != null && !applicationFilter.getTrackingNumber().isEmpty()) {
			return iopenApplicationRepository.findConnectionScheduleIopenApplicationByTrackingNumber(
					env.getProperty("application.stage.quotation.paid.value"),
					env.getProperty("application.stage.quotation.paid.value"), false,
					Long.valueOf(applicationFilter.getTrackingNumber()));
		}
		if (applicationFilter.getWorkType() != null && !applicationFilter.getWorkType().isEmpty()) {
			connectionScheduledApplications = iopenApplicationRepository
					.findConnectionScheduleIopenApplicationByPoleService(
							env.getProperty("application.stage.quotation.paid.value"),
							env.getProperty("application.stage.quotation.paid.value"), false,
							applicationFilter.getWorkType());
		}
		if (applicationFilter.getDistrict() != null && applicationFilter.getDistrict() > 0) {
			if (connectionScheduledApplications.isEmpty()) {
				connectionScheduledApplications = iopenApplicationRepository
						.findConnectionScheduleIopenApplicationByDistrict(
								env.getProperty("application.stage.quotation.paid.value"),
								env.getProperty("application.stage.quotation.paid.value"), false,
								applicationFilter.getDistrict());
			} else {
				return connectionScheduledApplications.stream()
						.filter(filter -> filter != null
						&& filter.getDistrict().equals(applicationFilter.getDistrict()))
						.collect(Collectors.toList());
			}
		}

		return connectionScheduledApplications;
	}

	@Override
	public List<ConnectionScheduledApplication> findScheduledConnectionApplications(Boolean scheduled,
			ApplicationListFilter applicationFilter) {
		applicationFilter.setEstado(env.getProperty("application.stage.quotation.paid.value"));
		applicationFilter.setEstAct(env.getProperty("application.stage.quotation.paid.value"));
		return iopenApplicationRepository.findConnectionScheduleIopenApplication(scheduled, applicationFilter);
	}

	@Override
	public Long countScheduledConnectionApplications(Boolean scheduled, ApplicationListFilter applicationFilter) {

		applicationFilter.setEstado(env.getProperty("application.stage.quotation.paid.value"));
		applicationFilter.setEstAct(env.getProperty("application.stage.quotation.paid.value"));
		return iopenApplicationRepository.getCountOfUnscheduledConnection(scheduled, applicationFilter);
	}

}
