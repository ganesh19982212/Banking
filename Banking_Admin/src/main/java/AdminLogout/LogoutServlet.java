package AdminLogout;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet(name = "Logout", urlPatterns = { "/Logout" })
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		session.removeAttribute("Username");
		session.invalidate();
		response.getWriter().println(""
				+ "<html>"
				+ "	<title>Logged Out</title>"
				+ "		<link rel=\"stylesheet\" href= \"BankingAdmin.css\">"
				+ "		<body>"
				+ "			<div class=\"body\"></div>"
				+ "			<div class=\"grad\"></div>"
				+ "			<div class=\"header\">"
				+ "				<div>Logged<span> out</span></div>"
				+ "			</div>"
				+ "			<div  class = \"logout\"  align = \"right\" style = \"vertical-align: top;\">"
				+ "				<input type = \"button\" name = \"Login\" value = \"Login\" onclick = "
				+ " 					\"location.href = 'http://localhost:8081/Banking_Admin/AdminLogin.jsp'\"> "
				+ "			</div>"
				+ "			<div  class = \"result\">"
				+ "				Logged out Successfully."
				+ "			</div>"
				+ "		</body>"
				+ "	</html>");
	}

}
