package com.example.calls;

public class Project {
	int ID;
	String Name;
	int User_ID;
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getUser_ID() {
		return User_ID;
	}
	public void setUser_ID(int User_ID) {
		User_ID = User_ID;
	}
	
	public Project() {
		ID = 0;
		
		Name = null;
		User_ID = 0;
		
	}
	public Project(int id, String name,  int userid) {
		ID = id;
		Name = name;
		User_ID = userid;
		
	}

}
