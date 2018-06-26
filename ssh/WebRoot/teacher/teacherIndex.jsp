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
		<script type="text/javascript" src="js/jquery-1.7.1.js">
	
</script>

		<title>首页</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<style type="text/css">
.header {
	background-color: #06F;
	clear: both;
	height: 150px;
	width: 960px;
	margin-right: auto;
	margin-left: auto;
}

a:link {
	color: #00F;
	text-decoration: none;
}

a:visited {
	text-decoration: none;
	color: #000;
}

a:hover {
	text-decoration: underline;
	color: #00F;
}

a:active {
	text-decoration: none;
	color: #000;
}

.main {
	clear: both;
	height: 600px;
	width: 960px;
	margin-right: auto;
	margin-left: auto;
	background-color: "#FFF";
}

.footer {
	clear: both;
	height: 150px;
	width: 960px;
	margin-right: auto;
	margin-left: auto;
}
</style>
	</head>

	<body bgcolor="white">
		<center>
			<input type="hidden" name="teacher.course.id"
				value=${teacher.course.id } />
			<div class="header" id="header">
				<table width="100%" height="150"
					style="background-color: #999999">
					<tr>
						<td height="110">
							<%-- <img src="<%=basePath%>images/logo.png" width="469" height="80" /> --%>
							&nbsp;&nbsp;&nbsp;<b style="color: white;font-family: 隶书;font-size: 40px">学生信息管理系统</b>
						</td>
					</tr>
					<tr>
						<td height="40">
							<table width="100%" border="1" cellspacing="0" cellpadding="1" style="color: white">
								<tr id="change">
									<td height="30" align="center"
										title="<%=basePath%>teacher/teacherInfo.jsp">
										<div>
											查询基本信息
										</div>
									</td>
									<td align="center"
										title="<%=basePath%>teacher/updateTeacher.jsp">
										<div id="updateInfo">
											修改个人信息
										</div>
									</td>
									<td align="center"
										title="<%=basePath%>teacherAction!loadStudentScores.action">
										<div id="courseInfo">
											成绩查询
										</div>
									</td>
									<td align="center" title="<%=basePath%>teacher/addScore.jsp">
										<div id="addScoure">
											录入成绩
										</div>
									</td>
									<td align="center">
										<div>
											<a href="logout.jsp">退出系统</a>
										</div>
									</td>
									<script type="text/javascript">
	$("#change").children().click(function() {
		var url = $(this).attr("title");
		$('#show').attr("src", url);
	});

	function f(url) {
		//var url = $(this).attr("title");
		$('#show').attr("src", url);
	}
</script>

								</tr>
							</table>
						</td>
					</tr>
				</table>
			</div>
			<div class="main" id="main">
				<iframe src="<%=basePath%>teacher/teacherInfo.jsp" id="show"
					width="960px" height="600px" frameborder="0"></iframe>
			</div>
			<div class="footer" id="footer">
				<table width="100%" height="150"
					bgcolor="white">
					<tr>
						<td align="center">
							<h1>
								欢迎使用学生信息管理系统
							</h1>
						</td>
					</tr>
				</table>
			</div>
		</center>
	</body>
</html>
