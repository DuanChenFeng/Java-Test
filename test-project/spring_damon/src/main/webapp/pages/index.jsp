<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+
    	request.getServerPort()+path;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>系统信息</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>首页</title>
	<link rel="stylesheet" href="<%=basePath %>/static/css/layui.css"  media="all">
	<link rel="stylesheet" href="<%=basePath %>/static/css/bootstrap.min.css"  media="all">
</head>
<body class="layui-layout-body">

	<div class="layui-layout layui-layout-admin">
		<div class="layui-header">
	    	<div class="layui-logo">
	    		<img src="<%=basePath %>/static/images/logo.png">
	    	</div>
	    
		    <!-- 头部左侧区域（可配合layui已有的水平导航） -->
		    <ul class="layui-nav layui-layout-left">
				<li class="layui-nav-item"><a href="<%=basePath %>/index">首页</a></li>
				<li class="layui-nav-item"><a href="">用户</a></li>
				<li class="layui-nav-item">
					<a href="javascript:;">其它系统</a>
					<dl class="layui-nav-child">
				    	<dd><a href="<%=basePath %>/employee/index">员工管理</a></dd>
					</dl>
				</li>
		    </ul>
		    
		    <!-- 头部右侧区域 -->
		    <ul class="layui-nav layui-layout-right">
		      	<li class="layui-nav-item">
		        	<a href="javascript:;" value="${login_user.name }">
		          		<img src="<%=basePath %>/static/images/face/10.gif" class="layui-nav-img">
		          		${USER_SESSION.name}
		        	</a>
		        	<dl class="layui-nav-child">
		          		<dd><a href="">基本资料</a></dd>
		          		<dd><a href="">安全设置</a></dd>
		        	</dl>
		     	</li>
		      	<li class="layui-nav-item"><a href="<%=basePath %>/logout">注销</a></li>
			</ul>
		</div>

		<div class="layui-side layui-bg-black">
			<div class="layui-side-scroll">
				<!-- 左侧导航区域（可配合layui已有的垂直导航） -->
				<ul class="layui-nav layui-nav-tree" lay-filter="test">
					<li class="layui-nav-item layui-nav-itemed"><a class=""
						href="javascript:;">动态命令信息</a>
						<dl class="layui-nav-child">
							<dd>
								<a href="<%=basePath%>/system/systeminfo">系统信息</a>
							</dd>
							<dd>
								<a href="<%=basePath%>/system/cpushow">cpu使用信息</a>
							</dd>
							<dd>
								<a href="<%=basePath%>/system/cpuinfo">cpu状态信息</a>
							</dd>
							<dd>
								<a href="<%=basePath%>/system/dninfo">数据节点状态信息</a>
							</dd>
							<%-- <dd>
								<a href="<%=basePath%>/system/meminfo">内存状态信息</a>
							</dd>
							<dd>
								<a href="<%=basePath%>/system/swapinfo">交换分区状态信息</a>
							</dd>
							<dd>
								<a href="<%=basePath%>/system/diskinfo">磁盘空间占用情况信息</a>
							</dd> --%>
						</dl>
					</li>

					<li class="layui-nav-item"><a href="javascript:;">静态命令信息</a>
						<dl class="layui-nav-child">
							<dd>
								<a href="<%=basePath%>/system/unameinfo">系统参数信息</a>
							</dd>
						</dl>
					</li>

					<li class="layui-nav-item"><a href="">云市场</a></li>

					<li class="layui-nav-item"><a href="">可视化</a></li>
				</ul>
			</div>
		</div>

		<div class="layui-body">
	    	<!-- 内容主体区域 -->
 			<div background="<%=basePath %>/static/images/2.jpg"
				style="background-size:cover;padding: 15px;">
    				
    				<div class="layui-row">
    					
    					<div class="layui-col-md6" style="border:1px solid white;">
	    					<h3>系统首页</h3>
	    					<h4>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	    						用户${USER_SESSION.name}，您好！</h4>
	    					<h4>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	    						本系统的作用是，采集Linux主机上的系统指标信息，将数据存入数据中然后在前端进行展示！</h4>
	    				</div>
						
						<div class="layui-col-md6" style="border:1px solid white;">
							<h4>DataNode Info</h4>
						</div>
						
    				</div>
    				
  			</div>
  		</div>
  		
	  	<!-- 底部固定区域 -->
	  	<div class="layui-footer">
	    	© Welcome to my world！
	  	</div>
	</div>

	<!-- jQuery -->
	<script src="<%=basePath %>/static/jquery-1.11.3.min.js"></script>
	<!-- Bootstrap Core JavaScript -->
	<script src="<%=basePath %>/static/bootstrap.min.js"></script>
	<!-- layui Core JavaScript -->
	<script src="<%=basePath %>/static/layui.all.js"></script>
	
	<script type="text/javascript">
		/* 下拉框的js */
		layui.use('element', function(){
		  var element = layui.element;
		  
		});
	</script>

</body>
</html>