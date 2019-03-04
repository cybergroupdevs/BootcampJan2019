package com.example.demo.beans;

public class SignUp {
	public SignUp(int iD, String fName, String lName, String emailID, int number, String password) {
		super();
		ID = iD;
		FName = fName;
		LName = lName;
		EmailID = emailID;
		Number = number;
		Password = password;
	}
	int ID;
	String FName;
	String LName;
	String EmailID;
	int Number;
	String Password;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getFName() {
		return FName;
	}
	public void setFName(String fName) {
		FName = fName;
	}
	public String getLName() {
		return LName;
	}
	public void setLName(String lName) {
		LName = lName;
	}
	public String getEmailID() {
		return EmailID;
	}
	public void setEmailID(String emailID) {
		EmailID = emailID;
	}
	public int getNumber() {
		return Number;
	}
	public void setNumber(int number) {
		Number = number;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}

}
