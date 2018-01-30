package com.intuit;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class PersonsDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
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
