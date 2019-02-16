package com.example.demo;

public class EmployeeRegistrationReply {

			String Name;
			String Email;
			String Phone;
		    int Age;
		    int Id;
		    int DesignationID;
		    String Gender;
		    String registrationStatus;
		    
			public int getDesignationID() {
				return DesignationID;
			}
			public void setDesignationID(int DesignationID) {
				this.DesignationID = DesignationID;
			}
		    public String getName() {
		    return Name;
		    }
		    public void setName(String Name) {
		    this.Name = Name;
		    }
		    public String getEmail() {
				return Email;
			}
			public void setEmail(String Email) { 
				this.Email = Email;
			}
			public String getPhone() {
				return Phone;
			}
			public void setPhone(String Phone) { 
				this.Phone = Phone;
			}
		    public String getGender() {
				return Gender;
			}
			public void setGender(String Gender) { 
				this.Gender = Gender;
			}
		    public int getAge() {
		    return Age;
		    }
		    public void setAge(int Age) {
		    this.Age = Age;
		    }
		    public int getId() {
		    return Id;
		    }
		    public void setId(int Id) {
		    this.Id = Id;
		    }
		    public String getRegistrationStatus() {
		    return registrationStatus;
		    }
		    public void setRegistrationStatus(String registrationStatus) {
		    this.registrationStatus = registrationStatus;
		    }

		

	

}
