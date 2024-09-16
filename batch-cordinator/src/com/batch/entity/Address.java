package com.batch.entity;

import java.io.Serializable;

public class Address implements Serializable {

	private String city;
	private int pincode;
	private String state;
	private String country;

	public Address(String city, int pincode, String state, String country) {
		super();
		this.city = city;
		this.pincode = pincode;
		this.state = state;
		this.country = country;
	}

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getCity() {

		return city;
	}

	public void setCity(String city) {
		this.city = city;

	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "Address [ city: " + city + ", pincode: " + pincode+", state: "+state+", country: "+country;
	}

}
