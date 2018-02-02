package com.intuit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = 
				new FileSystemXmlApplicationContext("classpath:beans.xml");
		//Door door = DoorFactory.getDoorWithSoundAlarm();
		Door door = context.getBean("doorBean2",Door.class);
		door.open();
		door.close();
	}
}
