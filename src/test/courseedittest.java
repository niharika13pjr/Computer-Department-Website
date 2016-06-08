package test;

import static org.junit.Assert.*;

import org.junit.Test;

import dao.courseEditDAO;
import dao.jobaddServletDAO;

public class courseedittest {

	@Test
	public void test() {
		courseEditDAO dao=new courseEditDAO();
		boolean status= dao.IsPresent("1");
		
		assertEquals(true, status);
		//fail("Not yet implemented");
	}

}
