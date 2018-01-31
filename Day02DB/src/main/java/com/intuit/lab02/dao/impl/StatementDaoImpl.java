package com.intuit.lab02.dao.impl;

import org.springframework.stereotype.Repository;

import com.intuit.lab02.dao.StatementDao;

@Repository
public class StatementDaoImpl extends BaseDaoSupport implements StatementDao
{
	public void addStatement(int accountNumber,String type,int amount)
	{
		String sql = "insert into statements(account_number,type,amount) values(?,?,?)";
		jdbcTemplate.update(sql,accountNumber,type,amount);
	}
}
