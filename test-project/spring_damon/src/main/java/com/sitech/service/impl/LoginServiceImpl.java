package com.sitech.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sitech.entity.User;
import com.sitech.mapper.LoginMapper;
import com.sitech.service.LoginService;
import com.sitech.util.MD5Util;

/**
*@author 段道博
*@date 2019年12月28日下午3:10:11
*
*/

@Service
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	private LoginMapper loginMapper;

	public User user_login(User user) {
		String login_pwd = MD5Util.getMD5Value(user.getPasswd());
		
		user.setPasswd(login_pwd);
		
		return loginMapper.user_login(user);
	}

	public int sign_in(User user) {
		//将密码进行加密处理
		String login_pwd = MD5Util.getMD5Value(user.getPasswd());
		
		user.setPasswd(login_pwd);
		
		//验证数据库中是否已经存在该用户名
		List<User> check_name = loginMapper.check_name(user.getName());
		
		if (check_name.size() > 0) {
			return 0;
		}else {
			return loginMapper.sign_in(user);
		}
		
	}

}
