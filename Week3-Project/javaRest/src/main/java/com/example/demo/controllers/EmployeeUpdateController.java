package com.example.demo.controllers;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.demo.beans.Employee;
import com.example.demo.beans.EmployeeRegistration;
import com.example.demo.myPack.JdbcCheck;
import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin(origins = "*")
@Controller
public class EmployeeUpdateController {
@RequestMapping(method = RequestMethod.PUT, value="/update/Employee/{regdNum}")
@ResponseBody
public void updateEmployeeRecord(@PathVariable("regdNum") String regdNum, @RequestBody Employee emp ) {
System.out.println("In updateEmployeeRecord");   
    

Connection conn = null;
try {
	conn = JdbcCheck.getConnection();
	if(conn != null ) {
		Statement stmt = conn.createStatement();
		//stmt.execute("Drop table PersonsTest ");
		//stmt.execute("Create table PersonsTest (id int, name varchar(20), age int); ");	
		String SQL = "update Employees "
				+"set Name= '"+emp.getName()
				+"',Age="+emp.getAge()
				+",Gender='"+emp.getGender()
				+"',DesignationId="+emp.getDesignationId()+"where Id="+regdNum+";";
		
		stmt.executeQuery(SQL);
		System.out.println("done");
	}
}
catch(SQLException ex) {
	ex.printStackTrace();
}



}
}