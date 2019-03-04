package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class EmployeeDetails {

	@Id
	private int Id;
	private String name;
	private String password;
	
	public EmployeeDetails() {}
	
	public EmployeeDetails(int id, String name, String pass) {
		this.setId(id);
		this.setName(name);
		this.setPassword(pass);
	}
	
	public EmployeeDetails(int id, String name) {
		this.setId(id);
		this.setName(name);
	}
	
	public EmployeeDetails(String name, String password) {
		this.setPassword(password);
		this.setName(name);
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
