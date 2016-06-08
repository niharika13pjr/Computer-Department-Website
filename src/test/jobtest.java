package test;

import static org.junit.Assert.*;

import org.junit.Test;

import dao.jobaddServletDAO;
import dao.newsDAO;

public class jobtest {

	@Test
	public void test() {
		jobaddServletDAO dao=new jobaddServletDAO();
		boolean status= dao.IsPresent("hh");
		
		assertEquals(true, status);
		//fail("Not yet implemented");
	}

}
