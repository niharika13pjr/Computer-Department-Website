package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import util.DBHandle;

import model.job;
public class jobaddServletDAO {
	public void InsertNewJob(job jobObj)
	{
	    try 
	    {
	    	PreparedStatement
	        dbStatement = 
	        DBHanlde.prepareStatement(
	        		"insert into job(jobname,jobtype,joblink) values (?,?,?)");
	      
	        dbStatement.setString(1,jobObj.getJobname()); 
	        dbStatement.setString(2,jobObj.getJobtype()); 
	        dbStatement.setString(3,jobObj.getJoblink()); 
	       
	      System.out.println("prof:"+jobObj.getJoblink());

	        dbStatement.executeUpdate(); 

	    } catch (Exception AllExceptoin) {
	    	AllExceptoin.printStackTrace();
	    }
	    
	}
	public jobaddServletDAO() 
	{
		DBHanlde = DBHandle.getDBHandle();
	}
	public job GetUserInfo(String jobname)
	{
		job courseObj = new job();
		 
	    try 
	    {
	    	
	        PreparedStatement dbStatement = DBHanlde.prepareStatement("select * from jobname where jobname=?");
	        
	        dbStatement.setString(1, jobname);
	        
	        ResultSet Resultset = dbStatement.executeQuery();
	
	       	//If set is not null then the entry is already present.
	        if (Resultset.next())
	        {
	        	
	        	//RegObj.setUserID(Resultset.getInt("userID"));
	        	courseObj.setJobname(Resultset.getString("jobname"));
	        	courseObj.setJobtype(Resultset.getString("jobtype"));
	        	
	        	
	            return courseObj;
	        }
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		return courseObj;
	
	   
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
	/*public boolean IsAuthenticatedUser(String alumniID, String alumniname) {
		// TODO Auto-generated method stub
		try 
	    {
	        PreparedStatement dbStatement = DBHanlde.prepareStatement("select * from alumni where alumniID=? and alumniname=?");
	        
	        dbStatement.setString(1, alumniID);
	        dbStatement.setString(2, alumniname);
	        
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
		
	}*/
}
