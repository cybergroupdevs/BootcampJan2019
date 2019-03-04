package firstpackage;

import java.util.ArrayList;
import java.util.List;

public class CreateEmployee {
    private List<Employee> studentRecords;
    private static StudentRegistration stdregd = null;
    private StudentRegistration(){
    studentRecords = new ArrayList<Employee>();
    }
    public static StudentRegistration getInstance() {
        if(stdregd == null) {
              stdregd = new StudentRegistration();
              return stdregd;
            }
            else {
                return stdregd;
            }
    }
    public void add(Employee std) {
    studentRecords.add(std);
    }
public String upDateStudent(Employee std) {
for(int i=0; i<studentRecords.size(); i++)
        {
	Employee stdn = studentRecords.get(i);
            if(stdn.getRegistrationNumber().equals(std.getRegistrationNumber())) {
              studentRecords.set(i, std);
              return "Update successful";
            }
        }
return "Update un-successful";
}
public String deleteStudent(String registrationNumber) {
for(int i=0; i<studentRecords.size(); i++)
        {
	Employee stdn = studentRecords.get(i);
            if(stdn.getRegistrationNumber().equals(registrationNumber)){
              studentRecords.remove(i);//update the new record
              return "Delete successful";
            }
        }
return "Delete un-successful";
}
    public List<Employee> getStudentRecords() {
    return studentRecords;
    }
	public static StudentRegistration getStdregd() {
		return stdregd;
	}
	public static void setStdregd(StudentRegistration stdregd) {
		StudentRegistration.stdregd = stdregd;
	}
	public void setStudentRecords(List<Employee> studentRecords) {
		this.studentRecords = studentRecords;
	}
}

