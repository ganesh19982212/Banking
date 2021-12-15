package MyProfile;

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
 * Servlet implementation class MyProfileServlet
 */
@WebServlet(name = "Profile", urlPatterns = { "/Profile" })
public class MyProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletContext servletcontext = getServletContext();
		String Username = (String)servletcontext.getAttribute("Username");
		try {
			ResultSet rs = myProfile(Username);
			response.getWriter().println(""
					+ "<html>"
					+ "	<title>My Profile</title>"
					+ "		<link rel=\"stylesheet\" href= \"BankingUser.css\">"
					+ "		<body>"
					+ "			<div class=\"body\"></div>"
					+ "			<div class=\"grad\"></div>"
					+ "			<div class=\"header\">"
					+ "				<div>My<span> Profile</span></div>"
					+ "			</div>"
					+ "			<div  class = \"logout\"  align = \"right\" style = \"vertical-align: top;\">"
					+ "				Welcome "+ Username 
					+ "			</div>"
					+ "			<div  class = \"result\">"
					+ "				<table> "
					+ "					<tr><td> Account Number</td><td>: " + rs.getString("Account_Number") + "</td></tr>" 
					+ "					<tr><td> Name</td><td>: " + rs.getString("Name") + "</td></tr>"
					+ "					<tr><td> Gender</td><td>: " + rs.getString("Gender") + "</td></tr>"
					+ "					<tr><td> Date</td><td>: " + rs.getDate("Date") + "</td></tr>"
					+ "					<tr><td> E-mail</td><td>: " + rs.getString("E_mail") + "</td></tr>"
					+ "					<tr><td> Mobile Number</td><td>: " + rs.getString("MobileNo") + "</td></tr>"
					+ "					<tr><td> Available Amount</td><td>: " + rs.getLong("Amount") + "</td></tr>"
					+ "				</table>"
					+ "				<input type=\"button\" value=\"Back\" onclick=\"history.back()\">"
					+ "			</div>"
					+ "		</body>"
					+ "	</html>");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.getWriter().println();
		
	}
	public ResultSet myProfile(String UserName) throws SQLException
	{
		String dbDriver = "com.mysql.cj.jdbc.Driver";
		DbConnection.LoadDriver(dbDriver);
		Connection con = DbConnection.getConnection();
		String sql = "select Register.Account_Number , Register.Name , Register.Gender , Register.Date ,"
				+ " Register.E_mail , Register.MobileNo , AmountData.Amount from Register ,"
				+ " AmountData where Register.UserName = ? ";
		PreparedStatement ps;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, UserName);
			rs = ps.executeQuery();
			rs.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

}
