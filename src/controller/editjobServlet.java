package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.editjobDAO;
import model.job;

/**
 * Servlet implementation class editjobServlet
 */
@WebServlet("/editjobServlet")
public class editjobServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editjobServlet() {
        super();
        editjobDAO = new editjobDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String jobname = request.getParameter("jobname");
		 String jobtype = request.getParameter("jobtype");
	    String joblink = request.getParameter("joblink");
	   
	   
	    boolean bResult;
	    bResult =editjobDAO.IsPresent(jobname);
	    
		if(bResult)
		{
		
			job editCourse=new job();
		 editCourse.setJobname(jobname);
		 System.out.println("1"+jobname);
		 editCourse.setJobtype(jobtype);
		 System.out.println("2"+jobtype);
		 editCourse.setJoblink(joblink);
		 System.out.println("3"+joblink);
		 
		 editjobDAO.EditInfo(editCourse);
			request.setAttribute("error", "");

			request.setAttribute("jobname",jobname);
			
	 
		     
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
	private editjobDAO editjobDAO;
}
