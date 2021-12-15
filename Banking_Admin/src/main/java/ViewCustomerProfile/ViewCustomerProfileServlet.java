package ViewCustomerProfile;

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

/**
 * Servlet implementation class ViewCustomerProfileServlet
 */
@WebServlet(name = "ViewProfile", urlPatterns = { "/ViewProfile" })
public class ViewCustomerProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletContext servletcontext = getServletContext();
		String AdminName = (String)servletcontext.getAttribute("Username");
		String AccountNo = request.getParameter("AccountNumber");
		boolean isAccountValid = IsAccountValid(AccountNo);
		if(isAccountValid)
		{
			try {
				ResultSet rs = myProfile(AccountNo);
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
						+ "				<input type=\"button\" value=\"Back\" onclick=\"history.back()\">"		
						+ "			</div>"
						+ "		</body>"
						+ "	</html>");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			response.getWriter().println(""
					+ "<html>"
					+ "	<title>Registration Failed</title>"
					+ "		<body>"
					+ "			<div align = \"right\" style = \"vertical-align: top;\">"
					+ "				Welcome "+ AdminName +" &emsp;&emsp;"
					+ "			</div>"
					+ "			<div align = \"center\"><br><br>Please Enter valid Account Number<br><br>"
					+ "				<input type=\"button\" value=\"Back\" onclick=\"history.back()\"></div>"
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
	public ResultSet myProfile(String AccountNo) throws SQLException
	{
		String dbDriver = "com.mysql.cj.jdbc.Driver";
		DbConnection.LoadDriver(dbDriver);
		Connection con = DbConnection.getConnection();
		String sql = "select  R.Account_Number , R.Name , R.Gender ,  R.Date ,  R.E_mail , R.MobileNo , A.Amount\r\n"
				+ "	from Register as R left join AmountData as A  on R.Account_Number = A.AccountNumber\r\n"
				+ "    where R.Account_Number = ?;";
		PreparedStatement ps;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, AccountNo);
			rs = ps.executeQuery();
			rs.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

}
