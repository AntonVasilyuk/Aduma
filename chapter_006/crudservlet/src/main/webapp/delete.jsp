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
    <form action="<%request.getContextPath();%>/delete" method="post">
        ID : <input type="number" name="id">
        <input type="submit">
    </form>
</body>
</html>
