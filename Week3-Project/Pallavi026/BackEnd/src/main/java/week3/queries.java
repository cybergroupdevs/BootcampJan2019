package week3;

//import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class queries {

  public static void main(String[] args) {
      // TODO Auto-generated method stub
      Connection conn = null;
      try {
          String dbURL = "jdbc:sqlserver://CYG255;databaseName=week3";
          String  user = "sa";
          
          conn = DriverManager.getConnection(dbURL,user,"cyber9198");
          if(conn != null) {
              Statement stmt = (Statement) conn.createStatement();
//              stmt.execute("DROP TABLE Hello");
//              String query = "CREATE TABLE PersonTest (\r\n" +
//                              "PersonID int,\r\n " +
//                              "LastName varchar(20),\r\n" +
//                              "FirstName varchar(20),\r\n" +
//                              "City varchar(20) \r\n" +
//                              ");";
//              stmt.execute(query);
//              String query2 = "INSERT INTO Designation VALUES(01,'Intern')";
//              stmt.execute(query2);
              String query1 = "INSERT INTO Designation VALUES(02,'Manager')";
              stmt.execute(query1);
              String SQL = "SELECT * FROM Designation;";
              ResultSet rs = stmt.executeQuery(SQL);
              while(rs.next()) {
                  System.out.println(rs.getString("ID")+":" + rs.getString("Name"));
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