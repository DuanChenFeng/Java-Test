package com.sitech.service;

import com.sitech.entity.User;

/**
*@author 段道博
*@date 2019年12月28日下午3:09:25
*
*/
public interface LoginService {
	
//	User user_login(String name, String passwd);
	
	User user_login(User user);
	
	int sign_in(User user);
}
