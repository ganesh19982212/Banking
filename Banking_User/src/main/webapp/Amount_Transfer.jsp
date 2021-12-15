<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Transfer Amount</title>
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
			<div>Transfer<span> Amount</span></div>
		</div>
		<div  class = "logout"  align = "right" style = "vertical-align: top;">
			<form action = "Logout" method = "Post">
				Welcome ${Username}&emsp;<input type = "submit" name = "Logout" value = "Logout">

			</form>
		</div>
		<div class = "Transfer">
			<form Action = "Transfer" Method = "post">
				<input type = "number" name = "Account" id = "Account" Placeholder = " Reciever Account Number" required>
				<input type = "number" name = "Amount" id = "Amount" placeholder = "Amount" required>
				<input type= "button" value= "Back" onclick= "history.back()">
				<input type = "submit" value = "Transfer">	
			</form>
		</div>
	</body>
</html>