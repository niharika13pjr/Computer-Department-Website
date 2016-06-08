package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.DBHandle;
import model.exam;
import model.news;
public class newsDAO {
	public void InsertNewNews(news newsObj)
	{
	//	DateFormat dateFormatMDY = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		//Date now = new Date();
	    try 
	    {
	    	//java.sql.Timestamp sqlDate = new java.sql.Timestamp(courseObj.getExamdate().getTime());
	    	PreparedStatement
	        dbStatement = 
	        DBHanlde.prepareStatement(
	        		"insert into news(newsID,newsname,newsdetail) values (?,?,?)");
	      
	        dbStatement.setString(1,newsObj.getNewsID()); 
	        dbStatement.setString(2,newsObj.getNewsname()); 
	        dbStatement.setString(3,newsObj.getNewsdetail()); 
	       
	      System.out.println("News:"+newsObj.getNewsname());

	        dbStatement.executeUpdate(); 

	    } catch (Exception AllExceptoin) {
	    	AllExceptoin.printStackTrace();
	    }
	    
	}
	public newsDAO() 
	{
		DBHanlde = DBHandle.getDBHandle();
	}

	private Connection DBHanlde;
	public boolean IsPresent(String newsname) {
		try 
	    {
			if(null == DBHanlde)
			{
				System.out.println("db null");
				return false;
			}
	        PreparedStatement dbStatement = DBHanlde.prepareStatement("select * from news where newsname=?");
	        
	        dbStatement.setString(1, newsname);
	        
	        ResultSet Resultset = dbStatement.executeQuery();
	
	        //If set is not null then the entry is already present.
	        if (Resultset.next())
	        {
	            return true;
	        }
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	
	    
		// TODO Auto-generated method stub
		return false;
	}
}
