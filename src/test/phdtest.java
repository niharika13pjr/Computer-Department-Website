package test;

import static org.junit.Assert.*;

import org.junit.Test;

import dao.updatephdDAO;
import model.Register;

public class phdtest {

	@Test
	public void test() {
		updatephdDAO dao=new updatephdDAO();
		Register c=dao.GetUserInfo("Pujji");
		
		int status=c.getUserID();
		assertEquals(status,0);
		//fail("Not yet implemented");
	}

}
