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
import model.regexam;

/**
 * Servlet implementation class regexam
 */
@WebServlet("/regexamServlet")
public class regexamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public regexamServlet() {
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

		 String examname = request.getParameter("examname");
		 int userID = Integer.parseInt(request.getParameter("userID"));
		 System.out.println(userID);
		 regexam Result = new regexam();
		 Result.setExamname(examname);
		 Result.setUserID(userID);
		 deptexamDao.Insertstudentreg(Result);
		 
		 RequestDispatcher Dispatch = request.getRequestDispatcher("success1.jsp");
			Dispatch.forward(request, response); 

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
