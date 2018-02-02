package com.intuit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class ConceptsMain {

	public static void main(String[] args) {
		ApplicationContext context = 
				new FileSystemXmlApplicationContext("classpath:concepts.xml");
		Book book = context.getBean("book1",Book.class);
		System.out.println(book.getPublishers());
		System.out.println(book.getInterestedPublishers());
//		System.out.println("DONE");
//		Car car = context.getBean("carBean",Car.class);
//		System.out.println(car);
//		Car car2 = context.getBean("carBean",Car.class);
//		System.out.println(car2);
	}

}
