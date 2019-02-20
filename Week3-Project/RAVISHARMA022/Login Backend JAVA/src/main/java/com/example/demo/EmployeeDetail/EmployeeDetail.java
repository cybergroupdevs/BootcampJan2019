package com.example.demo.EmployeeDetail;

import javax.persistence.Entity;

@Entity
public class EmployeeDetail {
	private String Id;
	private String firstname;
	private String lastname;
	private String fathername;
	private String Email;
	private String Phone;
	private String country;
	private String dob;
	private String gender;
	private String designation;
	private String address;
	
	//constructor for create Api
	public EmployeeDetail(String Id,String firstname,String lastname, 
			String fathername,String Email,String Phone, 
			String country,String dob,String gender,
			String designation,String address) {
		this.setId(Id);
		this.setFirstname(firstname);
		this.setLastname(lastname);
		this.setFathername(fathername);
		this.setEmail(Email);
		this.setPhone(Phone);
		this.setCountry(country);
		this.setDob(dob);
		this.setGender(gender);
		this.setDesignation(designation);
		this.setAddress(address);
	}
	//constructor for update Api
	public EmployeeDetail(String firstname,String lastname, 
			String fathername,String Email,String Phone, 
			String country,String dob,String gender,
			String designation,String address) {
		this.setFirstname(firstname);
		this.setLastname(lastname);
		this.setFathername(fathername);
		this.setEmail(Email);
		this.setPhone(Phone);
		this.setCountry(country);
		this.setDob(dob);
		this.setGender(gender);
		this.setDesignation(designation);
		this.setAddress(address);
	}
	
	//getters and setters
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getFathername() {
		return fathername;
	}
	public void setFathername(String fathername) {
		this.fathername = fathername;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
