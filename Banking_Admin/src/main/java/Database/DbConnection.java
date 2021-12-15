package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DatabaseEntry.DatabaseEntry;

public class DbConnection {
	private static String DB_URL = "jdbc:mysql://localhost:3306/Banking";
	private static String USERNAME = "sa";
	private static String PASSWORD = "root";
	private static String dbDriver = "com.mysql.cj.jdbc.Driver";
	public static void LoadDriver( String driver)
	{
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	  
	public static Connection getConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
			//   System.out.println("Connection Established");
		} catch (Exception e) {
			System.out.println("Connection failed");
			System.out.println(e);
		}
		return con;
	}

	public static void closeConnection(Connection con) {
		try {
			con.close();
		} catch (Exception e) {

		}
	}

	public boolean Validate(DatabaseEntry de)
	{
		LoadDriver(dbDriver);
		Connection con = getConnection();
		boolean status = false;
		String sql = "Select UserName , Password from Register where UserName = ? and Password = ?;";
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, de.getUsername());
			ps.setString(2, de.getPassword());
			ResultSet rs = ps.executeQuery();
			status = rs.next();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
		
		
	}

	public boolean Insert(DatabaseEntry de)
	{
		LoadDriver(dbDriver);
		Connection con = getConnection();
		boolean status = false;
		System.out.println(de.getDate());
		String sql = "call InsertCustomerData(? , ? , ? , ? , ? , ? , ? , ? , ? )";
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, de.getRusername());
			ps.setString(2, de.getAccount_number());
			ps.setString(3, de.getName());
			ps.setString(4, de.getGender());
			ps.setDate  (5, de.getDate());
			ps.setString(6, de.getEMail());
			ps.setString(7, de.getMobileNo());
			ps.setString(8, de.getRPassword());
			ps.setLong  (9, de.getAmount());
			ps.execute();
			status = true;
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(de.getDate());
			e.printStackTrace();
		}
		return status;
		
	}
	public boolean MyProfile(String UserName) throws SQLException
	{
		LoadDriver(dbDriver);
		Connection con = getConnection();
		boolean status = false;
		String sql = "select Register.Account_Number , Register.Name , Register.Gender , Register.Date ,"
				+ " Register.E_mail , Register.MobileNo , AmountData.Amount from Register ,"
				+ " AmountData where Register.UserName = ? ";
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, UserName);
			ResultSet rs = ps.executeQuery();
			rs.next();
			status = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}

}
