package com.example.demo.controllers;
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
import com.example.demo.beans.*;
import com.example.demo.myPack.*;
import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin(origins = "*")
@Controller
public class EmployeeRetrieveController {
  @RequestMapping(method = RequestMethod.GET, value="/Employee/EmployeeAll")
  @ResponseBody
  public List<Employee> getAllEmployees() {
  
  
	   List<Employee> empList= new ArrayList<Employee>();
	  
		Connection conn = null;
		try {
			conn = JdbcCheck.getConnection();
			if(conn != null ) {
				Statement stmt = conn.createStatement();
				//stmt.execute("Drop table PersonsTest ");
				//stmt.execute("Create table PersonsTest (id int, name varchar(20), age int); ");
				String SQL = "SELECT * from Employees";
				ResultSet rs = stmt.executeQuery(SQL);
				while(rs.next()) {
					Employee emp = new Employee();
					emp.setId(rs.getInt("Id"));
					emp.setName(rs.getString("Name"));
					emp.setAge(rs.getInt("Age"));
					emp.setGender(rs.getString("Gender"));
					emp.setDesignationId(rs.getInt("DesignationId"));
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