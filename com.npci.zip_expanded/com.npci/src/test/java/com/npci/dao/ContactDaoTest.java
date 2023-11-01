package com.npci.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.npci.beans.Contact;

@SpringBootTest
class ContactDaoTest {
   // autowired  the ContactDao we need methods of it
	@Autowired
	private ContactDao contactDao;
	
	@Test
	void addContactTest() {
		 // adding contact manually 
		 Contact contact1=new Contact(0,1,1055);
		 contactDao.save(contact1);
	}
	
	@Test
	void showAllContactsByProfileIdTest()
	{
		List<Contact> contacts=contactDao.findContactsByProfileId(1);
		System.out.println(contacts);
	}

	@Test
	void deleteContactByProfileIdAndWalletId()
	{
		System.out.println("______________________");
		System.out.println("Before deleting contact");
		System.out.println(contactDao.findContactsByProfileId(1));
		System.out.println("_______________________");
		
		contactDao.deleteContactByProfileIdAndWalletId(1, 1054);
		
		System.out.println("______________________");
		System.out.println("After deleting contact");
		System.out.println(contactDao.findContactsByProfileId(1));
		System.out.println("_______________________");
	}
}
