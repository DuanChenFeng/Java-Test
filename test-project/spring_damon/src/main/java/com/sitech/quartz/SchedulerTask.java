package com.sitech.quartz;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import org.quartz.SchedulerException;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

import com.sitech.util.SSH2Util;

/**
*@author 段道博
*@date 2020年1月6日上午11:39:02
*
*/

@Configuration
@Component
@EnableScheduling
public class SchedulerTask {
	
	public void start() 
			throws SchedulerException, IOException, SQLException {
		System.out.println("定时器开始启动。。。" + new Date());
		
		SSH2Util.run_ssh();
		
	}
	
}