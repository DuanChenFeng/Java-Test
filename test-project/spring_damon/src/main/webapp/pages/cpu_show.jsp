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
		        	<a href="javascript:;">
		          		<img src="<%=basePath %>/static/images/face/2.gif" class="layui-nav-img">
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
 			<div style="padding: 15px;">
 			
 				<div id="main" style="width: 559px;height:400px"></div>
				
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
	<!-- echarts Core JavaScript -->
	<script src="<%=basePath %>/static/echarts.min1.js"></script>
	
	<script type="text/javascript">
		/* 下拉框的js */
		layui.use('element', function(){
		  var element = layui.element;
		  
		});

		function CurentTime() {
	        var now = new Date();
	        var hh = now.getHours();            //时
	        var mm = now.getMinutes();          //分
	        var ss = now.getSeconds();           //秒
	        
	        var clock = hh + ":"
	        if (mm < 10) clock += '0'; 
	        clock += mm + ":"; 
	         
	        if (ss < 10) clock += '0'; 
	        clock += ss; 
	        return(clock); 
		}
		
		//初始化echarts实例
		var myChart = echarts.init(document.getElementById('main'));
		var date = [];	
		var free_values = [90];	//free_cpu  cpu空闲时间比
		var user_values = [5];	//user_cpu	cpu用户占用时间比
		var sys_values = [5];	//sys_cpu	系统占用时间比
		
		myChart.setOption({
			title:{
				text:'CPU信息'
			},
			tooltip:{},
			legend:{
				data:['CPU空闲时间比', '用户占用时间比', '系统占用时间比']
			},	
			xAxis:{
				data:date
			},
			yAxis:{
			},
			series:[{
				name:'CPU空闲时间比',
				type:'bar',
				data:free_values
			},
			{
				name:'用户占用时间比',	
				type:'bar',
				data:user_values
			},
			{
				name:'系统占用时间比',	
				type:'bar',
				data:sys_values
			}]
		});
		
		function ajax_get() {
			$.ajax({
				type:"get",
				async:true,
				url:"get_data",
				data:{},
				success:function(res) {
					date.push(CurentTime());
					free_values.push(res.free_cpu);
					user_values.push(res.user_cpu);
					sys_values.push(res.sys_cpu);
					
					myChart.setOption({
						xAxis:{
							data: date
						},
						yAxis:{
						},
						series:[{
							data: free_values,
							type: 'bar'
						},
						{
							data: user_values,
							type: 'bar'
						},
						{
							data: sys_values,
							type: 'bar'	
						}]
					});
				}
			});
		}
		
		setInterval(function(){
			ajax_get();
		}, 8000); 
	</script>

</body>
</html>