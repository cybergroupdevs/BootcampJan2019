package com.example.demo;

public class Employee {
	int id;
	String name;
    String mail;
    int DesignationID;
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
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public int getDesignationID() {
		return DesignationID;
	}
	public void setDesignationID(int designationID) {
		this.DesignationID = designationID;
	}
}
