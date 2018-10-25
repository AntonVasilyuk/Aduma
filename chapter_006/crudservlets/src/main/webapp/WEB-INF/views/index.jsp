<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User storage</title>
</head>
<body>

<h3>List for store writes about users</h3>

<a href="${pageContext.servletContext.contextPath}/create">Add new user</a>
<table border="1">
    <tr>
        <th>ID</th>
        <th>NAME</th>
        <th>LOGIN</th>
        <th>EMAIL</th>
        <th>EDIT_WRITES</th>
    </tr>
    <c:forEach items="${users}" var="user" varStatus="status">
        <tr>
            <td><c:out value="${user.id}"></c:out></td>
            <td><c:out value="${user.name}"></c:out></td>
            <td><c:out value="${user.login}"></c:out></td>
            <td><c:out value="${user.email}"></c:out></td>
            <td>
                <a href="${pageContext.servletContext.contextPath}/update?id=${user.id}">edit</a>
                <a href="${pageContext.servletContext.contextPath}/delete?id=${user.id}">del</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
