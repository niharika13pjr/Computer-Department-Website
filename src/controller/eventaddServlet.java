package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.eventDAO;
import model.event;

/**
 * Servlet implementation class eventaddServlet
 */
@WebServlet("/eventaddServlet")
public class eventaddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public eventaddServlet() {
        super();
        eventDao = new eventDAO();
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
	    String eventdetail = request.getParameter("eventdetail");
	    boolean bResult;
	    
	    bResult = eventDao.IsPresent(eventname);
	    
		if(bResult)
		{
			 request.setAttribute("error", "AlreadyPresent");
			 RequestDispatcher Dispatch = request.getRequestDispatcher("event.jsp");
			 
			 Dispatch.forward(request, response);       	 
			 return ;
		}
		
		 event NewCourse = new event();
		
		 NewCourse.setEventID(eventID);
		 NewCourse.setEventname(eventname);
		 NewCourse.setEventdetail(eventdetail);
		
			eventDao.InsertNewEvent(NewCourse);
			//courseDao.EditInfo(editCourse);
			request.setAttribute("error", "");

			request.setAttribute("eventname:", eventname);
			RequestDispatcher Dispatch = request.getRequestDispatcher("announcement.jsp");
			Dispatch.forward(request, response); 
	      //  return;
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	private eventDAO eventDao;
}
