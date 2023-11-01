package com.npci.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.npci.beans.Profile;

public interface ProfileDao extends JpaRepository<Profile, Integer> {
    
	// auto implements some methods based on Integer pk
	
	// we can create our own query 
	// to fetch data using email_id
	@Query("select p from Profile p where p.email_id=?1")
	public Profile findByEmailId(String email_id);
	
	
}
