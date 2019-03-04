//package com.example.demo.controllers;
//
//public class EmployeeDelete {
//	
//	
//
//}

package com.example.demo.controllers;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin (origins = "*")

@Controller
public class EmployeeDelete {
	@RequestMapping(method = RequestMethod.DELETE, value="api/employees/{eid}")
	@ResponseBody
	public String deleteEmployee(@PathVariable("eid") String Eid){
    	Connection conn = null;
		try {
			
			String dbURL = "jdbc:sqlserver://CYG362;databaseName=Eclipse";
			String user = "sa";
			conn = DriverManager.getConnection(dbURL, user, "Password@123" );
			if(conn != null ) {

			    System.out.println("Connection Successful******************************");
				Statement stmt = conn.createStatement();
			
				stmt.execute("Delete from employee where eid = '" + Eid + "';");
				System.out.println("Delete from employee where eid = " + Eid + ";");

			    System.out.println("Deletion Successful******************************");
			}
	    // There is no status variable, So even if there is no corr entry It will return successful
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		return "Delete successful";
    }
}
