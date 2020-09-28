<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/common/include.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>User Register</h3>
<form:form action="register" method="post" modelAttribute="user">
<label>Name:</label><form:input type="text" path="name" /><br>
<label>Password:</label><form:password path="password" /><br>
<label>Role</label><form:select path="roleName">
	<form:option value="MANAGER">Manager</form:option>
	<form:option value="ADMIN">Admin</form:option>
	<form:option value="USER">User</form:option>
</form:select>
<input type="submit" value="Register" />
</form:form>
</body>
</html>