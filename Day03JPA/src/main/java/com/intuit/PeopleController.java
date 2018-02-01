package com.intuit;

import java.util.List;

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
	
	@GetMapping("/findbyid/{id}")
	public Person getPersonById(@PathVariable int id){
		return personRepository.findOneById(id);
	}
	
	@GetMapping("/allpersonsbetween/{min}/{max}")
	public List<Person> getPersonsBetween(@PathVariable int min,@PathVariable int max){
		return personRepository.findByAgeBetween(min, max);
	}
	@GetMapping("/allpersonsbyage/{age}")
	public List<Person> getPersonsByAge(@PathVariable int age){
		return personRepository.findByAge(age);
	}
	
	@GetMapping("/allpersons/{name}")
	public List<Person> getPersonsByName(@PathVariable String name){
		return personRepository.findByName(name);
	}
	
	@GetMapping("/loadall")
	public List<Person> getAllPersons(){
		List<Person> persons = personRepository.findAll();
		return persons;
	}
	
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
