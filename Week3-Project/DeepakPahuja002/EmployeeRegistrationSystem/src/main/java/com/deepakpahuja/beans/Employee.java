package com.deepakpahuja.beans;

public class Employee {
    String employeeId;
    String name;
    String designation;
    String phoneNo;
    int signUpId;
    
    
    
	public Employee(String employeeId, String name, String designation, String phoneNo, int signUpId) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.designation = designation;
		this.phoneNo = phoneNo;
		this.signUpId = signUpId;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public int getSignUpId() {
		return signUpId;
	}
	public void setSignUpId(int signUpId) {
		this.signUpId = signUpId;
	}
	
}
