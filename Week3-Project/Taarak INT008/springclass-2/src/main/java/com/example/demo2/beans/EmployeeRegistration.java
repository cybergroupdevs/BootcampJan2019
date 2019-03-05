package com.example.demo2.beans;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRegistration {
	 private List<Employee> EmployeeRecords;
	    private static EmployeeRegistration stdregd = null;
	    private EmployeeRegistration(){
	    EmployeeRecords = new ArrayList<Employee>();
	    }
	    public static EmployeeRegistration getInstance() {
	        if(stdregd == null) {
	              stdregd = new EmployeeRegistration();
	              return stdregd;
	            }
	            else {
	                return stdregd;
	            }
	    }
	    public boolean add(Employee std) {
	   
	    Connection con=null;
    	try {
    	String url= "jdbc:sqlserver://CYG175\\SQLEXPRESS;database=week3java";
    	String user="sa";
    	con = DriverManager.getConnection(url, user, "leave12345");
    	if(con != null) {
    		Statement stmt = con.createStatement();
    		String qry1="Insert Into Employee VALUES('" + std.getName() +"','"+ std.getPassword() + "')";
    		return stmt.execute(qry1);
    		
    	}
    	else
    	{
    		return false;
    	}
    }
    catch(Exception e) {
    	e.printStackTrace();
    	return false;
    }	
    }
	    
	    
	public String updateEmployee(Employee std) {
		Connection con=null;
		try {
			String url="jdbc:sqlserver://CYG175\\SQLEXPRESS;database=week3java";
	    	String user="sa";
	    	con = DriverManager.getConnection(url, user, "leave12345");
    		System.out.println("Outside");

	    	if(con!=null) {
	    		System.out.println("In update student");
	    		Statement stmt = con.createStatement();
	    		String qry1 = "UPDATE Employee "
	    				+ "SET name = '" + std.getName() + "'"
	    				+ ", password = '" + std.getPassword() + "'"
	    				+ " WHERE id= " + std.getId() + "";
	    		System.out.println(std.getId());
	    		System.out.println("Below update student");

	 		    stmt.executeUpdate(qry1);
	    		System.out.println("Below update student");

	    		return "Update successful";


	    	}
	    	
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return "Update un-successful";

	}
	public String deleteEmployee(int id) {
		Connection con = null;
		try {
			String url="jdbc:sqlserver://CYG175\\SQLEXPRESS;database=week3java";
	    	String user="sa";
	    	con = DriverManager.getConnection(url, user, "leave12345");
	    	if(con!= null) {
	    		Statement stmt = con.createStatement();
	    		String qry1 = "DELETE FROM Employee "
	    				+ "WHERE id = " + id + "";
	    		stmt.execute(qry1);
	    		return "true";
	    	}
		}
    	catch(Exception e) {
    		e.printStackTrace();
    	}

		return "Delete un-successful";
	}
	
	public List<Employee> getEmployeeRecords() {
    	List<Employee> employeeList = new ArrayList<Employee>();
    	Connection con=null;
    	try {
    	String url="jdbc:sqlserver://CYG175\\SQLEXPRESS;database=week3java";
    	String user="sa";
    	con = DriverManager.getConnection(url, user, "leave12345");
    	if(con != null) {
    		Statement stmt = con.createStatement();
    		String qry1="select * from Employee";
    		ResultSet rs = stmt.executeQuery(qry1);
    		while(rs.next())
    		{	
    			employeeList.add(new Employee(rs.getString(2),rs.getInt(1),rs.getString(3)));
    		}
    	   }
    	
    	}
    catch(Exception e) {
    	e.printStackTrace();
    }	
    return employeeList;
    }
	}