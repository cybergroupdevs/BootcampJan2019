package com.CRUD.main.controller;

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

import com.CRUD.main.EmployeeData;

@CrossOrigin
@Controller
public class EmployeeDataController {

	@RequestMapping(method = RequestMethod.DELETE, value="/EmployeeData/{id}")
	@ResponseBody
	public void DeleteDep(@RequestBody @PathVariable("id")  String id) {
		Connection con;
			try {
				String dbURL = "jdbc:sqlserver://CYG376\\SQLEXPRESS;database=Employees";
				String user = "sa";
				con = DriverManager.getConnection(dbURL, user, "password");
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
	@RequestMapping(method = RequestMethod.POST, value="/EmployeeData")
	@ResponseBody
	public void AddDep(@RequestBody EmployeeData lc) {
		Connection con;
			try {
				String dbURL = "jdbc:sqlserver://CYG376\\SQLEXPRESS;database=Employees";
				String user = "sa";
				con = DriverManager.getConnection(dbURL, user, "password");
				if(con != null) {
					Statement stmt = con.createStatement();
					String query = "insert into EmployeeData values('"+lc.getId()+"','"+lc.getIdtype()+"','"+lc.getName()+"',"
							+ "'"+lc.getIdNumber()+"','"+lc.getEmail()+"','"+lc.getAddress()+"','"+lc.getContact()+"','"+lc.getIdNumber()+"');";
					stmt.execute(query);
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
				
	
	}
	@RequestMapping(method = RequestMethod.PUT, value="/EmployeeData/{id}")
	@ResponseBody
	public void UpdateDep(@RequestBody EmployeeData lc,@PathVariable("id") String id) {
		Connection con;
			try {
				String dbURL = "jdbc:sqlserver://CYG376\\SQLEXPRESS;database=Employees";
				String user = "sa";
				con = DriverManager.getConnection(dbURL, user, "password");
				if(con != null) {
					Statement stmt = con.createStatement();
					String query = "update EmployeeData set Code='"+lc.getIdtype()+"', Name = '"+lc.getName()+"', DesignationId = '"+lc.getIdtype()+"', EmailId = '"+lc.getEmail()+"', Address = '"+lc.getAddress()+"', Contact = '"+lc.getContact()+"', DepartmentId = '"+lc.getIdNumber()+"'where ID ='"+ id+"';";
					stmt.execute(query);
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
	}
	@RequestMapping(method= RequestMethod.GET, value="/EmployeeData")
	@ResponseBody
	public List<EmployeeData> getlogincredentials(){
		Connection con;
		List<EmployeeData> EmployeeDataList= new ArrayList<EmployeeData>();
		ResultSet rs = null;
			try {
				String dbURL = "jdbc:sqlserver://CYG376\\SQLEXPRESS;database=Employees";
				String user = "sa";
				con = DriverManager.getConnection(dbURL, user, "password");
				if(con != null) {
					Statement stmt = con.createStatement();
					String query5 = "select * from EmployeeData";
					rs=stmt.executeQuery(query5);
					while(rs.next())
					{
						EmployeeDataList.add(new EmployeeData(rs.getInt("Id"),rs.getString("Idtype"),rs.getString("MartialStatus"),
								rs.getString("DOB"),rs.getString("Name"),
								rs.getString("Contact"),rs.getString("Home"),rs.getString("Email"),rs.getString("Address"),
								rs.getString("PinCode"),rs.getString("State"))); 
					}
					return EmployeeDataList;
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			return EmployeeDataList;
		}
		
	@RequestMapping(method= RequestMethod.GET, value="/EmployeeData/{id}")
	@ResponseBody
	public EmployeeData getEmployeeDataById(@PathVariable("id") String id){
		Connection con;
		List<EmployeeData> EmployeeDatalist= new ArrayList<EmployeeData>();
		EmployeeData emp= new EmployeeData();
		ResultSet rs = null;
		try {
			String dbURL = "jdbc:sqlserver://CYG376\\SQLEXPRESS;database=EmployeeDatas";
			String user = "sa";
			con = DriverManager.getConnection(dbURL, user, "password");
			if(con != null) {
				Statement stmt = con.createStatement();
				String query5 = "select * from EmployeeData where ID="+id;
				rs=stmt.executeQuery(query5);
				while(rs.next())
				{
					emp.setId(rs.getInt("Id"));
					emp.setIdtype(rs.getString("Idtype"));
					emp.setIdNumber(rs.getInt("idNumber"));
					emp.setMartialStatus(rs.getString("martialStatus"));
					emp.setDOB(rs.getString("dOB"));
					emp.setName(rs.getString("name"));
					emp.setContact(rs.getString("contact"));
					emp.setHome(rs.getString("home"));
					emp.setEmail(rs.getString("email"));
					emp.setAddress(rs.getString("address"));
					emp.setPinCode(rs.getString("pinCode"));
					emp.setState(rs.getString("state"));
					EmployeeDatalist.add(emp);
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return EmployeeDatalist.get(0);
	}

}
