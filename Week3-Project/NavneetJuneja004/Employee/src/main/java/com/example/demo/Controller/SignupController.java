package com.example.demo.Controller;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Signup;

@RestController
public class SignupController {
	
	

	//GetApi for Single User Details 
	@RequestMapping(method=RequestMethod.GET, value="/Signup/{id}")
	//@GetMapping("/Signup/{Id}")
	public List<Signup> index3(@PathVariable String Id){
		Connection con;
		List<Signup> Employees = new ArrayList<Signup>();
		ResultSet rs = null;
		try {
			String dbURL = "jdbc:sqlserver://DESKTOP-8GLKVBG;database=CorporateLedger";
			String user = "sa";
			con = DriverManager.getConnection(dbURL, user, "godisgreat84");
			if(con != null) {
				Statement stmt = con.createStatement();
				String queryforoneuser = "select * from SIGNUP where Id="+Id;
				rs=stmt.executeQuery(queryforoneuser);
				while(rs.next())
				{
					Employees.add(new Signup(rs.getString("Id"),rs.getString("firstname"),
							rs.getString("lastname"),rs.getString("pswd")
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
	
	//DeleteApi for Signup
	@RequestMapping(method=RequestMethod.DELETE, value="/Signup/{id}")
	public void deleteCredentials(@PathVariable String id) {
		
		Connection con;
		try {
			String dbURL = "jdbc:sqlserver://DESKTOP-8GLKVBG;database=CorporateLedger";
			String userdata = "sa";
			con = DriverManager.getConnection(dbURL, userdata, "godisgreat84");
			if(con != null) {
				Statement stmt = con.createStatement();
				String query = "delete from SIGNUP where Id ="+ id;
				stmt.execute(query);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//CreateApi for Signup
	@RequestMapping(method=RequestMethod.POST, value="/Signup")
	public void createcredentials(@RequestBody Signup user, @PathVariable String Id) {
		Connection con;
		try {
			String dbURL = "jdbc:sqlserver://DESKTOP-8GLKVBG;database=LoginSystem";
			String userdata = "sa";
			con = DriverManager.getConnection(dbURL, userdata, "godisgreat84");
			if(con != null) {
				Statement stmt = con.createStatement();
				String query = "insert into SIGNUP values('"+user.getId()+"','"+user.getFirstname()+"','"+user.getLastname()+"',password='"+user.getPswd()+"');";
				stmt.execute(query);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	//UpdateApi for Signup
	@RequestMapping(method=RequestMethod.PUT, value="/Signup/{Id}")
	public void updatecredentials(@RequestBody Signup user, @PathVariable String Id) {
		
		Connection con;
		try {
			String dbURL = "jdbc:sqlserver://DESKTOP-8GLKVBG;database=LoginSystem";
			String userdata = "sa";
			con = DriverManager.getConnection(dbURL, userdata, "godisgreat84");
			if(con != null) {
				Statement stmt = con.createStatement();
				String query = "update Signup set firstname = '"+user.getFirstname()+"',password='"+user.getPswd()+"' where Id = "+Id;
				stmt.execute(query);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	
	

}
