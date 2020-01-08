package com.sitech.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sitech.entity.CpuInfo;
import com.sitech.entity.DnInfo;
import com.sitech.entity.SystemInfo;
import com.sitech.entity.UnameInfo;
import com.sitech.service.HomeService;

/**
*@author 段道博
*@date 2019年12月10日下午8:03:29
*
*/

@Controller
@RequestMapping("/system")
public class HomeController {
	
//	Logger log = LoggerFactory.getLogger(getClass());
	
	
	@Autowired
	private HomeService homeService;
	
	@RequestMapping("/systeminfo")
	public String system_info(Model model) throws IOException, SQLException{
//		SSH2Util.run_ssh();
		
		SystemInfo systemInfos = homeService.getSysInfo();
		
		model.addAttribute("sys", systemInfos);
		
		return "system_info";
	}
	
	@RequestMapping("/cpuinfo")
	public String cpu_info(Model model) {
		CpuInfo cpuInfos = homeService.getCpuInfo();
		model.addAttribute("cpu", cpuInfos);
		return "cpu_info";		
	}
	
	@RequestMapping("/unameinfo")
	public String uname_info(Model model) {
		UnameInfo unameInfos = homeService.getUnameInfo();
		
		model.addAttribute("uname", unameInfos);
		
		return "uname_info";
	}
	
	@RequestMapping("/dninfo")
	public String dn_info(Model model) {
		List<DnInfo> dnInfos = homeService.getDnInfo();
		
		model.addAttribute("dnInfos", dnInfos);
		return "dn_info";
	}
	
	@RequestMapping(value = "/dnById", method = RequestMethod.GET)
	@ResponseBody
	public DnInfo dn_data(Integer id) {
		DnInfo dnInfo = homeService.getInfoById(id);
		
		return dnInfo;
	}
	
	/*@RequestMapping("/cpushow")
	@ResponseBody
	public Map<String, Float> cpu_show(Model model) {
		
		Map<String, Float> map = new HashMap<String, Float>();
		
		CpuInfo cpuInfo = homeService.getCpuInfo();
		
		map.put("用户使用率", cpuInfo.getUser_cpu());
		
		return map;
	}*/
	
	
	
	
}
