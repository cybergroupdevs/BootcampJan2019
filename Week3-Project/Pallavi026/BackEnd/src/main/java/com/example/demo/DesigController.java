package com.example.demo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import week3.Designation;

@RestController
public class DesigController {
	//GetApi for All Users
	@GetMapping("/Designation")
	public List<Designation> index2(){
		Connection con;
		List<Designation> Designation = new ArrayList<Designation>();
		ResultSet rs = null;
		try {
			String dbURL = "jdbc:sqlserver://CYG255;database=week3";
			String userdata = "sa";
			con = DriverManager.getConnection(dbURL, userdata, "cyber9198");
			if(con != null) {
				Statement stmt = con.createStatement();
				String queryforallusers = "select * from Designation";
				rs=stmt.executeQuery(queryforallusers);
				while(rs.next())
				{
					Designation.add(new Designation(rs.getString("ID"),rs.getString("Name")
						)); 
				}
				return Designation;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}	
		return Designation;
	}

	//GetApi for Single User Details
	@GetMapping("/Designation/{ID}")
	public List<Designation> index3(@PathVariable String ID){
		Connection con;
		List<Designation> Designation = new ArrayList<Designation>();
		ResultSet rs = null;
		try {
			String dbURL = "jdbc:sqlserver://CYG255;database=week3";
			String userdata = "sa";
			con = DriverManager.getConnection(dbURL, userdata, "cyber9198");
			if(con != null) {
				Statement stmt = con.createStatement();
				String queryforoneuser = "select * from Designation where ID="+ID;
				rs=stmt.executeQuery(queryforoneuser);
				while(rs.next())
				{
					Designation.add(new Designation(rs.getString("ID"),rs.getString("Name")
							)); 
				}
				return Designation;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}	
		return Designation;
	}
	
	//DeleteApi for Designation
	@RequestMapping(method=RequestMethod.DELETE, value="/Designation/{ID}")
	public void deleteEmployee(@PathVariable String ID) {
		
		Connection con;
		try {
			String dbURL = "jdbc:sqlserver://CYG255;database=week3";
			String userdata = "sa";
			con = DriverManager.getConnection(dbURL, userdata, "cyber9198");
			if(con != null) {
				Statement stmt = con.createStatement();
				String query = "delete from Designation where ID ="+ ID;
				stmt.execute(query);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	//CreateApi for Designation
	@RequestMapping(method=RequestMethod.POST, value="/Designation")
	public String createDesignation(@RequestBody Designation user) {
		
		Connection con;
		try {
			//change your DBURL and database name 
			
			String dbURL = "jdbc:sqlserver://CYG255;database=week3";
			String userdata = "sa";
			con = DriverManager.getConnection(dbURL, userdata, "cyber9198");
			if(con != null) {
				Statement stmt = con.createStatement();
				String query = "insert into Designation values('+Designation.getID()+','+Designation.getName()+');";
				stmt.execute(query);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return "success";
	}

	//UpdateApi for Designation
	@RequestMapping(method=RequestMethod.PUT, value="/Designation/{ID}")
	public void updateDesignation(@RequestBody Designation user, @PathVariable String ID) {
		
		Connection con;
		try {
			String dbURL = "jdbc:sqlserver://CYG255;database=week3";
			String userdata = "sa";
			con = DriverManager.getConnection(dbURL, userdata, "cyber9198");
			if(con != null) {
				Statement stmt = con.createStatement();
				String query = "update Designation set ID='"+user.getID()+"',Name='"+ user.getName()+"' where ID = '"+ID+"'";    
				stmt.execute(query);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
