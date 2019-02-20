package com.example.demo.controller;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.Repository.EmpRepository;
import com.example.demo.EmployeeDetail.EmployeeDetail;

@RestController
public class EmpController {
	//@Autowired
	//EmpRepository Repo;
	
	
	//GetApi for All Users
	@GetMapping("/EmployeeDetail")
	public List<EmployeeDetail> index2(){
		Connection con;
		List<EmployeeDetail> Employees = new ArrayList<EmployeeDetail>();
		ResultSet rs = null;
		try {
			String dbURL = "jdbc:sqlserver://DESKTOP-4EEOQT3;database=LoginSystem";
			String user = "sa";
			con = DriverManager.getConnection(dbURL, user, "12345");
			if(con != null) {
				Statement stmt = con.createStatement();
				String queryforallusers = "select * from EmployeeDetail";
				rs=stmt.executeQuery(queryforallusers);
				while(rs.next())
				{
					Employees.add(new EmployeeDetail(rs.getString("Id"),rs.getString("firstname"),
						rs.getString("lastname"),rs.getString("fathername"),rs.getString("Email"),
						rs.getString("Phone"),rs.getString("country"),rs.getString("dob"),
						rs.getString("gender"),rs.getString("designation"),rs.getString("address")
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
	@GetMapping("/EmployeeDetail/{Id}")
	public List<EmployeeDetail> index3(@PathVariable String Id){
		Connection con;
		List<EmployeeDetail> Employees = new ArrayList<EmployeeDetail>();
		ResultSet rs = null;
		try {
			String dbURL = "jdbc:sqlserver://DESKTOP-4EEOQT3;database=LoginSystem";
			String user = "sa";
			con = DriverManager.getConnection(dbURL, user, "12345");
			if(con != null) {
				Statement stmt = con.createStatement();
				String queryforoneuser = "select * from EmployeeDetail where Id="+Id;
				rs=stmt.executeQuery(queryforoneuser);
				while(rs.next())
				{
					Employees.add(new EmployeeDetail(rs.getString("Id"),rs.getString("firstname"),
						rs.getString("lastname"),rs.getString("fathername"),rs.getString("Email"),
						rs.getString("Phone"),rs.getString("country"),rs.getString("dob"),
						rs.getString("gender"),rs.getString("designation"),rs.getString("address")
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
	
	//DeleteApi for EmployeeDetail
	@RequestMapping(method=RequestMethod.DELETE, value="/EmployeeDetail/{Id}")
	public void deleteEmployee(@PathVariable String id) {
		
		Connection con;
		try {
			String dbURL = "jdbc:sqlserver://DESKTOP-4EEOQT3;database=LoginSystem";
			String userdata = "sa";
			con = DriverManager.getConnection(dbURL, userdata, "12345");
			if(con != null) {
				Statement stmt = con.createStatement();
				String query = "delete from EmployeeDetail where Id ="+ id;
				stmt.execute(query);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	//CreateApi for EmployeeDetail
	@RequestMapping(method=RequestMethod.POST, value="/EmployeeDetail")
	public String createEmployeeDetail(@RequestBody EmployeeDetail user, @PathVariable String Id) {
		
		Connection con;
		try {
			String dbURL = "jdbc:sqlserver://DESKTOP-4EEOQT3;database=LoginSystem";
			String userdata = "sa";
			con = DriverManager.getConnection(dbURL, userdata, "12345");
			if(con != null) {
				Statement stmt = con.createStatement();
				String query = "insert into EmployeeDetail value('"+EmployeeDetail.getId()+"','"+EmployeeDetail.getFirstname()+"',lastname='"+EmployeeDetail.getLastname()+"',fathername='"+EmployeeDetail.getFathername()+"',Email='"+EmployeeDetail.getEmail()+"',Phone='"+EmployeeDetail.getPhone()+"',country='"+EmployeeDetail.getCountry()+"',dob='"+EmployeeDetail.getDob()+"',gender='"+EmployeeDetail.getGender()+"',designation='"+EmployeeDetail.getDesignation()+"',address='"+EmployeeDetail.getAddress()+"');";
				stmt.execute(query);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return "success";
	}

	//UpdateApi for EmployeeDetail
	@RequestMapping(method=RequestMethod.PUT, value="/EmployeeDetail/{Id}")
	public void updateEmployeeDetail(@RequestBody EmployeeDetail user, @PathVariable String Id) {
		
		Connection con;
		try {
			String dbURL = "jdbc:sqlserver://DESKTOP-4EEOQT3;database=LoginSystem";
			String userdata = "sa";
			con = DriverManager.getConnection(dbURL, userdata, "12345");
			if(con != null) {
				Statement stmt = con.createStatement();
				String query = "update EmployeeDetail set firstname='"+EmployeeDetail.getFirstname()+"',lastname='"+EmployeeDetail.getLastname()+"',fathername='"+EmployeeDetail.getFathername()+"',Email='"+EmployeeDetail.getEmail()+"',Phone='"+EmployeeDetail.getPhone()+"',country='"+EmployeeDetail.getCountry()+"',dob='"+EmployeeDetail.getDob()+"',gender='"+EmployeeDetail.getGender()+"',designation='"+EmployeeDetail.getDesignation()+"',address='"+EmployeeDetail.getAddress()+"' where Id = "+Id;
				stmt.execute(query);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
