package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.editprofileDAO;
import model.Register;

/**
 * Servlet implementation class editprofileServlet
 */
@WebServlet("/editprofileServlet")
public class editprofileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editprofileServlet() {
       
        super();
        editprofileDAO = new editprofileDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String netID = request.getParameter("netID");
		System.out.println("netID:"+netID);
		String usertype=request.getParameter("usertype");
		System.out.println("usertype:"+usertype);
	    String phone = request.getParameter("phone");
	    System.out.println("phone:"+phone);
	    String advisordetail = request.getParameter("advisordetail");
	    System.out.println("advisordetail:"+advisordetail);
	    String email = request.getParameter("email");
	    System.out.println("email:"+email);
	   
	   
	    boolean bResult;
	    boolean bResult1;
	    bResult =editprofileDAO.IsPresent(netID);
	    bResult1=editprofileDAO.IsAuthenticatedUser(netID, usertype);
		if(bResult)
		{
		
		 Register editProfile=new Register();
		 editProfile.setPhone(phone);
		 System.out.println("1"+phone);
		 editProfile.setEmail(email);
		 System.out.println("2"+email);
		 editProfile.setAdvisordetail(advisordetail);
		 System.out.println("3"+advisordetail);
		 editProfile.setNetID(netID);
		 System.out.println("4"+netID);
		 editprofileDAO.EditProfile(editProfile);
			request.setAttribute("error", "");

			request.setAttribute("netID", netID);
			
	 
		     
			RequestDispatcher Dispatch = request.getRequestDispatcher("editedprofile.jsp");
			Dispatch.forward(request, response); 
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	private editprofileDAO editprofileDAO;
}
