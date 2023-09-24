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

/**
 * Servlet implementation class Register
 */
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: Hi").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		float balance = Float.parseFloat(request.getParameter("balance"));
		 int min = 111111111;
		 int  max = 999999999;
		int  accNo = min + (int) (Math.random() * (max - min + 1));
		
		try {
			Connection con = DBConnection.connect();
			String query = "insert into banking values(?,?,?,?,?,?)";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, 0);
			stmt.setString(2, name);
			stmt.setString(3, username);
			stmt.setString(4, password);
			stmt.setFloat(5, balance);
			stmt.setInt(6, accNo);
			
			int i = stmt.executeUpdate();
			if(i>0)
			{
				query = "select * from banking where username=?";
				stmt = con.prepareStatement(query);
				stmt.setString(1, username);
				ResultSet rs = stmt.executeQuery();
				if(rs.next())
				{
					int id = rs.getInt(1);
					User.setId(id);
				}
				User.setName(name);
				User.setUsername(username);
				User.setPassword(password);
				User.setBalance(balance);
				User.setAccno(accNo);
				response.sendRedirect("home.jsp");
			}
			else
			{
				response.sendRedirect("funny.html");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		doGet(request, response);
	}

}
