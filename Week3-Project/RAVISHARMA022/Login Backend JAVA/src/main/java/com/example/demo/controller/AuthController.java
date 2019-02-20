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
import com.example.demo.EmployeeDetail.AuthenticateUser;
import com.example.demo.EmployeeDetail.EducationDetail;
import com.example.demo.EmployeeDetail.EmployeeDetail;

@RestController
public class AuthController {

	//GetApi for Single User Details
	@GetMapping("/AuthenticateUser/{Id}")
	public List<AuthController> index3(@PathVariable String Id){
		Connection con;
		List<AuthController> Employees = new ArrayList<AuthController>();
		ResultSet rs = null;
		try {
			String dbURL = "jdbc:sqlserver://DESKTOP-4EEOQT3;database=LoginSystem";
			String user = "sa";
			con = DriverManager.getConnection(dbURL, user, "12345");
			if(con != null) {
				Statement stmt = con.createStatement();
				String queryforoneuser = "select * from AuthenticateUser where Id="+Id;
				rs=stmt.executeQuery(queryforoneuser);
				while(rs.next())
				{
					Employees.add(new AuthenticateUser(rs.getString("Id"),rs.getString("Email"),
							rs.getString("password"),rs.getBoolean("Terms")
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
	
	//DeleteApi for AuthenticateUser
	@RequestMapping(method=RequestMethod.DELETE, value="/AuthenticateUser/{id}")
	public void deleteCredentials(@PathVariable String id) {
		
		Connection con;
		try {
			String dbURL = "jdbc:sqlserver://DESKTOP-4EEOQT3;database=LoginSystem";
			String userdata = "sa";
			con = DriverManager.getConnection(dbURL, userdata, "12345");
			if(con != null) {
				Statement stmt = con.createStatement();
				String query = "delete from AuthenticateUser where Id ="+ id;
				stmt.execute(query);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//CreateApi for AuthenticateUser
	@RequestMapping(method=RequestMethod.POST, value="/AuthenticateUser")
	public void createcredentials(@RequestBody AuthenticateUser user, @PathVariable String Id) {
		Connection con;
		try {
			String dbURL = "jdbc:sqlserver://DESKTOP-4EEOQT3;database=LoginSystem";
			String userdata = "sa";
			con = DriverManager.getConnection(dbURL, userdata, "12345");
			if(con != null) {
				Statement stmt = con.createStatement();
				String query = "insert into AuthenticateUser values('"+AuthenticateUser.getId()+"','"+AuthenticateUser.getEmail()+"',password='"+AuthenticateUser.getPassword()+"',Terms='"+AuthenticateUser.getTerms()+"');";
				stmt.execute(query);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	//UpdateApi for AuthenticateUser
	@RequestMapping(method=RequestMethod.PUT, value="/AuthenticateUser/{Id}")
	public void updatecredentials(@RequestBody EmployeeDetail user, @PathVariable String Id) {
		
		Connection con;
		try {
			String dbURL = "jdbc:sqlserver://DESKTOP-4EEOQT3;database=LoginSystem";
			String userdata = "sa";
			con = DriverManager.getConnection(dbURL, userdata, "12345");
			if(con != null) {
				Statement stmt = con.createStatement();
				String query = "update AuthenticateUser set Email = '"+AuthenticateUser.getEmail()+"',password='"+AuthenticateUser.getPassword()+"',Terms='"+AuthenticateUser.getTerms()+"' where Id = "+Id;
				stmt.execute(query);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	
	

}
