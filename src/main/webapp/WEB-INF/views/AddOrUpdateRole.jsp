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
			value="${pageContext.request.contextPath}${isUpdating ? '/update-role' : '/add-role'}" />
		<form:form action="${formActionUrl}" method="post"
			modelAttribute="role">
			<div>

				<form:input type="hidden" name="roleId" path="roleId"
					value="${role.roleId}" />
			</div>
			<div>
				<span>Role Name: </span>
				<form:input type="text" name="roleName" value="${role.roleName}"
					path="roleName" />
			</div>

			<div>
				<input type="submit"
					value="${isUpdating ? 'Update Role' : 'Add Role'}">
			</div>

		</form:form>
	</div>
	<%@include file="footer.jsp"%>
</body>
</html>