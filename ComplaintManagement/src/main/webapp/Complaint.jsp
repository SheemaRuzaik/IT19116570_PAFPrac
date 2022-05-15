<%@page import="model.Complaint"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Complaint Management</title>
<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="Components/jquery-3.6.0.min.js"></script>
<script src="Components/main.js"></script>
</head>
<body>

	<div class="container">
		<h1>Customer Complaint Management</h1>
	
		<form id="formComplaint" name="formComplaint" method="post" action="Complaint.jsp">
			Customer ID:<input id="CustomerId" name="CustomerId" type="text" class="form-control"><br>
			Date:<input id="ComplaintDate" name="ComplaintDate" type="text" class="form-control"><br>
			Complaint:<input id="Complaint" name="Complaint" type="text" class="form-control"><br>
		
			<input id="btnSave" name="btnSave" type="button" value="Save" class="btn btn-primary">
			<input type="hidden" id="hidItemIDSave" name="hidItemIDSave" value="">
		</form>
	
	<br>
	
	<div id="alertSuccess" class="alert alert-success"></div>
	<div id="alertError" class="alert alert-danger"></div>
	
	<br>
	
	<div id="divItemsGrid">
	<%
 		Complaint complaintObj = new Complaint();
 		out.print(complaintObj.readComplaints());
	%>
	</div>
	
	</div>
</body>
</html>