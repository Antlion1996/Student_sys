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

		<title>操作成功</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
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
		document.getElementById('ShowDiv').innerHTML = '将在' + num + '秒后为你自动跳转';
		if (num == 0) {
			window.location = URL;
		}
	}
</script>
	</head>

	<body background="images/main.GIF">
		<center>
		<br/><br/><br/><br/>
			<h1>${message}</h1>
			<div id="ShowDiv"></div>
			<script language="javascript">
	Load("<%=basePath%>${url}"); //要跳转到的页面
</script>

			<p>
				如果没有跳转，请点
				<a href="<%=basePath%>${url}">这里</a>
			</p>
		</center>
	</body>
</html>
