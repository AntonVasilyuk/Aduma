<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="${pageContext.servletContext.contextPath}/create" method="post">
        Name : <input type="text" name="name"/>
        Login : <input type="text" name="login"/>
        Email : <input type="text" name="email">
        <input type="submit">
    </form>
</body>
</html>