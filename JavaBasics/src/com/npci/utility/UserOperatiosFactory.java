package com.npci.utility;

import com.npci.service.UserOperations;
import com.npci.service.UserService;

/*
 * A class which can create object of UserService
 *  */

public class UserOperatiosFactory {
	
	public static UserOperations getInstance() {
	UserOperations operation=new UserService();
	return operation;
	}
}
