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


@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String name = req.getParameter("nm");
	String password = req.getParameter("ps");
	String email = req.getParameter("em");
	String country = req.getParameter("co");
	
	resp.setContentType("text/html");
	PrintWriter out = resp.getWriter();
	
	try {
		Class.forName("com.mysql.cj.jdbc.driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "root");
		PreparedStatement pst = con.prepareStatement("insert into userlogin values(?,?,?,?)");
		pst.setString(1,name);
		pst.setString(2,password);
		pst.setString(3,email);
		pst.setString(4,country);
		int row = pst.executeUpdate();
		out.println("<h1>" +row+ "inserted successfuly"+ "</h1>");
		System.out.println(row+"inserted successfuly");
	} catch(Exception e) {
		System.out.println(e);
	}
	}

}
