<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User storage</title>
</head>
<body>

<h3>List for store writes about users</h3>

<c:if test="${sessionScope.get('role') == 'admin'}">
<a href="${pageContext.servletContext.contextPath}/create">Add new user</a>
</c:if>
<table border="1">
    <tr>
        <th>ID</th>
        <th>NAME</th>
        <th>LOGIN</th>
        <th>EMAIL</th>
        <c:if test="${sessionScope.get('role') == 'admin'}">
        <th>EDIT_WRITES</th>
        </c:if>
    </tr>
    <c:forEach items="${users}" var="user" varStatus="status">
        <tr>
            <td><c:out value="${user.id}"></c:out></td>
            <td><c:out value="${user.name}"></c:out></td>
            <td><c:out value="${user.login}"></c:out></td>
            <td><c:out value="${user.email}"></c:out></td>
            <c:if test="${sessionScope.get('role') == 'admin'}">
            <td>
                <a href="${pageContext.servletContext.contextPath}/update?id=${user.id}&name=${user.name}&login=${user.login}&password=${user.password}&email=${user.email}">edit</a>
                <a href="${pageContext.servletContext.contextPath}/delete?id=${user.id}">del</a>
            </td>
            </c:if>
        </tr>
    </c:forEach>
</table>
<a href="${pageContext.servletContext.contextPath}/exit">exit</a>
</body>
</html>
