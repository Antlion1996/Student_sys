<%@ page language="java" contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

		<title>管理员信息</title>
	</head>
	<body>
		<center>
			<br />
			<br />
			<font size="5" style="font-family: 微软雅黑">管理员信息列表</font>

			<br />
			<br />
			<table>
				<s:iterator var="admin" value="admin">
					<tr>
						<td>
							用户名：
						</td>
						<td>
							<s:property value="username" />
						</td>
					</tr>
					<tr>
						<td>
							密码：
						</td>
						<td>
							<s:property value="password" />
						</td>
					</tr>
					<tr>
						<td>
							备注：
						</td>
						<td>
							<s:property value="name" />
						</td>
					</tr>
				</s:iterator>
			</table>
		</center>
	</body>
</html>