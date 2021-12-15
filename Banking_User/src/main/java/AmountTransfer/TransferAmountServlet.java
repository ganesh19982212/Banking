package AmountTransfer;

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
 * Servlet implementation class TransferAmountServlet
 */
@WebServlet(name = "Transfer", urlPatterns = { "/Transfer" })
public class TransferAmountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletContext servletcontext = getServletContext();
		String Username = (String)servletcontext.getAttribute("Username");
		String Account1 = getAccountNumber(Username);
		String Account2 = request.getParameter("Account").toString();
		long Amount = Long.parseLong(request.getParameter("Amount"));
		if(!Account1.equals(Account2))
		{
			if(IsAccountValid(Account2))
			{
				if(IsAmountValid(Account1 , Amount))
				{
					try {
						long balance = Amount_Transfer(Account1 , Account2 , Amount);
						response.getWriter().println(""
								+ "<html>"
								+ "	<title>Transferred</title>"
								+ "		<link rel=\"stylesheet\" href= \"BankingUser.css\">"
								+ "		<body>"
								+ "			<div class=\"body\"></div>"
								+ "			<div class=\"grad\"></div>"
								+ "			<div class=\"header\">"
								+ "				<div>Transfer<span> Success</span></div>"
								+ "			</div>"
								+ "			<div  class = \"logout\"  align = \"right\" style = \"vertical-align: top;\">"
								+ "				Welcome "+ Username 
								+ "			</div>"
								+ "			<div  class = \"result\">"
								+ "				Amount Successfully Transferred.<br>"
								+ "				Amount Transferred from <span style=\"color:Black;\">" + Account1 + "</span>"
								+ " 			to this <span style=\"color:Black;\">" + Account2 + "</span>.<br>"
								+ "				Your Available Balance is : <span style=\"color:Black;\">" + balance + "</span>."
								+ "				<br><input type=\"button\" value=\"Back\"  onclick =" 
								+ " 				 \"location.href = 'http://localhost:8081/Banking_User/Main_menu.jsp'\">"
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
							+ "	<title>Insufficient Balance</title>"
							+ "		<link rel=\"stylesheet\" href= \"BankingUser.css\">"
							+ "		<body>"
							+ "			<div class=\"body\"></div>"
							+ "			<div class=\"grad\"></div>"
							+ "			<div class=\"header\">"
							+ "				<div>Transfer<span> Failed</span></div>"
							+ "			</div>"
							+ "			<div  class = \"logout\"  align = \"right\" style = \"vertical-align: top;\">"
							+ "				Welcome "+ Username 
							+ "			</div>"
							+ "			<div  class = \"result\">"
							+ " 			Enter Valid Amount. You do not have Enough Balance.<br>"
							+ "				<input type=\"button\" value=\"Back\" onclick=\"history.back()\">"
							+ "			</div>"
							+ "		</body>"
							+ "	</html>");
				}
			}
			else
			{
				response.getWriter().println(""
						+ "<html>"
						+ "	<title>Invalid Account</title>"
						+ "		<link rel=\"stylesheet\" href= \"BankingUser.css\">"
						+ "		<body>"
						+ "			<div class=\"body\"></div>"
						+ "			<div class=\"grad\"></div>"
						+ "			<div class=\"header\">"
						+ "				<div>Account <span>not Found</span></div>"
						+ "			</div>"
						+ "			<div  class = \"logout\"  align = \"right\" style = \"vertical-align: top;\">"
						+ "				Welcome "+ Username 
						+ "			</div>"
						+ "			<div  class = \"result\">"
						+ " 			Enter Valid Account Number.<br>"
						+ "				<input type=\"button\" value=\"Back\" onclick=\"history.back()\">"
						+ "			</div>"
						+ "		</body>"
						+ "	</html>");
			}
		}
		else
		{
			response.getWriter().println(""
					+ "<html>"
					+ "	<title>Invalid Account</title>"
					+ "		<link rel=\"stylesheet\" href= \"BankingUser.css\">"
					+ "		<body>"
					+ "			<div class=\"body\"></div>"
					+ "			<div class=\"grad\"></div>"
					+ "			<div class=\"header\">"
					+ "				<div>Need Valid<span> Account</span></div>"
					+ "			</div>"
					+ "			<div  class = \"logout\"  align = \"right\" style = \"vertical-align: top;\">"
					+ "				Welcome "+ Username 
					+ "			</div>"
					+ "			<div  class = \"result\">"
					+ " 			Enter Receiver Account Number.<br>"
					+ "				<input type=\"button\" value=\"Back\" onclick=\"history.back()\">"
					+ "			</div>"
					+ "		</body>"
					+ "	</html>");
		}		
	}
	private String getAccountNumber(String username) {
		// TODO Auto-generated method stub
		String dbDriver = "com.mysql.cj.jdbc.Driver";
		DbConnection.LoadDriver(dbDriver);
		Connection con = DbConnection.getConnection();
		String Account1 = null;
		String sql = "Select Account_Number from Register where UserName = ?"; 
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			rs.next();
			Account1 = rs.getString("Account_Number");
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Account1;
	}
	public Long Amount_Transfer(String Account1 , String Account2 , long Amount) throws SQLException
	{
		String dbDriver = "com.mysql.cj.jdbc.Driver";
		DbConnection.LoadDriver(dbDriver);
		Connection con = DbConnection.getConnection();
		long balance = 0 ;
		String sql1 = "update AmountData set AmountData.Amount = Amount - " 
							+ Amount +  " where AmountData.AccountNumber = " + Account1 ;
		String sql2 = "update AmountData set AmountData.Amount = Amount + "
							+ Amount +  " where AmountData.AccountNumber = " + Account2 ;
		String sql3 = "select  AmountData.Amount from Register , AmountData where Register.Account_Number = " + Account1 ;
		PreparedStatement ps1 , ps2 , ps3;
		try {
			ps1 = con.prepareStatement(sql1);
			ps2 = con.prepareStatement(sql2);
			ps1.executeUpdate();
			ps2.executeUpdate();
			ps3 = con.prepareStatement(sql3);
			ResultSet rs = ps3.executeQuery();
			rs.next();
			balance = rs.getLong("Amount");
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			System.out.println("error");
			e.printStackTrace();
		}
		return balance;
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
	public boolean IsAmountValid(String AccountNo , Long Amount)
	{
		
		String dbDriver = "com.mysql.cj.jdbc.Driver";
		DbConnection.LoadDriver(dbDriver);
		Connection con = DbConnection.getConnection();
		boolean status = false;
		String sql = "Select Amount from AmountData where AccountNumber = ?";
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, AccountNo);
			ResultSet rs = ps.executeQuery();
			status = rs.next();
			if (status) 
			{
                if (rs.getLong("Amount") < Amount) 
                {
                    return false;
                }
            }
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}

}
