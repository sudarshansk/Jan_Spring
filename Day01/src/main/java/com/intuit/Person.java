package com.intuit;

public class Person {
	private Car car;
	public Person(Car car) {
		this.car = car;
	}
	public Person() {
		System.out.println("Person Created");
	}
}
