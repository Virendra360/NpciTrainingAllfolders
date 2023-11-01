package com.npci.service;

import com.npci.User;
import com.npci.exception.UserNotFoundException;

// service layer class
public class UserService implements UserOperations {
	
 private static User[] users=new User[5]; // [null null null null null]
 // we need a counter track the index  of array to know many objects are stored
 private static int index=0;
 //store method
 @Override
public int store(User user)
 {
	 // return 1 if stored
	 if(index>=5)
	 {
		 return -1;
	 }
	 
	 users[index++]=user;
	 return 1;
	 
 }
 // find all method
 @Override
public User[] findAll()
 {
	 
	 
	 User[] usersToReturn=new User[index] ;
	 int i=0;  // to know index of returning array
	 
	 for(User u: users)
	 {
		 if(u!=null)
		 {
			usersToReturn[i++] =u;
		 } 
	 }
	 
	 return usersToReturn;
 }
 // create method which find user by name and return the user
 // accept 3 service in switch in main
 
 @Override
public User find (String name) throws UserNotFoundException
 {
	 User[] us=findAll();
	 
	 for(User u: us)
	 {
		 if(u.getName().equals(name))
		 {
			 return u;
		 }
	 }
	 // throw exception or return null
	throw new UserNotFoundException("Sorry !!"+ name +" no user found");
 }
 
}
