<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Update</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script type="text/javascript">
        <%@include file="/WEB-INF/js/crudJS.js"%>
    </script>
    <script type="text/javascript">
        $(document).ready(getCountry());
    </script>
    <style>
        <%@include file="/WEB-INF/css/crudCSS.css"%>
    </style>
</head>
<body>
    <div class="container">
        <div class="row">
            <div class="col-md-offset-3 col-md-6">
                <form class="form-horizontal" action="${pageContext.servletContext.contextPath}/update" method="post">
                    <span class="heading">Update user</span>
                    <div class="form-group">
                        <input type="hidden" class="form-control" name="id" id="id" value="${id}">
                    </div>
                    <div class="form-group">
                        <input type="text" class="form-control" name="name" id="name" placeholder="enter your name">
                    </div>
                    <div class="form-group">
                        <input type="text" class="form-control" name="login" id="login" placeholder="enter your login">
                    </div>
                    <div class="form-group">
                        <input type="password" class="form-control" name="password" id="password" placeholder="enter your password">
                    </div>
                    <div class="form-group">
                        <input type="email" class="form-control" name="email" id="email" placeholder="enter your email">
                    </div>
                    <div class="form-group">
                        <select class="form-control" id="country" name="country" onchange="getCity()" required>
                            <option disabled>Country</option>
                            <option value="USA">USA</option>
                            <option value="RUSSIA">RUSSIA</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <select class="form-control" id="city" name="city" required>
                            <option disabled>City</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="role">Role:</label>
                        <select class="form-control" id="role" name="role">
                            <option>admin</option>
                            <option>user</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <button type="submit" class="btn btn-default" onclick="return validate()">ENTER</button>
                    </div>
                </form>
                <div class="form-group">
                    <form action="${pageContext.servletContext.contextPath}/" method="get">
                        <button type="submit" class="btn btn-default">BACK</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
