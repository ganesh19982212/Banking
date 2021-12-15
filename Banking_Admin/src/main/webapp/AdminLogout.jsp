<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Admin Logout</title>
	</head>
	<body>
		<%
			response.setHeader("Cache-Control", "no-cache , no-store , must-revalidate");
			if(session.getAttribute("Username") == null)
			{
				response.getWriter().println(""
						+ "<html>"
						+ "	<title>Page Expired</title>"
						+ "		<link rel=\"stylesheet\" href= \"BankingAdmin.css\">"
						+ "		<body>"
						+ "			<div class=\"body\"></div>"
						+ "			<div class=\"grad\"></div>"
						+ "			<div class=\"header\">"
						+ "				<div>Logged<span> out</span></div>"
						+ "			</div>"
						+ "			<div  class = \"logout\"  align = \"right\" style = \"vertical-align: top;\">"
						+ "			<input type = \"button\" name = \"Login\" value = \"Login\" "
						+ "					onclick = \"location.href = 'http://localhost:8081/Banking_Admin/AdminLogin.jsp'\">"
						+ "			</div>"
						+ "			<div  class = \"result\">"
						+ "				Page Expired. Please Login again to continue our Service."
						+ "			</div>"
						+ "		</body>"
						+ "	</html>");
			}
			else
			{
				response.sendRedirect("AdminPortal.jsp");
			}
		%>
	</body>
</html>