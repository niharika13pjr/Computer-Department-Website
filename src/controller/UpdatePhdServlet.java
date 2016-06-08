package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Register;
import model.course;
import dao.courseEditDAO;
import dao.updatephdDAO;

/**
 * Servlet implementation class UpdatePhdServlet
 */
@WebServlet("/UpdatePhdServlet")
public class UpdatePhdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePhdServlet() {
        super();
       updatephdDAO = new updatephdDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @param fname 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String fname = request.getParameter("fname");
		 String candidate = request.getParameter("candidate");
		    String advisordetail = request.getParameter("advisordetail");
		   // System.out.println("prof:"+profoffcdetails);
		    //String taofficedetails = request.getParameter("taofficedetails");
		  //  boolean bResult;
		 //   bResult = updatephdDAO.IsPresent(fname);
		    
			//if(bResult)
			//{
			
			 
			 
			 Register updatephd=new Register();
			 
			 updatephd.setFname(fname);
			 updatephd.setCandidate(candidate);
			 updatephd.setAdvisordetail(advisordetail);
			// System.out.println("1"+courseID);
			// editCourse.setCoursesyllabus(coursesyllabus);
			 //System.out.println("2"+coursesyllabus);
			 //editCourse.setProfoffcdetails(profoffcdetails);
			 //System.out.println("3"+profoffcdetails);
			 //editCourse.setTaofficedetails(taofficedetails);
			 //System.out.println("4"+taofficedetails);
				//courseDao.InsertNewCourse(NewCourse);
				updatephdDAO.updateInfo(updatephd);
				request.setAttribute("error", "");

				request.setAttribute("fname",fname);
				
		 
			     
				RequestDispatcher Dispatch = request.getRequestDispatcher("listphd.jsp");
				Dispatch.forward(request, response); 
				
			//}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	private updatephdDAO updatephdDAO;
}
