package com.example.demo.controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.Designation;


@CrossOrigin
@Controller
public class DesignationController {
	@RequestMapping(method = RequestMethod.DELETE, value="/Designations/{id}")
	@ResponseBody
	public void DeleteDes(@RequestBody @PathVariable("id") String id) {
		Connection con;
			try {
				String dbURL = "jdbc:sqlserver://CYG236\\SQLEXPRESS;database=Corporate";
				String user = "sa";
				con = DriverManager.getConnection(dbURL, user, "password");
				if(con != null) {
					Statement stmt = con.createStatement();
					String query = "delete from Designation where Id='"+id+"';";
					stmt.execute(query);
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
	}
	@RequestMapping(method = RequestMethod.POST, value="/Designations")
	@ResponseBody
	public void AddDes(@RequestBody Designation des) {
		Connection con;
			try {
				String dbURL = "jdbc:sqlserver://CYG236\\SQLEXPRESS;database=Corporate";
				String user = "sa";
				con = DriverManager.getConnection(dbURL, user, "password");
				if(con != null) {
					Statement stmt = con.createStatement();
					String query = "insert into Designation values('"+des.getId()+"','"+des.getName()+"')";
					stmt.execute(query);
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
				
	
	}
	@RequestMapping(method = RequestMethod.PUT, value="/Designations/{id}")
	@ResponseBody
	public void UpdateDes(@RequestBody Designation des,@PathVariable("id") String id) {
		Connection con;
			try {
				String dbURL = "jdbc:sqlserver://CYG236\\SQLEXPRESS;database=Corporate";
				String user = "sa";
				con = DriverManager.getConnection(dbURL, user, "password");
				if(con != null) {
					Statement stmt = con.createStatement();
					String query = "update Designation set Name = '"+des.getName()+"'where Id ='"+ id+"';";
					stmt.execute(query);
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
	}
	@RequestMapping(method= RequestMethod.GET, value="/Designations")
	@ResponseBody
	public List<Designation> getdesignations(){
		Connection con;
		List<Designation> DesignationList= new ArrayList<Designation>();
		ResultSet rs = null;
			try {
				String dbURL = "jdbc:sqlserver://CYG236\\SQLEXPRESS;database=Corporate";
				String user = "sa";
				con = DriverManager.getConnection(dbURL, user, "password");
				if(con != null) {
					Statement stmt = con.createStatement();
					String query5 = "select * from Designation";
					rs=stmt.executeQuery(query5);
					while(rs.next())
					{
						DesignationList.add(new Designation(rs.getInt("Id"),rs.getString("Name"))); 
					}
					return DesignationList;
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			return DesignationList;
		}
		
	@RequestMapping(method= RequestMethod.GET, value="/Designations/{id}")
	@ResponseBody
	public Designation getDepartmentById(@PathVariable("id") String id){
		Connection con;
		List<Designation> DesignationList= new ArrayList<Designation>();
		ResultSet rs = null;
			try {
				String dbURL = "jdbc:sqlserver://CYG236\\SQLEXPRESS;database=Corporate";
				String user = "sa";
				con = DriverManager.getConnection(dbURL, user, "password");
				if(con != null) {
					Statement stmt = con.createStatement();
					String query5 = "select * from Designation";
					rs=stmt.executeQuery(query5);
					while(rs.next())
					{
						DesignationList.add(new Designation(rs.getInt("Id"),rs.getString("Name"))); 
					}
					
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			return DesignationList.get(0);
	}

}
