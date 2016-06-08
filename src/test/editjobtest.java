package test;

import static org.junit.Assert.*;

import org.junit.Test;

import dao.editjobDAO;
import dao.editnewsDAO;

public class editjobtest {

	@Test
	public void test() {
		editjobDAO dao=new editjobDAO();
		boolean status= dao.IsPresent("hh");
		
		assertEquals(true, status);
		//fail("Not yet implemented");
	}

}
