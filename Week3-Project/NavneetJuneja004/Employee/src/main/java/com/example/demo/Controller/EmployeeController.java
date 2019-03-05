package com.example.demo.Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Employee;

@RestController
public class EmployeeController {
	//@Autowired
	//EmpRepository Repo;
	
	
	//GetApi for All Users
	@GetMapping("/Employee")
	public List<Employee> index2(){
		Connection con;
		List<Employee> Employees = new ArrayList<Employee>();
		ResultSet rs = null;
		try {
			String dbURL = "jdbc:sqlserver://DESKTOP-8GLKVBG;database=CorporateLedger";
			String user = "sa";
			con = DriverManager.getConnection(dbURL, user, "godisgreat84");
			if(con != null) {
				Statement stmt = con.createStatement();
				String queryforallusers = "select * from EMPLOYEE";
				rs=stmt.executeQuery(queryforallusers);
				while(rs.next())
				{
					Employees.add(new Employee(rs.getString("Id"),rs.getString("empid"),rs.getString("firstname"),
						rs.getString("lastname"),rs.getString("dob"),
						rs.getString("Gender"),rs.getString("Designation"),rs.getString("Adress")
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
	@GetMapping("/Employee/{Id}")
	public List<Employee> index3(@PathVariable String Id){
		Connection con;
		List<Employee> Employees = new ArrayList<Employee>();
		ResultSet rs = null;
		try {
			String dbURL = "jdbc:sqlserver://DESKTOP-8GLKVBG;database=CorporateLedger";
			String user = "sa";
			con = DriverManager.getConnection(dbURL, user, "godisgreat84");
			if(con != null) {
				Statement stmt = con.createStatement();
				String queryforoneuser = "select * from Employee where Id="+Id;
				rs=stmt.executeQuery(queryforoneuser);
				while(rs.next())
				{
					Employees.add(new Employee(rs.getString("Id"),rs.getString("empid"),rs.getString("firstname"),
						rs.getString("lastname"),rs.getString("dob"),
						rs.getString("Gender"),rs.getString("Designation"),rs.getString("Adress")
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
	
	//DeleteApi for Employee
	@RequestMapping(method=RequestMethod.DELETE, value="/Employee/{Id}")
	public void deleteEmployee(@PathVariable String id) {
		
		Connection con;
		try {
			String dbURL = "jdbc:sqlserver://DESKTOP-8GLKVBG;database=CorporateLedger";
			String userdata = "sa";
			con = DriverManager.getConnection(dbURL, userdata, "godisgreat84");
			if(con != null) {
				Statement stmt = con.createStatement();
				String query = "delete from Employee where Id ="+ id;
				stmt.execute(query);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	//CreateApi for Employee
	@RequestMapping(method=RequestMethod.POST, value="/Employee")
	public String createEmployee(@RequestBody Employee user) {
		
		Connection con;
		try {
			String dbURL = "jdbc:sqlserver://DESKTOP-8GLKVBG;database=CorporateLedger";
			String userdata = "sa";
			con = DriverManager.getConnection(dbURL, userdata, "godisgreat84");
			if(con != null) {
				System.out.println("Connection Successfull *************");

				Statement stmt = con.createStatement();
				
				String query = "insert into EMPLOYEE values('"+user.getId()+"','"+user.getId()+"','"+user.getFirstname()+"','"+user.getLastname()+"','"+user.getDOB()+"','"+user.getGender()+"','"+user.getDesignation()+"','"+user.getAdress()+"');";
				System.out.println("Connection Successfull *************");
				
				
				stmt.execute(query);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return "success";
	}

	//UpdateApi for Employee
	@RequestMapping(method=RequestMethod.PUT, value="/Employee/{Id}")
	public void updateEmployee(@RequestBody Employee user, @PathVariable String Id) {
		
		Connection con;
		try {
			String dbURL = "jdbc:sqlserver://DESKTOP-8GLKVBG;database=CorporateLedger";
			String userdata = "sa";
			con = DriverManager.getConnection(dbURL, userdata, "godisgreat84");
			if(con != null) {
				System.out.println("Connection Successfull *************");
				Statement stmt = con.createStatement();
				String query = "update Employee set firstname='"+user.getFirstname()+"',lastname='"+user.getLastname()+"',DOB='"+user.getDOB()+"',Gender='"+user.getGender()+"',Designation='"+user.getDesignation()+"',Adress='"+user.getAdress()+"' where Id = "+Id;
				stmt.execute(query);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	} 
}
	