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
 * Servlet implementation class Diposite
 */
public class Diposite extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Diposite() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		float balance = Float.parseFloat(request.getParameter("balance"));
		String password = request.getParameter("password");
		String pass = User.getPassword();
		if(balance<0)
		{
			response.sendRedirect("funny.html");
		}else{
			balance = balance+User.getBalance();
			int id = User.getId();
			try {
				Connection con = DBConnection.connect();
				String query = "update banking set balance = ? where id = ?";
				PreparedStatement stmt = con.prepareStatement(query);
				stmt.setFloat(1, balance);
				stmt.setInt(2, id);
				int i = stmt.executeUpdate();
				if(i>0)
				{
					User.setBalance(balance);
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
