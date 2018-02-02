package com.intuit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intuit.domain.Account;
import com.intuit.domain.Statement;
import com.intuit.repository.AccountRepository;
import com.intuit.repository.StatementRepository;

@Service
public class AccountService {
	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private StatementRepository statementRepository;

	@Transactional
	public void withdraw(int accountNumber,int amount) {
		Account account = accountRepository.findOne(accountNumber);
		if(account != null) {
			account.setBalance(account.getBalance() - amount);
			accountRepository.save(account);
			Statement statement = new Statement();
			statement.setAccountNumber(accountNumber);
			statement.setAmount(amount);
			statement.setType("Withdraw");
			statementRepository.save(statement);
		}
	}
	
	@Transactional
	public void deposit(int accountNumber,int amount) {
		Account account = accountRepository.findOne(accountNumber);
		if(account != null) {
			account.setBalance(account.getBalance() + amount);
			accountRepository.save(account);
			Statement statement = new Statement();
			statement.setAccountNumber(accountNumber);
			statement.setAmount(amount);
			statement.setType("Deposit");
			statementRepository.save(statement);
		}
	}
}
