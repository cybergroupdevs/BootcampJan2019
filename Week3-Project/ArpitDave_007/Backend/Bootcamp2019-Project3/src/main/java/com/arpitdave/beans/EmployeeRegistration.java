package com.arpitdave.beans;
import java.util.ArrayList;
import java.util.List;
public class EmployeeRegistration {
    private List<Employee> EmployeeRecords;
    private static EmployeeRegistration stdregd = null;
    private EmployeeRegistration(){
    EmployeeRecords = new ArrayList<Employee>();
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
    EmployeeRecords.add(std);
    }
public String upDateEmployee(Employee std) {
for(int i=0; i<EmployeeRecords.size(); i++)
        {
            Employee stdn = EmployeeRecords.get(i);
            if(stdn.getEmployeeID().equals(std.getEmployeeID())) {
              EmployeeRecords.set(i, std);//update the new record
              return "Update successful";
            }
        }
return "Update un-successful";
}
public String deleteEmployee(String EmployeeID) {
for(int i=0; i<EmployeeRecords.size(); i++)
        {
            Employee stdn = EmployeeRecords.get(i);
            if(stdn.getEmployeeID().equals(EmployeeID)){
              EmployeeRecords.remove(i);//update the new record
              return "Delete successful";
            }
        }
return "Delete un-successful";
}
    public List<Employee> getEmployeeRecords() {
    return EmployeeRecords;
    }
}