package com.example.demo.beans;

public class Profile {
	public Profile(int iD, String designation, String qualification, String experience) {
		super();
		ID = iD;
		Designation = designation;
		Qualification = qualification;
		Experience = experience;
	}
	int ID;
	String Designation;
	String Qualification;
	String Experience;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getDesignation1() {
		return Designation;
	}
	public void setDesignation(String designation) {
		Designation = designation;
	}
	public String getQualification() {
		return Qualification;
	}
	public void setQualification(String qualification) {
		Qualification = qualification;
	}
	public String getExperience() {
		return Experience;
	}
	public void setExperience(String experience) {
		Experience = experience;
	}
	public String getDesignation() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
