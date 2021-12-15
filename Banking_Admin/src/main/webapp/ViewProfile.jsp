<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>	
		<meta charset="ISO-8859-1">	
		<title>Profile View</title>
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
			<div>View<span> Profile</span></div>
		</div>
		<div  class = "logout"  align = "right" style = "vertical-align: top;">
			<form action="Logout" method = "Post">				
				Welcome ${Username}&emsp; <input type = "submit" name = "Logout" value = "Logout">
			</form>
		</div>
		<div  class = "Transfer">
			<form action = "ViewProfile" method = "Post">
				<input type = "number" id = "AccountNumber" name = "AccountNumber" placeholder = "Account Number" required/>
				<input type="button" value="Back" onclick="history.back()">
				<input type = "submit" value =  "View Profile" />
			</form>
		</div>
	</body>
</html>