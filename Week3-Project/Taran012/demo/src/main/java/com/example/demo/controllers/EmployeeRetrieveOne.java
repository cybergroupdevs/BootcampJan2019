package com.example.demo.controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.demo.Employee;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin (origins = "*")

@Controller

public class EmployeeRetrieveOne {
	@RequestMapping(method = RequestMethod.GET, value="api/employees/{getid}")
	@ResponseBody
	public Employee getEmployeeRecords(@PathVariable("getid") int getid) {

		Employee emp = new Employee();
		Connection conn = null;
		try {
			String dbURL = "jdbc:sqlserver://DESKTOP-NP793MF; databaseName = CorporateLedger";
			String user = "sa";
			conn = DriverManager.getConnection(dbURL, user, "P@ssw0rd" );
			if(conn != null ) {
	
			    System.out.println("Connection Successful******************************");
				Statement stmt = conn.createStatement();
				ResultSet rs  = stmt.executeQuery("SELECT * from employee where id = " + getid + ";");
				
				while(rs.next()) {
					emp.setId(rs.getInt("id"));
					emp.setDesignationID(rs.getInt("DesignationId"));
					emp.setMail(rs.getString("mail"));
					emp.setName(rs.getString("name"));
				}
			}
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		return emp;
	  }
}