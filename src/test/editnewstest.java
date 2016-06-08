package test;

import static org.junit.Assert.*;

import org.junit.Test;

import dao.editeventDAO;
import dao.editnewsDAO;

public class editnewstest {

	@Test
	public void test() {
		editnewsDAO dao=new editnewsDAO();
		boolean status= dao.IsPresent("niharika");
		
		assertEquals(false, status);
		//fail("Not yet implemented");
	}

}
