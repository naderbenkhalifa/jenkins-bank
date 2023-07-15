package com.benkhalifa.ICINBank.service;

import java.util.List;

import com.benkhalifa.ICINBank.model.Transaction;

public interface TransactionService {
	
	 public Transaction createTransaction(Transaction transaction); 
	
	 public void transferMoney(Transaction transaction);
	    
	 public int retreiveAccountNumber(Long id);

	 public List<Transaction> retrieveTransactionsForAccount(int accountNumber);
	 
	 

}
