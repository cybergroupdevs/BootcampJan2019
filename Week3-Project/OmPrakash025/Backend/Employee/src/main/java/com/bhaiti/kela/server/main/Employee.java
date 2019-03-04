package com.bhaiti.kela.server.main;

public class Employee {
	int ID;
	String Name;
	String Email;
	String PhoneNumber;
	String FathersName;
	String MothersName;
	String DOB;
	String Gender;
	String BloodGroup;
	String Nationality;
	String AadharNumber;
	String PanNumber;
	String Bio;
	String JobRole;
	
	public Employee(int iD, String name, String email, String phoneNumber, String fathersName, String mothersName,
			String dOB, String gender, String bloodGroup, String nationality, String aadharNumber, String panNumber,
			String bio, String jobRole) {
		super();
		ID = iD;
		Name = name;
		Email = email;
		PhoneNumber = phoneNumber;
		FathersName = fathersName;
		MothersName = mothersName;
		DOB = dOB;
		Gender = gender;
		BloodGroup = bloodGroup;
		Nationality = nationality;
		AadharNumber = aadharNumber;
		PanNumber = panNumber;
		Bio = bio;
		JobRole = jobRole;
	}
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
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}
	public String getFathersName() {
		return FathersName;
	}
	public void setFathersName(String fathersName) {
		FathersName = fathersName;
	}
	public String getMothersName() {
		return MothersName;
	}
	public void setMothersName(String mothersName) {
		MothersName = mothersName;
	}
	public String getDOB() {
		return DOB;
	}
	public void setDOB(String dOB) {
		DOB = dOB;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public String getBloodGroup() {
		return BloodGroup;
	}
	public void setBloodGroup(String bloodGroup) {
		BloodGroup = bloodGroup;
	}
	public String getNationality() {
		return Nationality;
	}
	public void setNationality(String nationality) {
		Nationality = nationality;
	}
	public String getAadharNumber() {
		return AadharNumber;
	}
	public void setAadharNumber(String aadharNumber) {
		AadharNumber = aadharNumber;
	}
	public String getPanNumber() {
		return PanNumber;
	}
	public void setPanNumber(String panNumber) {
		PanNumber = panNumber;
	}
	public String getBio() {
		return Bio;
	}
	public void setBio(String bio) {
		Bio = bio;
	}
	public String getJobRole() {
		return JobRole;
	}
	public void setJobRole(String jobRole) {
		JobRole = jobRole;
	}
}
