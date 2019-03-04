package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.Employees;


@CrossOrigin
@Controller
public class EmployeesController {


		@RequestMapping(method = RequestMethod.DELETE, value="/Employees/{id}")
		@ResponseBody
		public void DeleteDep(@RequestBody @PathVariable("id")  String id) {
			Connection con;
				try {
					String dbURL = "jdbc:sqlserver://CYG317;database=CygrpJava";
					String user = "sa";
					con = DriverManager.getConnection(dbURL, user, "Vatsal@123");
					if(con != null) {
						Statement stmt = con.createStatement();
						String query = "delete from Employees where ID="+id;
						stmt.execute(query);
					}
				}
				catch(Exception e) {
					e.printStackTrace();
				}
		}
		@RequestMapping(method = RequestMethod.POST, value="/Employees")
		@ResponseBody
		public void AddDep(@RequestBody Employees lc) {
			Connection con;
				try {
					String dbURL = "jdbc:sqlserver://CYG317;database=CygrpJava";
					String user = "sa";
					con = DriverManager.getConnection(dbURL, user, "Vatsal@123");
					if(con != null) {
						Statement stmt = con.createStatement();
						String query = "insert into Employees values('"+lc.getEmployee_CGI_Code()+"','"+lc.getFirst_Name()+"','"+lc.getLast_Name()+"','"+lc.getDesignation()+"','"+lc.getYears_Of_Experiance()+"','"+lc.getQualification()+"');";
						stmt.execute(query);
					}
				}
				catch(Exception e) {
					e.printStackTrace();
				}
					
		
		}
		@RequestMapping(method = RequestMethod.PUT, value="/Employees/{id}")
		@ResponseBody
		public void UpdateDep(@RequestBody Employees lc,@PathVariable("id") String id) {
			Connection con;
				try {
					String dbURL = "jdbc:sqlserver://CYG317;database=CygrpJava";
					String user = "sa";
					con = DriverManager.getConnection(dbURL, user, "Vatsal@123");
					if(con != null) {
						Statement stmt = con.createStatement();
						String query = "update Employees set Code='"+lc.getEmployee_CGI_Code()+"', FirstName = '"+lc.getFirst_Name()+"',LastName='"+lc.getLast_Name()+"', Designation = '"+lc.getDesignation()+"', Years_Of_Experiance = '"+lc.getYears_Of_Experiance()+"', Qualification = '"+lc.getQualification()+"'where ID ='"+ id+"';";
						stmt.execute(query);
					}
				}
				catch(Exception e) {
					e.printStackTrace();
				}
		}
		@RequestMapping(method= RequestMethod.GET, value="/Employees")
		@ResponseBody
		public List<Employees> getlogincredentials(){
			Connection con;
			List<Employees> EmployeesList= new ArrayList<Employees>();
			ResultSet rs = null;
				try {
					String dbURL = "jdbc:sqlserver://CYG317;database=CygrpJava";
					String user = "sa";
					con = DriverManager.getConnection(dbURL, user, "Vatsal@123");
					if(con != null) {
						Statement stmt = con.createStatement();
						String query5 = "select * from Employees";
						rs=stmt.executeQuery(query5);
						while(rs.next())
						{
							EmployeesList.add(new Employees(rs.getInt("Employee_CGI_Code"),rs.getString("First_Name"),rs.getString("Last_Name"),rs.getString("Designation"),rs.getInt("Years_Of_Experiance"),rs.getString("Qualification"))); 
						}
						return EmployeesList;
					}
				}
				catch(Exception e) {
					e.printStackTrace();
				}
				return EmployeesList;
			}
			
		@RequestMapping(method= RequestMethod.GET, value="/Employees/{id}")
		@ResponseBody
		public Employees getEmployeesById(@PathVariable("id") String id){
			Connection con;
			List<Employees> Employeeslist= new ArrayList<Employees>();
			Employees emp= new Employees();
			ResultSet rs = null;
			try {
				String dbURL = "jdbc:sqlserver://CYG317;database=CygrpJava";
				String user = "sa";
				con = DriverManager.getConnection(dbURL, user, "Vatsal@123");
				if(con != null) {
					Statement stmt = con.createStatement();
					String query5 = "select * from Employees where ID="+id;
					rs=stmt.executeQuery(query5);
					while(rs.next())
					{
						emp.setEmployee_CGI_Code(rs.getInt("Employee_CGI_Code"));
						emp.setFirst_Name(rs.getString("First_Name"));
						emp.setLast_Name(rs.getString("Last_Name"));
						emp.setDesignation(rs.getString("Designation"));
						emp.setYears_Of_Experiance(rs.getInt("Years_Of_Experiance"));
						emp.setQualification(rs.getString("Qualification"));
						Employeeslist.add(emp);
					}
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			return Employeeslist.get(0);
		}

	}


