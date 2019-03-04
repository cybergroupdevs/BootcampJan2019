package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DesignationRegistration {
	private List<Designation> DesignationRecords;
    private static DesignationRegistration stdregd = null;
    private DesignationRegistration(){
    DesignationRecords = new ArrayList<Designation>();
    }
    public static DesignationRegistration getInstance() {
        if(stdregd == null) {
              stdregd = new DesignationRegistration();
              return stdregd;
            }
            else {
                return stdregd;
            }
    }
    public List<Designation> getDesignationRecords() {
    	Connection conn = null;
		try {
	//		 Class.forName("com.mysql.jdbc.Driver");
			String dbURL="jdbc:sqlserver://DESKTOP-PE6EUGU;databaseName=test";
			String user ="sa";
			conn = DriverManager.getConnection(dbURL,user,"Password");
		if(conn!= null) {
			Statement stmt = conn.createStatement();
			stmt.execute("use Week1project;");
			String query2 = "SELECT * FROM Designations ";
			ResultSet rs = stmt.executeQuery(query2);
			
			{DesignationRecords = new ArrayList<Designation>();
			while(rs.next())
			{	Designation e = new Designation();
				e.setId(rs.getInt("Id"));
				e.setName(rs.getString("name"));
				System.out.println(rs.getString("Id")+" : " + rs.getString("name"));
				DesignationRecords.add(e);
			}
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
    return DesignationRecords;
    }
}
