package com.batch.entity;

public class Users {
	private String username;
	private String password;
	private String email;
	private int phonenumber;
	private Address address;
	public Users(String username, String password, String email, int phonenumber, Address address) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.phonenumber = phonenumber;
		this.address = address;
	}
	public Users() {
		super();
	}
	public String getUserName() {
		return username;
	}
	public void setUserName(String Username){
		this.username=Username;	
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(int phonenumber) {
		this.phonenumber = phonenumber;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	

}
