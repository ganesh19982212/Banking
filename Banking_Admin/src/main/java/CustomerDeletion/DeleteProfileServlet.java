package CustomerDeletion;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Database.DbConnection;

/**
 * Servlet implementation class DeleteProfileServlet
 */
@WebServlet(name = "DeleteProfile", urlPatterns = { "/DeleteProfile" })
public class DeleteProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletContext servletcontext = getServletContext();
		String AdminName = (String) servletcontext.getAttribute("Username");
		String AccountNo = (String)servletcontext.getAttribute("AccountNumber");
		System.out.println(AccountNo);
		try {
			boolean profileDelete = DeleteProfile(AccountNo);
			if(profileDelete)
			{
				response.getWriter().println(""
						+ "<html>"
						+ "	<title>Profile Deleted</title>"
						+ "		<link rel=\"stylesheet\" href= \"BankingAdmin.css\">"
						+ "		<body>"
						+ "			<div class=\"body\"></div>"
						+ "			<div class=\"grad\"></div>"
						+ "			<div class=\"header\">"
						+ "				<div>Account<span> Deleted</span></div>"
						+ "			</div>"
						+ "			<div  class = \"logout\"  align = \"right\" style = \"vertical-align: top;\">"
						+ "				Welcome "+ AdminName 
						+ "			</div>"
						+ "			<div  class = \"result\">"
						+ "				Customer Profile Deleted.<br>"
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
						+ "	<title>Profile Deleted</title>"
						+ "		<link rel=\"stylesheet\" href= \"BankingAdmin.css\">"
						+ "		<body>"
						+ "			<div class=\"body\"></div>"
						+ "			<div class=\"grad\"></div>"
						+ "			<div class=\"header\">"
						+ "				<div>Account<span> not Deleted</span></div>"
						+ "			</div>"
						+ "			<div  class = \"logout\"  align = \"right\" style = \"vertical-align: top;\">"
						+ "				Welcome "+ AdminName 
						+ "			</div>"
						+ "			<div  class = \"result\">"
						+ "				Customer Profile not Deleted.<br>"
						+ "				<input type=\"button\" value=\"Back\" onclick=\"history.back()\">"			
						+ "			</div>"
						+ "		</body>"
						+ "	</html>");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public boolean DeleteProfile(String AccountNo) throws SQLException
	{
		String dbDriver = "com.mysql.cj.jdbc.Driver";
		DbConnection.LoadDriver(dbDriver);
		Connection con = DbConnection.getConnection();
		String sql = "delete from Register where Account_Number = ?;";
		PreparedStatement ps;
		boolean status = false;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, AccountNo);
			ps.executeUpdate();
			status = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}

}
