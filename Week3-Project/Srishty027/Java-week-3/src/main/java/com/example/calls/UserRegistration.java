package com.example.calls;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UserRegistration {
	
	private static UserRegistration stdregd = null;
    private UserRegistration(){
    new ArrayList<User>();
    }
    public static UserRegistration getInstance() {
        if(stdregd == null) {
              stdregd = new UserRegistration();
              return stdregd;
            }
            else {
                return stdregd;
            }
    }

    public static String addDetail() {
    	Connection conn = null;
		try {
			String dbURL = "jdbc:sqlserver://DESKTOP-KJITFFA;databaseName=JavaProject";
			String  user = "sa";
			
			conn = DriverManager.getConnection(dbURL,user,"srishty");
			if(conn != null) {
				Statement stmt = (Statement) conn.createStatement();
				
				String query1 = "INSERT INTO User VALUES(1,'Srishty','abc')";
				stmt.execute(query1);
				String SQL = "SELECT * FROM PersonTest;";
				ResultSet rs = stmt.executeQuery(SQL);
				while(rs.next()) {
					System.out.println(rs.getString("ID")+":" + rs.getString("Username"));
				}
				
			}
			
		} catch(SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
			}catch(SQLException ex) {
				ex.printStackTrace();
			}
		}
		return "Updated";
    }
    public static void getDetails() {
    	Connection conn = null;
		try {
			String dbURL = "jdbc:sqlserver://DESKTOP-KJITFFA;databaseName=JavaProject";
			String  user = "sa";
			
			conn = DriverManager.getConnection(dbURL,user,"srishty");
			if(conn != null) {
				Statement stmt = (Statement) conn.createStatement();
				

				String SQL = "SELECT * FROM PersonTest;";
				ResultSet rs = stmt.executeQuery(SQL);
				while(rs.next()) {
					System.out.println(rs.getString("ID")+":" + rs.getString("Username"));
				}
				
			}
			
		} catch(SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
			}catch(SQLException ex) {
				ex.printStackTrace();
			}
		}
    }
    	
    }



