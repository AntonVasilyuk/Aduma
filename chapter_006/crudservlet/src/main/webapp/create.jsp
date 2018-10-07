
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="<%request.getContextPath();%>/create" method="post">
        Name : <input type="text" name="name"/>
        Login : <input type="text" name="login"/>
        Email : <input type="text" name="email">
        <input type="submit">
    </form>
</body>
</html>