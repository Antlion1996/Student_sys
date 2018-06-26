<%@ page language="java" contentType="text/html;charset=utf-8"%>
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

		<style type="text/css">
<!--
#Layer1 {
	position: absolute;
	left: 1059px;
	top: 427px;
	width: 43px;
	height: 489px;
	z-index: 1;
}

#Layer2 {
	position: absolute;
	left: 301px;
	top: 558px;
	width: 421px;
	height: 117px;
	z-index: 2;
}

.STYLE3 {
	font-size: 36px
}

.STYLE4 {
	color: #FFFFFF
}

body {
	<%-- background: url(<%=basePath%>images/ourbg.png); --%>
	background-color: white;
}

#Layer3 {
	position: absolute;
	left: 443px;
	top: 73px;
	width: 243px;
	height: 112px;
	z-index: 1;
}

#Layer4 {
	position: absolute;
	left: 421px;
	top: 115px;
	width: 152px;
	height: 85px;
	z-index: 1;
}
-->
</style>
	</head>

	<body>
		<center>
			<%-- <img src="<%=basePath%>images/our.png" width="1039" height="570" /> --%>
			<b style="font-size: 70px;line-height: 1000%;">欢迎使用后台管理系统</b>
		</center>
	</body>

</html>
