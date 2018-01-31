package com.intuit;

import org.springframework.stereotype.Component;

@Component
public  class Employee {
	private String name;
	public void setName(String name){
		this.name = name;
	}
	
	public void browse(String site) {
		System.out.println(name + " is browsing " + site);
	}
	
	public  void work(){
		System.out.println(name + " is on Facebook");
	}
}