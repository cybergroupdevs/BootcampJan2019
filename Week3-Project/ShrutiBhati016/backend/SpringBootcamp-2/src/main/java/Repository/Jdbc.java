package Repository;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;



public class Jdbc {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			String dbURL = "Jdbc:sqlserver://CYG343; databaseName=Cybergroup";
					String user = "sa";
			conn = DriverManager.getConnection(dbURL, user , "Sbhati@96" );
			if (conn !=null) {
				Statement stmt = conn.createStatement();
				stmt.execute("DROP TABLE Employees");
				String query = "CREATE TABLE PersonTest (\r\n" +
				"PersonId int, \r\n " + ");";
				String query2= "INSERT INTO PersonTEST VALUES ('123');";
			stmt.execute(query);
			stmt.execute(query2);
				String SQL = "SELECT * FROM PersonTEST";
				ResultSet rs =stmt.executeQuery(SQL);
				while (rs.next()) {
					System.out.println(rs.getString("PersonId"));
				}
			}
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
			}
			catch(SQLException ex) {
				ex.printStackTrace();
			}
		}
	}
}
