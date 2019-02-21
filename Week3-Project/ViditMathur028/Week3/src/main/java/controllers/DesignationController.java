package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.Designation;

public class DesignationController {
	@RequestMapping(method = RequestMethod.DELETE, value="/Designations/{id}")
	@ResponseBody
	public void DeleteDes(@RequestBody  String id) {
		Connection con;
			try {
				String dbURL = "jdbc:sqlserver://DESKTOP-48ID06J\\SQLEXPRESS;database=Corporate";
				String user = "sa";
				con = DriverManager.getConnection(dbURL, user, "password");
				if(con != null) {
					Statement stmt = con.createStatement();
					String query = "delete from Designation where Id='"+id;
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
				String dbURL = "jdbc:sqlserver://DESKTOP-48ID06J\\SQLEXPRESS;database=Corporate";
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
	public void UpdateDes(@RequestBody Designation des, String id) {
		Connection con;
			try {
				String dbURL = "jdbc:sqlserver://DESKTOP-48ID06J\\SQLEXPRESS;database=Corporate";
				String user = "sa";
				con = DriverManager.getConnection(dbURL, user, "password");
				if(con != null) {
					Statement stmt = con.createStatement();
					String query = "update Designation set Name = '"+des.getName()+"'where Id ="+ id+";";
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
				String dbURL = "jdbc:sqlserver://DESKTOP-48ID06J\\SQLEXPRESS;database=Corporate";
				String user = "sa";
				con = DriverManager.getConnection(dbURL, user, "password");
				if(con != null) {
					Statement stmt = con.createStatement();
					String query5 = "select * from Designation";
					rs=stmt.executeQuery(query5);
					while(rs.next())
					{
						DesignationList.add(new Designation(rs.getInt("ID"),rs.getString("Name"))); 
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
	public Designation getDepartmentById(int id){
		Connection con;
		Designation des= new Designation();
		ResultSet rs = null;
		try {
			String dbURL = "jdbc:sqlserver://DESKTOP-48ID06J\\SQLEXPRESS;database=Corporate";
			String user = "sa";
			con = DriverManager.getConnection(dbURL, user, "password");
			if(con != null) {
				Statement stmt = con.createStatement();
				String query5 = "select * from Designation where Id="+id;
				rs=stmt.executeQuery(query5);
				while(rs.next())
				{
					des.setId(rs.getInt("Id"));
					des.setName(rs.getString("Name")); 
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return des;
	}

}
