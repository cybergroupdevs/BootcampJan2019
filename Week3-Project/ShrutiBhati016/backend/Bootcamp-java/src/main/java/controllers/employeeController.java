package controllers;

import java.beans.Statement;
import java.sql.Connection;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.*;

import employee.CreateEmployee;
import jdbc.JdbcCheck;

public class employeeController {
	  @RequestMapping(method = RequestMethod.GET, value="/Employee")
	  @ResponseBody
	  public CreateEmployee getAllEmployees() {
	  	   
		  CreateEmployee emp = new CreateEmployee();
			
			Connection conn = null;
			try {
				conn = JdbcCheck.getConnection();
				if(conn != null ) {
					Statement stmt = (Statement) conn.createStatement();
					String SQL = "EXEC ListOfEmployees;";
					ResultSet rs = ((java.sql.Statement) stmt).executeQuery(SQL);
					while(rs.next()) {
						emp.setId(rs.getInt("Id"));
						emp.setFirstName(rs.getString("FirstName"));
						emp.setLastName(rs.getString("LastName"));
						emp.setAge(rs.getInt("Age"));
						emp.setEmail(rs.getString("Email"));
						emp.setDesignation(rs.getString("Designation"));
						emp.setPhone(rs.getString("Phone"));
						
					}

					System.out.println("done");
				}
			}
			catch(SQLException ex) {
				ex.printStackTrace();
			}

			return emp;  
	  
	  }
	}
