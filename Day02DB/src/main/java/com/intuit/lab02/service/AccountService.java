package com.intuit.lab02.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.intuit.lab02.dao.AccountDao;
import com.intuit.lab02.dao.StatementDao;

@Service
public class AccountService {
	
	@Autowired
	@Qualifier("accountDaoImpl")
	private AccountDao accountDao;
	
	@Autowired
	private StatementDao statementDao;
	
	public void deposit(int accountNumber,String type, int amount) {
		accountDao.deposit(accountNumber, amount);
		statementDao.addStatement(accountNumber, type, amount);
	}
	
	public void withdraw(int accountNumber,String type, int amount)
	{
		accountDao.withdraw(accountNumber, amount);
		statementDao.addStatement(accountNumber, type, amount);
	}
}
