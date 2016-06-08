package test;

import static org.junit.Assert.*;

import org.junit.Test;

import dao.alumniDAO;
import dao.courseDAO;
import model.alumni;
import model.course;

public class alumnitest {

	@Test
	public void test() {
		alumniDAO dao=new alumniDAO();
		alumni a=dao.GetUserInfo("1");
		String id=a.getAlumniID();
		assertEquals(id,"1");
		//fail("Not yet implemented");
	}

}
