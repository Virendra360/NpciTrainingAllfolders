package com.npci;

import java.time.LocalDate;
import java.util.Objects;

public class Profile   {
    private int profileid;
    private String name;
    private String password;
    private LocalDate dob;
    private long phone;
    
    public Profile() {
		super();
	}
    
    
	public Profile(int profileid, String name, String password, LocalDate dob, long phone) {
		super();
		this.profileid = profileid;
		this.name = name;
		this.password = password;
		this.dob = dob;
		this.phone = phone;
	}
	
	

	@Override
	public String toString() {
		return "Profile [profileid=" + profileid + ", name=" + name + ", password=" + password + ", dob=" + dob
				+ ", phone=" + phone + "]";
	}

	public int getProfileid() {
		return profileid;
	}

	public void setProfileid(int profileid) {
		this.profileid = profileid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
	
	// to have unique Profile in set we need to override  the hashcode and equals method

	@Override
	public int hashCode() {
		return Objects.hash(profileid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Profile other = (Profile) obj;
		return profileid == other.profileid;
	}

	
    
    
}
