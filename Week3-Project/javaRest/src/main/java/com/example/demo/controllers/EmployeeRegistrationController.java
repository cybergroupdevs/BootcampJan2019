package com.example.demo.controllers;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.demo.beans.*;
import com.example.demo.myPack.*;
import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin(origins = "*")
@Controller
public class EmployeeRegistrationController {
  @RequestMapping(method = RequestMethod.POST, value="/register/Employee")
  @ResponseBody
  public static void registerEmployee(@RequestBody Employee emp) {
  System.out.println("In registerEmployee");
  
   //  JdbcCheck.addEmployee();  this works
  
  
  Connection conn = null;
//try {
//	  conn = JdbcCheck.getConnection();
//    if(conn != null ) {
//        Statement stmt = conn.createStatement();
//        String query1 = "INSERT INTO Employees VALUES (3,'Example3',21,'M',2);";
//        stmt.execute(query1);
//        String SQL = "SELECT * from Employees;";
//        ResultSet rs = stmt.executeQuery(SQL);
////        while(rs.next()) {
////            System.out.println(rs.getString("Id") + ":" + rs.getString("Name") );
////        }
//
//        System.out.println("done");
//    }
//}
//catch(SQLException ex) {
//    ex.printStackTrace();
//}
  
  
  
   
  	  System.out.println("Reached Here");
    
      try {
    	  conn = JdbcCheck.getConnection();
          if(conn != null ) {
              Statement stmt = conn.createStatement();
              String query1 = "INSERT INTO Employees VALUES ('"
            		  +emp.getName()
            		  +"',"
            		  +emp.getAge()
            		  +",'"
            		  +emp.getGender()
            		  +"',"
            		  +emp.getDesignationId()
            		  +");";
              
              stmt.execute(query1);
              String SQL = "SELECT * from Employees;";
              ResultSet rs = stmt.executeQuery(SQL);
//              while(rs.next()) {
//                  System.out.println(rs.getString("Id") + ":" + rs.getString("Name") );
//              }

              System.out.println("done");
          }
      }
      catch(SQLException ex) {
          ex.printStackTrace();
      }
  
	
  
  
  
  
  
 
//        EmployeeRegistrationReply stdregreply = new EmployeeRegistrationReply();           
//        EmployeeRegistration.getInstance().add(emp);
//        //We are setting the below value just to reply a message back to the caller
//        stdregreply.setName(emp.getName());
//        stdregreply.setAge(emp.getAge());
//        stdregreply.setGender(emp.getGender());
//        stdregreply.setDesignationId(emp.getDesignationId());
//        stdregreply.setRegistrationStatus("Successful");
//        return stdregreply;
        
}
}