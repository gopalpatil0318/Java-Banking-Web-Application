<%@ page import="com.bank.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">
<title>Document</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<section class="login">
		<div class="row login_box">
			<div class="col-6 left">

				<div class="welcome">
					<h3>Welcome, MAULI BANK</h3>

				</div>
				<div class="buttons">
					<a href="details.jsp">
						<button class="btn btn-block">My Account</button>
					</a> <a href="diposit.html"><button class="btn btn-block">Deposit</button></a>
					<a href="withdraw.html"><button class="btn btn-block">Withdraw</button></a>
					<a href="transfer.html"><button class="btn btn-block">Money
							Transfer</button></a> <a href="checkbalance.jsp"><button
							class="btn btn-block">Check Balance</button></a> <a
						href="alluser.jsp"><button class="btn btn-block">All
							Users</button></a> <a href="index.html"><button class="btn btn-block">Logout</button></a>
				</div>
			</div>
			<div class="col-6 right">
				<div class="right-text">

					<h2>
						Welcome
						<%=User.getName()%>
						....
					</h2>

					<div class="text">
						<h5>Experience secure and convenient banking services with
							Mauli Bank. Manage your accounts, make transactions, and check
							balances effortlessly. Join us for a seamless banking experience
							tailored to your needs.</h5>
					</div>

				</div>
				<div class="right-inductor">
					
						
				</div>
			</div>
		</div>
	</section>

</body>
</html>