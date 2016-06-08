package test;

import static org.junit.Assert.*;

import org.junit.Test;

import dao.courseDAO;
import dao.examDAO;
import model.course;
import model.exam;

public class examtest {

	@Test
	public void test() {
		examDAO dao=new examDAO();
		exam c=dao.GetUserInfo("se");
		String id=c.getExamname();
		assertEquals(id,"se");
		//fail("Not yet implemented");
	}

}
