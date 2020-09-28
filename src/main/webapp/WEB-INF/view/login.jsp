<%@ include file="/WEB-INF/common/include.jsp"%>
<center>
<h1>Welcome to Spring Boot Security</h1>

<h2>Login Page</h2>
<form method="POST" action="/login">
<fieldset>
            <legend>Please sign in</legend>
            <c:if test="${param.error != null}">          
        <p style="color:red;">  
            Invalid username and password.  
        </p>  
    </c:if>  
    <c:if test="${param.logout != null}">         
        <p>  
            You have been logged out.  
        </p>  
    </c:if>  

	User Name : <input type="text" name="username" /><br><br>
	Password  : <input type="password" name="password" /><br><br>
	<input type="submit" name="submit"/>
	</fieldset>
</form>
</center>