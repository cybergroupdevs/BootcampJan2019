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

@CrossOrigin
@Controller
public class EmployeeDataDataController {

	@RequestMapping(method = RequestMethod.DELETE, value="/EmployeeData/{id}")
	@ResponseBody
	public void DeleteDep(@RequestBody @PathVariable("id")  String id) {
		Connection con;
			try {
				String dbURL = "jdbc:sqlserver://CYG376\SQLEXPRESS;database=Corporate";
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
				String dbURL = "jdbc:sqlserver://CYG376\SQLEXPRESS;database=Corporate";
				String user = "sa";
				con = DriverManager.getConnection(dbURL, user, "password");
				if(con != null) {
					Statement stmt = con.createStatement();
					String query = "insert into EmployeeData values('"+lc.getID()+"','"+lc.getCode()+"','"+lc.getName()+"','"+lc.getDesignationId()+"','"+lc.getEmailId()+"','"+lc.getAddress()+"','"+lc.getContact()+"','"+lc.getDesignationId()+"');";
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
				String dbURL = "jdbc:sqlserver://CYG376\SQLEXPRESS;database=Corporate";
				String user = "sa";
				con = DriverManager.getConnection(dbURL, user, "password");
				if(con != null) {
					Statement stmt = con.createStatement();
					String query = "update EmployeeData set Code='"+lc.getCode()+"', Name = '"+lc.getName()+"', DesignationId = '"+lc.getDesignationId()+"', EmailId = '"+lc.getEmailId()+"', Address = '"+lc.getAddress()+"', Contact = '"+lc.getContact()+"', DepartmentId = '"+lc.getDepartmentId()+"'where ID ='"+ id+"';";
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
				String dbURL = "jdbc:sqlserver://CYG376\SQLEXPRESS;database=Corporate";
				String user = "sa";
				con = DriverManager.getConnection(dbURL, user, "password");
				if(con != null) {
					Statement stmt = con.createStatement();
					String query5 = "select * from EmployeeData";
					rs=stmt.executeQuery(query5);
					while(rs.next())
					{
						EmployeeDataList.add(new EmployeeData(rs.getInt("ID"),rs.getString("Code"),rs.getString("Name"),rs.getInt("DesignationId"),rs.getString("Contact"),rs.getString("Address"),rs.getString("EmailId"),rs.getInt("DepartmentId"))); 
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
					emp.setID(rs.getInt("ID"));
					emp.setCode(rs.getString("Code"));
					emp.setEmailId(rs.getString("EmailId"));
					emp.setContact(rs.getString("Contact"));
					emp.setName(rs.getString("Name"));
					emp.setAddress(rs.getString("Address"));
					emp.setDepartmentId(rs.getInt("DepartmentId"));
					emp.setDesignationId(rs.getInt("DesignationId"));
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
