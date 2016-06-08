package controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.examDAO;
import model.exam;

/**
 * Servlet implementation class examAddServlet
 */
@WebServlet("/examAddServlet")
public class examAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public examAddServlet() {
        super();
       examDao = new examDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String examname = request.getParameter("examname");
		
		String examdate = request.getParameter("examdate");
	    String examlink = request.getParameter("examlink");
	    
	    boolean bResult;
	    bResult = examDao.IsPresent(examname);
	    
		if(bResult)
		{
			 request.setAttribute("error", "AlreadyPresent");
			 RequestDispatcher Dispatch = request.getRequestDispatcher("addexam.jsp");
			 
			 Dispatch.forward(request, response);       	 
			 return ;
		}
		//Date Examdate=new Date();
		
	
		
		 exam NewCourse = new exam();
		
		 NewCourse.setExamname(examname);
		 NewCourse.setExamdate(examdate);
		 NewCourse.setExamlink(examlink);
		
			examDao.InsertNewAlumni(NewCourse);
			//courseDao.EditInfo(editCourse);
			request.setAttribute("error", "");

			request.setAttribute("alumniID", examname);
			RequestDispatcher Dispatch = request.getRequestDispatcher("success.jsp");
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
	private examDAO examDao;
}
