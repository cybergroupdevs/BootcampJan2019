package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.Login_Credentials;

public class Login_CredentialsController {
	@RequestMapping(method = RequestMethod.DELETE, value="/Login_Credentials/{id}")
	@ResponseBody
	public void DeleteDep(@RequestBody  String id) {
		Connection con;
			try {
				String dbURL = "jdbc:sqlserver://DESKTOP-48ID06J\\SQLEXPRESS;database=Corporate";
				String user = "sa";
				con = DriverManager.getConnection(dbURL, user, "password");
				if(con != null) {
					Statement stmt = con.createStatement();
					String query = "delete from Login_Credentials where Id='"+id;
					stmt.execute(query);
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
	}
	@RequestMapping(method = RequestMethod.POST, value="/Login_Credentials")
	@ResponseBody
	public void AddDep(@RequestBody Login_Credentials lc) {
		Connection con;
			try {
				String dbURL = "jdbc:sqlserver://DESKTOP-48ID06J\\SQLEXPRESS;database=Corporate";
				String user = "sa";
				con = DriverManager.getConnection(dbURL, user, "password");
				if(con != null) {
					Statement stmt = con.createStatement();
					String query = "insert into Login_Credentials values('"+lc.getId()+"','"+lc.getEmail()+","+lc.getPassword()+"')";
					stmt.execute(query);
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
				
	
	}
	@RequestMapping(method = RequestMethod.PUT, value="/Login_Credentials/{id}")
	@ResponseBody
	public void UpdateDep(@RequestBody Login_Credentials lc, String id) {
		Connection con;
			try {
				String dbURL = "jdbc:sqlserver://DESKTOP-48ID06J\\SQLEXPRESS;database=Corporate";
				String user = "sa";
				con = DriverManager.getConnection(dbURL, user, "password");
				if(con != null) {
					Statement stmt = con.createStatement();
					String query = "update Login_Credentials set Password="+lc.getPassword()+", Email = '"+lc.getEmail()+"'where Id ="+ id+";";
					stmt.execute(query);
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
	}
	@RequestMapping(method= RequestMethod.GET, value="/Login_Credentials")
	@ResponseBody
	public List<Login_Credentials> getlogincredentials(){
		Connection con;
		List<Login_Credentials> Login_CredentialList= new ArrayList<Login_Credentials>();
		ResultSet rs = null;
			try {
				String dbURL = "jdbc:sqlserver://DESKTOP-48ID06J\\SQLEXPRESS;database=Corporate";
				String user = "sa";
				con = DriverManager.getConnection(dbURL, user, "password");
				if(con != null) {
					Statement stmt = con.createStatement();
					String query5 = "select * from Login_Credentials";
					rs=stmt.executeQuery(query5);
					while(rs.next())
					{
						Login_CredentialList.add(new Login_Credentials(rs.getInt("Id"),rs.getString("Email"),rs.getString("Password"))); 
					}
					return Login_CredentialList;
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			return Login_CredentialList;
		}
		
	@RequestMapping(method= RequestMethod.GET, value="/Login_Credentials/{id}")
	@ResponseBody
	public Login_Credentials getLogin_CredentialById(int id){
		Connection con;
		Login_Credentials lc= new Login_Credentials();
		ResultSet rs = null;
		try {
			String dbURL = "jdbc:sqlserver://DESKTOP-48ID06J\\SQLEXPRESS;database=Corporate";
			String user = "sa";
			con = DriverManager.getConnection(dbURL, user, "password");
			if(con != null) {
				Statement stmt = con.createStatement();
				String query5 = "select * from Login_Credentials where Id="+id;
				rs=stmt.executeQuery(query5);
				while(rs.next())
				{
					lc.setId(rs.getInt("Id"));
					lc.setEmail(rs.getString("Email"));
					lc.setPassword(rs.getString("Password"));
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return lc;
	}
}
