package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.registrationDAO;
import model.Register;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		boolean bResult;
		registrationDAO registrationDao = new registrationDAO();
		//private registrationDAO registrationDao;
		String netID = request.getParameter("netID");
	    String password = request.getParameter("pd");
	    String iam=request.getParameter("iam");
	    System.out.println("email : "+netID+"password"+password +"i am "+iam);
	    
	    bResult = registrationDao.IsPresent(netID);
		if(!bResult)
		{
			 request.setAttribute("error", "usernotfound");
			 RequestDispatcher Dispatch = request.getRequestDispatcher("login.jsp");
			 Dispatch.forward(request, response);       
			 
			//return;
		}
		else
		{
	    bResult = registrationDao.IsAuthenticatedUser(netID, password,iam);
//-------------------------------------------
	    Register UserInfo = registrationDao.GetUserInfo(netID);
		
		//Set the object in the Session.
		javax.servlet.http.HttpSession session = request.getSession();
		session.setAttribute("useremail", UserInfo.getNetID());
		System.out.println("hello:"+UserInfo.getUserID());
		session.setAttribute("userfname", UserInfo.getFname());
		session.setAttribute("userlname", UserInfo.getLname());
		session.setAttribute("userID", UserInfo.getUserID());
		System.out.println(UserInfo.getFname());
		
	    if(iam.equals("faculty"))
		{
		request.getRequestDispatcher("facultyhome1.jsp").forward(request,response);
		}
		else  if(iam.equals("staff"))
		{
		request.getRequestDispatcher("staffhome1.jsp").forward(request,response);	
		}
		else  if(iam.equals("student"))
		{
			System.out.println("student entered");
			request.getRequestDispatcher("studenthome.jsp").forward(request,response);	
		}
	   //-------------------------------------------
				
		
			
		//---------------------------------------------------------------------
			
			//---------------------------------------------------------------------

		
		}
			
		}
		//registrationDao.InsertNewUser(NewUser);
	
		  
		
		
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	//sprivate registrationDAO registrationDao;
}
