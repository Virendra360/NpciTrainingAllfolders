package com.npci.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.npci.beans.Contact;
import com.npci.beans.Profile;

import cpm.npci.ExceptionsStore.ProfileNotFoundException;

public interface ProfileService {
    // creating new profile
  public Profile createProfile(String name, String email_id, String password, LocalDate dob, long phone);

  //edit profile
  public void editProfile(Profile pf);
  
  // view profile details
  public Optional<Profile>  showProfile(int profile_id) throws ProfileNotFoundException;
  
  // show all profiles
  public List<Profile> showProfiles();
  
  //delete profile
  public void  deleteProfile(int profile_id);
  
  // add contact 
  public void addContact(int profile_id_ref,int wallet_id_ref);
  
  // view all contacts for particular profile
  public List<Contact> showContacts(int profiile_id);
  
  // delete contact for that we will pass profile id for which contact based on wallet id to delete
  public void deleteContact(int profile_id_ref,int wallet_id_ref);
  
}
