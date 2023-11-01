package com.npci.validation;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

public class ProfileValidation {
     
     private String name;
     private String email_id;
     private String password;
     private LocalDate dob;
     private long phone;
	
     // generate constructor
     public ProfileValidation(String name, String email_id, String password, LocalDate dob, long phone) {
	
		this.name = name;
		this.email_id = email_id;
		this.password = password;
		this.dob = dob;
		this.phone = phone;
	}
     
     public ProfileValidation() {
		super();
		// TODO Auto-generated constructor stub
	}


	// validate name : Must be between 5 to 60 characters
     public boolean validateName(String name)
     {
    	  if (name == null || name.length() < 5 || name.length() > 60) {
              return false;
          }
    	  return true;
     }
     
     // validate email_id : Valid email-id must have @, .(dot) mandatorily
     public boolean validateEmail(String email_id)
     {
    	// Regular expression for a valid email address
         String regex = "^[A-Za-z0-9+_.-]+@(.+)$";

         Pattern pattern = Pattern.compile(regex);
         Matcher matcher = pattern.matcher(email_id);
         return matcher.matches();
     }
     
     //Must be strong password that includes atleast 6 chars with special characters, numbers, upper case & lower case letters
     public boolean validatePassword(String password)
     {
    	 if (password.length() < 6) {
             return false;
         }

         // Use regular expressions to check for uppercase, lowercase, digit, and special symbol
         String regex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%^&+=]).*$";
         Pattern pattern = Pattern.compile(regex);
         Matcher matcher = pattern.matcher(password);

          return matcher.matches();
    	 
     }
     
     // Valid date in past 18 years
     public boolean validateDob(LocalDate dob)
     {
    	 try {
           // Calculate the current date
           LocalDate currentDate = LocalDate.now();

           // Calculate the date 18 years ago
           LocalDate eighteenYearsAgo = currentDate.minus(Period.ofYears(18));

           // Check if the input date is at least 18 years in the past
           return dob.isBefore(eighteenYearsAgo);
           
       } catch (DateTimeParseException e) {
           // Invalid date format
           return false;
       }
     }
     
     //  10 digits
     public boolean validatePhone(Long phone)
     {
    	 String myString = Long.toString(phone);
     	Pattern pattern = Pattern.compile("\\d{10}");
         Matcher matcher = pattern.matcher(myString);
     	
         return matcher.matches();
     }
}
