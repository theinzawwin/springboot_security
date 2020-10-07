<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c"		uri="http://java.sun.com/jsp/jstl/core"%>
<center>
<h1>Welcome to Spring Boot Simple Security Example</h1>
<sec:authorize access="isAuthenticated()">
<a href="/logout">logout</a>
</sec:authorize>

<sec:authorize access="hasAuthority('ADMIN')">
<a href="<c:url value='/admin_info' />">Admin</a>
</sec:authorize>
<sec:authorize access="hasAuthority('MG_DEPARTMENT')">
<a href="<c:url value='/department/list' />">Department List</a>
</sec:authorize>
<sec:authorize access="hasAuthority('MG_TEACHER')">
<a href="<c:url value='/teacher/list' />">Teacher List</a>
</sec:authorize>
<sec:authorize access="hasAuthority('MG_ITEM')">
<a href="<c:url value='/items/list' />">Item List</a>
</sec:authorize>
<sec:authorize access="hasAuthority('MG_BOOK')">
<a href="<c:url value='/book/list' />">Item List</a>
</sec:authorize>
<sec:authorize access="hasAuthority('MG_ADMIN')">
<a href="<c:url value='/admin/user_list' />">User List</a>
</sec:authorize>
<sec:authorize access="hasAuthority('USER')">
<a href="<c:url value='/info' />">Info</a>
</sec:authorize>
<sec:authorize access="hasRole('ROLE_MANAGER')">
<a href="<c:url value='/manager/manager.htm' />">Manager</a>
<a href="<c:url value='/item/edit.htm' />">Item Edit</a>
</sec:authorize>

</center>