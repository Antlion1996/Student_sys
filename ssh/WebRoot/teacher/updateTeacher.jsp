<%@ page language="java" contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
	<head>
		<base href="<%=basePath%>">

		<title>修改个人信息</title>

		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<style type="text/css">

		.infotable th{
			color: white;
		}
		</style>
	</head>

	<body background="<%=basePath%>images/main.GIF">
		<center>
			<h2>
				<img src="<%=basePath%>images/jiantou.jpg">
				当前位置：修改个人信息
			</h2>
			<form method="post" action="<%=basePath%>teacherAction!update">
				<table width="460" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td>
							<table class="infotable" width="460" border="1 solid" cellspacing="0" cellpadding="10">
								<tr>
									<th align="center" width="100" height="40" bgcolor="gray">
										教工号
									</th>
									<td width="233" align="center">
										<input type="text" readonly="readonly" name="teacher.id"
											value=${teacher.id } />
									</td>
									<td width="120" rowspan="3" align="center">
										<img src="<%=basePath%>images/person.png" width="100" height="110" />
									</td>
								</tr>
								<tr>
									<th height="40" bgcolor="gray" align="center">
										姓名
									</th>
									<td height="40" align="center">
										<input type="text" name="teacher.name" value=${teacher.name } />
									</td>
								</tr>
								<tr>
									<th height="40" bgcolor="gray" align="center">
										性别
									</th>
									<td height="40" align="center">
										<input type="text" name="teacher.sex" value=${teacher.sex } />
									</td>
								</tr>
								<tr>
									<th height="40" bgcolor="gray" align="center">
										出生日期
									</th>
									<td height="40" colspan="2" align="center">
										<input type="text" name="teacher.birthday"
											value=${teacher.birthday } />
									</td>
								</tr>
								<tr>
									<th height="40" bgcolor="gray" align="center">
										课程名
									</th>
									<td height="40" colspan="2" align="center">
										<input type="text" name="teacher.course.name"
											readonly="readonly" value=${teacher.course.name } />
									</td>
								</tr>
								<tr>
									<th height="40" bgcolor="gray" align="center">
										职称
									</th>
									<td height="40" colspan="2" align="center">
										<input type="text" name="teacher.professional"
											value=${teacher.professional } />
									</td>
								</tr>
								<tr>
									<th height="40" bgcolor="gray" align="center">
										操作 
									</th>
									<td height="40" colspan="2" align="center">
										<input type="submit" name=submit value="修改" />
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