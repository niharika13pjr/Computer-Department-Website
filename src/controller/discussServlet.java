package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;

import dao.alumniDAO;
import dao.discussDAO;
import model.discuss;
/**
 * Servlet implementation class discussServlet
 */
@WebServlet("/discussServlet")
public class discussServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public discussServlet() {
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
		doPost(request,response);
		
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String msg2="";
		try
		{
		int parentId=Integer.parseInt(request.getParameter("parentid"));
		discuss hashFeed=new discuss();
		
		
		discussDAO h=new discussDAO();
		//System.out.println(parentId);
		String cont;
		String hashtag=request.getParameter("hash");
		//hash.setHashtag(hashtag);
		//hashFeed.setHashtag(hashtag);
		if(parentId==0)
			cont=request.getParameter("postContent");
		else
			cont=request.getParameter("replyContent");
		
		if(validateContent(cont))
		{
		Date createdDate=new Date();
		hashFeed.setcontent(cont);
		
		hashFeed.setParentId(parentId);
		//SimpleDateFormat sd=new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		//System.out.println("Date:"+createdDate);
		hashFeed.setpostedDate(createdDate);
		//System.out.println(hashFeed.getpostedDate());
		h.insertHashtagFeed(hashFeed);
		}
		else
		{
			msg2="Please enter a valid content/reply";
		}
		
		ArrayList<discuss> Hashtagvalues=new ArrayList<discuss>(); 
		Hashtagvalues=h.fetchHashtagFeed();
		/*for(int i=0;i<Hashtagvalues.size();i++)
		{
			
		}*/
	//	request.setAttribute("hash", hash);
		System.out.println("hello");
		request.setAttribute("Hashtagvalues", Hashtagvalues);
		request.setAttribute("msg2",msg2);
		request.getRequestDispatcher("discuss.jsp").forward(request, response);
		
		
		}
		catch(Exception e)
		{
			System.out.println(e);
			System.out.println("here4554545");
		}
		//HashtagFeed[] has=new HashtagFeed[10];
	}
	


	public boolean validateContent(String content)
	{
		if((content!=null)&&(!content.isEmpty()))
		{
		if(content.length()<150)
			return true;
		else
			return false;
		}
		else
			return false;
	}
	private discussDAO discussDAO;
}
