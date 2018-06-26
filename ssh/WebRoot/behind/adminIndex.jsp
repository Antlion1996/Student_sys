<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
		
		<title>学生选课系统系统</title>
	</head>
	<frameset rows="*" cols="180,*" frameborder="no" border="0"
		framespacing="0">
		<frame src="<%=basePath%>behind/behindLeft.jsp" name="leftFrame"
			scrolling="auto" noresize="noresize" id="leftFrame" title="leftFrame" />
		<frameset frameborder="no" border="0" framespacing="0">
			<frame src="<%=basePath%>behind/behindRight.jsp" name="mainFrame"
				scrolling="auto" noresize="noresize" id="mainFrame"
				title="mainFrame" />
		</frameset>
	</frameset>
	<noframes>
		<body>
			<p>
				<font size="+3" color="red">你的浏览器不支持框架，请升级你的浏览器</font>
			</p>
		</body>
	</noframes>
</html>
