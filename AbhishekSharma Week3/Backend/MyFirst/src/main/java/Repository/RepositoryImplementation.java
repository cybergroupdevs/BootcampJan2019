package Repository;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RepositoryImplementation {

	public static void main(String[] args)
	{
		Connection conn=null;
		try {
			String dbURL="jdbc:sqlserver://DESKTOP-95D75UP;databaseName=HRMS";
					String user="sa";
			conn=DriverManager.getConnection(dbURL,user,"Abhishek");
			if(conn!=null)
			{
				Statement stmt=conn.createStatement();
				
				
				
				String query1="create table PersonsTest1(\r\n"+
						"PersonID int,\r\n" +
								"LastName varchar(255),\r\n" +
						"FirstName varchar(255),\r\n" +
								"Address varchar(255),\r\n"+
						"City varchar(255),\r\n" +
								");";
						
						
				stmt.execute(query1);
						String query2="Insert Into PersonsTest1 values('123','Sharma','Abhishek','ABC Colony','Delhi')";
						stmt.execute(query2);
						String SQL="select * from PersonsTest1;";
						ResultSet rs=stmt.executeQuery(SQL);
						while(rs.next())
						{
							System.out.println(rs.getString("PersonID")+":"+ rs.getString("FirstName")+rs.getString("LastName"));
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
		    } 
		    catch (SQLException e) {
		     // TODO Auto-generated catch block
		     e.printStackTrace();
		    }
		   }
		  }
		 
	}
}

