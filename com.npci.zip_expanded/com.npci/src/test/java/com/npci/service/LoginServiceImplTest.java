package com.npci.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.npci.beans.Profile;

import cpm.npci.ExceptionsStore.ProfileNotFoundException;

@SpringBootTest
class LoginServiceImplTest {
    @Autowired
	private LoginService loginService;
	
    // profile login test
	@Test
	void loginToProfileTest() {
		  
		System.out.println("_____________");
		
		try {
			Profile pf= loginService.loginToProfile("viru@gmail.com","Nandan12@");
			System.out.println("Login Successful..");
			System.out.println(pf);
			System.out.println("_____________");
			 
		}catch(ProfileNotFoundException e){
			System.out.println("_____________");
			System.out.println(e);
			System.out.println("_____________");
		}
	}

}
