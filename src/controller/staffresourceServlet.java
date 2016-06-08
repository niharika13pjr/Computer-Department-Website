package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.staffresourceDAO;

import model.staffresource;

/**
 * Servlet implementation class staffresourceServlet
 */
@WebServlet("/staffresourceServlet")
public class staffresourceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public staffresourceServlet() {
        super();
        staffresourceDAO = new staffresourceDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	//	int resourceID = Integer.parseInt(request.getParameter("resourceID"));
		 String resourcetype = request.getParameter("resourcetype");
	    String resourcedetail = request.getParameter("resourcedetail");
	    boolean bResult;
	    bResult = staffresourceDAO.IsPresent(resourcetype);
	    
		if(bResult)
		{
			 request.setAttribute("error", "AlreadyPresent");
			 RequestDispatcher Dispatch = request.getRequestDispatcher("createresource.jsp");
			 
			 Dispatch.forward(request, response);       	 
			 return ;
		}
		
		 staffresource NewCourse = new staffresource();
		// NewCourse.setResourceID(resourceID);
		 NewCourse.setResourcetype(resourcetype);
		 NewCourse.setResourcedetail(resourcedetail);
		// NewCourse.setProfoffcdetails(profoffcdetails);
			
			staffresourceDAO.Insertstaffresource(NewCourse);
			//courseDao.EditInfo(editCourse);
			request.setAttribute("error", "");

			request.setAttribute("resourcetype", resourcetype);
			
			RequestDispatcher Dispatch = request.getRequestDispatcher("facultyhome.jsp");
			Dispatch.forward(request, response); 
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	private staffresourceDAO staffresourceDAO;
}
