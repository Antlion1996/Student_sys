<%@ page language="java" contentType="text/html;charset=utf-8"%>
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

		<title>查看个人成绩</title>

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
				当前位置：成绩查询
			</h2>
			<table width="460" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td>
						<table class="infotable" width="460" border="1 solid" cellspacing="0" cellpadding="10">
							<tr>
								<th align="center" width="100" height="40" bgcolor="gray">
									学号
								</th>
								<td width="233" align="center">
									${scoresVo.id }
								</td>
							</tr>
							<tr>
								<th height="40" bgcolor="gray" align="center">
									姓名
								</th>
								<td height="40" align="center">
									${scoresVo.name }
								</td>
							</tr>
							<s:iterator value="scoresVo.scores">
								<tr>
									<th height="40" bgcolor="gray" align="center">
										科目
									</th>
									<td height="40" align="center">
										<s:property value="course.name" />
									</td>
								</tr>
								<tr>
									<th height="40" bgcolor="gray" align="center">
										成绩
									</th>
									<td height="40" colspan="2" align="center">
										<s:property value="score" />
									</td>
								</tr>
							</s:iterator>
						</table>
					</td>
				</tr>
			</table>
		</center>
		<br>
	</body>
</html>