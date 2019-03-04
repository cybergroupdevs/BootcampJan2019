package com.arpitdave.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.arpitdave.beans.Employee;
import com.arpitdave.beans.EmployeeRegistration;
@Controller
public class EmployeeUpdateController {
@RequestMapping(method = RequestMethod.PUT, value="/update/employee")
@ResponseBody
public String updateStudentRecord(@RequestBody Employee stdn) {
System.out.println("In updateStudentRecord");   
    return EmployeeRegistration.getInstance().upDateEmployee(stdn);
}
}