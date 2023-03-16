

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String user = request.getParameter("user");
		String pwd = request.getParameter("pwd");
		boolean rememberme = Boolean.parseBoolean(request.getParameter("rememberMe"));
		Connection con = null;
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		RequestDispatcher dispatcher = null;
		HttpSession session = request.getSession();
		StringBuilder errorMsg = new StringBuilder();	
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login?useSSL=false","root","root");
			PreparedStatement pst = con.prepareStatement("select * from register where uname = ? and pwd = ?");
			pst.setString(1, user);
			pst.setString(2, pwd);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				session.setAttribute("user", rs.getString("uname"));
				out.print("Successfully entered");
				response.sendRedirect("welcome");
			}else {
				errorMsg.append("Please check your username and password");
				response.sendRedirect("login.jsp");
			}
		}
		catch(Exception c) {
			
		}
	}

}
