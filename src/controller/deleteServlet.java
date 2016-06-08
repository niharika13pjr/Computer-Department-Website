package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.discussDAO;
import model.discuss;

/**
 * Servlet implementation class deleteServlet
 */
@WebServlet("/deleteServlet")
public class deleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteServlet() {
        super();
        discussDAO = new discussDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		try{
			
			
		//int parentId=Integer.parseInt(request.getParameter("parentid"));
		//System.out.println(parentId);
			System.out.println("I am here also niharika with the id");
		int id=Integer.parseInt(request.getParameter("id"));
		System.out.println("I am here also niharika with the id"+id);
		System.out.println(id);
		discussDAO h=new discussDAO();
		//hashFeed.setParentId(parentId);
		h.deleteReply(id);
		h.deletePost(id);
		
		request.getRequestDispatcher("/searchdiscussServlet").forward(request, response);
		}
		catch(Exception e)
		{
			System.out.println("I am here niharika");
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	private discussDAO discussDAO;
}
