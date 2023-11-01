package com.npci.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.npci.beans.Contact;

public interface ContactDao extends JpaRepository<Contact, Integer>{
	
	// auto implement CRUD methods
    @Query("select c from Contact c where c.profile_id_ref=?1")
    List<Contact> findContactsByProfileId(int profile_id_ref);
    
//    @Query("delete from Contact c where c.profile_id_ref=?1 and c.wallet_id_ref=?2")
//    void deleteContactByProfileIdAndWalletId(int profile_id_ref,int wallet_id_ref);
    
    @Modifying
    @Transactional
    @Query("DELETE FROM Contact c WHERE c.profile_id_ref = :value1 AND c.wallet_id_ref = :value2")
    void deleteContactByProfileIdAndWalletId(@Param("value1") int profile_id_ref, @Param("value2") int wallet_id_ref);
}
