package com.example.week3.controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import model.Employee;

@RestController
public class empcontrollers {
	@RequestMapping(method = RequestMethod.GET, value="/employee")
	public List<Employee> index1(){
	Connection con;
	List<Employee> userList=new ArrayList<Employee>();
	ResultSet rs=null;
	try {
		String dbUrl = "jdbc:sqlserver://CYG335;database=weekTwo";
		String user="sa";
		con = DriverManager.getConnection(dbUrl, user, "deepak");
		if(con!=null) {
			Statement st=con.createStatement();
			String query1="select * from employee2";
			rs=st.executeQuery(query1);
			while(rs.next())
			{
				userList.add(new Employee(rs.getInt("id"),rs.getString("name"),
				rs.getString("userName"),rs.getString("gender"),rs.getString("Designation"),
				rs.getString("employeeNo"),rs.getInt("contactNo"),rs.getString("Address"),
				rs.getString("Department")));
				
			}
			//return userList;
			System.out.println(userList);
		}
	}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
	   
		return userList;	
 }	

@RequestMapping(method = RequestMethod.POST, value="/Employee")
 public void index2(@RequestBody Employee emp) { 
	Connection con;

	try {
		String url="jdbc:sqlserver://CYG335;database=weekTwo";
		String user="sa";
		con = DriverManager.getConnection(url, user, "deepak");
		if(con!=null) {
			Statement st=con.createStatement();
			String query1="insert into employee2 values('"+emp.getName()+"',"
			+ "'"+emp.getUserName()+"','"+emp.getGender()+"','"+emp.getDesignation()+"',"
			+ "'"+emp.getEmpNo()+"','"+emp.getContact()+"','"+emp.getAdd()+"','"+emp.getDep()+"'";
			st.execute(query1);
		  }
	}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
   }



@RequestMapping(method = RequestMethod.PUT, value="/Employee")
public void index3(@RequestBody Employee emp, @PathVariable String id) { 
	Connection con;

	try {
		String url="jdbc:sqlserver://CYG335;database=weekTwo";
		String user="sa";
		con = DriverManager.getConnection(url, user, "deepak");
		if(con!=null) {
			Statement st=con.createStatement();
			String query1="update employee2 set name='"+emp.getName()+"',"
					+ " userName='"+emp.getUserName()+"',gender='"+emp.getGender()+"',"
					+ "Designation='"+emp.getDesignation()+"',employeeNo='"+emp.getEmpNo()+"',"
					+ "contactNo='"+emp.getContact()+"',Address='"+emp.getAdd()+"',"
					+ "Department='"+emp.getDep()+"' where employeeNo='"+id+"'";
			st.execute(query1);
		  }
	}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
   }
@RequestMapping(method = RequestMethod.DELETE, value="/Employee/{id}")
public void index4(@PathVariable String id) { 
	Connection con;

	try {
		String url="jdbc:sqlserver://CYG335;database=weekTwo";
		String user="sa";
		con = DriverManager.getConnection(url, user, "deepak");
		if(con!=null) {
			Statement st=con.createStatement();
			String query1="delete from employee2 where employeeNo='"+id+"'";
			st.execute(query1);
		  }
	}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
   }

@RequestMapping(method = RequestMethod.GET, value="/Employee/{id}")
public void index5(@PathVariable String id) { 
	Connection con;

	try {
		String url="jdbc:sqlserver://CYG335;database=weekTwo";
		String user="sa";
		con = DriverManager.getConnection(url, user, "deepak");
		if(con!=null) {
			Statement st=con.createStatement();
			String query1="select * from employee2 where employeeNo='"+id+"'";
			st.execute(query1);
		  }
	}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
   }

}


