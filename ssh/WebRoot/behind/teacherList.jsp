<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
		<title>教师信息</title>
	</head>
	<script language="javascript" type="text/javascript">
function doEdit(id) {
	frm.action = "<%=basePath%>teacherAction!editTeacher.action?id=" + id;
}

function dofind() {
	document.forms[0].action = "<%=basePath%>teacherAction!getTeacherById.action";
	document.forms[0].submit;
}

function dodelete(id) {
	frm.action = "<%=basePath%>teacherAction!deleteTeacher.action?id=" + id;
	if (!confirm("确认要删除？")) {
		window.event.returnValue = false;
	}
}

function getPwd(id) {
	frm.action = "<%=basePath%>teacherAction!getTeacherPwd.action?id="+id;
}
</script>

	<body>
		<center>
			<h1> 
				教师信息列表 
			</h1>
			<s:form action="" theme="simple">
				<table width="60%">
					<tr>
						<td>
							<font color=red><br> <marquee direction=left
									scrollamount="4">
									<b>※温馨提示：修改后的信息如没能正确反映请刷新后查看 删除的信息将不能复原，请慎重考虑※</b>
								</marquee> </font>
						</td>
					</tr>
				</table>
				<table>
					<tr>
						<td>
							<s:textfield name="teacher .id" />
						</td>
						<td>
							<input type="submit" value="按工号查询" align="bottom"
								onClick="dofind()" />
						</td>
					</tr>
				</table>
			</s:form>
			<s:form action="" method="post" name="frm">
				<table width="80%" border="1 solid" cellpadding="10" cellspacing="0">
					<tr
						style="background-color: gray;height: 30px; color: white;">
						<th>
							教工号
						</th>
						<th>
							姓名
						</th>
						<th>
							性别
						</th>
						<th>
							出生日期
						</th>
						<th>
							课程名
						</th>
						<th>
							职称
						</th>
						<th>
							密码
						</th>
						<th colspan="3">
							操作
						</th>
					</tr>
					<s:iterator id="teachers" value="teachers" status="index">
						<tr
							style="background-color: white; height: 30px;">
							<td align="center">
								<s:property value="id" />
							</td>
							<td align="center">
								<s:property value="name" />
							</td>
							<td align="center">
								<s:property value="sex" />
							</td>
							<td align="center">
								<s:property value="birthday" />
							</td>
							<td align="center">
								<s:property value="course.name" />
							</td>
							<td align="center">
								<s:property value="professional" />
							</td>
							<td align="center">
								<s:property value="password" />
							</td>
							<td align="center">
								<input type="submit" value="编辑" align="bottom"
									onClick="doEdit(<s:property value="id"/>)" />
							</td>
							<td align="center">
								<input type="submit" value="删除" align="bottom"
									onclick="dodelete(<s:property value="id"/>);" />
							</td>
							<td align="center">
								<input type="submit" value="修改密码" align="bottom"
									onclick="getPwd(<s:property value="id"/>);" />
							</td>
						</tr>
					</s:iterator>
				</table>
			</s:form>
		</center>
	</body>
</html>