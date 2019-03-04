package com.example.demo.beans;

public class EmployeeRegistrationReply {
	
	int id;
    String Name;
    int Age;
    String Gender;
    int DesignationId;
   
	String registrationStatus;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}

	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public int getDesignationId() {
		return DesignationId;
	}
	public void setDesignationId(int designationId) {
		DesignationId = designationId;
	}
	public String getRegistrationStatus() {
		return registrationStatus;
	}
	public void setRegistrationStatus(String registrationStatus) {
		this.registrationStatus = registrationStatus;
	}
    
    
    
    

}