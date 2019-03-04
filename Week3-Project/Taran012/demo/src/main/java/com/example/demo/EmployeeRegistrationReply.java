package com.example.demo;

public class EmployeeRegistrationReply {
	int id;
	String name;
    String mail;
    int DesignationID;
    String EmployeeRegistrationStatus;
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
		DesignationID = designationID;
	}
	public String getEmployeeRegistrationStatus() {
		return EmployeeRegistrationStatus;
	}
	public void setEmployeeRegistrationStatus(String employeeRegistrationStatus) {
		EmployeeRegistrationStatus = employeeRegistrationStatus;
	}  
}
