package com.npci.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.npci.beans.Account;

public interface AccountDao extends JpaRepository<Account, Long> {
	 // auto implements CRUD methods
	

}
