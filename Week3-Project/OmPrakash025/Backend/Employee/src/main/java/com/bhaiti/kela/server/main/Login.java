package com.bhaiti.kela.server.main;

public class Login {
	public Login(int id, String employeeId, String password) {
		super();
		Id = id;
		EmployeeId = employeeId;
		Password = password;
	}
	int Id;
	String EmployeeId;
	String Password;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getEmployeeId() {
		return EmployeeId;
	}
	public void setEmployeeId(String employeeId) {
		EmployeeId = employeeId;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
}
