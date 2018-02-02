package com.intuit.an;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ApplicationContext context = 
				new FileSystemXmlApplicationContext("classpath:an.xml");
		Person person = context.getBean("person",Person.class);
		System.out.println(person.getHobbies());
		
		Person person2 = context.getBean("person",Person.class);
		System.out.println(person2);
		
		Lunch lunch = context.getBean("lunch",Lunch.class);
		System.out.println(lunch);
	}
}
