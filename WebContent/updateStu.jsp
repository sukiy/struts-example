<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
</head>
<body>
	<h2>修改学生</h2>
	<s:form method="post" action="stuAction_updateStu" enctype="multipart/form-data">
				<s:hidden name="stu.sno"/>
		学生姓名:<s:textfield name="stu.sname"/><br/>
		学生性别:<s:radio list="{'男','女'}" name="stu.ssex"/><br/>
		学生爱好:<s:checkboxlist list="{'体育','娱乐','睡觉'}" name="stu.shobby"/><br/>
		入学时间:<s:textfield name="stu.sintime"/><br/>
		<img alt="" src="${stu.simage }" width="80" height="80"><br/>
		<s:hidden name="stu.simage"/>
		学生图像:<s:file name="stuImage"/><br/>
		分配班级:<s:select list="#request.clsList" name="stu.scno" headerKey="" headerValue="请分配班级" listKey="cno" listValue="cname"/><br/>
				<s:submit value="修改学生"/>
	</s:form>
	<a href="stuAction_findStuList">学生信息列表</a>
</body>
</html>
<script type="text/javascript">
	var hobby="${stu.shobby}";
	var hobbys=$(":checkbox");//所有复选框
	for (var i = 0; i < hobbys.length; i++) {
		if(hobby.indexOf(hobbys[i].value)>=0)
			hobbys[i].checked=true;
	}
</script>




