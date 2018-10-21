<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User storage</title>
</head>
<body>

<h3>List for store writes about users</h3>

<a href="${pageContext.servletContext.contextPath}/WEB-INF/views/create.jsp">Add new user</a>
<table border="1">
    <tr>
        <th>NAME</th>
        <th>LOGIN</th>
        <th>EMAIL</th>
        <th>CREATED</th>
        <th>EDIT_WRITES</th>
    </tr>
    <c:forEach items="${users}" var="user" varStatus="status">
        <tr>
            <td><c:out value="${user.login}"></c:out></td>
            <td><c:out value="${user.name}"></c:out></td>
            <td><c:out value="${user.email}"></c:out></td>
            <td><c:out value="${user.created}"></c:out></td>
            <td>
                <a href="${pageContext.servletContext.contextPath}/WEB-INF/views/update.jsp">edit</a>
                <a href="${pageContext.servletContext.contextPath}/WEB-INF/views/delete.jsp">del</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
