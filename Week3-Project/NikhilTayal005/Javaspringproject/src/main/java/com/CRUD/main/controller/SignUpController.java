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

import com.CRUD.main.SignUp;

@CrossOrigin
@Controller
public class SignUpController {
	@RequestMapping(method = RequestMethod.DELETE, value="/SignUp/{id}")
	@ResponseBody
	public void DeleteDep(@RequestBody @PathVariable("id") String id) {
		Connection con;
			try {
				String dbURL = "jdbc:sqlserver://CYG376\SQLEXPRESS;database=Employees";
				String user = "sa";
				con = DriverManager.getConnection(dbURL, user, "Password");
				if(con != null) {
					Statement stmt = con.createStatement();
					String query = "delete from SignUp where Id ="+id+"";
					stmt.execute(query);
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
	}
	@RequestMapping(method = RequestMethod.POST, value="/SignUp")
	@ResponseBody
	public SignUp AddDep(@RequestBody SignUp lc) {
		Connection con;
			try {
				String dbURL = "jdbc:sqlserver://CYG376\\SQLEXPRESS;database=Employees";
				String user = "sa";
				con = DriverManager.getConnection(dbURL, user, "Password");
				if(con != null) {
					Statement stmt = con.createStatement();
					String query = "insert into SignUp values('"+lc.getId()+"','"+lc.getEmail()+"','"+lc.getPassword()+"','"+lc.getFname()+"','"+lc.getLname()+"','"+lc.getUserName()+"')";
					stmt.execute(query);
				}
			}
			catch(Exception e) {
				e.printStackTrace();

			}
			return lc;
			
	}
	@RequestMapping(method = RequestMethod.PUT, value="/SignUp/{id}")
	@ResponseBody
	public void UpdateDep(@RequestBody SignUp lc,@PathVariable("id") String id) {
		Connection con;
			try {
				String dbURL = "jdbc:sqlserver://CYG376\SQLEXPRESS;database=Corporate";
				String user = "sa";
				con = DriverManager.getConnection(dbURL, user, "Password");
				if(con != null) {
					Statement stmt = con.createStatement();
					String query = "update SignUp set Password='"+lc.getPassword()+"', Email = '"+lc.getEmail()+"'where Id ='"+ id+"';";
					stmt.execute(query);
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
	}
	@RequestMapping(method= RequestMethod.GET, value="/SignUp")
	@ResponseBody
	public List<SignUp> getlogincredentials(){
		Connection con;
		List<SignUp> Login_CredentialList= new ArrayList<SignUp>();
		ResultSet rs = null;
			try {
				String dbURL = "jdbc:sqlserver://CYG376\SQLEXPRESS;database=Corporate";
				String user = "sa";
				con = DriverManager.getConnection(dbURL, user, "password");
				if(con != null) {
					Statement stmt = con.createStatement();
					String query5 = "select * from SignUp";
					rs=stmt.executeQuery(query5);
					while(rs.next())
					{
						Login_CredentialList.add(new SignUp(rs.getInt("Id"),rs.getString("Email"),rs.getString("Password"),rs.getString("Fname"),rs.getString("Lname"),rs.getString("UserName"))); 
					}
					return Login_CredentialList;
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			return Login_CredentialList;
		}
		
	@RequestMapping(method= RequestMethod.GET, value="/SignUp/{id}")
	@ResponseBody
	public SignUp getLogin_CredentialById(@PathVariable("id") String id){
		Connection con;
		List<SignUp> Login_CredentialList= new ArrayList<SignUp>();
		ResultSet rs=null;
		try {
			String dbURL = "jdbc:sqlserver://CYG376\SQLEXPRESS;database=Employees";
			String user = "sa";
			
			con = DriverManager.getConnection(dbURL, user, "password");
			if(con != null) {
				Statement stmt = con.createStatement();
				String query5 = "select * from SignUp where Id="+id+"";
				rs=stmt.executeQuery(query5);


				
				while(rs.next())
				{
					Login_CredentialList.add(new SignUp(rs.getInt("Id"),rs.getString("Email"),rs.getString("Password"),rs.getString("Fname"),rs.getString("Lname"),rs.getString("UserName"))); 
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
