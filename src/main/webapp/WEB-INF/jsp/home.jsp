<%@ page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC>

<html>
<head>
    <title>Home</title>
</head>

<body>
    <h3>Add Data/Alien</h3>
    <h4>${mess}</h4>
    <form action="addAlien">
        ID     <input type="text"name="id"> <br><br>
        Name <input type="text" name="name"><br><br>
        Tech <input type="text" name="tech"> <br><br>
        <input type="submit"> <br>
    </form>

    <br><br>
    <hr>
    <h3>Get Alien</h3>
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
        <p>Updates</p>
        Name <input type="text" name="name"><br><br>
        Tech <input type="text" name="tech"> <br><br>
        <input type="submit"> <br>
    </form>
    <br><br>
    <hr>
    <h3>Get Alien in XML</h3>
    <form action="getAlienXML">
        ID     <input type="text"name="id"> <br><br>
        <input type="submit"> <br>
    </form>
    <br><br>
    <hr>
    <h3>Get Aliens Sorted for a specific tech</h3>
    <form action="aliensSorted" method="get">
        Tech <input type="text" name="type"> <br><br>
        <input type="submit"> <br>
    </form>
    <br><br><br>
    <hr>
    <a class="button" href="aliens">Get All Aliens</a>

</body>
</html>
