package com.npci;

public interface ProfileService {
	
	int save(Profile pf);  // return type int for status
	// taking profile id as parameter to delete 
	int delete(int pfid) ;  // return type int to know status
    void displayAll();
    void loginToProfile(int profileid,String password);
}
