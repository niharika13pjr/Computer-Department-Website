package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import util.DBHandle;
import model.Register;
public class registrationDAO {
	public void InsertNewUser(Register RegObj)
	{
	    try 
	    {
	    	PreparedStatement
	        dbStatement = 
	        DBHanlde.prepareStatement(
	        		"insert into Registration"
	        		+ "(fname,lname,password,usertype,netID,year,program,candidate,major)"
	        		+ " values (?,?,?,?,?,?,?,?)");
	      
	        
	        dbStatement.setString(1,RegObj.getFname()); 
	        dbStatement.setString(2,RegObj.getLname()); 
	        dbStatement.setString(3,RegObj.getPassword()); 
	        
	      
	        dbStatement.setString(4,RegObj.getIam()); 
	        dbStatement.setString(5,RegObj.getNetID()); 
	        dbStatement.setString(6,RegObj.getYear());
	       dbStatement.setString(7, RegObj.getProgram());
	        dbStatement.setString(8,RegObj.getCandidate());     
	       dbStatement.setString(9,RegObj.getMajor());
	        //dbStatement.setDate(9,  new java.sql.Date(RegObj.getDob().getTime()));
	        
	        dbStatement.executeUpdate(); 

	    } catch (Exception AllExceptoin) {
	    	AllExceptoin.printStackTrace();
	    }
	    
	}
	public registrationDAO() 
	{
		DBHanlde = DBHandle.getDBHandle();
	}
	public Register GetUserInfo(String netID)
	{
		Register RegObj = new Register();
		 
	    try 
	    {
	    	
	        PreparedStatement dbStatement = DBHanlde.prepareStatement("select * from Registration where netID=?");
	        
	        dbStatement.setString(1, netID);
	        
	        ResultSet Resultset = dbStatement.executeQuery();
	
	       	//If set is not null then the entry is already present.
	        if (Resultset.next())
	        {
	        	
	        	RegObj.setUserID(Resultset.getInt("userID"));
	        	RegObj.setFname(Resultset.getString("fname"));
	        	RegObj.setLname(Resultset.getString("lname"));
	        	RegObj.setNetID(Resultset.getString("netID"));	
	        	
	            return RegObj;
	        }
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		return RegObj;
	
	   
	}
	 
	private Connection DBHanlde;

	public boolean IsPresent(String netID) {
		try 
	    {
			if(null == DBHanlde)
			{
				System.out.println("db null");
				return false;
			}
	        PreparedStatement dbStatement = DBHanlde.prepareStatement("select * from Registration where netID=?");
	        
	        dbStatement.setString(1, netID);
	        
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
	public boolean IsAuthenticatedUser(String netID, String password,String usertype) {
		// TODO Auto-generated method stub
		try 
	    {
	        PreparedStatement dbStatement = DBHanlde.prepareStatement("select * from Registration where netID=? and password=? and usertype=?");
	        
	        dbStatement.setString(1, netID);
	        dbStatement.setString(2, password);
	        dbStatement.setString(3, usertype);
	        
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
	public boolean IsFaculty(String usertype) {
		// TODO Auto-generated method stub
		try 
	    {
	        PreparedStatement dbStatement = DBHanlde.prepareStatement("select * from Registration where usertype=?");
	        
	    
	        dbStatement.setString(1, usertype);
	        
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
