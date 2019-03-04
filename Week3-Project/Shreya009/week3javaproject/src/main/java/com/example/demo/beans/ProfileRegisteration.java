package com.example.demo.beans;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.beans.*;

public class ProfileRegisteration {
	private List<Profile> profileRecords;
    private static ProfileRegisteration empregd = null;
    private ProfileRegisteration(){
    	profileRecords = new ArrayList<Profile>();
    }
    public static ProfileRegisteration getInstance() {
        if(empregd == null) {
        	empregd = new ProfileRegisteration();
              return empregd;
            }
            else {
                return empregd;
            }
    }
    public boolean add(Profile emp) {
//    employeeRecords.add(emp);
    	
    	Connection con=null;
    	try {
    		String url="jdbc:sqlserver://CYG385;database=p";
	    	String user="sa";
	    	con = DriverManager.getConnection(url, user, "password");
    	if(con != null) {
    		Statement stmt = con.createStatement();
    		String qry1="";
    	   
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
	public String upDateStudent(Profile pro) {
		Connection con=null;
		try {
			String url="jdbc:sqlserver://CYG385;database=p";
	    	String user="sa";
	    	con = DriverManager.getConnection(url, user, "password");
    		System.out.println("Outside");

	    	if(con!=null) {
	    		Statement stmt = con.createStatement();
	    		String qry1 = "UPDATE Profile "
	    				+ "SET Designation = '" + pro.getDesignation() + "'"
	    				+ ", Qualification = '" + pro.getQualification() + "'"
	    				+ ", Experience = '" + pro.getExperience() + "'";

	 		    stmt.executeUpdate(qry1);

	    		return "Update successful";
	    	}
	    	
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return "Update un-successful";
	}
	public String deleteStudent(String ProfileId) {
			Connection con = null;
			try {
		    	if(con!= null) {
		    		Statement stmt = con.createStatement();
		    		String qry1 = "DELETE FROM Profile "
		    				+ "WHERE ID = " + ProfileId + "";
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
    public List<Profile> getStudentRecords() {
    	List<Profile> employeeList = new ArrayList<Profile>();
    	Connection con=null;
    	try {
    		String url="jdbc:sqlserver://CYG385;database=p";
	    	String user="sa";
	    	con = DriverManager.getConnection(url, user, "password");
    	if(con != null) {
    		Statement stmt = con.createStatement();
    		String qry1="select * from Employees";
    		ResultSet rs = stmt.executeQuery(qry1);
    		while(rs.next())
    		{	
    			employeeList.add(new Profile(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4)));
    		}
    	   }
    	
    	}
    catch(Exception e) {
    	e.printStackTrace();
    }	
    return employeeList;
    }
	
}