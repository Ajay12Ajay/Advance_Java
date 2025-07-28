<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Registration</title>
</head>
<body>
	<%@ include file="Header.jsp"%>

	<%
		String success = (String) request.getAttribute("success");
		String error = (String) request.getAttribute("error");
	%>

	<div align="center">

		<h1>User Registration</h1>
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
		<form action="UserRegistrationCtl" method="post">
			
			<table>
				<tr>
					<th>First Name</th>
					<td><input type="text" name="firstName"></td>
				</tr>
				<tr>
					<th>Last Name</th>
					<td><input type="text" name="lastName"></td>
				</tr>
				<tr>
					<th>Login Id</th>
					<td><input type="text" name="loginId"></td>
				</tr>
				<tr>
					<th>Password</th>
					<td><input type="text" name="password"></td>
				</tr>
				<tr>
					<th>DOB</th>
					<td><input type="date" name="dob"></td>
				</tr>
				<tr>
					<th>Mobile No</th>
					<td><input type="text" name="mobileNo"></td>
				</tr>
				<tr>
					<th>Role Id</th>
					<td><input type="text" name="roleId"></td>
				</tr>
				<tr>
					<th>Gender</th>
					<td><input type="text" name="gender"></td>
				</tr>
				<tr>
					<td><input type="hidden" name="createdBy"></td>
				</tr>
				<tr>

					<td><input type="hidden" name="modifiedBy"></td>
				</tr>
				<tr>
					<td><input type="hidden" name="createdDatetime"></td>
				</tr>
				<tr>
					<td><input type="hidden" name="createdDatetime"></td>
				</tr>
				<tr>
					<th></th>
					<td><input type="submit" name="signUp"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>