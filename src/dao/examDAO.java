package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.DBHandle;
import model.exam;
public class examDAO {
	public void InsertNewAlumni(exam courseObj)
	{
	//	DateFormat dateFormatMDY = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		//Date now = new Date();
	    try 
	    {
	    	//java.sql.Timestamp sqlDate = new java.sql.Timestamp(courseObj.getExamdate().getTime());
	    	PreparedStatement
	        dbStatement = 
	        DBHanlde.prepareStatement(
	        		"insert into exam(examname,examdate,examlink) values (?,?,?)");
	      
	        dbStatement.setString(1,courseObj.getExamname()); 
	        dbStatement.setString(2,courseObj.getExamdate()); 
	        dbStatement.setString(3,courseObj.getExamlink()); 
	       
	      System.out.println("prof:"+courseObj.getExamname());

	        dbStatement.executeUpdate(); 

	    } catch (Exception AllExceptoin) {
	    	AllExceptoin.printStackTrace();
	    }
	    
	}
	public examDAO() 
	{
		DBHanlde = DBHandle.getDBHandle();
	}
	public exam GetUserInfo(String examname)
	{
		exam courseObj = new exam();
		 
	    try 
	    {
	    	
	        PreparedStatement dbStatement = DBHanlde.prepareStatement("select * from exam where examname=?");
	        
	        dbStatement.setString(1, examname);
	        
	        ResultSet Resultset = dbStatement.executeQuery();
	
	       	//If set is not null then the entry is already present.
	        if (Resultset.next())
	        {
	        	
	        	//RegObj.setUserID(Resultset.getInt("userID"));
	        	courseObj.setExamname(Resultset.getString("examname"));
	        //	courseObj.setExamdate(Resultset.getDate("examdate"));
	        	courseObj.setExamlink(Resultset.getString("examlink"));	
	        	
	            return courseObj;
	        }
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		return courseObj;
	
	   
	}
	
	private Connection DBHanlde;

	
	public boolean IsPresent(String examname) {
		try 
	    {
			if(null == DBHanlde)
			{
				System.out.println("db null");
				return false;
			}
	        PreparedStatement dbStatement = DBHanlde.prepareStatement("select * from exam where examname=?");
	        
	        dbStatement.setString(1,examname);
	        
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
	public boolean IsAuthenticatedUser(String examname) {
		// TODO Auto-generated method stub
		try 
	    {
	        PreparedStatement dbStatement = DBHanlde.prepareStatement("select * from exam where examname=?");
	        
	        
	        dbStatement.setString(1, examname);
	        
	        ResultSet Resultset = dbStatement.executeQuery();
	
	        //If set is not null then the entry is already present.
	        if (Resultset.next())
	        {
	            return true;
	        }
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	
	    return false;
		
	}
}

