package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import util.DBHandle;

import model.resource;
public class resourceDAO {
	public void InsertNewResource(resource resObj)
	{
		//System.out.println(resObj.getResourcetype());
		//System.out.println(resObj.getResourcedate());
		//System.out.println(resObj.getSlotID());
	
	    try 
	    {
	    	
	    	PreparedStatement
	        dbStatement = 
	        DBHanlde.prepareStatement(
	        		"insert into resource(resourcetype,resourcedate,slotID,userID) values (?,?,?,?)");
	      
	        dbStatement.setString(1,resObj.getResourcetype()); 
	        dbStatement.setString(2,resObj.getResourcedate()); 
	        dbStatement.setInt(3,resObj.getSlotID()); 
	        dbStatement.setInt(4,resObj.getUserID()); 
	      System.out.println("res:"+resObj.getResourcetype());

	        dbStatement.executeUpdate(); 

	    } catch (Exception AllExceptoin) {
	    	AllExceptoin.printStackTrace();
	    }
	    
	}
	public resourceDAO() 
	{
		DBHanlde = DBHandle.getDBHandle();
	}
	
	private Connection DBHanlde;
	
	public boolean checkslot(int slotID,int userID,String resourcedate,String resourcetype)
	{
		
		boolean status=true;
		try 
	    {
	    	
	    	PreparedStatement
	        dbStatement = 
	        DBHanlde.prepareStatement(
	      	        		"SELECT count(slotID) FROM resource where slotID=? and userID=? and resourcedate=? and resourcetype=?;");

	   
	        dbStatement.setInt(1,slotID); 
	        dbStatement.setInt(2,userID); 
	        dbStatement.setString(3,resourcedate); 
	        dbStatement.setString(4,resourcetype); 
	        if (dbStatement.executeQuery().next()) {
	            System.out.println("ALready booked");
	            status=false;   //false tha
	        } else status =true; // true tha
	        
	        
	        
	    } catch (Exception AllExceptoin) {
	    	AllExceptoin.printStackTrace();
	    }
		
		return status;
		
	}
	
	public int getuser(int slotID,String resourcedate,String resourcetype)
	{
		int id=0;
		try 
	    {
	    	
	    	PreparedStatement
	        dbStatement = 
	        DBHanlde.prepareStatement(
	      	        		"SELECT userID FROM resource where slotID=? and resourcedate=? and resourcetype=?;");

	   
	        dbStatement.setInt(1,slotID); 
	      
	        dbStatement.setString(2,resourcedate); 
	        dbStatement.setString(3,resourcetype); 
	        ResultSet rs=dbStatement.executeQuery();
	         
	        if(rs.next())
	        {
	        	id=rs.getInt("userID");
	        }
	      
	        
	        
	    } catch (Exception AllExceptoin) {
	    	AllExceptoin.printStackTrace();
	    }
		
		return id;
	}
	public String getUserName(int t) {
		// TODO Auto-generated method stub
		String name="";
		try 
	    {
	    	
	    	PreparedStatement
	        dbStatement = 
	        DBHanlde.prepareStatement(
	      	        		"select fname from Registration where userID=?");

	   
	        dbStatement.setInt(1,t); 
	       
	        ResultSet rs=dbStatement.executeQuery();
	         
	        if(rs.next())
	        {
	        	name=rs.getString("fname");
	        }
	      
	        
	        
	    } catch (Exception AllExceptoin) {
	    	AllExceptoin.printStackTrace();
	    }
		
		return name;
	}

}

