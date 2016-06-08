package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.alumniDAO;
import model.alumni;

/**
 * Servlet implementation class AlumniAddServlet
 */
@WebServlet("/AlumniAddServlet")
public class AlumniAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlumniAddServlet() {
        super();
        alumniDao = new alumniDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
		String alumniID = request.getParameter("alumniID");
		 String alumniname = request.getParameter("alumniname");
	    String alumnidetail = request.getParameter("alumnidetail");
	    
	    boolean bResult;
	    bResult = alumniDao.IsPresent(alumniID);
	    
		if(bResult)
		{
			 request.setAttribute("error", "AlreadyPresent");
			 RequestDispatcher Dispatch = request.getRequestDispatcher("alumni.jsp");
			 
			 Dispatch.forward(request, response);       	 
			 return ;
		}
		
		
		 alumni NewCourse = new alumni();
		 NewCourse.setAlumniID(alumniID);
		 NewCourse.setAlumniname(alumniname);
		 NewCourse.setAlumnidetail(alumnidetail);
		// NewCourse.setProfoffcdetails(profoffcdetails);
			
	
	
		 
			alumniDao.InsertNewAlumni(NewCourse);
			//courseDao.EditInfo(editCourse);
			request.setAttribute("error", "");

			request.setAttribute("alumniID", alumniID);
			
			RequestDispatcher Dispatch = request.getRequestDispatcher("listalumni.jsp");
			Dispatch.forward(request, response); 
		     
	       // return;
	}	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	private alumniDAO alumniDao;

}
