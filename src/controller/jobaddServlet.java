package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.jobaddServletDAO;
import model.job;

/**
 * Servlet implementation class jobaddServlet
 */
@WebServlet("/jobaddServlet")
public class jobaddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public jobaddServlet() {
        super();
        jobaddServletDAO= new jobaddServletDAO();
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
	    bResult = jobaddServletDAO.IsPresent(jobname);
	    
		if(bResult)
		{
			 request.setAttribute("error", "AlreadyPresent");
			 RequestDispatcher Dispatch = request.getRequestDispatcher("job.jsp");
			 
			 Dispatch.forward(request, response);       	 
			 return ;
		}
		
		 job NewCourse = new job();
		 NewCourse.setJobname(jobname);
		 NewCourse.setJobtype(jobtype);
		 NewCourse.setJoblink(joblink);
		// NewCourse.setProfoffcdetails(profoffcdetails);
			
	
	
		 
		 jobaddServletDAO.InsertNewJob(NewCourse);
			//courseDao.EditInfo(editCourse);
			request.setAttribute("error", "");

			request.setAttribute("jobname", jobname);
			RequestDispatcher Dispatch = request.getRequestDispatcher("announcement.jsp");
			Dispatch.forward(request, response); 
			
	 
		     
	    //    return;
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	private jobaddServletDAO jobaddServletDAO;
}
