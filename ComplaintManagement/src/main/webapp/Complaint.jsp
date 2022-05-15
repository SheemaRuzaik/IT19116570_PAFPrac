<%@page import="model.Complaint" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Complaint Management</title>
<link rel="stylesheet" href="Views/bootstrap.min.css"></head>
<body>
<div class="container">
<div class="row">
<div class="col-6">
<h1>Customer Complaint Management</h1>


				<form id="formItem" name="formItem">
				Customer ID: <input id="CustomerId"
				name="CustomerId" type="text" class="form-control form-control-sm"> <br>
				Date: <input id="ComplaintDate" name="ComplaintDate"
				type="text" class="form-control form-control-sm"> <br> 
				Complaint: <input id="Complaint" name="Complaint"
				type="text" class="form-control form-control-sm"> <br> 
				<br>
				
				<input id="btnSave" name="btnSave" type="button" value="Save" class="btn btn-primary">
				<input type="hidden" id="hidComplaintIDSave" name="hidComplaintIDSave" value="">
				</form>
				<br>
				
					<div id="alertSuccess" class="alert alert-success"></div>
					<div id="alertError" class="alert alert-danger"></div>
					<br>
					<div id="divItemsGrid">
					
					
					<%
						Complaint invoiceObj = new Complaint();
						out.print(invoiceObj.readComplaints());
					%>
</div>
</div>
</div>
</div>
</body>
<script src="Components/jquery.min.js" type="text/javascript"></script>
<script src="Components/complaint.js" type="text/javascript"></script>
</html>

