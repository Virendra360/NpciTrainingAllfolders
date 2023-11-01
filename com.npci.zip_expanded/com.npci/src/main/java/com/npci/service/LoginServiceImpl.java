package com.npci.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.npci.beans.Profile;

import com.npci.dao.ProfileDao;

import cpm.npci.ExceptionsStore.ProfileNotFoundException;

@Service("loginService")  // id ="loginService"
public class LoginServiceImpl implements LoginService {
  @Autowired
	private ProfileDao profileDao;

	@Override
	public Profile loginToProfile(String email_id, String password) throws ProfileNotFoundException  {
		 Profile op= profileDao.findByEmailId(email_id);
		if(op==null )
		{
			throw new ProfileNotFoundException("Incorrect email id..");
		}

		if(!password.equals(op.getPassword()))
		{
			throw new ProfileNotFoundException("Incorrect password..");
		}
		// if we reach until this it means Login Successful
//	     System.out.println("Login successful....");
		 return op;
	}
 
}
