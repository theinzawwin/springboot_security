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
<h3>Department List</h3>
<a href="<c:url value='/department/create'/>">Create New</a>
<table>
	<thead>
		<tr>
		<th>No</th>
		<th>Name</th>
		<th>Action</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${departmentList}" var="d" varStatus="r">
			<tr>
				<td>${r.count }</td>
				<td>${d.name }</td>
				<td><a href="${pageContext.request.contextPath}/department/edit/${d.id}">Edit</a>
				<a href="${pageContext.request.contextPath}/department/delete/${d.id}">Delete</a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</body>
</html>