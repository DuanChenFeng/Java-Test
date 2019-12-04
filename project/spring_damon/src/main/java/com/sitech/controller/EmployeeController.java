package com.sitech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sitech.entity.Employee;
import com.sitech.service.EmployeeService;

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
	
	@RequestMapping("/employee/selectById/{id}")	//配置URL映射
	public Employee selectEmployee(@PathVariable Integer id) {
		return employeeService.getEmployeeById(id);
	}
	
	@RequestMapping("/employee/index")
	public List<Employee> selectAll() {
		return employeeService.getAll();
	}
	
	@RequestMapping("/employee/selectName/{name}")
	public List<Employee> selectByName(@PathVariable String name) {
		return employeeService.getEmployeeList(name);
	}
	
	@RequestMapping("/employee/insertEmployee")
	public String addEmployee(Employee employee) {
		int res = employeeService.addEmployee(employee);
		if (res == 1) {
			return "ok";
		}else {
			return "ERROR";			
		}
	}
	
	@RequestMapping("/employee/updateEmployee")
	public String updateEmployee(Employee employee) {
		int res = employeeService.updEmployee(employee);
		if (res == 1) {
			return "OK";
		}else {
			return "ERROR";
		}
	}
	
	@RequestMapping("/employee/deleteEmployee")
	public String deleteEmployee(int id) {
		int res = employeeService.delById(id);
		if (res == 1) {
			return "OK";
		}else {
			return "ERROR";
		}
	}
	
	@RequestMapping("/test")
	public String Demo() {
		return "hello world!";
	}
	
	@RequestMapping("/jsp")
	public String Demo2() {
		return "index";
	}
	
}
