package dao;


	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import util.DBHandle;

	import model.resource;
	public class cancelresourceDAO {
		public void cancelResource(resource resObj)
		{
			//System.out.println(resObj.getResourcetype());
			//System.out.println(resObj.getResourcedate());
			//System.out.println(resObj.getSlotID());
		
		    try 
		    {
		    	
		    	PreparedStatement
		        dbStatement = 
		        DBHanlde.prepareStatement(
		        		"delete from resource where resourcetype=? and resourcedate=? and slotID=? and userID=?");
		      
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
		public cancelresourceDAO() 
		{
			DBHanlde = DBHandle.getDBHandle();
		}
		
		private Connection DBHanlde;
		
}
