package com.sitech.controller;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sitech.entity.CpuInfo;
import com.sitech.entity.SystemInfo;
import com.sitech.entity.UnameInfo;
import com.sitech.service.HomeService;
import com.sitech.util.InsertData;
import com.sitech.util.SSH2Util;

/**
*@author 段道博
*@date 2019年12月10日下午8:03:29
*
*/

@Controller
public class HomeController {
	@Autowired
	private HomeService homeService;
	
	@RequestMapping("/home")
	public String home() {
		return "home";
	}
	
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/index/systeminfo")
	public String system_info(Model model) throws IOException, SQLException{
		SSH2Util.run_ssh();
		InsertData.insert_sys_data();
		InsertData.insert_cpu_data();
		
		SystemInfo systemInfos = homeService.getSysInfo();
		
		model.addAttribute("sys", systemInfos);
		
		return "system_info";
	}
	
	@RequestMapping("/index/cpuinfo")
	public String cpu_info(Model model) {
		CpuInfo cpuInfos = homeService.getCpuInfo();
		model.addAttribute("cpu", cpuInfos);
		return "cpu_info";		
	}
	
	@RequestMapping("/index/unameinfo")
	public String uname_info(Model model) {
		UnameInfo unameInfos = homeService.getUnameInfo();
		
		model.addAttribute("uname", unameInfos);
		
		return "uname_info";
	}
	
	
	

}
