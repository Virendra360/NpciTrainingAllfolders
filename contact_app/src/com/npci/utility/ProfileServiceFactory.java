package com.npci.utility;

import com.npci.ProfileService;
import com.npci.ProfileServiceSetImpl;

public class ProfileServiceFactory {

	public ProfileService getInstance()
	{
		// implementing factory design pattern for making loosely coupled architecture
		ProfileService operations=new ProfileServiceSetImpl();
		return operations;
	}
	
}
