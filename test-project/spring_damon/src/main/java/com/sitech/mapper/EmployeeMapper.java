package com.sitech.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sitech.entity.Employee;
/**
*@author 段道博
*@date 2019年12月3日下午3:18:12
*
*/

@Mapper
public interface EmployeeMapper {
	Employee selectByPrimaryKey(Integer id);
	
	//通过注解的方式实现对mysql数据库的增删改查
	
	@Select("select * from employee")
	List<Employee> selectAll();
	
	//通过name进行模糊查询
	@Select("select * from employee where name like '%${name}%'")
	List<Employee> selectEmployeeList(@Param("name") String name);
	
	//insert增加信息
	@Insert("insert into employee(id, name, sex, age, birthday, address, department, createtime) "
			+ " values(#{id}, #{name}, #{sex}, #{age}, #{birthday}, #{address}, "
			+ " #{department}, #{createtime})")
	public int insertEmployee(Employee employee);
	
	//通过id进行删除信息
	@Delete("delete from employee where id=${id}")
	public int deleteById(@Param("id") Integer id);
	
	//update更新信息
	@Update("update employee set "
			+ "name=#{name},sex=#{sex},age=#{age},"
			+ "birthday=#{birthday},address=#{address},"
			+ "department=#{department},createtime=#{createtime} where id=#{id} ")
	public int updateEmployee(Employee employee);

}
