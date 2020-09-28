<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>User Info</h3>
<sec:authorize access="isAnonymous()">
<a href="/login">login</a>
</sec:authorize>
</body>
</html>