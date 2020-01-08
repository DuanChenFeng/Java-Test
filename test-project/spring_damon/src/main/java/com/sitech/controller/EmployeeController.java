package com.sitech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sitech.entity.Employee;
import com.sitech.service.EmployeeService;

/**
*@author 段道博
*@date 2019年12月3日下午2:11:24
*
*/

//@RestController的意思为controller中的方法都以json格式输出，不用在写jackjson配置

@Controller
public class EmployeeController {
	
//	Logger log = Logger.getRootLogger();
	
	@Autowired
	private EmployeeService employeeService;
	
	//查找整张表的员工信息
	/*
	@RequestMapping("/employee/index")
	public String selectAll(Model model) {
		List<Employee> employees = employeeService.getAll();
		model.addAttribute("employees", employees);
		return "index";
	}*/
	
	//员工姓名的模糊查询信息方法
	@RequestMapping("/employee/index")
	public String selectByName(String name, Model model) {
		List<Employee> employees = employeeService.getEmployeeList(name);
		model.addAttribute("employees", employees);
		return "employee";
	}
	
	//插入一条员工信息
	@RequestMapping(value = "/employee/create.action", method = RequestMethod.POST)
	@ResponseBody
	public String addEmployee(Employee employee) {
		int res = employeeService.addEmployee(employee);
		if (res == 1) {
			return "OK";
		}else {
			return "ERROR";			
		}
	}
	
	//根据id删除一条员工信息
	@RequestMapping(value = "/employee/delete.action", method = RequestMethod.POST)
	@ResponseBody
	public String deleteEmployee(Integer id) {
		int res = employeeService.delById(id);
		if (res == 1) {
			return "OK";
		}else {
			return "ERROR";
		}
	}
	
	//根据员工id查找员工信息
	@RequestMapping("/employee/getEmpById")	//配置URL映射
	@ResponseBody
	public Employee selectEmployee(Integer id) {
		System.out.println(id);
		return employeeService.getEmployeeById(id);
	}
	
	//更新指定id的员工信息
	@RequestMapping("/employee/updateEmployee")
	@ResponseBody
	public String updateEmployee(Employee employee) {
		int res = employeeService.updEmployee(employee);
		if (res == 1) {
			return "OK";
		}else {
			return "ERROR";
		}
	}
	
	//返回helloworld的测试方法
	@RequestMapping("/employee/test")
	public String Demo() {
		return "Hello World!";
	}
	
	
}
