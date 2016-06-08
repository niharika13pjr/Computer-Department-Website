package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import util.DBHandle;
import model.Register;
public class editprofileDAO {
	public void EditProfile(Register editObj)
	{
		  try 
		    {
		    	PreparedStatement
		        dbStatement = 
		        DBHanlde.prepareStatement(
		        		"Update Registration set phone=?,advisordetail=?,email=? where netID=?");
		    	
		    	dbStatement.setString(1,editObj.getPhone()); 
		    	System.out.println("in dao"+editObj.getPhone());
			    dbStatement.setString(2,editObj.getAdvisordetail()); 
			    System.out.println("in dao"+editObj.getAdvisordetail());
		        dbStatement.setString(3,editObj.getEmail()); 
		        System.out.println("in dao"+editObj.getEmail());
		        dbStatement.setString(4,editObj.getNetID()); 
		        System.out.println("in dao"+editObj.getNetID());
		 
		        dbStatement.executeUpdate(); 

		    } catch (Exception AllExceptoin) {
		    	AllExceptoin.printStackTrace();
		    }
		//return courseObj;
		    
		}

		public editprofileDAO() 
		{
			DBHanlde = DBHandle.getDBHandle();
		}
	   
	
		public Register GetUserInfo(String netID)
		{
			Register courseObj = new Register();
			 
		    try 
		    {
		    	
		        PreparedStatement dbStatement = DBHanlde.prepareStatement("select * from registration where netID=?");
		        
		        dbStatement.setString(1, netID);
		        
		        ResultSet Resultset = dbStatement.executeQuery();
		
		       	//If set is not null then the entry is already present.
		        if (Resultset.next())
		        {
		        	
		        	//RegObj.setUserID(Resultset.getInt("userID"));
		        	courseObj.setPhone(Resultset.getString("phone"));
		        	courseObj.setAdvisordetail(Resultset.getString("advisordetail"));
		        	courseObj.setEmail(Resultset.getString("email"));	
		        	courseObj.setNetID(Resultset.getString("netID"));	
		            return courseObj;
		        }
		        
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
			return courseObj;
		
		   
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
		        PreparedStatement dbStatement = DBHanlde.prepareStatement("select * from registration where netID=?");
		        
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
		public boolean IsAuthenticatedUser(String netID,String usertype) {
			// TODO Auto-generated method stub
			try 
		    {
		        PreparedStatement dbStatement = DBHanlde.prepareStatement("select * from registration where usertype=?");
		        
		      
		        dbStatement.setString(1, usertype);
		        
		        ResultSet Resultset = dbStatement.executeQuery();
		
		        //If set is not null then the entry is already present.
		        if (Resultset.next())
		        {
		        	
		            return true;
		        }
		        
		    } catch (SQLException e) {
		    	System.out.println("Wrong");
		        e.printStackTrace();
		    }
		
		    return false;
			
		}

		
}
