//Hide the alters on page load
$(document).ready(function()
{ $("#alertSuccess").hide(); $("#alertError").hide();});$(document).on("click", "#btnSave", function(event)
{
console.log($("#hidComplaintIDSave").val());


// Clear alerts---------------------
$("#alertSuccess").text("");
$("#alertSuccess").hide();
$("#alertError").text("");
$("#alertError").hide();


// Form validation-------------------
var status = validateItemForm();
if (status != true)
{
$("#alertError").text(status);
$("#alertError").show();
return;
}
// If valid------------------------
var type = ($("#hidComplaintIDSave").val() == "") ? "POST" : "PUT";
console.log(type);
$.ajax(
{
url : "ComplaintAPI",
type : type,
data : $("#formItem").serialize(),
dataType : "text",
complete : function(response, status)
{
onComplaintSaveComplete(response.responseText, status);
}
});
});// CLIENT-MODEL================================================================
function validateItemForm()
{
//Complaint ID
if ($("#ComplaintId").val().trim() == "")
{
return "Insert Complaint ID.";
}
//Customer ID
if ($("#CustomerId").val().trim() == "")
{
return "Insert Customer ID.";
}
//Date
if ($("#ComplaintDate").val().trim() == "")
{
return "Insert Date.";
}
//Complaint 
if ($("#Complaint").val().trim() == "")
{
return "Insert Complaint.";
}

return true;
}$(document).on("click", ".btnUpdate", function()
{
$("#hidComplaintIDSave").val($(this).data("ComplaintId"));
$("#CustomerId").val($(this).closest("tr").find('td:eq(0)').text());
$("#ComplaintDate").val($(this).closest("tr").find('td:eq(1)').text());
$("#Complaint").val($(this).closest("tr").find('td:eq(2)').text());

});function onComplaintSaveComplete(response, status)
{	
if (status == "success")
{
var resultSet = JSON.parse(response);
if (resultSet.status.trim() == "success")
{
$("#alertSuccess").text("Successfully saved.");
$("#alertSuccess").show();
$("#divItemsGrid").html(resultSet.data);
} else if (resultSet.status.trim() == "error")
{
$("#alertError").text(resultSet.data);
$("#alertError").show();
}
} else if (status == "error")
{
$("#alertError").text("Error while saving.");
$("#alertError").show();
} else
{
$("#alertError").text("Unknown error while saving..");
$("#alertError").show();
}
$("#hidComplaintIDSave").val("");
$("#formItem")[0].reset();
}
$(document).on("click", ".btnRemove", function()
{
var id = $(this).data("ComplaintId");
console.log("id is :"+id)
$.ajax(
{
url : "ComplaintAPI",
type : "DELETE",
data : "ComplaintId=" + id,
dataType : "text",
complete : function(response, status)
{
console.log(id)
onComplaintDeleteComplete(response.responseText, status);
}
});
});function onComplaintDeleteComplete(response, status)
{
if (status == "success")
{
var resultSet = JSON.parse(response);
if (resultSet.status.trim() == "success")
{
$("#alertSuccess").text("Successfully deleted.");
$("#alertSuccess").show();
$("#divItemsGrid").html(resultSet.data);
} else if (resultSet.status.trim() == "error")
{
$("#alertError").text(resultSet.data);
$("#alertError").show();
}
} else if (status == "error")
{
$("#alertError").text("Error while deleting.");
$("#alertError").show();
} else
{
$("#alertError").text("Unknown error while deleting..");
$("#alertError").show();
}
$("#hidItemIDSave").val("");
$("#formItem")[0].reset();
}

