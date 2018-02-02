package com.intuit.lab02.dao.impl;

import org.springframework.stereotype.Repository;

import com.intuit.lab02.dao.AccountDao;

@Repository
public class AccountDaoImpl extends BaseDaoSupport implements AccountDao
{
	public void deposit(int accountNumber,int amount)
	{
		String sql = "update accounts set balance=balance+? where account_number=?";
		jdbcTemplate.update(sql,amount,accountNumber);
	}
	public void withdraw(int accountNumber,int amount)
	{
		String sql = "update accounts set balance=balance-? where account_number=?";
		jdbcTemplate.update(sql,amount,accountNumber);
	}
}
