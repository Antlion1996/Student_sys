<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<base href="<%=basePath%>">
		<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
		<title>退出系统</title>
		<script type="text/javascript">
	var secs = 3; //倒计时的秒数 
	var URL;
	function Load(url) {
		URL = url;
		for ( var i = secs; i >= 0; i--) {
			window.setTimeout('doUpdate(' + i + ')', (secs - i) * 1000);
		}
	}
	function doUpdate(num) {
		document.getElementById('ShowDiv').innerHTML = '将在' + num + '秒后自动跳转到登录页面';
		if (num == 0) {
			window.location = URL;
		}
	}
</script>
	</head>
	<!--[if IE]><style type="text/css"> body {word-wrap: break-word;}</style><![endif]-->
	<body background="<%=basePath%>images/main.GIF">
		<center>
			<%
				//使session失效
				session.invalidate();
			%>
			<br/><br/><br/><br/><br/><br/>
			<h1>
				注销成功！
			</h1>
			<div id="ShowDiv"></div>
			<script language="javascript">
	Load("<%=basePath%>login.jsp"); //要跳转到的页面
</script>

			<p>
				如果没有跳转，请点
				<a href="<%=basePath%>login.jsp">这里</a>
			</p>
		</center>

	</body>
</html>



