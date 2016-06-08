package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import util.DBHandle;

import model.deptexam;
public class editdeptExamDAO {
	public void EditInfo(deptexam examObj)
	{
		  try 
		    {
		    	PreparedStatement
		        dbStatement = 
		        DBHanlde.prepareStatement(
		        		"Update deptexam set dexamname=?,result=? where studentexamID=?");
		    	
		    	dbStatement.setString(1,examObj.getDexamname()); 
			        dbStatement.setString(2,examObj.getResult()); 
		        dbStatement.setString(3,examObj.getStudentexamID()); 
		       // dbStatement.setString(2,courseObj.getCoursename()); 
		       
		        
		
		      System.out.println("id:"+examObj.getDexamname());
		      System.out.println("name:"+examObj.getResult());
		      System.out.println("det:"+examObj.getStudentexamID());
		       
		 
		        dbStatement.executeUpdate(); 

		    } catch (Exception AllExceptoin) {
		    	AllExceptoin.printStackTrace();
		    }
		//return courseObj;
		    
		}

		public editdeptExamDAO() 
		{
			DBHanlde = DBHandle.getDBHandle();
		}
	   
	
		public deptexam GetUserInfo(String studentexamID)
		{
			deptexam courseObj = new deptexam();
			 
		    try 
		    {
		    	
		        PreparedStatement dbStatement = DBHanlde.prepareStatement("select * from deptexam where studentexamID=?");
		        
		        dbStatement.setString(1, studentexamID);
		        
		        ResultSet Resultset = dbStatement.executeQuery();
		
		       	//If set is not null then the entry is already present.
		        if (Resultset.next())
		        {
		        	
		        	//RegObj.setUserID(Resultset.getInt("userID"));
		        	courseObj.setDexamname(Resultset.getString("dexamname"));
		        	courseObj.setResult(Resultset.getString("result"));
		        	courseObj.setStudentexamID(Resultset.getString("studentexamID"));	
		        	
		            return courseObj;
		        }
		        
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
			return courseObj;
		
		   
		}
		
		
		
		 
		private Connection DBHanlde;

		
		public boolean IsPresent(String studentexamID) {
			try 
		    {
				if(null == DBHanlde)
				{
					System.out.println("db null");
					return false;
				}
		        PreparedStatement dbStatement = DBHanlde.prepareStatement("select * from deptexam where studentexamID=?");
		        
		        dbStatement.setString(1, studentexamID);
		        
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
		public boolean IsAuthenticatedUser(String studentexamID, String dexamname) {
			// TODO Auto-generated method stub
			try 
		    {
		        PreparedStatement dbStatement = DBHanlde.prepareStatement("select * from deptexam where studentexamID=? and dexamname=?");
		        
		        dbStatement.setString(1, studentexamID);
		        dbStatement.setString(2, dexamname);
		        
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
