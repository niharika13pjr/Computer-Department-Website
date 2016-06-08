package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.alumniEditDAO;
import model.alumni;

/**
 * Servlet implementation class AlumniEditServlet
 */
@WebServlet("/AlumniEditServlet")
public class AlumniEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlumniEditServlet() {
        super();
        alumniEditDAO = new alumniEditDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String alumniID = request.getParameter("alumniID");
		
		    String alumniname = request.getParameter("alumniname");
		    String alumnidetail = request.getParameter("alumnidetail");
		    System.out.println("prof:"+alumnidetail);
		   
		   
		    boolean bResult;
		    bResult =alumniEditDAO.IsPresent(alumniID);
		    
			if(bResult)
			{
			
				alumni editCourse=new alumni();
			 editCourse.setAlumniID(alumniID);
			 System.out.println("1"+alumniID);
			 editCourse.setAlumniname(alumniname);
			 System.out.println("2"+alumniname);
			 editCourse.setAlumnidetail(alumnidetail);
			 System.out.println("3"+alumnidetail);
			 
			 alumniEditDAO.EditInfo(editCourse);
				request.setAttribute("error", "");

				request.setAttribute("courseID", alumniID);
				
		 
			     
				RequestDispatcher Dispatch = request.getRequestDispatcher("listalumni.jsp");
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
	private alumniEditDAO alumniEditDAO;
}
