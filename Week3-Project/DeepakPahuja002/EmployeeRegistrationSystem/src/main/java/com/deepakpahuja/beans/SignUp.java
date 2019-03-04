package com.deepakpahuja.beans;

public class SignUp {
	int Id;
	String Name;
    String EmailId;
    String Password;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getEmailId() {
		return EmailId;
	}
	public void setEmailId(String emailId) {
		EmailId = emailId;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public SignUp(int id, String name, String emailId, String password) {
		super();
		Id = id;
		Name = name;
		EmailId = emailId;
		Password = password;
	}
	
}
