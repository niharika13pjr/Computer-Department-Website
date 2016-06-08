package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import dao.discussDAO;
import model.discuss;
/**
 * Servlet implementation class searchdiscussServlet
 */
@WebServlet("/searchdiscussServlet")
public class searchdiscussServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public searchdiscussServlet() {
        super();
       discussDAO = new discussDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String errormessage="";
		String msg="";
		try
		{
		
			discussDAO h=new discussDAO();
			
				ArrayList<discuss> Hashtagvalues=new ArrayList<discuss>(); 
				System.out.println("here1");
				Hashtagvalues=h.fetchHashtagFeed();
				System.out.println("here2");
				if(Hashtagvalues.size()<1)
				{
					msg="No posts created so far";
					request.setAttribute("msg", msg);
				}
				String msg2="";
				request.setAttribute("msg2", msg2);
				request.setAttribute("Hashtagvalues", Hashtagvalues);
				request.getRequestDispatcher("discuss.jsp").forward(request, response);
			
	
		}
		catch(Exception e)
		{
			System.out.println("here3");
		}
	}


		
	private discussDAO discussDAO;
	}


