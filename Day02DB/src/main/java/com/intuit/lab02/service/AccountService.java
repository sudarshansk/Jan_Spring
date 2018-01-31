package com.intuit.lab02.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import com.intuit.lab02.dao.AccountDao;
import com.intuit.lab02.dao.StatementDao;

@Service
public class AccountService {
	
	@Autowired
	@Qualifier("accountDaoImpl")
	private AccountDao accountDao;
	
	@Autowired
	private StatementDao statementDao;
	
	@Autowired
	private TransactionTemplate transactionTemplate;
	
	
	public void transferFund(int from,int to,int amount) {
		transactionTemplate.execute(new TransactionCallback<Boolean>() {
			public Boolean doInTransaction(TransactionStatus status) {
				try {
					accountDao.withdraw(from, amount);
					statementDao.addStatement(from, "Withdraw through transfer", amount);
					accountDao.deposit(to, amount);
					statementDao.addStatement(to, "Deposit through transfer", amount);
				}
				catch(Exception ex) {
					status.setRollbackOnly();
				}
				return null;
			}
		});
		
	}
	
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void deposit(int accountNumber,String type, int amount) throws Exception{
		accountDao.deposit(accountNumber, amount);
		
		int i = 4;
		if(i % 2 == 0) {
			throw new Exception("i cannot be even number. WTH");
		}
		statementDao.addStatement(accountNumber, type, amount);
	}
	@Transactional(propagation=Propagation.REQUIRED)
	public void withdraw(int accountNumber,String type, int amount)
	{
		accountDao.withdraw(accountNumber, amount);
		statementDao.addStatement(accountNumber, type, amount);
	}
}
