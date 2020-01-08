package com.sitech.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.sitech.entity.User;

/**
*@author 段道博
*@date 2019年12月28日下午3:04:32
*
*/
@Mapper
public interface LoginMapper {
	
	/*@Select("select * from user "
			+ " where name='${name}' and passwd='${passwd}'")
	User user_login(@Param("name")String name, @Param("passwd")String passwd);
	*/
	
	@Select("select * from user "
			+ " where name=#{name} and passwd=#{passwd}")
	User user_login(User user);
	
	//验证是否存在用户重名
	@Select("select * from user "
			+ " where name=#{name} ")
	List<User> check_name(String name);
	
	
	//注册用户
	@Insert("insert into user(name,passwd) values(#{name}, #{passwd})")
	int sign_in(User user);
	
	//权限验证
	@Select("select isadmin from user where name=#{name}")
	List<Integer> user_role(String name);
	
}
