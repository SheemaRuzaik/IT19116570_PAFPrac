package model;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Servlet implementation class ComplaintAPI
 */
@WebServlet("/ComplaintAPI")
public class ComplaintAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Complaint complaintObj = null;
    
    public ComplaintAPI() {
        super();
        
    }
    
    

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("come to post");
		Complaint Complaint = new Complaint();
		String output = Complaint.insertComplaint(request.getParameter("CustomerId"),
				 request.getParameter("ComplaintDate"),
				request.getParameter("Complaint"));
			
				response.getWriter().write(output);
				
	}

	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("came here");
		Complaint Complaint = new Complaint();
		// TODO Auto-generated method stub
		Map paras = getParasMap(request);
		 String output = Complaint.updateComplaint(paras.get("hidComplaintIDSave").toString(),
		 paras.get("CustomerId").toString(),
		paras.get("ComplaintDate").toString(),
		paras.get("Complaint").toString()
	
		);
		response.getWriter().write(output);
		
	}

	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Complaint Complaint = new Complaint();
		Map paras = getParasMap(request);
		 String output = Complaint.deleteComplaint(paras.get("ComplaintId").toString());
		response.getWriter().write(output);
	}
	
	// Convert request parameters to a Map
	private static Map getParasMap(HttpServletRequest request)
		{
			Map<String, String> map = new HashMap<String, String>();
	try
	 	{
			Scanner scanner = new Scanner(request.getInputStream(), "UTF-8");
			String queryString = scanner.hasNext() ?
			scanner.useDelimiter("\\A").next() : "";
			scanner.close();
			String[] params = queryString.split("&");
			for (String param : params)
				{ 
					String[] p = param.split("=");
					map.put(p[0], p[1]);
				 }
	 	}
		catch (Exception e)
			 {
			 	}
		return map;
				}

}
