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
			String dbURL = "jdbc:sqlserver://CYG297;database=javaweek3";
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
			String dbURL = "jdbc:sqlserver://CYG297;database=javaweek3";
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
			String dbURL = "jdbc:sqlserver://CYG297;database=javaweek3";
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
			String dbURL = "jdbc:sqlserver://CYG297;database=javaweek3";
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
			String dbURL = "jdbc:sqlserver://CYG297;database=javaweek3";
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
	public List<Users> showOneEmployee(@PathVariable String name){
		Connection con;
		List<Users> usersList = new ArrayList<Users>();
		ResultSet rs = null;
		try {
			String dbURL = "jdbc:sqlserver://CYG297;database=javaweek3";
			String user = "sa";
			con = DriverManager.getConnection(dbURL, user, "abcd");
			if(con != null) {
				Statement stmt = con.createStatement();
				String query5 = "select * from Users where Name= '"+name+"'";
				rs=stmt.executeQuery(query5);
				while(rs.next())
				{
					usersList.add(new Users(rs.getInt("ID"),rs.getString("Name"),rs.getString("Password"))); 
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
	public String addEmployee(@RequestBody Users Users) {
		
		Connection con;
		try {
			String dbURL = "jdbc:sqlserver://CYG297;database=javaweek3";
			String userdata = "sa";
			con = DriverManager.getConnection(dbURL, userdata, "abcd");
			if(con != null) {
				Statement stmt = con.createStatement();
				String query = "insert into Users values('"+Users.getName()+"','"+Users.getPassword()+"')";
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
	public void updatePassword(@RequestBody Users Users, @PathVariable String id) {
		
		Connection con;
		try {
			String dbURL = "jdbc:sqlserver://CYG297;database=javaweek3";
			String userdata = "sa";
			con = DriverManager.getConnection(dbURL, userdata, "abcd");
			if(con != null) {
				Statement stmt = con.createStatement();
				String query = "update Users set Password = '"+Users.getPassword()+"' where Name = "+id;
				stmt.execute(query);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
}
