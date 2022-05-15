package model;

public class Complaint {

	private String ComplaintId;
	private String CustomerId;
	private String ComplaintDate;
	private String Complaint;

	public Complaint() {

	}

	public Complaint(String ComplaintId, String CustomerId, String ComplaintDate, String Complaint) {
		super();
		this.ComplaintId = ComplaintId;
		this.CustomerId = CustomerId;
		this.ComplaintDate = ComplaintDate;
		this.Complaint = Complaint;

	}

	public String getComplaintId() {
		return ComplaintId;
	}

	public void setComplaintId(String ComplaintId) {
		this.ComplaintId = ComplaintId;
	}

	public String getCustomerId() {
		return CustomerId;
	}

	public void setCustomerId(String CustomerId) {
		this.CustomerId = CustomerId;
	}

	public String getComplaintDate() {
		return ComplaintDate;
	}

	public void setComplaintDate(String ComplaintDate) {
		this.ComplaintDate = ComplaintDate;
	}

	public String getComplaint() {
		return Complaint;
	}

	public void setComplaint(String Complaint) {
		this.Complaint = Complaint;
	}
	
	
	public String readComplaints()
	{
	 String output = "";
	try
	 {
	 Connection con = connect();
	 if (con == null)
	 {
	 return "Error while connecting to the database for reading.";
	 }
	 // Prepare the html table to be displayed
	
	 output = "<table border=\"1\"><tr><th>Item Code</th>
	 <th>Item Name</th><th>Item Price</th>
	 <th>Item Description</th>
	 <th>Update</th><th>Remove</th></tr>"; 
	 String query = "select * from items";
	 Statement stmt = con.createStatement();
	 ResultSet rs = stmt.executeQuery(query);
	 // iterate through the rows in the result set
	 while (rs.next())
	 {
	 String itemID = Integer.toString(rs.getInt("itemID"));
	 String itemCode = rs.getString("itemCode");
	 String itemName = rs.getString("itemName");
	 String itemPrice = Double.toString(rs.getDouble("itemPrice"));
	 String itemDesc = rs.getString("itemDesc");
	 
	 
	 // Add into the html table
	 output += "<tr><td><input id='hidItemIDUpdate'
	 name='hidItemIDUpdate'
	 type='hidden' value='" + itemID + "'>"
	 + itemCode + "</td>";
	 output += "<td>" + itemName + "</td>";
	 output += "<td>" + itemPrice + "</td>";
	 output += "<td>" + itemDesc + "</td>";
	 
	 
	 // buttons
	 output += "<td><input name='btnUpdate'
	 type='button' value='Update'
	 class=' btnUpdate btn btn-secondary'></td>
	 <td><form method='post' action='items.jsp'>
	 <input name='btnRemove' type='submit'
	 value='Remove' class='btn btn-danger'>
	 <input name='hidItemIDDelete' type='hidden'
	 value='" + itemID + "'>" + "</form></td></tr>";
	 }
	 con.close();
	 
	 
	 
	 // Complete the html table
	 output += "</table>";
	 }
	 
	catch (Exception e)
	 {
	 output = "Error while reading the items.";
	 System.err.println(e.getMessage());
	 }
	return output;
	}

}
