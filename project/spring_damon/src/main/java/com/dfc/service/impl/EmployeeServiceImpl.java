package com.dfc.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dfc.entity.Employee;
import com.dfc.mapper.EmployeeMapper;
import com.dfc.service.EmployeeService;

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

}
