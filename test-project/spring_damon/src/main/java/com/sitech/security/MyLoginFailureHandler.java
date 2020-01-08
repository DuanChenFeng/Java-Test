package com.sitech.security;

/**
*@author 段道博
*@date 2019年12月31日下午3:09:19
*
*/

//@Component("MyLoginFailureHandler")
/*public class MyLoginFailureHandler extends SimpleUrlAuthenticationFailureHandler{
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		
		response.setContentType("application/json;charset=UTF-8");

        logger.info("登录失败");
        PrintWriter out = response.getWriter();
        out.write(objectMapper.writeValueAsString("登录失败"));
        out.flush();
        out.close();
	
	}
	
	
}*/
