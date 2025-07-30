<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
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
		int pageNo = (int) request.getAttribute("pageNo");
		List list = (List) request.getAttribute("list");
		Iterator it = list.iterator();
	%>

	<%@ include file="Header.jsp"%>

	<form action="UserListCtl" method="post">

		<div align="center">
			<h1>User List</h1>
		</div>


		<div align="center">
			<table>
				<tr>
					<th>First Name:</th>
					<td><input type="text" name="firstName"
						placeholder="enter first name here">&nbsp; &nbsp;</td>
					<th>Date of birth:</th>
					<td><input type="date" name="dob">&nbsp; &nbsp;</td>
					<td><input type="submit" name="operation" value="search"></td>
				</tr>
			</table>
		</div>

		<br>

		<table border="1%" style="width: 100%">
			<tr style="background: gray;">
				<th>Sr No</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Login Id</th>
				<th>Password</th>
				<th>DOB</th>
				<th>Address</th>
				<th>Edit</th>

			</tr>

			<%
				while (it.hasNext()) {
					UserBean bean = (UserBean) it.next();
			%>

			<tr align="center">
				<td><%=bean.getId()%></td>
				<td><%=bean.getFirstName()%></td>
				<td><%=bean.getLastName()%></td>
				<td><%=bean.getLoginId()%></td>
				<td><%=bean.getPassword()%></td>
				<td><%=bean.getDob()%></td>
				<td><%=bean.getAddress()%></td>
				<td><a href="#">edit</a></td>
			</tr>

			<%
				}
			%>

		</table>

		<table style="width: 100%">
			<tr>
				<td style="width: 30%"><input type="submit" name="operation"
					value="previous" <%=(pageNo == 1) ? "disabled" : ""%>></td>

				<td style="width: 30%"><input type="submit" name="operation"
					value="add"></td>

				<td style="width: 25%"><input type="submit" name="operation"
					value="delete"></td>

				<td style="text-align: right;"><input type="submit"
					name="operation" value="next"
					<%=(list.size() < 5) ? "disabled" : ""%>></td>
			</tr>
		</table>

		<input type="text" name="pageNo" value="<%=pageNo%>">
	</form>

</body>
</html>