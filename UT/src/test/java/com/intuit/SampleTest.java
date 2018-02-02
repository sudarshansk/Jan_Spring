package com.intuit;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:test-beans.xml"})
public class SampleTest {

	@Autowired
	private Person person;
	@Autowired
	private ApplicationContext applicationContext;
	
	@Test
	public void testIfApplicationContextIsNotNull() {
		assertNotNull(applicationContext);
	}
	@Test
	public void testPersonNameIsSam() {
		assertEquals("Ram", person.getName());
	}
	@Test
	public void testPersonIsNotNull() {
		assertNotNull(person);
	}

}
