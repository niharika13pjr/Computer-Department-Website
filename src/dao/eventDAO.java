package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.DBHandle;
import model.event;

public class eventDAO {
	public void InsertNewEvent(event eventObj)
	{
	//	DateFormat dateFormatMDY = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		//Date now = new Date();
	    try 
	    {
	    	//java.sql.Timestamp sqlDate = new java.sql.Timestamp(courseObj.getExamdate().getTime());
	    	PreparedStatement
	        dbStatement = 
	        DBHanlde.prepareStatement(
	        		"insert into event(eventID,eventname,eventdetail) values (?,?,?)");
	      
	        dbStatement.setString(1,eventObj.getEventID()); 
	        dbStatement.setString(2,eventObj.getEventname()); 
	        dbStatement.setString(3,eventObj.getEventdetail()); 
	       
	      System.out.println("event:"+eventObj.getEventID());

	        dbStatement.executeUpdate(); 

	    } catch (Exception AllExceptoin) {
	    	AllExceptoin.printStackTrace();
	    }
	    
	}
	public eventDAO() 
	{
		DBHanlde = DBHandle.getDBHandle();
	}
	
	private Connection DBHanlde;
	public boolean IsPresent(String eventname) {
		try 
	    {
			if(null == DBHanlde)
			{
				System.out.println("db null");
				return false;
			}
	        PreparedStatement dbStatement = DBHanlde.prepareStatement("select * from event where eventname=?");
	        
	        dbStatement.setString(1,eventname);
	        
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
