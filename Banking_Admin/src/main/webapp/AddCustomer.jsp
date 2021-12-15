<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>Add Customer</title>
	<link rel="stylesheet" href= "BankingAdmin.css" >
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
			<div>Add<span> Customer</span></div>
		</div>
		<div  class = "logout"  align = "right" style = "vertical-align: top;">
			<form action="Logout" method = "Post">				
				Welcome ${Username}&emsp; <input type = "submit" name = "Logout" value = "Logout">
			</form>
		</div>
		<div  class = "result">
			<form action = "Register" method = "post">
				<table>
					<tr>
						<td><input type = "text" name = "Username" id = "Username" placeholder = "Username" required></td>
					</tr>
					<tr>
						<td>
							<input type = "tel" name = "Account_Number" id = "Account" placeholder = "Account Number"
									pattern="[3106]{4}[16]{2}[205]{3}[0-9]{3}" title="Format : 310616205(0-9)(0-9)(0-9)" required>
						</td>
					</tr>
					<tr>
						<td><input type = "text" name = "Name" id = "Name" placeholder = "Name" required></td>
					</tr>
					<tr>
						<td>
							<div class="CreditDebit">
								<label id = "MaleLabel"  for = "Male">
								<input type = "radio"  name = "gender"  value = "Male" id = "Male" required>
								<span>Male</span></label>
								<label id = "FemaleLabel"  for = "Female" >
								<input type = "radio" name = "gender"  value = "Female" id= "Female" required>
								<span>Female</span></label>
							</div>
						</td>
					</tr>
					<tr>
						<td><input type = "date" name = "DOB" id = "DOB" title="Date of Birth" required></td>
					</tr>
					<tr>
						<td><input type = "email" name = "E-Mail" id = "Email" placeholder = "example123@gmail.com"
								title="Please Enter a valid Email Address" required></td>
					</tr>
					<tr>
						<td><input type = "tel" name = "MobileNumber" id = "MobileNo" placeholder = "9876543210"
								 pattern="[7-9]{1}[0-9]{9}" title="Indian phone Numbers only allowed" required></td>
					</tr>
					<tr>
						<td><input type = "number" name = "Amount" id = "Amount" Placeholder = "Amount 00.00" required></td>
					</tr>
					<tr>
						<td>
							<input type = "password" name = "Password" id = "Password"
								pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])\S{8,}" 
								title="Minimum one Capital letter , Small Letter and Number" placeholder = "Password" required>
						</td>
					</tr>
					<tr>
						<td>
							<input type="button" value="Back" onclick="history.back()">
		 					<input type = "submit" value = "Register">
							
						</td>
					</tr>
				</table>
					
			</form>
		</div>
	</body>
</html>