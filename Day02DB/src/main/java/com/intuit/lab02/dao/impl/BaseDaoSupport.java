package com.intuit.lab02.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public abstract class BaseDaoSupport{
	@Autowired
	protected JdbcTemplate jdbcTemplate;
}