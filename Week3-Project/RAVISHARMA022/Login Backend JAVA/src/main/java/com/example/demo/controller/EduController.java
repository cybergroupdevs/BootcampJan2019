package com.example.demo.controller;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.Repository.EmpRepository;
import com.example.demo.EmployeeDetail.EducationDetail;
import com.example.demo.EmployeeDetail.EmployeeDetail;

@RestController
public class EduController {
	
	//GetApi for All Users
	@GetMapping("/EducationDetail")
	public List<EducationDetail> index2(){
		Connection con;
		List<EducationDetail> Employees = new ArrayList<EducationDetail>();
		ResultSet rs = null;
		try {
			String dbURL = "jdbc:sqlserver://DESKTOP-4EEOQT3;database=LoginSystem";
			String user = "sa";
			con = DriverManager.getConnection(dbURL, user, "12345");
			if(con != null) {
				Statement stmt = con.createStatement();
				String queryforallusers = "select * from EducationDetail";
				rs=stmt.executeQuery(queryforallusers);
				while(rs.next())
				{
					Employees.add(new EducationDetail(rs.getString("Id"),rs.getString("TenthBoard"),
						rs.getFloat("Tenthmarks"),rs.getString("Twelfthboard"),rs.getFloat("Twelfthmarks"),
						rs.getString("GraduationDegree"),rs.getFloat("GraduationMarks")
						)); 
				}
				return Employees;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}	
		return Employees;
	}

	//GetApi for Single User Details
	@GetMapping("/EducationDetail/{Id}")
	public List<EducationDetail> index3(@PathVariable String Id){
		Connection con;
		List<EducationDetail> Employees = new ArrayList<EducationDetail>();
		ResultSet rs = null;
		try {
			String dbURL = "jdbc:sqlserver://DESKTOP-4EEOQT3;database=LoginSystem";
			String user = "sa";
			con = DriverManager.getConnection(dbURL, user, "12345");
			if(con != null) {
				Statement stmt = con.createStatement();
				String queryforoneuser = "select * from EducationDetail where Id="+Id;
				rs=stmt.executeQuery(queryforoneuser);
				while(rs.next())
				{
					Employees.add(new EducationDetail(rs.getString("Id"),rs.getString("TenthBoard"),
							rs.getFloat("Tenthmarks"),rs.getString("Twelfthboard"),rs.getFloat("Twelfthmarks"),
							rs.getString("GraduationDegree"),rs.getFloat("GraduationMarks")
							)); 
					}
				return Employees;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}	
		return Employees;
	}
	
	//DeleteApi for EducationDetail
	@RequestMapping(method=RequestMethod.DELETE, value="/EducationDetail/{Id}")
	public void deleteEducation(@PathVariable String id) {
		
		Connection con;
		try {
			String dbURL = "jdbc:sqlserver://DESKTOP-4EEOQT3;database=LoginSystem";
			String userdata = "sa";
			con = DriverManager.getConnection(dbURL, userdata, "12345");
			if(con != null) {
				Statement stmt = con.createStatement();
				String query = "delete from EducationDetail where Id ="+ id;
				stmt.execute(query);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//CreateApi for EducationDetail
	@RequestMapping(method=RequestMethod.POST, value="/EducationDetail")
	public void createEducationDetail(@RequestBody EducationDetail user,  @PathVariable String Id) {
		
		Connection con;
		try {
			String dbURL = "jdbc:sqlserver://DESKTOP-4EEOQT3;database=LoginSystem";
			String userdata = "sa";
			con = DriverManager.getConnection(dbURL, userdata, "12345");
			if(con != null) {
				Statement stmt = con.createStatement();
				String query = "insert into EducationDetail values('"+EducationDetail.getId()+"','"+EducationDetail.getTenthboard()+"',Tenthmarks='"+EducationDetail.getTenthmarks()+"',Twelfthboard='"+EducationDetail.getTwelfthboard()+"',Twelfthmarks='"+EducationDetail.Twelfthmarks()+"',GraduationDegree='"+EducationDetail.getGraduationdegree()+"',GraduationMarks='"+EducationDetail.getGraduationmarks()+"');";
				stmt.execute(query);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//UpdateApi for EducationDetail
	@RequestMapping(method=RequestMethod.PUT, value="/EducationDetail/{Id}")
	public void updateEducationDetail(@RequestBody EmployeeDetail user, @PathVariable String Id) {
		
		Connection con;
		try {
			String dbURL = "jdbc:sqlserver://DESKTOP-4EEOQT3;database=LoginSystem";
			String userdata = "sa";
			con = DriverManager.getConnection(dbURL, userdata, "12345");
			if(con != null) {
				Statement stmt = con.createStatement();
				String query = "update EducationDetail set TenthBoard = '"+EducationDetail.getTenthboard()+"',Tenthmarks='"+EducationDetail.getTenthmarks()+"',Twelfthboard='"+EducationDetail.getTwelfthboard()+"',Twelfthmarks='"+EducationDetail.Twelfthmarks()+"',GraduationDegree='"+EducationDetail.getGraduationdegree()+"',GraduationMarks='"+EducationDetail.getGraduationmarks()+"' where Id = "+Id;
				stmt.execute(query);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
}
