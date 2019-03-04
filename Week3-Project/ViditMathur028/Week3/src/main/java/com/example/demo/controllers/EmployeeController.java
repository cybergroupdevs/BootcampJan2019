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

import com.example.demo.Employee;
@CrossOrigin
@Controller
public class EmployeeController {

	@RequestMapping(method = RequestMethod.DELETE, value="/Employee/{id}")
	@ResponseBody
	public void DeleteDep(@RequestBody @PathVariable("id")  String id) {
		Connection con;
			try {
				String dbURL = "jdbc:sqlserver://CYG236\\SQLEXPRESS;database=Corporate";
				String user = "sa";
				con = DriverManager.getConnection(dbURL, user, "password");
				if(con != null) {
					Statement stmt = con.createStatement();
					String query = "delete from Employee where ID="+id;
					stmt.execute(query);
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
	}
	@RequestMapping(method = RequestMethod.POST, value="/Employee")
	@ResponseBody
	public void AddDep(@RequestBody Employee lc) {
		Connection con;
			try {
				String dbURL = "jdbc:sqlserver://CYG236\\SQLEXPRESS;database=Corporate";
				String user = "sa";
				con = DriverManager.getConnection(dbURL, user, "password");
				if(con != null) {
					Statement stmt = con.createStatement();
					String query = "insert into Employee values('"+lc.getID()+"','"+lc.getCode()+"','"+lc.getName()+"','"+lc.getDesignationId()+"','"+lc.getEmailId()+"','"+lc.getAddress()+"','"+lc.getContact()+"','"+lc.getDesignationId()+"');";
					stmt.execute(query);
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
				
	
	}
	@RequestMapping(method = RequestMethod.PUT, value="/Employee/{id}")
	@ResponseBody
	public void UpdateDep(@RequestBody Employee lc,@PathVariable("id") String id) {
		Connection con;
			try {
				String dbURL = "jdbc:sqlserver://CYG236\\SQLEXPRESS;database=Corporate";
				String user = "sa";
				con = DriverManager.getConnection(dbURL, user, "password");
				if(con != null) {
					Statement stmt = con.createStatement();
					String query = "update Employee set Code='"+lc.getCode()+"', Name = '"+lc.getName()+"', DesignationId = '"+lc.getDesignationId()+"', EmailId = '"+lc.getEmailId()+"', Address = '"+lc.getAddress()+"', Contact = '"+lc.getContact()+"', DepartmentId = '"+lc.getDepartmentId()+"'where ID ='"+ id+"';";
					stmt.execute(query);
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
	}
	@RequestMapping(method= RequestMethod.GET, value="/Employee")
	@ResponseBody
	public List<Employee> getlogincredentials(){
		Connection con;
		List<Employee> EmployeeList= new ArrayList<Employee>();
		ResultSet rs = null;
			try {
				String dbURL = "jdbc:sqlserver://CYG236\\SQLEXPRESS;database=Corporate";
				String user = "sa";
				con = DriverManager.getConnection(dbURL, user, "password");
				if(con != null) {
					Statement stmt = con.createStatement();
					String query5 = "select * from Employee";
					rs=stmt.executeQuery(query5);
					while(rs.next())
					{
						EmployeeList.add(new Employee(rs.getInt("ID"),rs.getString("Code"),rs.getString("Name"),rs.getInt("DesignationId"),rs.getString("Contact"),rs.getString("Address"),rs.getString("EmailId"),rs.getInt("DepartmentId"))); 
					}
					return EmployeeList;
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			return EmployeeList;
		}
		
	@RequestMapping(method= RequestMethod.GET, value="/Employee/{id}")
	@ResponseBody
	public Employee getEmployeeById(@PathVariable("id") String id){
		Connection con;
		List<Employee> Employeelist= new ArrayList<Employee>();
		Employee emp= new Employee();
		ResultSet rs = null;
		try {
			String dbURL = "jdbc:sqlserver://CYG236\\SQLEXPRESS;database=Corporate";
			String user = "sa";
			con = DriverManager.getConnection(dbURL, user, "password");
			if(con != null) {
				Statement stmt = con.createStatement();
				String query5 = "select * from Employee where ID="+id;
				rs=stmt.executeQuery(query5);
				while(rs.next())
				{
					emp.setID(rs.getInt("ID"));
					emp.setCode(rs.getString("Code"));
					emp.setEmailId(rs.getString("EmailId"));
					emp.setContact(rs.getString("Contact"));
					emp.setName(rs.getString("Name"));
					emp.setAddress(rs.getString("Address"));
					emp.setDepartmentId(rs.getInt("DepartmentId"));
					emp.setDesignationId(rs.getInt("DesignationId"));
					Employeelist.add(emp);
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return Employeelist.get(0);
	}
}
