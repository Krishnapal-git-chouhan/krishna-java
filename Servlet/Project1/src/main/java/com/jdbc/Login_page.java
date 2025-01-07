package com.jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Login_page")
public class Login_page  extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
String myname = req.getParameter("nm");
String myemail = req.getParameter("em");
PrintWriter out = resp.getWriter();
resp.setContentType("text/html");

		try {
		Class.forName("com.mysql.cj.jdbc.driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/yt_demo","root","root");
		System.out.println("connection stablished");
		PreparedStatement ps = con.prepareStatement("select * from register where email=? and password=?");
		ps.setString(1,myname);
		ps.setString(2, myemail);
		
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			
HttpSession se = req.getSession();
se.setAttribute("se_name", rs.getString("name"));

			RequestDispatcher rd = req.getRequestDispatcher("/profile.jsp");
			rd.forward(req, resp);
		}else {
			out.println("<h3> style='color:red'>email and password didn't match </h3>");
			
			RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
			rd.include(req, resp);
		}
       }catch (Exception e) {
    	   out.println("<h3> style='color:red'>email and password didn't match </h3>");
			
			RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
			rd.include(req, resp);
	} 
    	   
       }
    }


