package com.bhaiti.kela.server.main.Controllers;

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
import org.springframework.web.bind.annotation.ResponseBody;

import com.bhaiti.kela.server.main.Login;

@Controller
public class LoginController {
	@RequestMapping(method = RequestMethod.DELETE, value="/Login/{id}")
	@ResponseBody
	public void DeleteDep(@RequestBody @PathVariable("id") String id) {
		Connection con;
			try {
				String dbURL = "jdbc:sqlserver://CYG169;database=hrms";
				String user = "sa1";
				con = DriverManager.getConnection(dbURL, user, "password");
				if(con != null) {
					Statement stmt = con.createStatement();
					String query = "delete from Login where Id ="+id+"";
					stmt.execute(query);
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
	}
	@RequestMapping(method = RequestMethod.POST, value="/Login")
	@ResponseBody
	public Login AddDep(@RequestBody Login lc) {
		Connection con;
			try {
				String dbURL = "jdbc:sqlserver://CYG169;database=hrms";
				String user = "sa1";
				con = DriverManager.getConnection(dbURL, user, "password");
				if(con != null) {
					Statement stmt = con.createStatement();
					String query = "insert into Login values('"+lc.getId()+"','"+lc.getEmployeeId()+"','"+lc.getPassword()+"')";
					stmt.execute(query);
				}
			}
			catch(Exception e) {
				e.printStackTrace();

			}
			return lc;
			
	}
	@RequestMapping(method = RequestMethod.PUT, value="/Login/{id}")
	@ResponseBody
	public void UpdateDep(@RequestBody Login lc,@PathVariable("id") String id) {
		Connection con;
			try {
				String dbURL = "jdbc:sqlserver://CYG169;database=hrms";
				String user = "sa1";
				con = DriverManager.getConnection(dbURL, user, "password");
				if(con != null) {
					Statement stmt = con.createStatement();
					String query = "update Login set Password='"+lc.getPassword()+"', EmployeeId = '"+lc.getEmployeeId()+"'where Id ='"+ id+"';";
					stmt.execute(query);
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
	}
	@RequestMapping(method= RequestMethod.GET, value="/Login")
	@ResponseBody
	public List<Login> getlogincredentials(){
		Connection con;
		List<Login> Login_CredentialList= new ArrayList<Login>();
		ResultSet rs = null;
			try {
				String dbURL = "jdbc:sqlserver://CYG169;database=hrms";
				String user = "sa1";
				con = DriverManager.getConnection(dbURL, user, "password");
				if(con != null) {
					Statement stmt = con.createStatement();
					String query5 = "select * from Login";
					rs=stmt.executeQuery(query5);
					while(rs.next())
					{
						Login_CredentialList.add(new Login(rs.getInt("Id"),rs.getString("EmployeeId"),rs.getString("Password"))); 
					}
					return Login_CredentialList;
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			return Login_CredentialList;
		}
		
	@RequestMapping(method= RequestMethod.GET, value="/Login/{id}")
	@ResponseBody
	public Login getLogin_CredentialById(@PathVariable("id") String id){
		Connection con;
		List<Login> Login_CredentialList= new ArrayList<Login>();
		ResultSet rs=null;
		try {
			String dbURL = "jdbc:sqlserver://CYG169;database=hrms";
			String user = "sa1";
			
			con = DriverManager.getConnection(dbURL, user, "password");
			if(con != null) {
				Statement stmt = con.createStatement();
				String query5 = "select * from Login where Id="+id+"";
				rs=stmt.executeQuery(query5);


				
				while(rs.next())
				{
					Login_CredentialList.add(new Login(rs.getInt("Id"),rs.getString("EmployeeId"),rs.getString("Password"))); 
				}
				return Login_CredentialList.get(0);
			
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return Login_CredentialList.get(0);
	}

}
