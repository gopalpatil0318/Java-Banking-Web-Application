package com.bank;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.DBConnection;

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public Login() {
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username+password);
		
		Connection con = DBConnection.connect();
		
		
		try {
			String query = "select * from banking where username=? and password=?";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, username);
			stmt.setString(2, password);
			ResultSet rs = stmt.executeQuery();
			if(rs.next())
			{
				int id = rs.getInt(1);
				String name = rs.getString(2);
				float balance = rs.getFloat(5);
				int accno= rs.getInt(6);
				User.setId(id);
				User.setName(name);
				User.setUsername(username);
				User.setPassword(password);
				User.setBalance(balance);
				User.setAccno(accno);
				response.sendRedirect("home.jsp");
			}else{
				response.sendRedirect("funny.html");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		doGet(request, response);
	}

}
