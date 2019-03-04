package com.example.demo.controllers;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.demo.beans.EmployeeRegistration;
import com.example.demo.myPack.JdbcCheck;
import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin(origins = "*")
@Controller
public class EmployeeDeleteController {
@RequestMapping(method = RequestMethod.DELETE, value="/delete/Employee/{regdNum}")
@ResponseBody
public void deleteEmployeeRecord(@PathVariable("regdNum") String regdNum) {
System.out.println("In deleteEmployeeRecord");   
Connection conn = null;
try {
	conn = JdbcCheck.getConnection();
	if(conn != null ) {
		Statement stmt = conn.createStatement();
		//stmt.execute("Drop table PersonsTest ");
		//stmt.execute("Create table PersonsTest (id int, name varchar(20), age int); ");
		String SQL = "delete from Employees where Id="+regdNum+";";
		System.out.println("done");
	}
}
catch(SQLException ex) {
	ex.printStackTrace();
}
}
}