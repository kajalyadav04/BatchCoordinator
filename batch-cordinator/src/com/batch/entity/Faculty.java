package com.batch.entity;


import com.batch.utility.GenerateId;

public class Faculty extends Users {
	private String facId;

	public Faculty(String username, String password, String email, int phonenumber, Address address) {
		super(username, password, email, phonenumber, address);
		this.facId = GenerateId.generateFacIdString(username);
	}

	public Faculty() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getFacId() {
		return facId;
	}

	public void setFacId(String facId) {
		this.facId = facId;
	}

	@Override
	public String toString() {
		return "Faculty [facId=" + facId + "]";
	}
	
	
	

}
