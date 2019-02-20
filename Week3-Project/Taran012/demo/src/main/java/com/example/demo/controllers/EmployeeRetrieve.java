package com.example.demo.controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.demo.Employee;
//import com.example.demo.EmployeeRegistration;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin (origins = "*")

@Controller

public class EmployeeRetrieve {
  @RequestMapping(method = RequestMethod.GET, value="api/employees")
  @ResponseBody
//  public List<Employee> getAllEmployee() {
//	  return EmployeeRegistration.getInstance().getEmployeeRecords();
//
//  }



	public List<Employee> getEmployeeRecords() {
		
	  	List<Employee> empRecords = new ArrayList<Employee>();
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
					empRecords.add(emp);
					System.out.println(rs.getInt("id") + "," + rs.getString("name")+ "," + rs.getInt("DesignationId") );
				}
				System.out.println("done with get");
			}
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		return empRecords;
	  }
}