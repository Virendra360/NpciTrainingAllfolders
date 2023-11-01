package com.npci.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.npci.beans.Wallet;

@SpringBootTest
class WalletDaoTest {
     @Autowired
	private WalletDao walletDao;
	
	@Test
	void getByWalletIdTest() {
		  Wallet wallet= walletDao.getByWalletId(1055);
		   System.out.println("______________");
		   System.out.println("Wallet Details :"+wallet);
		   System.out.println("______________");
	}

}
