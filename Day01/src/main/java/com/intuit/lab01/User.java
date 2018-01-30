package com.intuit.lab01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class User {

	public static void main(String[] args) {
		ApplicationContext context = new FileSystemXmlApplicationContext("classpath:lab01.xml");
		Conference conf = context.getBean(Conference.class);
		System.out.println("60 minutes: " + conf.get60MinutesTopicsCount());
		System.out.println("50 minutes: " + conf.get50MinutesTopicsCount());
		System.out.println("45 minutes: " + conf.get45MinutesTopicsCount());
	}

}
