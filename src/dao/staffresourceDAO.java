package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.staffresource;
import util.DBHandle;

public class staffresourceDAO {
	public void Insertstaffresource(staffresource courseObj)
	{
	    try 
	    {
	    	PreparedStatement
	        dbStatement = 
	        DBHanlde.prepareStatement(
	        		"insert into staffresource(resourcetype,resourcedetail) values (?,?)");
	      
	        //dbStatement.setInt(1,courseObj.getResourceID()); 
	        dbStatement.setString(1,courseObj.getResourcetype()); 
	        dbStatement.setString(2,courseObj.getResourcedetail()); 
	       
	      System.out.println("Resource detail :"+courseObj.getResourcedetail());

	        dbStatement.executeUpdate(); 

	    } catch (Exception AllExceptoin) {
	    	AllExceptoin.printStackTrace();
	    }
	    
	}
	public staffresourceDAO() 
	{
		DBHanlde = DBHandle.getDBHandle();
	}
	private Connection DBHanlde;
	
	public boolean IsPresent(String resourcetype) {
		try 
	    {
			if(null == DBHanlde)
			{
				System.out.println("db null");
				return false;
			}
	        PreparedStatement dbStatement = DBHanlde.prepareStatement("select * from staffresource where resourcetype=?");
	        
	        dbStatement.setString(1, resourcetype);
	        
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
