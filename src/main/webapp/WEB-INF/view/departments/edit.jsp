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
<h3>Create Department</h3>
<form:form action="${pageContext.request.contextPath}/department/edit" method="post" modelAttribute="department">
<form:hidden path="id"/>
<label>Name</label>:<form:input path="name"  />
<br>
<input type="submit" value="Save" /><input type="reset" value="Reset">
</form:form>
</body>
</html>