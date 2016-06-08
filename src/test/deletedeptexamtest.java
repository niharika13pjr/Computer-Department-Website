package test;

import static org.junit.Assert.*;

import org.junit.Test;

import dao.jobaddServletDAO;

public class deletedeptexamtest {

	@Test
	public void test() {
		jobaddServletDAO dao=new jobaddServletDAO();
		boolean status= dao.IsPresent("se");
		
		assertEquals(false, status);
		//fail("Not yet implemented");
	}

}
