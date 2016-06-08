package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.courseDAO;
import dao.courseEditDAO;
import model.course;

/**
 * Servlet implementation class CourseEditServlet
 */
@WebServlet("/CourseEditServlet")
public class CourseEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseEditServlet() {
        super();
        courseEditDAO = new courseEditDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String courseID = request.getParameter("courseID");
	//	 String coursename = request.getParameter("coursename");
	    String coursesyllabus = request.getParameter("coursesyllabus");
	    String profoffcdetails = request.getParameter("profoffcdetails");
	    System.out.println("prof:"+profoffcdetails);
	    String taofficedetails = request.getParameter("taofficedetails");
	   // String profname=request.getParameter("profname");
	   // String profemail=request.getParameter("profemail");
	    boolean bResult;
	    bResult = courseEditDAO.IsPresent(courseID);
	    
		if(bResult)
		{
		
		 
		 
		 course editCourse=new course();
		 editCourse.setCourseID(courseID);
		 System.out.println("1"+courseID);
		 editCourse.setCoursesyllabus(coursesyllabus);
		 System.out.println("2"+coursesyllabus);
		 editCourse.setProfoffcdetails(profoffcdetails);
		 System.out.println("3"+profoffcdetails);
		 editCourse.setTaofficedetails(taofficedetails);
		 System.out.println("4"+taofficedetails);
			//courseDao.InsertNewCourse(NewCourse);
			courseEditDAO.EditInfo(editCourse);
			request.setAttribute("error", "");

			request.setAttribute("courseID", courseID);
			
	 
		     
			RequestDispatcher Dispatch = request.getRequestDispatcher("listcourse.jsp");
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
	private courseEditDAO courseEditDAO;
}
