package DatabaseEntry;

public class DatabaseEntry {
	private String Rusername;
	private String username;
	private String password;
	private String Name;
	private String Account_number;
	private String Gender;
	private java.util.Date Date;
	private String EMail;
	private String MobileNo;
	private String RPassword;
	private String Account1;
	private String Account2;
	private long Amount;
	public String getAccount1() {
		return Account1;
	}
	public void setAccount1(String account1) {
		Account1 = account1;
	}
	public String getAccount2() {
		return Account2;
	}
	public void setAccount2(String account2) {
		Account2 = account2;
	}
	public long getAmount() {
		return Amount;
	}
	public void setAmount(long amount) {
		Amount = amount;
	}
	public String getRusername() {
		return Rusername;
	}
	public void setRusername(String rusername) {
		Rusername = rusername;
	}
	public String getRPassword() {
		return RPassword;
	}
	public void setRPassword(String rPassword) {
		RPassword = rPassword;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getAccount_number() {
		return Account_number;
	}
	public void setAccount_number(String account_number) {
		Account_number = account_number;
	}
	public java.util.Date getDate() {
		return Date;
	}
	public void setDate(java.util.Date date) {
		Date = date;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public String getEMail() {
		return EMail;
	}
	public void setEMail(String eMail) {
		EMail = eMail;
	}
	public String getMobileNo() {
		return MobileNo;
	}
	public void setMobileNo(String mobileNo) {
		MobileNo = mobileNo;
	}

}
