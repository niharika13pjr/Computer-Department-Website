package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import util.DBHandle;

import model.deptexam;
import model.regexam;
public class deptexamDAO {
	public void Insertresult(deptexam deptexamObj)
	{
	    try 
	    {
	    	PreparedStatement
	        dbStatement = 
	        DBHanlde.prepareStatement(
	        		"insert into deptexam(dexamname,studentexamID,result) values (?,?,?)");
	      
	        dbStatement.setString(1,deptexamObj.getDexamname()); 
	        dbStatement.setString(2,deptexamObj.getStudentexamID()); 
	        dbStatement.setString(3,deptexamObj.getResult()); 
	       
	      System.out.println("prof:"+deptexamObj.getResult());

	        dbStatement.executeUpdate(); 

	    } catch (Exception AllExceptoin) {
	    	AllExceptoin.printStackTrace();
	    }
	    
	}
	public deptexamDAO() 
	{
		DBHanlde = DBHandle.getDBHandle();
	}
	private Connection DBHanlde;
	public boolean IsPresent(String dexamname) {
		try 
	    {
			if(null == DBHanlde)
			{
				System.out.println("db null");
				return false;
			}
	        PreparedStatement dbStatement = DBHanlde.prepareStatement("select * from deptexam where dexamname=?");
	        
	        dbStatement.setString(1, dexamname);
	        
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
	
	public boolean check(int userID,String examname)
	{
		
		boolean status=true;
		try 
	    {
	    	
	    	PreparedStatement
	        dbStatement = 
	        DBHanlde.prepareStatement(
	      	        		"SELECT count(slotID) FROM resource where slotID=? and userID=? and resourcedate=? and resourcetype=?;");

	   
	       
	        dbStatement.setInt(1,userID); 
	        dbStatement.setString(2,examname); 
	     
	        if (dbStatement.executeQuery().next()) {
	            System.out.println("ALready booked");
	            status=false;   //false tha
	        } else status =true; // true tha
	        
	        
	        
	    } catch (Exception AllExceptoin) {
	    	AllExceptoin.printStackTrace();
	    }
		
		return status;
		
	}
	
	public void Insertstudentreg(regexam deptexamObj)
	{
	    try 
	    {
	    	PreparedStatement
	        dbStatement = 
	        DBHanlde.prepareStatement(
	        		"insert into regexam(userID,examname) values (?,?)");
	      
	        dbStatement.setInt(1,deptexamObj.getUserID()); 
	        dbStatement.setString(2,deptexamObj.getExamname()); 
	      
	       
	      System.out.println("IN DAO This is the user iD :"+deptexamObj.getUserID());

	        dbStatement.executeUpdate(); 

	    } catch (Exception AllExceptoin) {
	    	AllExceptoin.printStackTrace();
	    }
	    
	}
	
	
	public int getuser(int userID,String examname)
	{
		int id=0;
		try 
	    {
	    	
	    	PreparedStatement
	        dbStatement = 
	        DBHanlde.prepareStatement(
	      	        		"SELECT *  FROM regexam where userID=?  and examname=?;");

	   
	      //  dbStatement.setInt(1,slotID); 
	      
	        dbStatement.setInt(1,userID); 
	        dbStatement.setString(2,examname); 
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
	
}
