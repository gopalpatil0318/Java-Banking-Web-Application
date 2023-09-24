<%@ page import="com.bank.User" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
    integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <title>check balance</title>
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
          <h3>CHECK BALANCE</h3>
         
          <label for="balance">Balance:</label>
          <input type="text" id="balance" value="<%= User.getBalance() %>" readonly>
        </form>
      </div>
    </div>
    <div class="col-6 right">
      <div class="right-text">
        <h2>MAULI BANK</h2>
        <h5>Effortlessly check your account balance with Mauli Bank's intuitive interface. Stay updated on your finances and make informed decisions with ease. Join us for hassle-free balance checking today.</h5>
      </div>
      <div class="right-inductor">
       
      </div>
    </div>
  </div>
</section>

</body>
</html>