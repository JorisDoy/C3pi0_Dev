package com.indra.iopen.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import com.indra.iopen.batch.job.AutoCancelOldPendingApplications;
import com.indra.iopen.batch.job.GenerateQuotationJob;
import com.indra.iopen.batch.job.RemindToCompleteApplicationsJob;
import com.indra.iopen.batch.job.SendMessageWhenPaymentIsRecievedJob;
import com.indra.iopen.batch.job.SendMessageWhenConnectionPaymentHasBeenReceivedJob;
import com.indra.iopen.service.ApplicationBatchService;

@Configuration

public class JobConfig {

	@Autowired
	private Environment env;

	@Autowired
	private ApplicationBatchService applicationBatchService;

	@Autowired
	private CronTriggerFactoryBean[] triggerFactoryBeans;

	@Autowired
	private JobDetailFactoryBean[] jobDetailFactoryBeans;

	@Value("${cron.expression.cancel.old.applications}")
	private String cronCancelApplications;

	@Value("${cron.expression.send.reminder}")
	private String cronEmailReminder;

	@Bean(name = "autoCancelOldPendingApplications")
	public JobDetailFactoryBean autoCancelOldPendingApplications() {
		JobDetailFactoryBean factoryBean = new JobDetailFactoryBean();

		factoryBean.setJobClass(AutoCancelOldPendingApplications.class);
		factoryBean.setJobDataAsMap(new HashMap<String, Object>());
		factoryBean.getJobDataMap().put("applicationBatchService", applicationBatchService);
		factoryBean.getJobDataMap().put("maxDays", env.getProperty("max.days.delete.pending.application"));
		factoryBean.setDurability(true);

		return factoryBean;
	}

	@Bean
	@Autowired
	public CronTriggerFactoryBean cronTriggerCancelOldPendingApplicationsFactoryBean(
			@Qualifier("autoCancelOldPendingApplications") JobDetailFactoryBean jobDetail) {
		CronTriggerFactoryBean trigger = new CronTriggerFactoryBean();

		trigger.setJobDetail(jobDetail.getObject());
		trigger.setCronExpression(env.getProperty("cron.expression.cancel.old.applications"));

		return trigger;
	}

	// @Bean
	// @Autowired
	// public SimpleTriggerFactoryBean
	// simpleTriggerCancelOldPendingApplicationsFactoryBean(@Qualifier("autoCancelOldPendingApplications")
	// JobDetailFactoryBean jobDetail) {
	// SimpleTriggerFactoryBean trigger = new SimpleTriggerFactoryBean();
	//
	// trigger.setJobDetail(jobDetail.getObject());
	// trigger.setStartDelay(1000);
	// //runs every day
	// trigger.setRepeatInterval(86400000);
	//
	// return trigger;
	// }

	@Bean
	@Autowired
	public CronTriggerFactoryBean cronTriggerRemindToCompleteFactoryBean(
			@Qualifier("remindToCompleteApplicationsJob") JobDetailFactoryBean jobDetail) {
		CronTriggerFactoryBean trigger = new CronTriggerFactoryBean();

		trigger.setJobDetail(jobDetail.getObject());
		trigger.setCronExpression(env.getProperty("cron.expression.send.reminder"));

		return trigger;
	}

	@Bean(name = "remindToCompleteApplicationsJob")
	public JobDetailFactoryBean remindToCompleteApplicationsJob() {
		JobDetailFactoryBean factoryBean = new JobDetailFactoryBean();

		factoryBean.setJobClass(RemindToCompleteApplicationsJob.class);
		factoryBean.setJobDataAsMap(new HashMap<String, Object>());
		factoryBean.getJobDataMap().put("applicationBatchService", applicationBatchService);
		//SMA 20160315
		factoryBean.getJobDataMap().put("maxDays", env.getProperty("max.days.delete.pending.application"));
		factoryBean.setDurability(true);

		return factoryBean;
	}

	// @Bean
	// @Autowired
	// public SimpleTriggerFactoryBean
	// simpleTriggerRemindToCompleteFactoryBean(@Qualifier("remindToCompleteApplicationsJob")
	// JobDetailFactoryBean jobDetail) {
	// SimpleTriggerFactoryBean trigger = new SimpleTriggerFactoryBean();
	//
	// trigger.setJobDetail(jobDetail.getObject());
	// trigger.setStartDelay(10000);
	// //runs every hour
	// trigger.setRepeatInterval(3600000);
	//
	// return trigger;
	// }

