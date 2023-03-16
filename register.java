

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class register
 */
@WebServlet("/register")
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String user = request.getParameter("user");
		String pwd = request.getParameter("pwd");
		String tel = request.getParameter("tel");
		StringBuilder errorMsg = new StringBuilder();
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login?useSSL=false","root","root");
			PreparedStatement pst = con.prepareStatement("insert into register(uname,tel,pwd) values (?,?,?)");
			pst.setString(1,user);
			pst.setString(2, tel);
			pst.setString(3, pwd);
			int i = pst.executeUpdate();
			if(i > 0) {
				out.print("Successfully Register");
				response.sendRedirect("login.jsp");
			}
			else {
				errorMsg.append("Unsuccessfully register");
				response.sendRedirect("register.jsp");
			}
		}
		catch(Exception c) {
			
		}
	}

}
