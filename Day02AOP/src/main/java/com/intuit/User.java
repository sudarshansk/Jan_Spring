package com.intuit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class User {
	public static void main(String[] args) {
		ApplicationContext context = 
				new FileSystemXmlApplicationContext("classpath:beans.xml");
		Employee employee = context.getBean("employee",Employee.class);
	
//		System.out.println(employee.getClass().getName());
//		System.out.println(employee.getClass().getSuperclass().getName());
		
		employee.setName("Sam");
		employee.work();
		employee.browse("TOI");
		employee.browse("cricinfo");
		
	}
}
