package test;

import static org.junit.Assert.*;

import org.junit.Test;

import dao.registrationDAO;

public class registerationtest {

	@Test
	public void test1() {
		registrationDAO registerDAO= new registrationDAO();
		
		boolean status= registerDAO.IsPresent("NP11111");
		assertEquals(true, status);
		//fail("Not yet implemented");
	}
	
	
	public static void main(String args[])
	{
		System.out.println("Hello");
	}

}
