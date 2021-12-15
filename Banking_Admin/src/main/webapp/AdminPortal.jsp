<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
	<title>Main menu</title>
	<link rel="stylesheet" href="BankingAdmin.css">
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
			<form action = "ViewCustomerprofile" method = "Post">
				<input type = "button" name = "AddCustomer" value = "Add Customer"
					 onclick = "location.href = 'http://localhost:8081/Banking_Admin/AddCustomer.jsp'">
				<input type = "button" name = "UpdateCustomerDetails" value = "Update Customer Details"
					 onclick = "location.href = 'http://localhost:8081/Banking_Admin/UpdateCustomerDetails.jsp'">
				<input type = "button" name = "DeleteCustomer" value = "Delete Customer"
		 			onclick = "location.href = 'http://localhost:8081/Banking_Admin/DeleteCustomer.jsp'">
				<input type = "button" name = "View CustomerProfile" value = "View Customer Profile"
					onclick = "location.href = 'http://localhost:8081/Banking_Admin/CustomerProfile.jsp'">
			</form>
		</div>
	</body>
</html>