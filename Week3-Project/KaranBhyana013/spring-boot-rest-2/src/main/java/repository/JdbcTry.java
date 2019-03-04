package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcTry {

	public static void main(String[] args) {
		int id=6;
		Connection conn = null;
		try {
			String dbURL="jdbc:sqlserver://DESKTOP-PE6EUGU;databaseName=test";
			String user ="sa";
			conn = DriverManager.getConnection(dbURL,user,"Password");
		if(conn!= null) {
			Statement stmt = conn.createStatement();
			stmt.execute("use CorporateLedger;");
			//stmt.execute("Delete from Employees where Id = "+  id);
			/*
			 * String query = "CREATE TABLE students(id int NOT NULL IDENTITY(1,1) primary key, name varchar(50) UNIQUE  NOT NULL, age int NOT NULL);";
			stmt.execute(query);
			String query1 = "insert into students Values('Karan');insert into students Values('Tatti Taran');";
			stmt.execute(query1);
			*/
			String query2 = "SELECT * FROM employees" ;
			ResultSet rs = stmt.executeQuery(query2);
			//while(rs.next())
			{
				System.out.println(rs.getString("Id")+" : " + rs.getString("name"));
				//System.out.println(rs.getString("Book_id")+" : " + rs.getString("Author")+" : "+ rs.getString("Book_name"));		
			}
			
		}
	 } catch (SQLException ex) {
		 ex.printStackTrace();
	 }finally {
		 if (conn != null) {
        try {
		            conn.close();
		    } catch (SQLException e) {}
		}
	 }
		
	}
}
