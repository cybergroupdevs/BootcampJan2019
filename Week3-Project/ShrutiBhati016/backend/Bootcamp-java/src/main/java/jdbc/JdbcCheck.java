package jdbc;

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
        String dbURL = "jdbc:sqlserver://CYG343; databaseName = Week3";
        String user = "sa";
         conn = DriverManager.getConnection(dbURL, user, "Shruti" );
		
		}
		finally {
			return conn;
		}
    }

	public static void addEmployee(int Id,String FirstName,String LastName,int Age,String Email,String Designation,String Phone){
        Connection conn = null;
        try {
        		conn = getConnection();
            if(conn != null ) {
                Statement stmt = conn.createStatement();
                String query1 = "EXEC NewEmployee '"+FirstName+"','"+LastName+"','"+Age+"','"+Email+"','"+Designation+"','"+Phone+"';";
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
	
	
	public void deleteEmployee(String Id){		
			Connection conn = null;
			try {
		    String dbURL = "jdbc:sqlserver://CYG343; databaseName = Week3";
		    String user = "sa";
		     conn = DriverManager.getConnection(dbURL, user, "password" );
		            if(conn != null ) {
		                Statement stmt = conn.createStatement();
		                System.out.println("hello");
		                String query1 = "Exec DeleteEmployee "+Id+";";
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
			
	
	public void updateEmployee(int Id,String FirstName,String LastName,int Age,String Email,String Designation,String Phone){
        Connection conn = null;
        try {
        		conn = getConnection();
            if(conn != null ) {
                Statement stmt = conn.createStatement();
                String query1 = "Exec UpdateData '"+FirstName+"','"+LastName+"','"+Age+"','"+Email+"','"+Designation+"','"+Phone+"';";
                stmt.execute(query1);
                System.out.println(" Updated Id "+Id);
            }
        }
        catch(SQLException ex) {
            ex.printStackTrace();
        }
    }
}