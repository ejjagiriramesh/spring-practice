<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
body {
	text-align: center;
}

table {
	margin-left: auto;
	margin-right: auto;
}

th, td {
	border-bottom: 1px solid #ddd;
}
</style>
</head>
<body>
	<h1>All Users</h1>

	<table>

		<tr>
			<th>FirstName</th>
			<th>LastName</th>
			<th>Emial</th>
			<th>Actions</th>
		</tr>
		<c:forEach items="${users}" var="user">
			<tr>
				<td>${user.firstName}</td>
				<td>${user.lastName}</td>
				<td>${user.email}</td>
				<td><a
					href="${pageContext.request.contextPath}/delete-user?userId=${user.userId}">Delete</a>
					<a
					href="${pageContext.request.contextPath}/update-user?userId=${user.userId}">Update</a>
				</td>
			</tr>
		</c:forEach>

	</table>

	<%@include file="footer.jsp"%>

</body>
</html>