package com.example.demo.Controller;

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

import com.example.demo.login;

@Controller
public class loginController {
	@RequestMapping(method = RequestMethod.DELETE, value="/login/{id}")
	@ResponseBody
	public void DeleteDep(@RequestBody @PathVariable("id") String id) {
		Connection con;
			try {
				String dbURL = "jdbc:sqlserver://CYG317;database=CygrpJava";
				String user = "sa";
				con = DriverManager.getConnection(dbURL, user, "Vatsal@123");
				if(con != null) {
					Statement stmt = con.createStatement();
					String query = "delete from login where Id ="+id+"";
					stmt.execute(query);
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
	}
	@RequestMapping(method = RequestMethod.POST, value="/login")
	@ResponseBody
	public login AddDep(@RequestBody login lc) {
		Connection con;
			try {
				String dbURL = "jdbc:sqlserver://CYG317;database=CygrpJava";
				String user = "sa";
				con = DriverManager.getConnection(dbURL, user, "Vatsal@123");
				if(con != null) {
					Statement stmt = con.createStatement();
					String query = "insert into login values('"+lc.getId()+"','"+lc.getUsername()+"','"+lc.getEmail_ID()+"','"+lc.getPassword()+"')";
					stmt.execute(query);
				}
			}
			catch(Exception e) {
				e.printStackTrace();

			}
			return lc;
			
	}
	@RequestMapping(method = RequestMethod.PUT, value="/login/{id}")
	@ResponseBody
	public void UpdateDep(@RequestBody login lc,@PathVariable("id") String id) {
		Connection con;
			try {
				String dbURL = "jdbc:sqlserver://CYG317;database=CygrpJava";
				String user = "sa";
				con = DriverManager.getConnection(dbURL, user, "Vatsal@123");
				if(con != null) {
					Statement stmt = con.createStatement();
					String query = "update login set Password='"+lc.getPassword()+"', Email = '"+lc.getEmail_ID()+"', Username='"+lc.getUsername()+"where Id ='"+ id+"';";
					stmt.execute(query);
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
	}
	@RequestMapping(method= RequestMethod.GET, value="/login")
	@ResponseBody
	public List<login> getlogincredentials(){
		Connection con;
		List<login> Login_CredentialList= new ArrayList<login>();
		ResultSet rs = null;
			try {
				String dbURL = "jdbc:sqlserver://CYG317;database=CygrpJava";
				String user = "sa";
				con = DriverManager.getConnection(dbURL, user, "Vatsal@123");
				if(con != null) {
					Statement stmt = con.createStatement();
					String query5 = "select * from login";
					rs=stmt.executeQuery(query5);
					while(rs.next())
					{
						Login_CredentialList.add(new login(rs.getInt("Id"),rs.getString("Username"),rs.getString("Email_ID"),rs.getString("Password"))); 
					}
					return Login_CredentialList;
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			return Login_CredentialList;
		}
		
	@RequestMapping(method= RequestMethod.GET, value="/login/{id}")
	@ResponseBody
	public login getLogin_CredentialById(@PathVariable("id") String id){
		Connection con;
		List<login> Login_CredentialList= new ArrayList<login>();
		ResultSet rs=null;
		try {
			String dbURL = "jdbc:sqlserver://CYG317;database=CygrpJava";
			String user = "sa";
			
			con = DriverManager.getConnection(dbURL, user, "Vatsal@123");
			if(con != null) {
				Statement stmt = con.createStatement();
				String query5 = "select * from login where Id="+id+"";
				rs=stmt.executeQuery(query5);


				
				while(rs.next())
				{
					Login_CredentialList.add(new login(rs.getInt("Id"),rs.getString("Username"),rs.getString("Email"),rs.getString("Password"))); 
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
