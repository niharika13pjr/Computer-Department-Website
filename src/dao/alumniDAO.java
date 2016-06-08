package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import util.DBHandle;
import model.alumni;
public class alumniDAO {
	public void InsertNewAlumni(alumni courseObj)
	{
	    try 
	    {
	    	PreparedStatement
	        dbStatement = 
	        DBHanlde.prepareStatement(
	        		"insert into alumni(alumniID,alumniname,alumnidetail) values (?,?,?)");
	      
	        dbStatement.setString(1,courseObj.getAlumniID()); 
	        dbStatement.setString(2,courseObj.getAlumniname()); 
	        dbStatement.setString(3,courseObj.getAlumnidetail()); 
	       
	      System.out.println("prof:"+courseObj.getAlumnidetail());

	        dbStatement.executeUpdate(); 

	    } catch (Exception AllExceptoin) {
	    	AllExceptoin.printStackTrace();
	    }
	    
	}
	public alumniDAO() 
	{
		DBHanlde = DBHandle.getDBHandle();
	}
	public alumni GetUserInfo(String alumniID)
	{
		alumni courseObj = new alumni();
		 
	    try 
	    {
	    	
	        PreparedStatement dbStatement = DBHanlde.prepareStatement("select * from alumni where alumniID=?");
	        
	        dbStatement.setString(1, alumniID);
	        
	        ResultSet Resultset = dbStatement.executeQuery();
	
	       	//If set is not null then the entry is already present.
	        if (Resultset.next())
	        {
	        	
	        	//RegObj.setUserID(Resultset.getInt("userID"));
	        	courseObj.setAlumniname(Resultset.getString("alumniname"));
	        	courseObj.setAlumnidetail(Resultset.getString("alumnidetail"));
	        	courseObj.setAlumniID(Resultset.getString("alumniID"));	
	        	
	            return courseObj;
	        }
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		return courseObj;
	
	   
	}
	
	
	
	 
	private Connection DBHanlde;

	
	public boolean IsPresent(String alumniID) {
		try 
	    {
			if(null == DBHanlde)
			{
				System.out.println("db null");
				return false;
			}
	        PreparedStatement dbStatement = DBHanlde.prepareStatement("select * from alumni where alumniID=?");
	        
	        dbStatement.setString(1, alumniID);
	        
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
	public boolean IsAuthenticatedUser(String alumniID, String alumniname) {
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
		
	}
}

