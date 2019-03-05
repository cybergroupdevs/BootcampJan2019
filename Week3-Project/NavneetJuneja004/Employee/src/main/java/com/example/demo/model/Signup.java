package com.example.demo.model;

import javax.persistence.Id;

public class Signup {

	  private	String firstname; 
	  private	String lastname;
	  private	String pswd; 
	  
	  @Id
	  private   String id;
	  
	  public Signup() {} 
	  
	//Constructor for get/delete put Api
		public Signup(String Id,String firstname,String lastname,String pswd)
		{	
			this.setId(Id);
			this.setFirstname(firstname);
			this.setLastname(lastname);
			this.setPswd(pswd);
			
		}
		//Constructor for update/put Api
		public Signup(String firstname,String lastname,String pswd)
		{	
		this.setFirstname(firstname);
		this.setLastname(lastname);
		this.setPswd(pswd);
		
			
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
		public String getPswd() {
			return pswd;
		}
		public void setPswd(String pswd) {
			this.pswd = pswd;
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		
}
