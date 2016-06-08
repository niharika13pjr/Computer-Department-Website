package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.deptexamDAO;
import model.deptexam;

/**
 * Servlet implementation class deptExamServlet
 */
@WebServlet("/deptExamServlet")
public class deptExamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deptExamServlet() {
        super();
        deptexamDao = new deptexamDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String dexamname = request.getParameter("dexamname");
		 String studentexamID = request.getParameter("studentexamID");
	    String result = request.getParameter("result");
	    
	    boolean bResult;
	 /*  bResult = deptexamDao.IsPresent(dexamname);
	    
		if(bResult)
		{
			 request.setAttribute("error", "AlreadyPresent");
			 RequestDispatcher Dispatch = request.getRequestDispatcher("deptexam.jsp");
			 
			 Dispatch.forward(request, response);       	 
			 return ;
		}*/
		
		 deptexam Result = new deptexam();
		 Result.setDexamname(dexamname);
		 Result.setStudentexamID(studentexamID);
		 Result.setResult(result);
		
			deptexamDao.Insertresult(Result);
			//courseDao.EditInfo(editCourse);
			request.setAttribute("error", "");

			request.setAttribute("dexamname", dexamname);
			
			RequestDispatcher Dispatch = request.getRequestDispatcher("facultyhome1.jsp");
			Dispatch.forward(request, response); 
			
		     
	     //   return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	private deptexamDAO deptexamDao;
}
