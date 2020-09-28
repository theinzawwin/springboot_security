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
<h3>Teacher List</h3>
<a href="<c:url value='/teacher/create' />">Create New</a>
<div>
	<h6>Search By Department</h6>
	<form action="${pageContext.request.contextPath}/teacher/list">
		<label>Department</label><select name="departmentId">
			<c:forEach items="${departmentList }" var="d">
				<option value="${d.id}">${d.name}</option>
			</c:forEach>
		</select>
		<input type="submit" value="Search" />
	</form>
</div>
<table>
	<thead>
		<tr>
			<td> No.</td>
			<td>Name</td>
			<td>Nrc</td>
			<td>Phone</td>
			<td>Email</td>
			<td>Department</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${teacherList }" var="t" varStatus="r">
			<tr>
				<td>${r.count }</td>
				<td>${t.name }</td>
				<td>${t.nrc }</td>
				<td>${t.phone }</td>
				<td>${t.email }</td>
				<td>${t.departmentName }</td>
				
			</tr>
		</c:forEach>
	</tbody>
</table>
</body>
</html>