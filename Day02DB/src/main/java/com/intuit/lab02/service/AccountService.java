package com.intuit.lab02.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
	@Transactional(propagation=Propagation.REQUIRED)
	public void withdraw(int accountNumber,String type, int amount)
	{
		accountDao.withdraw(accountNumber, amount);
		statementDao.addStatement(accountNumber, type, amount);
	}
}
