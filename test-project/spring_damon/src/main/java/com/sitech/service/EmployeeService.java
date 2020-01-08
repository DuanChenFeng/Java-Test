package com.sitech.service;
import java.util.List;

import com.sitech.entity.Employee;
/**
*@author 段道博
*@date 2019年12月3日下午3:11:53
*
*/
public interface EmployeeService {	
	List<Employee> getAll();
	
	List<Employee> getEmployeeList(String name);
	
	public int addEmployee(Employee employee);
	
	public int delById(Integer id);
	
	Employee getEmployeeById(Integer id);
	
	public int updEmployee(Employee employee);	
	
}
