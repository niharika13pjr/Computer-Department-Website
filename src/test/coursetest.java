package test;

import static org.junit.Assert.*;

import org.junit.Test;

import dao.courseDAO;
import model.course;

public class coursetest {

	@Test
	public void test1() {
		courseDAO dao=new courseDAO();
		course c=dao.GetUserInfo("8");
		String id=c.getCourseID();
		assertEquals(id,"8");
		//fail("Not yet implemented");
	}
	/*public void test2() {
		courseDAO dao=new courseDAO();
		boolean c=dao.IsAuthenticatedUser("2", "a");
		
		assertEquals(c,"2");
		//fail("Not yet implemented");
	}*/
}
