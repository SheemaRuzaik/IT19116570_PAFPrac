<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="components/jquery-3.2.1.min.js"></script>
<script src="components/complaint.js"></script>

<title>Customer Complaint Management</title>
</head>
<body>
<div class="container"> 
		<div class="row">  
		
			<div class="col-8">       
				<h1 class="m-3">Customer Complaint Management</h1>        
				
				<form id="formComplaint" name="formComplaint" method="post" action="Complaint.jsp">  
				
					Complaint ID:  
					<input id="ComplaintId" name="ComplaintId" type="text" class="form-control form-control-sm">  
					
					<br> 
					Customer ID:  
					<input id="CustomerId" name="CustomerId" type="text" class="form-control form-control-sm">  
				 	
					 Date:  
					 <input id="ComplaintDate" name="dComplaintDateate" type="text" class="form-control form-control-sm"> 
					 
					 <br> 
					 Message:  
					 <input id="msg" name="msg" type="text" class="form-control form-control-sm">

					 
					 
					 <br>  
					 <input id="btnSave" name="btnSave" type="button" value="Save" class="btn btn-primary">  
					 <input type="hidden" id="hidAppIDSave" name="hidAppIDSave" value=""> 
					 
				</form> 
				
				<div id="alertSuccess" class="alert alert-success"></div>  
				<div id="alertError" class="alert alert-danger"></div> 
				
				<br>  
				<div id="divItemsGrid">   
					<%    
						Complaint comObj = new Complaint();
						out.print(comObj.readAppointment());   
					%>  
					
				</div> 
				  
 			</div>
 		 
 		</div>    
 		
 
	</div> 

</body>

</html>