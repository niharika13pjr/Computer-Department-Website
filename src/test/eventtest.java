package test;

import static org.junit.Assert.*;

import org.junit.Test;

import dao.eventDAO;
import dao.newsDAO;

public class eventtest {

	@Test
	public void test() {
		eventDAO dao=new eventDAO();
		boolean status= dao.IsPresent("niharika");
		
		assertEquals(true, status);
		//fail("Not yet implemented");
	}

}
