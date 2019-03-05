package com.example.demo.model;

import javax.persistence.Id;

public class Employee {
	  private String id; 
	  
	  @Id
	  private	String empid;
	  
	  
	  private	String firstname;
	 
	  private	String lastname;
	  
	  private	String DOB;
	  
	  private	String Gender;
	  
	  private	String Designation; 
	  
	  private String Adress;
	  
	  public Employee() {}
	  
	//constructor for create Api
		public Employee(String empid,String id,String firstname,String lastname, 
				
			String DOB,String Gender,
				String Designation,String Adress) {
			this.setId(id);
			this.setEmpid(empid);
			this.setFirstname(firstname);
			this.setLastname(lastname);
			
			this.setDOB(DOB);
			this.setGender(Gender);
			this.setDesignation(Designation);
			this.setAdress(Adress);
			
		}
		//constructor for update Api 
	
	  public Employee(String firstname,String lastname, String DOB,String Gender,
	  String Designation,String Adress) { this.setFirstname(firstname);
	  this.setLastname(lastname);
	  
	  this.setDOB(DOB); this.setGender(Gender); this.setDesignation(Designation);
	  this.setAdress(Adress);
	  
	  }
	 
	  
	  	public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getEmpid() {
			return empid;
		}
		public void setEmpid(String empid) {
			this.empid = empid;
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
		public String getDOB() {
			return DOB;
		}
		public void  setDOB(String DOB) {
			this.DOB = DOB;
		}
		 public String getGender() {
			return Gender;
		}
		public void setGender(String Gender) {
			this.Gender = Gender;
		}
		public String getDesignation() {
			return Designation;
		}
		public void setDesignation(String Designation) {
			this.Designation = Designation;
		}
		public String getAdress() {
			return Adress;
		}
		public void setAdress(String Adress) {
			this.Adress = Adress;
		}
}
	