<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Page 1</title>
</head>
<body>
    <h1>Page 1</h1>
    <form action="/addition1" method="post">
        <label for="num1">Number 1:</label>
        <input type="text" id="num1" name="num1" required>
        <br>
        <label for="num2">Number 2:</label>
        <input type="text" id="num2" name="num2" required>
        <br>
        <button type="submit">Add Numbers</button>
    </form>
    <br>
    <a href="/">Home</a><br/>
    <a href="/addition2">Go to Page 2</a>
</body>
</html>
