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
		List list = (List) request.getAttribute("list");
		Iterator it = list.iterator();
	%>

	<%@ include file="Header.jsp"%>

	<form action="">
		<h1 align="center">User List</h1>

		<table border="2%" style="width: 100%">
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
	</form>

</body>
</html>