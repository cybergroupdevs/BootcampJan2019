package com.example.demo.model;
import javax.persistence.Id;
import javax.persistence.Entity;

@Entity
public class User {
	
	@Id
	private int Id;
	private String name;
	private String EmpId;
	
	public User () {}
	public User(int Id, String name, String EmpId) {
		this.setId(Id);
		this.setName(name);
		this.setEmpId(EmpId);
	}
	public User(String name, String EmpId) {
		this.setName(name);
		this.setEmpId(EmpId);
	}
	
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmpId() {
		return EmpId;
	}
	public void setEmpId(String EmpId) {
		this.EmpId = EmpId;
	}
	
		
	}

