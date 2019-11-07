<%--
  Created by IntelliJ IDEA.
  User: saarthak08
  Date: 07/11/19
  Time: 10:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
${SPRING_SECURITY_LAST_EXCEPTION.message}<br>
${message}
    <form action="check" method="POST">
    <table>
        <tr>
            <td>Name:</td>
            <td><input type="text" name="username" required></td>
        </tr>
        <tr>
            <td>Email:</td>
            <td><input type="text" name="email"required></td>
        </tr>
        <tr>
            <td>Password::</td>
            <td><input type="password" name="password" required></td>
        </tr>
        <tr>
            <td><input type="submit" name="submit"></td>
        </tr>
    </table>
    </form>
<br>
<br>
<a href="/login/">Sign in</a>
</body>
</html>
