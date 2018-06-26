<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<title>修改学生信息</title>
	</head>

	<body background="<%=basePath%>images/main.GIF">
		<center>
			<h2>
				修改学生信息
			</h2>
			<br>
			<s:form action="<%=basePath%>studentAction!updateStudent.action" method="post">

				<table>
					<tr>
						<td>
							<s:textfield readonly="true" name="student.id" label="学号"></s:textfield>
						</td>
						<td>
							<s:textfield name="student.name" label="姓名"></s:textfield>
						</td>
						<td>
							<s:textfield name="student.sex" label="性别"></s:textfield>
						</td>
						<td>
							<s:textfield name="student.clazz" label="班级"></s:textfield>
						</td>
						<td>
							<s:textfield name="student.birthday" label="出生日期"></s:textfield>
						</td>
					</tr>
					<tr>
						<td colspan="4">
							<s:submit value="更 新"></s:submit>
						</td>
					</tr>
				</table>
			</s:form>
		</center>
	</body>
</html>