<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anony
	mous">

<title>Banking System</title>
</head>
<body>
	<div class="container mt-5 ">
		<h3>Account Creation Screen</h3>
		<form action="createaccount" method="post">
			<div class="form-group">
				<label for="exampleInputEmail1">Account Number</label> <input
					type="number" class="form-control" id="exampleInputEmail1"
					aria-describedby="emailHelp" placeholder="Account Number"
					name="accountnumber" required>
			</div>
			<div class="form-group">
				<label for="exampleInputEmail1">Name</label> <input type="text"
					class="form-control" id="exampleInputEmail1"
					aria-describedby="emailHelp" placeholder="Name" name="name" required>
			</div>
			<div class="form-group">
				<label for="exampleInputEmail1">Address</label> <input type="text"
					class="form-control" id="exampleInputEmail1"
					aria-describedby="emailHelp" placeholder="Address" name="address" required>
			</div>
			<div class="form-group">
				<label for="exampleInputEmail1">Email address</label> <input
					type="text" class="form-control" id="exampleInputEmail1"
					aria-describedby="emailHelp" placeholder="Email Address"
					name="email" required>
			</div>
			<div class="form-group">
				<label for="exampleFormControlSelect1">Account Type</label> <select
					class="form-control" id="exampleFormControlSelect1"
					name="acctype" required>
					<option>Savings</option>
					<option>Current</option>
				</select>
			
				<div class="container mt-5 text-center">
					<input type="hidden" name="username" value=${userpass.username}/>
				</div>
				
				<div class="container mt-5 text-center">
					<button type="submit" class="btn btn-success">Submit</button>
					<a href="mainmenu.jsp" class="btn btn-info" role="button">Main Menu</a>

				</div>
				
				
		</form>
	</div>
<h4>${msg}</h4>	
	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
</body>
</html>