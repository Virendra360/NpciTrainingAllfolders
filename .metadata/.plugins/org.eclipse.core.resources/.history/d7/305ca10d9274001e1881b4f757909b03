package com.npci.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.npci.beans.Account;
import com.npci.beans.Contact;
import com.npci.beans.Profile;
import com.npci.beans.Wallet;
import com.npci.dao.AccountDao;
import com.npci.dao.ContactDao;
import com.npci.dao.ProfileDao;
import com.npci.dao.WalletDao;
import com.npci.validation.ProfileValidation;

import cpm.npci.ExceptionsStore.ProfileNotFoundException;

@Service("registrationService") // id="registrationService"
public class ProfileServiceImpl implements ProfileService{
     @Autowired
	 private ProfileDao profileDao;
     
     //  also we are going initialize account and wallet  at time of profile creation
     @Autowired
	 private AccountDao accountDao;
     @Autowired
	 private WalletDao walletDao;
     @Autowired
	 private ContactDao contactDao;
	 
     // implementing method for profile registration in database
	@Override
	@Transactional
	public Profile createProfile(String name, String email_id, String password, LocalDate dob, long phone) {
		   
		 ProfileValidation validate=new ProfileValidation();
		 
		 if(validate.validateName(name))
		 {
			 if( validate.validateEmail(email_id))
			 {
				 if(validate.validatePassword(password)) {
					  if( validate.validateDob(dob)) {
						   if( validate.validatePhone(phone)) {
							  
//           all details are in correct format so we can create profile
//	         also we are going initialize account and wallet  at time of profile creation
							  
						   Account accnt=new Account();
						   accnt.setBalance(50000);
						   Account registerAccnt=accountDao.save(accnt);
						   Wallet wallet=new Wallet();
						   wallet.setAmount(2000);
						   Wallet registerWallet=walletDao.save(wallet);
						   registerWallet.setAccount(registerAccnt);
						   Profile pf=new Profile(0,name,email_id,password,dob,phone,registerWallet);

//						   pf.setWallet(registerWallet);
							   
							   Profile newPf=profileDao.save(pf);
							   return newPf;
							   
						   }
						   else {
							   throw new IllegalArgumentException("Phone number must have 10 digits..");
						   }
					  }
					  else {
						  throw new IllegalArgumentException("Age must  above 18..");
					  }
				 }
				 else {
					 throw new IllegalArgumentException("Password must have mention format..");
				 }
			 }
			 else {
				 throw new IllegalArgumentException("Provide email id with corect format..");
			 }
		 }
		 else {
			 throw new IllegalArgumentException("Name must be between 5 and 60 characters.");
		 }
	}

	@Override
	public void editProfile(Profile pf) {
		// TODO Auto-generated method stub
		
		
	}

	// fetching profile based on profile id
	@Override
	public Optional<Profile> showProfile(int profile_id) throws  ProfileNotFoundException {
		
		Optional<Profile> op=profileDao.findById(profile_id);
	     if(op.isEmpty()) 
	    	 throw new  ProfileNotFoundException("No Profile with given profile id..");
		return op;
	}
	
	// fetching all profiles
	@Override
	public List<Profile> showProfiles() {
		return profileDao.findAll();
	}

	// deleting profile  
	@Override
	public void deleteProfile(int profile_id) {	
		profileDao.deleteById(profile_id);
	}

	// adding contact
	@Override
	public void addContact(int profile_id_ref, int wallet_id_ref) {
		Contact contact=new Contact(0,profile_id_ref,wallet_id_ref);
		contactDao.save(contact);
	}
	
	// to fetch all contacts
	

	// to fetch all contacts for particular profile
	@Override
	public List<Contact> showContacts(int profiile_id) {
		
		return contactDao.findContactsByProfileId(profiile_id);
	}

	// delete contact based on wallet id and current user profile id
	@Override
	public void deleteContact(int profile_id_ref,int wallet_id_ref) {
		
		contactDao.deleteContactByProfileIdAndWalletId(profile_id_ref, wallet_id_ref);	
	}

	

}
