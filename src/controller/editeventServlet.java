package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.editeventDAO;
import dao.editjobDAO;
import model.event;
import model.job;
/**
 * Servlet implementation class editeventServlet
 */
@WebServlet("/editeventServlet")
public class editeventServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editeventServlet() {
        super();
        editeventDAO = new editeventDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String eventID = request.getParameter("eventID");
		 String eventname = request.getParameter("eventname");
	    String eventdetail= request.getParameter("eventdetail");
	   
	   
	    boolean bResult;
	    bResult =editeventDAO.IsPresent(eventID);
	    
		if(bResult)
		{
		
			event editCourse=new event();
		 editCourse.setEventID(eventID);
		 System.out.println("1"+eventID);
		 editCourse.setEventname(eventname);
		 System.out.println("2"+eventname);
		 editCourse.setEventdetail(eventdetail);
		 System.out.println("3"+eventdetail);
		 
		 editeventDAO.EditInfo(editCourse);
			request.setAttribute("error", "");

			request.setAttribute("eventID",eventID);
			
	 
		     
			RequestDispatcher Dispatch = request.getRequestDispatcher("announcement.jsp");
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
	private editeventDAO editeventDAO;
}
