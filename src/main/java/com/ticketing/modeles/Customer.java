package com.ticketing.modeles;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;

import com.sun.istack.NotNull;

@Entity
public class Customer {
	@Id
	@GeneratedValue
	private int custId;
	@NotNull
	private String custName;
	@NotNull
	private String address;
	@NotNull
	private String city;
	@NotNull
	@Email
	private String email;
	@NotNull
	private String phoneNumber;
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Customer() {
		
	}
	public Customer(String custName, String address, String city, @Email String email,
			String phoneNumber) {
		
		this.custName = custName;
		this.address = address;
		this.city = city;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

}
