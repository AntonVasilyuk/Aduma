<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User storage</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <style>
        <%@include file="/WEB-INF/css/crudCSS.css"%>
        table {
            width: 100%; /* Ширина таблицы */
            border-collapse: collapse; /* Убираем двойные линии */
            text-align: center;
        }
        thead {
            background: #00b4ef; /* Цвет фона заголовка */
        }
        td, th {
            padding: 5px; /* Поля в ячейках */
            border: 1px solid #333; /* Параметры рамки */
        }
        tbody {
            background-color: gainsboro;
            color: #333333;
            align-items: center;
        }
        tbody tr:nth-child(even) {
            background: #f0f0f0; /* Зебра */
        }
        @-webkit-keyframes AnimationName {
            0%{
                background-position:0% 31%
            }
            50%{
                background-position:100% 70%
            }
            100%{
                background-position:0% 31%
            }
        }
        @-moz-keyframes AnimationName {
            0%{
                background-position:0% 31%
            }
            50%{
                background-position:100% 70%
            }
            100%{
                background-position:0% 31%
            }
        }
        @keyframes AnimationName {
            0%{
                background-position:0% 31%
            }
            50%{
                background-position:100% 70%
            }
            100%{
                background-position:0% 31%
            }
        }
        .elements-page-btn .btn {
            margin: 6px 3px;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-offset-3 col-md-6">
            <div class="form-horizontal">
                <span class="heading">Storage for users</span>
                <c:if test="${sessionScope.get('role') == 'admin'}">
                    <div class="element-center">
                        <form action="${pageContext.servletContext.contextPath}/create">
                            <div class="form-group">
                                <button type="submit" class="btn btn-default">New user</button>
                            </div>
                        </form>
                    </div>
                </c:if>
                <div class="table-bordered">
                    <table border="1">
                        <thead>
                        <tr>
                            <th>ID</th>
                            <th>NAME</th>
                            <th>LOGIN</th>
                            <th>EMAIL</th>
                            <th>COUNTRY</th>
                            <th>CITY</th>
                            <c:if test="${sessionScope.get('role') == 'admin'}">
                                <th>EDIT USER</th>
                                <th>DELETE USER</th>
                            </c:if>
                        </tr>
                        </thead>
                        <c:forEach items="${users}" var="user" varStatus="status">
                            <tbody>
                            <tr>
                                <td><c:out value="${user.id}"></c:out></td>
                                <td><c:out value="${user.name}"></c:out></td>
                                <td><c:out value="${user.login}"></c:out></td>
                                <td><c:out value="${user.email}"></c:out></td>
                                <td><c:out value="${user.country}"></c:out></td>
                                <td><c:out value="${user.city}"></c:out></td>
                                <c:if test="${sessionScope.get('role') == 'admin'}">
                                    <td>
                                        <a href="${pageContext.servletContext.contextPath}/update?id=${user.id}
                                        &name=${user.name}&login=${user.login}&password=${user.password}
                                        &email=${user.email}">edit</a>
                                    </td>
                                    <td>
                                        <a href="${pageContext.servletContext.contextPath}/delete?id=${user.id}">del</a>
                                    </td>
                                </c:if>
                            </tr>
                            </tbody>
                        </c:forEach>
                    </table>
                    <form action="${pageContext.servletContext.contextPath}/exit">
                        <div class="form-group">
                            <button type="submit" class="btn btn-default">Exit</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div><!-- /.row -->
</div><!-- /.container -->
</body>
</html>
