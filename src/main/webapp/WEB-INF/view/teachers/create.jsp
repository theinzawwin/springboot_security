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
<h3>Create Teacher</h3>
<form:form action="${pageContext.request.contextPath}/teacher/create" method="post" modelAttribute="teacher">
<label>Name</label>:<form:input path="name"  />
<br>
<label>Nrc:</label><form:input path="nrc" /><br>
<label>Email:</label><form:input path="email" /><br>
<label>Phone:</label><form:input path="phone" /><br>
<label>Department:</label><form:select path="departmentId" items="${departmentList }" itemValue="id" itemLabel="name"></form:select>
<input type="submit" value="Save" /><input type="reset" value="Reset">
</form:form>
</body>
</html>