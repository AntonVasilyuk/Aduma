<%@ page import="ru.job4j.LayoutPersistent.User" %>
<%@ page import="ru.job4j.LayoutLogic.ValidateService" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="<%request.getContextPath();%>/list" method="post">
        <table style="border: black" cellpadding="1" cellspacing="1" border="1">
            <tr>
                <th>id</th>
                <th>name</th>
                <th>login</th>
                <th>email</th>
                <th>button</th>
                <th>button</th>
            </tr>
            <% for(User user : ValidateService.getInstance().getListStorage()) {%>
            <tr>
                <td><%=user.getId()%></td>
                <td><%=user.getName()%></td>
                <td><%=user.getLogin()%></td>
                <td><%=user.getEmail()%></td>
                <td><button type="button">edit</button> </td>
                <td><button type="button">delete</button> </td>
            </tr>
            <%}%>
        </table>
    </form>
</body>
</html>
