package com.npci;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.*;

public class ProfileValidation {
	
	   private int profileid;
	    private String name;
	    private String password;
	    private LocalDate dob;
	    private long phone;

    public ProfileValidation(int profileid, String name, String password, LocalDate dob, long phone) {
      
    	validateProfileId(profileid);
       
        validateName(name);
        boolean pswdverresult= validatePassword(password);
        if(!pswdverresult)
        {
        	throw new IllegalArgumentException("Password must contain 6 charecters with atleast one uppercase, one "
        			+ "lowercase, one digit, one speacial char");
        }
        
       boolean dateverresult= isDateValid(dob);
       if(!dateverresult)
       {
       	throw new IllegalArgumentException("Below 18 :Age restriction.. ");
       }
       
        validatePhone(phone);
        
        this.profileid = profileid;
        this.name = name;
        this.password = password;
        this.dob = dob;
        this.phone = phone;
       
    }

    private void validateProfileId(int profileId) {
        if (profileId <= 0) {
            throw new IllegalArgumentException("Profile ID must be a positive integer.");
        }
    }

    private void validateName(String name) {
        if (name == null || name.length() < 5 || name.length() > 60) {
            throw new IllegalArgumentException("Name must be between 5 and 60 characters.");
        }
    }

    public boolean validatePassword(String password) {
        if (password.length() < 6) {
            return false;
        }

        // Use regular expressions to check for uppercase, lowercase, digit, and special symbol
        String regex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%^&+=]).*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);

         return matcher.matches();
      
    }
    
    public boolean isDateValid(LocalDate date) {
        try {
//            // Parse the input date
//            LocalDate date = LocalDate.parse(inputDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

            // Calculate the current date
            LocalDate currentDate = LocalDate.now();

            // Calculate the date 18 years ago
            LocalDate eighteenYearsAgo = currentDate.minus(Period.ofYears(18));

            // Check if the input date is at least 18 years in the past
            return date.isBefore(eighteenYearsAgo);
        } catch (DateTimeParseException e) {
            // Invalid date format
            return false;
        }
    }



    private void validatePhone(long phone) {
    	String myString = Long.toString(phone);
    	Pattern pattern = Pattern.compile("\\d{10}");
        Matcher matcher = pattern.matcher(myString);
    	
        if (!matcher.matches()) {
            throw new IllegalArgumentException("Phone must be a 10-digit number.");
        }
    }
    
    // Getter methods
    public int getProfileid() {
		return profileid;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public LocalDate getDob() {
		return dob;
	}

	public long getPhone() {
		return phone;
	}
    
}
