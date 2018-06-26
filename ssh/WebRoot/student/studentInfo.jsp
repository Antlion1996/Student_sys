<%@ page language="java" contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

		<title>查询基本信息</title>

		<style type="text/css">
<!--
.style1 {
	color: #FFFFFF
}
.infotable th{
	color: white;
}
-->
</style>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	</head>

	<body background="<%=basePath%>images/main.GIF">
		<center>
			<h2>
				<img src="<%=basePath%>images/jiantou.jpg">
				当前位置：查询基本信息
			</h2>
			<form>
				<c:set var="student" value="${sessionScope.student}" />
				<table width="460" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td>
							<table class="infotable" width="460" border="1 solid" cellspacing="0" cellpadding="10">
								<tr>
									<th align="center" width="100" height="40" bgcolor="gray">
										学号
									</th>
									<td width="233" align="center">
										${student.id }
									</td>
									<td width="120" rowspan="3" align="center">
										<img src="<%=basePath%>images/person.png" width="100"
											height="110" />
									</td>
								</tr>
								<tr>
									<th height="40" bgcolor="gray" align="center">
										姓名
									</th>
									<td height="40" align="center">
										${student.name }
									</td>
								</tr>
								<tr>
									<th height="40" bgcolor="gray" align="center">
										性别
									</th>
									<td height="40" align="center">
										${student.sex}
									</td>
								</tr>
								<tr>
									<th height="40" bgcolor="gray" align="center">
										班级
									</th>
									<td height="40" colspan="2" align="center">
										${student.clazz }
									</td>
								</tr>
								<tr>
									<th height="40" bgcolor="gray" align="center">
										出生日期
									</th>
									<td height="40" colspan="2" align="center">
										${student.birthday}
									</td>
								</tr>
								<tr>
									<th height="110" align="center" bgcolor="gray">
										个人简介
									</th>
									<td colspan="2" align="center">
										此人很懒，什么都没留下！
									</td>
								</tr>
							</table>
						</td>
					</tr>
				</table>

			</form>
		</center>
		<br>
	</body>
</html>
