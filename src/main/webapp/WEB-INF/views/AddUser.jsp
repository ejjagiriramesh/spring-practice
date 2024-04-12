<%@include file="tags.jsp"%>
<%@include file="styles.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
	<h1>Add User Page</h1>
	<h3 style="color: ${isSaved ? 'green' : 'red'};">${msg}</h3>
	<div class="user-form">
		<c:set var="formActionUrl"
			value="${pageContext.request.contextPath}${isUpdating ? '/update-user' : '/add-user'}" />
		<form:form action="${formActionUrl}" method="post"
			modelAttribute="user">
			<div>
				<span>FirstName: </span>
				<form:input type="hidden" name="userId" path="userId"
					value="${user.userId}" />
			</div>
			<div>
				<span>FirstName: </span>
				<form:input type="text" name="firstName" value="${user.firstName}"
					path="firstName" />
			</div>
			<div>
				<span>LastName: </span>
				<form:input type="text" name="lastName" value="${user.lastName}"
					path="lastName" />
			</div>
			<div>
				<span>Email: </span>
				<form:input type="text" name="email" value="${user.email}"
					path="email" />
			</div>
			<div>
				<span>Password: </span>
				<form:input type="text" name="password" value="${user.password}"
					path="password" />
			</div>
			<div>
				<input type="submit"
					value="${isUpdating ? 'Update User' : 'Add User'}">
			</div>

		</form:form>
	</div>
	<%@include file="footer.jsp"%>
</body>
</html>