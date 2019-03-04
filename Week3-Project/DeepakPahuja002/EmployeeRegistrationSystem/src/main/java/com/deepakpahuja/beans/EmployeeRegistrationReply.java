package com.deepakpahuja.beans;

public class EmployeeRegistrationReply {
	String EmployeeId;
    String Name;
    String Designation;
    String PhoneNo;
    int SignUpId;
    String registrationStatus;
	public String getEmployeeId() {
		return EmployeeId;
	}
	public void setEmployeeId(String employeeId) {
		EmployeeId = employeeId;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getDesignation() {
		return Designation;
	}
	public void setDesignation(String designation) {
		Designation = designation;
	}
	public String getPhoneNo() {
		return PhoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		PhoneNo = phoneNo;
	}
	public int getSignUpId() {
		return SignUpId;
	}
	public void setSignUpId(int signUpId) {
		SignUpId = signUpId;
	}
	public String getRegistrationStatus() {
		return registrationStatus;
	}
	public void setRegistrationStatus(String registrationStatus) {
		this.registrationStatus = registrationStatus;
	}
}
