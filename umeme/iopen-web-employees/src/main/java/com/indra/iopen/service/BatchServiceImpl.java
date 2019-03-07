package com.indra.iopen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Service;

import com.indra.iopen.pojo.SchedulerBean;

@Service
public class BatchServiceImpl implements BatchService {

	@Autowired
	private SchedulerFactoryBean quartzScheduler;

	@Override
	public SchedulerBean getSchedulerBean() throws Exception {
		return new SchedulerBean(quartzScheduler);
	}

}
