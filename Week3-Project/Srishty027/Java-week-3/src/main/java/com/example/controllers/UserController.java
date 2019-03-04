package com.example.controllers;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.calls.User;


@CrossOrigin
@Controller
public class UserController {
	@RequestMapping(method = RequestMethod.DELETE, value="/User/{id}")
	@ResponseBody
	public void DeleteDep(@RequestBody @PathVariable("id") String id) {
		Connection con;
			try {
				String dbURL = "jdbc:sqlserver://CYG236\\SQLEXPRESS;database=Corporate";
				String user = "sa";
				con = DriverManager.getConnection(dbURL, user, "password");
				if(con != null) {
					Statement stmt = con.createStatement();
					String query = "delete from User where Id ="+id+"";
					stmt.execute(query);
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
	}
	@RequestMapping(method = RequestMethod.POST, value="/User")
	@ResponseBody
	public User AddDep(@RequestBody User lc) {
		Connection con;
			try {
				String dbURL = "jdbc:sqlserver://CYG188;database=JavaProject";
				String user = "sa";
				con = DriverManager.getConnection(dbURL, user, "password");
				if(con != null) {
					Statement stmt =  con.createStatement();
					String query = "insert into User values('"+lc.getID()+"','"+lc.getUsername()+"','"+lc.getPassword()+"')";
					stmt.execute(query);
				}
			}
			catch(Exception e) {
				e.printStackTrace();

			}
			return lc;
			
	}
	@RequestMapping(method = RequestMethod.PUT, value="/User/{id}")
	@ResponseBody
	public void UpdateDep(@RequestBody User lc,@PathVariable("id") String id) {
		Connection con;
			try {
				String dbURL = "jdbc:sqlserver://CYG236\\SQLEXPRESS;database=Corporate";
				String user = "sa";
				con = DriverManager.getConnection(dbURL, user, "password");
				if(con != null) {
					Statement stmt = con.createStatement();
					String query = "update User set Password='"+lc.getPassword()+"', Email = '"+lc.getUsername()+"'where Id ='"+ id+"';";
					stmt.execute(query);
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
	}
	@RequestMapping(method= RequestMethod.GET, value="/User")
	@ResponseBody
	public List<User> getlogincredentials(){
		Connection con;
		List<User> Login_CredentialList= new ArrayList<User>();
		ResultSet rs = null;
			try {
				String dbURL = "jdbc:sqlserver://CYG236\\SQLEXPRESS;database=Corporate";
				String user = "sa";
				con = DriverManager.getConnection(dbURL, user, "password");
				if(con != null) {
					Statement stmt = con.createStatement();
					String query5 = "select * from User";
					rs=stmt.executeQuery(query5);
					while(rs.next())
					{
						Login_CredentialList.add(new User(rs.getInt("Id"),rs.getString("Username"),rs.getString("Password"))); 
					}
					return Login_CredentialList;
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			return Login_CredentialList;
		}
		
	@RequestMapping(method= RequestMethod.GET, value="/User/{id}")
	@ResponseBody
	public User getLogin_CredentialById(@PathVariable("id") String id){
		Connection con;
		List<User> Login_CredentialList= new ArrayList<User>();
		ResultSet rs=null;
		try {
			String dbURL = "jdbc:sqlserver://CYG236\\SQLEXPRESS;database=Corporate";
			String user = "sa";
			
			con = DriverManager.getConnection(dbURL, user, "password");
			if(con != null) {
				Statement stmt = (Statement) con.createStatement();
				String query5 = "select * from User where Id="+id+"";
				rs=stmt.executeQuery(query5);


				
				while(rs.next())
				{
					Login_CredentialList.add(new User(rs.getInt("Id"),rs.getString("Email"),rs.getString("Password"))); 
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
