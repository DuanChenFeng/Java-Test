package com.sitech.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sitech.entity.UnameInfo;
import com.sitech.entity.User;
import com.sitech.service.HomeService;
import com.sitech.service.LoginService;

/**
*@author 段道博
*@date 2019年12月28日下午3:14:52
*
*/
@Controller
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private HomeService homeService;
	
	@RequestMapping("/index")
	public String index(Model model) {
		
		UnameInfo unameInfo = homeService.getUnameInfo();
		
		model.addAttribute("uname", unameInfo);
		
		return "index";
	}
	
	
	@RequestMapping("/login")
	public String login(String name, String passwd, 
				Model model, HttpSession session) {
		
		User user = new User();
		user.setName(name);
		user.setPasswd(passwd);
		
		User user_login = loginService.user_login(user);
		
		if (user_login != null) {
			//将用户对象添加到Session
			session.setAttribute("USER_SESSION", user_login);
			return "redirect:employee/index";
		}else {
			model.addAttribute("msg", "账号或密码错误，请重新输入！");
			return "login";
		}
	}
	
	@RequestMapping("/sign_in")
	@ResponseBody
	public String sign(User user){
		int res = loginService.sign_in(user);
		
		if (res == 1) {
			return "OK";
		}else {
			return "ERROR";
		}
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		//清除session
		session.invalidate();
		
		//重定向到登录页面的跳转方法
		return "redirect:login";
	}
	
}
