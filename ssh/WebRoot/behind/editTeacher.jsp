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
		<title>修改教师信息</title>
	</head>

	<body background="<%=basePath%>images/main.GIF">
		<center>
			<h2>
				修改教师信息
			</h2>
			<br>
			<s:form action="<%=basePath%>teacherAction!updateTeacher.action" method="post">

				<table>
					<tr>
						<td>
							<s:textfield readonly="true" name="teacher.id" label="教工号" />
						</td>
						<td>
							<s:textfield name="teacher.name" label="姓名" />
						</td>
						<td>
							<s:textfield name="teacher.sex" label="性别" />
						</td>
						<td>
							<s:textfield name="teacher.birthday" label="出生日期" />
						</td>
						<td>
							<s:textfield name="teacher.course.courserName" label="课程名" />
						</td>
						<td>
							<s:textfield name="teacher.professional" label="职称" />
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