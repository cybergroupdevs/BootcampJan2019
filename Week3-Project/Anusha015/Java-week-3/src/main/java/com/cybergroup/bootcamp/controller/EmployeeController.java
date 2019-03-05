package com.cybergroup.bootcamp.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cybergroup.bootcamp.week3.Employee;

@Controller 

public class EmployeeController {
	@RequestMapping(method = RequestMethod.DELETE, value="/Employee/{id}")
	@ResponseBody
	public void DeleteDep(@RequestBody @PathVariable("id")  String id) {
		Connection con;
			try {
				String dbURL = "jdbc:sqlserver://CYG270;database=Week2";
				String user = "sa";
				con = DriverManager.getConnection(dbURL, user, "anusha");
				if(con != null) {
					Statement stmt = con.createStatement();
					String query = "delete from EmployeeData where ID="+id;
					stmt.execute(query);
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
	}
	@RequestMapping(method = RequestMethod.POST, value="/Employee")
	@ResponseBody
	public void AddDep(@RequestBody Employee emp) {
		Connection con;
			try {
				String dbURL = "jdbc:sqlserver://CYG270;database=Week2";
				String user = "sa";
				con = DriverManager.getConnection(dbURL, user, "anusha");
				if(con != null) {
					Statement stmt = con.createStatement();
					String query = "insert into EmployeeData values('"+emp.getFirstName()+"','"+emp.getLastName()+"',"
							+ "'"+emp.getDOB()+"','"+emp.getDesignation()+"','"+emp.getEmailId()+"','"+emp.getPhoneNo()+"');";
					stmt.execute(query);
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
				
	
	}
	@RequestMapping(method = RequestMethod.PUT, value="/Employee/{id}")
	@ResponseBody
	public void UpdateDep(@RequestBody Employee emp,@PathVariable("id") String id) {
		Connection con;
			try {
				String dbURL = "jdbc:sqlserver://CYG270;database=Week2";
				String user = "sa";
				con = DriverManager.getConnection(dbURL, user, "anusha");
				if(con != null) {
					Statement stmt = con.createStatement();
					String query = "update Employee set FirstName='"+emp.getFirstName()+"', LastName = '"+emp.getLastName()+"', DOB = '"+emp.getDOB()+"', Designation = '"+emp.getDesignation()+"', EmailId = '"+emp.getEmailId()+"', PhoneNo = '"+emp.getPhoneNo()+"'where CygId ='"+ id+"';";
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
				String dbURL = "jdbc:sqlserver://CYG270;database=Week2";
				String user = "sa";
				con = DriverManager.getConnection(dbURL, user, "anusha");
				if(con != null) {
					Statement stmt = con.createStatement();
					String query5 = "select * from Employee";
					rs=stmt.executeQuery(query5);
					while(rs.next())
					{
						System.out.println("dbcjwh");
						EmployeeList.add(new Employee(rs.getInt("CygId"),rs.getString("FirstName"),rs.getString("LastName"),
								rs.getString("DOB"),rs.getString("Designation"),
								rs.getString("EmailId"),rs.getString("PhoneNo"))); 
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
	public Employee getEmployeeDataById(@PathVariable("id") String id){
		Connection con;
		List<Employee> Employeelist= new ArrayList<Employee>();
		Employee emp= new Employee();
		ResultSet rs = null;
		try {
			String dbURL = "jdbc:sqlserver://CYG270;database=Week2";
			String user = "sa";
			con = DriverManager.getConnection(dbURL, user, "anusha");
			if(con != null) {
				Statement stmt = con.createStatement();
				String query5 = "select * from Employee where CygId="+id;
				rs=stmt.executeQuery(query5);
				while(rs.next())
				{
					emp.setCygId(rs.getInt("CygId"));
					emp.setFirstName(rs.getString("FirstName"));
					emp.setLastName(rs.getString("LastName"));
					emp.setDOB(rs.getString("DOB"));
					emp.setDesignation(rs.getString("Designation"));
					emp.setEmailId(rs.getString("EmailId"));
					emp.setPhoneNo(rs.getString("PhoneNo"));
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
