package com.example.demo.controllers;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.Employee;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin (origins = "*")
@Controller
public class EmployeeUpdate {
	@RequestMapping(method = RequestMethod.PUT, value="api/employees/{ChangeId}")
	
	@ResponseBody
	public String deleteEmployee(@PathVariable("ChangeId") int ChangeId,@RequestBody Employee emp){
		
		String name = emp.getName();
		int id = ChangeId;
		String mail = emp.getMail();
		int DesignationId = emp.getDesignationID();
    	Connection conn = null;
		try {
			
			String dbURL = "jdbc:sqlserver://DESKTOP-NP793MF; databaseName = CorporateLedger";
			String user = "sa";
			conn = DriverManager.getConnection(dbURL, user, "P@ssw0rd" );
			if(conn != null ) {

			    System.out.println("Connection Successful******************************");
			    
				Statement stmt = conn.createStatement();
				stmt.executeQuery("Update employee where id = " + id + " Set mail = \'" + mail + "\' , name = \' " + name + "\' , designationID = " + DesignationId + ";");
				
			}
	    
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		return "Update successful";
		
    }
}