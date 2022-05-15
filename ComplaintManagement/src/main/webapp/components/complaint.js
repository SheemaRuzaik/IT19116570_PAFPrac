$(document).ready(function()
{
 $("#alertSuccess").hide();
 $("#alertError").hide();
});


// SAVE ============================================

$(document).on("click", "#btnSave", function(event)
{
	
// Clear status msges-------------

 $("#alertSuccess").text("");
 $("#alertSuccess").hide();
 $("#alertError").text("");
 $("#alertError").hide();
 
 
// Form validation----------------

var status = validateComplaintForm();

// If not valid-------------------
if (status != true)
 {
 $("#alertError").text(status);
 $("#alertError").show();
 return;
 }
 
// If valid----------------------
var complaint = getComplaintID($("#txtName").val().trim(),$("#txtName").val().trim(),$$("#txtName").val().trim(),$("#txtName").val().trim());$("#colComplaints").append(complaint);

 $("#alertSuccess").text("Saved successfully.");
 $("#alertSuccess").show();

 $("#formComplaint")[0].reset();
});
// REMOVE==========================================
$(document).on("click", ".remove", function(event)
{
 $(this).closest(".complaint").remove();

 $("#alertSuccess").text("Removed successfully.");
 $("#alertSuccess").show();
});


// CLIENT-MODEL=================================================================

function validateComplaintForm()
{
// COMPLAINT ID
if ($("#txtName").val().trim() == "")
 {
 return "Insert complaint ID.";
 }
// CUSTOMER ID
if ($("#txtName").val().trim() == "")
 {
 return "Insert customer ID.";
 }
// DATE
if ($("#txtName").val().trim() == "")
 {
 return "Insert date.";
 }
 // MESSAGE
 if ($("#txtName").val().trim() == "")
 {
 return "Insert message.";
 }
 
 
return true;
}


function getComplaintCard(complaintID, customerID, date,message)
{
var complaintID = (gender == "Male") ? "Mr." : "Ms.";
var yearNumber = "";
switch (year) {
case "1":
 yearNumber = "1st";
 break;
case "2":
 yearNumber = "2nd";
 break;
case "3":
 yearNumber = "3rd";
 break;
case "4":
 yearNumber = "4th";
 break;
 }
 
 
var student = "";
 student += "<div class=\"student card bg-light m-2\"
 style=\"max-width: 10rem; float: left;\">";
 student += "<div class=\"card-body\">";
 student += title + " " + name + ",";
 student += "<br>";
 student += yearNumber + " year";
 student += "</div>";
 student += "<input type=\"button\" value=\"Remove\"
 class= \"btn btn-danger remove\">";
 student += "</div>";
return student;
}

$(document).on("click", ".remove", function(event)
{
 $(this).closest(".student").remove();

 $("#alertSuccess").text("Removed successfully.");
 $("#alertSuccess").show();
});
