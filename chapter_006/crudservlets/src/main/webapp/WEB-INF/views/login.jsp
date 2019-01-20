<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Authorisation page</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" />
    <link rel="${pageContext.servletContext.contextPath}.crudCSS.css">
    <style>
        <%@include file="/WEB-INF/css/crudCSS.css"%>
    </style>
</head>
<body>
    <div class="container">
        <div class="row">
            <div class="col-md-offset-3 col-md-6">
                <form class="form-horizontal" action="${pageContext.servletContext.contextPath}/signin" method="post">
                    <span class="heading">Autorization</span>
                    <div class="form-group">
                        <input type="text" class="form-control" name="login" placeholder="enter your email">
                        <i class="fa fa-user"></i>
                    </div>
                    <div class="form-group">
                        <input type="password" class="form-control" name="password" placeholder="enter your password">
                        <i class="fa fa-lock"></i>
                    </div>
                    <div class="form-group">
                        <button type="submit" class="btn btn-default">ENTER</button>
                    </div>
                </form>
            </div>

        </div><!-- /.row -->
    </div><!-- /.container -->
</body>
</html>

