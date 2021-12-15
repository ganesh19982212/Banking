package CustomerDetailsUpdate;

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
 * Servlet implementation class UpdateCustomerDetailsServlet
 */
@WebServlet(name = "UpdateCustomer", urlPatterns = { "/UpdateCustomer" })
public class UpdateCustomerDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletContext servletcontext = getServletContext();
		String AdminName = (String)servletcontext.getAttribute("Username");
		String Account = request.getParameter("AccountNumber");
		boolean isAccountValid = IsAccountValid(Account);
		if(isAccountValid)
		{
			String Name = null , DOB = null , Email = null , Amount = null , MobileNo = null , creditDebit = null;
			if(request.getParameter("checkbox1") != null)
			{
				Name = request.getParameter("Name").toString();
			}
			if(request.getParameter("checkbox2") != null)
			{
				DOB = request.getParameter("DOB").toString();
			}
			if(request.getParameter("checkbox3") != null)
			{
				Email = request.getParameter("Email").toString().toLowerCase();
			}
			if(request.getParameter("checkbox4") != null)
			{
				MobileNo = request.getParameter("MobileNo").toString();
			}
			if(request.getParameter("checkbox5") != null)
			{
				Amount = request.getParameter("Amount").toString();
				creditDebit = request.getParameter("Transaction").toString();
			}
			if(Name != null)
			{
				try {
					boolean status = UpdateDetails(Account , "Register" , "Name" , Name , null);
					System.out.println(status + " Name Success");
					response.getWriter().println();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(DOB != null)
			{
				try {
					boolean status = UpdateDetails(Account , "Register" , "Date" , DOB , null);
					System.out.println(status + " DOB Success");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(Email != null)
			{
				try {
					boolean status = UpdateDetails(Account , "Register" , "E_mail" , Email , null);
					System.out.println(status + " Email Success");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(MobileNo != null)
			{
				try {
					boolean status = UpdateDetails(Account , "Register" , "MobileNo" , MobileNo , null);
					System.out.println(status + " MobileNo Success");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(Amount != null && creditDebit !=  null)
			{
				try {
					boolean status = UpdateDetails(Account , "AmountData" , "Amount" , Amount , creditDebit);
					System.out.println(status + " Amount Success");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(Name == null && DOB == null && Email == null && MobileNo == null && Amount == null)
			{
				response.getWriter().println(""
						+ "<html>"
						+ "	<title>No checkbox Clicked</title>"
						+ "		<link rel=\"stylesheet\" href= \"BankingAdmin.css\">"
						+ "		<body>"
						+ "			<div class=\"body\"></div>"
						+ "			<div class=\"grad\"></div>"
						+ "			<div class=\"header\">"
						+ "				<div>Click<span> Checkbox</span></div>"
						+ "			</div>"
						+ "			<div  class = \"logout\"  align = \"right\" style = \"vertical-align: top;\">"
						+ "				Welcome "+ AdminName 
						+ "			</div>"
						+ "			<div  class = \"result\">"
						+ "				Please Click Checkbox to update details.<br>"
						+ "				<input type=\"button\" value=\"Back\" onclick=\"history.back()\">"			
						+ "			</div>"
						+ "		</body>"
						+ "	</html>");
			}
			else if(Name != null || DOB != null || Email != null || MobileNo != null || Amount != null 
					&& IsAmountValid(Account , Long.parseLong(Amount)))
			{
				response.getWriter().println(""
						+ "<html>"
						+ "	<title>Updated</title>"
						+ "		<link rel=\"stylesheet\" href= \"BankingAdmin.css\">"
						+ "		<body>"
						+ "			<div class=\"body\"></div>"
						+ "			<div class=\"grad\"></div>"
						+ "			<div class=\"header\">"
						+ "				<div>Data<span> Updated</span></div>"
						+ "			</div>"
						+ "			<div  class = \"logout\"  align = \"right\" style = \"vertical-align: top;\">"
						+ "				Welcome "+ AdminName 
						+ "			</div>"
						+ "			<div  class = \"result\">"
						+ "				Details Updated Successfully.<br>"
						+ "				<input type=\"button\" value=\"Back\"  onclick =" 
						+ " 				 \"location.href = 'http://localhost:8081/Banking_Admin/AdminPortal.jsp'\">"		
						+ "			</div>"
						+ "		</body>"
						+ "	</html>");;
			}
			else
			{
				response.getWriter().println(""
						+ "<html>"
						+ "	<title>Insufficient Balance</title>"
						+ "		<link rel=\"stylesheet\" href= \"BankingAdmin.css\">"
						+ "		<body>"
						+ "			<div class=\"body\"></div>"
						+ "			<div class=\"grad\"></div>"
						+ "			<div class=\"header\">"
						+ "				<div>Insufficient<span> Balance</span></div>"
						+ "			</div>"
						+ "			<div  class = \"logout\"  align = \"right\" style = \"vertical-align: top;\">"
						+ "				Welcome "+ AdminName 
						+ "			</div>"
						+ "			<div  class = \"result\">"
						+ "				Insufficient Balance. Please Enter Valid Amount and try again.<br>"
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
					+ "		<link rel=\"stylesheet\" href= \"BankingAdmin.css\">"
					+ "		<body>"
					+ "			<div class=\"body\"></div>"
					+ "			<div class=\"grad\"></div>"
					+ "			<div class=\"header\">"
					+ "				<div>Invalid<span> Account</span></div>"
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
	public boolean UpdateDetails(String Account , String TableName , String  TableData , String UpdatedData , String CreditDebit)
			throws SQLException
	{
		String dbDriver = "com.mysql.cj.jdbc.Driver";
		DbConnection.LoadDriver(dbDriver);
		Connection con = DbConnection.getConnection();
		String sql = null;
		boolean status = false;
		if(TableData.equals("Amount"))
		{
			if(CreditDebit.equals("Credit"))
			{
				sql = "update "+ TableName + " set " + TableName + "." + TableData + " = Amount + " + UpdatedData +  " where " 
						+ TableName + ".AccountNumber = " + "'" + Account + "'" ;
			}
			else if(CreditDebit.equals("Debit"))
			{
				boolean IsAmountvalid = IsAmountValid(Account , Long.parseLong(UpdatedData));
				if(IsAmountvalid)
				{
					sql = "update "+ TableName + " set " + TableName + "." + TableData + " = Amount - " + UpdatedData +  " where " 
							+ TableName + ".AccountNumber = " + "'" + Account + "'";	
				}
				else
				{
					return false;
				}
			}
		}
		if(TableData.equals("Date"))
		{
			java.sql.Date date = java.sql.Date.valueOf(UpdatedData);
			sql = "update "+ TableName + " set " + TableName + "." + TableData + " = " + "'" + date + "'" +  " where " 
					+ TableName + ".Account_Number = " + "'" + Account + "'" ;
			//System.out.println(sql + " Date");
		}
		if(TableData.equals("Name") || TableData.equals("E_mail") || TableData.equals("MobileNo"))
		{
			sql = "update "+ TableName + " set " + TableName + "." + TableData + " = " + "'" + UpdatedData + "'" +  " where " 
					+ TableName + ".Account_Number = " + "'" + Account + "'" ;
		}
		PreparedStatement ps;
		try {
			
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
			status = true;
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			System.out.println("error");
			e.printStackTrace();
		}
		return status;
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
                    System.out.println("Insufficient Balance!");
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
