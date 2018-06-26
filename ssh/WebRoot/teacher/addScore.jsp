<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

		<title>录入成绩</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		.infotable th{
			color: white;
		}
	</style>
	</head>

	<body>
		<center>
			<h2>
				<img src="<%=basePath%>images/jiantou.jpg">
				当前位置：录入成绩
			</h2>
			<form action="<%=basePath%>teacherAction!addStudentScore" method="post">
				<table width="460" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td>
							<table class="infotable" width="460" border="1 solid" cellspacing="0" cellpadding="10">
								<tr>
									<th align="center" width="100" height="40" bgcolor="gray">
										学号
									</th>
									<td width="233" align="center">
										<input type="text" name="sid" />
									</td>
								</tr>
								<tr>
									<th height="40" bgcolor="gray" align="center">
										成绩
									</th>
									<td height="40" colspan="2" align="center">
										<input type="text" name="stuScore" />
									</td>
								</tr>
								<tr>
									<td colspan="2" align="center">
										<input type="hidden" name="id" value=${teacher.course.id } />
										<input type="submit" value="提交" />

										<input type="reset" value="重置" />
									</td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</form>
		</center>
	</body>
</html>
