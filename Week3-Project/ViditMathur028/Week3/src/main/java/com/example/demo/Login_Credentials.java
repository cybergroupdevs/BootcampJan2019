package com.example.demo;

public class Login_Credentials {
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

public Login_Credentials(int id, String email, String password) {
	Id = id;
	Email = email;
	Password = password;
}
public Login_Credentials() {
	Id = 0;
	Email = null;
	Password = null;
}
}
