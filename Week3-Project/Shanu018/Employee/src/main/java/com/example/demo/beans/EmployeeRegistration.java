package com.example.demo.beans;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRegistration {
	private List<Employee> employeeRecords;
    private static EmployeeRegistration stdregd = null;
    private EmployeeRegistration(){
    employeeRecords = new ArrayList<Employee>();
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
    public void add(Employee std) {
    employeeRecords.add(std);
    }
public String upDateEmployee(Employee std) {
for(int i=0; i<employeeRecords.size(); i++)
        {
            Employee stdn = employeeRecords.get(i);
            if(stdn.getEid().equals(std.getEid())) {
              employeeRecords.set(i, std);//update the new record
              return "Update successful";
            }
        }
return "Update un-successful";
}
public String deleteEmployee(String Eid) {
for(int i=0; i<employeeRecords.size(); i++)
        {
            Employee stdn = employeeRecords.get(i);
            if(stdn.getEid().equals(Eid)){
              employeeRecords.remove(i);//update the new record
              return "Delete successful";
            }
        }
return "Delete un-successful";
}
    public List<Employee> getEmployeeRecords() {
    return employeeRecords;
    }
}

