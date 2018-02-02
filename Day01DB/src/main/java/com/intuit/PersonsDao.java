package com.intuit;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
//@Lazy
public class PersonsDao {
	public PersonsDao() {
		System.out.println("Created");
	}
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void deletePerson(int id) {
		jdbcTemplate.update("delet from persons where id=?",id);
	}
	
	public List<Person> getAllPersons(){
		List<Person> persons = jdbcTemplate.query("select * from persons", 
				new PersonRowMapper());
		
//		List<Person> persons = jdbcTemplate.query("select * from persons", 
//				new RowMapper<Person>() {
//			public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
//				Person person = new Person();
//				person.setId(rs.getInt("id"));
//				person.setName(rs.getString("name"));
//				person.setAge(rs.getInt("age"));
//				return person;
//			}
//			
//		});
		return persons;
	}
	
	public List<String> getPersons(){
		List<String> names = jdbcTemplate.queryForList("select name from persons",
				String.class);
		return names;
	}
	
	
	public void delete(int id) {
		jdbcTemplate.update("delete from persons where id=?",id);
	}
	
	public Object getPersonNames(){
		return jdbcTemplate.queryForList("select name from persons");
	}
	
	public void insertPerson(String name,int age) {
		jdbcTemplate.update("insert into persons(name,age) values(?,?)",name,age);
	}
}
