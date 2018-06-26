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

		<title>登录</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<style type="text/css">
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	/* background-image: url("images/bg1.jpg"); */
	background-color: gray;
}

.s1 {
	font-weight: bold;
	font-size: 24px;
	text-align: left;
}

.s2 {
	text-align: center;
	font-weight: bold;
}
</style>
	</head>
	<script type="text/javascript">
function check_login() {
	var username = document.getElementById("username");
	var password = document.getElementById("password");
	var type = document.getElementById("type");
	if (username.value == "" || password.value == "" || type.value == "") {
		window.alert("登录ID、登录密码和登录身份都不能为空！");
		return false;
	}
	return true;
}
</script>
	<body>
		<form name="form1" action="loginAction" method="post">
			<table width="100%" border="0" cellspacing="0" cellpadding="0"
				height="705">
				<tr>
					<td height="192" colspan="3" class="s3" align="center">
						<h1 style="color: white;font-size: 70px;">
							学生信息管理系统
						</h1>
					</td>
				</tr>
				<tr>
					<td width="39%" height="206">
						&nbsp;
					</td>
					<td width="27%" valign="top"><!-- background="images/login_bg .jpg" -->
						<table width="297" border="0" cellspacing="0" cellpadding="0"
							 bgcolor="white">
							<tr>
								<td height="40" align="left">
									&nbsp;&nbsp;
									<img src="images/login_logo.jpg" width="53" height="40" />
									<span class="s1">&nbsp;用户登录</span>
								</td>
							</tr>
							<tr>
								<td height="140" valign="top">
									<table width="100%" border="0" cellspacing="0" cellpadding="0">
										<tr>
											<td width="33%" height="20">
												&nbsp;
											</td>
											<td width="57%" height="20">
												&nbsp;
											</td>
											<td width="10%" height="25">
												&nbsp;
											</td>
										</tr>
										<tr>
											<td height="35" class="s2">
												登录ID
											</td>
											<td height="35">
												<input type="text" id="username" name="username" />
											</td>
											<td height="40">
												&nbsp;
											</td>
										</tr>
										<tr>
											<td height="35" class="s2">
												登录密码
											</td>
											<td height="35">
												<input type="password" id="password" name="password" />
											</td>
											<td height="40">
												&nbsp;
											</td>
										</tr>
										<tr>
											<td class="s2">
												登录身份
											</td>
											<td>
												<select id="type" name="type">
													<option>
														--请选择--
													</option>
													<option value="0">
														学生
													</option>
													<option value="1">
														教师
													</option>
													<option value="2">
														管理员
													</option>
												</select>
											</td>
										</tr>
										<tr>
											<td height="37" colspan="2" align="right">
												<input type="submit" id="submit" name="submit" value="登录"
													onclick="return check_login();" />
												<input type="reset" id="reset" name="reset" value="重置" />
												&nbsp;
											</td> 
											<td height="37">
												&nbsp;
											</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
					<td width="34%">
						&nbsp;
					</td>
				</tr>
				<tr>
					<td height="306" colspan="3">
						&nbsp;
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
