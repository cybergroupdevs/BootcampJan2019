package com.example.demo.controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.demo.Employee;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin (origins = "*")

@Controller
public class EmployeeAdd{
	  @RequestMapping(method = RequestMethod.POST, value="api/employees")
	  @ResponseBody

	  public Employee addEmployee(@RequestBody Employee emp) {
		  
		Employee emp1 = new Employee();
		Connection conn = null;
		try {
			String name = emp.getName();
//			int id = emp.getId();
			String mail = emp.getMail();
			int DesignationId = emp.getDesignationID();
//			String dbURL = "jdbc:sqlserver://DESKTOP-NP793MF; databaseName = Database1";
			String dbURL = "jdbc:sqlserver://DESKTOP-NP793MF; databaseName = CorporateLedger";
			String user = "sa";
			conn = DriverManager.getConnection(dbURL, user, "P@ssw0rd" );
			if(conn != null ) {

			    System.out.println("Connection Successful******************************");
			    
				Statement stmt = conn.createStatement();
				
			    stmt.execute("Insert into employee values( \'" + mail +"\' ," + " \'"+ name +"\' ," + DesignationId + ");");
			    System.out.println("Done******************************");
			    ResultSet rs  = stmt.executeQuery("SELECT * from employee where name = \'" + name + "\' ;");
			    
			    emp1.setId(rs.getInt("id"));
				emp1.setDesignationID(rs.getInt("DesignationId"));
				emp1.setMail(rs.getString("mail"));
				emp1.setName(rs.getString("name"));
			}
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		return emp;
  }

}