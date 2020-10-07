<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ include file="/WEB-INF/common/include.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Manage Permission</title>
</head>
<body>
<h3>Manage Permission of Registered Users</h3>
<div class="row">
	<form action="${pageContext.request.contextPath}/admin/manage_permission" method="post">
		<label>User</label>
		<select name="userId">
			<c:forEach items="${userList}" var="u">
				<option value="${u.id }">${u.name }</option>
			</c:forEach>
		</select>
		<br>
		
		<label>Given Privileges</label>
		<div>
			<c:forEach items="${privilegeList }" var="p" varStatus="row">
			<div>
				<input type="hidden" name="privilegeList[${row.index}].id" value="${p.id }" />
				<input type="checkbox" name="privilegeList[${row.index}].selected" /><label>${p.name}</label>
			</div>
			</c:forEach>
		</div>
		<div>
			<input type="submit" value="Save"/>
			<input type="reset" value="Reset" />
		</div>
	</form>
</div>
</body>
</html>