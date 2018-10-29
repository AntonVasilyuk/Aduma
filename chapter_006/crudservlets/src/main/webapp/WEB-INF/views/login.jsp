<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Authorisation page</title>
</head>
<body>

<h4>Authorisation page</h4>
<c:if test="${error != ''}">
    <div style="background: red">
        <c:out value="${error}"/>
    </div>
</c:if>
<form action="${pageContext.servletContext.contextPath}/signin" method="post">
    Login : <input type="text" name="login"/>
    Password : <input type="password" name="password">
    <input type="submit">
</form>
</body>
</html>

