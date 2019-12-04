package com.sitech.service;
import java.util.List;

import com.sitech.entity.Employee;
/**
*@author 段道博
*@date 2019年12月3日下午3:11:53
*
*/
public interface EmployeeService {
	Employee getEmployeeById(Integer id);
	
	List<Employee> getAll();
	
	List<Employee> getEmployeeList(String name);
	
	public int addEmployee(Employee employee);
	
	public int delById(int id);
	
	public int updEmployee(Employee employee);	
	
}
