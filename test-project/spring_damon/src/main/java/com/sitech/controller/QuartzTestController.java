package com.sitech.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.annotation.Resource;

import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sitech.entity.CpuInfo;
import com.sitech.service.HomeService;

/**
*@author 段道博
*@date 2020年1月6日上午11:42:38
*
*/
@Controller
@RequestMapping("/system")
public class QuartzTestController {
	
	@Resource(name="jobDetail")
	private JobDetail jobDetail;
	
	@Resource(name="scheduler")
	private Scheduler scheduler;

	@Resource(name="jobTrigger")
	private CronTrigger cronTrigger;
	
	@Autowired
	private HomeService homeSerice;
	
	@GetMapping("/cpushow")
	public String quartz_test(Model model) throws SchedulerException, IOException, SQLException {
		
		CronTrigger cron = (CronTrigger) scheduler.getTrigger(cronTrigger.getKey());
		
		String current_cron = cron.getCronExpression();
		
		System.out.println("当前trigger使用的：" + current_cron);
		
		CpuInfo cpu_show = homeSerice.getCpuInfo();
		model.addAttribute("cpu_shows", cpu_show);

		/*CronScheduleBuilder cronSchedule = CronScheduleBuilder.cronSchedule("0/6 * * * * ?");
		
		cron.getTriggerBuilder()
			.withIdentity(cronTrigger.getKey())
			.withSchedule(cronSchedule).build();*/
		
		scheduler.rescheduleJob(cronTrigger.getKey(), cron);
		
		return "cpu_show";
	}
	
	
	@RequestMapping("/get_data")
	@ResponseBody
	public CpuInfo get_data() {
		
		CpuInfo cpu_show = homeSerice.getCpuInfo();
		System.out.println(cpu_show.getFree_cpu());
		
		return cpu_show;
	}
	
	
	
	
}
