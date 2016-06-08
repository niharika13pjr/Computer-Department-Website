package test;

import static org.junit.Assert.*;

import org.junit.Test;

import dao.courseDAO;
import dao.resourceDAO;
import model.course;
import model.resource;

public class resourcetest {

	@Test
	public void test() {
		resourceDAO dao=new resourceDAO();
		boolean status=dao.checkslot(3,2,"05/16/2016","Conference Room");
		
		assertEquals(false, status);
		//fail("Not yet implemented");
	}

}
