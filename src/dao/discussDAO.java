package dao;
import java.sql.*;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import util.DBHandle;
import java.sql.Connection;
import model.discuss;
public class discussDAO {
	
	public discussDAO() 
	{
		DBHanlde = DBHandle.getDBHandle();
	}
	
	public void insertHashtagFeed(discuss htf)
	{
		try
		{
		
		java.sql.Timestamp sqlDate = new java.sql.Timestamp(htf.getpostedDate().getTime());
		PreparedStatement dbStatement = DBHanlde.prepareStatement("Insert into discuss(postedTime,parentID,content)"+"values(?,?,?)");
		
		
		dbStatement.setTimestamp(1, sqlDate);
		dbStatement.setInt(2, htf.getParentId());
		//preparedStmt.setString(3, htf.getHashtag());
		dbStatement.setString(3, htf.getcontent());
		dbStatement.executeUpdate();
	   
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public void deleteReply(int id)
	{
		try
		{
		
		//java.sql.Timestamp sqlDate = new java.sql.Timestamp(htf.getpostedDate().getTime());
		PreparedStatement dbStatement = DBHanlde.prepareStatement("Delete from discuss where parentID=?");
		
		
		//dbStatement.setTimestamp(1, sqlDate);
		dbStatement.setInt(1, id);
		//dbStatement.setInt(2, id);
		System.out.println(id);
		//System.out.println("ParentID is here" +htf.getParentId());
		//dbStatement.setString(3, htf.getcontent());
		dbStatement.executeUpdate();
	   
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public void deletePost(int id)
	{
		try
		{
		
		//java.sql.Timestamp sqlDate = new java.sql.Timestamp(htf.getpostedDate().getTime());
		PreparedStatement dbStatement = DBHanlde.prepareStatement("Delete from discuss where id=?");
		
		
		//dbStatement.setTimestamp(1, sqlDate);
		//dbStatement.setInt(1, htf.getParentId());
		dbStatement.setInt(1, id);
		System.out.println(id);
		//dbStatement.setString(3, htf.getcontent());
		dbStatement.executeUpdate();
	   
		}
		catch(Exception e)
		{
			System.out.println(e);
			
		}
	}
	private Connection DBHanlde;
	public ArrayList<discuss> fetchHashtagFeed()
	{
		
		try
		{
		
		
		PreparedStatement dbStatement = DBHanlde.prepareStatement("Select * from discuss order by postedTime desc");
		

		System.out.println("here4");
		//dbStatement.setString(1, htf);

		ResultSet re=dbStatement.executeQuery();
		
		//HashtagFeed[] htf2;
		System.out.println("here5");
		//if(size>0)
		//htf2=new HashtagFeed[size];
		ArrayList<discuss> htf2 = new ArrayList<discuss>(); 
		 
		while(re.next())
		{
			
			//System.out.println(re.getInt("id"));
			//System.out.println(re.getTimestamp("postedTime"));
			/*
			System.out.println(re.getInt("parentFeedID"));
			System.out.println(re.getString("hashtagname"));
			System.out.println(re.getString("content"));
			*/
			discuss hashtagfeed=new discuss();
			hashtagfeed.setId(re.getInt("id"));
			hashtagfeed.setcontent(re.getString("content"));
		//	hashtagfeed.setHashtag(re.getString("hashtagname"));
			hashtagfeed.setParentId(re.getInt("parentID"));
			hashtagfeed.setpostedDate(re.getTimestamp("postedTime"));
			htf2.add(hashtagfeed);
		}
		System.out.println("here6");
		
		return htf2;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return null;
		}
	}
}
