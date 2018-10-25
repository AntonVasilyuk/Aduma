<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="${pageContext.servletContext.contextPath}/delete" method=post>
        ID : <input type="text" name="id" value="${id}">
        <input type="submit" name="DELETE">
    </form>
</body>
</html>
