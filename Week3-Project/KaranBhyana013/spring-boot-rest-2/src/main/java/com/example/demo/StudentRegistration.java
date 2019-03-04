package com.example.demo;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;

public class StudentRegistration {
	private List<Student> studentRecords;
	    private static StudentRegistration stdregd = null;
	   /* public void dbconnect() {
	    	Connection conn = null;
			try {
				String dbURL="jdbc:sqlserver://DESKTOP-PE6EUGU;databaseName=test";
				String user ="sa";
				conn = DriverManager.getConnection(dbURL,user,"Password");
			if(conn!= null) {
				Statement stmt = conn.createStatement();
				/*stmt.execute("Drop Table students");
				String query = "CREATE TABLE students(id int NOT NULL IDENTITY(1,1) primary key, username varchar(50) UNIQUE  NOT NULL);";
				stmt.execute(query);
				String query1 = "insert into students Values('Karan');insert into students Values('Tatti Taran');";
				stmt.execute(query1);
				String query2 = "SELECT * FROM students;";
				ResultSet rs = stmt.executeQuery(query2);
				while(rs.next())
				{
					System.out.println(rs.getString("id")+" : " + rs.getString("username"));
					//System.out.println(rs.getString("Book_id")+" : " + rs.getString("Author")+" : "+ rs.getString("Book_name"));		
				}
				
			}
		 } catch (SQLException ex) {
			 ex.printStackTrace();
		 }finally {
			 /*try {
				 if(conn !=)
			 }
		 }
			
		}
	    */
	    private StudentRegistration(){
	    studentRecords = new ArrayList<Student>();
	    }
	    public static StudentRegistration getInstance() {
	        if(stdregd == null) {
	              stdregd = new StudentRegistration();
	              return stdregd;
	            }
	            else {
	                return stdregd;
	            }
	    }
	    public void add(Student std) {
	    studentRecords.add(std);
	    }
	public String upDateStudent(Student std) {
	for(int i=0; i<studentRecords.size(); i++)
	        {
	            Student stdn = studentRecords.get(i);
	            if(stdn.getRegistrationNumber().equals(std.getRegistrationNumber())) {
	              studentRecords.set(i, std);//update the new record
	              return "Update successful";
	            }
	        }
	return "Update un-successful";
	}
	public String deleteStudent(String registrationNumber) {
		Connection conn = null;
		try {
			String dbURL="jdbc:sqlserver://DESKTOP-PE6EUGU;databaseName=test";
			String user ="sa";
			conn = DriverManager.getConnection(dbURL,user,"Password");
		if(conn!= null) {
			Statement stmt = conn.createStatement();
			/*stmt.execute("Drop Table students");
			String query = "CREATE TABLE students(id int NOT NULL IDENTITY(1,1) primary key, username varchar(50) UNIQUE  NOT NULL);";
			stmt.execute(query);
			String query1 = "insert into students Values('Karan');insert into students Values('Tatti Taran');";
			stmt.execute(query1);
			String query2 = "SELECT * FROM students;";
			ResultSet rs = stmt.executeQuery(query2);
			while(rs.next())
			{
				System.out.println(rs.getString("id")+" : " + rs.getString("username"));
				//System.out.println(rs.getString("Book_id")+" : " + rs.getString("Author")+" : "+ rs.getString("Book_name"));		
			}
			*/
		}
	 } catch (SQLException ex) {
		 ex.printStackTrace();
	 }
		
	for(int i=0; i<studentRecords.size(); i++)
	        {
	            Student stdn = studentRecords.get(i);
	            if(stdn.getRegistrationNumber().equals(registrationNumber)){
	              studentRecords.remove(i);//update the new record
	              //stmt.execute("Drop Table students");
	              return "Delete successful";
	            }
	        }
	return "Delete un-successful";
	}
	    public List<Student> getStudentRecords() {
	    return studentRecords;
	    }

	    public static void main(String[] args) {
			Connection conn = null;
			try {
				String dbURL="jdbc:sqlserver://DESKTOP-PE6EUGU;databaseName=test";
				String user ="sa";
				conn = DriverManager.getConnection(dbURL,user,"Password");
			if(conn!= null) {
				Statement stmt = conn.createStatement();
				/*stmt.execute("Drop Table students");
				String query = "CREATE TABLE students(id int NOT NULL IDENTITY(1,1) primary key, username varchar(50) UNIQUE  NOT NULL);";
				stmt.execute(query);
				String query1 = "insert into students Values('Karan');insert into students Values('Tatti Taran');";
				stmt.execute(query1);
				String query2 = "SELECT * FROM students;";
				ResultSet rs = stmt.executeQuery(query2);
				while(rs.next())
				{
					System.out.println(rs.getString("id")+" : " + rs.getString("username"));
					//System.out.println(rs.getString("Book_id")+" : " + rs.getString("Author")+" : "+ rs.getString("Book_name"));		
				}
				*/
			}
		 } catch (SQLException ex) {
			 ex.printStackTrace();
		 }finally {
			 /*try {
				 if(conn !=)
			 }*/
		 }
			
		}
}
