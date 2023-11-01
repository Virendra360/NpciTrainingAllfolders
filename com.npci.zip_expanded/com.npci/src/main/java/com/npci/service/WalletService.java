package com.npci.service;

import com.npci.beans.Wallet;

import cpm.npci.ExceptionsStore.LowBalanceException;

public interface WalletService  {
    // add funds
	  public void addFund(int profile_id,int fund) throws LowBalanceException;
	
	// show balance
	  public double showBalance(int wallet_id);
	
	// fund transfer
	  public void transferFund(int fund,int wallet_id_issuere, int wallet_id_receiever) throws LowBalanceException;
}
