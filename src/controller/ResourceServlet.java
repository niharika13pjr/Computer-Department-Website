package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.resourceDAO;
import model.resource;

/**
 * Servlet implementation class ResourceServlet
 */
@WebServlet("/ResourceServlet")
public class ResourceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResourceServlet() {
        super();
        resourceDAO = new resourceDAO();

        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String resourcetype= request.getParameter("resourcetype");
		 String resourcedate = request.getParameter("resourcedate");
		 System.out.println(request.getParameter("userID"));
		 
		 int userID = Integer.parseInt(request.getParameter("userID"));
		 
		 int slotID = Integer.parseInt(request.getParameter("slotID"));
		 String slotavalability=null;
		 //System.out.println(resourcedate);
		// System.out.println(resourcetype);
		System.out.println(userID);
		 
		 resource NewResource = new resource();
		 NewResource.setResourcetype(resourcetype);
		 NewResource.setResourcedate(resourcedate);
		 NewResource.setSlotID(slotID);
		 NewResource.setUserID(userID);
		 String name="";
		boolean status= resourceDAO.checkslot(slotID, userID,resourcedate,resourcetype);
			 if(status == true){
					
					int t=resourceDAO.getuser(slotID,resourcedate,resourcetype);
					 name=resourceDAO.getUserName(t);
					 slotavalability="Sorry "+name+" has already booked the request slot.";
			 }
			 
			 else 
			 { resourceDAO.InsertNewResource(NewResource);
			 	slotavalability="Successfully booked";
			 	
			 } 
			 
			 request.setAttribute("slotavalability",slotavalability);
			 RequestDispatcher Dispatch = request.getRequestDispatcher("successresource.jsp");
				Dispatch.forward(request, response); 
		
	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	private resourceDAO resourceDAO;
}
