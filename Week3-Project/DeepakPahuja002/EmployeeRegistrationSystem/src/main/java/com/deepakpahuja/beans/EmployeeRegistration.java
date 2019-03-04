package com.deepakpahuja.beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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
    public boolean add(Employee emp) {
//    employeeRecords.add(emp);
    	
    	Connection con=null;
    	try {
    	String url="jdbc:sqlserver://CYG291;database=EmployeeManagementSystem";
    	String user="sa";
    	con = DriverManager.getConnection(url, user, "deepak");
    	if(con != null) {
    		Statement stmt = con.createStatement();
    		String qry1="Insert Into Employees VALUES('"+ emp.getEmployeeId()+"','" + emp.getName() +
    		 "','" + emp.getDesignation() +"','"+ emp.getPhoneNo() + "',"+ emp.getSignUpId() + ");";
    	   
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
	public String upDateStudent(Employee emp) {
		Connection con=null;
		try {
			String url="jdbc:sqlserver://CYG291;database=EmployeeManagementSystem";
	    	String user="sa";
	    	con = DriverManager.getConnection(url, user, "deepak");
    		System.out.println("Outside");

	    	if(con!=null) {
	    		System.out.println("In update student");
	    		Statement stmt = con.createStatement();
	    		String qry1 = "UPDATE Employees "
	    				+ "SET EmployeeId = '" + emp.getEmployeeId() + "'"
	    				+ ", Name = '" + emp.getName() + "'"
	    				+ ", Designation = '" + emp.getDesignation() + "'"
	    				+ ", PhoneNo = '" + emp.getPhoneNo() + "'"
	    				+ ", SignUpId = '" + emp.getSignUpId() + "'"
	    				+ " WHERE EmployeeId= '" + emp.getEmployeeId() + "'";
	    		System.out.println(emp.getEmployeeId());
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
//	for(int i=0; i<employeeRecords.size(); i++)
//	        {
//	            Employee empn = employeeRecords.get(i);
//	            if(empn.getEmployeeId().equals(emp.getEmployeeId())) {
//	            	employeeRecords.set(i, emp);//update the new record
//	              return "Update successful";
//	            }
//	        }
	}
	public String deleteStudent(String EmployeeId) {
			Connection con = null;
			try {
				String url="jdbc:sqlserver://CYG291;database=EmployeeManagementSystem";
		    	String user="sa";
		    	con = DriverManager.getConnection(url, user, "deepak");
		    	if(con!= null) {
		    		Statement stmt = con.createStatement();
		    		String qry1 = "DELETE FROM Employees "
		    				+ "WHERE EmployeeId = '" + EmployeeId + "'";
		    		stmt.execute(qry1);
		    		return "true";
		    	}
			}
	    	catch(Exception e) {
	    		e.printStackTrace();
	    	}
	
			return "Delete un-successful";

		
//	for(int i=0; i<employeeRecords.size(); i++)
//	        {
//	            Employee stdn = employeeRecords.get(i);
//	            if(stdn.getEmployeeId().equals(EmployeeId)){
//	            	employeeRecords.remove(i);//update the new record
//	              return "Delete successful";
//	            }
//	        }
	}
    public List<Employee> getStudentRecords() {
    	List<Employee> employeeList = new ArrayList<Employee>();
    	Connection con=null;
    	try {
    	String url="jdbc:sqlserver://CYG291;database=EmployeeManagementSystem";
    	String user="sa";
    	con = DriverManager.getConnection(url, user, "deepak");
    	if(con != null) {
    		Statement stmt = con.createStatement();
    		String qry1="select * from Employees";
    		ResultSet rs = stmt.executeQuery(qry1);
    		while(rs.next())
    		{	
    			employeeList.add(new Employee(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5)));
    		}
    	   }
    	
    	}
    catch(Exception e) {
    	e.printStackTrace();
    }	
    return employeeList;
    }
	
}
