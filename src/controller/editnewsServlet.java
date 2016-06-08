package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.editjobDAO;
import dao.editnewsDAO;
import model.news;
/**
 * Servlet implementation class editnewsServlet
 */
@WebServlet("/editnewsServlet")
public class editnewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editnewsServlet() {
        super();
        editnewsDAO = new editnewsDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String newsID = request.getParameter("newsID");
		String newsname = request.getParameter("newsname");
	    String newsdetail = request.getParameter("newsdetail");
	    

		
		 news NewCourse = new news();
		
		 NewCourse.setNewsID(newsID);
		 NewCourse.setNewsname(newsname);
		 NewCourse.setNewsdetail(newsdetail);
		
		 editnewsDAO.EditInfo(NewCourse);
			//courseDao.EditInfo(editCourse);
			request.setAttribute("error", "");

			request.setAttribute("newsID: ", newsID);
			RequestDispatcher Dispatch = request.getRequestDispatcher("announcement.jsp");
			Dispatch.forward(request, response); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	private editnewsDAO editnewsDAO;
}
