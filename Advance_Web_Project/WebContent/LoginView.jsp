<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
</head>
<body>
	<%@ include file="Header.jsp"%>
	

	<%
		String success = (String) request.getAttribute("success");
		String error = (String) request.getAttribute("error");
	%>


	<div align="center">
		<h1>Login</h1>
		<%
			if (error != null) {
		%>
		<h3>
			<font color="red"><%=error%></font>
		</h3>

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
		<form action="LoginCtl" method="post">
			<table>
				<tr>
					<th>Login Id</th>
					<td><input type="text" name="loginId"></td>
				</tr>
				<tr>
					<th>Password</th>
					<td><input type="text" name="password"></td>
				</tr>
				<tr>

					<td><input type="submit" value="signIn" name="operation"></td>
					<td><input type="submit" value="signUp" name="operation"></td>
				</tr>
			</table>
		</form>
	</div>

</body>
</html>