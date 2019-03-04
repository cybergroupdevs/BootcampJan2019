package com.deepakpahuja;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.deepakpahuja"})
public class EmployeeRegistrationSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeRegistrationSystemApplication.class, args);
	}

}

