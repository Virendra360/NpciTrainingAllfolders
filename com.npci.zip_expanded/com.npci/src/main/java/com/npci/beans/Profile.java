package com.npci.beans;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="profile")
public class Profile {
	// profile_id will be Primary key
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="profile_id")
     private int  profile_id;
	
	@Column(name="name")
     private String name;
	
	@Column(name="email_id")
     private String email_id;
	@Column(name="password")
     private String password;
	@Column(name="dob")
     private LocalDate dob;
	@Column(name="phone")
     private long phone;
	
	 @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	 @JoinColumn(name="wallet_id_ref") // name of realtion col in Profile table
     private Wallet wallet;

//	  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	  @JoinColumn(name = "profile_id_ref",
//	              referencedColumnName ="profile_id")
//	  private List<Contact> contacts;
	  
    
//	 public List<Contact> getContacts() {
//		return contacts;
//	}
//
//	public void setContacts(List<Contact> contacts) {
//		this.contacts = contacts;
//	}
	 
	 
	public Profile() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Profile(int profile_id, String name, String email_id, String password, LocalDate dob, long phone,
			Wallet wallet) {
		super();
		this.profile_id = profile_id;
		this.name = name;
		this.email_id = email_id;
		this.password = password;
		this.dob = dob;
		this.phone = phone;
		this.wallet = wallet;
	}

	public int getProfile_id() {
		return profile_id;
	}

	public void setProfile_id(int profile_id) {
		this.profile_id = profile_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public Wallet getWallet() {
		return wallet;
	}

	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}

	@Override
	public String toString() {
		return "Profile [profile_id=" + profile_id + ", name=" + name + ", email_id=" + email_id + ", password="
				+ password + ", dob=" + dob + ", phone=" + phone + ", wallet=" + wallet + "]";
	}
	 
	
}
