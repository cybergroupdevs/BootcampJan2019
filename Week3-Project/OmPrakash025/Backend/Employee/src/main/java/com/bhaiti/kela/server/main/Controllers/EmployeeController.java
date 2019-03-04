package com.bhaiti.kela.server.main.Controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bhaiti.kela.server.main.Employee;

public class EmployeeController {
	@RequestMapping(method = RequestMethod.DELETE, value="/Employee/{id}")
	@ResponseBody
	public void DeleteDep(@RequestBody @PathVariable("id")  String id) {
		Connection con;
			try {
				String dbURL = "jdbc:sqlserver://CYG169;database=hrms";
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
				String dbURL = "jdbc:sqlserver://CYG169;database=hrms";
				String user = "sa";
				con = DriverManager.getConnection(dbURL, user, "password");
				if(con != null) {
					Statement stmt = con.createStatement();
					String query = "insert into Employee values('"+lc.getID()+"', Name = '"+lc.getName()+"',Email='"+lc.getEmail()+"', PhoneNumber='"+lc.getPhoneNumber()+"', FathersName='"+lc.getFathersName()+"', MothersName='"+lc.getMothersName()+"', DOB='"+lc.getDOB()+"', Gender='"+lc.getGender()+"',BloodGroup='"+lc.getBloodGroup()+"',Nationality='"+lc.getNationality()+"', AadharNumber='"+lc.getAadharNumber()+"',PanNumber='"+lc.getPanNumber()+"',Bio='"+lc.getBio()+"',JobRole='"+lc.getJobRole()+"');";
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
				String dbURL = "jdbc:sqlserver://CYG169;database=hrms";
				String user = "sa";
				con = DriverManager.getConnection(dbURL, user, "password");
				if(con != null) {
					Statement stmt = con.createStatement();
					String query = "update Employee set ID='"+lc.getID()+"', Name = '"+lc.getName()+"',Email='"+lc.getEmail()+"', PhoneNumber='"+lc.getPhoneNumber()+"', FathersName='"+lc.getFathersName()+"', MothersName='"+lc.getMothersName()+"', DOB='"+lc.getDOB()+"', Gender='"+lc.getGender()+"',BloodGroup='"+lc.getBloodGroup()+"',Nationality='"+lc.getNationality()+"', AadharNumber='"+lc.getAadharNumber()+"',PanNumber='"+lc.getPanNumber()+"',Bio='"+lc.getBio()+"',JobRole='"+lc.getJobRole()+"' where ID ='"+ id+"';";
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
				String dbURL = "jdbc:sqlserver://CYG169;database=hrms";
				String user = "sa";
				con = DriverManager.getConnection(dbURL, user, "password");
				if(con != null) {
					Statement stmt = con.createStatement();
					String query5 = "select * from Employee";
					rs=stmt.executeQuery(query5);
					while(rs.next())
					{
						EmployeeList.add(new Employee(rs.getInt("ID"),rs.getString("Name"),rs.getString("Email"),rs.getString("PhoneNumber"),rs.getString("FathersName"),rs.getString("MothersName"),rs.getString("DOB"),rs.getString("Gender"),rs.getString("BloodGroup"),rs.getString("Nationality"),rs.getString("AadharNumber"),rs.getString("PanNumber"),rs.getString("Bio"),rs.getString("JobRole"))); 
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
			String dbURL = "jdbc:sqlserver://CYG169;database=hrms";
			String user = "sa";
			con = DriverManager.getConnection(dbURL, user, "password");
			if(con != null) {
				Statement stmt = con.createStatement();
				String query5 = "select * from Employee where ID="+id;
				rs=stmt.executeQuery(query5);
				while(rs.next())
				{
					emp.setID(rs.getInt("ID"));
					emp.setName(rs.getString("Name"));
					emp.setEmail(rs.getString("Email"));
					emp.setPhoneNumber(rs.getString("PhoneNumber"));
					emp.setFathersName(rs.getString("FathersName"));
					emp.setMothersName(rs.getString("MothersName"));
					emp.setDOB(rs.getString("DOB"));
					emp.setGender(rs.getString("Gender"));
					emp.setBloodGroup(rs.getString("BloodGroup"));
					emp.setNationality(rs.getString("Nationality"));

					emp.setAadharNumber(rs.getString("AadharNumber"));
					emp.setPanNumber(rs.getString("panNumber"));
					emp.setBio(rs.getString("Bio"));
					emp.setJobRole(rs.getString("JobRole"));
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
