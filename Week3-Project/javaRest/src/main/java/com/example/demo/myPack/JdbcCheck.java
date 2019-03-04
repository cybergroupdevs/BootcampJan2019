package com.example.demo.myPack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcCheck {
	
	
	public static Connection getConnection()
    {	
		Connection conn = null;
		try {
        String dbURL = "jdbc:sqlserver://DESKTOP-DM3ONQI; databaseName = CorporateLedger";
        String user = "sa";
         conn = DriverManager.getConnection(dbURL, user, "password" );
		
		}
		finally {
			return conn;
		}
    }

	
	
}