package com.example.demo.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.*;

@RestController
public class Usercontroller {
	
	@GetMapping("/project")
	public List<User> allProjects(){
		Connection con;
		List<User> usersList = new ArrayList<User>();
		ResultSet rs = null;
		try {
			String dbURL = "jdbc:sqlserver:DESKTOP-OHFBEH1//;database=EmployeeManagement";
			String user = "sa";
			con = DriverManager.getConnection(dbURL, user, "abcd");
			if(con != null) {
				Statement stmt = con.createStatement();
				String query5 = "select * from Project";
				rs=stmt.executeQuery(query5);
				while(rs.next())
				{
					usersList.add(new User(rs.getInt("ID"),rs.getString("Name"),rs.getString("EmployeeId"))); 
				}
				return usersList;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return usersList;
	}
	
	@GetMapping("/project/{Id}")
	public List<User> showOne(@PathVariable String Id){
		Connection con;
		List<User> usersList = new ArrayList<User>();
		ResultSet rs = null;
		try {
			String dbURL = "jdbc:sqlserver://DESKTOP-OHFBEH1;database=EmployeeManagement";
			String user = "sa";
			con = DriverManager.getConnection(dbURL, user, "abcd");
			if(con != null) {
				Statement stmt = con.createStatement();
				String query5 = "select * from Project where EmployeeId="+Id;
				rs=stmt.executeQuery(query5);
				while(rs.next())
				{
					usersList.add(new User(rs.getInt("ID"),rs.getString("Name"),rs.getString("EmployeeId"))); 
				}
				return usersList;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return usersList;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/project")
	public void addProject(@RequestBody User user) {
		
		Connection con;
		try {
			String dbURL = "jdbc:sqlserver://DESKTOP-OHFBEH1;database=";
			String userdata = "sa";
			con = DriverManager.getConnection(dbURL, userdata, "abcd");
			if(con != null) {
				Statement stmt = con.createStatement();
				String query = "insert into Project values('"+user.getName()+"','"+user.getEmpId()+"')";
				stmt.execute(query);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/project/{id}")
	public void updateProject(@RequestBody User user, @PathVariable String id) {
		
		Connection con;
		try {
			String dbURL = "jdbc:sqlserver://DESKTOP-OHFBEH1;database=EmployeeManagement";
			String userdata = "sa";
			con = DriverManager.getConnection(dbURL, userdata, "abcd");
			if(con != null) {
				Statement stmt = con.createStatement();
				String query = "update Project set Name = '"+user.getName()+"' where ID = "+id;
				//update Project set name = 'project' where ID = 3;
				stmt.execute(query);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/project/{id}")
	public void deleteProject(@PathVariable String id) {
		
		Connection con;
		try {
			String dbURL = "jdbc:sqlserver://DESKTOP-OHFBEH1;database=EmployeeManagement";
			String userdata = "sa";
			con = DriverManager.getConnection(dbURL, userdata, "abcd");
			if(con != null) {
				Statement stmt = con.createStatement();
				String query = "delete from Project where Id = "+ id;
				stmt.execute(query);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@GetMapping("/employee/{name}")
	public List<EmployeeRecord> showOneEmployee(@PathVariable String name){
		Connection con;
		List<EmployeeRecord> usersList = new ArrayList<EmployeeRecord>();
		ResultSet rs = null;
		try {
			String dbURL = "jdbc:sqlserver://DESKTOP-OHFBEH1;database=EmployeeManagement";
			String user = "sa";
			con = DriverManager.getConnection(dbURL, user, "abcd");
			if(con != null) {
				Statement stmt = con.createStatement();
				String query5 = "select * from EmployeeRecord where Name= '"+name+"'";
				rs=stmt.executeQuery(query5);
				while(rs.next())
				{
					usersList.add(new EmployeeRecord(rs.getInt("ID"),rs.getString("Name"),rs.getString("Password"))); 
				}
				return usersList;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return usersList;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/employee")
	public String addEmployee(@RequestBody EmployeeRecord EmployeeRecord) {
		
		Connection con;
		try {
			String dbURL = "jdbc:sqlserver://DESKTOP-OHFBEH1;database=EmployeeManagement";
			String userdata = "sa";
			con = DriverManager.getConnection(dbURL, userdata, "abcd");
			if(con != null) {
				Statement stmt = con.createStatement();
				String query = "insert into EmployeeRecord values('"+EmployeeRecord.getName()+"','"+EmployeeRecord.getPassword()+"')";
				stmt.execute(query);
				return "success";
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return "success";
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/employee/{id}")
	public void updatePassword(@RequestBody EmployeeRecord, @PathVariable String id) {
		
		Connection con;
		try {
			String dbURL = "jdbc:sqlserver://DESKTOP-OHFBEH1;database=EmployeeManagement";
			String userdata = "sa";
			con = DriverManager.getConnection(dbURL, userdata, "abcd");
			if(con != null) {
				Statement stmt = con.createStatement();
				String query = "update EmployeeRecord set Password = '"+EmployeeRecord.getPassword()+"' where Name = "+id;
				stmt.execute(query);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
}
