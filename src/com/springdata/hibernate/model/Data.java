package com.springdata.hibernate.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "data")
public class Data {

	@OneToOne(mappedBy = "data",cascade = CascadeType.ALL)
	private Person p;
	
	
	
	
	public Person getP() {
		return p;
	}

	public void setP(Person p) {
		this.p = p;
	}

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int id ; 
	
	@Column(name = "person_age")
	private String age ;

	public Data() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	} 
	
}
