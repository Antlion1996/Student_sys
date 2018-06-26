<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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

		<title>成绩查询</title>
		<script type="text/javascript">
function load() {
	var trs = document.getElementsByTagName("tr");
	for ( var i = 1; i < trs.length; i++) {
		trs[i].onmouseover = function() {
			this.className = "at";
		};
		trs[i].onmouseout = function() {
			this.className = "none";
		};
	}
}
</script>
	</head>

	<body background="<%=basePath%>images/main.GIF">
		<center>
			<h2>
				<img src="<%=basePath%>images/jiantou.jpg">
				当前位置：成绩查询
			</h2>
			<table width="660" border="1" cellspacing="0" cellpadding="5"
				bordercolor="#000">
				<tr align="center"
					style="background-color: #00BFFF; border-bottom: 2px solid black; height: 30px">
					<td width="50px">
						学号
					</td>
					<td width="100px">
						姓名
					</td>
					<td width="100px">
						${teacher.course.name}成绩
					</td>
					<td width="100px">
						操作
					</td>
				</tr>
				<c:forEach items="${sessionScope.scoresList}" var="scoresList"
					varStatus="num">
					<tr align="center"
						style="background-color: #FFFFFF; border-bottom: 2px solid black; height: 30px">
						<td>
							${scoresList.studentId}
						</td>
						<td>
							${scoresList.name}
						</td>
						<td>
							${scoresList.score}
						</td>
						<td>
							<a
								href="<%=basePath%>teacherAction!editStudentScore.action?id=${scoresList.id}">修改</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</center>
	</body>
</html>
