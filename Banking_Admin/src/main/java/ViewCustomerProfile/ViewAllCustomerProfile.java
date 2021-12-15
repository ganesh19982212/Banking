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
 * Servlet implementation class ViewAllCustomerProfile
 */
@WebServlet(name = "ViewAllProfile", urlPatterns = { "/ViewAllProfile" })
public class ViewAllCustomerProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletContext servletcontext = getServletContext();
		String AdminName = (String) servletcontext.getAttribute("Username");
		try {
			ResultSet rs = ViewAllProfile();
			response.getWriter().println(""
					+ "<html>"
					+ "	<title>Customer Profile</title>"
					+ "		<link rel=\"stylesheet\" href= \"BankingAdmin.css\">"
					+ "		<body>"
					+ "			<div class=\"body\"></div>"
					+ "			<div class=\"grad\"></div>"
					+ "			<div class=\"Profile\">"
					+ "				<div>All<span> Profiles</span></div>"
					+ "			</div>"
					+ "			<div  class = \"logout\"  align = \"right\" style = \"vertical-align: top;\">"
					+ "				Welcome "+ AdminName
					+ "			</div>"
					+ "			<div  class = \"profileAll\">"
					+ "				<table border=1 >"
					+ "					<tr><th>Username</th>"
					+ "					<th>Account Number</th>"
					+ "					<th>Name</th>"
					+ "					<th>Gender</th>"
					+ "					<th>Date</th>"
					+ "					<th>E-mail</th>"
					+ "					<th>Mobile Number</th>"
					+ "					<th>Password</th>"
					+ "					<th>Amount</th></tr>");
			while(rs.next())
			{
				response.getWriter().println(""
					+ "					<tr><td> " +rs.getString("UserName") + "</td>"
					+ "					<td>" + rs.getString("Account_Number") + "</td>"
					+ "					<td>" + rs.getString("Name") + "</td>"
					+ "					<td>" + rs.getString("Gender") + "</td>"
					+ "					<td>" + rs.getDate("Date") + "</td>"
					+ "					<td>" + rs.getString("E_mail") + "</td>"
					+ "					<td>" + rs.getString("MobileNo") + "</td>"
					+ "					<td>" + rs.getString("Password") + "</td>"
					+ "					<td>" + rs.getLong("Amount") + "</td></tr>");
			}
			response.getWriter().println(""
					+ "				</table><br>"
					+ "				<div style=\"position: absolute; left: 300px;\">"
					+ "					<input type=\"button\" value=\"Back\" onclick=\"history.back()\">"
					+ "				</div>"
					+ "			</div>"
					+ "		</body>"
					+ "	</html");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ResultSet ViewAllProfile() throws SQLException
	{
		String dbDriver = "com.mysql.cj.jdbc.Driver";
		DbConnection.LoadDriver(dbDriver);
		Connection con = DbConnection.getConnection();
		String sql = "select R.UserName , R.Account_Number , R.Name , R.Gender ,  R.Date ,  R.E_mail , R.MobileNo ,"
				+ " R.Password , A.Amount from Register as R left join AmountData as A  on R.Account_Number = A.AccountNumber;";
		PreparedStatement ps;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			//String Acc = rs.getString("Account_Number");
			//System.out.println(Acc);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

}
