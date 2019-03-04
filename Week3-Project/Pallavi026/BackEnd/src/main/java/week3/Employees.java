package week3;
import javax.persistence.Entity;

@Entity
public class Employees {
	 public Employees() {
		super();
		// TODO Auto-generated constructor stub
	}
	String ID;
	    String Name;
	      int ContactNo;
	      String Gender;
	      String Password;  
	      String EmailID; 
	      String DesigID;
	     //constructor for post 
public Employees(String ID, String Name, int ContactNo,String Gender, String Password, String EmailID, String DesigID) {
	  		this.setID(ID);
	  		this.setName(Name);
	  		this.setContactNo(ContactNo);
	  		this.setGender(ID);
	  		this.setName(Name);
	  		this.setPassword(Password);
	  		this.setEmailID(EmailID);
	  		this.setDesigID(DesigID);
	  	}
	 //Constructor for PUT/DELETE     

	      
		public String getID() {
			return ID;
		}
		public void setID(String iD) {
			ID = iD;
		}
		public String getName() {
			return Name;
		}
		public void setName(String name) {
			Name = name;
		}
		public int getContactNo() {
			return ContactNo;
		}
		public void setContactNo(int contactNo) {
			ContactNo = contactNo;
		}
		public String getGender() {
			return Gender;
		}
		public void setGender(String gender) {
			Gender = gender;
		}
		public String getPassword() {
			return Password;
		}
		public void setPassword(String password) {
			Password = password;
		}
		public String getEmailID() {
			return EmailID;
		}
		public void setEmailID(String emailID) {
			EmailID = emailID;
		}
		public String getDesigID() {
			return DesigID;
		}
		public void setDesigID(String desigID) {
			DesigID = desigID;
		}
		
	      
	 
}
