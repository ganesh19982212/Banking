<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Customer Profile</title>
		<link rel="stylesheet" href= "BankingAdmin.css">
	</head>
	<body>
		<%
			response.setHeader("Cache-Control", "no-cache , no-store , must-revalidate");
			if(session.getAttribute("Username") == null)
			{
				response.sendRedirect("AdminLogin.jsp");
			}
		%>
		<div class="body"></div>
		<div class="grad"></div>
		<div class="header">
			<div>Choose<span> Operation</span></div>
		</div>
		<div  class = "logout"  align = "right" style = "vertical-align: top;">
			<form action="Logout" method = "Post">				
				Welcome ${Username}&emsp; <input type = "submit" name = "Logout" value = "Logout">
			</form>
		</div>
		<div  class = "MainMenu">
			<input type = "button" name = "View customer" value = "View Profile"
								 onclick = "location.href = 'http://localhost:8081/Banking_Admin/ViewProfile.jsp'">
			<form action = "ViewAllProfile" method = "Post">
					<input type = "submit" name = "View customer" value = "View All profile">
			</form>
				<input type="button" value="Back" onclick="history.back()">
		</div>
	</body>
</html>