package com.npci.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import cpm.npci.ExceptionsStore.LowBalanceException;

@SpringBootTest
class WalletServiceImplTest {
    @Autowired
	private WalletService walletService;
	
	@Test
	void showBalanceTest() {
		 double amount=walletService.showBalance(1055);
		 System.out.println("_____________");
		 System.out.println("Amount : " +amount);
		 System.out.println("_____________");
	}

	@Test
	void addFundTest()
	{
		try {
			walletService.addFund(1055,1000);
			double amount=walletService.showBalance(1055);
			System.out.println("________________");
			System.out.println("wallet amount :"+amount);
			System.out.println("________________");
			
		}catch(LowBalanceException e){
			System.out.println(e);
		}
		
	}
	
	@Test
	void transferFundTest()
	{
		try {
			double before_transfer_issuer_amount=walletService.showBalance(1056);
			double before_transfer_receiver_amount=walletService.showBalance(1058);
			System.out.println("________________");
			System.out.println("Befofe transfer");
			System.out.println(before_transfer_issuer_amount);
			System.out.println(before_transfer_receiver_amount);
			System.out.println("________________");
			
			walletService.transferFund(1500, 1056, 1058);
			double issuer_amount=walletService.showBalance(1056);
			double receiver_amount=walletService.showBalance(1058);
			System.out.println("________________");
			System.out.println("After transfer");
			System.out.println(issuer_amount);
			System.out.println(receiver_amount);
			System.out.println("________________");
			
		}catch(LowBalanceException e){
			System.out.println(e);
		}
	}
	
}
