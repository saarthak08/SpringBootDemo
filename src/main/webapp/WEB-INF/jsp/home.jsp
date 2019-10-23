<%@ page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC>

<html>
<head>
    <title>Home</title>
</head>

<body>

    <form action="addAlien">
        ID     <input type="text"name="id"> <br><br>
        Name <input type="text" name="name"><br><br>
        Tech <input type="text" name="tech"> <br><br>
        <input type="submit"> <br>
    </form>

    <br><br>
    <hr>
    <form action="getAlien">
        ID     <input type="text"name="id"> <br><br>
        <input type="submit"> <br>
    </form>

</body>
</html>
