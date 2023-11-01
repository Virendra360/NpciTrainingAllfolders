package com.npci;

import java.time.LocalDate;
import java.util.Scanner;

import com.npci.colllectionException.ProfileCreationException;
import com.npci.utility.ProfileServiceFactory;

//to use regex import
//import java.util.regex.*;

public class MainService {

	public static void main(String[] args) {

		int operation;
		// creating a service to use save and delete operations
		ProfileService service=new ProfileServiceFactory().getInstance();

		do {
			Scanner sc=new Scanner(System.in);
			//taking input from user to select operation
			System.out.println("Select- 1:Login 2.Save  3.Delete 4.Logout");
			operation=sc.nextInt();
			// use switch to provide different operations

			switch(operation)
			{
			
			case 1:// Login operation
				System.out.println("Eneter your profile id..!!");
				int id=sc.nextInt();
				System.out.println("Eneter your profile password..!!");
				String pswd=sc.next();
				service.loginToProfile(id,pswd);
				
		        break;
				
			case 2:// save operation
				
				System.out.println("Enter profile id");
				int tempPfId=sc.nextInt();
				System.out.println("Enter  your name");
				String tempPfName=sc.next();
				System.out.println("Set profile password ");
				String tempPfPassword=sc.next();
			
				System.out.println("Enter your DoB in the format: YYYY-MM-DD");
				LocalDate tempPfDob=LocalDate.parse(sc.next());
				System.out.println("Enter your phone number");
				long tempPfPhone=sc.nextLong();
				Profile newPf=new Profile(tempPfId,tempPfName,tempPfPassword,tempPfDob,tempPfPhone);
				
				try {
					ProfileValidation validate=new ProfileValidation(tempPfId,tempPfName,tempPfPassword,tempPfDob,tempPfPhone);
					
					 int status=service.save(newPf);
					 
					 if(status==1)
			            {
			            	System.out.println("Profile created Successfully..!!");
			            	System.out.println("Now ready to Login in your profile..!!");
			            }	
			            else
			            {
			            	throw new ProfileCreationException("Id already exist. Pls provide different id..");
//			            	System.out.println("Id already exist. Pls provide different id..");
			            }
			            	
				
				}
				catch(IllegalArgumentException e) {
					  System.out.println("Invlid format :"+ e);
				}
				catch(ProfileCreationException e)
				{
					 System.out.println("Error :"+ e);
				}
				finally {
					service.displayAll();
				}
				
				break;
			
			
			case 3:// delete operation
				System.out.println("Enter profile id to delete profile");
				int idTodelete=sc.nextInt();
                int deleteStatus=service.delete(idTodelete);
                if(deleteStatus==1)
                	System.out.println("Profile deleted Successfully..!!");
                else
                	System.out.println("Such profile id does not exist..!!");
				service.displayAll();
				break;
				
			case 4:
				// to exit
				System.out.println("Logout successfull");
				break;
				
			 default :
				System.out.println("Wrong Input");
			}
		}while(operation!=4);
	}

}
