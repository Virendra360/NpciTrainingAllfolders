package com.npci.beans;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="account")
public class Account {
    
	// we will have account no as primary key
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="account_number")
	private long account_number;
	
	@Column(name="balance")
	private double balance;

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Account(long account_number, double balance) {
		super();
		this.account_number = account_number;
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account [account_number=" + account_number + ", balance=" + balance + "]";
	}

	public long getAccount_number() {
		return account_number;
	}

	public void setAccount_number(long account_number) {
		this.account_number = account_number;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	
}
