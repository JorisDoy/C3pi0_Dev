package com.indra.iopen.batch.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.indra.iopen.service.ApplicationBatchService;

public class GenerateQuotationJob extends QuartzJobBean {
	private static final Logger logger = LoggerFactory.getLogger(GenerateQuotationJob.class);

	@Autowired
	private ApplicationBatchService applicationBatchService;

	public ApplicationBatchService getApplicationBatchService() {
		return applicationBatchService;
	}

	public void setApplicationBatchService(ApplicationBatchService applicationBatchService) {
		this.applicationBatchService = applicationBatchService;
	}

	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		logger.info("BEGIN: batch service GenerateQuotationJob ");

		try {
			applicationBatchService.generateQuotationJob();
		} catch (final Exception e) {
			logger.error(e.getMessage());
			throw new JobExecutionException(e.getLocalizedMessage());
		}

		logger.info("END: batch service GenerateQuotationJob ");

	}

}
