package com.npci.testing;

import java.time.LocalDate;


import org.junit.jupiter.api.Test;

import com.npci.Profile;
import com.npci.ProfileService;
import com.npci.utility.ProfileServiceFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class ProfileServiceTestCases {
	// using factory design pattern object
	ProfileService service= new ProfileServiceFactory().getInstance();
	int status1=service.save(new Profile(200,"Bruce","hshdgdh@546",LocalDate.parse("2000-06-03"),725727882L));
	
	
	@Test
	public void saveTest()
	{   
		
		int expected=1;
		assertEquals(expected,status1);
		
	}
	
	@Test
	public void deleteTest()
	{
		
		int status=service.delete(200);
		int expected=1;
		assertEquals(expected,status);
	}
	
	@Test
	public void loginTest()
	{
//		Profile newPf=new Profile(67,"Harsha","Sept@12345",LocalDate.parse("2000-06-03"),1234567899);
//		 int status=service.save(newPf);
//		 assertTrue(status);
	}
	
}
