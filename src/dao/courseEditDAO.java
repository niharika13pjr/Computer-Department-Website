package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import util.DBHandle;
import model.course;
public class courseEditDAO {
	public void EditInfo(course courseObj)
	{
		  try 
		    {
		    	PreparedStatement
		        dbStatement = 
		        DBHanlde.prepareStatement(
		        		"Update course set coursesyllabus=?,profoffcdetails=?,taofficedetails=? where courseID=?");
		      
		        
		        dbStatement.setString(4,courseObj.getCourseID()); 
		       // dbStatement.setString(2,courseObj.getCoursename()); 
		        dbStatement.setString(1,courseObj.getCoursesyllabus()); 
		        
		      System.out.println("prof:"+courseObj.getProfoffcdetails());
		      System.out.println("id:"+courseObj.getCourseID());
		      System.out.println("sylll:"+courseObj.getCoursesyllabus());
		      System.out.println("ta:"+courseObj.getTaofficedetails());
		        dbStatement.setString(2,courseObj.getProfoffcdetails()); 
		        dbStatement.setString(3,courseObj.getTaofficedetails()); 
		       // dbStatement.setString(6,courseObj.getProfname());
		     //  dbStatement.setString(7, courseObj.getProfemail());
		                
		        dbStatement.executeUpdate(); 

		    } catch (Exception AllExceptoin) {
		    	AllExceptoin.printStackTrace();
		    }
		//return courseObj;
		    
		}

		public courseEditDAO() 
		{
			DBHanlde = DBHandle.getDBHandle();
		}
	   
	
		public course GetUserInfo(String courseID)
		{
			course courseObj = new course();
			 
		    try 
		    {
		    	
		        PreparedStatement dbStatement = DBHanlde.prepareStatement("select * from course where courseID=?");
		        
		        dbStatement.setString(1, courseID);
		        
		        ResultSet Resultset = dbStatement.executeQuery();
		
		       	//If set is not null then the entry is already present.
		        if (Resultset.next())
		        {
		        	
		        	//RegObj.setUserID(Resultset.getInt("userID"));
		        	courseObj.setCoursename(Resultset.getString("coursename"));
		        	courseObj.setCoursesyllabus(Resultset.getString("coursesyllabus"));
		        	courseObj.setCourseID(Resultset.getString("courseID"));	
		        	
		            return courseObj;
		        }
		        
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
			return courseObj;
		
		   
		}
		
		
		
		 
		private Connection DBHanlde;

		
		public boolean IsPresent(String courseID) {
			try 
		    {
				if(null == DBHanlde)
				{
					System.out.println("db null");
					return false;
				}
		        PreparedStatement dbStatement = DBHanlde.prepareStatement("select * from course where courseID=?");
		        
		        dbStatement.setString(1, courseID);
		        
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
		public boolean IsAuthenticatedUser(String courseID, String coursename) {
			// TODO Auto-generated method stub
			try 
		    {
		        PreparedStatement dbStatement = DBHanlde.prepareStatement("select * from course where courseID=? and coursename=?");
		        
		        dbStatement.setString(1, courseID);
		        dbStatement.setString(2, coursename);
		        
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