package com.intuit;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.dao.DataAccessException;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new FileSystemXmlApplicationContext("classpath:beans.xml");
		PersonsDao personsDao = context.getBean("personsDao",PersonsDao.class);
		try {
			personsDao.deletePerson(101);
		}
		catch(DataAccessException dex) {
			Throwable ex = dex.getCause();
			System.out.println("Error: " + ex.getMessage());
		}
		
		
		
		List<String> names = personsDao.getPersons();
		System.out.println(names);
		List<Person> persons = personsDao.getAllPersons();
		persons.forEach(person -> System.out.println(person.getName() + " " + person.getAge()));
		
		
		//personsDao.insertPerson("Ram", 23);
		//System.out.println("Done");
		//Object obj = personsDao.getPersonNames();
		//System.out.println(obj);
	}

}
