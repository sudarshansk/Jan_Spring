package com.workingside;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages= {"com.workingside.springsecurity","com.workingside.springsecurity.configuration"})
public class MvcAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MvcAppApplication.class, args);
	}
}
