package AdminLogin;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(name = "Login", urlPatterns = { "/Login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String Username = request.getParameter("Username").toString();
		String Password = request.getParameter("Password").toString();
		boolean login = Username.equals("Admin123") && Password.equals("Admin123");
		if(login)
		{

			ServletContext servletcontext = getServletContext();
			servletcontext.setAttribute("Username", Username);
			HttpSession session=request.getSession();
			session.setAttribute("Username", Username);			
			response.sendRedirect("AdminPortal.jsp");
			
		}
		else
		{
			response.getWriter().println(""
					+ "<html>"
					+ "	<title>Invalid Credentials</title>"
					+ "		<link rel=\"stylesheet\" href= \"BankingAdmin.css\">"
					+ "		<body>"
					+ "			<div class=\"body\"></div>"
					+ "			<div class=\"grad\"></div>"
					+ "			<div class=\"header\">"
					+ "				<div>Invalid<span> Credentials</span></div>"
					+ "			</div>"
					+ "			<div  class = \"result\">"
					+ "				Please Enter Valid Credentials"
					+ "				<input type=\"button\" value=\"Back\" onclick=\"history.back()\">"
					+ "			</div>"
					+ "		</body>"
					+ "	</html>");
		}
	}

}
