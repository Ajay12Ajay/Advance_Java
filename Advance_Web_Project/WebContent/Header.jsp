<%@page import="in.co.rays.bean.UserBean"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		UserBean user = (UserBean) session.getAttribute("user");
	%>
	<%
		if (user != null) {
	%>
	<h3>
		Hi,
		<%=user.getFirstName()%></h3>

	<a href="#"><b>Add User</b></a>
	<b>|</b>
	<a href="UserListCtl"><b>User List</b></a>
	<b>|</b>
	<a href="LoginCtl?operation=Logout"><b>Logout</b></a>

	<%
		} else {
	%>

	<h3>Hi, Guest</h3>
	<a href="WelcomeCtl">Welcome</a>
	<b>|</b>
	<a href="LoginCtl">Login</a>
	<%
		}
	%>

	<hr>

</body>
</html>