package com.npci;

import java.time.LocalDate;

public class User {
	private String name;
	private long phone;
	private LocalDate dob;
	
	
	
	@Override
	public String toString() {
		if(dob==null)
			return "name=" + name + ", phone=" + phone +", dob= NA";
		return "User [name=" + name + ", phone=" + phone + ", dob=" + dob + "]";
	}

	public User(String name, long phone) {
		super();
		this.name = name;
		this.phone = phone;
	}
	
	public User(String name, long phone, LocalDate dob) {
		super();
		this.name = name;
		this.phone = phone;
		this.dob=dob;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	

}
