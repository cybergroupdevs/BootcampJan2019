package com.example.controllers;

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

import com.example.calls.Project;
@CrossOrigin
@Controller
public class Projectcontroller {
	@RequestMapping(method = RequestMethod.DELETE, value="/Project/{id}")
	@ResponseBody
	public void DeleteDep(@RequestBody @PathVariable("id")  String id) {
		Connection con;
			try {
				String dbURL = "jdbc:sqlserver://CYG188;database=JavaProject";
				String user = "sa";
				con = DriverManager.getConnection(dbURL, user, "password");
				if(con != null) {
					Statement stmt = con.createStatement();
					String query = "delete from Project where ID="+id;
					stmt.execute(query);
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
	}
	@RequestMapping(method = RequestMethod.POST, value="/Project")
	@ResponseBody
	public void AddDep(@RequestBody Project lc) {
		Connection con;
			try {
				String dbURL = "jdbc:sqlserver://CYG188;database=JavaProject";
				String user = "sa";
				con = DriverManager.getConnection(dbURL, user, "password");
				if(con != null) {
					Statement stmt = con.createStatement();
					String query = "insert into Project values('"+lc.getID()+"','"+lc.getName()+"','"+lc.getUser_ID();
					stmt.execute(query);
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
				
	
	}
	@RequestMapping(method = RequestMethod.PUT, value="/Project/{id}")
	@ResponseBody
	public void UpdateDep(@RequestBody Project lc,@PathVariable("id") String id) {
		Connection con;
			try {
				String dbURL = "jdbc:sqlserver://CYG188;database=JavaProject";
				String user = "sa";
				con = DriverManager.getConnection(dbURL, user, "password");
				if(con != null) {
					Statement stmt = con.createStatement();
					String query = "update Project set Code='"+lc.getID()+"', Name = '"+lc.getName()+"', User_ID = '"+lc.getUser_ID();
					stmt.execute(query);
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
	}
	@RequestMapping(method= RequestMethod.GET, value="/Project")
	@ResponseBody
	public List<Project> getlogincredentials(){
		Connection con;
		List<Project> ProjectList= new ArrayList<Project>();
		ResultSet rs = null;
			try {
				String dbURL = "jdbc:sqlserver://CYG188;database=JavaProject";
				String user = "sa";
				con = DriverManager.getConnection(dbURL, user, "password");
				if(con != null) {
					Statement stmt = con.createStatement();
					String query5 = "select * from Project";
					rs=stmt.executeQuery(query5);
					while(rs.next())
					{
						ProjectList.add(new Project(rs.getInt("ID"),rs.getString("Name"),rs.getInt("User_ID"))); 
					}
					return ProjectList;
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			return ProjectList;
		}
		
	@RequestMapping(method= RequestMethod.GET, value="/Project/{id}")
	@ResponseBody
	public Project getProjectById(@PathVariable("id") String id){
		Connection con;
		List<Project> Projectlist= new ArrayList<Project>();
		Project emp= new Project();
		ResultSet rs = null;
		try {
			String dbURL = "jdbc:sqlserver://CYG188;database=JavaProject";
			String user = "sa";
			con = DriverManager.getConnection(dbURL, user, "password");
			if(con != null) {
				Statement stmt = con.createStatement();
				String query5 = "select * from Project where ID="+id;
				rs=stmt.executeQuery(query5);
				while(rs.next())
				{
					emp.setID(rs.getInt("ID"));
					emp.setName(rs.getString("Name"));
					emp.setUser_ID(rs.getInt("User_ID"));
					Projectlist.add(emp);
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return Projectlist.get(0);
	}


}
