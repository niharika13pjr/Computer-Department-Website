package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.editdeptExamDAO;
import model.deptexam;

/**
 * Servlet implementation class editdeptExamServlet
 */
@WebServlet("/editdeptExamServlet")
public class editdeptExamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editdeptExamServlet() {
        super();
        editdeptExamDAO = new editdeptExamDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		String studentexamID = request.getParameter("studentexamID");
	    String dexamname = request.getParameter("dexamname");
	    String result = request.getParameter("result");
	    System.out.println("result edited to:"+result);
	   
	   
	    boolean bResult;
	    bResult =editdeptExamDAO.IsPresent(studentexamID);
	    
		if(bResult)
		{
		
			deptexam editCourse=new deptexam();
		 editCourse.setStudentexamID(studentexamID);
		 System.out.println("1"+studentexamID);
		 editCourse.setDexamname(dexamname);
		 System.out.println("2"+dexamname);
		 editCourse.setResult(result);
		 System.out.println("3"+result);
		 
		 editdeptExamDAO.EditInfo(editCourse);
			request.setAttribute("error", "");

			request.setAttribute("studentexamID",studentexamID);
			
	 
		     
			RequestDispatcher Dispatch = request.getRequestDispatcher("success.jsp");
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
	private editdeptExamDAO editdeptExamDAO;
}
