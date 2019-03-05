package week3Controllers;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;



import week3.EmployeeDetails;
import week3.EmployeeRegistration;
import week3.StoreEmployeeDetails;

@CrossOrigin (origins = "*")

@Controller
public class EmployeeDetailsController {
	
	
	EmployeeRegistration EmpReg=new EmployeeRegistration();
	EmployeeDetails emp1=new EmployeeDetails();
	StoreEmployeeDetails EmpDetails=new StoreEmployeeDetails();
	
	
	@RequestMapping(method = RequestMethod.POST, value="/register/Employee")
	  @ResponseBody
	public EmployeeDetails EmployeeRecords(@RequestBody EmployeeDetails emp){
	
	  Connection conn=null;
	try {
		
		String FirstName=emp.getFirstName();
		String LastName=emp.getLastName();
		String DesignationId=emp.getDesignationId();
		String EmailId=emp.getEmailId();
		String Contact=emp.getContact();
		String AddressLine1=emp.getAddressLine1();
		String AddressLine2=emp.getAddressLine2();
		String City=emp.getCity();
		String Country=emp.getCountry();
		
		String dbURL="jdbc:sqlserver://DESKTOP-95D75UP;databaseName=HRMS";{
				String user="sa";
		conn=DriverManager.getConnection(dbURL,user,"Abhishek");
		if(conn!=null)
		{
			System.out.println("Connection Successful");
		    
			Statement stmt = conn.createStatement();
			
		    stmt.execute("Insert into EmployeeDetails values( \'" + FirstName +"\' ," + " \'"+ LastName +"\' ," + " \'"+DesignationId +"\' ," + " \'"+ EmailId +"\' ," + " \'"+ Contact +"\' ," + " \'"+ AddressLine1 +"\' ," + " \'"+AddressLine2 +"\' ," + " \'"+ City+"\' ," + " \'"+Country);
		    System.out.println("Done");
		    ResultSet rs  = stmt.executeQuery("SELECT * from EmployeeDetails where FirstName = \'" + FirstName + "\' ;");
		    
		    emp1.setFirstName(rs.getString("FirstName"));
			emp1.setLastName(rs.getString("LastName"));
			emp1.setDesignationId(rs.getString("DesignationId"));
			 emp1.setEmailId(rs.getString("EmailId"));
				emp1.setContact(rs.getString("Contact"));
				emp1.setAddressLine1(rs.getString("AddressLine"));
				emp1.setAddressLine2(rs.getString("AddressLine2"));
					emp1.setCity(rs.getString("City"));
					emp1.setCountry(rs.getString("Country"));
		}
	}
}
	catch(Exception se) {
		se.printStackTrace();
}
	
		return emp;
	  }
	
	
	 

	  
	  
	
	
	@RequestMapping(method = RequestMethod.GET, value="/retreive/Employee")
	  @ResponseBody
	  public List<EmployeeDetails> getAllEmployees() {
		List<EmployeeDetails> empRecords = new ArrayList<EmployeeDetails>();
		Connection conn = null;
		try {
			String dbURL = "jdbc:sqlserver://DESKTOP-95D75UP;databaseName=HRMS";
			String user = "sa";
			conn = DriverManager.getConnection(dbURL,user,"Abhishek" );
			if(conn != null ) {
	
			    System.out.println("Connection Successful");
				Statement stmt = conn.createStatement();
				ResultSet rs  = stmt.executeQuery("SELECT * from EmployeeDetails;");
				
				while(rs.next()) {	
					EmployeeDetails emp1 = new EmployeeDetails();
					emp1.setFirstName(rs.getString("FirstName"));
					emp1.setLastName(rs.getString("LastName"));
					emp1.setDesignationId(rs.getString("DesignationId"));
					 emp1.setEmailId(rs.getString("EmailId"));
						emp1.setContact(rs.getString("Contact"));
						emp1.setAddressLine1(rs.getString("AddressLine1"));
						emp1.setAddressLine2(rs.getString("AddressLine2"));
							emp1.setCity(rs.getString("City"));
							emp1.setCountry(rs.getString("Country"));
					System.out.println(rs.getString("FirstName") + "," + rs.getString("LastName")+ "," + rs.getString("DesignationId")+ "," +rs.getString("EmailId") + "," + rs.getString("Contact")+ "," + rs.getString("AddressLine1")+ "," +rs.getString("AddressLine2") + "," + rs.getString("City")+ "," + rs.getInt("Country") );
				}
			
			}
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		return empRecords;
	  }

	
	
	@RequestMapping(method = RequestMethod.DELETE, value="api/employees/{id}")
	@ResponseBody
	public String deleteEmployee(@PathVariable("id") int id){
    	Connection conn = null;
		try {
			
			String dbURL = "jdbc:sqlserver://DESKTOP-95D75UP;databaseName=HRMS";
			String user = "sa";
			conn = DriverManager.getConnection(dbURL, user, "Abhishek" );
			if(conn != null ) {

			    System.out.println("Connection Successful");
				Statement stmt = conn.createStatement();
				stmt.execute("Delete from EmployeeDetails where Employeeid = " + id + ";");

			    System.out.println("Deletion Successful");
			}
	   
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		return "Delete successful";
    }

	
	
	
		@RequestMapping(method = RequestMethod.PUT, value="api/employees/{UpdateId}")
		
		@ResponseBody
		public String UpdateEmployee(@PathVariable("UpdateId") int UpdateId,@RequestBody EmployeeDetails emp){
			
			int id = UpdateId;
			
			
			String FirstName=emp.getFirstName();
			String LastName=emp.getLastName();
			String DesignationId=emp.getDesignationId();
			String EmailId=emp.getEmailId();
			String Contact=emp.getContact();
			String AddressLine1=emp.getAddressLine1();
			String AddressLine2=emp.getAddressLine2();
			String City=emp.getCity();
			String Country=emp.getCountry();
		
	    	Connection conn = null;
			try {
				
				String dbURL = "jdbc:sqlserver://DESKTOP-95D75UP;databaseName=HRMS";
				String user = "sa";
				conn = DriverManager.getConnection(dbURL, user, "Abhishek" );
				if(conn != null ) {

				    System.out.println("Connection Successful");
				    
					Statement stmt = conn.createStatement();
					stmt.executeQuery("Update EmployeeDetails where EmployeeId = " + id + " Set FirstName = \'" + FirstName + "\' , LastName = \' " + LastName + "\' , DesignationId = " + DesignationId + "\' , EmailId = \' " + EmailId +  "\' , Contact = \' " + Contact +  "\' , AddressLine1 = \' " + AddressLine1 +  "\' , AddressLine2 = \' " + AddressLine2 +  "\' , City = \' " + City +  "\' , Country = \' " + Country +" ;");
					
				}
		    
			}
			catch(SQLException ex) {
				ex.printStackTrace();
			}
			return "Update successful";
			
	    }
	

	}
	

