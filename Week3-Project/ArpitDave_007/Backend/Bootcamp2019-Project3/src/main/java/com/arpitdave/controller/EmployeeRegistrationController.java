package com.arpitdave.controller;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.arpitdave.beans.*;
@Controller
public class EmployeeRegistrationController {
  @RequestMapping(method = RequestMethod.POST, value="/register/employee")
  @ResponseBody
  public EmployeeRegistrationReply registerStudent(@RequestBody Employee employee) {
  System.out.println("In registerEmployee");
        EmployeeRegistrationReply stdregreply = new EmployeeRegistrationReply();           
        EmployeeRegistration.getInstance().add(employee);
        //We are setting the below value just to reply a message back to the caller
        stdregreply.setEmployeeID(employee.getEmployeeID());
        stdregreply.setName(employee.getName());
        stdregreply.setPhone(employee.getPhone());
        stdregreply.setDob(employee.getDob());
        stdregreply.setEmail(employee.getEmail());
        stdregreply.setDesignation(employee.getDesignation());
        stdregreply.setPassword(employee.getPassword());
        stdregreply.setRegistrationStatus("Successful");
        return stdregreply;
}
}