package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class JdbcTry {
	
	public static void main(String[] args) {
		Connection conn = null;
		try {
			String name = "sahil";
			int id = 2,age =22;
			String dbURL = "jdbc:sqlserver://DESKTOP-NP793MF; databaseName = Database1";
			String user = "sa";
			conn = DriverManager.getConnection(dbURL, user, "P@ssw0rd" );
			if(conn != null ) {
				Statement stmt = conn.createStatement();
				stmt.execute("Drop table PersonsTest ");
				stmt.execute("Create table PersonsTest (id int, name varchar(20), age int); ");
				String query1 = "INSERT INTO PERSONSTEST VALUES (1,'Taran',21);";
				String query2 = "INSERT INTO PERSONSTEST VALUES ("+ id + ", \'"+ name +"\'"+ "," + age + ");" ;
				stmt.execute(query1);
				stmt.execute(query2);
				String SQL = "SELECT * from Personstest;";
				ResultSet rs = stmt.executeQuery(SQL);
				while(rs.next()) {
					System.out.println(rs.getInt("id") + "," + rs.getString("name")+ "," + rs.getInt("DesignationId") );
				}
				
				System.out.println("done");
			}
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
}
 