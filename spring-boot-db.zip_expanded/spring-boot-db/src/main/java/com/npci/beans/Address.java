package com.npci.beans;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Address {
	@Id
    @Column(name="address_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int addressId;
	
	private String location;
	
	
	// generate 2 constructors , setters and getters

	public Address() {
		super();
	}
	
	public Address(int addressId, String location) {
		super();
		this.addressId = addressId;
		this.location = location;
		
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
}
