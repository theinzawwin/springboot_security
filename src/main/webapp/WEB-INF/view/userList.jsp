<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ include file="/WEB-INF/common/include.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All User List</title>
</head>
<body>
<h3>User List</h3>
<div>
	<a href="<c:url value='/admin/manage_permission' />">Manage Permission</a>
</div>
<div>
	<table>
		<thead>
		<tr>
			<th>
				No
			</th>
			<th>
			Name
			</th>
			<th>
			Action
			</th>
		</tr>
		</thead>
		<tbody>
			<c:forEach items="${userList }" var="u" varStatus="row">
				<tr>
					<td>${row.count }</td>
					<td>${u.name }</td>
					<td><a href="<c:url value='/admin/privilege/${u.id}' />">Detail</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
</body>
</html>