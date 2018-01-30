<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>添加学生</h2>
	<s:if test="message==1">
		<div style="color:green">添加学生成功</div>
	</s:if>
	<s:elseif test="message==2">
		<div style="color:red">添加学生失败</div>
	</s:elseif>
	<s:form method="post" action="stuAction_addStu" enctype="multipart/form-data">
		学生姓名:<s:textfield name="stu.sname"/><br/>
		学生性别:<s:radio list="{'男','女'}" name="stu.ssex" value="%{'男'}"/><br/>
		学生爱好:<s:checkboxlist list="{'体育','娱乐','睡觉'}" name="stu.shobby"/><br/>
		入学时间:<s:textfield name="stu.sintime"/><br/>
		学生图像:<s:file name="stuImage"/><br/>
		分配班级:<s:select list="#request.clsList" name="stu.scno" headerKey="" headerValue="请分配班级" listKey="cno" listValue="cname"/><br/>
				<s:submit value="添加学生"/>
	</s:form>
	<a href="stuAction_findStuList">学生信息列表</a>
</body>
</html>





