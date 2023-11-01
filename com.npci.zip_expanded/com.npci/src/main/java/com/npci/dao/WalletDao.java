package com.npci.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.npci.beans.Wallet;

public interface WalletDao extends JpaRepository<Wallet, Integer> {
	
	// spring boot auto implements CRUD methods

	// custom queries
	@Query("select w from Wallet w where w.wallet_id=?1")
	public Wallet getByWalletId(int wallet_id_ref);
}
