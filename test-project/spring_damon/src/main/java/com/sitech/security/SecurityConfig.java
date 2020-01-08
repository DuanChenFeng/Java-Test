package com.sitech.security;

/**
*@author 段道博
*@date 2019年12月30日下午3:51:27
*
*/

//@Configuration
/*public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	private Logger logger = LoggerFactory.getLogger(getClass()); 
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
				.antMatchers("/home").permitAll()	//允许任何人访问
				.antMatchers("/system/*").hasRole("ADMIN")	//指定权限为ADMIN才能访问
				.antMatchers("/employee/*").hasAnyRole("ADMIN", "USER")	//指定多个权限都能访问
				.anyRequest()		//任何其它请求
				.authenticated()	//都需要身份认证
				.and()
				.formLogin()		//使用表单认证方式
				.loginProcessingUrl("/security/login")
				.successHandler(myLoginSuccessHandler)
				.failureHandler(myLoginFailureHandler)
				.and()
				.csrf().disable();
	
	}
	
	*//**
     * 自定义认证策略
     *
     * @return
     *//*
    @Autowired
    public void configGlobal(AuthenticationManagerBuilder auth) throws Exception {
        String password = passwordEncoder().encode("123456");

        logger.info("加密后的密码:" + password);

        auth.inMemoryAuthentication().withUser("admin").password(password)
                .roles("ADMIN").and();

        auth.inMemoryAuthentication().withUser("user").password(password)
                .roles("USER").and();

    }

    @Autowired
    private AuthenticationSuccessHandler myLoginSuccessHandler; //认证成功结果处理器

    @Autowired
    private AuthenticationFailureHandler myLoginFailureHandler; //认证失败结果处理器

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
}*/

