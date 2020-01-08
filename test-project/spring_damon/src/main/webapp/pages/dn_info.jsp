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
		          		<img src="<%=basePath %>/static/images/face/1.gif" class="layui-nav-img">
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
 			<div style="padding: 15px;" >
				<h2>DataNode Infomation</h2>
				<!-- 查询结果表格显示 -->
				<table class="layui-table">
					<thead>
						<tr>
							<th>node ip</th>
							<th>host name</th>
							<th>node status</th>
							<th>node use info</th>
							<th>capacity user ratio</th>
							<th>current time</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${dnInfos}" var="dns">
						  <tr>
							<td>${dns.node_ip}</td>
							<td>${dns.host_name}</td>
							<td>${dns.node_status}</td>
							<td>
								<a href="dninfo#" data-toggle="modal" data-target="#dataNodeInfo" 
									onclick="getDnDataById(${dns.id})">节点使用详细信息</a>
							</td>
							<td>${dns.dfs_used_pro }</td>
							<td>${dns.contact_time}</td>
						  </tr>
						</c:forEach>
					</tbody>
				</table>
				
				<div class="layui-row">
    				<div class="layui-col-md6" 
    					style="width: 559px;height:400px;border:2px;border:1px solid #eee;">
    					
    					<h4 align="center" style="color:#9370DB;">nn02节点容量的使用率</h4>
						<div style="width: 555px;height:350px;" id="ratio2"></div>
    				</div>
					
					<div class="layui-col-md6" 
						style="width: 559px;height:400px;border:2px;border:1px solid #eee;">
						
						<h4 align="center" style="color:#9370DB;">dn01节点容量的使用率</h4>
						<div style="width: 555px;height:350px;" id="ratio3"></div>
					</div>
   				</div>
				
  			</div>
  		</div>
  			
 			<!-- 节点使用情况展示部分 -->
		<div class="modal fade" id="dataNodeInfo" tabindex="-1" role="dialog" 
					aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">×</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">节点使用详细信息</h4>
					</div>
					<div class="modal-body">
							<div id="main" style="width: 565px;height:400px;">
							</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="layui-btn layui-btn-normal" 
								data-dismiss="modal">关闭</button>
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
	<!-- echarts Core JavaScript -->
	<%-- <script src="<%=basePath %>/static/echarts.min.js"></script> --%>
	<script src="<%=basePath %>/static/echarts.min1.js"></script>
	
	<script type="text/javascript">
		/* 下拉框的js */
		layui.use('element', function(){
		  var element = layui.element;
		  
		});
		
		//显示节点使用详细信息
	 	var myChart = echarts.init(document.getElementById('main'));
		
		//获取数据
		function getDnDataById(id) {
		    $.ajax({
		        type: "get",
		        url: "<%=basePath %>/system/dnById",
		        data: {"id":id},
		        success:function(data) {
		        	var test_1 = data.node_capacity;
		        	$("#get_capacity").val(data.node_capacity);
		        	
		        	var test_2 = data.dfs_used/1024;
					$("#get_used").val(data.dfs_used);
		        	
					var test_3 = data.non_dfs;
					$("#get_non_dfs").val(data.non_dfs);
					
					var test_4 = data.dfs_remain;
					$("#get_remain").val(data.dfs_remain);
					
					var option = {
							backgroundColor: '#2c343c',
			                series : [
			                    {
			                        name: '访问来源',
			                        type: 'pie',
			                        radius: '55%',
			                        roseType: 'angle',
			                        data:[
			                            {value:test_1, name:'Node_Capacity'},
			                            {value:test_2, name:'DFS_Used'},
			                            {value:test_3, name:'Non_DFS'},
			                            {value:test_4, name:'DFS_Remain'}
		                            ]
			                    }
			                ]
			            };
					
			        // 使用刚指定的配置项和数据显示图表。
			        myChart.setOption(option);
			        
		        }
		    });
		}
		
		//显示节点容量使用率
		var myChart2 = echarts.init(document.getElementById("ratio2"));
		
		var option2 = {
			    tooltip: {
			        formatter: '{a} <br/>{b} : {c}%'
			    },
			    toolbox: {
			        feature: {
			            restore: {},
			            saveAsImage: {}
			        }
			    },
			    series: [
			        {
			            name: '节点nn02容量',
			            type: 'gauge',
			            detail: {formatter: '{value}%'},
			            data: [{value: 0.26, name: '使用率'}]
			        }
			    ]
			};

		myChart2.setOption(option2);
			
		//显示节点容量使用率
		var myChart3 = echarts.init(document.getElementById("ratio3"));
			
		var option3 = {
			    tooltip: {
			        formatter: '{a} <br/>{b} : {c}%'
			    },
			    toolbox: {
			        feature: {
			            restore: {},
			            saveAsImage: {}
			        }
			    },
			    series: [
			        {
			            name: '节点dn01容量',
			            type: 'gauge',
			            detail: {formatter: '{value}%'},
			            data: [{value: 0.26, name: '使用率'}]
			        }
			    ]
			};

	    myChart3.setOption(option3);

		
	</script>

</body>
</html>