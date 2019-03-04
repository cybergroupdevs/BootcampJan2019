package com.example.calls;

public class User {
	int ID;
	String Username;
	String Password;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public User() {
		ID = 0;
		
		Username = null;
		Password = null;
		
	}
	public User(int id, String name,  String password) {
		ID = id;
		Username = name;
		Password = password;
		
	}
}
