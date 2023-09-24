<%@ page import="db.DBConnection" %>
<%@ page import="com.bank.User" %>
<%@ page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
    integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
    integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <title>check balance</title>
<link rel="stylesheet" href="style.css">
<link rel="stylesheet" href="style.css">
</head>
<body>
<section class="login">
  <div class="row login_box">
    <div class="col-6 left">
      <div class="top_link">
        <a href="home.jsp">
          <img src="https://drive.google.com/u/0/uc?id=16U__U5dJdaTfNGobB_OpwAJ73vM50rPV&export=download" alt="">
          Return home
        </a>
      </div>
      <div class="contact">
        <form action="">
          <h3>ACCOUNT HOLDERS</h3>
         <% Connection con = DBConnection.connect();
			String query = "select * from banking ORDER BY balance DESC";
			PreparedStatement stmt = con.prepareStatement(query);
		
			
			
			ResultSet rs= stmt.executeQuery(); %>
          <table>
            <thead>
              <tr>
                
                <th>Name</th>
                <th>Balance</th>
                <th>AccountNo</th>
                <th>Action</th>
              </tr>
            </thead>
            <% while(rs.next()) {%>
            <tbody>
              <tr>
               
                <td><%= rs.getString(2) %></td>
               
                <td><%= rs.getFloat(5) %></td>
                <td><%= rs.getInt(6) %></td>
                <td><a href="delete.jsp?id=<%=rs.getInt(1) %>">Delete</a></td>
              </tr>
            
            </tbody>
            <% } %>
          </table>
        </form>
      </div>
    </div>
    <div class="col-6 right">
      <div class="right-text">
        <h2>MAULI BANK</h2>
        <h5>Welcome to the most trusted bank</h5>
      </div>
      <div class="right-inductor">
      
      </div>
    </div>
  </div>
</section>



</body>
</html>