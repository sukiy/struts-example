<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	if("${stuList}"==""){
		location.href="stuAction_findStuList";
	}
</script>
</head>
<body>
	<h2>学生管理系统</h2>
	<h3>当前登录人:${loginUser.uname}</h3>
	<s:if test="message==1">
		<div style="color:green">操作成功！</div>
	</s:if>
	<s:elseif test="message==2">
		<div style="color:red">操作失败！</div>
	</s:elseif>
	<s:form action="stuAction_findStuListByName" method="post">
	学生姓名:<s:textfield name="stu.sname"/>
	<s:submit value="查询"/>&nbsp;|&nbsp;
	<input type="button" value="添加新学生" onclick="javascript:location.href='stuAction_toAddStu';">
	<input type="button" value="修改" onclick="updateStu()">
	<input type="button" value="删除" onclick="deleteStu()">
	</s:form>
	<table border="1" width="700">
	<tr>
	<td><a href="javascript:selectAll()">全选/反选</a></td>
	<td>编号</td><td>班级</td><td>专业</td>
	<td>学生姓名</td><td>图像</td>
	<td>性别</td><td>爱好</td>
	<td>入学时间</td>
	</tr>
	<s:iterator value="#request.stuList" var="sts" status="ids">
	<tr>
	<td><input type="checkbox" name="id" value="${sts[0]}"></td>
	<td>${ids.count }</td><td>${sts[7]}</td><td>${sts[8]}</td>
	<td>${sts[1]}</td><td><img src="${sts[5]}" width="60" height="60"></td>
	<td>${sts[2]}</td><td>${sts[3]}</td>
	<td>${sts[4].substring(0,10)}</td>
	</tr>
	</s:iterator>
	</table>
</body>
</html>
<script type="text/javascript">
	function selectAll(){
		if($(":checkbox:checked").length>0){
			$(":checkbox").prop("checked",false);
		}else{
			$(":checkbox").prop("checked",true);
		}
	}
	
	function updateStu(){
		var ids=$(":checkbox:checked");
		if(ids.length==0){
			alert("请选择要修改的学生");
		}else if(ids.length>1){
			alert("每次只能选择修改一个学生");
		}else{
			//去到修改页面
			location.href="stuAction_toUpdateStu?stu.sno="+ids[0].value;
		}
	}
	
	//删除学生
	function deleteStu(){
		var ids=$(":checkbox:checked");
		if(ids.length==0){
			alert("请选择要删除的学生");
		}else{
			var param=$(":checkbox").serialize();
			location.href="stuAction_deleteStus?"+param;
		}
		
	}
</script>









