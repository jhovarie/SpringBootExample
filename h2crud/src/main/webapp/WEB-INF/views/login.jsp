<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            // Event listener for the login button
            $("#loginBtn").click(function () {
                // Perform login validation (you can replace this with your own logic)
                var username = $("#usernameInput").val();
                var password = $("#passwordInput").val();

                if (username === "barik" && password === "barik") {
                    // Redirect to the dashboard on successful login
                    window.location.href = "/productmanagement";
                } else {
                    // Display an error message (you can replace this with your own error handling)
                    $("#errorMessage").text("Invalid username or password");
                }
            });
        });
    </script>
</head>
<body>
    <h2>Login Page</h2>
    <div>
        <label>Username:</label>
        <input type="text" id="usernameInput">
    </div>
    <div>
        <label>Password:</label>
        <input type="password" id="passwordInput">
    </div>
    <button id="loginBtn">Login</button>
    <p id="errorMessage" style="color: red;"></p>
</body>
</html>
