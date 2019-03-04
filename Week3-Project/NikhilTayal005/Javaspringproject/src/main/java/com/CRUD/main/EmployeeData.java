package com.CRUD.main;

public class EmployeeData {
public EmployeeData() {
		super();
		// TODO Auto-generated constructor stub
	}
public EmployeeData(int id, String idtype, String martialStatus, String dOB, String name, String contact,
			String home, String email, String address, String pinCode, String state) {
		super();
		Id = id;
		Idtype = idtype;
		MartialStatus = martialStatus;
		DOB = dOB;
		Name = name;
		Contact = contact;
		Home = home;
		Email = email;
		Address = address;
		PinCode = pinCode;
		State = state;
	}
int Id;
String Idtype;
int IdNumber;
String MartialStatus;
String DOB;
String Name;
String Contact;
String Home;
String Email;
String Address;
String PinCode;
String State;
public int getId() {
	return Id;
}
public void setId(int id) {
	Id = id;
}
public String getIdtype() {
	return Idtype;
}
public void setIdtype(String idtype) {
	Idtype = idtype;
}
public int getIdNumber() {
	return Id;
}
public void setIdNumber(int idNumber) {
	Id = idNumber;
}
public String getMartialStatus() {
	return MartialStatus;
}
public void setMartialStatus(String martialStatus) {
	MartialStatus = martialStatus;
}
public String getDOB() {
	return DOB;
}
public void setDOB(String dOB) {
	DOB = dOB;
}
public String getName() {
	return Name;
}
public void setName(String name) {
	Name = name;
}
public String getContact() {
	return Contact;
}
public void setContact(String contact) {
	Contact = contact;
}
public String getHome() {
	return Home;
}
public void setHome(String home) {
	Home = home;
}
public String getEmail() {
	return Email;
}
public void setEmail(String email) {
	Email = email;
}
public String getAddress() {
	return Address;
}
public void setAddress(String address) {
	Address = address;
}
public String getPinCode() {
	return PinCode;
}
public void setPinCode(String pinCode) {
	PinCode = pinCode;
}
public String getState() {
	return State;
}
public void setState(String state) {
	State = state;
}
}
