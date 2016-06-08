package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import util.DBHandle;

import model.news;
public class deletenewsDAO {
	public void DeleteInfo(news examObj)
	{
		  try 
		    {
		    	PreparedStatement
		        dbStatement = 
		        DBHanlde.prepareStatement("Delete from news where newsID=?");
		    	
		    	dbStatement.setString(1,examObj.getNewsID()); 
			        
		       // dbStatement.setString(2,courseObj.getCoursename()); 
		       
		        
		
		      System.out.println("NEwsID delete is "+examObj.getNewsID());
	   
		 
		        dbStatement.executeUpdate(); 

		    } catch (Exception AllExceptoin) {
		    	AllExceptoin.printStackTrace();
		    }
		//return courseObj;
		    
		}

		public deletenewsDAO() 
		{
			DBHanlde = DBHandle.getDBHandle();
		}
	   
		public boolean IsPresent(String newsID) {
			try 
		    {
				if(null == DBHanlde)
				{
					System.out.println("db null");
					return false;
				}
		        PreparedStatement dbStatement = DBHanlde.prepareStatement("select * from news where newsID=?");
		        
		        dbStatement.setString(1,newsID);
		        
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
		
		 
		private Connection DBHanlde;
}