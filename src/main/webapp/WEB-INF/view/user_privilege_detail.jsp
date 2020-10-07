<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ include file="/WEB-INF/common/include.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Detail</title>
</head>
<body>
<h3>User Permission Detail</h3>
<label>User Name:</label>${user.name}
<br>
<h5>Privilge List</h5>
<div>
	<c:forEach items="${userPrevilgeList}" var="up">
		<label>${up.privileges.name }</label><br>
	</c:forEach>
</div>
</body>
</html>