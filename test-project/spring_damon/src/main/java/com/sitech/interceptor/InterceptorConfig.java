package com.sitech.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
*@author 段道博
*@date 2019年12月28日下午4:49:36
*
*/
@Configuration
public class InterceptorConfig implements WebMvcConfigurer{

	@Autowired
	private LoginInterceptor loginInterceptor;
	
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(loginInterceptor)
				.excludePathPatterns("/sign_in")
				.excludePathPatterns("/logout")
				.excludePathPatterns("/home")
				.excludePathPatterns("/static/**");
	
	}
	
}
