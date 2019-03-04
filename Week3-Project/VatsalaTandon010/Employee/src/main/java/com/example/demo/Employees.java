package com.example.demo;

public class Employees {
	public Employees() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employees(int employee_CGI_Code, String first_Name, String last_Name, String designation,
			int years_Of_Experiance, String qualification) {
		super();
		Employee_CGI_Code = employee_CGI_Code;
		First_Name = first_Name;
		Last_Name = last_Name;
		Designation = designation;
		Years_Of_Experiance = years_Of_Experiance;
		Qualification = qualification;
	}
	int Employee_CGI_Code ;
	String First_Name ;
	String Last_Name;
	String Designation;
	int Years_Of_Experiance ;
	String Qualification ;
	public int getEmployee_CGI_Code() {
		return Employee_CGI_Code;
	}
	public void setEmployee_CGI_Code(int employee_CGI_Code) {
		Employee_CGI_Code = employee_CGI_Code;
	}
	public String getFirst_Name() {
		return First_Name;
	}
	public void setFirst_Name(String first_Name) {
		First_Name = first_Name;
	}
	public String getLast_Name() {
		return Last_Name;
	}
	public void setLast_Name(String last_Name) {
		Last_Name = last_Name;
	}
	public String getDesignation() {
		return Designation;
	}
	public void setDesignation(String designation) {
		Designation = designation;
	}
	public int getYears_Of_Experiance() {
		return Years_Of_Experiance;
	}
	public void setYears_Of_Experiance(int years_Of_Experiance) {
		Years_Of_Experiance = years_Of_Experiance;
	}
	public String getQualification() {
		return Qualification;
	}
	public void setQualification(String qualification) {
		Qualification = qualification;
	}
}
