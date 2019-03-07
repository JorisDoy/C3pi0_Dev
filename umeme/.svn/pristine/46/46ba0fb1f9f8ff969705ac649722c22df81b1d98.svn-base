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
 * Class to be runned in batch mode to auto cancel old pending new applications.
 * @author mbaez
 *
 */
@DisallowConcurrentExecution
public class AutoCancelOldPendingApplications extends QuartzJobBean {

    private static final Logger LOGGER = LoggerFactory.getLogger(AutoCancelOldPendingApplications.class);

    @Autowired
    private ApplicationBatchService applicationBatchService;

    private String maxDays;

    public final ApplicationBatchService getApplicationBatchService() {
        return applicationBatchService;
    }

    public final void setApplicationBatchService(final ApplicationBatchService applicationBatchService) {
        this.applicationBatchService = applicationBatchService;
    }

    public final String getMaxDays() {
        return maxDays;
    }

    public final void setMaxDays(final String maxDays) {
        this.maxDays = maxDays;
    }

    @Override
    protected final void executeInternal(final JobExecutionContext context) throws JobExecutionException {
        LOGGER.info("BEGIN: batch service AutoCancelOldPendingApplications ");

        try {
            final Integer maximumDays = Integer.valueOf(maxDays);
            applicationBatchService.autoCancelOldPendingApplications(maximumDays);
        } catch (final Exception e) {
            LOGGER.error(e.getMessage());
            throw new JobExecutionException(e.getLocalizedMessage());
        }

        LOGGER.info("END: batch service AutoCancelOldPendingApplications ");
    }

}
