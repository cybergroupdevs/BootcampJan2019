package week3;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRegistration {
	
		public List<EmployeeDetails> EmployeeRecords;
		private static EmployeeRegistration EmpReg=null;
		public EmployeeRegistration() {
			EmployeeRecords= new ArrayList<EmployeeDetails>();
		}
		public static EmployeeRegistration getInstance() {
			if(EmpReg==null) {
				EmpReg = new EmployeeRegistration();
	            return EmpReg;
				
			}
			return EmpReg;
			
		}
		
		public void add(EmployeeDetails Emp) {
			EmployeeRecords.add(Emp);
		}
		
		public String UpdateEmployee(EmployeeDetails Emp) {
			for(int i=0;i<EmployeeRecords.size();i++)
			{
				EmployeeDetails Emp1 = EmployeeRecords.get(i);
	            if(Emp1.getEmployeeId().equals(Emp.getEmployeeId())) {
	              EmployeeRecords.set(i, Emp);//update the new record
	              return "Update successful";
			}
		}

		return "Update Unsuccessful";
		}
		
		
		public String DeleteEmployee(String EmployeeId) {
			for(int i=0; i<EmployeeRecords.size(); i++)
			        {
			            EmployeeDetails Emp = EmployeeRecords.get(i);
			            if(Emp.getEmployeeId().equals(EmployeeId)){
			              EmployeeRecords.remove(i);
			              return "Delete successful";
			            }
			        }
			
			return "Delete un-successful";
		}
		
		public List<EmployeeDetails> getEmployeeRecords() {
			Connection conn=null;
			try {
				String dbURL="jdbc:sqlserver://DESKTOP-95D75UP;databaseName=HRMS";
						String user="sa";
				conn=DriverManager.getConnection(dbURL,user,"Abhishek");
				if(conn!=null)
				{
					Statement stmt=conn.createStatement();
					
					
					
					String query1="select * from EmployeeRegistration ";
							
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
			 
		
		    return EmployeeRecords;
		    }
	}
		

