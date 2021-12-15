<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Account Login</title>
		<link rel="stylesheet" href="BankingUser.css">
	</head>
	<body>
		<%
			response.setHeader("Cache-Control", "no-cache , no-store , must-revalidate");
		%>
		<div class="body"></div>
		<div class="grad"></div>
		<div class="header">
			<div>Personal<span> Banking</span></div>
		</div>
		<br>
		<div class="login">
			<form action = "Login" method = "post">
				<input type = "text" id = "Username" name = "Username" placeholder="Username" required>
				<input type = "Password" id = "Password" name = "Password" placeholder = "Password" required>
				<input type = "submit" value = "Login">
			</form>
		</div>
	</body>
</html>