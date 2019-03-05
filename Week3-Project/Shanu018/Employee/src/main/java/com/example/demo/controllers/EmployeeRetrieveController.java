package com.example.demo.controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.beans.Employee;


@Controller
public class EmployeeRetrieveController {
	
	 @CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(method = RequestMethod.GET,value="/employee" )
	 
	 
	@ResponseBody
//	public List<Employee> getAllEmployee() {
//		System.out.println("service hit");
//		return EmployeeRegistration.getInstance().getEmployeeRecords();
//		
//	}
//	
//	@RequestMapping(method = RequestMethod.GET, value = "/demo")
//	@ResponseBody
//	public String demo() {
//		System.out.println("service hit");
//		return "service hit";
//	}
	
public List<Employee> getEmployeeRecords() {
		
	  	List<Employee> empRecords = new ArrayList<Employee>();
		Connection conn = null;
		try {
			String dbURL = "jdbc:sqlserver://CYG362;databaseName=Eclipse";
			String user = "sa";
				
			conn = DriverManager.getConnection(dbURL, user, "Password@123" );
			if(conn != null ) {
	
			    System.out.println("Connection Successful******************************");
				Statement stmt = conn.createStatement();
				ResultSet rs  = stmt.executeQuery("SELECT * from Employee;");
				
				while(rs.next()) {	
					Employee emp = new Employee();
					emp.setName(rs.getString("Name"));
					emp.setFathersName(rs.getString("FathersName"));
					emp.setEid(rs.getString("Eid"));
					emp.setDob(rs.getString("Dob"));
					emp.setMob(rs.getInt("Mobile"));
					emp.setEmailid(rs.getString("Emailid"));
					emp.setAddress(rs.getString("Address"));
					emp.setCity(rs.getString("City"));
					emp.setState(rs.getString("State"));
					emp.setDesignation(rs.getString("Designation"));
					emp.setSupervisor(rs.getString("Supervisor"));
					emp.setGender(rs.getString("Gender"));
					emp.setPassword(rs.getString("Password"));
				
				
					
					empRecords.add(emp);
					System.out.println(rs.getString("Eid") + "," + rs.getString("Name")+ "," + rs.getInt("Mobile") );
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
