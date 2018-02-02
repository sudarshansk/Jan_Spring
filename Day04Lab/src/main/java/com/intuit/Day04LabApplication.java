package com.intuit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages= {"com.intuit","com.intuit.web"})
public class Day04LabApplication {

	public static void main(String[] args) {
		SpringApplication.run(Day04LabApplication.class, args);
	}
}