	@Bean
	@Autowired
	public CronTriggerFactoryBean cronTriggerSendMessageWhenPaymentIsRecievedFactoryBean(
			@Qualifier("sendMessageWhenPaymentIsRecieved") JobDetailFactoryBean jobDetail) {
		CronTriggerFactoryBean trigger = new CronTriggerFactoryBean();

		trigger.setJobDetail(jobDetail.getObject());
		trigger.setCronExpression(env.getProperty("cron.expression.send.message"));

		return trigger;
	}

	@Bean(name = "sendMessageWhenPaymentIsRecieved")
	public JobDetailFactoryBean sendMessageWhenPaymentIsRecievedJob() {
		JobDetailFactoryBean factoryBean = new JobDetailFactoryBean();

		factoryBean.setJobClass(SendMessageWhenPaymentIsRecievedJob.class);
		factoryBean.setJobDataAsMap(new HashMap<String, Object>());
		factoryBean.getJobDataMap().put("applicationBatchService", applicationBatchService);
		factoryBean.setDurability(true);

		return factoryBean;
	}

	@Bean
	@Autowired
	public CronTriggerFactoryBean cronTriggerSendMessageWhenStatusIsConnectionPendingFactoryBean(
			@Qualifier("sendMessageWhenConnectionPaymentHasBeenReceived") JobDetailFactoryBean jobDetail) {
		CronTriggerFactoryBean trigger = new CronTriggerFactoryBean();

		trigger.setJobDetail(jobDetail.getObject());
		trigger.setCronExpression(env.getProperty("cron.expression.send.message"));

		return trigger;
	}

	@Bean(name = "sendMessageWhenConnectionPaymentHasBeenReceived")
	public JobDetailFactoryBean sendMessageWhenStatusIsConnectionPendingJob() {
		JobDetailFactoryBean factoryBean = new JobDetailFactoryBean();

		factoryBean.setJobClass(SendMessageWhenConnectionPaymentHasBeenReceivedJob.class);
		factoryBean.setJobDataAsMap(new HashMap<String, Object>());
		factoryBean.getJobDataMap().put("applicationBatchService", applicationBatchService);
		factoryBean.setDurability(true);

		return factoryBean;
	}

	@Bean
	@Autowired
	public CronTriggerFactoryBean cronTriggerGenerateQuotationFactoryBean(
			@Qualifier("generateQuotation") JobDetailFactoryBean jobDetail) {
		CronTriggerFactoryBean trigger = new CronTriggerFactoryBean();

		trigger.setJobDetail(jobDetail.getObject());
		trigger.setCronExpression(env.getProperty("cron.expression.generate.quotation"));

		return trigger;
	}

	@Bean(name = "generateQuotation")
	public JobDetailFactoryBean generateQuotationJob() {
		JobDetailFactoryBean factoryBean = new JobDetailFactoryBean();

		factoryBean.setJobClass(GenerateQuotationJob.class);
		factoryBean.setJobDataAsMap(new HashMap<String, Object>());
		factoryBean.getJobDataMap().put("applicationBatchService", applicationBatchService);
		factoryBean.setDurability(true);

		return factoryBean;
	}

	@Bean
	@Autowired
	public SchedulerFactoryBean schedulerFactoryBean() {
		SchedulerFactoryBean factoryBean = new SchedulerFactoryBean();

		List<JobDetail> jobDetails = new ArrayList<JobDetail>();

		for (JobDetailFactoryBean jobDetailFactoryBean : jobDetailFactoryBeans) {
			jobDetails.add(jobDetailFactoryBean.getObject());
		}
		factoryBean.setJobDetails(jobDetails.toArray(new JobDetail[jobDetails.size()]));

		List<Trigger> triggers = new ArrayList<Trigger>();
		for (CronTriggerFactoryBean triggerFactoryBean : triggerFactoryBeans) {
			triggers.add(triggerFactoryBean.getObject());
		}
		factoryBean.setTriggers(triggers.toArray(new Trigger[triggers.size()]));

		return factoryBean;
	}

}
