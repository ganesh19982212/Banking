<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Main Menu</title>
<link rel="stylesheet" href="BankingUser.css">
</head>
<body>
	<%
		response.setHeader("Cache-Control", "no-cache , no-store , must-revalidate");
		if(session.getAttribute("Username") == null)
		{
			response.sendRedirect("AccountLogin.jsp");
		}
	%>
	<div class="body"></div>
		<div class="grad"></div>
		<div class="header">
			<div>Choose<span> Operation</span></div>
		</div>
		<div  class = "logout"  align = "right" style = "vertical-align: top;">
			<form action = "Logout" method = "Post">
				Welcome ${Username}&emsp;<input type = "submit" name = "Logout" value = "Logout">

			</form>
		</div>
	<div  class = "MainMenu" >
		<form action = "Profile" method = "post">
			<input type = "submit" name = "Profile" value = "Profile">
			<input type = "button" name = "Transfer" value = "Transfer"
				 onclick = "location.href = 'http://localhost:8081/Banking_User/Amount_Transfer.jsp'">
		</form>
	</div>
</body>
</html>