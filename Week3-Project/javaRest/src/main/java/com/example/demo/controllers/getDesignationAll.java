package com.example.demo.controllers;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.demo.beans.*;
import com.example.demo.myPack.*;
import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin(origins = "*")
@Controller
public class getDesignationAll {
  @RequestMapping(method = RequestMethod.GET, value="/DesignationAll")
  @ResponseBody
  public List<Designation> getAllDesignation() {
  
	   
	   List<Designation> degList= new ArrayList<Designation>();
		
		Connection conn = null;
		try {
			conn = JdbcCheck.getConnection();
			if(conn != null ) {
				Statement stmt = conn.createStatement();
				//stmt.execute("Drop table PersonsTest ");
				//stmt.execute("Create table PersonsTest (id int, name varchar(20), age int); ");
				String SQL = "SELECT * from Designations";
				ResultSet rs = stmt.executeQuery(SQL);
				while(rs.next()) {
					Designation deg= new Designation();
					deg.setId(rs.getInt("Id"));
					deg.setName(rs.getString("Name"));
					degList.add(deg);
				}

				System.out.println("done");
			}
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}

		return degList;
  
  }
}