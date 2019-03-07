package com.indra.iopen.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.indra.iopen.pojo.SchedulerBean;
import com.indra.iopen.service.BatchService;

@Controller
@RequestMapping("/employee/batch/")
public class BatchController {
	private static final Logger logger = LoggerFactory.getLogger(BatchController.class);

	@Autowired
	BatchService batchService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String getBatchList(final Model model) throws Exception {

		model.addAttribute("scheduler", batchService.getSchedulerBean());

		return "view_batch_list";
	}

	@RequestMapping(value = "/fire", method = RequestMethod.GET)
	public String runBatchJob(final Model model, @RequestParam("jobGroup") String jobGroup,
			@RequestParam("jobName") String jobName) throws Exception {
		SchedulerBean schedulerBean = batchService.getSchedulerBean();
		schedulerBean.fireNow(jobName, jobGroup);

		return "redirect:/employee/batch/list";
	}
}
