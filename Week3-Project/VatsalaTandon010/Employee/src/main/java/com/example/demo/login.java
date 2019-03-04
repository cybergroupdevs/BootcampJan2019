package com.example.demo;

public class login {
	public login() {
		super();
		// TODO Auto-generated constructor stub
	}
	public login(int id, String username, String email_ID, String password) {
		super();
		Id = id;
		Username = username;
		Email_ID = email_ID;
		Password = password;
	}
	int Id ;
	String Username ;
	String Email_ID;
	String Password;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getEmail_ID() {
		return Email_ID;
	}
	public void setEmail_ID(String email_ID) {
		Email_ID = email_ID;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
}
