package com.example.demo.controllers;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.beans.*;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin (origins = "*")
@Controller
public class EmployeeUpdate {
	@RequestMapping(method = RequestMethod.PUT, value="api/employees/{ChangeId}")
	
	@ResponseBody
	public String deleteEmployee(@PathVariable("ChangeId") String ChangeId,@RequestBody Employee emp){
		
		String name = emp.getName();
		String Eid = ChangeId;
		String mail = emp.getEmailid();
		String Designation = emp.getDesignation();
    	Connection conn = null;
		try {
			String dbURL = "jdbc:sqlserver://CYG362;databaseName=Eclipse";
			String user = "sa";
			conn = DriverManager.getConnection(dbURL, user, "Password@123" );
			if(conn != null ) {

			    System.out.println("Connection Successful******************************");
			    
				Statement stmt = conn.createStatement();
				stmt.executeQuery("Update employee Set Emailid = '" + mail + "' , name = '" + name +  "' Set Designation = '" + Designation + "' where Eid = '" + Eid + "'");
				
			}
	    
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		return "Update successful";
		
    }
}