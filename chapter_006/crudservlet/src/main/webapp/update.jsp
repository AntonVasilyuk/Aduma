<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 07.10.2018
  Time: 23:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="<%request.getContextPath();%>/update" method="post">
    ID : <input type="number" name="id">
    Name : <input type="text" name="name"/>
    Login : <input type="text" name="login"/>
    Email : <input type="text" name="email">
    <input type="submit">
</form>
</body>
</html>
