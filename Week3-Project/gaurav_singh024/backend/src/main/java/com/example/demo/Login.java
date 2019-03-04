package com.example.demo;

public class Login {

int Id;
String Email;
String Password;


public int getId() {
	return Id;
}
public void setId(int id) {
	Id = id;
}
public String getEmail() {
	return Email;
}
public void setEmail(String email) {
	Email = email;
}
public String getPassword() {
	return Password;
}
public void setPassword(String password) {
	Password = password;
}
public Login(int id, String email, String password) {
	this.setId(id);	
	this.setEmail(email);
	this.setPassword(password);
}
public Login() {
	super();
	// TODO Auto-generated constructor stub
}
}
