package com.springdata.hibernate.model;



import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "student")
public class Student {

	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "student")
	private Set<Info> infos;
	


	public Set<Info> getInfos() {
		return infos;
	}

	public void setInfos(Set<Info> infos) {
		this.infos = infos;
	}


	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ; 
	
	public Student() {
		infos = new HashSet<Info>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	@Column(name = "full_name")
	private String name ; 
}
