<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+
    	request.getServerPort()+path;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>员工管理系统</title>
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
		          		<img src="<%=basePath %>/static/images/face/3.gif" class="layui-nav-img">
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
 			<div style="padding: 15px;">
				<!-- 新增按钮 -->
				<a href="index#" class="layui-btn layui-btn-normal" data-toggle="modal" 
					data-target="#newEmpDialog" onclick="clearEmployee()">新建</a>
				
				<br><br>
			
				<!-- 查询部分 -->
				<div class="layui-row">
					<div class="layui-col-md5">
						<form class="layui-form" method="get" action="<%=basePath %>/employee/index">
							<div class="layui-col-md8">
								<input type="text" id="name" value="${name}" name="name" 
								placeholder="请输入查询人姓名" class="layui-input"/>
							</div>
							<button type="submit" class="layui-btn layui-btn-normal">查询</button>
						</form>
					</div>
			 	</div>
		 	
			 	<!-- 查询结果表格显示 -->
				<table class="layui-table">
					<thead>
						<tr>
							<th>id</th>
							<th>name</th>
							<th>sex</th>
							<th>age</th>
							<th>birthday</th>
							<th>address</th>
							<th>department</th>
							<th>createtime</th>
							<th>operation</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${employees}" var="emp">
						  <tr>
							<td>${emp.id}</td>
							<td>${emp.name}</td>
							<td>${emp.sex}</td>
							<td>${emp.age}</td>
							<td>${emp.birthday}</td>
							<td>${emp.address}</td>
							<td>${emp.department}</td>
							<td>${emp.createtime}</td>
							<td>
								<a href="index#" class="layui-btn" 
									onclick="delEmployee(${emp.id})">删除</a>
								<a href="index#" class="layui-btn" 
									data-toggle="modal" 
									data-target="#editEmpDialog" onclick="selectById(${emp.id})">修改</a>
							</td>
						  </tr>
						</c:forEach>
					</tbody>
				</table>
			
			</div>
  	  	</div>
		<!-- 新建部分 -->
		<div class="modal fade" id="newEmpDialog" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">×</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">新建员工信息</h4>
					</div>
					<div class="modal-body">
						<form class="form-horizontal" id="new_employee_form">
							<div class="form-group">
								<label for="new_id" class="col-sm-2 control-label">员工id</label>
								<div class="col-sm-4">
									<input type="number" class="form-control" id="new_id" placeholder="员工id" name="id">
								</div>
								<label for="new_name" class="col-sm-2 control-label">员工姓名</label>
								<div class="col-sm-4">
									<input type="text" class="form-control" id="new_name" placeholder="员工姓名" name="name">
								</div>
							</div>
							<div class="form-group">
								<label for="new_sex" class="col-sm-2 control-label">性别</label>
								<div class="col-sm-4"> 
									<select class="form-control" id="new_sex" name="sex">
										<option value="man" selected="selected">---请选择---</option>
										<option value="man">man</option>
										<option value="woman">woman</option>
									</select>
								</div>
								<label for="new_age" class="col-sm-2 control-label">员工年龄</label>
								<div class="col-sm-4">
									<input type="number" class="form-control" id="new_age" placeholder="员工年龄" name="age">
								</div>
							</div>
							<div class="form-group">
								<label for="new_birthday" class="col-sm-2 control-label">员工出生年月</label>
								<div class="col-sm-4">
									<input type="datetime-local" class="form-control" id="new_birthday" placeholder="员工出生年月" name="birthday">
								</div>
								<label for="new_address" class="col-sm-2 control-label">员工住址</label>
								<div class="col-sm-4">
									<input type="text" class="form-control" id="new_address" placeholder="员工住址" name="address">
								</div>
							</div>
							<div class="form-group">
								<label for="new_department" class="col-sm-2 control-label">员工部门</label>
								<div class="col-sm-4">
									<input type="text" class="form-control" id="new_department" placeholder="员工部门" name="department">
								</div>
								<label for="new_department" class="col-sm-2 control-label">时间</label>
								<div class="col-sm-4">
									<input type="datetime-local" class="form-control" id="new_createtime" placeholder="创建时间" name="createtime">
								</div>
							</div>
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="layui-btn layui-btn-normal" data-dismiss="modal">关闭</button>
						<button type="button" class="layui-btn layui-btn-normal" onclick="createEmployee()">创建员工</button>
					</div>
				</div>
			</div>
		</div>
	
		<!-- 修改部分 -->
		<div class="modal fade" id="editEmpDialog" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">×</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">修改员工信息</h4>
					</div>
					<div class="modal-body">
						<form class="form-horizontal" id="edit_employee_form">
							<div class="form-group">
								<label for="edit_id" class="col-sm-2 control-label">员工id</label>
								<div class="col-sm-4">
									<input type="hidden" class="form-control" id="edit_id" name="id">
								</div>
								<label for="edit_name" class="col-sm-2 control-label">员工姓名</label>
								<div class="col-sm-4">
									<input type="text" class="form-control" id="edit_name" name="name">
								</div>
							</div>
							<div class="form-group">
								<label for="edit_sex" class="col-sm-2 control-label">性别</label>
								<div class="col-sm-4"> 
									<select class="form-control" id="edit_sex" name="sex">
										<option value="man" selected="selected">---请选择---</option>
										<option value="man">man</option>
										<option value="woman">woman</option>
									</select>
								</div>
								<label for="edit_age" class="col-sm-2 control-label">员工年龄</label>
								<div class="col-sm-4">
									<input type="number" class="form-control" id="edit_age" placeholder="员工年龄" name="age">
								</div>
							</div>
							<div class="form-group">
								<label for="edit_birthday" class="col-sm-2 control-label">员工出生年月</label>
								<div class="col-sm-4">
									<input type="datetime-local" class="form-control" id="edit_birthday" placeholder="员工出生年月" name="birthday">
								</div>
								<label for="edit_address" class="col-sm-2 control-label">员工住址</label>
								<div class="col-sm-4">
									<input type="text" class="form-control" id="edit_address" placeholder="员工住址" name="address">
								</div>
							</div>
							<div class="form-group">
								<label for="edit_department" class="col-sm-2 control-label">员工部门</label>
								<div class="col-sm-4">
									<input type="text" class="form-control" id="edit_department" placeholder="员工部门" name="department">
								</div>
								<label for="edit_createtime" class="col-sm-2 control-label">时间</label>
								<div class="col-sm-4">
									<input type="datetime-local" class="form-control" id="edit_createtime" placeholder="更新时间" name="createtime">
								</div>
							</div>
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="layui-btn layui-btn-normal" data-dismiss="modal">关闭</button>
						<button type="button" class="layui-btn layui-btn-normal" onclick="updEmployee()">更新信息</button>
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
	
			
		/* 清空新建员工窗口中的数据 */
		function clearEmployee() { 
			$("#new_id").val("");
			$("#new_name").val("");
			$("#new_age").val("");
			$("#new_birthday").val("");
			$("#new_address").val("");
			$("#new_department").val("");
		}
		
		/* 创建新员工  */
		function createEmployee() {
			$.post("create.action",
			$("#new_employee_form").serialize(),function(data){
				if(data == "OK"){
					alert("部门创建成功！");
					window.location.reload();
				}else{
					alert("部门创建失败！");
					window.location.reload();
				}
			});
		}
		
		/* 删除员工信息  */
		function delEmployee(id) {
			if(confirm('确实要删除该员工信息吗?')) {
				$.post("delete.action",{"id":id},
				function(data){
					if(data == "OK"){
						alert("员工信息删除成功！");
						window.location.reload();
					}else{
						alert("删除员工信息失败！");
						window.location.reload();
					}
				});
			}
		}
		
		/* 根据id获取需要修改的员工信息  */ 		  
		function selectById(id) {
		    $.ajax({
		        type:"get",
		        url:"getEmpById",
		        data:{"id":id},
		        success:function(data) {
		        	$("#edit_id").val(data.id);
		        	$("#edit_name").val(data.name);
		        	$("#edit_sex").val(data.sex);
		        	$("#edit_age").val(data.age);
		        	$("#edit_birthday").val(data.birthday);
		        	$("#edit_address").val(data.address);
		        	$("#edit_department").val(data.department);
		        	$("#edit_createtime").val(data.createtime);
		        }
		    });
		}
		
		/* 执行修改操作 */
		function updEmployee() {
			$.post("updateEmployee",
			 $("#edit_employee_form").serialize(),
			  function(data){
				if(data == "OK"){
					alert("员工信息更新成功！");
					window.location.reload();
				}else{
					alert("员工信息更新失败！");
					window.location.reload();
				}
			});
		}
		
		
	</script>
</body>
</html>