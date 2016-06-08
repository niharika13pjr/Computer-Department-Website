package test;

import static org.junit.Assert.*;

import org.junit.Test;

import dao.deletenewsDAO;
import dao.jobaddServletDAO;

public class deletenewstest {

	@Test
	public void test() {
		deletenewsDAO dao=new deletenewsDAO();
		boolean status= dao.IsPresent("niharika");
		
		assertEquals(false, status);
		//fail("Not yet implemented");
	}

}
