package com.sitech.security;

/**
*@author 段道博
*@date 2019年12月31日下午3:12:10
*
*/
/*@Component("MyLoginSuccessHandler")
public class MyLoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler{
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		logger.info("登录成功");

        PrintWriter out = response.getWriter();
        out.write(objectMapper.writeValueAsString("登录成功"));
        out.flush();
        out.close();
	
	}
	
	
	
}*/
