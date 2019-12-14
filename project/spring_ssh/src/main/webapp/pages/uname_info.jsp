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
	<link rel="stylesheet" href="<%=basePath %>/css/layui.css"  media="all">
	<link rel="stylesheet" href="<%=basePath %>/css/bootstrap.min.css"  media="all">
</head>
<body class="layui-layout-body">

	<div class="layui-layout layui-layout-admin">
		<div class="layui-header">
	    	<div class="layui-logo">大数据监控数据展示</div>
	    
		    <!-- 头部左侧区域（可配合layui已有的水平导航） -->
		    <ul class="layui-nav layui-layout-left">
				<li class="layui-nav-item"><a href="">控制台</a></li>
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
		        	<a href="javascript:;">
		          		<img src="<%=basePath %>/images/face/9.gif" class="layui-nav-img">
		        		闭嘴
		        	</a>
		        	<dl class="layui-nav-child">
		          		<dd><a href="">基本资料</a></dd>
		          		<dd><a href="">安全设置</a></dd>
		        	</dl>
		     	</li>
		      	<li class="layui-nav-item"><a href="<%=basePath %>/home">跪下</a></li>
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
								<a href="<%=basePath%>/index/systeminfo">系统信息</a>
							</dd>
							<dd>
								<a href="<%=basePath%>/index/taskinfo">任务进程信息</a>
							</dd>
							<dd>
								<a href="<%=basePath%>/index/cpuinfo">cpu状态信息</a>
							</dd>
							<dd>
								<a href="<%=basePath%>/index/meminfo">内存状态信息</a>
							</dd>
							<dd>
								<a href="<%=basePath%>/index/swapinfo">交换分区状态信息</a>
							</dd>
							<dd>
								<a href="<%=basePath%>/index/diskinfo">磁盘空间占用情况信息</a>
							</dd>
						</dl>
					</li>

					<li class="layui-nav-item"><a href="javascript:;">静态命令信息</a>
						<dl class="layui-nav-child">
							<dd>
								<a href="<%=basePath%>/index/unameinfo">系统参数信息</a>
							</dd>
						</dl></li>

					<li class="layui-nav-item"><a href="">云市场</a></li>

					<li class="layui-nav-item"><a href="">可视化</a></li>
				</ul>
			</div>
		</div>

		<div class="layui-body">
	    	<!-- 内容主体区域 -->
 			<div style="padding: 15px;">
 				
 				<div class="layui-row">
	    			<div class="layui-col-md2">
	    				<p align="right" style="font: '微软雅黑'; font-size: x-large">
	    				系统名：&nbsp;&nbsp;&nbsp;
	    				</p>
	    			</div>
	    			<div class="layui-col-md5" >
	    				<input type="text" style="font: '微软雅黑'; font-size: x-large" 
	    					class="form-control" 
	    					value="${uname.sys_name}" readonly="true"/>
	    			</div>
	    		</div>
	    		
	    		<br/><br/>
	    		
	    		<div class="layui-row">
	    			<div class="layui-col-md2">
	    				<p align="right" style="font: '微软雅黑'; font-size: x-large">
	    				主机名：&nbsp;&nbsp;&nbsp;
	    				</p>
	    			</div>
	    			<div class="layui-col-md5" >
	    				<input type="text" style="font: '微软雅黑'; font-size: x-large" 
	    					class="form-control" 
	    					value="${uname.host_name}" readonly="true"/>
	    			</div>
	    		</div>
	    		
	    		<br/><br/>
	    		
	    		<div class="layui-row">
	    			<div class="layui-col-md2">
	    				<p align="right" style="font: '微软雅黑'; font-size: x-large">
	    				发行版本：&nbsp;&nbsp;&nbsp;
	    				</p>
	    			</div>
	    			<div class="layui-col-md5" >
	    				<input type="text" style="font: '微软雅黑'; font-size: x-large" 
	    					class="form-control" 
	    					value="${uname.sys_version}" readonly="true"/>
	    			</div>
	    		</div>
	    		
	    		<br/><br/>
	    		
	    		<div class="layui-row">
	    			<div class="layui-col-md2">
	    				<p align="right" style="font: '微软雅黑'; font-size: x-large">
	    				内核版本：&nbsp;&nbsp;&nbsp;
	    				</p>
	    			</div>
	    			<div class="layui-col-md5" >
	    				<input type="text" style="font: '微软雅黑'; font-size: x-large" 
	    					class="form-control" 
	    					value="${uname.kernel_version}" readonly="true"/>
	    			</div>
	    		</div>
	    		
	    		<br/><br/>
	    		
	    		<div class="layui-row">
	    			<div class="layui-col-md2">
	    				<p align="right" style="font: '微软雅黑'; font-size: x-large">
	    				处理器结构：&nbsp;&nbsp;&nbsp;
	    				</p>
	    			</div>
	    			<div class="layui-col-md5" >
	    				<input type="text" style="font: '微软雅黑'; font-size: x-large" 
	    					class="form-control" 
	    					value="${uname.processor_sys}" readonly="true"/>
	    			</div>
	    		</div>
	    		
	    		<br/><br/>
	    		
	    		<div class="layui-row">
	    			<div class="layui-col-md2">
	    				<p align="right" style="font: '微软雅黑'; font-size: x-large">
	    				机器硬件名：&nbsp;&nbsp;&nbsp;
	    				</p>
	    			</div>
	    			<div class="layui-col-md5" >
	    				<input type="text" style="font: '微软雅黑'; font-size: x-large" 
	    					class="form-control" 
	    					value="${uname.cpu_name}" readonly="true"/>
	    			</div>
	    		</div>
	    		
	    		<br/><br/>
	    		
	    		<div class="layui-row">
	    			<div class="layui-col-md2">
	    				<p align="right" style="font: '微软雅黑'; font-size: x-large">
	    				硬件平台：&nbsp;&nbsp;&nbsp;
	    				</p>
	    			</div>
	    			<div class="layui-col-md5" >
	    				<input type="text" style="font: '微软雅黑'; font-size: x-large" 
	    					class="form-control" 
	    					value="${uname.hard_platform}" readonly="true"/>
	    			</div>
	    		</div>
	    		
	    		<br/><br/>
	    		
	    		<div class="layui-row">
	    			<div class="layui-col-md2">
	    				<p align="right" style="font: '微软雅黑'; font-size: x-large">
	    				操作系统：&nbsp;&nbsp;&nbsp;
	    				</p>
	    			</div>
	    			<div class="layui-col-md5" >
	    				<input type="text" style="font: '微软雅黑'; font-size: x-large" 
	    					class="form-control" 
	    					value="${uname.operating_sys}" readonly="true"/>
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
	<script src="<%=basePath %>/jquery-1.11.3.min.js"></script>
	<!-- Bootstrap Core JavaScript -->
	<script src="<%=basePath %>/bootstrap.min.js"></script>
	<!-- layui Core JavaScript -->
	<script src="<%=basePath %>/layui.all.js"></script>
	
	<script type="text/javascript">
		/* 下拉框的js */
		layui.use('element', function(){
		  var element = layui.element;
		  
		});
	</script>

</body>
</html>