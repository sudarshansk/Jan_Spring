package com.intuit.lab02.dao;

public interface StatementDao {
	void addStatement(int accountNumber,String type,int amount);
}
