<%@page import="in.co.rays.bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>UserView</title>
</head>
<body>


	<%@ include file="Header.jsp"%>


	<%
		String success = (String) request.getAttribute("success");
		String error = (String) request.getAttribute("error");
	%>

	<div align="center">

		<%
			UserBean bean = (UserBean) request.getAttribute("bean");
		%>

		<%
			if (bean != null && bean.getId() > 0) {
		%>
		<h1>Update User</h1>
		<%
			} else {
		%>

		<h1>Add User</h1>
		<%
			}
		%>


		<%
			if (success != null) {
		%>
		<h3>
			<font color="green"><%=success%></font>
		</h3>

		<%
			}
		%>
		<%
			if (error != null) {
		%>
		<h3>
			<font color="red"><%=error%></font>
		</h3>

		<%
			}
		%>
		<form action="UserCtl" method="post">

			<table>
				<tr>
					<th>First Name</th>
					<td><input type="text" name="firstName"
						value="<%=(bean != null) ? bean.getFirstName() : ""%>"></td>
				</tr>
				<tr>
					<th>Last Name</th>
					<td><input type="text" name="lastName"
						value=" <%=(bean != null) ? bean.getLastName() : ""%>"></td>
				</tr>
				<tr>
					<th>Login Id</th>
					<td><input type="text" name="loginId"
						value="<%=(bean != null) ? bean.getLoginId() : ""%>"></td>
				</tr>
				<tr>
					<th>Password</th>
					<td><input type="text" name="password"
						value="<%=(bean != null) ? bean.getPassword() : ""%>"></td>
				</tr>
				<tr>
					<th>DOB</th>
					<td><input type="date" name="dob"
						value="<%=(bean != null) ? bean.getDob() : ""%>"></td>
				</tr>
				<tr>
					<th>Address</th>
					<td><input type="text" name="address"
						value="<%=(bean != null) ? bean.getAddress() : ""%>"></td>
				</tr>

				<tr>
					<th></th>
					<td><input type="submit" name="operation"
						value="<%=(bean != null && bean.getId() > 0) ? "update" : "save"%>"></td>
				</tr>
			</table>
		</form>
	</div>

</body>
</html>