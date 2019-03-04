package com.arpitdave.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;
import com.arpitdave.beans.EmployeeRegistration;
@Controller
public class EmployeeDeleteController {
@RequestMapping(method = RequestMethod.DELETE, value="/delete/Employee/{EmployeeID}")
@ResponseBody
public String deleteEmployeeRecord(@PathVariable("EmployeeID") String regdNum) {
System.out.println("In deleteEmployeeRecord");   
    return EmployeeRegistration.getInstance().deleteEmployee(regdNum);
}
}