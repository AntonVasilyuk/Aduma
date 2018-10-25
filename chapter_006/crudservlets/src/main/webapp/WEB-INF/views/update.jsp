<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Update</title>
</head>
<body>
<form action='${pageContext.servletContext.contextPath}/update' method=post>
    ID : <input type='text' name='id' value='${id}'/>
    Name : <input type='text' name='name'/>
    Login : <input type='text' name='login'/>
    Email : <input type='text' name='email'>
    <input type='submit' value='Update'>
</form>
</body>
</html>
