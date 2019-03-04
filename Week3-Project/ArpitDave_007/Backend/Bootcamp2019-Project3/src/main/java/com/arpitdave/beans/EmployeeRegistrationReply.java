package com.arpitdave.beans;

public class EmployeeRegistrationReply {
    String EmployeeID;
    String Name;
    int Phone;
    String Email;
    int dob;
    String Password;
    String Designation;
    String RegistrationStatus;
	public String getEmployeeID() {
		return EmployeeID;
	}
	public void setEmployeeID(String employeeID) {
		EmployeeID = employeeID;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getPhone() {
		return Phone;
	}
	public void setPhone(int phone) {
		Phone = phone;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public int getDob() {
		return dob;
	}
	public void setDob(int dob) {
		this.dob = dob;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
    public String getRegistrationStatus() {
    return RegistrationStatus;
    }
    public void setRegistrationStatus(String registrationStatus) {
    this.RegistrationStatus = registrationStatus;
    }
	public String getDesignation() {
		return Designation;
	}
	public void setDesignation(String designation) {
		Designation = designation;
	}
}