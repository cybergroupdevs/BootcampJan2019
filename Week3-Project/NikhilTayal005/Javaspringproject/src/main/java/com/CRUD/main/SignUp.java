package com.CRUD.main;

public class SignUp {
public SignUp(int id, String fname, String lname, String userName, String email, String password) {
		super();
		Id = id;
		Fname = fname;
		Lname = lname;
		UserName = userName;
		this.email = email;
		Password = password;
	}
int Id;
String Fname;
String Lname;
String UserName;
String email;
String Password;

public int getId() {
	return Id;
}
public void setId(int id) {
	Id = id;
}
public String getFname() {
	return Fname;
}
public void setFname(String fname) {
	Fname = fname;
}
public String getLname() {
	return Lname;
}
public void setLname(String lname) {
	Lname = lname;
}
public String getUserName() {
	return UserName;
}
public void setUserName(String userName) {
	UserName = userName;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return Password;
}
public void setPassword(String password) {
	Password = password;
}
}
