package com.dfc.mapper;
import org.apache.ibatis.annotations.Mapper;
import com.dfc.entity.Employee;
/**
*@author 段道博
*@date 2019年12月3日下午3:18:12
*
*/

@Mapper
public interface EmployeeMapper {
	Employee selectByPrimaryKey(Integer id);

}
