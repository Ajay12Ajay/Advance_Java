<%@page import="in.co.rays.bean.UserBean"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome to JSP</title>
</head>
<body bgcolor="yellow">
	<%@ include file="Header.jsp"%>
	<br>
	<br>
	<br>

	<div align="center">
		<h1 style="color: maroon;">Welcome to Web Project</h1>
	</div>

	<%
		UserBean user = (UserBean) request.getAttribute("user");
	%>
	<%
		if (user != null) {
	%>
	<h3>
		Hi,
		<%=user.getFirstName()%></h3>
	<%
		}
	%>


</body>
</html>