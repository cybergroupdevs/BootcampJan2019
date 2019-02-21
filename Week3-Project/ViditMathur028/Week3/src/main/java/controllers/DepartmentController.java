package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.Department;

@Controller
public class DepartmentController {
	@RequestMapping(method = RequestMethod.DELETE, value="/Departments/{id}")
	@ResponseBody
	public void DeleteDep(@RequestBody  String id) {
		Connection con;
			try {
				String dbURL = "jdbc:sqlserver://DESKTOP-48ID06J\\SQLEXPRESS;database=Corporate";
				String user = "sa";
				con = DriverManager.getConnection(dbURL, user, "password");
				if(con != null) {
					Statement stmt = con.createStatement();
					String query = "delete from Department where Id='"+id;
					stmt.execute(query);
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
	}
	@RequestMapping(method = RequestMethod.POST, value="/Departments")
	@ResponseBody
	public void AddDep(@RequestBody Department dep) {
		Connection con;
			try {
				String dbURL = "jdbc:sqlserver://DESKTOP-48ID06J\\SQLEXPRESS;database=Corporate";
				String user = "sa";
				con = DriverManager.getConnection(dbURL, user, "password");
				if(con != null) {
					Statement stmt = con.createStatement();
					String query = "insert into Department values('"+dep.getId()+"','"+dep.getName()+"')";
					stmt.execute(query);
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
				
	
	}
	@RequestMapping(method = RequestMethod.PUT, value="/Departments/{id}")
	@ResponseBody
	public void UpdateDep(@RequestBody Department dep, String id) {
		Connection con;
			try {
				String dbURL = "jdbc:sqlserver://DESKTOP-48ID06J\\SQLEXPRESS;database=Corporate";
				String user = "sa";
				con = DriverManager.getConnection(dbURL, user, "password");
				if(con != null) {
					Statement stmt = con.createStatement();
					String query = "update Department set Name = '"+dep.getName()+"'where Id ="+ id+";";
					stmt.execute(query);
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
	}
	@RequestMapping(method= RequestMethod.GET, value="/Departments")
	@ResponseBody
	public List<Department> getdepartments(){
		Connection con;
		List<Department> DepartmentList= new ArrayList<Department>();
		ResultSet rs = null;
			try {
				String dbURL = "jdbc:sqlserver://DESKTOP-48ID06J\\SQLEXPRESS;database=Corporate";
				String user = "sa";
				con = DriverManager.getConnection(dbURL, user, "password");
				if(con != null) {
					Statement stmt = con.createStatement();
					String query5 = "select * from Department";
					rs=stmt.executeQuery(query5);
					while(rs.next())
					{
						DepartmentList.add(new Department(rs.getInt("ID"),rs.getString("Name"))); 
					}
					return DepartmentList;
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			return DepartmentList;
		}
		
	@RequestMapping(method= RequestMethod.GET, value="/Departments/{id}")
	@ResponseBody
	public Department getDepartmentById(int id){
		Connection con;
		Department dep= new Department();
		ResultSet rs = null;
		try {
			String dbURL = "jdbc:sqlserver://DESKTOP-48ID06J\\SQLEXPRESS;database=Corporate";
			String user = "sa";
			con = DriverManager.getConnection(dbURL, user, "password");
			if(con != null) {
				Statement stmt = con.createStatement();
				String query5 = "select * from Department where Id="+id;
				rs=stmt.executeQuery(query5);
				while(rs.next())
				{
					dep.setId(rs.getInt("Id"));
					dep.setName(rs.getString("Name")); 
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return dep;
	}
	
	
	
}
