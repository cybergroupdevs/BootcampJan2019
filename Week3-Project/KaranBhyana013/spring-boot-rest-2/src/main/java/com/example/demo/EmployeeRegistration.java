package com.example.demo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;


public class EmployeeRegistration {

		private List<Employee> EmployeeRecords;
		private static EmployeeRegistration stdregd = null;
		    private EmployeeRegistration(){
		    
			Connection conn = null;
			try {
		//		 Class.forName("com.mysql.jdbc.Driver");
				String dbURL="jdbc:sqlserver://DESKTOP-PE6EUGU;databaseName=test";
				String user ="sa";
				conn = DriverManager.getConnection(dbURL,user,"Password");
			if(conn!= null) {
				Statement stmt = conn.createStatement();
				stmt.execute("use Week1project;");
				String query2 = "SELECT * FROM employees ";
				ResultSet rs = stmt.executeQuery(query2);
				if(rs != null)
				{EmployeeRecords = new ArrayList<Employee>();
				while(rs.next())
				{	Employee e = new Employee();
					e.setId(rs.getInt("Id"));
					e.setAge(rs.getInt("Age"));
					e.setName(rs.getString("name"));
					e.setEmail(rs.getString("Email"));
					e.setPhone(rs.getString("Phone"));
					e.setGender(rs.getString("Gender"));
					e.setDesignationID(rs.getInt("DesignationID"));
					System.out.println(rs.getString("Id")+" : " + rs.getString("name"));
					EmployeeRecords.add(e);
				}
				}
				else
					EmployeeRecords = new ArrayList<Employee>();
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
		    
		    
		    public static EmployeeRegistration getInstance() {
		        if(stdregd == null) {
		              stdregd = new EmployeeRegistration();
		              return stdregd;
		            }
		            else {
		                return stdregd;
		            }
		    }
		    
		    
		    public int add(Employee std) {
		    	int p = -1;
		    	Connection conn = null;
				try {
					String dbURL="jdbc:sqlserver://DESKTOP-PE6EUGU;databaseName=test";
					String user ="sa";
					conn = DriverManager.getConnection(dbURL,user,"Password");
				if(conn!= null) {
					Statement stmt = conn.createStatement();
					stmt.execute("use Week1project;");
					stmt.execute("insert into employees Values('"+std.Name+"','"+std.Email+"',"+ std.Age+",'"+std.Gender+"','"+std.Phone+"',"+std.DesignationID+");");
					ResultSet rs = stmt.executeQuery("select Id from Employees where Name ='"+std.Name+"' AND Age='"+std.Age+"' AND Gender= '"+std.Gender+"' AND DesignationID='"+std.DesignationID+"'AND Email='"+std.Email+"'AND Phone='"+std.Phone+"';");
					while(rs.next()) {
						p = rs.getInt("Id");
					std.setId(rs.getInt("Id"));
					}
					EmployeeRecords.add(std);
					return p;
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
		    return 0;
		    }
		    
		    
		    
		public String upDateEmployee(int id ,Employee std) {
			Connection conn = null;
			try {
				String dbURL="jdbc:sqlserver://DESKTOP-PE6EUGU;databaseName=test";
				String user ="sa";
				conn = DriverManager.getConnection(dbURL,user,"Password");
			if(conn!= null) {
				Statement stmt = conn.createStatement();
				stmt.execute("use Week1project;");
				for(int i=0; i<EmployeeRecords.size(); i++)
		        {
		            Employee stdn = EmployeeRecords.get(i);
		            if(stdn.getId() == (id)) {
		              EmployeeRecords.set(i, std);//update the new record
		              stmt.execute("Update Employees\r\n" + 
		              		"set DesignationID ="+std.getDesignationID()+", Name = '"+ std.getName()+"', Age ="+std.getAge()+" , Gender ='"+std.getGender()+"', Email = '"+std.getEmail()+"', Phone = '"+std.getPhone()+"'\r\n" + 
		              		"where Id = "+  id +";");
		              return "Update successful";
		            }
		        }
				//stmt.execute("Delete from Employee where Id = "+  Id);
				/*stmt.execute("Drop Table Employees");
				String query = "CREATE TABLE Employees(id int NOT NULL IDENTITY(1,1) primary key, username varchar(50) UNIQUE  NOT NULL);";
				stmt.execute(query);
				String query1 = "insert into Employees Values('Karan');insert into Employees Values('Tatti Taran');";
				stmt.execute(query1);
				String query2 = "SELECT * FROM Employees;";
				ResultSet rs = stmt.executeQuery(query2);
				while(rs.next())
				{
					System.out.println(rs.getString("id")+" : " + rs.getString("username"));
					//System.out.println(rs.getString("Book_id")+" : " + rs.getString("Author")+" : "+ rs.getString("Book_name"));		
				}
				*/
			}
		 } catch (SQLException ex) {
			 ex.printStackTrace();
			 return "Update un-successful";
		 }finally {
			 if (conn != null) {
			        try {
					            conn.close();
					    } catch (SQLException e) {}
					}
				 }	
		
		return "Update un-successful";
		}
		
		public String deleteEmployee(int Id) {
			Connection conn = null;
			try {
				String dbURL="jdbc:sqlserver://DESKTOP-PE6EUGU;databaseName=test";
				String user ="sa";
				conn = DriverManager.getConnection(dbURL,user,"Password");
			if(conn!= null) {
				Statement stmt = conn.createStatement();
				stmt.execute("use Week1project;");
				stmt.execute("Delete from Employees where Id = "+  Id);
				for(int i=0; i<EmployeeRecords.size(); i++)
		        {
		            Employee stdn = EmployeeRecords.get(i);
		            if(stdn.getId() == (Id)){
		              EmployeeRecords.remove(i);//update the new record
		              //stmt.execute("Drop Table Employees");
		              //return "Delete successful";
		            }
		        }
				return "Delete successful";
				/*stmt.execute("Drop Table Employees");
				String query = "CREATE TABLE Employees(id int NOT NULL IDENTITY(1,1) primary key, username varchar(50) UNIQUE  NOT NULL);";
				stmt.execute(query);
				String query1 = "insert into Employees Values('Karan');insert into Employees Values('Tatti Taran');";
				stmt.execute(query1);
				String query2 = "SELECT * FROM Employees;";
				ResultSet rs = stmt.executeQuery(query2);
				while(rs.next())
				{
					System.out.println(rs.getString("id")+" : " + rs.getString("username"));
					//System.out.println(rs.getString("Book_id")+" : " + rs.getString("Author")+" : "+ rs.getString("Book_name"));		
				}
				*/
			}
		 } catch (SQLException ex) {
			 ex.printStackTrace();
			 return "Delete un-successful";
		 }finally {
			 if (conn != null) {
			        try {
					            conn.close();
					    } catch (SQLException e) {}
					}
				 }	
		
			return "Delete un-sucessful";
				
		}
		    public List<Employee> getEmployeeRecords() {
		    	Connection conn = null;
				try {
			//		 Class.forName("com.mysql.jdbc.Driver");
					String dbURL="jdbc:sqlserver://DESKTOP-PE6EUGU;databaseName=test";
					String user ="sa";
					conn = DriverManager.getConnection(dbURL,user,"Password");
				if(conn!= null) {
					Statement stmt = conn.createStatement();
					stmt.execute("use Week1project;");
					String query2 = "SELECT * FROM employees ";
					ResultSet rs = stmt.executeQuery(query2);
					
					{EmployeeRecords = new ArrayList<Employee>();
					while(rs.next())
					{	Employee e = new Employee();
						e.setId(rs.getInt("Id"));
						e.setAge(rs.getInt("Age"));
						e.setName(rs.getString("Name"));
						e.setEmail(rs.getString("Email"));
						e.setPhone(rs.getString("Phone"));
						e.setGender(rs.getString("Gender"));
						e.setDesignationID(rs.getInt("DesignationID"));
						System.out.println(rs.getString("Id")+" : " + rs.getString("Name"));
						EmployeeRecords.add(e);
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
		    return EmployeeRecords;
		    }
		    
		    
		    public List<Employee> getEmployeeRecords(int id) {
		    	Connection conn = null;
				try {
			//		 Class.forName("com.mysql.jdbc.Driver");
					String dbURL="jdbc:sqlserver://DESKTOP-PE6EUGU;databaseName=test";
					String user ="sa";
					conn = DriverManager.getConnection(dbURL,user,"Password");
				if(conn!= null) {
					Statement stmt = conn.createStatement();
					stmt.execute("use Week1project;");
					String query2 = "SELECT * FROM employees where id = "+ id;
					ResultSet rs = stmt.executeQuery(query2);
					
					{EmployeeRecords = new ArrayList<Employee>();
					while(rs.next())
					{	Employee e = new Employee();
						e.setId(rs.getInt("Id"));
						e.setAge(rs.getInt("Age"));
						e.setName(rs.getString("name"));
						e.setEmail(rs.getString("Email"));
						e.setPhone(rs.getString("Phone"));
						e.setGender(rs.getString("Gender"));
						e.setDesignationID(rs.getInt("DesignationID"));
						System.out.println(rs.getString("Id")+" : " + rs.getString("name"));
						EmployeeRecords.add(e);
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
		    return EmployeeRecords;
		    }


	}


