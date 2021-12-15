package CustomerDeletion;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Database.DbConnection;
import ViewCustomerProfile.ViewCustomerProfileServlet;

/**
 * Servlet implementation class DeleteProfileServlet
 */
@WebServlet(name = "ViewBeforeDelete", urlPatterns = { "/ViewBeforeDelete" })
public class ViewProfileBeforeDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String AccountNo = request.getParameter("AccountNumber");
		ServletContext servletcontext = getServletContext();
		servletcontext.setAttribute("AccountNumber", AccountNo);
		String AdminName = (String)servletcontext.getAttribute("Username");
		ViewCustomerProfileServlet vp = new ViewCustomerProfileServlet();
		boolean isAccountValid = IsAccountValid(AccountNo);
		if(isAccountValid)
		{
			try {
				ResultSet rs = vp.myProfile(AccountNo);
				response.getWriter().println(""
						+ "<html>"
						+ "	<title>Customer Profile</title>"
						+ "		<link rel=\"stylesheet\" href= \"BankingAdmin.css\">"
						+ "		<body>"
						+ "			<div class=\"body\"></div>"
						+ "			<div class=\"grad\"></div>"
						+ "			<div class=\"header\">"
						+ "				<div>Customer<span> Profile</span></div>"
						+ "			</div>"
						+ "			<div  class = \"logout\"  align = \"right\" style = \"vertical-align: top;\">"
						+ "				Welcome "+ AdminName 
						+ "			</div>"
						+ "			<div  class = \"Transfer\">"
						+ "				<table> "
						+ "					<tr><td> Account Number : </td><td>" + rs.getString("Account_Number") + "</td></tr>" 
						+ "					<tr><td> Name : </td><td>" + rs.getString("Name") + "</td></tr>"
						+ "					<tr><td> Gender : </td><td>" + rs.getString("Gender") + "</td></tr>"
						+ "					<tr><td> Date : </td><td>" + rs.getDate("Date") + "</td></tr>"
						+ "					<tr><td> E-mail : </td><td>" + rs.getString("E_mail") + "</td></tr>"
						+ "					<tr><td> Mobile Number : </td><td>" + rs.getString("MobileNo") + "</td></tr>"
						+ "					<tr><td> Available Amount : </td><td>" + rs.getLong("Amount") + "</td></tr>"
						+ "				</table>"
						+ "				<form action = \"DeleteProfile\" method = \"Post\">"
						+ "					<input type=\"button\" value=\"Back\" onclick=\"history.back()\">&emsp;&emsp; "
						+ "					<input type=\"submit\" value=\"Delete\">"
						+ "				</form>"		
						+ "			</div>"
						+ "		</body>"
						+ "	</html>");
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		else
		{
			response.getWriter().println(""
					+ "<html>"
					+ "	<title>Invalid Account</title>"
					+ "		<link rel=\"stylesheet\" href= \"BankingAdmin.css\">"
					+ "		<body>"
					+ "			<div class=\"body\"></div>"
					+ "			<div class=\"grad\"></div>"
					+ "			<div class=\"header\">"
					+ "				<div>Account<span> not Valid</span></div>"
					+ "			</div>"
					+ "			<div  class = \"logout\"  align = \"right\" style = \"vertical-align: top;\">"
					+ "				Welcome "+ AdminName 
					+ "			</div>"
					+ "			<div  class = \"result\">"
					+ "				Please Enter Valid Account and try again.<br>"
					+ "				<input type=\"button\" value=\"Back\" onclick=\"history.back()\">"			
					+ "			</div>"
					+ "		</body>"
					+ "	</html>");			
		}
	}
	public boolean IsAccountValid(String account) {
		// TODO Auto-generated method stub
		String dbDriver = "com.mysql.cj.jdbc.Driver";
		DbConnection.LoadDriver(dbDriver);
		Connection con = DbConnection.getConnection();
		boolean status = false;
		String sql = "Select AmountData.AccountNumber from AmountData where AmountData.AccountNumber = ?"; 
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, account);
			ResultSet rs = ps.executeQuery();
			status = rs.next();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}
}
