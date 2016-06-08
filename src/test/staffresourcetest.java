package test;

import static org.junit.Assert.*;

import org.junit.Test;

import dao.staffresourceDAO;

public class staffresourcetest {

	@Test
	public void test() {
		staffresourceDAO dao=new staffresourceDAO();
		boolean status=dao.IsPresent("movie room");
		
		assertEquals(true, status);
		//fail("Not yet implemented");
	}

}
