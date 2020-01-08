package com.sitech.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.sitech.entity.User;

/**
*@author 段道博
*@date 2019年12月24日下午7:44:40
*
*/
@Component
public class LoginInterceptor implements HandlerInterceptor{
	
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, Object handler)
			throws Exception {
		//获取请求的url
		String url = request.getRequestURI();		
		//URL：除了login.jsp是可以公开访问的，其它的URL都进行拦截控制
		if (url.indexOf("/login") >= 0) {
			return true;
		}		
		//获取session
		HttpSession session = request.getSession();		
		//注意key值要和Controller中的setAttribute中的key值
		User user = (User) session.getAttribute("USER_SESSION");			
		// 判断 Session 中是否有用户数据，如果有，则返回 true,继续向下执行
		if(user != null){
			//若用户是管理员角色，则返回true，所有页面都可以访问
			if (user.getIsadmin() == 1) {
				return true;
			} 			
			//若用户不是管理员角色，只能访问首页以及特定的页面
			if (user.getIsadmin() == 0) {				
				if (url.indexOf("/employee") >= 0 || url.indexOf("/index") >= 0) {
					return true;
				}else {
					request.getRequestDispatcher("/pages/index.jsp").forward(request, response);
					return false;
				}
			}
		}
		
		// 不符合条件的给出提示信息，并转发到登录页面
		request.setAttribute("msg", "您还没有登录，请先登录！");
		request.getRequestDispatcher("/pages/login.jsp").forward(request, response);
		
		return false;
	}
	
	public void postHandle(HttpServletRequest request, 
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
//		log.info("LoginInterceptor......postHandle");
	}
	
	public void afterCompletion(HttpServletRequest request, 
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
//		log.info("LoginInterceptor......afterCompletion");
	}

}
