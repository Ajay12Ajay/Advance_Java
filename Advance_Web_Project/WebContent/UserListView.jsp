<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User List View</title>
</head>
<body>



	<%
		String success = (String) request.getAttribute("success");
		String error = (String) request.getAttribute("error");

		int pageNo = (int) request.getAttribute("pageNo");
		int index = ((pageNo - 1) * 5) + 1;

		List list = (List) request.getAttribute("list");
		Iterator it = list.iterator();
	%>

	<%@ include file="Header.jsp"%>

	<form action="UserListCtl.do" method="post">

		<div align="center">
			<h1>User List</h1>

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
				<th>Select</th>
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
				<td><input type="checkbox" name="ids" value="<%=bean.getId()%>"></td>
				<td><%=index++%></td>
				<td><%=bean.getFirstName()%></td>
				<td><%=bean.getLastName()%></td>
				<td><%=bean.getLoginId()%></td>
				<td><%=bean.getPassword()%></td>
				<td><%=bean.getDob()%></td>
				<td><%=bean.getAddress()%></td>
				<td><a href="UserCtl.do?id=<%=bean.getId()%>">edit</a></td>
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