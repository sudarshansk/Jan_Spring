package com.intuit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.intuit.dao.PersonRepository;
import com.intuit.domain.Person;

@RestController
public class PeopleController {

	@Autowired
	private PersonRepository personRepository;
	
	@GetMapping("/delete/{id}")
	public String deletePerson(@PathVariable int id) {
		personRepository.delete(id);
		return "Done";
	}
	
	@GetMapping("/create/{name}/{age}")
	public String createPerson(@PathVariable String name,@PathVariable int age) {
		Person person = new Person();
		person.setAge(age);
		person.setName(name);
		personRepository.save(person);
		return "Done";
	}
	
}
