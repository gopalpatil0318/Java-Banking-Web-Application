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
 * Servlet implementation class Transfer
 */
public class Transfer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Transfer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		float balance = Float.parseFloat(request.getParameter("balance"));
		int accno = Integer.parseInt(request.getParameter("account"));
		String password = request.getParameter("password");
		float otherbalance = 0;
		float bal = User.getBalance();
		int id = User.getId();
		String pass = User.getPassword();
		System.out.println(pass);
		if(bal<balance)
		{
			response.sendRedirect("funny.html");
		}else{
			
			try {
				Connection con = DBConnection.connect();
				String query = "select * from banking where account=?";
				PreparedStatement stmt = con.prepareStatement(query);
				stmt.setInt(1, accno);
				ResultSet rs = stmt.executeQuery();
				if(rs.next())
				{
					otherbalance = rs.getFloat(5);
				}
				else
				{
					
				}
				
				bal = bal - balance;
				otherbalance = otherbalance + balance;
				
				query = "update banking set balance = ? where id = ?";
				stmt = con.prepareStatement(query);
				stmt.setFloat(1, bal);
				stmt.setInt(2, id);
				int i = stmt.executeUpdate();
				if(i>0)
				{
					User.setBalance(bal);
				}
				
				query = "update banking set balance = ? where account = ?";
				stmt = con.prepareStatement(query);
				stmt.setFloat(1, otherbalance);
				stmt.setInt(2, accno);
				i = stmt.executeUpdate();
				if(i>0)
				{
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
			
		}
		
		
		
		
		doGet(request, response);
	}

}
