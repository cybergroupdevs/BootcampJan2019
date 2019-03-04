 package com.example.week3.controllers;

import model.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class logins {
	

	 @RequestMapping(method = RequestMethod.GET, value="/logon")
	public List<login> index1(){
		
		Connection con;
		List<login> userList=new ArrayList<login>();
		ResultSet rs=null;
		try {
			String url="jdbc:sqlserver://CYG335;database=weekTwo";
			String user="sa";
			con = DriverManager.getConnection(url, user, "deepak");
			if(con!=null) {
				Statement st=con.createStatement();
				String query1="select * from Accounts";
				rs=st.executeQuery(query1);
				while(rs.next())
				{
					userList.add(new login(rs.getInt("id"),rs.getString("name"),rs.getString("userName"),rs.getString("password")));
					
				}
				return userList;
			}
		}
			
			catch(Exception e)
			{
				e.printStackTrace();
			}
		   
			return userList;
		
		
	}
	
	 @RequestMapping(method = RequestMethod.POST, value="/logon")
	  public void index2(@RequestBody login log) { 
		Connection con;
	
		try {
			String url="jdbc:sqlserver://CYG335;database=weekTwo";
			String user="sa";
			con = DriverManager.getConnection(url, user, "deepak");
			if(con!=null) {
				Statement st=con.createStatement();
				String query1="insert into Accounts values('"+log.getName()+"','"+log.getUserName()+"','"+log.getPassword()+"')";
				st.execute(query1);
			  }
		}
			
			catch(Exception e)
			{
				e.printStackTrace();
			}
	}
}