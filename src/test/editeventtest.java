package test;

import static org.junit.Assert.*;

import org.junit.Test;

import dao.deletenewsDAO;
import dao.editeventDAO;

public class editeventtest {

	@Test
	public void test() {
		editeventDAO dao=new editeventDAO();
		boolean status= dao.IsPresent("niharika");
		
		assertEquals(false, status);
		//fail("Not yet implemented");
	}

}
