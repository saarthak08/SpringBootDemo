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

    <br><br>
    <hr>
    <h4>${message}</h4>
    <h3>Update Alien</h3>
    <form action="updateAlien" method="post">
        Original ID of the data    <input type="text"name="id"> <br><br>
        <hr>
        <p>Updates</p>
        Name <input type="text" name="name"><br><br>
        Tech <input type="text" name="tech"> <br><br>
        <input type="submit"> <br>
    </form>
</body>
</html>
