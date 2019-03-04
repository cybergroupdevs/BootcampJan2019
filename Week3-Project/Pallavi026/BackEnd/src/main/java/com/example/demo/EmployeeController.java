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
import week3.Employees;

@RestController
public class EmployeeController {
	//GetApi for All Users
	@GetMapping("/Employees")
	public List<Employees> index2(){
		Connection con;
		List<Employees> Employees = new ArrayList<Employees>();
		ResultSet rs = null;
		try {
			String dbURL = "jdbc:sqlserver://CYG255;database=week3";
			String userdata = "sa";
			con = DriverManager.getConnection(dbURL, userdata, "cyber9198");
			if(con != null) {
				Statement stmt = con.createStatement();
				String queryforallusers = "select * from Employees";
				rs=stmt.executeQuery(queryforallusers);
				while(rs.next())
				{
					Employees.add(new Employees(rs.getString("ID"),rs.getString("Name"),
						rs.getInt("Name"),rs.getString("Gender"),rs.getString("Password"),
						rs.getString("EmailID"),rs.getString("DesigID")
						)); 
				}
				return Employees;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}	
		return Employees;
	}

	//GetApi for Single User Details
	@GetMapping("/Employees/{ID}")
	public List<Employees> index3(@PathVariable String ID){
		Connection con;
		List<Employees> Employees = new ArrayList<Employees>();
		ResultSet rs = null;
		try {
			String dbURL = "jdbc:sqlserver://CYG255;database=week3";
			String userdata = "sa";
			con = DriverManager.getConnection(dbURL, userdata, "cyber9198");
			if(con != null) {
				Statement stmt = con.createStatement();
				String queryforoneuser = "select * from Employees where ID="+ID;
				rs=stmt.executeQuery(queryforoneuser);
				while(rs.next())
				{
					Employees.add(new Employees(rs.getString("ID"),rs.getString("Name"),
							rs.getInt("Name"),rs.getString("Gender"),rs.getString("Password"),
							rs.getString("EmailID"),rs.getString("DesigID")
							)); 
				}
				return Employees;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}	
		return Employees;
	}
	
	//DeleteApi for Employees
	@RequestMapping(method=RequestMethod.DELETE, value="/Employees/{ID}")
	public void deleteEmployee(@PathVariable String ID) {
		
		Connection con;
		try {
			String dbURL ="jdbc:sqlserver://CYG255;database=week3";
			String userdata = "sa";
			con = DriverManager.getConnection(dbURL, userdata, "cyber9198");
			if(con != null) {
				Statement stmt = con.createStatement();
				String query = "delete from Employees where ID ="+ ID;
				stmt.execute(query);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	//CreateApi for Employees
	@RequestMapping(method=RequestMethod.POST, value="/Employees")
	public String createEmployees(@RequestBody Employees user) {
		
		Connection con;
		try {
			//change your DBURL and database name 
			
			String dbURL = "jdbc:sqlserver://CYG255;database=week3";
			String userdata = "sa";
			con = DriverManager.getConnection(dbURL, userdata, "cyber9198");
			if(con != null) {
				Statement stmt = con.createStatement();
				String query = "insert into Employees value('"+user.getID()+"','"+user.getName()+"','"+user.getContactNo()+"','"+user.getGender()+"','"+user.getPassword()+"','"+user.getEmailID()+','+user.getDesigID()+"');";
				stmt.execute(query);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return "success";
	}

	//UpdateApi for Employees
	@RequestMapping(method=RequestMethod.PUT, value="/Employees/{ID}")
	public void updateEmployees(@RequestBody Employees user, @PathVariable String ID) {
		
		Connection con;
		try {
			String dbURL = "jdbc:sqlserver://CYG255;database=week3";
			String userdata = "sa";
			con = DriverManager.getConnection(dbURL, userdata, "cyber9198");
			if(con != null) {
				Statement stmt = con.createStatement();
				String query = "update Employees set ID='+Employees.getID()+',Name='+Employees.getName()+',ContactNo='+Employees.getContactNo()+',Gender='+Employees.getGender()+',Password='+Employees.getPassword()+',EmailID='+Employees.getEmailID()+',DesigID='+Employees.getDesigID()+' where ID = "+ID;
				stmt.execute(query);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
