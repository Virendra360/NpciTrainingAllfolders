package com.npci.service;

import com.npci.User;
import com.npci.exception.UserNotFoundException;

public interface UserOperations {

	//store method
	int store(User user);

	// find all method
	User[] findAll();
	// create method which find user by name and return the user
	// accept 3 service in switch in main

	User find(String name) throws UserNotFoundException;

}