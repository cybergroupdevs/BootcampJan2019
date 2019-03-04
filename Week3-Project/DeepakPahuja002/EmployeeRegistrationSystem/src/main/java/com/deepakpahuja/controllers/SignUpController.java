package com.deepakpahuja.controllers;


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

import com.deepakpahuja.beans.SignUp;
@CrossOrigin
@Controller
public class SignUpController {
	

	  @RequestMapping(method = RequestMethod.GET, value="/SignUp/allSignUp")  
	  @ResponseBody
	  public List<SignUp> GetSignUpTable() {
	      List<SignUp> signupList = new ArrayList<SignUp>();

		  Connection con = null;
		  try {
			  String url="jdbc:sqlserver://CYG291;database=EmployeeManagementSystem";
		    	String user="sa";
		    	con = DriverManager.getConnection(url, user, "deepak");
		    	if(con != null) {
		    		Statement stmt = con.createStatement();
		    		String query1 = "SELECT * FROM SignUp";
		    		ResultSet rs = stmt.executeQuery(query1);
		    		while(rs.next())
		    		{	
		    			signupList.add(new SignUp(rs.getInt("Id"),rs.getString("Name"),rs.getString("EmailId"),rs.getString("Password")));
		    		}
		    	}
		  }
		  catch(Exception e) {
				e.printStackTrace();
		  }
		return signupList;
		
	  }
	
	
	  @RequestMapping(method = RequestMethod.PUT, value="/register/SignUp/{id}")  
	  @ResponseBody
	  public void PutSignUpTable(@RequestBody SignUp su, @PathVariable("id") String id) {
		  Connection con = null;
		  try {
			  String url="jdbc:sqlserver://CYG291;database=EmployeeManagementSystem";
		    	String user="sa";
		    	con = DriverManager.getConnection(url, user, "deepak");
		    	if(con != null) {
		    		Statement stmt = con.createStatement();
		    		String qry1="UPDATE SignUp SET Password = '" + su.getPassword()
		    		+ "', EmailId = '" + su.getEmailId() + "' WHERE Id = '" + id + "';";
		    	   
		    		stmt.execute(qry1);
		    	}
		  }
		  catch(Exception e) {
				e.printStackTrace();
		  }
		
	  }
	  
	  
	  @RequestMapping(method = RequestMethod.POST, value="/register/SignUp")  
	  @ResponseBody
	  public boolean postSignUpTable(@RequestBody SignUp su) {
		  Connection con;
			System.out.println("In retrieveStudentRecord");   

		  try {
			  String url="jdbc:sqlserver://CYG291;database=EmployeeManagementSystem";
		    	String user="sa";
		    	con = DriverManager.getConnection(url, user, "deepak");
		    	if(con != null) {
		    		Statement stmt = con.createStatement();
					System.out.println("In retrieveStudentRecord");   

		    		String qry1="INSERT INTO SignUp(Name, EmailId, Password) VALUES('" + su.getName() + "', '" +
		    					su.getEmailId() + "', '" + su.getPassword() + "');";
		    	   
		    		return stmt.execute(qry1);
		    	}
		  }
		  catch(Exception e) {
				e.printStackTrace();
		  }
		  
		return false;
		  
	  }
	  

	  @RequestMapping(method = RequestMethod.DELETE, value="/register/SignUp/{id}")  
	  @ResponseBody
	  public String deleteSignUp(@PathVariable("id") int id) {
			Connection con = null;
			try {
				String url="jdbc:sqlserver://CYG291;database=EmployeeManagementSystem";
		    	String user="sa";
		    	con = DriverManager.getConnection(url, user, "deepak");
		    	if(con!= null) {
		    		Statement stmt = con.createStatement();
		    		String qry1 = "DELETE FROM SignUp "
		    				+ "WHERE Id = " + id + "";
		    		stmt.execute(qry1);
		    		return "Deleted Successfully";
		    	}
			}
	    	catch(Exception e) {
	    		e.printStackTrace();
	    	}
	
			return "Delete un-successful";
	}  
}
	   
	  
	

