<%@ page language="java" contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
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

		<title>成绩修改</title>

		<style type="text/css">
<!--
.style1 {
	color: #FFFFFF
}
-->
</style>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	</head>

	<body background="<%=basePath%>images/main.GIF">
		<center>
			<h2>
				<img src="<%=basePath%>images/jiantou.jpg">
				当前位置：成绩修改
			</h2>
			<form action="<%=basePath%>teacherAction!updateStudentScore.action" method="post">
				<table width="460" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td>
							<table width="460" border="1" cellspacing="1" cellpadding="0">
								<tr>
									<td align="center" width="100" height="40" bgcolor="#336699">
										学号
									</td>
									<td width="233" align="center">
										<input type="text" readonly="readonly" name="score.student.id"
											value=${score.student.id } />
									</td>
								</tr>
								<tr>
									<td height="40" bgcolor="#336699" align="center">
										姓名
									</td>
									<td height="40" align="center">
										<input type="text" readonly="readonly"
											name="score.student.name" value=${score.student.name } />
									</td>
								</tr>
								<tr>
									<td height="40" bgcolor="#336699" align="center">
										成绩
									</td>
									<td height="40" colspan="2" align="center">
										<input type="text" name="stuScore" value="${score.score}" />
									</td>
								</tr>
								<tr>
									<td colspan="2" align="center">
										<input type="hidden" name="score.id" value=${score.id } />
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
		<br>
	</body>
</html>