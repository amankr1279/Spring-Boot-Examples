<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home</title>
</head>
<body>
    <h2> Home page </h2>
    <form action="addAlien">
        <label for="aid" >Enter ID:</label>
        <input type="text" name="aid"> <br>
        <label for="aname" >Enter name:</label>
        <input type="text" name="aname"> <br>
        <label for="lang" >Enter fav lang:</label>
        <input type="text" name="lang"> 
        <input type="submit" >
    </form>
    <hr>

    <form action="getAlien">
        <label for="aid">Enter ID:</label>
        <input type="text" name="aid">
        <input type="submit" value="Get Info">
    </form>

</body>
</html>