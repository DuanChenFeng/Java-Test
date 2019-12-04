package com.sitech.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sitech.entity.Employee;
import com.sitech.mapper.EmployeeMapper;
import com.sitech.service.EmployeeService;

/**
*@author 段道博
*@date 2019年12月3日下午3:12:35
*
*/
@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired	//自动注入
	private EmployeeMapper employeeMapper;
	
	@Override
	public Employee getEmployeeById(Integer id) {
		return employeeMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Employee> getEmployeeList(String name) {
		return employeeMapper.selectEmployeeList(name);
	}

	@Override
	public int addEmployee(Employee employee) {
		if (!employee.getSex().equals("man") || !employee.getSex().equals("woman")) {
			return 0;
		}
		if (employee.getAge() < 18 || employee.getAge() > 60) {
			return 0;
		}
		return employeeMapper.insertEmployee(employee);
	}

	@Override
	public int delById(int id) {
		return employeeMapper.deleteById(id);
	}

	@Override
	public int updEmployee(Employee employee) {
		if (!employee.getSex().equals("man") || !employee.getSex().equals("woman")) {
			return 0;
		}
		if (employee.getAge() < 18 || employee.getAge() > 60) {
			return 0;
		}
		return employeeMapper.updateEmployee(employee);
	}

	@Override
	public List<Employee> getAll() {
		return employeeMapper.selectAll();
	}

}
