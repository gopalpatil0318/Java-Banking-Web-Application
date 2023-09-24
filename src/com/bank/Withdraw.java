package com.bank;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ResponseCache;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.DBConnection;

/**
 * Servlet implementation class Withdraw
 */
public class Withdraw extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Withdraw() {
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
		float balance = Float.parseFloat(request.getParameter("balance"));
		String password = request.getParameter("password");
		float oldbalance = User.getBalance();
		String pass = User.getPassword();
		
		if(balance>oldbalance)
		{
			response.sendRedirect("funny.html");
		}
		else{
			balance = oldbalance - balance;
			int id = User.getId();
			try {
				Connection con = DBConnection.connect();
				String query ="update banking set balance = ? where id=?";
				PreparedStatement stmt = con.prepareStatement(query);
				stmt.setFloat(1, balance);
				stmt.setInt(2, id);
				int i = stmt.executeUpdate();
				if(i>0)
				{
					User.setBalance(balance);
					response.sendRedirect("home.jsp");
				}else{
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
