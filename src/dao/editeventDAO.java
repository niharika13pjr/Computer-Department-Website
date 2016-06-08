package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import util.DBHandle;

import model.event;
public class editeventDAO {
	public void EditInfo(event examObj)
	{
		  try 
		    {
		    	PreparedStatement
		        dbStatement = 
		        DBHanlde.prepareStatement(
		        		"Update event set eventname=?,eventdetail=? where eventID=?");
		    	
		    	dbStatement.setString(1,examObj.getEventname()); 
			        dbStatement.setString(2,examObj.getEventdetail()); 
		        dbStatement.setString(3,examObj.getEventID()); 
		       // dbStatement.setString(2,courseObj.getCoursename()); 
		       
		        
		
		      System.out.println("id:"+examObj.getEventID());
		      
		 
		        dbStatement.executeUpdate(); 

		    } catch (Exception AllExceptoin) {
		    	AllExceptoin.printStackTrace();
		    }
		//return courseObj;
		    
		}

		public editeventDAO() 
		{
			DBHanlde = DBHandle.getDBHandle();
		}
		private Connection DBHanlde;
		public boolean IsPresent(String eventID) {
			try 
		    {
				if(null == DBHanlde)
				{
					System.out.println("db null");
					return false;
				}
		        PreparedStatement dbStatement = DBHanlde.prepareStatement("select * from event where eventID=?");
		        
		        dbStatement.setString(1, eventID);
		        
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
