package com.npci.beans;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Contact {
    
	// contact  id will be primary key
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="contact_id")
	private int contact_id;
	
	
	@Column(name="profile_id_ref")
	private int profile_id_ref;
	
	@Column(name="wallet_id_ref")
	private int  wallet_id_ref;

	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Contact(int contact_id, int profile_id_ref, int wallet_id_ref) {
		super();
		this.contact_id = contact_id;
		this.profile_id_ref = profile_id_ref;
		this.wallet_id_ref = wallet_id_ref;
	}

	@Override
	public String toString() {
		return "Contact [contact_id=" + contact_id + ", profile_id_ref=" + profile_id_ref + ", wallet_id_ref="
				+ wallet_id_ref + "]";
	}

	public int getContact_id() {
		return contact_id;
	}

	public void setContact_id(int contact_id) {
		this.contact_id = contact_id;
	}

	public int getProfile_id_ref() {
		return profile_id_ref;
	}

	public void setProfile_id_ref(int profile_id_ref) {
		this.profile_id_ref = profile_id_ref;
	}

	public int getWallet_id_ref() {
		return wallet_id_ref;
	}

	public void setWallet_id_ref(int wallet_id_ref) {
		this.wallet_id_ref = wallet_id_ref;
	}

	
	
}
