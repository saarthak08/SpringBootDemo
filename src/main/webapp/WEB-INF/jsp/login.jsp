<%--
  Created by IntelliJ IDEA.
  User: saarthak08
  Date: 02/11/19
  Time: 12:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <h1>Login</h1>
    ${SPRING_SECURITY_LAST_EXCEPTION.message}
    <form action="login" method="POST">
        <table>
            <tr>
                <td>User:</td>
                <td><input type="text" name="username"></td>
            </tr>
            <tr>
                <td>Password::</td>
                <td><input type="text" name="password"></td>
            </tr>
            <tr>
                <td><input type="submit" name="submit"></td>
            </tr>
        </table>
    </form>
</body>
</html>
