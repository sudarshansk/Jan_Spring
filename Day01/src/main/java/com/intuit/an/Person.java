package com.intuit.an;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Person {
	
	@Resource(name="hobbies")
	private List<String> hobbies;
	
	//<property name="lunch" ref="lunch"/>
	@Autowired
	private Lunch lunch;
	
	@Value("Sam")
	private String name;
	
	public List<String> getHobbies() {
		return hobbies;
	}

	public Person() {
		System.out.println("Person created");
	}
}
