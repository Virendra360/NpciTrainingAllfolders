package com.npci.service;

import com.npci.beans.Profile;

import cpm.npci.ExceptionsStore.ProfileNotFoundException;

public interface LoginService {
       
	// login to profile method
	public Profile loginToProfile(String email_id,String password) throws ProfileNotFoundException;
   
}
