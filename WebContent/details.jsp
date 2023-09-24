<%@ page import="db.DBConnection" %>
<%@ page import="com.bank.User" %>
<%@ page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
    integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <title>Document</title>
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
          <h3>ACCOUNT DETAILS</h3>
     
          <label for="fullname">Full Name:</label>
          <input type="text" id="fullname" value="<%= User.getName() %>" readonly>
          <label for="username">Username:</label>
          <input type="text" id="username" value="<%= User.getUsername() %>" readonly>
          <label for="account-number">Account Number:</label>
          <input type="text" id="account-number" value="<%= User.getAccno() %>" readonly>
          <label for="balance">Balance:</label>
          <input type="text" id="balance" value="<%= User.getBalance() %>" readonly>
        </form>
      </div>
    </div>
    <div class="col-6 right">
      <div class="right-text">
        <h2>MAULI BANK</h2>
        <h5>View your account details on Mauli Bank's account details page. Access your full name, username, account number, and current balance. Stay informed about your financial information with ease and security.</h5>
      </div>
      <div class="right-inductor">
       
      </div>
    </div>
  </div>
</section>
</body>
</html>
