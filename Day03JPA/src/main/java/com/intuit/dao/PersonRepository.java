package com.intuit.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.intuit.domain.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer>{
		//id,name,age
		
		//@Query("select * from persons where age > ?")
		@Query("select p from Person p where p.age > :ageParam")
		List<Person> findAllPersonsWithAgeGreaterThan(int ageParam);
	
		Person findOneById(int id);
		List<Person> findByName(String name);
		List<Person> findByNameAndAge(String name,int age);
		List<Person> findByAge(int age);
		List<Person> findByIdAndAge(int id,int age);
		
		List<Person> findByAgeBetween(int min,int max);
}













