package controllers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import employee.CreateEmployee;
import jdbc.JdbcCheck;

import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin(origins = "*")
@Controller
public class employeeRetrieveController {
  @RequestMapping(method = RequestMethod.GET, value="/Employee/EmployeeAll")
  @ResponseBody
  public List<CreateEmployee> getAllEmployees() {
  
  
	   List<CreateEmployee> empList= new ArrayList<CreateEmployee>();
	  
		Connection conn = null;
		try {
			conn = JdbcCheck.getConnection();
			if(conn != null ) {
				Statement stmt = conn.createStatement();
				String SQL = "SELECT * from Employees";
				ResultSet rs = stmt.executeQuery(SQL);
				while(rs.next()) {
					CreateEmployee emp = new CreateEmployee();
					emp.setId(rs.getInt("Id"));
					emp.setFirstName(rs.getString("FirstName"));
					emp.setLastName(rs.getString("LastName"));
					emp.setAge(rs.getInt("Age"));
					emp.setEmail(rs.getString("Email"));
					emp.setDesignation(rs.getString("Designation"));
					emp.setPhone(rs.getString("Phone"));
					
					empList.add(emp);
				}

				System.out.println("done");
			}
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}

		return empList;
  
  
  
  }
}
