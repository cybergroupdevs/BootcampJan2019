package com.cybergroup.bootcamp.week3;

public class Employee {
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(int cygId, String firstName, String lastName, String dOB, String designation, String emailId,
			String phoneNo) {
		super();
		CygId = cygId;
		FirstName = firstName;
		LastName = lastName;
		DOB = dOB;
		Designation = designation;
		EmailId = emailId;
		PhoneNo = phoneNo;
	}
	int CygId;
	String FirstName;
	String LastName;
	String DOB;
	String Designation;
	String EmailId;
	String PhoneNo;
	
	public int getCygId() {
		return CygId;
	}
	public void setCygId(int cygId) {
		CygId = cygId;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getDOB() {
		return DOB;
	}
	public void setDOB(String dOB) {
		DOB = dOB;
	}
	public String getDesignation() {
		return Designation;
	}
	public void setDesignation(String designation) {
		Designation = designation;
	}
	public String getEmailId() {
		return EmailId;
	}
	public void setEmailId(String emailId) {
		EmailId = emailId;
	}
	public String getPhoneNo() {
		return PhoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		PhoneNo = phoneNo;
	}

}
