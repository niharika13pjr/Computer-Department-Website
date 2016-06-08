package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import util.DBHandle;

import model.job;
public class editjobDAO {
	public void EditInfo(job examObj)
	{
		  try 
		    {
		    	PreparedStatement
		        dbStatement = 
		        DBHanlde.prepareStatement(
		        		"Update job set jobtype=?,joblink=? where jobname=?");
		    	
		    	dbStatement.setString(1,examObj.getJobtype()); 
			        dbStatement.setString(2,examObj.getJoblink()); 
		        dbStatement.setString(3,examObj.getJobname()); 
		       // dbStatement.setString(2,courseObj.getCoursename()); 
		       
		        
		
		      System.out.println("id:"+examObj.getJobname());
		      
		 
		        dbStatement.executeUpdate(); 

		    } catch (Exception AllExceptoin) {
		    	AllExceptoin.printStackTrace();
		    }
		//return courseObj;
		    
		}

		public editjobDAO() 
		{
			DBHanlde = DBHandle.getDBHandle();
		}
		private Connection DBHanlde;
		public boolean IsPresent(String jobname) {
			try 
		    {
				if(null == DBHanlde)
				{
					System.out.println("db null");
					return false;
				}
		        PreparedStatement dbStatement = DBHanlde.prepareStatement("select * from job where jobname=?");
		        
		        dbStatement.setString(1, jobname);
		        
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
