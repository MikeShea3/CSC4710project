<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Welcome Page</title>
</head>
<body>
    <div style="text-align: center">
        <h1>Welcome!</h1>
        <b>${user.firstname} (${user.lastname}) (${user.email})</b>
        <br><br>
        <a href="/logout">Logout</a>
    </div>
</body>
</html>