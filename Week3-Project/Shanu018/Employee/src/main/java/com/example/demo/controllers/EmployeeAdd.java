package com.example.demo.controllers;



	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.sql.ResultSet;

	import org.springframework.stereotype.Controller;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;
	import org.springframework.web.bind.annotation.ResponseBody;
	import com.example.demo.beans.Employee;
	import org.springframework.web.bind.annotation.CrossOrigin;

	@CrossOrigin (origins = "*")

	@Controller
	public class EmployeeAdd{
		  @RequestMapping(method = RequestMethod.POST, value="api/employees")
		  @ResponseBody

		  public Employee addEmployee(@RequestBody Employee emp) {
			  
			Employee emp1 = new Employee();
			Connection conn = null;
			try {
				String Name = emp.getName();
				String FathersName = emp.getFathersName();
				String Eid = emp.getEid();
				String Dob = emp.getDob();
				int Mobile = emp.getMob();
				String Address = emp.getAddress();
				String City = emp.getCity();
				String State = emp.getState();
				String Designation = emp.getDesignation();
				String Supervisor = emp.getSupervisor();
				String Gender = emp.getGender();
				String Emailid = emp.getEmailid();
				

				String dbURL = "jdbc:sqlserver://CYG362;databaseName=Eclipse";
				String user = "sa";
				conn = DriverManager.getConnection(dbURL, user, "Password@123" );
				if(conn != null ) {

				    System.out.println("Connection Successful******************************");
				    
					Statement stmt = conn.createStatement();
				   

					String pass="";
				    System.out.println("Insert into Employee values( \'" + Name +"\' ," + " \'"+ FathersName +"\' ,'" + Eid  +"\' ," + " \'"+ Dob +"\' ," + " \'"+ Mobile +"\' ," + " \'"+Address +"\' ," + " \'"+City  +"\' ," + " \'"+ State  +"\' ," + " \'"+ Designation  +"\' ," + " \'"+ Supervisor  +"\' ," + " \'"+ Gender   +"\' ," + " \'"+ Emailid + "','"+pass+"');");
						
			    stmt.execute("Insert into Employee values( \'" + Name +"\' ," + " \'"+ FathersName +"\' ,'" + Eid  +"\' ," + " \'"+ Dob +"\' ," + " \'"+ Mobile +"\' ," + " \'"+Address +"\' ," + " \'"+City  +"\' ," + " \'"+ State  +"\' ," + " \'"+ Designation  +"\' ," + " \'"+ Supervisor  +"\' ," + " \'"+ Gender   +"\' ," + " \'"+ Emailid + "','"+pass+"');");
				    System.out.println("Done******************************");

				}
			}
			catch(SQLException ex) {
				ex.printStackTrace();
			}
			return emp;
	  }

}

