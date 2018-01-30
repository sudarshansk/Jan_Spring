package com.intuit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new FileSystemXmlApplicationContext("classpath:beans.xml");
		PersonsDao personsDao = context.getBean("personsDao",PersonsDao.class);
		//personsDao.insertPerson("Ram", 23);
		//System.out.println("Done");
		Object obj = personsDao.getPersonNames();
		System.out.println(obj);
	}

}
