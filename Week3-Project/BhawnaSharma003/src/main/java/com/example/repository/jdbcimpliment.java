package com.example.repository;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbcimpliment {
	public static void main(String[] args)
	{
		Connection conn = null;
		System.out.println("123");
		try {
			String dbURL = "jdbc:sqlserver://DESKTOP-8SSRL3P;databaseName=Student";
			
			
			
			conn = DriverManager.getConnection(dbURL,"sa","Bhawna220@");
			if(conn!=null) {
				Statement stmt = conn.createStatement();
				stmt.execute("DROP TABLE PersonTest");
				String query = "CREATE TABLE PersonTest(\r\n"+
				      "PersonID int,\r\n" +
					  " LastName varchar(255),\r\n "+
					  " FirstName varchar(50),\r\n "+
					  "Address varchar(255),\r\n"+
					  "City varchar(30)\r\n"+
					  ");";
				stmt.execute(query);
				String query2="Insert into PersonTest values('123','Sharma','Bhawna','Pitampura','Delhi');";
				stmt.execute(query2);
				String sql ="Select * from PersonTest";
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()) {
					System.out.println(rs.getString("PersonID")+":"+rs.getString("FirstName")+":"+rs.getString("LastName")+":");
					
				}
				      
			}
			
		}
		catch(Exception se) {
			se.printStackTrace();
		}
		finally {
			if(conn!=null) {
				try {
				conn.close();
				}catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

}
