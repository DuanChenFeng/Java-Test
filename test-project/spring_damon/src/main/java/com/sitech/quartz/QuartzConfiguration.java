package com.sitech.quartz;

import org.quartz.Trigger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

/**
*@author 段道博
*@date 2020年1月6日上午11:19:47
*
*/

@Configuration
public class QuartzConfiguration{

	@Bean(name="jobDetail")
	public MethodInvokingJobDetailFactoryBean detailFactoryBean(SchedulerTask task) {
		//ScheduledTask为需要执行的任务
		MethodInvokingJobDetailFactoryBean jobDetail = new MethodInvokingJobDetailFactoryBean();
		
		//是否并发执行任务
		jobDetail.setConcurrent(true);
		
		jobDetail.setName("scheduler");
		jobDetail.setGroup("scheduler_group");
		
		jobDetail.setTargetObject(task);
		
		jobDetail.setTargetMethod("start");
		
		return jobDetail;				
	}
	
	@Bean(name="jobTrigger")
	public CronTriggerFactoryBean cronTrigger(MethodInvokingJobDetailFactoryBean jobDetail) {
		
		CronTriggerFactoryBean tigger = new CronTriggerFactoryBean();
		tigger.setJobDetail(jobDetail.getObject());
		tigger.setCronExpression("0/6 * * * * ?");
		
		tigger.setName("myTigger");
		return tigger;		
	}
	
	@Bean(name="scheduler")
	public SchedulerFactoryBean schedulerFactory(Trigger cTrigger) {
		SchedulerFactoryBean bean = new SchedulerFactoryBean();
		//设置是否任意一个已定义的Job会覆盖现有的Job
		bean.setOverwriteExistingJobs(true);
		
		//设置延时启动，应用启动5秒后，定时器才开始启动
		bean.setStartupDelay(5);
		//注册定时触发器
		bean.setTriggers(cTrigger);
		return bean;
		
	}
	
}