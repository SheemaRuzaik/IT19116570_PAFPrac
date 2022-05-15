package model;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Complaint {
	
	public String insertComplaint(String CustomerId, String ComplaintDate, String Complaint) 
	{ 
		String output = ""; 
		try
		{ 
			DBConnection con = new DBConnection();
			Connection con1 = con.connect(); 
			if (con1 == null) 
			{return "Error while connecting to the database for inserting."; } 
			// create a prepared statement
			String query = " insert into complaint('ComplaintId','CustomerId','ComplaintDate','Complaint')"
					+ " values (?, ?, ?, ?)"; 
			PreparedStatement preparedStmt = con1.prepareStatement(query); 
			// binding values
			preparedStmt.setInt(1, 0); 
			preparedStmt.setString(2, CustomerId); 
			preparedStmt.setString(3, ComplaintDate);
			preparedStmt.setString(4, Complaint);
		
			
			// execute the statement
			preparedStmt.execute(); 
			con1.close(); 
			String newItems = readComplaints();
			
			System.out.println(newItems);

			output = "{\"status\":\"success\", \"data\": \"" + newItems + "\"}";

		} 
		catch (Exception e) 
		{ 
			output =  "{\"status\":\"error\", \"data\": \"Error while inserting the complaint.\"}";
			System.err.println(e.getMessage()); 
		} 
		return output; 
	} 
	public String readComplaints() 
	{ 
		String output = ""; 
		try
		{ 
			DBConnection con = new DBConnection();
			Connection con1 = con.connect(); 
			if (con1 == null) 
			{return "Error while connecting to the database for reading."; } 
			// Prepare the html table to be displayed
			output = "<table border='1'><tr><th>Customer ID</th><th>Name</th>" +
					"<th>Date</th>" + 
					"<th>Complaint</th></tr>"; 

			String query = "select * from complaint"; 
			Statement stmt = con1.createStatement(); 
			ResultSet rs = stmt.executeQuery(query); 
			// iterate through the rows in the result set
			while (rs.next()) 
			{ 
				String ComplaintId = Integer.toString(rs.getInt("ComplaintId")); 
				String CustomerId = rs.getString("CustomerId"); 
				String ComplaintDate = rs.getString("ComplaintDate"); 
				String Complaint = rs.getString("Complaint");
			
				// Add into the html table
				output += "<tr><td><input type='hidden' name='hidComplaintIDUpdate' id='hidComplaintIDUpdate' value='"+ComplaintId+"'>" + CustomerId + "</td>"; 
				output += "<td>" + ComplaintDate + "</td>"; 
				output += "<td>" + Complaint + "</td>";
			
				// buttons
				output += "<td><input name='btnUpdate' type='button' value='Update' class='btnUpdate btn btn-secondary' data-inquiryid='"+ComplaintId+"'></td>"
						+ "<td><input name='btnRemove' type='button' value='Remove' class='btnRemove btn btn-secondary' data-inquiryid='"+ComplaintId+"'></td></tr>"; 
			} 
			con1.close(); 
			// Complete the html table
			output += "</table>"; 
		} 
		catch (Exception e) 
		{ 
			output = "Error while reading the complaints."; 
			System.err.println(e.getMessage()); 
		} 
		return output; 
	} 
	public String updateComplaint(String ComplaintId, String CustomerId, String ComplaintDate, String Complaint)

	{ 
		System.out.println("came here as well");
		String output = ""; 
		try
		{ 
			DBConnection con = new DBConnection();
			Connection con1 = con.connect(); 
			if (con1 == null) 
			{return "Error while connecting to the database for updating."; } 
			// create a prepared statement
			String query = "UPDATE complaints SET CustomerId=?,ComplaintDate=?,Complaint=? WHERE ComplaintId=?"; 
			PreparedStatement preparedStmt = con1.prepareStatement(query); 
			// binding values
			preparedStmt.setString(1, CustomerId); 
			preparedStmt.setString(2, ComplaintDate); 
			preparedStmt.setString(3, Complaint); 
		
			preparedStmt.setInt(6, Integer.parseInt(ComplaintId)); 
			// execute the statement
			preparedStmt.execute(); 
			con1.close(); 
			String newItems = readComplaints();

			output = "{\"status\":\"success\", \"data\": \"" + newItems + "\"}";
		} 
		catch (Exception e) 
		{ 
			output =  "{\"status\":\"error\", \"data\": \"Error while updating the complaint.\"}";
			System.err.println(e.getMessage()); 
		} 
		return output; 
	} 
	public String deleteComplaint(String ComplaintId) 
	{ 
		String output = ""; 
		try
		{ 
			DBConnection con = new DBConnection();
			Connection con1 = con.connect(); 
			if (con1 == null) 
			{return "Error while connecting to the database for deleting."; } 
			// create a prepared statement
			String query = "delete from complaints where ComplaintId=?"; 
			PreparedStatement preparedStmt = con1.prepareStatement(query); 
			// binding values
			preparedStmt.setString(1, ComplaintId); 
			// execute the statement
			preparedStmt.execute(); 
			con1.close(); 
			String newItems = readComplaints();

			output = "{\"status\":\"success\", \"data\": \"" + newItems + "\"}";
		} 
		catch (Exception e) 
		{ 
			output =  "{\"status\":\"error\", \"data\": \"Error while deleting the item.\"}";
			System.err.println(e.getMessage()); 
		} 
		return output; 
	} 
}
