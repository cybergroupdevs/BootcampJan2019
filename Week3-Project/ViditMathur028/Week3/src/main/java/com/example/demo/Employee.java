package com.example.demo;

public class Employee {
int ID;
String Code;
String Name;
int DesignationId;
String EmailId;
String Address;
String Contact;
int DepartmentId;
public int getID() {
	return ID;
}
public void setID(int iD) {
	ID = iD;
}
public String getCode() {
	return Code;
}
public void setCode(String code) {
	Code = code;
}
public String getName() {
	return Name;
}
public void setName(String name) {
	Name = name;
}
public int getDesignationId() {
	return DesignationId;
}
public void setDesignationId(int designationId) {
	DesignationId = designationId;
}
public String getEmailId() {
	return EmailId;
}
public void setEmailId(String emailId) {
	EmailId = emailId;
}
public String getAddress() {
	return Address;
}
public void setAddress(String address) {
	Address = address;
}
public String getContact() {
	return Contact;
}
public void setContact(String contact) {
	Contact = contact;
}
public int getDepartmentId() {
	return DepartmentId;
}
public void setDepartmentId(int departmentId) {
	DepartmentId = departmentId;
}
public Employee() {
	ID = 0;
	Code = null;
	Name = null;
	DesignationId = 0;
	EmailId = null;
	Address = null;
	Contact = null;
	DepartmentId = 0;
}
public Employee(int id, String code, String name, int designationId, String emailId, String address, String contact,
		int departmentId) {
	ID = id;
	Code = code;
	Name = name;
	DesignationId = designationId;
	EmailId = emailId;
	Address = address;
	Contact = contact;
	DepartmentId = departmentId;
}
}
