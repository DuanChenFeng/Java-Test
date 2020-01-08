<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+
    	request.getServerPort()+path;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Home</title>
	<link rel="stylesheet" href="<%=basePath %>/css/layui.css"  media="all">
	<link rel="stylesheet" href="<%=basePath %>/css/bootstrap.min.css"  media="all">
</head>
<body background="<%=basePath %>/static/images/bg1.jpg" style="background-size:cover;">



</body>
</html>