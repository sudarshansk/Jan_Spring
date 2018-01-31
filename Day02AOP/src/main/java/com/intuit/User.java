package com.intuit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class User {
	public static void main(String[] args) {
		ApplicationContext context = 
				new FileSystemXmlApplicationContext("classpath:beans.xml");
		Employee employee = context.getBean("employee",Employee.class);
		employee.setName("Sam");
		employee.work();
	}
}
