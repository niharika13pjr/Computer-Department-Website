package dao;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import util.DBHandle;
import model.Register;
import model.course;
import util.DBHandle;

public class updatephdDAO {
	public void updateInfo(Register phdObj)
{
	try 
    {
    	PreparedStatement
        dbStatement = 
        DBHanlde.prepareStatement(
        		"Update Registration set candidate=? where fname=?");
      
        
        //dbStatement.setString(4,courseObj.getCourseID()); 
       // dbStatement.setString(2,courseObj.getCoursename()); 
        dbStatement.setString(1,phdObj.getCandidate()); 
        
     // System.out.println("prof:"+courseObj.getProfoffcdetails());
   //   System.out.println("id:"+courseObj.getCourseID());
     // System.out.println("sylll:"+courseObj.getCoursesyllabus());
   //   System.out.println("ta:"+courseObj.getTaofficedetails());
        dbStatement.setString(2,phdObj.getFname()); 
     //  dbStatement.setString(3,phdObj.getAdvisordetail()); 
       // dbStatement.setString(6,courseObj.getProfname());
     //  dbStatement.setString(7, courseObj.getProfemail());
                
        dbStatement.executeUpdate(); 

    } catch (Exception AllExceptoin) {
    	AllExceptoin.printStackTrace();
    }
//return courseObj;
    
}

public updatephdDAO() 
{
	DBHanlde = DBHandle.getDBHandle();
}
private Connection DBHanlde;

public Register GetUserInfo(String fname)
{
	Register courseObj = new Register();
	 
    try 
    {
    	
        PreparedStatement dbStatement = DBHanlde.prepareStatement("select * from Registration where fname=?");
        
        dbStatement.setString(1, fname);
        
        ResultSet Resultset = dbStatement.executeQuery();

       	//If set is not null then the entry is already present.
        if (Resultset.next())
        {
        	
        	//RegObj.setUserID(Resultset.getInt("userID"));
        	courseObj.setFname(Resultset.getString("fname"));
        	//courseObj.setCoursesyllabus(Resultset.getString("coursesyllabus"));
        	//courseObj.setCourseID(Resultset.getString("courseID"));	
        	
            return courseObj;
        }
        
    } catch (SQLException e) {
        e.printStackTrace();
    }
	return courseObj;

   
}
}
