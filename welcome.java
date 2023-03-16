

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class welcome
 */
@WebServlet("/welcome")
public class welcome extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		HttpSession session1 = request.getSession(false);
		if (session1 == null || session1.getAttribute("user") == null) {
		    // Redirect the user to the login page
		    response.sendRedirect("login.jsp");
		}
		out.println("<!DOCTYPE html>\r\n"
				+ "<html>\r\n"
				+ "<head>\r\n"
				+ "<meta charset=\"ISO-8859-1\">\r\n"
				+ "<title>Insert title here</title>\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "<form action=\"welcome\" method=\"post\">\r\n"
				+ "Welcome To this page\r\n"
				+ "<a href=\"logout\">Logout</a>\r\n"
				+ "</form>\r\n"
				+ "\r\n"
				+ "</body>\r\n"
				+ "</html>");
	}

}
