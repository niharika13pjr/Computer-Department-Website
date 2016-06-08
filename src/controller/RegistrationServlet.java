package controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.registrationDAO;
import model.Register;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
        super();
        registrationDao = new registrationDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		boolean bResult;
		
		//All parameter get here.
		String candidate="no";
	    String fname = request.getParameter("fname");
	    String lname = request.getParameter("lname");
	    
	    String netID = request.getParameter("netID");
	    //String dob = request.getParameter("dob");
	    String password = request.getParameter("password");
	    String iam=request.getParameter("iam");
	    String program=request.getParameter("program");
	    String year=request.getParameter("year");
	    String major=request.getParameter("major");
	    String sem=request.getParameter("sem");
	    //String candidate=request.getParameter("candidate");
	    bResult = registrationDao.IsPresent(netID);
	    
		if(bResult)
		{
			 request.setAttribute("error", "AlreadyPresent");
			 RequestDispatcher Dispatch = request.getRequestDispatcher("register.jsp");
			 
			 Dispatch.forward(request, response);       	 
			 return ;
		}
		
	//	Date DOBdate = null;
	    
	   // DateFormat format = new SimpleDateFormat("dd-mm-yyyy", Locale.ENGLISH);
	   // System.out.println("Date is : "+dob);
	    //try
	    //{
	    	//DOBdate = format.parse(dob);	
	    //}
	    //catch(Exception e)
	    //{
			// request.setAttribute("error", "Internal Error");
			 //RequestDispatcher Dispatch = request.getRequestDispatcher("register.jsp");
			 //Dispatch.forward(request, response);     
			 //System.out.println("exception while parsing date");
			 //return;
	    //}
		
		
	    Register NewUser = new Register();
		NewUser.setFname(fname);
		NewUser.setLname(lname);
		NewUser.setPassword(password);
		NewUser.setNetID(netID);
		NewUser.setIam(iam);
		NewUser.setProgram(program);
		NewUser.setYear(year);
		NewUser.setCandidate(candidate);
		NewUser.setMajor(major);
		NewUser.setMajor(sem);



		registrationDao.InsertNewUser(NewUser);
		
		request.setAttribute("error", "");

		request.setAttribute("netID", netID);
		RequestDispatcher Dispatch = request.getRequestDispatcher("login.jsp");
		Dispatch.forward(request, response);  
		/*----------------------------------------------------------------
		Register UserInfo = registrationDao.GetUserInfo(netID);
		HttpSession session	= request.getSession();
		session.setAttribute("fname",UserInfo.getFname());
		session.setAttribute("lname",UserInfo.getLname());
		session.setAttribute("netID",UserInfo.getNetID());
		session.setAttribute("password",UserInfo.getPassword());
	    // -----------------------------------------------------------------*/
       // return;
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	private registrationDAO registrationDao;
}
