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
 * Batch Job to send a message when payment is received.
 * @author mbaez
 *
 */
@DisallowConcurrentExecution
public class SendMessageWhenPaymentIsRecievedJob extends QuartzJobBean {
	private static final Logger LOGGER = LoggerFactory.getLogger(SendMessageWhenPaymentIsRecievedJob.class);

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
		LOGGER.info("BEGIN: batch service SendMessageWhenPaymentIsRecievedJob ");

		try {
			applicationBatchService.sendMessageWhenPaymentIsRecievedJob();
		} catch (final Exception e) {
			LOGGER.error(e.getMessage());
			throw new JobExecutionException(e.getLocalizedMessage());
		}

		LOGGER.info("END: batch service SendMessageWhenPaymentIsRecievedJob ");

	}

}
