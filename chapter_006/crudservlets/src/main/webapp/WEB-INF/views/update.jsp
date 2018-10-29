<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Update</title>
</head>
<body>
<form action='${pageContext.servletContext.contextPath}/update' method=post>
     <input type='hidden' name='id' value='${id}'/>
    Name : <input type='text' name='name' value="${name}"/>
    Login : <input type='text' name='login' value="${login}"/>
    Password : <input type="text" name='password' value="${password}"/>
    Email : <input type='text' name='email' value="${email}"/>
    Role: <select name="role"/>
    <option value="admin">admin</option>
    <option value="user">user</option>
    </select>
    <input type='submit' value='Update'>
</form>
</body>
</html>
