package com.npci.service;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.npci.beans.Contact;
import com.npci.beans.Profile;

import cpm.npci.ExceptionsStore.ProfileNotFoundException;

@SpringBootTest
class ProfileServiceImplTest {
  // autowired the ProfileServiceImpl
	@Autowired
	private ProfileService profileService;
	
	//  register profile
	@Test
	void createProfileTest()
	{
		try {// valid profile format
			  Profile registerPf1=profileService.createProfile("Ashish", "ashish123@gmail.com", "Ashish@12",
					LocalDate.parse("1995-09-17"), 9882345673L);
			  System.out.println("_______________________");
			  System.out.println(registerPf1);
			  System.out.println("_______________________");
			  
			  // invalid profile format
			  Profile registerPf2=profileService.createProfile("Ashish", "ashish123@gmail.com", "Ashish@12",
						LocalDate.parse("2015-09-17"), 9882345673L);
			  System.out.println("_______________________");
			  System.out.println(registerPf2);
			  System.out.println("_______________________");
			  
		}catch(IllegalArgumentException e) {
			 System.out.println("_______________________");
			  System.out.println(e);
			  System.out.println("_______________________");
		}
	  
	  
	}
	
	// to verify fetching based on profile id
	@Test
	void showProfileTest() {
		try {
			Optional<Profile>  pf= profileService.showProfile(2);
			System.out.println("_______________________");
			 System.out.println(pf);
			 System.out.println("_______________________");
			 
			 Optional<Profile>  pf2= profileService.showProfile(25);
			 System.out.println("_______________________");
			 System.out.println(pf2);
			 System.out.println("_______________________");
			 
		}catch(ProfileNotFoundException e) {
			System.out.println("_______________________");
			  System.out.println(e);
			  System.out.println("_______________________");
		}  
	}
	
	// to fetch all profiles
	@Test
	void showProfilesTest()
	{
		List<Profile> profiles=profileService.showProfiles();
		System.out.println("_______________________");
		System.out.println(profiles);
		System.out.println("_______________________");
	}
	
	// profile delete test
	@Test
	void deleteProfile()
	{
		System.out.println("______________________");
		System.out.println("Before delete");
		System.out.println(profileService.showProfiles());
		System.out.println("_______________________");
		
		profileService.deleteProfile(5);
		
		System.out.println("______________________");
		System.out.println("After delete");
		System.out.println(profileService.showProfiles());
		System.out.println("_______________________");
	}
	
	// fetching  all contacts related particular profile
		@Test
		void showContactsTest()
		{
			List<Contact> contacts=profileService.showContacts(1);
			System.out.println("______________________");
			System.out.println(contacts);
			System.out.println("_______________________");
		}
	
	// contact add test
	@Test
	void addContactTest()
	{
		System.out.println("______________________");
		System.out.println("Before adding contact");
		System.out.println(profileService.showContacts(2));
		System.out.println("_______________________");
		
		profileService.addContact(2,1053);
		profileService.addContact(2,1058);
		
		System.out.println("______________________");
		System.out.println("After adding contact");
		System.out.println(profileService.showContacts(2));
		System.out.println("_______________________");
	}
	
	// deleting contact based on profile id of  user and wallet id of his contact
	@Test
	void  deleteContactTest()
	{
		System.out.println("______________________");
		System.out.println("Before deleting contact");
		System.out.println(profileService.showContacts(2));
		System.out.println("_______________________");
		
		profileService.deleteContact(2, 1053);
		
		System.out.println("______________________");
		System.out.println("After deleting contact");
		System.out.println(profileService.showContacts(2));
		System.out.println("_______________________");
	}
}
