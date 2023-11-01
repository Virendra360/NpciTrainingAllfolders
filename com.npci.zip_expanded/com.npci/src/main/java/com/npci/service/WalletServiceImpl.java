package com.npci.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.npci.beans.Account;
import com.npci.beans.Wallet;
import com.npci.dao.AccountDao;
import com.npci.dao.WalletDao;

import cpm.npci.ExceptionsStore.LowBalanceException;

@Service("walletService")
public class WalletServiceImpl implements WalletService{

	@Autowired
	private WalletDao walletDao;
//	@Autowired
//	private AccountDao accountDao;

	@Modifying
	@Transactional
	@Override
	public void addFund(int wallet_id,int fund) throws LowBalanceException {
		Wallet wallet=walletDao.getByWalletId(wallet_id);
		Account account=wallet.getAccount();
		if(account.getBalance()>=fund)
		{
			double totalFundInWallet=fund+wallet.getAmount();
			System.out.println(totalFundInWallet);
			
			double totalAmmountInAccount=account.getBalance()-fund;
			System.out.println(totalAmmountInAccount);
			wallet.setAmount(totalFundInWallet);
			account.setBalance(totalAmmountInAccount);
			System.out.println(account.getBalance());
			System.out.println(wallet.getAmount());
		}
		else
		{
			throw new LowBalanceException("Account don't have sufficient balance");
		}
		
	}
    
	// show balance
	@Override
	public double showBalance(int wallet_id) {
		
		Wallet wallet=walletDao.getByWalletId(wallet_id);
		return wallet.getAmount();
	}

	@Modifying
	@Transactional
	@Override
	public void transferFund(int fund, int wallet_id_issuere, int wallet_id_receiever) throws LowBalanceException {
		Wallet issuer_wallet=walletDao.getByWalletId(wallet_id_issuere);
		Wallet receiever_wallet=walletDao.getByWalletId(wallet_id_receiever);

		if(issuer_wallet.getAmount()>=fund)
		{
			double issuer_amount=issuer_wallet.getAmount()-fund;
			double receiver_amount=receiever_wallet.getAmount()+fund;
			issuer_wallet.setAmount(issuer_amount);
			receiever_wallet.setAmount(receiver_amount);
		}
		else
		{
			throw new LowBalanceException("Wallet don't have sufficient balance");
		}

	}
	
	
	
}
