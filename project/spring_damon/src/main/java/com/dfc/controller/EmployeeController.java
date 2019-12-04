package com.dfc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dfc.entity.Employee;
import com.dfc.service.EmployeeService;

/**
*@author 段道博
*@date 2019年12月3日下午2:11:24
*
*/

//@RestController的意思为controller中的方法都以json格式输出，不用在写jackjson配置

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping("/select/{id}")	//配置URL映射
	public Employee selectEmployee(@PathVariable Integer id) {
		return employeeService.getEmployeeById(id);
	}
	
	
	@RequestMapping("/test")
	public String Demo() {
		return "hello world!";
	}

}
