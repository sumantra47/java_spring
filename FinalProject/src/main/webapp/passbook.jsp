<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Banking System</title>
<link rel="stylesheet" href="./styles/style.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.47/css/bootstrap-datetimepicker.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.24.0/moment.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.47/js/bootstrap-datetimepicker.min.js"></script>
</head>

<body>
	<div class="container text-center">
		<h3>Display Statements</h3>
		<a href="mainmenu.jsp" class="btn btn-info" role="button">Main
			Menu</a>
	</div>
	<form action="gettrx" , method="get">
		<div class="form-group col-xs-3">
			<label for="exampleInputEmail1">Account Number</label> <input
				type="number" class="form-control" id="exampleInputEmail1"
				aria-describedby="emailHelp" placeholder="Account Number"
				name="accountnumber" value=0>
		</div>

		<div class="form-group col-sm-3">
			<label for="exampleInputEmail1">Start Date</label>
			<div class='input-group date'>
				<input type='text' class="form-control" name=begindate
					id='datetimepicker1' required /> <span class="input-group-addon">
					<span class="glyphicon glyphicon-calendar"></span>
				</span>
			</div>
		</div>

		<div class="form-group col-sm-3">
			<label for="exampleInputEmail1">End Date</label>
			<div class='input-group date'>
				<input type='text' class="form-control" name=enddate
					id='datetimepicker2' required /> <span class="input-group-addon">
					<span class="glyphicon glyphicon-calendar"></span>
				</span>
			</div>
		</div>
		<div class="container text-center">
			<button type="submit" class="btn btn-primary">Display</button>
		</div>
	</form>


	<script type="text/javascript">
		$(function() {
			$('#datetimepicker1').datetimepicker({
				format : 'DDMMYYYY',

			});
		});
	</script>
	<script type="text/javascript">
		$(function() {
			$('#datetimepicker2').datetimepicker({
				format : 'DDMMYYYY',
			});
		});
	</script>
	<table border="2" width="70%" cellpadding="2">
		<tr>
			<th>SerialNo</th>
			<th>TrxDate</th>
			<th>Descriptopn</th>
			<th>ChequeNo</th>
			<th>WithDraw</th>
			<th>Deposit</th>
			<th>Balance</th>
		</tr>
		<c:forEach var="user" items="${userhist}">
			<tr>
				<td>${user.serialno}</td>
				<td>${user.trxdate}</td>
				<td>${user.description}</td>
				<td>${user.chequeno}</td>
				<td>${user.withdraw}</td>
				<td>${user.deposit}</td>
				<td>${user.balance}</td>
			</tr>
		</c:forEach>
	</table>
	<p>${msg}</p>
</body>

</html>