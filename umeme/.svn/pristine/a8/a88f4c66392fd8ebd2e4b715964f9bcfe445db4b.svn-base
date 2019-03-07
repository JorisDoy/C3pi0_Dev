package com.indra.iopen.batch.job;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.indra.iopen.service.ApplicationBatchService;

/**
 * Batch Quartz Job to send reminder mail to users who have
 * new pending applications.
 * @author mbaez
 *
 */
@DisallowConcurrentExecution
public class RemindToCompleteApplicationsJob extends QuartzJobBean {

	private static final Logger LOGGER = LoggerFactory.getLogger(RemindToCompleteApplicationsJob.class);
	//SMA 20160315 start
	private String maxDays;

	public String getMaxDays() {
		return maxDays;
	}

	public void setMaxDays(String maxDays) {
		this.maxDays = maxDays;
	}
	//SMA 20160315 end
	@Autowired
	private ApplicationBatchService applicationBatchService;

	public final ApplicationBatchService getApplicationBatchService() {
		return applicationBatchService;
	}

	public final void setApplicationBatchService(final ApplicationBatchService applicationBatchService) {
		this.applicationBatchService = applicationBatchService;
	}

	@Override
	protected final void executeInternal(final JobExecutionContext context) throws JobExecutionException {
		LOGGER.info("BEGIN: batch service RemindToCompleteApplicationsJob ");

		try {
			final Integer maximumDays = Integer.valueOf(maxDays);
			applicationBatchService.remindImcompleteApplicationToClients(maximumDays);
		} catch (final Exception e) {
			LOGGER.error(e.getMessage());
			throw new JobExecutionException(e.getLocalizedMessage());
		}

		LOGGER.info("END: batch service RemindToCompleteApplicationsJob ");
	}

}
