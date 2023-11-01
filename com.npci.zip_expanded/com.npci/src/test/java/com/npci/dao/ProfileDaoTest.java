package com.npci.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.npci.beans.Profile;

@SpringBootTest
class ProfileDaoTest {

	// we required  autowired of ProfileDao to use methods
	@Autowired
	private ProfileDao profileDao;
	
	@Test
	void getAllProfileTest() {
		   List<Profile> profiles=profileDao.findAll();
		   System.out.println(profiles);
	}
	
	@Test 
	void getprofileByEmailIdTest()
	{
		Profile pf=profileDao.findByEmailId("viru@gmail.com");
		System.out.println(pf);
		assertTrue(pf!=null);
	}

}
