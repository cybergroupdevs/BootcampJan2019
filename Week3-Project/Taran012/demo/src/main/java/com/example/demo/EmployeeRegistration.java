package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRegistration {
	private List<Employee> employeeRecords;
	private static EmployeeRegistration empregd = null;
    private EmployeeRegistration(){
    	employeeRecords = new ArrayList<Employee>();
    }
    
    public static EmployeeRegistration getInstance() {
        if(empregd == null) {
        	  empregd = new EmployeeRegistration();
              return empregd;
        }
        else {
            return empregd;
        }
    }
    
public void add(Employee emp) {
    	employeeRecords.add(emp);
    	
    	Connection conn = null;
		try {
			String name = emp.getName();
			int id = emp.getId();
			String mail = emp.getMail();
			int DesignationId = emp.getDesignationID();
//			String dbURL = "jdbc:sqlserver://DESKTOP-NP793MF; databaseName = Database1";
			String dbURL = "jdbc:sqlserver://DESKTOP-NP793MF; databaseName = CorporateLedger";
			String user = "sa";
			conn = DriverManager.getConnection(dbURL, user, "P@ssw0rd" );
			if(conn != null ) {

			    System.out.println("Connection Successful******************************");
			    
				Statement stmt = conn.createStatement();
				
				stmt.execute("Drop table Personstest;");
			    System.out.println("Dropped******************************");

				stmt.execute("Create table Personstest( id int);");
			    System.out.println("Created******************************");

			    stmt.execute("Insert into employee values( \'" + mail +"\' ," + " \'"+ name +"\' ," + DesignationId + ");");
			    System.out.println("Done******************************");

			    System.out.println("Id is: " + id);
			}
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
    }
	
//    public List<Employee> getEmployeeRecords() {
//    	return employeeRecords;
//    }
    public List<Employee> getEmployeeRecords() {
    	
    	Connection conn = null;
		try {
			
			String dbURL = "jdbc:sqlserver://DESKTOP-NP793MF; databaseName = CorporateLedger";
			String user = "sa";
			conn = DriverManager.getConnection(dbURL, user, "P@ssw0rd" );
			if(conn != null ) {

			    System.out.println("Connection Successful******************************");
			    
				Statement stmt = conn.createStatement();
				ResultSet rs  = stmt.executeQuery("SELECT * from employee;");
				
				while(rs.next()) {	
					Employee emp = new Employee();
					emp.setId(rs.getInt("id"));
					emp.setDesignationID(rs.getInt("DesignationId"));
					emp.setMail(rs.getString("mail"));
					emp.setName(rs.getString("name"));
			    	employeeRecords.add(emp);
					System.out.println(rs.getInt("id") + "," + rs.getString("name")+ "," + rs.getInt("DesignationId") );
				}
				System.out.println("done with get");
				
			}
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
    	
    	return employeeRecords;
    }
    public String deleteEmployee(int id){
    	Connection conn = null;
		try {
			
			String dbURL = "jdbc:sqlserver://DESKTOP-NP793MF; databaseName = CorporateLedger";
			String user = "sa";
			conn = DriverManager.getConnection(dbURL, user, "P@ssw0rd" );
			if(conn != null ) {

			    System.out.println("Connection Successful******************************");
			    
				Statement stmt = conn.createStatement();
				stmt.executeQuery("Delete from employee where id = " + id + ";");
				
			}
	    
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		return "Delete successful";
		
    }
}