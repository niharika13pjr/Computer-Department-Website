package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.courseDAO;
import model.course;

/**
 * Servlet implementation class CourseServlet
 */
@WebServlet("/CourseServlet")
public class CourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseServlet() {
        super();
       courseDao = new courseDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String courseID = request.getParameter("courseID");
		 String coursename = request.getParameter("coursename");
	    String coursesyllabus = request.getParameter("coursesyllabus");
	    String profoffcdetails = request.getParameter("profoffcdetails");
	   
	    String taofficedetails = request.getParameter("taofficedetails");
	    String profname=request.getParameter("profname");
	    String profemail=request.getParameter("profemail");
	    String credit=request.getParameter("credit");
	    System.out.println("credit::"+credit);
	    boolean bResult;
	    bResult = courseDao.IsPresent(courseID);
	    
		if(bResult)
		{
			 request.setAttribute("error", "AlreadyPresent");
			 RequestDispatcher Dispatch = request.getRequestDispatcher("course.jsp");
			 
			 Dispatch.forward(request, response);       	 
			 return ;
		}
		
		
		 course NewCourse = new course();
		 NewCourse.setCoursename(coursename);
		 NewCourse.setCoursesyllabus(coursesyllabus);
		 NewCourse.setProfoffcdetails(profoffcdetails);
			
		
			
		 NewCourse.setCourseID(courseID);
		 NewCourse.setTaofficedetails(taofficedetails);
		 NewCourse.setProfemail(profemail);
		 NewCourse.setProfname(profname);
		 NewCourse.setCredit(credit);
		 

		 
			courseDao.InsertNewCourse(NewCourse);
			//courseDao.EditInfo(editCourse);
			request.setAttribute("error", "");

			request.setAttribute("courseID", courseID);
			
			RequestDispatcher Dispatch = request.getRequestDispatcher("listcourse.jsp");
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
	private courseDAO courseDao;
}
