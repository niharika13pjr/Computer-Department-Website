package test;

import static org.junit.Assert.*;

import org.junit.Test;

import dao.editprofileDAO;
import dao.jobaddServletDAO;

public class editprofile {

	@Test
	public void test() {
		editprofileDAO dao=new editprofileDAO();
		boolean status= dao.IsPresent("NP11111");
		
		assertEquals(true, status);
		//fail("Not yet implemented");
	}

}
