package com.indra.iopen.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.matchers.GroupMatcher;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

public class SchedulerBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Scheduler scheduler = null;

	private List<QuartzJob> quartzJobList = new ArrayList<QuartzJob>();

	@SuppressWarnings("unchecked")
	public SchedulerBean(SchedulerFactoryBean quartzScheduler) throws SchedulerException {

		scheduler = quartzScheduler.getScheduler();

		// loop jobs by group
		for (String groupName : scheduler.getJobGroupNames()) {

			// get jobkey
			for (JobKey jobKey : scheduler.getJobKeys(GroupMatcher.jobGroupEquals(groupName))) {

				String jobName = jobKey.getName();
				String jobGroup = jobKey.getGroup();

				// get job's trigger
				List<Trigger> triggers = (List<Trigger>) scheduler.getTriggersOfJob(jobKey);
				Date nextFireTime = triggers.get(0).getNextFireTime();

				quartzJobList.add(new QuartzJob(jobName, jobGroup, nextFireTime));

			}

		}

	}

	// trigger a job
	public void fireNow(String jobName, String jobGroup) throws SchedulerException {

		JobKey jobKey = new JobKey(jobName, jobGroup);
		scheduler.triggerJob(jobKey);

	}

	public List<QuartzJob> getQuartzJobList() {

		return quartzJobList;

	}

	public static class QuartzJob {

		String jobName;
		String jobGroup;
		Date nextFireTime;

		public QuartzJob(String jobName, String jobGroup, Date nextFireTime) {

			this.jobName = jobName;
			this.jobGroup = jobGroup;
			this.nextFireTime = nextFireTime;
		}

		public String getJobName() {
			return jobName;
		}

		public void setJobName(String jobName) {
			this.jobName = jobName;
		}

		public String getJobGroup() {
			return jobGroup;
		}

		public void setJobGroup(String jobGroup) {
			this.jobGroup = jobGroup;
		}

		public Date getNextFireTime() {
			return nextFireTime;
		}

		public void setNextFireTime(Date nextFireTime) {
			this.nextFireTime = nextFireTime;
		}

	}

}
