<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Update Customer Details</title>
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
			<div>Update<span> Details</span></div>
		</div>
		<div  class = "logout"  align = "right" style = "vertical-align: top;">
			<form action="Logout" method = "Post">				
				Welcome ${Username}&emsp; <input type = "submit" name = "Logout" value = "Logout">
			</form>
		</div>
		<div  class = "result">
			<form action="UpdateCustomer" method = "Post">
			<table>
				<tr>
					
					<td><input type="number" style="position:relative;left:15px;" name="AccountNumber" placeholder="Account Number" id = "Account Number" required /></td>
				</tr>
				<tr>
					<td>
						<input type="checkbox" name="checkbox1" id="checkboxOne" onclick="enableDisableAll();" />
						<input type="text" name="Name" placeholder="Name" id = "Name" disabled  required/></td>
				</tr>
				<tr>
					<td>
						<input type="checkbox" name="checkbox2" id="checkboxTwo" onclick="enableDisableAll();" />
						<input type="date"  name="DOB" placeholder="DD-MM-YYYY" id = "DOB" disabled  required/>
					</td>
				</tr>
				<tr>
					<td>
						<input type="checkbox" name="checkbox3" id="checkboxThree" onclick="enableDisableAll();" />
						<input type = "email"  name = "E-Mail" id = "Email" placeholder = "example123@gmail.com"
								title="Please Enter a valid Email Address" disabled required>
					</td>
				</tr>
				<tr>
					<td>
						<input type="checkbox" name="checkbox4" id="checkboxFour" onclick="enableDisableAll();" />				
						<input type = "tel" name = "MobileNumber" id = "MobileNo" placeholder = "9876543210"
								 pattern="[7-9]{1}[0-9]{9}" title="Indian phone Numbers only allowed" disabled required />
					</td>
				</tr>
				<tr>
					<td>
						<input type="checkbox" name="checkbox5" id="checkboxFive" onclick="enableDisableAll();display();" />
						<input type="number" name="Amount" placeholder="Amount" 
							id = "Amount" disabled  required/>
					</td>
				</tr>
				<tr>
					<td>
						<div class = "CreditDebit" style="position:relative;left:22px;">
							<label id = "DebitLabel"  for = "Debit" style="display:none">
						<input type = "radio"  name = "Transaction"  value = "Debit" id = "Debit"  disabled required>
						<span>Debit</span></label>
						<label id = "CreditLabel"  for = "Credit" style="display:none">
						<input type = "radio" name = "Transaction"  value = "Credit" id= "Credit"  disabled required>
						<span>Credit</span></label>
						</div>
					</td>
				</tr>
				<tr>
					<td>
						<div style="position:relative;padding-left:24px;">
							
								<input type="button" value="Back" onclick="history.back()">
								<input type = "submit" name = "Update" value = "Update" />	
						</div>
					</td>
					
				</tr>
			</table>
			</form>
			<script>
				function display() 
				{
				  var AmountCheckbox = document.getElementById("checkboxFive");
				  var CreditLabel = document.getElementById("CreditLabel");
				  var DebitLabel = document.getElementById("DebitLabel");
				  if (AmountCheckbox.checked == true){
    			    CreditLabel.style.display = "block";
    			    DebitLabel.style.display = "block";
  				  }
  				  else {
    			    CreditLabel.style.display = "none";
    			    DebitLabel.style.display = "none";
  				  }
  				}	
  				function enableDisableAll() {
					var NameCheckbox = document.getElementById("checkboxOne").checked;
  					var DOBCheckbox = document.getElementById("checkboxTwo").checked;
  					var EmailCheckbox = document.getElementById("checkboxThree").checked;
 	 				var MobileNoCheckbox = document.getElementById("checkboxFour").checked;
 	 				var AmountCheckbox = document.getElementById("checkboxFive").checked;
				    document.getElementById('Name').disabled = !NameCheckbox;
				 	document.getElementById('DOB').disabled = !DOBCheckbox;
			   		document.getElementById('Email').disabled = !EmailCheckbox;
			   		document.getElementById('MobileNo').disabled = !MobileNoCheckbox;
				    document.getElementById('Amount').disabled = !AmountCheckbox;
			    	document.getElementById('Credit').disabled = !AmountCheckbox;
			    	document.getElementById('Debit').disabled = !AmountCheckbox;
				}
			</script>
		</div>
	</body>
</html>