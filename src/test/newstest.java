package test;

import static org.junit.Assert.*;

import org.junit.Test;

import dao.courseDAO;
import dao.newsDAO;
import model.course;
import model.news;

public class newstest {

	@Test
	public void test() {
		newsDAO dao=new newsDAO();
		boolean status= dao.IsPresent("niharika");
		
		assertEquals(true, status);
		//fail("Not yet implemented");
	}

}
