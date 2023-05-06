package com.springdata.hibernate.model;

import javax.persistence.Id;

public class Info {

	
	@Id
	private int id ; 
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	private String Phone ; 
	
	
	public Info() {
		
		
	}
	
}
