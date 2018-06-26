<%@ page language="java" pageEncoding="GBK"%>
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
		<title>修改密码</title>
	</head>
	<body>
		<table width="955px" align="center" cellspacing="0">
			<tr>
				<td colspan="4" height="20">
					&nbsp;
				</td>
			</tr>
			<tr>
				<td width="34" height="30" valign="middle">
					&nbsp;
					<span class="STYLE1"><img src="<%=basePath%>images/jiantou.jpg"
							width="15" height="17" /> </span>
				</td>
				<td colspan="3" valign="middle">
					当前位置：修改密码
				</td>
			</tr>
			<tr>
				<td colspan="4" height="20">
					&nbsp;
				</td>
			</tr>
			<tr>
				<td>
					&nbsp;
				</td>
				<td width="80">
					&nbsp;
				</td>
				<td width="500">
					<c:set var="student" value="${sessionScope.student}" />
					<form method="post"
						action="<%=basePath%>studentAction!updateStudentPwd.action">
						<table cellspacing="1" bgcolor="#c2d3b0">
							<tr>
								<td width="80" height="30" bgcolor="#f8fcf3">
									登录帐号：
								</td>
								<td width="185" bgcolor="#FFFFFF">
									&nbsp;
									<input name="student.id" value="${student.id }"
										readonly="readonly" />
								</td>
								<td width="200" bgcolor="#FFFFFF">
									&nbsp;当前帐号，不可以修改
								</td>
							</tr>
							<tr>
								<td height="30" bgcolor="#f8fcf3">
									旧密码：
								</td>
								<td bgcolor="#FFFFFF">
									&nbsp;
									<input type="password" name="student.password" />
								</td>
								<td bgcolor="#FFFFFF">
									&nbsp;输入原始密码
								</td>
							</tr>
							<tr>
								<td height="30" bgcolor="#f8fcf3">
									新密码：
								</td>
								<td bgcolor="#FFFFFF">
									&nbsp;
									<input type="password" name="newPassword" />
								</td>
								<td bgcolor="#FFFFFF">
									&nbsp;输入新密码
								</td>
							</tr>
							<tr>
								<td height="30" bgcolor="#f8fcf3">
									确认密码：
								</td>
								<td bgcolor="#FFFFFF">
									&nbsp;
									<input type="password" name="confirmPassword" />
								</td>
								<td bgcolor="#FFFFFF">
									&nbsp;确认新密码
								</td>
							</tr>
							<tr>
								<td height="30" colspan="3" align="center" bgcolor="#FFFFFF">
									<input type="submit" value="修改" />
									&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="reset" value="重置" />
								</td>
							</tr>
						</table>
					</form>
				</td>
				<td width="331">
					&nbsp;
				</td>
			</tr>
		</table>
	</body>
</html>

