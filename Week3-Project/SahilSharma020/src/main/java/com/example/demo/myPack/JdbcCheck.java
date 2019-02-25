package com.example.demo.myPack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcCheck {
	
	public void getEmployee(int id) {
		Connection conn = null;
		try {
			 conn = getConnection();
			if(conn != null ) {
				Statement stmt = conn.createStatement();
				//stmt.execute("Drop table PersonsTest ");
				//stmt.execute("Create table PersonsTest (id int, name varchar(20), age int); ");
				String SQL = "SELECT * from Employees where Id="+id+";";
				ResultSet rs = stmt.executeQuery(SQL);
				while(rs.next()) {
					System.out.println(rs.getString("Id") + ":" + rs.getString("Name") );
				}

				System.out.println("done");
			}
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}

	}

	public static Connection getConnection()
    {	
		Connection conn = null;
		try {
        String dbURL = "jdbc:sqlserver://DESKTOP-CH4H2QT; databaseName = CorporateLedger";
        String user = "sa";
         conn = DriverManager.getConnection(dbURL, user, "Sahil1234" );
		
		}
		finally {
			return conn;
		}
    }

	public static void addEmployee(){
        Connection conn = null;
        try {
        		conn = getConnection();
            if(conn != null ) {
                Statement stmt = conn.createStatement();
                String query1 = "INSERT INTO Employees VALUES ('Example1',21,'M',2);";
                stmt.execute(query1);
                String SQL = "SELECT * from Employees;";
                ResultSet rs = stmt.executeQuery(SQL);
//                while(rs.next()) {
//                    System.out.println(rs.getString("Id") + ":" + rs.getString("Name") );
//                }

                System.out.println("done");
            }
        }
        catch(SQLException ex) {
            ex.printStackTrace();
        }
    }
	
	
	public void deleteEmployee(String id){		
			Connection conn = null;
			try {
				System.out.println("KUCH BHHI");
		    String dbURL = "jdbc:sqlserver://DESKTOP-DM3ONQI; databaseName = CorporateLedger";
		    String user = "sa";
		     conn = DriverManager.getConnection(dbURL, user, "password" );
		            if(conn != null ) {
		                Statement stmt = conn.createStatement();
		                System.out.println("We reached here");
		                String query1 = "DELETE FROM Employees WHERE Id="+id+";";
		                stmt.execute(query1);
//		                String SQL = "delete from Employees where Id="+id+";";
//		                ResultSet rs = stmt.executeQuery(SQL);
//		                while(rs.next()) {
//		                    System.out.println(rs.getString("Id") + ":" + rs.getString("Name") );
//		                }

		                
		                
		            }
		        }
		        catch(SQLException ex) {
		            ex.printStackTrace();
		        }
			
		    }
			
	
	public void updateEmployee(String name,int age,char gender,int designationId,int id){
        Connection conn = null;
        try {
        		conn = getConnection();
            if(conn != null ) {
                Statement stmt = conn.createStatement();
                String query1 = "update Employees set Age="+age+"Gender="+gender+"DesignationId="+designationId+"where Id="+id+";";
                stmt.execute(query1);
//                String SQL = "delete from Employees where Id="+id+";";
//                ResultSet rs = stmt.executeQuery(SQL);
//                while(rs.next()) {
//                System.out.println(rs.getString("Id") + ":" + rs.getString("Name") );
//                }
                System.out.println(" Deleted Id "+id);
            }
        }
        catch(SQLException ex) {
            ex.printStackTrace();
        }
    }
}