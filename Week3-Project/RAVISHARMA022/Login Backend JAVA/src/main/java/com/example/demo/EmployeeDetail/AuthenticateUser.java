package com.example.demo.EmployeeDetail;
import javax.persistence.Entity;

@Entity
public class AuthenticateUser {
	private String Id;
	private String Email;
	private String Password;
	private boolean Terms;
	
	//Constructor for get/delete put Api
	public AuthenticateUser(String Id,String Email,String Password,boolean Terms)
	{	
		this.setId(Id);
		this.setEmail(Email);
		this.setPassword(Password);
		this.setTerms(Terms);
	}
	//Constructor for update/put Api
	public AuthenticateUser(String Email,String Password,boolean Terms)
	{	
		this.setEmail(Email);
		this.setPassword(Password);
		this.setTerms(Terms);
	}
	
	//Getter and Setter for table
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public boolean isTerms() {
		return Terms;
	}
	public void setTerms(boolean terms) {
		Terms = terms;
	}
}
