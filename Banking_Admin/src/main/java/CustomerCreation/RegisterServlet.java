package CustomerCreation;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Database.DbConnection;
import DatabaseEntry.DatabaseEntry;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet(name = "Register", urlPatterns = { "/Register" })
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		ServletContext servletcontext = getServletContext();
		String AdminName = (String)servletcontext.getAttribute("Username");
		String UserName = request.getParameter("Username");
		String Account_Number = request.getParameter("Account_Number").toString();
		String Name = request.getParameter("Name").toString();
		String gender = request.getParameter("gender").toString();
		String DOB = request.getParameter("DOB");
		String Email = request.getParameter("E-Mail").toLowerCase().toString();
	    String mobileNo = request.getParameter("MobileNumber").toString();
	    long Amount = Long.parseLong(request.getParameter("Amount"));
	    String Password = request.getParameter("Password");
	    //System.out.println(DOB);
	    java.sql.Date date = java.sql.Date.valueOf(DOB);
		DbConnection db = new DbConnection();
		DatabaseEntry de = new DatabaseEntry();
		de.setRusername(UserName);
		de.setAccount_number(Account_Number); 
		de.setName(Name);
		de.setGender(gender);
		de.setDate(date);
		de.setEMail(Email);
		de.setMobileNo(mobileNo);
		de.setAmount(Amount);
		de.setRPassword(Password);
		boolean Register = db.Insert(de);
		if(Register)
		{
			response.getWriter().println(""
					+ "<html>"
					+ "	<title>Registered</title>"
					+ "		<link rel=\"stylesheet\" href= \"BankingAdmin.css\">"
					+ "		<body>"
					+ "			<div class=\"body\"></div>"
					+ "			<div class=\"grad\"></div>"
					+ "			<div class=\"header\">"
					+ "				<div>Account<span> Added</span></div>"
					+ "			</div>"
					+ "			<div  class = \"logout\"  align = \"right\" style = \"vertical-align: top;\">"
					+ "				Welcome "+ AdminName 
					+ "			</div>"
					+ "			<div  class = \"result\">"
					+ "				Successfully Registered.<br>"
					+ "				<input type=\"button\" value=\"Back\"  onclick =" 
					+ " 				 \"location.href = 'http://localhost:8081/Banking_Admin/AdminPortal.jsp'\">"		
					+ "			</div>"
					+ "		</body>"
					+ "	</html>");
		}
		else
		{
			response.getWriter().println(""
					+ "<html>"
					+ "	<title>Registered</title>"
					+ "		<link rel=\"stylesheet\" href= \"BankingAdmin.css\">"
					+ "		<body>"
					+ "			<div class=\"body\"></div>"
					+ "			<div class=\"grad\"></div>"
					+ "			<div class=\"header\">"
					+ "				<div>Account<span> not Created</span></div>"
					+ "			</div>"
					+ "			<div  class = \"logout\"  align = \"right\" style = \"vertical-align: top;\">"
					+ "				Welcome "+ AdminName 
					+ "			</div>"
					+ "			<div  class = \"result\">"
					+ "				Registration Failed<br>"
					+ "				Enter Unique UserName and Account Number<br>"
					+ "				<input type=\"button\" value=\"Back\" onclick=\"history.back()\">"		
					+ "			</div>"
					+ "		</body>"
					+ "	</html>");
		}
	}

}
