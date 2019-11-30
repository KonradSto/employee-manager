package com.konradsto.employeedirectory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.konradsto.employeedirectory"})
public class EmployeeDirectoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeDirectoryApplication.class, args);
	}

}
