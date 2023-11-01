package com.npci;

import java.time.LocalDate;
import java.util.Scanner;

import com.npci.exception.UserNotFoundException;
import com.npci.service.UserOperations;
import com.npci.service.UserService;
import com.npci.utility.UserOperatiosFactory;

public class TestUser {
    public static void main(String[] args) {
		
    	Scanner sc=new Scanner(System.in);
    	UserOperations service= UserOperatiosFactory.getInstance(); // to call store() and findAll() 
    	int option =0; // user option to store or findAll or exit
    	do {
    		System.out.println("1:Store , 2:Find All , 3:Find user, 4: Exit");
    		option = sc.nextInt();
    		
    		switch(option)
    		{
    		case 1:
    			// ask details and initialize the user and pass to UserServoce.store()
    			System.out.println("Entere name");
    			String name= sc.next();
    			System.out.println("Entere phone no");
    			Long phone= sc.nextLong();
    			System.out.println("Entere Date of Birth in format yyyy-mm-dd only");
    			LocalDate dob=LocalDate.parse(sc.next());
    			User user=new User(name,phone,dob);
    			int status = service.store(user);
    			if(status==1)
    				System.out.println("User stored..");
    			else
    				System.out.println("Failed to store..");
    			
    			break;
    		case 2:
    			// call the findAll and iterate the print user
    			User[] users= service.findAll();
    			for(User u: users)
    			{
    				System.out.println(u);
    				System.out.println("_____________");
    			}
    			
    			break;
    		case 3:
    			System.out.println("Enter name of user to find");
    			String username=sc.next();
    			
    			try
    			{
    				User userRetrieve=service.find(username);
        			System.out.println(userRetrieve);
    			}
    			catch(UserNotFoundException e)
    			{
    				System.err.println(e.getMessage());
    			}
    			
    			break;
    		}
    		
    	}while(option!=4);
    	
    	
    }
}
