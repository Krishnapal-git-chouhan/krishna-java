import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/regform")
public class Register extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String myname = req.getParameter("name1");
		String myemail = req.getParameter("email1");
		String mypass = req.getParameter("ps1");
		String gender = req.getParameter("gender1");
		String mycity = req.getParameter("city1");
		PrintWriter out = resp.getWriter();
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/yt_demo","root","root");
			
			PreparedStatement ps = con.prepareStatement("insert into register(?,?,?,?,?)");
			ps.setString(1, myname);
			ps.setString(2, myemail);
			ps.setString(3, mypass);
			ps.setString(4, gender);
			ps.setString(5, mycity);
			
			int count = ps.executeUpdate();
			
			if(count > 0 ) {
				resp.setContentType("text/html");
				out.println("<h2 style='color:green'> registration successful </h3>");
			}
		} catch (Exception e) {
			out.println("registration fail");
		}
	}

}
